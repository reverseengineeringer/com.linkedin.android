package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

class CompoundButtonCompat$BaseCompoundButtonCompat
  implements CompoundButtonCompat.CompoundButtonCompatImpl
{
  public Drawable getButtonDrawable(CompoundButton paramCompoundButton)
  {
    return CompoundButtonCompatDonut.getButtonDrawable(paramCompoundButton);
  }
  
  public void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
    }
  }
  
  public void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.CompoundButtonCompat.BaseCompoundButtonCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */