package com.linkedin.android.feed.shared;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.linkedin.android.artdeco.ArtDecoTypefaceLoader;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;

final class StackedImagesDrawable$RollupCountDrawable
  extends LayerDrawable
{
  private static final int[] APPEARANCE_ATTRIBUTES = { 16842901, 2130771969, 16842904 };
  private final int offsetAmountPx;
  private final int rollupBorderWidthPx;
  private final int sizePx;
  private final int stackedImageBorderWidthPx;
  private final CharSequence text;
  private final Layout textLayout;
  private final TextPaint textPaint = new TextPaint(1);
  
  private StackedImagesDrawable$RollupCountDrawable(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(new Drawable[] { localShapeDrawable, localObject });
    text = Util.getAppComponent(paramContext).i18NManager().getString(2131231306, new Object[] { Integer.valueOf(Math.min(paramInt1, 99)) });
    sizePx = paramInt2;
    stackedImageBorderWidthPx = paramInt3;
    rollupBorderWidthPx = paramContext.getResources().getDimensionPixelSize(2131493145);
    offsetAmountPx = Math.round(paramInt2 * 0.02F);
    textLayout = configureText(paramContext);
  }
  
  private Layout configureText(Context paramContext)
  {
    int j = sizePx / 2;
    textPaint.setTextSize(j);
    textPaint.setColor(-16777216);
    textPaint.density = getResourcesgetDisplayMetricsdensity;
    textPaint.setDither(true);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(2131361900, APPEARANCE_ATTRIBUTES);
    if (localTypedArray != null)
    {
      i = 0;
      if (i < localTypedArray.getIndexCount())
      {
        k = localTypedArray.getIndex(i);
        switch (k)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          textPaint.setTextSize(localTypedArray.getDimensionPixelSize(k, j));
          continue;
          Object localObject = localTypedArray.getString(k);
          if ((localObject != null) && (!((String)localObject).isEmpty()))
          {
            localObject = ArtDecoTypefaceLoader.typefaceForFontPath(paramContext.getAssets(), (String)localObject);
            if (localObject != null)
            {
              textPaint.setTypeface((Typeface)localObject);
              continue;
              textPaint.setColor(localTypedArray.getColor(k, -16777216));
            }
          }
        }
      }
      localTypedArray.recycle();
    }
    int i = sizePx;
    j = rollupBorderWidthPx;
    int k = stackedImageBorderWidthPx;
    int m = offsetAmountPx;
    return new StaticLayout(text, textPaint, i - j * 2 - k * 2 - m * 2, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Rect localRect = getBounds();
    int i = paramCanvas.save();
    int k = textLayout.getHeight();
    int j = top;
    k = (sizePx - k) / 2;
    int m = offsetAmountPx;
    paramCanvas.translate(left + stackedImageBorderWidthPx + rollupBorderWidthPx, j + k - m);
    textLayout.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.StackedImagesDrawable.RollupCountDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */