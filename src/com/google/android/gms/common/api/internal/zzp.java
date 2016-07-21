package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract interface zzp
{
  public abstract ConnectionResult blockingConnect();
  
  public abstract void connect();
  
  public abstract boolean disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T paramT);
  
  public abstract boolean zza(zzu paramzzu);
  
  public abstract <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T paramT);
  
  public abstract void zzoW();
  
  public abstract void zzpj();
  
  public static abstract interface zza
  {
    public abstract void zzc(int paramInt, boolean paramBoolean);
    
    public abstract void zzd(ConnectionResult paramConnectionResult);
    
    public abstract void zzi(Bundle paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */