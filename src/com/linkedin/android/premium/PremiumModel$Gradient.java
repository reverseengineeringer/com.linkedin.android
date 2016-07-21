package com.linkedin.android.premium;

import android.graphics.drawable.GradientDrawable.Orientation;

public final class PremiumModel$Gradient
{
  public final int[] colors;
  final GradientDrawable.Orientation orientation;
  
  public PremiumModel$Gradient(int paramInt)
  {
    this(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { paramInt });
  }
  
  public PremiumModel$Gradient(GradientDrawable.Orientation paramOrientation, int... paramVarArgs)
  {
    if (paramOrientation != null) {}
    for (;;)
    {
      orientation = paramOrientation;
      colors = paramVarArgs;
      return;
      paramOrientation = GradientDrawable.Orientation.LEFT_RIGHT;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumModel.Gradient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */