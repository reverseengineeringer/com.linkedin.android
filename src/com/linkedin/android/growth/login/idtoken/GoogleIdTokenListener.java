package com.linkedin.android.growth.login.idtoken;

public abstract interface GoogleIdTokenListener
{
  public abstract void onFetchFailed();
  
  public abstract void onFetchSucceed(String paramString);
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.idtoken.GoogleIdTokenListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */