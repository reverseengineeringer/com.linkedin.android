package com.linkedin.android.growth.heathrow;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.Origin;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.UserActionType;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.platformType;
import javax.inject.Inject;

public final class HeathrowFlowDataProvider
  extends DataProvider<State, DataProvider.DataProviderListener>
{
  @Inject
  public HeathrowFlowDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  final String buildHeathrowRoute(Origin paramOrigin, UserActionType paramUserActionType, platformType paramplatformType)
  {
    paramOrigin = Routes.SUGGESTED_ROUTES.buildUponRoot().buildUpon().appendQueryParameter("q", "key").appendQueryParameter("origin", paramOrigin.name()).appendQueryParameter("userActionType", paramUserActionType.name()).appendQueryParameter("platform", paramplatformType.name());
    if ((!"control".equalsIgnoreCase(activityComponent.lixManager().getTreatment(Lix.LIX_HEATHROW_SUGGESTED_ROUTE_TRACKING))) && (!TextUtils.isEmpty(state).suggestedRouteTrackingId))) {
      paramOrigin.appendQueryParameter("trackingId", state).suggestedRouteTrackingId);
    }
    return paramOrigin.build().toString();
  }
  
  public static final class State
    extends DataProvider.State
  {
    String acceptInviteRoute;
    String heathrowRoute;
    String miniProfileRoute;
    String suggestedRouteTrackingId;
    
    public State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowFlowDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */