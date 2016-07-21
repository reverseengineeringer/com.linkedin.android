package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzr;

final class zzfp$1
  implements DialogInterface.OnClickListener
{
  zzfp$1(zzfp paramzzfp, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (DownloadManager)zzDt.mContext.getSystemService("download");
    try
    {
      Object localObject = zzDr;
      String str = zzDs;
      localObject = new DownloadManager.Request(Uri.parse((String)localObject));
      ((DownloadManager.Request)localObject).setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str);
      zzr.zzbE().zza((DownloadManager.Request)localObject);
      paramDialogInterface.enqueue((DownloadManager.Request)localObject);
      return;
    }
    catch (IllegalStateException paramDialogInterface)
    {
      zzDt.zzam("Could not store picture.");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfp.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */