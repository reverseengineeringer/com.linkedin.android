package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;

@TargetApi(9)
public class zzis$zza
  extends zzis
{
  public zzis$zza()
  {
    super((byte)0);
  }
  
  public boolean zza(DownloadManager.Request paramRequest)
  {
    paramRequest.setShowRunningNotification(true);
    return true;
  }
  
  public final int zzhv()
  {
    return 6;
  }
  
  public final int zzhw()
  {
    return 7;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzis.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */