package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.DrawerListener;

public final class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private final Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  private boolean mDrawerIndicatorEnabled;
  private final int mOpenDrawerContentDescRes;
  
  private void setActionBarDescription(int paramInt)
  {
    mActivityImpl.setActionBarDescription(paramInt);
  }
  
  public final void onDrawerClosed$3c7ec8c3()
  {
    if (mDrawerIndicatorEnabled) {
      setActionBarDescription(mOpenDrawerContentDescRes);
    }
  }
  
  public final void onDrawerOpened$3c7ec8c3()
  {
    if (mDrawerIndicatorEnabled) {
      setActionBarDescription(mCloseDrawerContentDescRes);
    }
  }
  
  public final void onDrawerSlide$5359e7dd(float paramFloat)
  {
    Math.min(1.0F, Math.max(0.0F, paramFloat));
  }
  
  public static abstract interface Delegate
  {
    public abstract void setActionBarDescription(int paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */