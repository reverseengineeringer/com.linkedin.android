package com.google.android.gms.internal;

import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class zzlh$1
  implements InvocationHandler
{
  zzlh$1(zzlh paramzzlh, Class paramClass) {}
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramObject = Class.forName("com.facebook.SessionState");
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    if ((!paramMethod.getName().equals("call")) || (arrayOfClass.length != 3) || (arrayOfClass[0] != zzYk) || (arrayOfClass[1] != paramObject) || (arrayOfClass[2] != Exception.class)) {
      throw new ExceptionInInitializerError("Method not supported!");
    }
    if (((Boolean)zzYk.getDeclaredMethod("isOpened", new Class[0]).invoke(paramArrayOfObject[0], new Object[0])).booleanValue())
    {
      paramObject = (String)zzYk.getDeclaredMethod("getAccessToken", new Class[0]).invoke(paramArrayOfObject[0], new Object[0]);
      zzlh.zzb(zzYl).zzk(zzlh.zza(zzYl, IdpTokenType.zzXA, (String)paramObject, zzlh.zza(zzYl)));
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlh.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */