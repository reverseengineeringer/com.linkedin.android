package com.linkedin.android.growth.onboarding;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.infra.shared.Routes;

public final class OnboardingRoutes
{
  public static Uri buildRebuildMyFeedRout(int paramInt1, int paramInt2)
  {
    return Routes.REBUILD_MY_FFED.buildPagedRouteUponRoot(paramInt1, paramInt2).buildUpon().appendQueryParameter("q", "followRecommendations").build();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingRoutes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */