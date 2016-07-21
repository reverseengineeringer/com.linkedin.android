package com.linkedin.android.feed.shared;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public final class LineHeightImageSpan
  extends ImageSpan
{
  private WeakReference<Drawable> drawableRef;
  public int marginLeftPx;
  
  public LineHeightImageSpan(Drawable paramDrawable)
  {
    super(paramDrawable);
    drawableRef = new WeakReference(paramDrawable);
  }
  
  private Drawable getCachedDrawable()
  {
    Drawable localDrawable2 = (Drawable)drawableRef.get();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null)
    {
      localDrawable1 = getDrawable();
      drawableRef = new WeakReference(localDrawable1);
    }
    return localDrawable1;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getCachedDrawable();
    if (paramCharSequence == null) {
      return;
    }
    paramCanvas.save();
    paramInt2 = getFontMetricsIntascent;
    paramInt3 = getFontMetricsIntdescent;
    paramInt1 = paramCharSequence.getBounds().height();
    paramInt2 = (paramInt3 - paramInt2) / 2;
    paramInt1 /= 2;
    paramCanvas.translate(marginLeftPx + paramFloat, paramInt5 - paramInt2 - paramInt1);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getCachedDrawable();
    if (paramCharSequence == null) {
      return 0;
    }
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      ascent = ascent;
      descent = descent;
      top = top;
      bottom = bottom;
      paramInt2 = descent - ascent;
      int i = paramCharSequence.getIntrinsicWidth();
      int j = paramCharSequence.getBounds().width();
      paramInt1 = paramInt2;
      if (i > 0)
      {
        paramInt1 = paramInt2;
        if (j > 0) {
          paramInt1 = paramInt2 / (i / j);
        }
      }
      paramCharSequence.setBounds(0, 0, paramInt1, paramInt1);
    }
    return marginLeftPx + paramCharSequence.getBounds().width();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.LineHeightImageSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */