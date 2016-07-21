package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class ViewGroupCompat
{
  static final ViewGroupCompatImpl IMPL = new ViewGroupCompatStubImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      IMPL = new ViewGroupCompatLollipopImpl();
      return;
    }
    if (i >= 18)
    {
      IMPL = new ViewGroupCompatJellybeanMR2Impl();
      return;
    }
    if (i >= 14)
    {
      IMPL = new ViewGroupCompatIcsImpl();
      return;
    }
    if (i >= 11)
    {
      IMPL = new ViewGroupCompatHCImpl();
      return;
    }
  }
  
  public static void setMotionEventSplittingEnabled$4d3af60(ViewGroup paramViewGroup)
  {
    IMPL.setMotionEventSplittingEnabled$4d3af60(paramViewGroup);
  }
  
  static class ViewGroupCompatHCImpl
    extends ViewGroupCompat.ViewGroupCompatStubImpl
  {
    public final void setMotionEventSplittingEnabled$4d3af60(ViewGroup paramViewGroup)
    {
      paramViewGroup.setMotionEventSplittingEnabled(false);
    }
  }
  
  static class ViewGroupCompatIcsImpl
    extends ViewGroupCompat.ViewGroupCompatHCImpl
  {}
  
  static abstract interface ViewGroupCompatImpl
  {
    public abstract void setMotionEventSplittingEnabled$4d3af60(ViewGroup paramViewGroup);
  }
  
  static class ViewGroupCompatJellybeanMR2Impl
    extends ViewGroupCompat.ViewGroupCompatIcsImpl
  {}
  
  static final class ViewGroupCompatLollipopImpl
    extends ViewGroupCompat.ViewGroupCompatJellybeanMR2Impl
  {}
  
  static class ViewGroupCompatStubImpl
    implements ViewGroupCompat.ViewGroupCompatImpl
  {
    public void setMotionEventSplittingEnabled$4d3af60(ViewGroup paramViewGroup) {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewGroupCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */