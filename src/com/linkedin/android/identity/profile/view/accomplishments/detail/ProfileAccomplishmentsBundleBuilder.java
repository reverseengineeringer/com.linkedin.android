package com.linkedin.android.identity.profile.view.accomplishments.detail;

import android.os.Bundle;
import com.linkedin.android.identity.profile.view.accomplishments.AccomplishmentType;
import com.linkedin.android.infra.BundleBuilder;

public final class ProfileAccomplishmentsBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public static ProfileAccomplishmentsBundleBuilder create(AccomplishmentType paramAccomplishmentType, String paramString)
  {
    ProfileAccomplishmentsBundleBuilder localProfileAccomplishmentsBundleBuilder = new ProfileAccomplishmentsBundleBuilder();
    bundle.putInt("cardType", paramAccomplishmentType.ordinal());
    bundle.putString("profileId", paramString);
    return localProfileAccomplishmentsBundleBuilder;
  }
  
  public static AccomplishmentType getCardType(Bundle paramBundle)
  {
    int i = paramBundle.getInt("cardType");
    return AccomplishmentType.values()[i];
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.accomplishments.detail.ProfileAccomplishmentsBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */