package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

@zzhb
public final class zzfp
  extends zzfs
{
  final Context mContext;
  final Map<String, String> zzxA;
  
  public zzfp(zzjp paramzzjp, Map<String, String> paramMap)
  {
    super(paramzzjp, "storePicture");
    zzxA = paramMap;
    mContext = paramzzjp.zzhP();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */