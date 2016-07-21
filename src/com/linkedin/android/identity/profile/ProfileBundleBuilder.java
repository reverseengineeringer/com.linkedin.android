package com.linkedin.android.identity.profile;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileCategories;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;

public final class ProfileBundleBuilder
  implements BundleBuilder
{
  public final Bundle bundle;
  
  private ProfileBundleBuilder()
  {
    bundle = new Bundle();
  }
  
  public ProfileBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static ProfileBundleBuilder create(MiniProfile paramMiniProfile)
  {
    ProfileBundleBuilder localProfileBundleBuilder = new ProfileBundleBuilder();
    bundle.putString("profileId", entityUrn.getId());
    return localProfileBundleBuilder;
  }
  
  public static ProfileBundleBuilder createFromExternalIdentifier(String paramString)
  {
    ProfileBundleBuilder localProfileBundleBuilder = new ProfileBundleBuilder();
    bundle.putString("externalIdentifier", paramString);
    return localProfileBundleBuilder;
  }
  
  @Deprecated
  public static ProfileBundleBuilder createFromMemberId(String paramString)
  {
    ProfileBundleBuilder localProfileBundleBuilder = new ProfileBundleBuilder();
    bundle.putString("memberId", paramString);
    bundle.putBoolean("memberIdProfile", true);
    return localProfileBundleBuilder;
  }
  
  public static ProfileBundleBuilder createFromProfileId(String paramString)
  {
    ProfileBundleBuilder localProfileBundleBuilder = new ProfileBundleBuilder();
    bundle.putString("profileId", paramString);
    return localProfileBundleBuilder;
  }
  
  public static ProfileBundleBuilder createFromPublicIdentifier(String paramString)
  {
    ProfileBundleBuilder localProfileBundleBuilder = new ProfileBundleBuilder();
    bundle.putString("publicIdentifier", paramString);
    return localProfileBundleBuilder;
  }
  
  public static ProfileBundleBuilder createMeTabProfile()
  {
    ProfileBundleBuilder localProfileBundleBuilder = new ProfileBundleBuilder();
    bundle.putBoolean("selfProfile", true);
    bundle.putBoolean("meTabProfile", true);
    return localProfileBundleBuilder;
  }
  
  public static ProfileBundleBuilder createSelfProfile()
  {
    ProfileBundleBuilder localProfileBundleBuilder = new ProfileBundleBuilder();
    bundle.putBoolean("selfProfile", true);
    return localProfileBundleBuilder;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final ProfileBundleBuilder setDefaultCategoryView(ProfileCategories paramProfileCategories)
  {
    bundle.putSerializable("defaultView", paramProfileCategories);
    return this;
  }
  
  public final void setThirdPartyPackageName(String paramString)
  {
    bundle.putString("thirdPartyApplicationPackageName", paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.ProfileBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */