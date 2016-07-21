package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.lang.reflect.Method;

@zzhb
public final class zzb
{
  final Context mContext;
  final boolean zzFA;
  Object zzFz;
  
  public zzb(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private zzb(Context paramContext, byte paramByte)
  {
    mContext = paramContext;
    zzFA = true;
  }
  
  public final Bundle zzb(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Class localClass = mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
      paramString1 = (Bundle)localClass.getDeclaredMethod("getBuyIntent", new Class[] { Integer.TYPE, String.class, String.class, String.class, String.class }).invoke(localClass.cast(zzFz), new Object[] { Integer.valueOf(3), paramString1, paramString2, "inapp", paramString3 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (zzFA) {
        zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", paramString1);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */