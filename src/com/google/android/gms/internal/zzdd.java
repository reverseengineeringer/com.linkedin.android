package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

@zzhb
public final class zzdd
  implements zzdf
{
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    Object localObject = (String)paramMap.get("action");
    String str;
    if ("tick".equals(localObject))
    {
      str = (String)paramMap.get("label");
      localObject = (String)paramMap.get("start_label");
      paramMap = (String)paramMap.get("timestamp");
      if (TextUtils.isEmpty(str)) {
        zzin.zzaK("No label given for CSI tick.");
      }
    }
    label226:
    do
    {
      return;
      if (TextUtils.isEmpty(paramMap))
      {
        zzin.zzaK("No timestamp given for CSI tick.");
        return;
      }
      for (;;)
      {
        long l1;
        try
        {
          l1 = Long.parseLong(paramMap);
          long l2 = zzr.zzbG().currentTimeMillis();
          long l3 = zzr.zzbG().elapsedRealtime();
          l1 = l1 - l2 + l3;
          paramMap = (Map<String, String>)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramMap = "native:view_load";
          }
          paramzzjp = paramzzjp.zzic();
          localObject = zzpe;
          paramMap = (zzbz)zzxy.get(paramMap);
          if ((localObject == null) || (paramMap == null))
          {
            paramMap = zzxy;
            paramzzjp = zzpe;
            if (paramzzjp != null) {
              break label226;
            }
            paramzzjp = null;
            paramMap.put(str, paramzzjp);
            return;
          }
        }
        catch (NumberFormatException paramzzjp)
        {
          zzin.zzd("Malformed timestamp for CSI tick.", paramzzjp);
          return;
        }
        ((zzcb)localObject).zza(paramMap, l1, new String[] { str });
        continue;
        paramzzjp = paramzzjp.zzb(l1);
      }
      if ("experiment".equals(localObject))
      {
        paramMap = (String)paramMap.get("value");
        if (TextUtils.isEmpty(paramMap))
        {
          zzin.zzaK("No value given for CSI experiment.");
          return;
        }
        paramzzjp = zziczzpe;
        if (paramzzjp == null)
        {
          zzin.zzaK("No ticker for WebView, dropping experiment ID.");
          return;
        }
        paramzzjp.zzc("e", paramMap);
        return;
      }
    } while (!"extra".equals(localObject));
    localObject = (String)paramMap.get("name");
    paramMap = (String)paramMap.get("value");
    if (TextUtils.isEmpty(paramMap))
    {
      zzin.zzaK("No value given for CSI extra.");
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      zzin.zzaK("No name given for CSI extra.");
      return;
    }
    paramzzjp = zziczzpe;
    if (paramzzjp == null)
    {
      zzin.zzaK("No ticker for WebView, dropping extra parameter.");
      return;
    }
    paramzzjp.zzc((String)localObject, paramMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */