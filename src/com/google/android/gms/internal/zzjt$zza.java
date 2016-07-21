package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@zzhb
public final class zzjt$zza
  extends MutableContextWrapper
{
  Activity zzMM;
  Context zzOg;
  private Context zzsa;
  
  public zzjt$zza(Context paramContext)
  {
    super(paramContext);
    setBaseContext(paramContext);
  }
  
  public final Object getSystemService(String paramString)
  {
    return zzOg.getSystemService(paramString);
  }
  
  public final void setBaseContext(Context paramContext)
  {
    zzsa = paramContext.getApplicationContext();
    if ((paramContext instanceof Activity)) {}
    for (Activity localActivity = (Activity)paramContext;; localActivity = null)
    {
      zzMM = localActivity;
      zzOg = paramContext;
      super.setBaseContext(zzsa);
      return;
    }
  }
  
  public final void startActivity(Intent paramIntent)
  {
    if ((zzMM != null) && (!zzne.zzcp(21)))
    {
      zzMM.startActivity(paramIntent);
      return;
    }
    paramIntent.setFlags(268435456);
    zzsa.startActivity(paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjt.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */