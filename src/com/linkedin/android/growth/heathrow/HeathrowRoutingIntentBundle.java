package com.linkedin.android.growth.heathrow;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.JsonGeneratorException;

public final class HeathrowRoutingIntentBundle
  implements BundleBuilder
{
  private final Bundle bundle;
  
  public HeathrowRoutingIntentBundle()
  {
    bundle = new Bundle();
  }
  
  public HeathrowRoutingIntentBundle(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static MiniProfile getMiniProfile(Bundle paramBundle)
  {
    if (paramBundle != null) {
      try
      {
        paramBundle = (MiniProfile)RecordParceler.unparcel(MiniProfile.BUILDER, "MINI_PROFILE", paramBundle);
        return paramBundle;
      }
      catch (DataReaderException paramBundle)
      {
        Util.safeThrow$7a8b4789(new RuntimeException(paramBundle));
      }
    }
    return null;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final HeathrowRoutingIntentBundle heathrowSource(HeathrowSource paramHeathrowSource)
  {
    if (paramHeathrowSource != null) {
      bundle.putSerializable("HEATHROW_SOURCE", paramHeathrowSource);
    }
    return this;
  }
  
  public final HeathrowRoutingIntentBundle miniProfile(MiniProfile paramMiniProfile)
  {
    if (paramMiniProfile != null) {}
    try
    {
      RecordParceler.parcel(paramMiniProfile, "MINI_PROFILE", bundle);
      profileIdString(entityUrn.getId());
      return this;
    }
    catch (JsonGeneratorException localJsonGeneratorException)
    {
      for (;;)
      {
        Util.safeThrow$7a8b4789(new RuntimeException(localJsonGeneratorException));
      }
    }
  }
  
  public final HeathrowRoutingIntentBundle profileIdString(String paramString)
  {
    bundle.putString("PROFILE_ID_STRING", paramString);
    return this;
  }
  
  public final HeathrowRoutingIntentBundle withInvitationToAcceptData(String paramString1, String paramString2)
  {
    bundle.putString("INVITATION_ID", paramString1);
    bundle.putString("INVITATION_SHARED_KEY", paramString2);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowRoutingIntentBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */