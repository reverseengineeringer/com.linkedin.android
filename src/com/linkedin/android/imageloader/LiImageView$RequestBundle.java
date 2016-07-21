package com.linkedin.android.imageloader;

import android.content.Context;
import android.net.Uri;
import com.linkedin.android.imageloader.interfaces.ImageLoader;
import com.linkedin.android.imageloader.interfaces.ImageTransformer;
import com.linkedin.android.imageloader.interfaces.PerfEventListener;
import java.io.File;

final class LiImageView$RequestBundle
{
  public final Uri mContentUri;
  public final int mDrawableRes;
  public final File mFile;
  public final ImageTransformer mImageTransformer;
  public final LiImageView.ImageViewLoadListener mListener;
  public final ImageLoader mLoader;
  public final PerfEventListener mPerfEventListener;
  public final String mRequestUrl;
  
  public LiImageView$RequestBundle(Context paramContext, int paramInt, ImageLoader paramImageLoader, LiImageView.ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
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
  
  public LiImageView$RequestBundle(Uri paramUri, ImageLoader paramImageLoader, LiImageView.ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
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
  
  public LiImageView$RequestBundle(File paramFile, ImageLoader paramImageLoader, LiImageView.ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
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
  
  public LiImageView$RequestBundle(String paramString, ImageLoader paramImageLoader, LiImageView.ImageViewLoadListener paramImageViewLoadListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener)
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

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageView.RequestBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */