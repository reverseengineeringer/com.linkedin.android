package com.linkedin.android.premium;

import android.content.Intent;
import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductFamily;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel;

public final class PremiumActivityBundleBuilder
  implements BundleBuilder
{
  private static final PremiumUpsellChannel DEFAULT_CHANNEL = PremiumUpsellChannel.$UNKNOWN;
  private static final PremiumProductFamily DEFAULT_FAMILY = PremiumProductFamily.$UNKNOWN;
  private final Bundle bundle = new Bundle();
  
  public PremiumActivityBundleBuilder()
  {
    this((byte)0);
  }
  
  private PremiumActivityBundleBuilder(byte paramByte) {}
  
  public static String getCampaignId(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("campaignId");
  }
  
  public static PremiumUpsellChannel getFromChannel(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return DEFAULT_CHANNEL;
    }
    paramBundle = paramBundle.getString("channel");
    if (paramBundle == null) {
      return DEFAULT_CHANNEL;
    }
    return PremiumUpsellChannel.of(paramBundle);
  }
  
  static Intent getNextActivityIntent(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return (Intent)paramBundle.getParcelable("nextActivityIntent");
  }
  
  static Bundle getNextActivityOptions(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getBundle("nextActivityOptions");
  }
  
  public static PremiumProductFamily getSuggestedFamily(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return DEFAULT_FAMILY;
    }
    paramBundle = paramBundle.getString("suggestedFamily");
    if (paramBundle == null) {
      return DEFAULT_FAMILY;
    }
    return PremiumProductFamily.of(paramBundle);
  }
  
  public static String getUpsellTrackingCode(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("upsellTrackingCode");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final PremiumActivityBundleBuilder setCampaignUrn(Urn paramUrn)
  {
    if (paramUrn != null) {
      bundle.putString("campaignId", paramUrn.getId());
    }
    return this;
  }
  
  public final PremiumActivityBundleBuilder setFromChannel(PremiumUpsellChannel paramPremiumUpsellChannel)
  {
    bundle.putString("channel", String.valueOf(paramPremiumUpsellChannel));
    return this;
  }
  
  public final PremiumActivityBundleBuilder setNextActivity(Intent paramIntent)
  {
    bundle.putParcelable("nextActivityIntent", paramIntent);
    bundle.putBundle("nextActivityOptions", null);
    return this;
  }
  
  public final PremiumActivityBundleBuilder setSuggestedFamily(PremiumProductFamily paramPremiumProductFamily)
  {
    if (paramPremiumProductFamily != null) {
      bundle.putString("suggestedFamily", String.valueOf(paramPremiumProductFamily));
    }
    return this;
  }
  
  public final PremiumActivityBundleBuilder setUpsellTrackingCode(Urn paramUrn)
  {
    bundle.putString("upsellTrackingCode", paramUrn.getId());
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumActivityBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */