package com.linkedin.messengerlib;

import android.widget.ImageView;
import android.widget.TextView;

@Deprecated
public abstract class MessengerDrawableResources
{
  public static int getImageResourceId(MessengerDrawableResources paramMessengerDrawableResources, int paramInt)
  {
    if (paramMessengerDrawableResources != null) {
      return paramMessengerDrawableResources.getResId(paramInt);
    }
    return 0;
  }
  
  public static void setCompoundDrawablesWithIntrinsicBounds$514a8d2(MessengerDrawableResources paramMessengerDrawableResources, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramMessengerDrawableResources != null) {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramMessengerDrawableResources.getResId(paramInt1), paramMessengerDrawableResources.getResId(paramInt2), paramMessengerDrawableResources.getResId(paramInt3), paramMessengerDrawableResources.getResId(0));
    }
  }
  
  public static void setImageResource(MessengerDrawableResources paramMessengerDrawableResources, ImageView paramImageView, int paramInt)
  {
    if (paramMessengerDrawableResources != null) {
      paramImageView.setImageResource(paramMessengerDrawableResources.getResId(paramInt));
    }
  }
  
  public abstract int getResId(int paramInt);
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.MessengerDrawableResources
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */