package com.linkedin.android.entities.shared;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class AutofitTextButton
  extends AppCompatButton
  implements AutofitHelper.OnTextSizeChangeListener
{
  private AutofitHelper mHelper;
  
  public AutofitTextButton(Context paramContext)
  {
    super(paramContext);
    init$23ad5828$57252eaa();
  }
  
  public AutofitTextButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init$23ad5828$57252eaa();
  }
  
  public AutofitTextButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init$23ad5828$57252eaa();
  }
  
  private void init$23ad5828$57252eaa()
  {
    AutofitHelper localAutofitHelper = new AutofitHelper(this);
    localAutofitHelper.setEnabled(true);
    mHelper = localAutofitHelper.addOnTextSizeChangeListener(this);
  }
  
  public AutofitHelper getAutofitHelper()
  {
    return mHelper;
  }
  
  public float getMaxTextSize()
  {
    return mHelper.mMaxTextSize;
  }
  
  public float getMinTextSize()
  {
    return mHelper.mMinTextSize;
  }
  
  public float getPrecision()
  {
    return mHelper.mPrecision;
  }
  
  public final void onTextSizeChange$2548a35() {}
  
  public void setLines(int paramInt)
  {
    super.setLines(paramInt);
    if (mHelper != null) {
      mHelper.setMaxLines(paramInt);
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    if (mHelper != null) {
      mHelper.setMaxLines(paramInt);
    }
  }
  
  public void setMaxTextSize(float paramFloat)
  {
    AutofitHelper localAutofitHelper = mHelper;
    Context localContext = mTextView.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    paramFloat = TypedValue.applyDimension(2, paramFloat, localResources.getDisplayMetrics());
    if (paramFloat != mMaxTextSize)
    {
      mMaxTextSize = paramFloat;
      localAutofitHelper.autofit();
    }
  }
  
  public void setMinTextSize(int paramInt)
  {
    AutofitHelper localAutofitHelper = mHelper;
    float f = paramInt;
    Context localContext = mTextView.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    f = TypedValue.applyDimension(2, f, localResources.getDisplayMetrics());
    if (f != mMinTextSize)
    {
      mMinTextSize = f;
      localAutofitHelper.autofit();
    }
  }
  
  public void setPrecision(float paramFloat)
  {
    AutofitHelper localAutofitHelper = mHelper;
    if (mPrecision != paramFloat)
    {
      mPrecision = paramFloat;
      localAutofitHelper.autofit();
    }
  }
  
  public void setSizeToFit(boolean paramBoolean)
  {
    mHelper.setEnabled(paramBoolean);
  }
  
  public void setTextSize(float paramFloat)
  {
    super.setTextSize(paramFloat);
    if (mHelper != null) {
      mHelper.setTextSize(2, paramFloat);
    }
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    if (mHelper != null) {
      mHelper.setTextSize(paramInt, paramFloat);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.AutofitTextButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */