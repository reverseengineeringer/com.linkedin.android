package com.linkedin.android.identity.guidededit.pendingendorsement;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import java.util.Map;
import javax.inject.Inject;

public final class PendingEndorsedSkillsDataProvider
  extends DataProvider<PendingEndorsedSkillsDataProvider.PendingEndorsedSkillsState, DataProvider.DataProviderListener>
{
  private static final Uri ROOT = Routes.PROFILE.buildUponRoot();
  Map<String, String> trackingHeader;
  
  @Inject
  public PendingEndorsedSkillsDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
    paramActivityComponent = activityComponent.memberUtil().getProfileId();
    state).pendingEndorsedSkillsRoute = ROOT.buildUpon().appendEncodedPath(paramActivityComponent).appendEncodedPath("pendingEndorsedSkills").build().toString();
    state).versionTagRoute = ProfileRoutes.buildVersionTagRoute(paramActivityComponent, "versionTag").toString();
  }
  
  final String buildPendingEndorsedSkillsActionRoute(String paramString)
  {
    String str = activityComponent.memberUtil().getProfileId();
    return ROOT.buildUpon().appendEncodedPath(str).appendEncodedPath("pendingEndorsedSkills").appendQueryParameter("action", paramString).build().toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsedSkillsDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */