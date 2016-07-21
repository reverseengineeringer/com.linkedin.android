package com.linkedin.android.liauthlib.common;

public final class LiAuthResponse
  extends LiResponse
{
  public static abstract interface AuthListener
  {
    public abstract void onResponse(LiAuthResponse paramLiAuthResponse);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.common.LiAuthResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */