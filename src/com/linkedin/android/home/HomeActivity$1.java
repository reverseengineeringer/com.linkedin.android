package com.linkedin.android.home;

import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuthProvider;
import com.linkedin.android.tos.LiLogInStateInterface;

final class HomeActivity$1
  implements LiLogInStateInterface
{
  HomeActivity$1(HomeActivity paramHomeActivity, ActivityComponent paramActivityComponent) {}
  
  public final boolean isLoggedInAsLinkedinMember()
  {
    LiAuth localLiAuth = LiAuthProvider.getInstance(val$activityComponent.context());
    val$activityComponent.context();
    return !localLiAuth.needsAuth$faab209();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.home.HomeActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */