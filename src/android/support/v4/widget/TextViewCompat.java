package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class TextViewCompat
{
  static final TextViewCompatImpl IMPL = new BaseTextViewCompatImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      IMPL = new Api23TextViewCompatImpl();
      return;
    }
    if (i >= 18)
    {
      IMPL = new JbMr2TextViewCompatImpl();
      return;
    }
    if (i >= 17)
    {
      IMPL = new JbMr1TextViewCompatImpl();
      return;
    }
    if (i >= 16)
    {
      IMPL = new JbTextViewCompatImpl();
      return;
    }
  }
  
  public static int getMaxLines(TextView paramTextView)
  {
    return IMPL.getMaxLines(paramTextView);
  }
  
  public static void setCompoundDrawablesRelative$16207aff(TextView paramTextView, Drawable paramDrawable)
  {
    IMPL.setCompoundDrawablesRelative$16207aff(paramTextView, paramDrawable);
  }
  
  static final class Api23TextViewCompatImpl
    extends TextViewCompat.JbMr2TextViewCompatImpl
  {}
  
  static class BaseTextViewCompatImpl
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
  
  static class JbMr1TextViewCompatImpl
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
  
  static class JbMr2TextViewCompatImpl
    extends TextViewCompat.JbMr1TextViewCompatImpl
  {
    public final void setCompoundDrawablesRelative$16207aff(TextView paramTextView, Drawable paramDrawable)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable, null, null, null);
    }
  }
  
  static class JbTextViewCompatImpl
    extends TextViewCompat.BaseTextViewCompatImpl
  {
    public final int getMaxLines(TextView paramTextView)
    {
      return paramTextView.getMaxLines();
    }
  }
  
  static abstract interface TextViewCompatImpl
  {
    public abstract int getMaxLines(TextView paramTextView);
    
    public abstract void setCompoundDrawablesRelative$16207aff(TextView paramTextView, Drawable paramDrawable);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.TextViewCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */