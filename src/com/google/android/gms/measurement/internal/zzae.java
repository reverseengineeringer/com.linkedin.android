package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpz.zzf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzae
{
  final boolean zzaXg;
  final int zzaZh;
  final boolean zzaZi;
  final String zzaZj;
  final List<String> zzaZk;
  final String zzaZl;
  
  public zzae(zzpz.zzf paramzzf)
  {
    zzx.zzz(paramzzf);
    boolean bool1;
    if ((zzaZN == null) || (zzaZN.intValue() == 0)) {
      bool1 = false;
    }
    for (;;)
    {
      if (bool1)
      {
        zzaZh = zzaZN.intValue();
        boolean bool2 = bool3;
        if (zzaZP != null)
        {
          bool2 = bool3;
          if (zzaZP.booleanValue()) {
            bool2 = true;
          }
        }
        zzaZi = bool2;
        if ((zzaZi) || (zzaZh == 1) || (zzaZh == 6))
        {
          zzaZj = zzaZO;
          label108:
          if (zzaZQ != null) {
            break label205;
          }
          paramzzf = null;
          label117:
          zzaZk = paramzzf;
          if (zzaZh != 1) {
            break label220;
          }
          zzaZl = zzaZj;
        }
      }
      for (;;)
      {
        zzaXg = bool1;
        return;
        if (zzaZN.intValue() == 6)
        {
          if ((zzaZQ != null) && (zzaZQ.length != 0)) {
            break label256;
          }
          bool1 = false;
          break;
        }
        if (zzaZO != null) {
          break label256;
        }
        bool1 = false;
        break;
        zzaZj = zzaZO.toUpperCase(Locale.ENGLISH);
        break label108;
        label205:
        paramzzf = zza(zzaZQ, zzaZi);
        break label117;
        label220:
        zzaZl = null;
        continue;
        zzaZh = 0;
        zzaZi = false;
        zzaZj = null;
        zzaZk = null;
        zzaZl = null;
      }
      label256:
      bool1 = true;
    }
  }
  
  private static List<String> zza(String[] paramArrayOfString, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = Arrays.asList(paramArrayOfString);
      return (List<String>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(paramArrayOfString[i].toUpperCase(Locale.ENGLISH));
      i += 1;
    }
  }
  
  public final Boolean zzfp(String paramString)
  {
    if (!zzaXg) {
      return null;
    }
    String str = paramString;
    if (!zzaZi)
    {
      if (zzaZh != 1) {
        break label102;
      }
      str = paramString;
    }
    switch (zzaZh)
    {
    default: 
      return null;
    case 1: 
      if (zzaZi) {}
      for (int i = 0;; i = 66)
      {
        return Boolean.valueOf(Pattern.compile(zzaZl, i).matcher(str).matches());
        str = paramString.toUpperCase(Locale.ENGLISH);
        break;
      }
    case 2: 
      return Boolean.valueOf(str.startsWith(zzaZj));
    case 3: 
      return Boolean.valueOf(str.endsWith(zzaZj));
    case 4: 
      return Boolean.valueOf(str.contains(zzaZj));
    case 5: 
      label102:
      return Boolean.valueOf(str.equals(zzaZj));
    }
    return Boolean.valueOf(zzaZk.contains(str));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */