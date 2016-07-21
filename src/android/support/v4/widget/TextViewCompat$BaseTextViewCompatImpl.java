package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class TextViewCompat$BaseTextViewCompatImpl
  implements TextViewCompat.TextViewCompatImpl
{
  public int getMaxLines(TextView paramTextView)
  {
    if (!TextViewCompatDonut.sMaxModeFieldFetched)
    {
      TextViewCompatDonut.sMaxModeField = TextViewCompatDonut.retrieveField("mMaxMode");
      TextViewCompatDonut.sMaxModeFieldFetched = true;
    }
    if ((TextViewCompatDonut.sMaxModeField != null) && (TextViewCompatDonut.retrieveIntFromField(TextViewCompatDonut.sMaxModeField, paramTextView) == 1))
    {
      if (!TextViewCompatDonut.sMaximumFieldFetched)
      {
        TextViewCompatDonut.sMaximumField = TextViewCompatDonut.retrieveField("mMaximum");
        TextViewCompatDonut.sMaximumFieldFetched = true;
      }
      if (TextViewCompatDonut.sMaximumField != null) {
        return TextViewCompatDonut.retrieveIntFromField(TextViewCompatDonut.sMaximumField, paramTextView);
      }
    }
    return -1;
  }
  
  public void setCompoundDrawablesRelative$16207aff(TextView paramTextView, Drawable paramDrawable)
  {
    paramTextView.setCompoundDrawables(paramDrawable, null, null, null);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.TextViewCompat.BaseTextViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */