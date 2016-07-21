package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

@zzhb
public final class zzbl
{
  private final Context mContext;
  
  public zzbl(Context paramContext)
  {
    zzx.zzb(paramContext, "Context can not be null");
    mContext = paramContext;
  }
  
  public final boolean zza(Intent paramIntent)
  {
    boolean bool = false;
    zzx.zzb(paramIntent, "Intent can not be null");
    if (!mContext.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty()) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean zzdl()
  {
    return ("mounted".equals(Environment.getExternalStorageState())) && (mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
  
  @TargetApi(14)
  public final boolean zzdo()
  {
    Intent localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event");
    return (Build.VERSION.SDK_INT >= 14) && (zza(localIntent));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */