package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.overlay.zzi;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzhb
public final class zzdo
  implements zzdf
{
  private final Map<zzjp, Integer> zzzI = new WeakHashMap();
  
  private static int zza(Context paramContext, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      zzn.zzcS();
      i = zza.zzb(paramContext, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      zzin.zzaK("Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    Object localObject1 = (String)paramMap.get("action");
    if (localObject1 == null) {
      zzin.zzaK("Action missing from video GMSG.");
    }
    for (;;)
    {
      return;
      if (zzin.zzQ(3))
      {
        localObject2 = new JSONObject(paramMap);
        ((JSONObject)localObject2).remove("google.afma.Notify_dt");
        zzin.zzaI("Video GMSG: " + (String)localObject1 + " " + ((JSONObject)localObject2).toString());
      }
      int i;
      if ("background".equals(localObject1))
      {
        paramMap = (String)paramMap.get("color");
        if (TextUtils.isEmpty(paramMap))
        {
          zzin.zzaK("Color parameter missing from color video GMSG.");
          return;
        }
        try
        {
          i = Color.parseColor(paramMap);
          paramMap = paramzzjp.zzia();
          if (paramMap != null)
          {
            paramMap = paramMap.zzhM();
            if (paramMap != null)
            {
              paramMap.setBackgroundColor(i);
              return;
            }
          }
        }
        catch (IllegalArgumentException paramzzjp)
        {
          zzin.zzaK("Invalid color parameter in video GMSG.");
          return;
        }
        zzzI.put(paramzzjp, Integer.valueOf(i));
        return;
      }
      Object localObject2 = paramzzjp.zzia();
      if (localObject2 == null)
      {
        zzin.zzaK("Could not get underlay container for a video GMSG.");
        return;
      }
      boolean bool1 = "new".equals(localObject1);
      boolean bool2 = "position".equals(localObject1);
      int j;
      int k;
      int m;
      if ((bool1) || (bool2))
      {
        localObject1 = paramzzjp.getContext();
        i = zza((Context)localObject1, paramMap, "x", 0);
        j = zza((Context)localObject1, paramMap, "y", 0);
        k = zza((Context)localObject1, paramMap, "w", -1);
        m = zza((Context)localObject1, paramMap, "h", -1);
      }
      try
      {
        Integer.parseInt((String)paramMap.get("player"));
        if ((bool1) && (((zzjo)localObject2).zzhM() == null))
        {
          if (zzFo == null)
          {
            zzbx.zza(zzpD.zzic().zzpe, zzpD.zzib(), new String[] { "vpr" });
            zzbx.zzb(zzpD.zzic().zzpe);
            zzFo = new zzk(mContext, zzpD);
            zzNx.addView(zzFo, 0, new ViewGroup.LayoutParams(-1, -1));
            zzFo.zzd(i, j, k, m);
            zzpD.zzhU().zzND = false;
          }
          if (!zzzI.containsKey(paramzzjp)) {
            continue;
          }
          i = ((Integer)zzzI.get(paramzzjp)).intValue();
          paramzzjp = ((zzjo)localObject2).zzhM();
          paramzzjp.setBackgroundColor(i);
          paramzzjp.zzfE();
          return;
        }
        zzx.zzcD("The underlay may only be modified from the UI thread.");
        if (zzFo == null) {
          continue;
        }
        zzFo.zzd(i, j, k, m);
        return;
        localObject2 = ((zzjo)localObject2).zzhM();
        if (localObject2 == null)
        {
          zzk.zzg(paramzzjp);
          return;
        }
        if ("click".equals(localObject1))
        {
          paramzzjp = paramzzjp.getContext();
          i = zza(paramzzjp, paramMap, "x", 0);
          j = zza(paramzzjp, paramMap, "y", 0);
          long l = SystemClock.uptimeMillis();
          paramzzjp = MotionEvent.obtain(l, l, 0, i, j, 0);
          if (zzEP != null) {
            zzEP.dispatchTouchEvent(paramzzjp);
          }
          paramzzjp.recycle();
          return;
        }
        if ("currentTime".equals(localObject1))
        {
          paramzzjp = (String)paramMap.get("time");
          if (paramzzjp == null)
          {
            zzin.zzaK("Time parameter missing from currentTime video GMSG.");
            return;
          }
          try
          {
            Float.parseFloat(paramzzjp);
            return;
          }
          catch (NumberFormatException paramMap)
          {
            zzin.zzaK("Could not parse time parameter from currentTime video GMSG: " + paramzzjp);
            return;
          }
        }
        if ("hide".equals(localObject1))
        {
          ((zzk)localObject2).setVisibility(4);
          return;
        }
        if ("load".equals(localObject1))
        {
          ((zzk)localObject2).zzfD();
          return;
        }
        if ("mimetype".equals(localObject1))
        {
          ((zzk)localObject2).setMimeType((String)paramMap.get("mimetype"));
          return;
        }
        if ("muted".equals(localObject1))
        {
          Boolean.parseBoolean((String)paramMap.get("muted"));
          return;
        }
        if (("pause".equals(localObject1)) || ("play".equals(localObject1))) {
          continue;
        }
        if ("show".equals(localObject1))
        {
          ((zzk)localObject2).setVisibility(0);
          return;
        }
        if ("src".equals(localObject1))
        {
          zzzK = ((String)paramMap.get("src"));
          return;
        }
        if ("volume".equals(localObject1))
        {
          paramzzjp = (String)paramMap.get("volume");
          if (paramzzjp == null)
          {
            zzin.zzaK("Level parameter missing from volume video GMSG.");
            return;
          }
          try
          {
            Float.parseFloat(paramzzjp);
            return;
          }
          catch (NumberFormatException paramMap)
          {
            zzin.zzaK("Could not parse volume parameter from volume video GMSG: " + paramzzjp);
            return;
          }
        }
        if ("watermark".equals(localObject1))
        {
          ((zzk)localObject2).zzfE();
          return;
        }
        zzin.zzaK("Unknown video action: " + (String)localObject1);
        return;
      }
      catch (NumberFormatException paramMap)
      {
        for (;;) {}
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */