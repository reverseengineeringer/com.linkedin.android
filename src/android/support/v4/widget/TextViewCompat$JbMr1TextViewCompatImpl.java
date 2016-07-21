package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class TextViewCompat$JbMr1TextViewCompatImpl
  extends TextViewCompat.JbTextViewCompatImpl
{
  public void setCompoundDrawablesRelative$16207aff(TextView paramTextView, Drawable paramDrawable)
  {
    int i;
    Drawable localDrawable;
    if (paramTextView.getLayoutDirection() == 1)
    {
      i = 1;
      if (i == 0) {
        break label36;
      }
      localDrawable = null;
      label17:
      if (i == 0) {
        break label42;
      }
    }
    for (;;)
    {
      paramTextView.setCompoundDrawables(localDrawable, null, paramDrawable, null);
      return;
      i = 0;
      break;
      label36:
      localDrawable = paramDrawable;
      break label17;
      label42:
      paramDrawable = null;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.TextViewCompat.JbMr1TextViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */