package android.support.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public final class VectorDrawableCompat
  extends VectorDrawableCommon
{
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  boolean mAllowCaching = true;
  private Drawable.ConstantState mCachedConstantStateDelegate;
  private ColorFilter mColorFilter;
  private boolean mMutated;
  private PorterDuffColorFilter mTintFilter;
  private final Rect mTmpBounds = new Rect();
  private final float[] mTmpFloats = new float[9];
  private final Matrix mTmpMatrix = new Matrix();
  VectorDrawableCompatState mVectorState;
  
  private VectorDrawableCompat()
  {
    mVectorState = new VectorDrawableCompatState();
  }
  
  private VectorDrawableCompat(VectorDrawableCompatState paramVectorDrawableCompatState)
  {
    mVectorState = paramVectorDrawableCompatState;
    mTintFilter = updateTintFilter$5c32a288(mTint, mTintMode);
  }
  
  public static VectorDrawableCompat create(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = new VectorDrawableCompat();
      mDelegateDrawable = ResourcesCompat.getDrawable(paramResources, paramInt, paramTheme);
      mCachedConstantStateDelegate = new VectorDrawableDelegateState(mDelegateDrawable.getConstantState());
      return (VectorDrawableCompat)localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (XmlPullParserException paramResources)
    {
      AttributeSet localAttributeSet;
      Log.e("VectorDrawableCompat", "parser error", paramResources);
      return null;
      paramResources = createFromXmlInner(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        Log.e("VectorDrawableCompat", "parser error", paramResources);
      }
    }
  }
  
  public static VectorDrawableCompat createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
    localVectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localVectorDrawableCompat;
  }
  
  private void inflateInternal(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    VectorDrawableCompatState localVectorDrawableCompatState = mVectorState;
    VPathRenderer localVPathRenderer = mVPathRenderer;
    int i = 1;
    Stack localStack = new Stack();
    localStack.push(mRootGroup);
    int k = paramXmlPullParser.getEventType();
    if (k != 1)
    {
      Object localObject;
      VGroup localVGroup;
      TypedArray localTypedArray;
      int j;
      if (k == 2)
      {
        localObject = paramXmlPullParser.getName();
        localVGroup = (VGroup)localStack.peek();
        if ("path".equals(localObject))
        {
          localObject = new VFullPath();
          localTypedArray = VectorDrawableCommon.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_VectorDrawablePath);
          ((VFullPath)localObject).updateStateFromTypedArray(localTypedArray, paramXmlPullParser);
          localTypedArray.recycle();
          mChildren.add(localObject);
          if (mPathName != null) {
            mVGTargetsMap.put(mPathName, localObject);
          }
          j = 0;
          mChangingConfigurations |= mChangingConfigurations;
        }
      }
      for (;;)
      {
        k = paramXmlPullParser.next();
        i = j;
        break;
        if ("clip-path".equals(localObject))
        {
          localObject = new VClipPath();
          if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData"))
          {
            localTypedArray = VectorDrawableCommon.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_VectorDrawableClipPath);
            ((VClipPath)localObject).updateStateFromTypedArray(localTypedArray);
            localTypedArray.recycle();
          }
          mChildren.add(localObject);
          if (mPathName != null) {
            mVGTargetsMap.put(mPathName, localObject);
          }
          mChangingConfigurations |= mChangingConfigurations;
          j = i;
        }
        else
        {
          j = i;
          if ("group".equals(localObject))
          {
            localObject = new VGroup();
            localTypedArray = VectorDrawableCommon.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_VectorDrawableGroup);
            mThemeAttrs = null;
            mRotate = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "rotation", 5, mRotate);
            mPivotX = localTypedArray.getFloat(1, mPivotX);
            mPivotY = localTypedArray.getFloat(2, mPivotY);
            mScaleX = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "scaleX", 3, mScaleX);
            mScaleY = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "scaleY", 4, mScaleY);
            mTranslateX = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "translateX", 6, mTranslateX);
            mTranslateY = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "translateY", 7, mTranslateY);
            String str = localTypedArray.getString(0);
            if (str != null) {
              mGroupName = str;
            }
            mLocalMatrix.reset();
            mLocalMatrix.postTranslate(-mPivotX, -mPivotY);
            mLocalMatrix.postScale(mScaleX, mScaleY);
            mLocalMatrix.postRotate(mRotate, 0.0F, 0.0F);
            mLocalMatrix.postTranslate(mTranslateX + mPivotX, mTranslateY + mPivotY);
            localTypedArray.recycle();
            mChildren.add(localObject);
            localStack.push(localObject);
            if (mGroupName != null) {
              mVGTargetsMap.put(mGroupName, localObject);
            }
            mChangingConfigurations |= mChangingConfigurations;
            j = i;
            continue;
            j = i;
            if (k == 3)
            {
              j = i;
              if ("group".equals(paramXmlPullParser.getName()))
              {
                localStack.pop();
                j = i;
              }
            }
          }
        }
      }
    }
    if (i != 0)
    {
      paramResources = new StringBuffer();
      if (paramResources.length() > 0) {
        paramResources.append(" or ");
      }
      paramResources.append("path");
      throw new XmlPullParserException("no " + paramResources + " defined");
    }
  }
  
  private PorterDuffColorFilter updateTintFilter$5c32a288(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  public final boolean canApplyTheme()
  {
    if (mDelegateDrawable != null) {
      DrawableCompat.canApplyTheme(mDelegateDrawable);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (mDelegateDrawable != null) {
      mDelegateDrawable.draw(paramCanvas);
    }
    int i;
    int k;
    int m;
    do
    {
      do
      {
        return;
        copyBounds(mTmpBounds);
      } while ((mTmpBounds.width() <= 0) || (mTmpBounds.height() <= 0));
      if (mColorFilter != null) {
        break;
      }
      localObject = mTintFilter;
      paramCanvas.getMatrix(mTmpMatrix);
      mTmpMatrix.getValues(mTmpFloats);
      float f1 = Math.abs(mTmpFloats[0]);
      float f2 = Math.abs(mTmpFloats[4]);
      float f4 = Math.abs(mTmpFloats[1]);
      float f3 = Math.abs(mTmpFloats[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      j = (int)(mTmpBounds.width() * f1);
      i = (int)(mTmpBounds.height() * f2);
      k = Math.min(2048, j);
      m = Math.min(2048, i);
    } while ((k <= 0) || (m <= 0));
    int j = paramCanvas.save();
    paramCanvas.translate(mTmpBounds.left, mTmpBounds.top);
    mTmpBounds.offsetTo(0, 0);
    VectorDrawableCompatState localVectorDrawableCompatState = mVectorState;
    if (mCachedBitmap != null)
    {
      if ((k != mCachedBitmap.getWidth()) || (m != mCachedBitmap.getHeight())) {
        break label386;
      }
      i = 1;
      label270:
      if (i != 0) {}
    }
    else
    {
      mCachedBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      mCacheDirty = true;
    }
    label314:
    Rect localRect;
    if (!mAllowCaching)
    {
      mVectorState.updateCachedBitmap(k, m);
      localVectorDrawableCompatState = mVectorState;
      localRect = mTmpBounds;
      if (mVPathRenderer.mRootAlpha >= 255) {
        break label544;
      }
      i = 1;
      label343:
      if ((i != 0) || (localObject != null)) {
        break label550;
      }
    }
    for (Object localObject = null;; localObject = mTempPaint)
    {
      paramCanvas.drawBitmap(mCachedBitmap, null, localRect, (Paint)localObject);
      paramCanvas.restoreToCount(j);
      return;
      localObject = mColorFilter;
      break;
      label386:
      i = 0;
      break label270;
      localVectorDrawableCompatState = mVectorState;
      if ((!mCacheDirty) && (mCachedTint == mTint) && (mCachedTintMode == mTintMode) && (mCachedAutoMirrored == mAutoMirrored) && (mCachedRootAlpha == mVPathRenderer.mRootAlpha)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label542;
        }
        mVectorState.updateCachedBitmap(k, m);
        localVectorDrawableCompatState = mVectorState;
        mCachedTint = mTint;
        mCachedTintMode = mTintMode;
        mCachedRootAlpha = mVPathRenderer.mRootAlpha;
        mCachedAutoMirrored = mAutoMirrored;
        mCacheDirty = false;
        break;
      }
      label542:
      break label314;
      label544:
      i = 0;
      break label343;
      label550:
      if (mTempPaint == null)
      {
        mTempPaint = new Paint();
        mTempPaint.setFilterBitmap(true);
      }
      mTempPaint.setAlpha(mVPathRenderer.mRootAlpha);
      mTempPaint.setColorFilter((ColorFilter)localObject);
    }
  }
  
  public final int getAlpha()
  {
    if (mDelegateDrawable != null) {
      return DrawableCompat.getAlpha(mDelegateDrawable);
    }
    return mVectorState.mVPathRenderer.mRootAlpha;
  }
  
  public final int getChangingConfigurations()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | mVectorState.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (mDelegateDrawable != null) {
      return new VectorDrawableDelegateState(mDelegateDrawable.getConstantState());
    }
    mVectorState.mChangingConfigurations = getChangingConfigurations();
    return mVectorState;
  }
  
  public final int getIntrinsicHeight()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.getIntrinsicHeight();
    }
    return (int)mVectorState.mVPathRenderer.mBaseHeight;
  }
  
  public final int getIntrinsicWidth()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.getIntrinsicWidth();
    }
    return (int)mVectorState.mVPathRenderer.mBaseWidth;
  }
  
  public final int getOpacity()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    if (mDelegateDrawable != null)
    {
      mDelegateDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (mDelegateDrawable != null)
    {
      DrawableCompat.inflate(mDelegateDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    VectorDrawableCompatState localVectorDrawableCompatState1 = mVectorState;
    mVPathRenderer = new VPathRenderer();
    TypedArray localTypedArray = obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_VectorDrawableTypeArray);
    VectorDrawableCompatState localVectorDrawableCompatState2 = mVectorState;
    VPathRenderer localVPathRenderer = mVPathRenderer;
    int i = TypedArrayUtils.getNamedInt$7903c789(localTypedArray, paramXmlPullParser, "tintMode", 6);
    PorterDuff.Mode localMode = PorterDuff.Mode.SRC_IN;
    Object localObject = localMode;
    boolean bool;
    switch (i)
    {
    default: 
      localObject = localMode;
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      mTintMode = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        mTint = ((ColorStateList)localObject);
      }
      bool = mAutoMirrored;
      if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "autoMirrored")) {
        break;
      }
    }
    for (;;)
    {
      mAutoMirrored = bool;
      mViewportWidth = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "viewportWidth", 7, mViewportWidth);
      mViewportHeight = TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "viewportHeight", 8, mViewportHeight);
      if (mViewportWidth > 0.0F) {
        break label356;
      }
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
      localObject = PorterDuff.Mode.SRC_OVER;
      break;
      localObject = PorterDuff.Mode.SRC_IN;
      break;
      localObject = PorterDuff.Mode.SRC_ATOP;
      break;
      localObject = PorterDuff.Mode.MULTIPLY;
      break;
      localObject = PorterDuff.Mode.SCREEN;
      break;
      localObject = PorterDuff.Mode.ADD;
      break;
      bool = localTypedArray.getBoolean(5, bool);
    }
    label356:
    if (mViewportHeight <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    mBaseWidth = localTypedArray.getDimension(3, mBaseWidth);
    mBaseHeight = localTypedArray.getDimension(2, mBaseHeight);
    if (mBaseWidth <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (mBaseHeight <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    mRootAlpha = ((int)(TypedArrayUtils.getNamedFloat(localTypedArray, paramXmlPullParser, "alpha", 4, mRootAlpha / 255.0F) * 255.0F));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      mRootName = ((String)localObject);
      mVGTargetsMap.put(localObject, localVPathRenderer);
    }
    localTypedArray.recycle();
    mChangingConfigurations = getChangingConfigurations();
    mCacheDirty = true;
    inflateInternal(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    mTintFilter = updateTintFilter$5c32a288(mTint, mTintMode);
  }
  
  public final void invalidateSelf()
  {
    if (mDelegateDrawable != null)
    {
      mDelegateDrawable.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isStateful()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.isStateful();
    }
    return (super.isStateful()) || ((mVectorState != null) && (mVectorState.mTint != null) && (mVectorState.mTint.isStateful()));
  }
  
  public final Drawable mutate()
  {
    if (mDelegateDrawable != null) {
      mDelegateDrawable.mutate();
    }
    while ((mMutated) || (super.mutate() != this)) {
      return this;
    }
    mVectorState = new VectorDrawableCompatState(mVectorState);
    mMutated = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (mDelegateDrawable != null) {
      mDelegateDrawable.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.setState(paramArrayOfInt);
    }
    paramArrayOfInt = mVectorState;
    if ((mTint != null) && (mTintMode != null))
    {
      mTintFilter = updateTintFilter$5c32a288(mTint, mTintMode);
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (mDelegateDrawable != null)
    {
      mDelegateDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (mDelegateDrawable != null) {
      mDelegateDrawable.setAlpha(paramInt);
    }
    while (mVectorState.mVPathRenderer.mRootAlpha == paramInt) {
      return;
    }
    mVectorState.mVPathRenderer.mRootAlpha = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (mDelegateDrawable != null)
    {
      mDelegateDrawable.setColorFilter(paramColorFilter);
      return;
    }
    mColorFilter = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (mDelegateDrawable != null)
    {
      DrawableCompat.setTint(mDelegateDrawable, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (mDelegateDrawable != null) {
      DrawableCompat.setTintList(mDelegateDrawable, paramColorStateList);
    }
    VectorDrawableCompatState localVectorDrawableCompatState;
    do
    {
      return;
      localVectorDrawableCompatState = mVectorState;
    } while (mTint == paramColorStateList);
    mTint = paramColorStateList;
    mTintFilter = updateTintFilter$5c32a288(paramColorStateList, mTintMode);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (mDelegateDrawable != null) {
      DrawableCompat.setTintMode(mDelegateDrawable, paramMode);
    }
    VectorDrawableCompatState localVectorDrawableCompatState;
    do
    {
      return;
      localVectorDrawableCompatState = mVectorState;
    } while (mTintMode == paramMode);
    mTintMode = paramMode;
    mTintFilter = updateTintFilter$5c32a288(mTint, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (mDelegateDrawable != null)
    {
      mDelegateDrawable.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  private static final class VClipPath
    extends VectorDrawableCompat.VPath
  {
    public VClipPath() {}
    
    public VClipPath(VClipPath paramVClipPath)
    {
      super();
    }
    
    public final boolean isClipPath()
    {
      return true;
    }
    
    final void updateStateFromTypedArray(TypedArray paramTypedArray)
    {
      String str = paramTypedArray.getString(0);
      if (str != null) {
        mPathName = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        mNodes = PathParser.createNodesFromPathData(paramTypedArray);
      }
    }
  }
  
  private static final class VFullPath
    extends VectorDrawableCompat.VPath
  {
    float mFillAlpha = 1.0F;
    int mFillColor = 0;
    int mFillRule;
    float mStrokeAlpha = 1.0F;
    int mStrokeColor = 0;
    Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
    Paint.Join mStrokeLineJoin = Paint.Join.MITER;
    float mStrokeMiterlimit = 4.0F;
    float mStrokeWidth = 0.0F;
    private int[] mThemeAttrs;
    float mTrimPathEnd = 1.0F;
    float mTrimPathOffset = 0.0F;
    float mTrimPathStart = 0.0F;
    
    public VFullPath() {}
    
    public VFullPath(VFullPath paramVFullPath)
    {
      super();
      mThemeAttrs = mThemeAttrs;
      mStrokeColor = mStrokeColor;
      mStrokeWidth = mStrokeWidth;
      mStrokeAlpha = mStrokeAlpha;
      mFillColor = mFillColor;
      mFillRule = mFillRule;
      mFillAlpha = mFillAlpha;
      mTrimPathStart = mTrimPathStart;
      mTrimPathEnd = mTrimPathEnd;
      mTrimPathOffset = mTrimPathOffset;
      mStrokeLineCap = mStrokeLineCap;
      mStrokeLineJoin = mStrokeLineJoin;
      mStrokeMiterlimit = mStrokeMiterlimit;
    }
    
    final void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      mThemeAttrs = null;
      if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        mPathName = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        mNodes = PathParser.createNodesFromPathData((String)localObject);
      }
      mFillColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "fillColor", 1, mFillColor);
      mFillAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, mFillAlpha);
      int i = TypedArrayUtils.getNamedInt$7903c789(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8);
      localObject = mStrokeLineCap;
      switch (i)
      {
      default: 
        mStrokeLineCap = ((Paint.Cap)localObject);
        i = TypedArrayUtils.getNamedInt$7903c789(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9);
        localObject = mStrokeLineJoin;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        mStrokeLineJoin = ((Paint.Join)localObject);
        mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, mStrokeMiterlimit);
        mStrokeColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "strokeColor", 3, mStrokeColor);
        mStrokeAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, mStrokeAlpha);
        mStrokeWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, mStrokeWidth);
        mTrimPathEnd = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, mTrimPathEnd);
        mTrimPathOffset = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, mTrimPathOffset);
        mTrimPathStart = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, mTrimPathStart);
        return;
        localObject = Paint.Cap.BUTT;
        break;
        localObject = Paint.Cap.ROUND;
        break;
        localObject = Paint.Cap.SQUARE;
        break;
        localObject = Paint.Join.MITER;
        continue;
        localObject = Paint.Join.ROUND;
        continue;
        localObject = Paint.Join.BEVEL;
      }
    }
  }
  
  private static final class VGroup
  {
    int mChangingConfigurations;
    final ArrayList<Object> mChildren = new ArrayList();
    String mGroupName = null;
    final Matrix mLocalMatrix = new Matrix();
    float mPivotX = 0.0F;
    float mPivotY = 0.0F;
    float mRotate = 0.0F;
    float mScaleX = 1.0F;
    float mScaleY = 1.0F;
    final Matrix mStackedMatrix = new Matrix();
    int[] mThemeAttrs;
    float mTranslateX = 0.0F;
    float mTranslateY = 0.0F;
    
    public VGroup() {}
    
    public VGroup(VGroup paramVGroup, ArrayMap<String, Object> paramArrayMap)
    {
      mRotate = mRotate;
      mPivotX = mPivotX;
      mPivotY = mPivotY;
      mScaleX = mScaleX;
      mScaleY = mScaleY;
      mTranslateX = mTranslateX;
      mTranslateY = mTranslateY;
      mThemeAttrs = mThemeAttrs;
      mGroupName = mGroupName;
      mChangingConfigurations = mChangingConfigurations;
      if (mGroupName != null) {
        paramArrayMap.put(mGroupName, this);
      }
      mLocalMatrix.set(mLocalMatrix);
      ArrayList localArrayList = mChildren;
      int i = 0;
      while (i < localArrayList.size())
      {
        paramVGroup = localArrayList.get(i);
        if ((paramVGroup instanceof VGroup))
        {
          paramVGroup = (VGroup)paramVGroup;
          mChildren.add(new VGroup(paramVGroup, paramArrayMap));
          i += 1;
        }
        else
        {
          if ((paramVGroup instanceof VectorDrawableCompat.VFullPath)) {}
          for (paramVGroup = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)paramVGroup);; paramVGroup = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)paramVGroup))
          {
            mChildren.add(paramVGroup);
            if (mPathName == null) {
              break;
            }
            paramArrayMap.put(mPathName, paramVGroup);
            break;
            if (!(paramVGroup instanceof VectorDrawableCompat.VClipPath)) {
              break label315;
            }
          }
          label315:
          throw new IllegalStateException("Unknown object in the tree!");
        }
      }
    }
  }
  
  private static class VPath
  {
    int mChangingConfigurations;
    protected PathParser.PathDataNode[] mNodes = null;
    String mPathName;
    
    public VPath() {}
    
    public VPath(VPath paramVPath)
    {
      mPathName = mPathName;
      mChangingConfigurations = mChangingConfigurations;
      mNodes = PathParser.deepCopyNodes(mNodes);
    }
    
    public boolean isClipPath()
    {
      return false;
    }
    
    public final void toPath(Path paramPath)
    {
      paramPath.reset();
      PathParser.PathDataNode[] arrayOfPathDataNode;
      float[] arrayOfFloat1;
      int k;
      int j;
      float[] arrayOfFloat2;
      float f4;
      float f3;
      float f6;
      float f1;
      float f2;
      int m;
      float f7;
      float f8;
      label290:
      label482:
      float f9;
      if (mNodes != null)
      {
        arrayOfPathDataNode = mNodes;
        arrayOfFloat1 = new float[6];
        k = 0;
        j = 109;
        if (k < arrayOfPathDataNode.length)
        {
          int n = type;
          arrayOfFloat2 = params;
          f4 = arrayOfFloat1[0];
          f3 = arrayOfFloat1[1];
          f6 = arrayOfFloat1[2];
          f5 = arrayOfFloat1[3];
          f1 = arrayOfFloat1[4];
          f2 = arrayOfFloat1[5];
          int i;
          switch (n)
          {
          default: 
            i = 2;
            m = 0;
            f7 = f3;
            f3 = f4;
            f4 = f7;
            f7 = f6;
            f8 = f5;
            if (m < arrayOfFloat2.length) {
              switch (n)
              {
              default: 
                f5 = f2;
                f2 = f4;
                f4 = f3;
                f3 = f2;
                f2 = f1;
                f6 = f7;
                f1 = f5;
                f5 = f8;
              }
            }
            break;
          case 90: 
          case 122: 
          case 76: 
          case 77: 
          case 84: 
          case 108: 
          case 109: 
          case 116: 
          case 72: 
          case 86: 
          case 104: 
          case 118: 
          case 67: 
          case 99: 
          case 81: 
          case 83: 
          case 113: 
          case 115: 
          case 65: 
          case 97: 
            for (;;)
            {
              m += i;
              f9 = f2;
              float f10 = f4;
              j = n;
              f8 = f5;
              f7 = f6;
              f2 = f1;
              f1 = f9;
              f4 = f3;
              f3 = f10;
              break label290;
              paramPath.close();
              paramPath.moveTo(f1, f2);
              f5 = f2;
              f6 = f1;
              f3 = f2;
              f4 = f1;
              i = 2;
              break;
              i = 2;
              break;
              i = 1;
              break;
              i = 6;
              break;
              i = 4;
              break;
              i = 7;
              break;
              f3 += arrayOfFloat2[(m + 0)];
              f4 += arrayOfFloat2[(m + 1)];
              if (m > 0)
              {
                paramPath.rLineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                f9 = f3;
                f3 = f2;
                f2 = f1;
                f5 = f8;
                f1 = f3;
                f6 = f7;
                f3 = f4;
                f4 = f9;
              }
              else
              {
                paramPath.rMoveTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                f10 = f4;
                f9 = f3;
                f5 = f8;
                f1 = f4;
                f6 = f7;
                f2 = f3;
                f3 = f10;
                f4 = f9;
                continue;
                f3 = arrayOfFloat2[(m + 0)];
                f4 = arrayOfFloat2[(m + 1)];
                if (m > 0)
                {
                  paramPath.lineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                  f9 = f3;
                  f3 = f2;
                  f2 = f1;
                  f5 = f8;
                  f1 = f3;
                  f6 = f7;
                  f3 = f4;
                  f4 = f9;
                }
                else
                {
                  paramPath.moveTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                  f10 = f4;
                  f9 = f3;
                  f5 = f8;
                  f1 = f4;
                  f6 = f7;
                  f2 = f3;
                  f3 = f10;
                  f4 = f9;
                  continue;
                  paramPath.rLineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                  f5 = arrayOfFloat2[(m + 0)];
                  f4 += arrayOfFloat2[(m + 1)];
                  f9 = f3 + f5;
                  f3 = f2;
                  f2 = f1;
                  f5 = f8;
                  f1 = f3;
                  f6 = f7;
                  f3 = f4;
                  f4 = f9;
                  continue;
                  paramPath.lineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                  f4 = arrayOfFloat2[(m + 0)];
                  f9 = arrayOfFloat2[(m + 1)];
                  f3 = f2;
                  f2 = f1;
                  f5 = f8;
                  f1 = f3;
                  f6 = f7;
                  f3 = f9;
                  continue;
                  paramPath.rLineTo(arrayOfFloat2[(m + 0)], 0.0F);
                  f5 = arrayOfFloat2[(m + 0)];
                  f9 = f3 + f5;
                  f3 = f1;
                  f5 = f8;
                  f1 = f2;
                  f6 = f7;
                  f2 = f3;
                  f3 = f4;
                  f4 = f9;
                  continue;
                  paramPath.lineTo(arrayOfFloat2[(m + 0)], f4);
                  f5 = arrayOfFloat2[(m + 0)];
                  f3 = f4;
                  f4 = f5;
                  f9 = f1;
                  f5 = f8;
                  f1 = f2;
                  f6 = f7;
                  f2 = f9;
                  continue;
                  paramPath.rLineTo(0.0F, arrayOfFloat2[(m + 0)]);
                  f5 = arrayOfFloat2[(m + 0)];
                  f9 = f1;
                  f10 = f4 + f5;
                  f4 = f3;
                  f1 = f2;
                  f5 = f8;
                  f6 = f7;
                  f2 = f9;
                  f3 = f10;
                  continue;
                  paramPath.lineTo(f3, arrayOfFloat2[(m + 0)]);
                  f9 = arrayOfFloat2[(m + 0)];
                  f4 = f1;
                  f10 = f3;
                  f1 = f2;
                  f5 = f8;
                  f6 = f7;
                  f2 = f4;
                  f3 = f9;
                  f4 = f10;
                  continue;
                  paramPath.rCubicTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)], arrayOfFloat2[(m + 4)], arrayOfFloat2[(m + 5)]);
                  f6 = f3 + arrayOfFloat2[(m + 2)];
                  f5 = f4 + arrayOfFloat2[(m + 3)];
                  f7 = arrayOfFloat2[(m + 4)];
                  f4 += arrayOfFloat2[(m + 5)];
                  f7 = f3 + f7;
                  f3 = f2;
                  f2 = f1;
                  f1 = f3;
                  f3 = f4;
                  f4 = f7;
                  continue;
                  paramPath.cubicTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)], arrayOfFloat2[(m + 4)], arrayOfFloat2[(m + 5)]);
                  f4 = arrayOfFloat2[(m + 4)];
                  f3 = arrayOfFloat2[(m + 5)];
                  f7 = arrayOfFloat2[(m + 2)];
                  f5 = arrayOfFloat2[(m + 3)];
                  f6 = f2;
                  f2 = f1;
                  f1 = f6;
                  f6 = f7;
                }
              }
            }
            f6 = 0.0F;
            if ((j == 99) || (j == 115) || (j == 67) || (j == 83)) {
              f6 = f4 - f8;
            }
            break;
          }
        }
      }
      for (float f5 = f3 - f7;; f5 = 0.0F)
      {
        paramPath.rCubicTo(f5, f6, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
        f6 = f3 + arrayOfFloat2[(m + 0)];
        f5 = f4 + arrayOfFloat2[(m + 1)];
        f7 = arrayOfFloat2[(m + 2)];
        f4 += arrayOfFloat2[(m + 3)];
        f7 = f3 + f7;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        f3 = f4;
        f4 = f7;
        break label482;
        if ((j == 99) || (j == 115) || (j == 67) || (j == 83))
        {
          f4 = 2.0F * f4 - f8;
          f3 = 2.0F * f3 - f7;
        }
        for (;;)
        {
          paramPath.cubicTo(f3, f4, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
          f6 = arrayOfFloat2[(m + 0)];
          f5 = arrayOfFloat2[(m + 1)];
          f4 = arrayOfFloat2[(m + 2)];
          f7 = arrayOfFloat2[(m + 3)];
          f3 = f2;
          f2 = f1;
          f1 = f3;
          f3 = f7;
          break label482;
          paramPath.rQuadTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
          f6 = f3 + arrayOfFloat2[(m + 0)];
          f5 = f4 + arrayOfFloat2[(m + 1)];
          f7 = arrayOfFloat2[(m + 2)];
          f4 += arrayOfFloat2[(m + 3)];
          f7 = f3 + f7;
          f3 = f2;
          f2 = f1;
          f1 = f3;
          f3 = f4;
          f4 = f7;
          break label482;
          paramPath.quadTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
          f6 = arrayOfFloat2[(m + 0)];
          f5 = arrayOfFloat2[(m + 1)];
          f4 = arrayOfFloat2[(m + 2)];
          f7 = arrayOfFloat2[(m + 3)];
          f3 = f2;
          f2 = f1;
          f1 = f3;
          f3 = f7;
          break label482;
          if ((j == 113) || (j == 116) || (j == 81) || (j == 84)) {
            f5 = f4 - f8;
          }
          for (f6 = f3 - f7;; f6 = 0.0F)
          {
            paramPath.rQuadTo(f6, f5, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
            f6 = f3 + f6;
            f5 = f4 + f5;
            f7 = arrayOfFloat2[(m + 0)];
            f4 += arrayOfFloat2[(m + 1)];
            f7 = f3 + f7;
            f3 = f2;
            f2 = f1;
            f1 = f3;
            f3 = f4;
            f4 = f7;
            break label482;
            if ((j != 113) && (j != 116) && (j != 81))
            {
              f6 = f4;
              f5 = f3;
              if (j != 84) {}
            }
            else
            {
              f5 = 2.0F * f3 - f7;
              f6 = 2.0F * f4 - f8;
            }
            paramPath.quadTo(f5, f6, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
            f4 = arrayOfFloat2[(m + 0)];
            f3 = arrayOfFloat2[(m + 1)];
            f7 = f6;
            f6 = f5;
            f8 = f2;
            f2 = f1;
            f5 = f7;
            f1 = f8;
            break label482;
            f5 = arrayOfFloat2[(m + 5)];
            f6 = arrayOfFloat2[(m + 6)];
            f7 = arrayOfFloat2[(m + 0)];
            f8 = arrayOfFloat2[(m + 1)];
            f9 = arrayOfFloat2[(m + 2)];
            boolean bool1;
            if (arrayOfFloat2[(m + 3)] != 0.0F)
            {
              bool1 = true;
              label2168:
              if (arrayOfFloat2[(m + 4)] == 0.0F) {
                break label2261;
              }
            }
            label2261:
            for (boolean bool2 = true;; bool2 = false)
            {
              PathParser.PathDataNode.drawArc(paramPath, f3, f4, f5 + f3, f6 + f4, f7, f8, f9, bool1, bool2);
              f6 = f3 + arrayOfFloat2[(m + 5)];
              f5 = f4 + arrayOfFloat2[(m + 6)];
              f7 = f2;
              f2 = f1;
              f3 = f5;
              f4 = f6;
              f1 = f7;
              break;
              bool1 = false;
              break label2168;
            }
            f5 = arrayOfFloat2[(m + 5)];
            f6 = arrayOfFloat2[(m + 6)];
            f7 = arrayOfFloat2[(m + 0)];
            f8 = arrayOfFloat2[(m + 1)];
            f9 = arrayOfFloat2[(m + 2)];
            if (arrayOfFloat2[(m + 3)] != 0.0F)
            {
              bool1 = true;
              label2328:
              if (arrayOfFloat2[(m + 4)] == 0.0F) {
                break label2409;
              }
            }
            label2409:
            for (bool2 = true;; bool2 = false)
            {
              PathParser.PathDataNode.drawArc(paramPath, f3, f4, f5, f6, f7, f8, f9, bool1, bool2);
              f6 = arrayOfFloat2[(m + 5)];
              f5 = arrayOfFloat2[(m + 6)];
              f7 = f2;
              f2 = f1;
              f3 = f5;
              f4 = f6;
              f1 = f7;
              break;
              bool1 = false;
              break label2328;
            }
            arrayOfFloat1[0] = f3;
            arrayOfFloat1[1] = f4;
            arrayOfFloat1[2] = f7;
            arrayOfFloat1[3] = f8;
            arrayOfFloat1[4] = f1;
            arrayOfFloat1[5] = f2;
            j = type;
            k += 1;
            break;
            return;
            f5 = 0.0F;
          }
        }
      }
    }
  }
  
  private static final class VPathRenderer
  {
    private static final Matrix IDENTITY_MATRIX = new Matrix();
    float mBaseHeight = 0.0F;
    float mBaseWidth = 0.0F;
    private int mChangingConfigurations;
    private Paint mFillPaint;
    private final Matrix mFinalPathMatrix = new Matrix();
    private final Path mPath;
    private PathMeasure mPathMeasure;
    private final Path mRenderPath;
    int mRootAlpha = 255;
    private final VectorDrawableCompat.VGroup mRootGroup;
    String mRootName = null;
    private Paint mStrokePaint;
    final ArrayMap<String, Object> mVGTargetsMap = new ArrayMap();
    float mViewportHeight = 0.0F;
    float mViewportWidth = 0.0F;
    
    public VPathRenderer()
    {
      mRootGroup = new VectorDrawableCompat.VGroup();
      mPath = new Path();
      mRenderPath = new Path();
    }
    
    public VPathRenderer(VPathRenderer paramVPathRenderer)
    {
      mRootGroup = new VectorDrawableCompat.VGroup(mRootGroup, mVGTargetsMap);
      mPath = new Path(mPath);
      mRenderPath = new Path(mRenderPath);
      mBaseWidth = mBaseWidth;
      mBaseHeight = mBaseHeight;
      mViewportWidth = mViewportWidth;
      mViewportHeight = mViewportHeight;
      mChangingConfigurations = mChangingConfigurations;
      mRootAlpha = mRootAlpha;
      mRootName = mRootName;
      if (mRootName != null) {
        mVGTargetsMap.put(mRootName, this);
      }
    }
    
    private void drawGroupTree(VectorDrawableCompat.VGroup paramVGroup, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      mStackedMatrix.set(paramMatrix);
      mStackedMatrix.preConcat(mLocalMatrix);
      int i = 0;
      if (i < mChildren.size())
      {
        paramMatrix = mChildren.get(i);
        if ((paramMatrix instanceof VectorDrawableCompat.VGroup)) {
          drawGroupTree((VectorDrawableCompat.VGroup)paramMatrix, mStackedMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
        float f1;
        float f3;
        float f2;
        Object localObject;
        float f7;
        float f4;
        float f5;
        float f6;
        for (;;)
        {
          i += 1;
          break;
          if ((paramMatrix instanceof VectorDrawableCompat.VPath))
          {
            paramMatrix = (VectorDrawableCompat.VPath)paramMatrix;
            f1 = paramInt1 / mViewportWidth;
            f3 = paramInt2 / mViewportHeight;
            f2 = Math.min(f1, f3);
            localObject = mStackedMatrix;
            mFinalPathMatrix.set((Matrix)localObject);
            mFinalPathMatrix.postScale(f1, f3);
            float[] arrayOfFloat = new float[4];
            float[] tmp155_153 = arrayOfFloat;
            tmp155_153[0] = 0.0F;
            float[] tmp159_155 = tmp155_153;
            tmp159_155[1] = 1.0F;
            float[] tmp163_159 = tmp159_155;
            tmp163_159[2] = 1.0F;
            float[] tmp167_163 = tmp163_159;
            tmp167_163[3] = 0.0F;
            tmp167_163;
            ((Matrix)localObject).mapVectors(arrayOfFloat);
            f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
            f7 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
            f3 = arrayOfFloat[0];
            f4 = arrayOfFloat[1];
            f5 = arrayOfFloat[2];
            f6 = arrayOfFloat[3];
            f7 = Math.max(f1, f7);
            f1 = 0.0F;
            if (f7 > 0.0F) {
              f1 = Math.abs(f6 * f3 - f4 * f5) / f7;
            }
            if (f1 != 0.0F)
            {
              paramMatrix.toPath(mPath);
              localObject = mPath;
              mRenderPath.reset();
              if (!paramMatrix.isClipPath()) {
                break label336;
              }
              mRenderPath.addPath((Path)localObject, mFinalPathMatrix);
              paramCanvas.clipPath(mRenderPath, Region.Op.REPLACE);
            }
          }
        }
        label336:
        paramMatrix = (VectorDrawableCompat.VFullPath)paramMatrix;
        if ((mTrimPathStart != 0.0F) || (mTrimPathEnd != 1.0F))
        {
          f6 = mTrimPathStart;
          f7 = mTrimPathOffset;
          f4 = mTrimPathEnd;
          f5 = mTrimPathOffset;
          if (mPathMeasure == null) {
            mPathMeasure = new PathMeasure();
          }
          mPathMeasure.setPath(mPath, false);
          f3 = mPathMeasure.getLength();
          f6 = (f6 + f7) % 1.0F * f3;
          f4 = (f4 + f5) % 1.0F * f3;
          ((Path)localObject).reset();
          if (f6 <= f4) {
            break label733;
          }
          mPathMeasure.getSegment(f6, f3, (Path)localObject, true);
          mPathMeasure.getSegment(0.0F, f4, (Path)localObject, true);
        }
        for (;;)
        {
          ((Path)localObject).rLineTo(0.0F, 0.0F);
          mRenderPath.addPath((Path)localObject, mFinalPathMatrix);
          if (mFillColor != 0)
          {
            if (mFillPaint == null)
            {
              mFillPaint = new Paint();
              mFillPaint.setStyle(Paint.Style.FILL);
              mFillPaint.setAntiAlias(true);
            }
            localObject = mFillPaint;
            ((Paint)localObject).setColor(VectorDrawableCompat.access$900(mFillColor, mFillAlpha));
            ((Paint)localObject).setColorFilter(paramColorFilter);
            paramCanvas.drawPath(mRenderPath, (Paint)localObject);
          }
          if (mStrokeColor == 0) {
            break;
          }
          if (mStrokePaint == null)
          {
            mStrokePaint = new Paint();
            mStrokePaint.setStyle(Paint.Style.STROKE);
            mStrokePaint.setAntiAlias(true);
          }
          localObject = mStrokePaint;
          if (mStrokeLineJoin != null) {
            ((Paint)localObject).setStrokeJoin(mStrokeLineJoin);
          }
          if (mStrokeLineCap != null) {
            ((Paint)localObject).setStrokeCap(mStrokeLineCap);
          }
          ((Paint)localObject).setStrokeMiter(mStrokeMiterlimit);
          ((Paint)localObject).setColor(VectorDrawableCompat.access$900(mStrokeColor, mStrokeAlpha));
          ((Paint)localObject).setColorFilter(paramColorFilter);
          ((Paint)localObject).setStrokeWidth(f1 * f2 * mStrokeWidth);
          paramCanvas.drawPath(mRenderPath, (Paint)localObject);
          break;
          label733:
          mPathMeasure.getSegment(f6, f4, (Path)localObject, true);
        }
      }
    }
    
    public final void draw$65b72e48(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      drawGroupTree(mRootGroup, IDENTITY_MATRIX, paramCanvas, paramInt1, paramInt2, null);
    }
  }
  
  private static final class VectorDrawableCompatState
    extends Drawable.ConstantState
  {
    boolean mAutoMirrored;
    boolean mCacheDirty;
    boolean mCachedAutoMirrored;
    Bitmap mCachedBitmap;
    int mCachedRootAlpha;
    ColorStateList mCachedTint;
    PorterDuff.Mode mCachedTintMode;
    int mChangingConfigurations;
    Paint mTempPaint;
    ColorStateList mTint = null;
    PorterDuff.Mode mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
    VectorDrawableCompat.VPathRenderer mVPathRenderer;
    
    public VectorDrawableCompatState()
    {
      mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
    }
    
    public VectorDrawableCompatState(VectorDrawableCompatState paramVectorDrawableCompatState)
    {
      if (paramVectorDrawableCompatState != null)
      {
        mChangingConfigurations = mChangingConfigurations;
        mVPathRenderer = new VectorDrawableCompat.VPathRenderer(mVPathRenderer);
        if (mVPathRenderer.mFillPaint != null) {
          VectorDrawableCompat.VPathRenderer.access$402(mVPathRenderer, new Paint(mVPathRenderer.mFillPaint));
        }
        if (mVPathRenderer.mStrokePaint != null) {
          VectorDrawableCompat.VPathRenderer.access$502(mVPathRenderer, new Paint(mVPathRenderer.mStrokePaint));
        }
        mTint = mTint;
        mTintMode = mTintMode;
        mAutoMirrored = mAutoMirrored;
      }
    }
    
    public final int getChangingConfigurations()
    {
      return mChangingConfigurations;
    }
    
    public final Drawable newDrawable()
    {
      return new VectorDrawableCompat(this, (byte)0);
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new VectorDrawableCompat(this, (byte)0);
    }
    
    public final void updateCachedBitmap(int paramInt1, int paramInt2)
    {
      mCachedBitmap.eraseColor(0);
      Canvas localCanvas = new Canvas(mCachedBitmap);
      mVPathRenderer.draw$65b72e48(localCanvas, paramInt1, paramInt2);
    }
  }
  
  private static final class VectorDrawableDelegateState
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState mDelegateState;
    
    public VectorDrawableDelegateState(Drawable.ConstantState paramConstantState)
    {
      mDelegateState = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return mDelegateState.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return mDelegateState.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat((byte)0);
      mDelegateDrawable = ((VectorDrawable)mDelegateState.newDrawable());
      return localVectorDrawableCompat;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat((byte)0);
      mDelegateDrawable = ((VectorDrawable)mDelegateState.newDrawable(paramResources));
      return localVectorDrawableCompat;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat((byte)0);
      mDelegateDrawable = ((VectorDrawable)mDelegateState.newDrawable(paramResources, paramTheme));
      return localVectorDrawableCompat;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */