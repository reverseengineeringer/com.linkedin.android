package com.linkedin.android.feed.endor.ui.loadingcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;

public class FeedLoadingCardViewWithMountain
  extends FeedLoadingCardView
{
  private final int animationLineWidth = 1;
  private Path animationPath;
  private Path bigMountain;
  private Point bigPeakPoint;
  private Point headPoint;
  private Rect imageBounds;
  private Paint mountainAnimationPaint;
  private Paint mountainPaint;
  private Path smallMountain;
  private Point smallPeakPoint;
  private ShapeDrawable sun;
  private Point tailPoint;
  private Point valleyPoint;
  
  public FeedLoadingCardViewWithMountain(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public FeedLoadingCardViewWithMountain(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public FeedLoadingCardViewWithMountain(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(21)
  public FeedLoadingCardViewWithMountain(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  private void init()
  {
    sun = new ShapeDrawable(new OvalShape());
    bigMountain = new Path();
    smallMountain = new Path();
    animationPath = new Path();
    sun.getPaint().setColor(mediumGrayColor);
    mountainPaint = new Paint(1);
    mountainPaint.setStyle(Paint.Style.FILL);
    mountainPaint.setColor(mediumGrayColor);
    mountainAnimationPaint = new Paint(1);
    mountainAnimationPaint.setStyle(Paint.Style.STROKE);
    mountainAnimationPaint.setColor(darkGrayColor);
    mountainAnimationPaint.setStrokeWidth(toPx(1));
    tailPoint = new Point();
    headPoint = new Point();
    bigPeakPoint = new Point();
    valleyPoint = new Point();
    smallPeakPoint = new Point();
  }
  
  private int y(float paramFloat)
  {
    if (paramFloat < 0.4F) {
      return (int)(imageBounds.bottom - paramFloat / 0.4F * (imageBounds.bottom - bigPeakPoint.y));
    }
    if (paramFloat < 0.65F) {
      return (int)(bigPeakPoint.y + (paramFloat - 0.4F) / 0.25F * (valleyPoint.y - bigPeakPoint.y));
    }
    if (paramFloat < 0.75F) {
      return (int)(valleyPoint.y - (paramFloat - 0.65F) / 0.1F * (valleyPoint.y - smallPeakPoint.y));
    }
    return (int)(smallPeakPoint.y + (paramFloat - 0.75F) / 0.25F * (imageBounds.bottom - smallPeakPoint.y));
  }
  
  protected final void drawImage(Canvas paramCanvas, Rect paramRect)
  {
    if (!paramRect.equals(imageBounds)) {
      onImageRectChanged(paramRect);
    }
    sun.draw(paramCanvas);
    paramCanvas.drawPath(bigMountain, mountainPaint);
    paramCanvas.drawPath(smallMountain, mountainPaint);
  }
  
  protected final void drawImageAnimation$1845ecb4(Canvas paramCanvas, float paramFloat, Rect paramRect)
  {
    Object localObject2 = null;
    if (!paramRect.equals(imageBounds)) {
      onImageRectChanged(paramRect);
    }
    int i = right - left;
    Point localPoint2;
    int j;
    label102:
    Point localPoint3;
    if (paramFloat < 0.8F)
    {
      tailPoint.set(left, bottom);
      localPoint2 = tailPoint;
      if (paramFloat >= 0.6F) {
        break label392;
      }
      localPoint1 = headPoint;
      j = left;
      localPoint1.set((int)(i * paramFloat * 1.6666666F) + j, y(paramFloat * 1.6666666F));
      localPoint3 = headPoint;
      if ((x >= bigPeakPoint.x) || (x <= bigPeakPoint.x)) {
        break label410;
      }
      paramRect = bigPeakPoint;
      label143:
      if ((x >= valleyPoint.x) || (x <= valleyPoint.x)) {
        break label415;
      }
    }
    label392:
    label410:
    label415:
    for (Point localPoint1 = valleyPoint;; localPoint1 = null)
    {
      Object localObject1 = localObject2;
      if (x < smallPeakPoint.x)
      {
        localObject1 = localObject2;
        if (x > smallPeakPoint.x) {
          localObject1 = smallPeakPoint;
        }
      }
      animationPath.reset();
      animationPath.moveTo(x, y);
      if (paramRect != null) {
        animationPath.lineTo(x, y);
      }
      if (localPoint1 != null) {
        animationPath.lineTo(x, y);
      }
      if (localObject1 != null) {
        animationPath.lineTo(x, y);
      }
      animationPath.lineTo(x, y);
      paramCanvas.drawPath(animationPath, mountainAnimationPaint);
      return;
      j = (int)(i * (paramFloat - 0.8F) / 0.2F);
      tailPoint.set(j + left, y((paramFloat - 0.8F) * 5.0F));
      break;
      headPoint.set(right, bottom);
      break label102;
      paramRect = null;
      break label143;
    }
  }
  
  protected final void onImageRectChanged(Rect paramRect)
  {
    imageBounds = paramRect;
    int i = right - left;
    int j = bottom - top;
    int k = right - (int)(i * 0.19999999F);
    int m = top + (int)(j * 0.19999999F);
    sun.setBounds(k, m, (int)(j * 0.15F) + k, (int)(m + j * 0.15F));
    Rect localRect = imageBounds;
    bigMountain.reset();
    bigMountain.moveTo(left, bottom);
    bigMountain.lineTo(left + i * 0.8F, bottom);
    bigMountain.lineTo(left + i * 0.8F * 0.5F, top + j * 0.19999999F);
    bigMountain.close();
    bigPeakPoint.set((int)(left + i * 0.8F * 0.5F), (int)(top + j * 0.19999999F));
    localRect = imageBounds;
    smallMountain.reset();
    smallMountain.moveTo(right, bottom);
    smallMountain.lineTo(right - i * 0.5F * 0.5F, top + j * 0.5F);
    smallMountain.lineTo(left + i * 0.5F, bottom);
    smallMountain.close();
    smallPeakPoint.set((int)(right - i * 0.5F * 0.5F), (int)(top + j * 0.5F));
    valleyPoint.set((int)(left + i * 0.65F), (int)(top + j * 0.7F));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.loadingcard.FeedLoadingCardViewWithMountain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */