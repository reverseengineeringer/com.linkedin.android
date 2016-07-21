package com.linkedin.android.infra.shared;

public final class VoyagerUserVisibleException
  extends Exception
{
  public final int serviceErrorCode;
  
  public VoyagerUserVisibleException(String paramString, int paramInt)
  {
    super(paramString);
    serviceErrorCode = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.VoyagerUserVisibleException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */