package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

final class NavUtils$NavUtilsImplJB
  extends NavUtils.NavUtilsImplBase
{
  public final Intent getParentActivityIntent(Activity paramActivity)
  {
    Intent localIntent2 = paramActivity.getParentActivityIntent();
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null) {
      localIntent1 = super.getParentActivityIntent(paramActivity);
    }
    return localIntent1;
  }
  
  public final String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo)
  {
    String str2 = parentActivityName;
    String str1 = str2;
    if (str2 == null) {
      str1 = super.getParentActivityName(paramContext, paramActivityInfo);
    }
    return str1;
  }
  
  public final void navigateUpTo(Activity paramActivity, Intent paramIntent)
  {
    paramActivity.navigateUpTo(paramIntent);
  }
  
  public final boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
  {
    return paramActivity.shouldUpRecreateTask(paramIntent);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NavUtils.NavUtilsImplJB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */