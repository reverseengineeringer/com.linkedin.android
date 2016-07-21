package com.linkedin.android.imageloader;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ImageLoader;
import com.linkedin.android.imageloader.interfaces.ImageTransformer;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageloader.interfaces.PerfEventListener;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;
import com.makeramen.roundedimageview.RoundedImageView;
import java.io.File;

public class LiImageView
  extends RoundedImageView
{
  private static final String TAG = LiImageView.class.getSimpleName();
  private int mCrossFadeDuration = 0;
  private Drawable mDefaultDrawable;
  private Rect mDestRect = new Rect(0, 0, 0, 0);
  private Drawable mErrorDrawable;
  private boolean mIsAttachedToWindow = false;
  private volatile ManagedBitmap mManagedBitmap;
  private RequestBundle mRequestBundle;
  private boolean mShouldLoopGif = true;
  private boolean mShouldPauseGif = false;
  private Rect mSrcRect = new Rect(0, 0, 0, 0);
  
  public LiImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LiImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LiImageView, paramInt, 0);
    if (localTypedArray != null)
    {
      mDefaultDrawable = localTypedArray.getDrawable(R.styleable.LiImageView_placeholderImage);
      mErrorDrawable = localTypedArray.getDrawable(R.styleable.LiImageView_errorImage);
      localTypedArray.recycle();
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedImageView, paramInt, 0);
    if (paramContext != null)
    {
      if (paramContext.getColorStateList(R.styleable.RoundedImageView_riv_border_color) == null) {
        setBorderColor(ColorStateList.valueOf(0));
      }
      paramContext.recycle();
    }
  }
  
  private void cancelExistingFetchRequest()
  {
    mRequestBundle = null;
  }
  
  private void loadDefaultImage()
  {
    try
    {
      super.setImageDrawable(mDefaultDrawable);
      return;
    }
    finally
    {
      releaseManagedBitmap();
    }
  }
  
  private void loadErrorImage()
  {
    if (mErrorDrawable == null)
    {
      loadDefaultImage();
      return;
    }
    try
    {
      super.setImageDrawable(mErrorDrawable);
      return;
    }
    finally
    {
      releaseManagedBitmap();
    }
  }
  
  private ImageListener newImageListener(final ImageViewLoadListener paramImageViewLoadListener)
  {
    new ImageListener()
    {
      public final Pair<Integer, Integer> getTargetDimensions()
      {
        if ((getMeasuredWidth() <= 0) || (getMeasuredHeight() <= 0)) {
          return null;
        }
        return new Pair(Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()));
      }
      
      public final void onErrorResponse(String paramAnonymousString, Exception paramAnonymousException)
      {
        if ((mIsAttachedToWindow) && (mRequestBundle != null) && (TextUtils.equals(mRequestBundle.mRequestUrl, paramAnonymousString)))
        {
          Log.e(LiImageView.TAG, "Failed to load image for: " + paramAnonymousString, paramAnonymousException);
          LiImageView.this.loadErrorImage();
          if (paramImageViewLoadListener != null) {
            paramImageViewLoadListener.onImageLoadFailure(paramAnonymousString, paramAnonymousException);
          }
        }
      }
      
      public final void onResponse(String paramAnonymousString, ManagedBitmap paramAnonymousManagedBitmap, boolean paramAnonymousBoolean)
      {
        if ((mIsAttachedToWindow) && (mRequestBundle != null) && (TextUtils.equals(mRequestBundle.mRequestUrl, paramAnonymousString)))
        {
          FeatureLog.d(LiImageView.TAG, "Loaded image successfully for: " + paramAnonymousString, "LI Image Loader");
          LiImageView.this.setManagedBitmap(paramAnonymousManagedBitmap, paramAnonymousBoolean);
          if (paramImageViewLoadListener != null) {
            paramImageViewLoadListener.onImageLoadSuccess(paramAnonymousManagedBitmap, paramAnonymousString, paramAnonymousBoolean);
          }
        }
      }
    };
  }
  
  private void releaseManagedBitmap()
  {
    if (mManagedBitmap != null)
    {
      mManagedBitmap.release();
      mManagedBitmap = null;
    }
  }
  
  private void setManagedBitmap(ManagedBitmap paramManagedBitmap, boolean paramBoolean)
  {
    if ((paramManagedBitmap != null) && (paramManagedBitmap.equals(mManagedBitmap))) {
      return;
    }
    if (paramManagedBitmap == null)
    {
      setImageBitmap(null);
      return;
    }
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        if ((mCrossFadeDuration <= 0) || (paramManagedBitmap.isGif()) || (mDefaultDrawable == null)) {
          continue;
        }
        TransitionDrawable localTransitionDrawable = new TransitionDrawable(new Drawable[] { mDefaultDrawable, new BitmapDrawable(getResources(), paramManagedBitmap.getBitmap()) });
        localTransitionDrawable.setCrossFadeEnabled(true);
        super.setImageDrawable(localTransitionDrawable);
        localTransitionDrawable.startTransition(mCrossFadeDuration);
      }
      catch (Exception localException)
      {
        loadErrorImage();
        releaseManagedBitmap();
        continue;
      }
      finally
      {
        releaseManagedBitmap();
      }
      if (paramManagedBitmap.isGif()) {
        ((LiGifManagedBitmap)paramManagedBitmap).startAnimation();
      }
      mManagedBitmap = paramManagedBitmap.retain();
      return;
      super.setImageBitmap(paramManagedBitmap.getBitmap());
    }
  }
  
  public String getImageRequestUrl()
  {
    if (mRequestBundle == null) {
      return null;
    }
    return mRequestBundle.mRequestUrl;
  }
  
  public void loadImage(int paramInt, ImageLoader paramImageLoader, ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
  {
    cancelExistingFetchRequest();
    loadDefaultImage();
    if (paramInt <= 0)
    {
      if (paramImageViewLoadListener != null) {
        paramImageViewLoadListener.onImageLoadFailure(null, new Exception("Resource is invalid"));
      }
      return;
    }
    mRequestBundle = new RequestBundle(getContext(), paramInt, paramImageLoader, paramImageViewLoadListener, paramImageTransformer, paramPerfEventListener);
    paramImageLoader.loadImageFromResource(paramInt, newImageListener(paramImageViewLoadListener), paramImageTransformer, paramPerfEventListener);
  }
  
  public void loadImage(Uri paramUri, ImageLoader paramImageLoader, ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
  {
    cancelExistingFetchRequest();
    loadDefaultImage();
    if (paramUri == null)
    {
      if (paramImageViewLoadListener != null) {
        paramImageViewLoadListener.onImageLoadFailure(null, new Exception("Content URI is null"));
      }
      return;
    }
    mRequestBundle = new RequestBundle(paramUri, paramImageLoader, paramImageViewLoadListener, paramImageTransformer, paramPerfEventListener);
    paramImageLoader.loadImageFromContentUri(paramUri, newImageListener(paramImageViewLoadListener), paramImageTransformer, paramPerfEventListener);
  }
  
  public void loadImage(File paramFile, ImageLoader paramImageLoader, ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
  {
    cancelExistingFetchRequest();
    loadDefaultImage();
    if (paramFile == null)
    {
      if (paramImageViewLoadListener != null) {
        paramImageViewLoadListener.onImageLoadFailure(null, new Exception("File is null"));
      }
      return;
    }
    mRequestBundle = new RequestBundle(paramFile, paramImageLoader, paramImageViewLoadListener, paramImageTransformer, paramPerfEventListener);
    paramImageLoader.loadImageFromFile(paramFile, newImageListener(paramImageViewLoadListener), paramImageTransformer, paramPerfEventListener);
  }
  
  public void loadImage(String paramString, ImageLoader paramImageLoader, ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
  {
    cancelExistingFetchRequest();
    loadDefaultImage();
    if (TextUtils.isEmpty(paramString))
    {
      if (paramImageViewLoadListener != null) {
        paramImageViewLoadListener.onImageLoadFailure(null, new Exception("URL is null/empty"));
      }
      return;
    }
    mRequestBundle = new RequestBundle(paramString, paramImageLoader, paramImageViewLoadListener, paramImageTransformer, paramPerfEventListener);
    paramImageLoader.loadImageFromUrl(paramString, newImageListener(paramImageViewLoadListener), paramImageTransformer, paramPerfEventListener);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mIsAttachedToWindow = true;
    if ((getDrawable() == null) && (mDefaultDrawable != null)) {
      loadDefaultImage();
    }
    RequestBundle localRequestBundle = mRequestBundle;
    if (localRequestBundle != null)
    {
      if (mContentUri != null) {
        loadImage(mContentUri, mLoader, mListener, mImageTransformer, mPerfEventListener);
      }
    }
    else {
      return;
    }
    if (mFile != null)
    {
      loadImage(mFile, mLoader, mListener, mImageTransformer, mPerfEventListener);
      return;
    }
    if (mDrawableRes != 0)
    {
      loadImage(mDrawableRes, mLoader, mListener, mImageTransformer, mPerfEventListener);
      return;
    }
    loadImage(mRequestUrl, mLoader, mListener, mImageTransformer, mPerfEventListener);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    mIsAttachedToWindow = false;
    if (mManagedBitmap != null) {
      if (mManagedBitmap.isGif()) {
        ((LiGifManagedBitmap)mManagedBitmap).pauseAnimation();
      }
    }
    try
    {
      super.setImageDrawable(null);
      return;
    }
    finally
    {
      releaseManagedBitmap();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((mManagedBitmap == null) || (!mManagedBitmap.isGif()))
    {
      super.onDraw(paramCanvas);
      return;
    }
    Bitmap localBitmap = ((LiGifManagedBitmap)mManagedBitmap).getBitmap();
    if (localBitmap != null)
    {
      mSrcRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      mDestRect.set(0, 0, getWidth(), getHeight());
      paramCanvas.drawBitmap(localBitmap, mSrcRect, mDestRect, null);
    }
    invalidate();
  }
  
  public void pauseGIFAnimation()
  {
    mShouldPauseGif = true;
    if ((mManagedBitmap != null) && (mManagedBitmap.isGif())) {
      ((LiGifManagedBitmap)mManagedBitmap).pauseAnimation();
    }
  }
  
  public void restartGIFAnimation()
  {
    if ((mManagedBitmap != null) && (mManagedBitmap.isGif()))
    {
      LiGifManagedBitmap localLiGifManagedBitmap = (LiGifManagedBitmap)mManagedBitmap;
      localLiGifManagedBitmap.pauseAnimation();
      mDecoder.framePointer = -1;
      mDecoder.advance();
      localLiGifManagedBitmap.startAnimation();
    }
  }
  
  public void resumeGIFAnimation()
  {
    mShouldPauseGif = false;
    if ((mManagedBitmap != null) && (mManagedBitmap.isGif())) {
      ((LiGifManagedBitmap)mManagedBitmap).startAnimation();
    }
  }
  
  public void setCrossFadeDuration(int paramInt)
  {
    mCrossFadeDuration = paramInt;
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    mDefaultDrawable = paramDrawable;
  }
  
  public void setDefaultDrawableResource(int paramInt)
  {
    mDefaultDrawable = getContext().getResources().getDrawable(paramInt);
  }
  
  public void setErrorDrawable(Drawable paramDrawable)
  {
    mErrorDrawable = paramDrawable;
  }
  
  public void setErrorDrawableResource(int paramInt)
  {
    mErrorDrawable = getContext().getResources().getDrawable(paramInt);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    cancelExistingFetchRequest();
    if (paramBitmap == null)
    {
      loadDefaultImage();
      return;
    }
    try
    {
      super.setImageBitmap(paramBitmap);
      return;
    }
    catch (Exception paramBitmap)
    {
      loadErrorImage();
      return;
    }
    finally
    {
      releaseManagedBitmap();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    cancelExistingFetchRequest();
    if (paramDrawable == null)
    {
      loadDefaultImage();
      return;
    }
    try
    {
      super.setImageDrawable(paramDrawable);
      return;
    }
    catch (Exception paramDrawable)
    {
      loadErrorImage();
      return;
    }
    finally
    {
      releaseManagedBitmap();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    cancelExistingFetchRequest();
    if (paramInt <= 0)
    {
      loadDefaultImage();
      return;
    }
    try
    {
      super.setImageResource(paramInt);
      return;
    }
    catch (Exception localException)
    {
      loadErrorImage();
      return;
    }
    finally
    {
      releaseManagedBitmap();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    cancelExistingFetchRequest();
    if (paramUri == null)
    {
      loadDefaultImage();
      return;
    }
    try
    {
      super.setImageURI(paramUri);
      return;
    }
    catch (Exception paramUri)
    {
      loadErrorImage();
      return;
    }
    finally
    {
      releaseManagedBitmap();
    }
  }
  
  public void setManagedBitmap(ManagedBitmap paramManagedBitmap)
  {
    setManagedBitmap(paramManagedBitmap, false);
  }
  
  public void setShouldLoopGIFAnimation(boolean paramBoolean)
  {
    mShouldLoopGif = paramBoolean;
    if ((mManagedBitmap != null) && (mManagedBitmap.isGif())) {
      mManagedBitmap).mDecoder.shouldLoop = paramBoolean;
    }
  }
  
  public static abstract interface ImageViewLoadListener
  {
    public abstract void onImageLoadFailure(String paramString, Exception paramException);
    
    public abstract void onImageLoadSuccess(ManagedBitmap paramManagedBitmap, String paramString, boolean paramBoolean);
  }
  
  private static final class RequestBundle
  {
    public final Uri mContentUri;
    public final int mDrawableRes;
    public final File mFile;
    public final ImageTransformer mImageTransformer;
    public final LiImageView.ImageViewLoadListener mListener;
    public final ImageLoader mLoader;
    public final PerfEventListener mPerfEventListener;
    public final String mRequestUrl;
    
    public RequestBundle(Context paramContext, int paramInt, ImageLoader paramImageLoader, LiImageView.ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
    {
      mRequestUrl = Utils.getResourceUrl(paramContext, paramInt);
      mContentUri = null;
      mDrawableRes = paramInt;
      mFile = null;
      mLoader = paramImageLoader;
      mListener = paramImageViewLoadListener;
      mImageTransformer = paramImageTransformer;
      mPerfEventListener = paramPerfEventListener;
    }
    
    public RequestBundle(Uri paramUri, ImageLoader paramImageLoader, LiImageView.ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
    {
      mRequestUrl = paramUri.toString();
      mContentUri = paramUri;
      mDrawableRes = 0;
      mFile = null;
      mLoader = paramImageLoader;
      mListener = paramImageViewLoadListener;
      mImageTransformer = paramImageTransformer;
      mPerfEventListener = paramPerfEventListener;
    }
    
    public RequestBundle(File paramFile, ImageLoader paramImageLoader, LiImageView.ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
    {
      mRequestUrl = Utils.getFileUrl(paramFile);
      mContentUri = null;
      mDrawableRes = 0;
      mFile = paramFile;
      mLoader = paramImageLoader;
      mListener = paramImageViewLoadListener;
      mImageTransformer = paramImageTransformer;
      mPerfEventListener = paramPerfEventListener;
    }
    
    public RequestBundle(String paramString, ImageLoader paramImageLoader, LiImageView.ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
    {
      mRequestUrl = paramString;
      mContentUri = null;
      mDrawableRes = 0;
      mFile = null;
      mLoader = paramImageLoader;
      mListener = paramImageViewLoadListener;
      mImageTransformer = paramImageTransformer;
      mPerfEventListener = paramPerfEventListener;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */