package com.linkedin.android.feed.endor.ui.loadingcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.linkedin.android.R.styleable;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.shared.LollipopUtils;
import com.linkedin.android.infra.shared.Util;
import java.util.concurrent.TimeUnit;

public class FeedLoadingCardView
  extends View
{
  protected static final int ANIMATION_DURATION;
  protected static final int ANIMATION_FRAME_COUNT;
  protected static final int FRAME_DURATION = (int)TimeUnit.SECONDS.toMillis(1L) / 60;
  private ShapeDrawable actorImageShape;
  private final int actorImageSize = 48;
  private int actorImageSizePx;
  private boolean animateBorder = false;
  private boolean animateImage = false;
  private int animationDelay = 0;
  private int animationLoopCount = -1;
  private int animationLoops;
  private Paint borderLinePaint;
  private Path borderLinePath;
  private Point borderLinePoint1;
  private Point borderLinePoint2;
  private Point borderLinePoint3;
  private final int borderLineWidth = 2;
  private int borderLineWidthPx;
  private int cardHeightWithoutImagePx;
  private final int cardPadding = 12;
  private int cardPaddingPx;
  private ShapeDrawable commentaryShape;
  private final float commentaryWidthPercent = 0.75F;
  private int commentaryY;
  protected int darkGrayColor;
  private ShapeDrawable headlineShape;
  private final int headlineWidth = 80;
  private final float imageAspectRatio = 1.5F;
  private ShapeDrawable imageBackgroundShape;
  private int imageY;
  private final int innerItemPadding = 8;
  private final Interpolator interpolator = new AccelerateDecelerateInterpolator();
  protected int lightGrayColor;
  protected int mediumGrayColor;
  private ShapeDrawable nameShape;
  private final int nameWidth = 64;
  private int numCommentaryLines = 3;
  private boolean showImage = false;
  private final long startTime = SystemClock.uptimeMillis();
  private final int textLineHeight = 8;
  private int textLineHeightPx;
  
  static
  {
    int i = (int)TimeUnit.SECONDS.toMillis(2L);
    ANIMATION_DURATION = i;
    ANIMATION_FRAME_COUNT = i / FRAME_DURATION;
  }
  
  public FeedLoadingCardView(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public FeedLoadingCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public FeedLoadingCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  @TargetApi(21)
  public FeedLoadingCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramAttributeSet);
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    boolean bool2;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.FeedLoadingCardView, 0, 0);
      numCommentaryLines = paramAttributeSet.getInt(0, numCommentaryLines);
      animateImage = paramAttributeSet.getBoolean(2, animateImage);
      if ((animateImage) || (paramAttributeSet.getBoolean(1, showImage)))
      {
        bool2 = true;
        showImage = bool2;
        animateBorder = paramAttributeSet.getBoolean(3, animateBorder);
        animationDelay = paramAttributeSet.getInt(4, animationDelay);
        animationLoopCount = paramAttributeSet.getInt(5, animationLoopCount);
        paramAttributeSet.recycle();
      }
    }
    else
    {
      if (Util.getAppComponent(getContext()).deviceClass() < 2012) {
        break label649;
      }
      bool1 = true;
      label138:
      animateImage &= bool1;
      bool2 = animateBorder;
      if ((!bool1) || (!LollipopUtils.isEnabled())) {
        break label654;
      }
    }
    int i;
    label649:
    label654:
    for (boolean bool1 = true;; i = 0)
    {
      animateBorder = (bool1 & bool2);
      cardPaddingPx = toPx(12);
      actorImageSizePx = toPx(48);
      textLineHeightPx = toPx(8);
      borderLineWidthPx = toPx(2);
      lightGrayColor = ContextCompat.getColor(getContext(), 2131624161);
      mediumGrayColor = ContextCompat.getColor(getContext(), 2131624162);
      darkGrayColor = ContextCompat.getColor(getContext(), 2131624160);
      borderLinePaint = new Paint(1);
      borderLinePaint.setStyle(Paint.Style.STROKE);
      borderLinePaint.setColor(darkGrayColor);
      borderLinePaint.setStrokeWidth(borderLineWidthPx);
      borderLinePath = new Path();
      borderLinePoint1 = new Point();
      borderLinePoint2 = new Point();
      borderLinePoint3 = new Point();
      actorImageShape = new ShapeDrawable(new OvalShape());
      nameShape = new ShapeDrawable(new RectShape());
      headlineShape = new ShapeDrawable(new RectShape());
      commentaryShape = new ShapeDrawable(new RectShape());
      imageBackgroundShape = new ShapeDrawable(new RectShape());
      actorImageShape.getPaint().setColor(mediumGrayColor);
      nameShape.getPaint().setColor(mediumGrayColor);
      headlineShape.getPaint().setColor(mediumGrayColor);
      commentaryShape.getPaint().setColor(mediumGrayColor);
      imageBackgroundShape.getPaint().setColor(lightGrayColor);
      commentaryY = 68;
      imageY = (commentaryY + Math.max(0, numCommentaryLines) * 16);
      cardHeightWithoutImagePx = toPx(imageY + 12);
      actorImageShape.setBounds(cardPaddingPx, cardPaddingPx, cardPaddingPx + actorImageSizePx, cardPaddingPx + actorImageSizePx);
      i = toPx(68);
      int j = toPx(24);
      nameShape.setBounds(i, j, toPx(64) + i, textLineHeightPx + j);
      j = toPx(40);
      headlineShape.setBounds(i, j, toPx(80) + i, textLineHeightPx + j);
      return;
      bool2 = false;
      break;
      i = 0;
      break label138;
    }
  }
  
  protected void drawImage(Canvas paramCanvas, Rect paramRect) {}
  
  protected void drawImageAnimation$1845ecb4(Canvas paramCanvas, float paramFloat, Rect paramRect) {}
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    if ((animationLoops < animationLoopCount) || (animationLoopCount == -1))
    {
      i = (int)Math.max(0L, SystemClock.uptimeMillis() - startTime - animationDelay) / FRAME_DURATION;
      animationLoops = (i / ANIMATION_FRAME_COUNT);
    }
    float f;
    int j;
    Object localObject;
    label371:
    Point localPoint1;
    if (paramCanvas != null)
    {
      f = i % ANIMATION_FRAME_COUNT / ANIMATION_FRAME_COUNT;
      f = interpolator.getInterpolation(f);
      actorImageShape.draw(paramCanvas);
      nameShape.draw(paramCanvas);
      headlineShape.draw(paramCanvas);
      i = 0;
      if (i < numCommentaryLines)
      {
        j = toPx(commentaryY + i * 16);
        if ((i >= 0) && (i < numCommentaryLines - 1))
        {
          commentaryShape.setBounds(cardPaddingPx, j, Math.max(0, getMeasuredWidth() - cardPaddingPx), textLineHeightPx + j);
          localObject = commentaryShape;
        }
        for (;;)
        {
          if (localObject != null) {
            ((ShapeDrawable)localObject).draw(paramCanvas);
          }
          i += 1;
          break;
          if (i == numCommentaryLines - 1)
          {
            commentaryShape.setBounds(cardPaddingPx, j, Math.max(0, (int)(getMeasuredWidth() * 0.75F)), textLineHeightPx + j);
            localObject = commentaryShape;
          }
          else
          {
            localObject = null;
          }
        }
      }
      if (showImage)
      {
        imageBackgroundShape.draw(paramCanvas);
        localObject = imageBackgroundShape.getBounds();
        drawImage(paramCanvas, (Rect)localObject);
        if (animateImage) {
          drawImageAnimation$1845ecb4(paramCanvas, f, (Rect)localObject);
        }
      }
      if (animateBorder)
      {
        i = getMeasuredWidth();
        j = getMeasuredHeight();
        if (f >= 0.2F) {
          break label489;
        }
        borderLinePoint1.set(0, 0);
        localObject = borderLinePoint1;
        if (f >= 0.2F) {
          break label617;
        }
        borderLinePoint3.set((int)(i * f / 0.2F), 0);
        localPoint1 = borderLinePoint3;
        if (f < 0.2F) {
          break label775;
        }
        if (f >= 0.4F) {
          break label733;
        }
        borderLinePoint2.set(i, 0);
      }
    }
    for (;;)
    {
      Point localPoint2 = borderLinePoint2;
      borderLinePath.reset();
      borderLinePath.moveTo(x, y);
      borderLinePath.lineTo(x, y);
      borderLinePath.lineTo(x, y);
      paramCanvas.drawPath(borderLinePath, borderLinePaint);
      invalidate();
      return;
      label489:
      if (f < 0.4F)
      {
        borderLinePoint1.set((int)(i * (f - 0.2F) / 0.2F), 0);
        break;
      }
      if (f < 0.6F)
      {
        borderLinePoint1.set(i, (int)(j * (f - 0.4F) / 0.2F));
        break;
      }
      if (f < 0.8F)
      {
        borderLinePoint1.set(i - (int)(i * (f - 0.6F) / 0.2F), j);
        break;
      }
      borderLinePoint1.set(0, j - (int)(j * (f - 0.8F) / 0.2F));
      break;
      label617:
      if (f < 0.4F)
      {
        borderLinePoint3.set(i, (int)(j * (f - 0.2F) / 0.2F));
        break label371;
      }
      if (f < 0.6F)
      {
        borderLinePoint3.set(i - (int)(i * (f - 0.4F) / 0.2F), j);
        break label371;
      }
      if (f < 0.8F)
      {
        borderLinePoint3.set(0, j - (int)(j * (f - 0.6F) / 0.2F));
        break label371;
      }
      borderLinePoint3.set(0, 0);
      break label371;
      label733:
      if (f < 0.6F) {
        borderLinePoint2.set(i, j);
      } else if (f < 0.8F) {
        borderLinePoint2.set(0, j);
      } else {
        label775:
        borderLinePoint2.set(0, 0);
      }
    }
  }
  
  protected void onImageRectChanged(Rect paramRect) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = resolveSize(0, paramInt1);
    int i = (int)((k - cardPaddingPx * 2) / 1.5F);
    int m = cardHeightWithoutImagePx;
    paramInt1 = j;
    if (showImage) {
      paramInt1 = i;
    }
    setMeasuredDimension(k, resolveSize(paramInt1 + m, paramInt2));
    if (showImage)
    {
      paramInt1 = toPx(imageY);
      imageBackgroundShape.setBounds(cardPaddingPx, paramInt1, k - cardPaddingPx, paramInt1 + i);
      onImageRectChanged(imageBackgroundShape.getBounds());
    }
  }
  
  protected final int toPx(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.loadingcard.FeedLoadingCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */