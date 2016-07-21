package com.crashlytics.android.core.internal.models;

public final class SignalData
{
  public final String code;
  public final long faultAddress;
  public final String name;
  
  public SignalData(String paramString1, String paramString2)
  {
    name = paramString1;
    code = paramString2;
    faultAddress = 0L;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.internal.models.SignalData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */