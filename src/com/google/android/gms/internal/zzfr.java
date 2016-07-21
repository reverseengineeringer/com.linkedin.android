package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzfr
  extends zzfs
  implements zzdf
{
  private final Context mContext;
  DisplayMetrics zzDA;
  private float zzDB;
  int zzDC = -1;
  int zzDD = -1;
  private int zzDE;
  int zzDF = -1;
  int zzDG = -1;
  int zzDH = -1;
  int zzDI = -1;
  private final zzbl zzDz;
  private final zzjp zzpD;
  private final WindowManager zzsb;
  
  public zzfr(zzjp paramzzjp, Context paramContext, zzbl paramzzbl)
  {
    super(paramzzjp);
    zzpD = paramzzjp;
    mContext = paramContext;
    zzDz = paramzzbl;
    zzsb = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    zzDA = new DisplayMetrics();
    paramzzjp = zzsb.getDefaultDisplay();
    paramzzjp.getMetrics(zzDA);
    zzDB = zzDA.density;
    zzDE = paramzzjp.getRotation();
    zzn.zzcS();
    zzDC = zza.zzb(zzDA, zzDA.widthPixels);
    zzn.zzcS();
    zzDD = zza.zzb(zzDA, zzDA.heightPixels);
    paramzzjp = zzpD.zzhP();
    int j;
    int k;
    if ((paramzzjp == null) || (paramzzjp.getWindow() == null))
    {
      zzDF = zzDC;
      zzDG = zzDD;
      if (!zzpD.zzaN().zzui) {
        break label594;
      }
      zzDH = zzDC;
      zzDI = zzDD;
      zza(zzDC, zzDD, zzDF, zzDG, zzDB, zzDE);
      paramzzjp = new zzfq.zza();
      paramMap = zzDz;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setData(Uri.parse("tel:"));
      zzDv = paramMap.zza(localIntent);
      paramMap = zzDz;
      localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse("sms:"));
      zzDu = paramMap.zza(localIntent);
      zzDw = zzDz.zzdo();
      zzDx = zzDz.zzdl();
      zzDy = true;
      paramzzjp = new zzfq(paramzzjp, (byte)0);
      zzpD.zzb("onDeviceFeaturesReceived", paramzzjp.toJson());
      paramzzjp = new int[2];
      zzpD.getLocationOnScreen(paramzzjp);
      zzn.zzcS();
      j = zza.zzc(mContext, paramzzjp[0]);
      zzn.zzcS();
      k = zza.zzc(mContext, paramzzjp[1]);
      if (!(mContext instanceof Activity)) {
        break label676;
      }
      zzr.zzbC();
    }
    label594:
    label676:
    for (int i = zzir.zzh((Activity)mContext)[0];; i = 0)
    {
      int m = zzDH;
      int n = zzDI;
      try
      {
        paramzzjp = new JSONObject().put("x", j).put("y", k - i).put("width", m).put("height", n);
        zzpD.zzb("onDefaultPositionReceived", paramzzjp);
        paramzzjp = zzpD.zzhU();
        if (zzzB != null)
        {
          paramzzjp = zzzB;
          zzDd = j;
          zzDe = k;
        }
        if (zzin.zzQ(2)) {
          zzin.zzaJ("Dispatching Ready Event.");
        }
        paramzzjp = zzpD.zzhX().afmaVersion;
        try
        {
          paramzzjp = new JSONObject().put("js", paramzzjp);
          zzpD.zzb("onReadyEventReceived", paramzzjp);
          return;
        }
        catch (JSONException paramzzjp)
        {
          zzin.zzb("Error occured while dispatching ready Event.", paramzzjp);
          return;
        }
        zzr.zzbC();
        paramzzjp = zzir.zze(paramzzjp);
        zzn.zzcS();
        zzDF = zza.zzb(zzDA, paramzzjp[0]);
        zzn.zzcS();
        zzDG = zza.zzb(zzDA, paramzzjp[1]);
        break;
        zzpD.measure(0, 0);
        zzn.zzcS();
        zzDH = zza.zzc(mContext, zzpD.getMeasuredWidth());
        zzn.zzcS();
        zzDI = zza.zzc(mContext, zzpD.getMeasuredHeight());
      }
      catch (JSONException paramzzjp)
      {
        for (;;)
        {
          zzin.zzb("Error occured while dispatching default position.", paramzzjp);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */