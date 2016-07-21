package com.linkedin.android.identity.edit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementIntent;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewActivity;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileCategories;
import java.util.Arrays;
import javax.inject.Inject;

public final class ProfileEditDeeplinkIntent
  extends IntentFactory<ProfileBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    Object localObject = Uri.parse(paramString);
    String str = ((Uri)localObject).getQueryParameter("showPendingEndorsementDialog");
    boolean bool = Boolean.valueOf(str).booleanValue();
    if ((str != null) && (bool)) {
      return new PendingEndorsementIntent().getDeeplinkIntent(paramContext, paramArrayMap, paramString, paramLinkingRoutes);
    }
    localObject = ((Uri)localObject).getQueryParameter("esl");
    if ((str != null) && (!bool) && (localObject != null)) {
      return new ProfileSkillsEditHostIntent().getDeeplinkIntent(paramContext, paramArrayMap, paramString, paramLinkingRoutes);
    }
    paramContext = provideIntent(paramContext);
    paramArrayMap = ProfileBundleBuilder.createSelfProfile();
    paramLinkingRoutes = ProfileEditDeeplinkIntent.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$identity$guidededit$ProfileCategories;
    paramString = Arrays.asList(paramString.split("/"));
    switch (paramLinkingRoutes[ProfileCategories.of(((String)paramString.get(paramString.size() - 1)).toUpperCase(java.util.Locale.US)).ordinal()])
    {
    }
    for (;;)
    {
      paramContext.putExtras(paramArrayMap.build());
      return paramContext;
      paramArrayMap.setDefaultCategoryView(ProfileCategories.SKILLS);
    }
  }
  
  public final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ProfileViewActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileEditDeeplinkIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */