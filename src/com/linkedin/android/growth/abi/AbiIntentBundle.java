package com.linkedin.android.growth.abi;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.JsonGeneratorException;

public final class AbiIntentBundle
  implements BundleBuilder
{
  public final Bundle bundle;
  
  public AbiIntentBundle()
  {
    bundle = new Bundle();
  }
  
  public AbiIntentBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      bundle = paramBundle;
      return;
      paramBundle = new Bundle();
    }
  }
  
  public static String getAbiSource(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("ABI_SOURCE");
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
        Util.safeThrow(new RuntimeException(paramBundle));
      }
    }
    return null;
  }
  
  public final AbiIntentBundle abiSource(String paramString)
  {
    bundle.putString("ABI_SOURCE", paramString);
    return this;
  }
  
  public final AbiIntentBundle abookImportTransactionId(String paramString)
  {
    bundle.putString("abookImportTransactionId", paramString);
    return this;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final AbiIntentBundle forceLaunchAbiSplash()
  {
    bundle.putInt("LAUNCH_MODE", 1);
    return this;
  }
  
  public final AbiIntentBundle forceLaunchPastImportedContacts()
  {
    bundle.putInt("LAUNCH_MODE", 2);
    return this;
  }
  
  public final AbiIntentBundle legoTrackingToken(String paramString)
  {
    bundle.putString("legoTrackingToken", paramString);
    return this;
  }
  
  public final AbiIntentBundle miniProfile(MiniProfile paramMiniProfile)
  {
    if (paramMiniProfile != null) {}
    try
    {
      RecordParceler.parcel(paramMiniProfile, "MINI_PROFILE", bundle);
      return this;
    }
    catch (JsonGeneratorException paramMiniProfile)
    {
      Util.safeThrow(new RuntimeException(paramMiniProfile));
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiIntentBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */