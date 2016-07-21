package com.linkedin.android.entities.shared;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class AutofitHelper
{
  private boolean mEnabled;
  private boolean mIsAutofitting;
  private ArrayList<OnTextSizeChangeListener> mListeners;
  private int mMaxLines;
  float mMaxTextSize;
  float mMinTextSize;
  private View.OnLayoutChangeListener mOnLayoutChangeListener = new AutofitOnLayoutChangeListener((byte)0);
  private TextPaint mPaint;
  float mPrecision;
  private float mTextSize;
  TextView mTextView;
  private TextWatcher mTextWatcher = new AutofitTextWatcher((byte)0);
  
  AutofitHelper(TextView paramTextView)
  {
    float f = getContextgetResourcesgetDisplayMetricsscaledDensity;
    mTextView = paramTextView;
    mPaint = new TextPaint();
    setRawTextSize(paramTextView.getTextSize());
    int i = -1;
    TransformationMethod localTransformationMethod = paramTextView.getTransformationMethod();
    if ((localTransformationMethod != null) && ((localTransformationMethod instanceof SingleLineTransformationMethod))) {
      i = 1;
    }
    for (;;)
    {
      mMaxLines = i;
      mMinTextSize = (13.0F * f);
      mMaxTextSize = mTextSize;
      mPrecision = 0.5F;
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        i = paramTextView.getMaxLines();
      }
    }
  }
  
  private static float getAutofitTextSize(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, DisplayMetrics paramDisplayMetrics)
  {
    float f1 = paramFloat2;
    for (;;)
    {
      paramFloat2 = (f1 + paramFloat3) / 2.0F;
      int i = 1;
      StaticLayout localStaticLayout = null;
      paramTextPaint.setTextSize(TypedValue.applyDimension(0, paramFloat2, paramDisplayMetrics));
      if (paramInt != 1)
      {
        localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, (int)paramFloat1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        i = localStaticLayout.getLineCount();
      }
      if (i > paramInt) {
        if (paramFloat3 - f1 >= paramFloat4) {}
      }
      float f2;
      float f3;
      while (paramFloat3 - f1 < paramFloat4)
      {
        return f1;
        paramFloat3 = paramFloat2;
        break;
        if (i < paramInt)
        {
          f1 = paramFloat2;
          break;
        }
        f2 = 0.0F;
        if (paramInt != 1) {
          break label149;
        }
        f3 = paramTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
      }
      if (f3 > paramFloat1)
      {
        paramFloat3 = paramFloat2;
        continue;
        label149:
        int j = 0;
        for (;;)
        {
          f3 = f2;
          if (j >= i) {
            break;
          }
          f3 = f2;
          if (localStaticLayout.getLineWidth(j) > f2) {
            f3 = localStaticLayout.getLineWidth(j);
          }
          j += 1;
          f2 = f3;
        }
      }
      else
      {
        if (f3 >= paramFloat1) {
          break;
        }
        f1 = paramFloat2;
      }
    }
    return paramFloat2;
  }
  
  private void sendTextSizeChange$2548a35()
  {
    if (mListeners == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((OnTextSizeChangeListener)localIterator.next()).onTextSizeChange$2548a35();
      }
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (mTextSize != paramFloat) {
      mTextSize = paramFloat;
    }
  }
  
  public final AutofitHelper addOnTextSizeChangeListener(OnTextSizeChangeListener paramOnTextSizeChangeListener)
  {
    if (mListeners == null) {
      mListeners = new ArrayList();
    }
    mListeners.add(paramOnTextSizeChangeListener);
    return this;
  }
  
  final void autofit()
  {
    float f4 = mTextView.getTextSize();
    mIsAutofitting = true;
    TextView localTextView = mTextView;
    TextPaint localTextPaint = mPaint;
    float f3 = mMinTextSize;
    float f1 = mMaxTextSize;
    int i = mMaxLines;
    float f2 = mPrecision;
    if ((i <= 0) || (i == Integer.MAX_VALUE)) {}
    int j;
    do
    {
      mIsAutofitting = false;
      if (mTextView.getTextSize() != f4) {
        sendTextSizeChange$2548a35();
      }
      return;
      j = localTextView.getWidth() - localTextView.getCompoundPaddingLeft() - localTextView.getCompoundPaddingRight();
    } while (j <= 0);
    Object localObject2 = localTextView.getText();
    Object localObject3 = localTextView.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, localTextView);
    }
    localObject3 = localTextView.getContext();
    localObject2 = Resources.getSystem();
    if (localObject3 != null) {
      localObject2 = ((Context)localObject3).getResources();
    }
    localObject2 = ((Resources)localObject2).getDisplayMetrics();
    localTextPaint.set(localTextView.getPaint());
    localTextPaint.setTextSize(f1);
    if ((i != 1) || (localTextPaint.measureText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length()) <= j))
    {
      float f5 = j;
      localTextPaint.setTextSize(TypedValue.applyDimension(0, f1, (DisplayMetrics)localObject2));
      if (new StaticLayout((CharSequence)localObject1, localTextPaint, (int)f5, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= i) {}
    }
    else
    {
      f1 = getAutofitTextSize((CharSequence)localObject1, localTextPaint, j, i, 0.0F, f1, f2, (DisplayMetrics)localObject2);
    }
    for (;;)
    {
      f2 = f1;
      if (f1 < f3) {
        f2 = f3;
      }
      localTextView.setTextSize(0, f2);
      break;
    }
  }
  
  public final AutofitHelper setEnabled(boolean paramBoolean)
  {
    if (mEnabled != paramBoolean)
    {
      mEnabled = paramBoolean;
      if (paramBoolean)
      {
        mTextView.addTextChangedListener(mTextWatcher);
        mTextView.addOnLayoutChangeListener(mOnLayoutChangeListener);
        autofit();
      }
    }
    else
    {
      return this;
    }
    mTextView.removeTextChangedListener(mTextWatcher);
    mTextView.removeOnLayoutChangeListener(mOnLayoutChangeListener);
    mTextView.setTextSize(0, mTextSize);
    return this;
  }
  
  public final AutofitHelper setMaxLines(int paramInt)
  {
    if (mMaxLines != paramInt)
    {
      mMaxLines = paramInt;
      autofit();
    }
    return this;
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    if (mIsAutofitting) {
      return;
    }
    Context localContext = mTextView.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
  }
  
  private final class AutofitOnLayoutChangeListener
    implements View.OnLayoutChangeListener
  {
    private AutofitOnLayoutChangeListener() {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      autofit();
    }
  }
  
  private final class AutofitTextWatcher
    implements TextWatcher
  {
    private AutofitTextWatcher() {}
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      autofit();
    }
  }
  
  public static abstract interface OnTextSizeChangeListener
  {
    public abstract void onTextSizeChange$2548a35();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.AutofitHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */