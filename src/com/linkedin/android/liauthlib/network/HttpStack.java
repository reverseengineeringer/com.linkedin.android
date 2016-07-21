package com.linkedin.android.liauthlib.network;

import com.linkedin.android.liauthlib.cookies.AuthLibCookieManager;
import java.util.Map;

public abstract interface HttpStack
  extends AuthLibCookieManager
{
  public abstract void performGET(String paramString, Map<String, String> paramMap, int paramInt, HttpOperationListener paramHttpOperationListener);
  
  public abstract void performPOST(String paramString, Map<String, String> paramMap, int paramInt, byte[] paramArrayOfByte, HttpOperationListener paramHttpOperationListener);
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.network.HttpStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */