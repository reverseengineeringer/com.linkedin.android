package com.linkedin.android.feed.shared.autoresize;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.linkedin.android.R.styleable;

public class AutoResizeTextView
  extends AppCompatTextView
  implements AutoResizeTextViewDelegate.AutoResizeTextViewProvider
{
  private boolean autoComputeMaxLines;
  private AutoResizeTextViewDelegate autoResizeTextViewDelegate;
  
  public AutoResizeTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoResizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public AutoResizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private boolean computeMaxLines()
  {
    boolean bool2 = false;
    Layout localLayout = getLayout();
    boolean bool1 = bool2;
    if (localLayout != null)
    {
      bool1 = bool2;
      if (localLayout.getLineCount() > 0)
      {
        int i = localLayout.getLineCount();
        int j = localLayout.getLineBottom(0) - localLayout.getLineTop(0);
        int k = getMeasuredHeight();
        if (k < i * j)
        {
          setMaxLines(k / j);
          post(new Runnable()
          {
            public final void run()
            {
              if (autoResizeTextViewDelegate != null) {
                autoResizeTextViewDelegate.sizeToFit();
              }
            }
          });
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    setEllipsize(TextUtils.TruncateAt.END);
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.AutoResizeTextView, 0, 0);
      autoComputeMaxLines = localTypedArray.getBoolean(0, false);
      localTypedArray.recycle();
    }
    autoResizeTextViewDelegate = new AutoResizeTextViewDelegate(this, paramAttributeSet);
  }
  
  public final void callSuperSetTextSize$255e752(float paramFloat)
  {
    super.setTextSize(0, paramFloat);
  }
  
  public int getMaxLines()
  {
    if (autoResizeTextViewDelegate != null) {
      return autoResizeTextViewDelegate.maxLines;
    }
    return -1;
  }
  
  public boolean onPreDraw()
  {
    if (autoComputeMaxLines) {
      computeMaxLines();
    }
    return super.onPreDraw();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (autoResizeTextViewDelegate != null) {
      autoResizeTextViewDelegate.textCachedSizes.clear();
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) && (autoResizeTextViewDelegate != null)) {
      autoResizeTextViewDelegate.sizeToFit();
    }
    if (autoComputeMaxLines) {
      computeMaxLines();
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (autoResizeTextViewDelegate != null) {
      autoResizeTextViewDelegate.sizeToFit();
    }
  }
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    super.setLineSpacing(paramFloat1, paramFloat2);
    if (autoResizeTextViewDelegate != null)
    {
      AutoResizeTextViewDelegate localAutoResizeTextViewDelegate = autoResizeTextViewDelegate;
      spacingMult = paramFloat2;
      spacingAdd = paramFloat1;
    }
  }
  
  public void setLines(int paramInt)
  {
    super.setLines(paramInt);
    if (autoResizeTextViewDelegate != null)
    {
      AutoResizeTextViewDelegate localAutoResizeTextViewDelegate = autoResizeTextViewDelegate;
      maxLines = paramInt;
      localAutoResizeTextViewDelegate.sizeToFit();
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    if (autoResizeTextViewDelegate != null)
    {
      AutoResizeTextViewDelegate localAutoResizeTextViewDelegate = autoResizeTextViewDelegate;
      maxLines = paramInt;
      localAutoResizeTextViewDelegate.sizeToFit();
    }
  }
  
  public void setSingleLine()
  {
    super.setSingleLine();
    if (autoResizeTextViewDelegate != null) {
      autoResizeTextViewDelegate.onSetSingleLine(true);
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    super.setSingleLine(paramBoolean);
    if (autoResizeTextViewDelegate != null) {
      autoResizeTextViewDelegate.onSetSingleLine(paramBoolean);
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
    if (autoResizeTextViewDelegate != null) {
      autoResizeTextViewDelegate.sizeToFit();
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    if (autoResizeTextViewDelegate != null) {
      autoResizeTextViewDelegate.onSetTextSize(paramFloat);
    }
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AutoResizeTextViewDelegate localAutoResizeTextViewDelegate;
    if (autoResizeTextViewDelegate != null)
    {
      localAutoResizeTextViewDelegate = autoResizeTextViewDelegate;
      localObject = view.getContext();
      if (localObject != null) {
        break label45;
      }
    }
    label45:
    for (Object localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      localAutoResizeTextViewDelegate.onSetTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.autoresize.AutoResizeTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */