package com.google.android.gms.common.api;

import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzp;
import java.io.PrintWriter;
import java.util.Set;

public abstract interface Api$zzb
{
  public abstract void disconnect();
  
  public abstract void dump$ec96877(String paramString, PrintWriter paramPrintWriter);
  
  public abstract boolean isConnected();
  
  public abstract void zza(GoogleApiClient.zza paramzza);
  
  public abstract void zza(zzp paramzzp, Set<Scope> paramSet);
  
  public abstract boolean zzmE();
  
  public abstract boolean zznb();
  
  public abstract Intent zznc();
  
  public abstract IBinder zzoT();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */