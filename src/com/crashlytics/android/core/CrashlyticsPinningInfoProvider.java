package com.crashlytics.android.core;

import java.io.InputStream;

final class CrashlyticsPinningInfoProvider
  implements io.fabric.sdk.android.services.network.PinningInfoProvider
{
  private final PinningInfoProvider pinningInfo;
  
  public CrashlyticsPinningInfoProvider(PinningInfoProvider paramPinningInfoProvider)
  {
    pinningInfo = paramPinningInfoProvider;
  }
  
  public final String getKeyStorePassword()
  {
    return pinningInfo.getKeyStorePassword();
  }
  
  public final InputStream getKeyStoreStream()
  {
    return pinningInfo.getKeyStoreStream();
  }
  
  public final String[] getPins()
  {
    return pinningInfo.getPins();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsPinningInfoProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */