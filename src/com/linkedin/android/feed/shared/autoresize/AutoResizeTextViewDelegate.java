package com.linkedin.android.feed.shared.autoresize;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;

public final class AutoResizeTextViewDelegate<T extends TextView,  extends AutoResizeTextViewProvider>
{
  private RectF availableSpaceRect;
  private boolean enableSizeCache = true;
  private boolean initialized;
  int maxLines;
  private float maxTextSize;
  private float minTextSize;
  private TextPaint paint;
  float spacingAdd;
  float spacingMult = 1.0F;
  SparseIntArray textCachedSizes;
  private RectF textRect = new RectF();
  final T view;
  private int widthLimit;
  
  public AutoResizeTextViewDelegate(T paramT, AttributeSet paramAttributeSet)
  {
    view = paramT;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramT.getContext().obtainStyledAttributes(paramAttributeSet, new int[] { 16843091 });
      i = paramAttributeSet.getInt(0, -1);
      paramAttributeSet.recycle();
    }
    maxLines = i;
    minTextSize = paramT.getContext().getResources().getDimension(2131493561);
    paint = new TextPaint(view.getPaint());
    maxTextSize = view.getTextSize();
    availableSpaceRect = new RectF();
    textCachedSizes = new SparseIntArray();
    initialized = true;
  }
  
  private int binarySearch(int paramInt1, int paramInt2, RectF paramRectF)
  {
    int i = paramInt1;
    int j = paramInt2 - 1;
    paramInt2 = paramInt1;
    paramInt1 = i;
    i = j;
    while (paramInt2 <= i)
    {
      int m = paramInt2 + i >>> 1;
      paint.setTextSize(m);
      Object localObject = view.getText().toString();
      if (maxLines == 1)
      {
        paramInt1 = 1;
        label65:
        if (paramInt1 == 0) {
          break label140;
        }
        textRect.bottom = paint.getFontSpacing();
        textRect.right = paint.measureText((String)localObject);
        label99:
        textRect.offsetTo(0.0F, 0.0F);
        if (!paramRectF.contains(textRect)) {
          break label268;
        }
      }
      label140:
      label268:
      for (paramInt1 = -1;; paramInt1 = 1)
      {
        if (paramInt1 >= 0) {
          break label273;
        }
        paramInt1 = paramInt2;
        paramInt2 = m + 1;
        break;
        paramInt1 = 0;
        break label65;
        localObject = new StaticLayout((CharSequence)localObject, paint, widthLimit, Layout.Alignment.ALIGN_NORMAL, spacingMult, spacingAdd, true);
        if ((maxLines == -1) || (((StaticLayout)localObject).getLineCount() <= maxLines))
        {
          textRect.bottom = ((StaticLayout)localObject).getHeight();
          j = -1;
          paramInt1 = 0;
          while (paramInt1 < ((StaticLayout)localObject).getLineCount())
          {
            int k = j;
            if (j < ((StaticLayout)localObject).getLineWidth(paramInt1)) {
              k = (int)((StaticLayout)localObject).getLineWidth(paramInt1);
            }
            paramInt1 += 1;
            j = k;
          }
          textRect.right = j;
          break label99;
        }
      }
      label273:
      i = m;
      if (paramInt1 <= 0) {
        break label296;
      }
      i = m - 1;
      paramInt1 = i;
    }
    i = paramInt1;
    label296:
    return i;
  }
  
  final void onSetSingleLine(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      maxLines = i;
      sizeToFit();
      return;
    }
  }
  
  final void onSetTextSize(float paramFloat)
  {
    maxTextSize = paramFloat;
    textCachedSizes.clear();
    sizeToFit();
  }
  
  final void sizeToFit()
  {
    int i = 1;
    if (initialized)
    {
      Layout localLayout = view.getLayout();
      localObject = localLayout;
      if (localLayout == null) {
        localObject = new StaticLayout(view.getText(), paint, widthLimit, Layout.Alignment.ALIGN_NORMAL, spacingMult, spacingAdd, true);
      }
      j = ((Layout)localObject).getLineCount();
      if ((j <= 0) || (((Layout)localObject).getEllipsisCount(j - 1) <= 0)) {
        break label89;
      }
    }
    while (i == 0)
    {
      return;
      label89:
      i = 0;
    }
    int k = (int)minTextSize;
    i = view.getMeasuredHeight();
    int j = view.getCompoundPaddingBottom();
    int m = view.getCompoundPaddingTop();
    widthLimit = (view.getMeasuredWidth() - view.getCompoundPaddingLeft() - view.getCompoundPaddingRight());
    availableSpaceRect.right = widthLimit;
    availableSpaceRect.bottom = (i - j - m);
    int n = (int)maxTextSize;
    Object localObject = availableSpaceRect;
    if (!enableSizeCache) {
      i = binarySearch(k, n, (RectF)localObject);
    }
    for (;;)
    {
      ((AutoResizeTextViewProvider)view).callSuperSetTextSize$255e752(i);
      return;
      m = view.getText().toString().length();
      j = textCachedSizes.get(m);
      i = j;
      if (j == 0)
      {
        i = binarySearch(k, n, (RectF)localObject);
        textCachedSizes.put(m, i);
      }
    }
  }
  
  public static abstract interface AutoResizeTextViewProvider
  {
    public abstract void callSuperSetTextSize$255e752(float paramFloat);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.autoresize.AutoResizeTextViewDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */