package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class MarginLayoutParamsCompat
{
  static final MarginLayoutParamsCompatImpl IMPL = new MarginLayoutParamsCompatImplBase();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      IMPL = new MarginLayoutParamsCompatImplJbMr1();
      return;
    }
  }
  
  public static int getMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return IMPL.getMarginEnd(paramMarginLayoutParams);
  }
  
  public static int getMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return IMPL.getMarginStart(paramMarginLayoutParams);
  }
  
  static abstract interface MarginLayoutParamsCompatImpl
  {
    public abstract int getMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams);
    
    public abstract int getMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams);
  }
  
  static final class MarginLayoutParamsCompatImplBase
    implements MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
  {
    public final int getMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      return rightMargin;
    }
    
    public final int getMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      return leftMargin;
    }
  }
  
  static final class MarginLayoutParamsCompatImplJbMr1
    implements MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl
  {
    public final int getMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      return paramMarginLayoutParams.getMarginEnd();
    }
    
    public final int getMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      return paramMarginLayoutParams.getMarginStart();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.MarginLayoutParamsCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */