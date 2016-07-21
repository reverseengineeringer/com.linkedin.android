package com.linkedin.android.growth.onboarding;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.voyager.growth.confirmation.EmailConfirmationTask;
import com.linkedin.android.pegasus.gen.voyager.growth.profile.UnderageResponse;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VersionTag;

public final class OnboardingDataProvider$OnboardingState
  extends DataProvider.State
{
  public String addEducationRoute;
  public String addPositionRoute;
  public final String basicLocationRoute = Routes.buildBasicLocationRoute().toString();
  public String citiesRoute;
  public final String countriesRoute = Routes.buildCountriesRoute().toString();
  public String editProfileRoute;
  public String educationsRoute;
  public final String emailConfirmationTaskRoute = Routes.EMAIL.buildUponRoot().buildUpon().build().toString();
  public final String goalTypeRecommendationsRoute = Routes.GOAL_TYPE_RECOMMENDATIONS.buildUponRoot().buildUpon().build().toString();
  public final String goalsRoute = Routes.GOALS.buildUponRoot().buildUpon().build().toString();
  final String invitationsRoute = Routes.NORM_INVITATIONS.buildUponRoot().buildUpon().appendQueryParameter("action", "batchCreate").build().toString();
  public String onboardingFlowRoute = Routes.ONBOARDING_FLOW.buildUponRoot().buildUpon().build().toString();
  public String peopleYouMayKnowRoute;
  public String positionsRoute;
  public String profileRoute;
  public String statesRoute;
  public final String updateUnderageRoute = Routes.UNDERAGE_CHECK.buildUponRoot().buildUpon().appendQueryParameter("action", "update").build().toString();
  public String versionTagRoute;
  
  public OnboardingDataProvider$OnboardingState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
  
  public final EmailConfirmationTask emailConfirmationTask()
  {
    return (EmailConfirmationTask)getModel(emailConfirmationTaskRoute);
  }
  
  public final Profile profile()
  {
    return (Profile)getModel(profileRoute);
  }
  
  public final ActionResponse<UnderageResponse> underageResponse()
  {
    return (ActionResponse)getModel(updateUnderageRoute);
  }
  
  public final VersionTag versionTag()
  {
    return (VersionTag)getModel(versionTagRoute);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */