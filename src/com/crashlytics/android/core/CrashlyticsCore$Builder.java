package com.crashlytics.android.core;

public final class CrashlyticsCore$Builder
{
  private float delay = -1.0F;
  private boolean disabled = false;
  private CrashlyticsListener listener;
  private PinningInfoProvider pinningInfoProvider;
  
  public final CrashlyticsCore build()
  {
    if (delay < 0.0F) {
      delay = 1.0F;
    }
    return new CrashlyticsCore(delay, listener, pinningInfoProvider, disabled);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */