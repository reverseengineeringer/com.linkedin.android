package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;

public class ActivityOptionsCompat
{
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsImpl21(new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(paramActivity, paramView, paramString)));
    }
    return new ActivityOptionsCompat();
  }
  
  public Bundle toBundle()
  {
    return null;
  }
  
  private static final class ActivityOptionsImpl21
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompat21 mImpl;
    
    ActivityOptionsImpl21(ActivityOptionsCompat21 paramActivityOptionsCompat21)
    {
      mImpl = paramActivityOptionsCompat21;
    }
    
    public final Bundle toBundle()
    {
      return mImpl.mActivityOptions.toBundle();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */