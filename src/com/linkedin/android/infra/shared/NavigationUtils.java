package com.linkedin.android.infra.shared;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import com.linkedin.android.infra.app.BaseActivity;

public final class NavigationUtils
{
  public static void navigateUp(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    if ((paramActivity.isTaskRoot()) && (paramActivity.getFragmentManager().getBackStackEntryCount() == 0))
    {
      TaskStackBuilder.create(paramActivity).addNextIntentWithParentStack(paramIntent).startActivities();
      if ((paramActivity instanceof BaseActivity)) {
        ((BaseActivity)paramActivity).fireBackPressedControlInteractionEvent();
      }
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      isSoftwareBack = true;
      ignoreBackButtonTracking = paramBoolean;
    }
    paramActivity.onBackPressed();
  }
  
  public static void onUpPressed(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramActivity instanceof BaseActivity))
    {
      isSoftwareBack = true;
      ignoreBackButtonTracking = paramBoolean;
    }
    paramActivity.onBackPressed();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.NavigationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */