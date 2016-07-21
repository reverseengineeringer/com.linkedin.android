package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class VelocityTrackerCompat
{
  static final VelocityTrackerVersionImpl IMPL = new BaseVelocityTrackerVersionImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new HoneycombVelocityTrackerVersionImpl();
      return;
    }
  }
  
  public static float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getXVelocity(paramVelocityTracker, paramInt);
  }
  
  public static float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getYVelocity(paramVelocityTracker, paramInt);
  }
  
  static final class BaseVelocityTrackerVersionImpl
    implements VelocityTrackerCompat.VelocityTrackerVersionImpl
  {
    public final float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getXVelocity();
    }
    
    public final float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getYVelocity();
    }
  }
  
  static final class HoneycombVelocityTrackerVersionImpl
    implements VelocityTrackerCompat.VelocityTrackerVersionImpl
  {
    public final float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getXVelocity(paramInt);
    }
    
    public final float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getYVelocity(paramInt);
    }
  }
  
  static abstract interface VelocityTrackerVersionImpl
  {
    public abstract float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt);
    
    public abstract float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.VelocityTrackerCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */