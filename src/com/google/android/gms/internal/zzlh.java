package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class zzlh
  extends zzlg
{
  public static final List<String> zzYf = Collections.singletonList("email");
  private Class<?> zzYg;
  private Class<?> zzYh;
  private Object zzYi;
  private Object zzYj;
  
  public zzlh(Activity paramActivity, List<String> paramList)
  {
    super(paramActivity, zzYf, paramList);
  }
  
  private void zznv()
    throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    if (zzYj != null)
    {
      Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[] { Activity.class, Collection.class }).invoke(zzYj, new Object[] { mActivity, new ArrayList(zzns()) });
      return;
    }
    Class localClass1 = Class.forName("com.facebook.Session$OpenRequest");
    Object localObject1 = localClass1.getConstructor(new Class[] { Activity.class }).newInstance(new Object[] { mActivity });
    localClass1.getDeclaredMethod("setPermissions", new Class[] { List.class }).invoke(localObject1, new Object[] { new ArrayList(zzns()) });
    localClass1.getDeclaredMethod("setRequestCode", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(64206) });
    Class localClass2 = Class.forName("com.facebook.Session");
    Object localObject2 = localClass1.getDeclaredMethod("setCallback", new Class[] { Class.forName("com.facebook.Session$StatusCallback") });
    final Object localObject3 = Class.forName("com.facebook.Session");
    Class localClass3 = Class.forName("com.facebook.Session$StatusCallback");
    ClassLoader localClassLoader = localClass3.getClassLoader();
    localObject3 = new InvocationHandler()
    {
      public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        paramAnonymousObject = Class.forName("com.facebook.SessionState");
        Class[] arrayOfClass = paramAnonymousMethod.getParameterTypes();
        if ((!paramAnonymousMethod.getName().equals("call")) || (arrayOfClass.length != 3) || (arrayOfClass[0] != localObject3) || (arrayOfClass[1] != paramAnonymousObject) || (arrayOfClass[2] != Exception.class)) {
          throw new ExceptionInInitializerError("Method not supported!");
        }
        if (((Boolean)localObject3.getDeclaredMethod("isOpened", new Class[0]).invoke(paramAnonymousArrayOfObject[0], new Object[0])).booleanValue())
        {
          paramAnonymousObject = (String)localObject3.getDeclaredMethod("getAccessToken", new Class[0]).invoke(paramAnonymousArrayOfObject[0], new Object[0]);
          zzlh.zzb(zzlh.this).zzk(zzlh.zza(zzlh.this, IdpTokenType.zzXA, (String)paramAnonymousObject, zzlh.zza(zzlh.this)));
        }
        return null;
      }
    };
    ((Method)localObject2).invoke(localObject1, new Object[] { Proxy.newProxyInstance(localClassLoader, new Class[] { localClass3 }, (InvocationHandler)localObject3) });
    localObject2 = localClass2.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { mActivity });
    localClass2.getDeclaredMethod("setActiveSession", new Class[] { localClass2 }).invoke(null, new Object[] { localObject2 });
    localClass2.getDeclaredMethod("openForRead", new Class[] { localClass1 }).invoke(localObject2, new Object[] { localObject1 });
  }
  
  public final void zza(zzlf.zza paramzza)
  {
    zzb(null, null, (zzlf.zza)zzx.zzz(paramzza));
    try
    {
      zznv();
      return;
    }
    catch (ClassNotFoundException paramzza)
    {
      throw new RuntimeException(paramzza);
    }
    catch (NoSuchMethodException paramzza)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramzza)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramzza)
    {
      for (;;) {}
    }
    catch (InstantiationException paramzza)
    {
      for (;;) {}
    }
  }
  
  public final void zza(String paramString, zzlf.zza paramzza)
  {
    zzb((String)zzx.zzz(paramString), null, (zzlf.zza)zzx.zzz(paramzza));
    try
    {
      zznv();
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramString)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramString)
    {
      for (;;) {}
    }
    catch (InstantiationException paramString)
    {
      for (;;) {}
    }
  }
  
  public final void zza(String paramString1, String paramString2, zzlf.zza paramzza)
  {
    zzb((String)zzx.zzz(paramString1), (String)zzx.zzz(paramString2), (zzlf.zza)zzx.zzz(paramzza));
    try
    {
      zznv();
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
    catch (NoSuchMethodException paramString1)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramString1)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramString1)
    {
      for (;;) {}
    }
    catch (InstantiationException paramString1)
    {
      for (;;) {}
    }
  }
  
  public final boolean zza(int paramInt1, int paramInt2, Intent paramIntent, zzlf.zza paramzza)
  {
    zzb(paramzza);
    if ((paramInt1 != 64206) && (zzYg == null)) {
      return false;
    }
    if ((zzYg != null) && (zzYh != null) && (zzYi != null)) {}
    try
    {
      if (!((Boolean)zzYg.getDeclaredMethod("isFacebookRequestCode", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt1) })).booleanValue()) {
        return false;
      }
      bool = ((Boolean)zzYh.getDeclaredMethod("onActivityResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class }).invoke(zzYi, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramIntent)
    {
      boolean bool;
      throw new RuntimeException(paramIntent);
      try
      {
        Object localObject = Class.forName("com.facebook.Session");
        paramzza = ((Class)localObject).getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
        localObject = ((Class)localObject).getDeclaredMethod("onActivityResult", new Class[] { Activity.class, Integer.TYPE, Integer.TYPE, Intent.class });
        if (paramzza == null) {
          return false;
        }
        bool = ((Boolean)((Method)localObject).invoke(paramzza, new Object[] { mActivity, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent })).booleanValue();
        return bool;
      }
      catch (ClassNotFoundException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
      catch (IllegalAccessException paramIntent)
      {
        for (;;) {}
      }
      catch (NoSuchMethodException paramIntent)
      {
        for (;;) {}
      }
      catch (InvocationTargetException paramIntent)
      {
        for (;;) {}
      }
    }
    catch (NoSuchMethodException paramIntent)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramIntent)
    {
      for (;;) {}
    }
  }
  
  public final zzd zzmU()
  {
    return zzd.zzXi;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */