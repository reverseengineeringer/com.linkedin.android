package android.support.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region.Op;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

final class VectorDrawableCompat$VPathRenderer
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
  
  public VectorDrawableCompat$VPathRenderer()
  {
    mRootGroup = new VectorDrawableCompat.VGroup();
    mPath = new Path();
    mRenderPath = new Path();
  }
  
  public VectorDrawableCompat$VPathRenderer(VPathRenderer paramVPathRenderer)
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

/* Location:
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VPathRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */