package com.google.android.gms.internal;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class zzkj
{
  private static zzpm.zzb zzb(String paramString, Bundle paramBundle)
  {
    zzpm.zzb localzzb = new zzpm.zzb();
    name = paramString;
    zzaMt = new zzpm.zzd();
    zzaMt.zzaMy = zzg(paramBundle);
    return localzzb;
  }
  
  static zzpm.zzc zzg(Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramBundle.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str1 = (String)((Iterator)localObject1).next();
      Object localObject2 = paramBundle.get(str1);
      if ((localObject2 instanceof String))
      {
        localArrayList.add(zzp(str1, (String)localObject2));
      }
      else if ((localObject2 instanceof Bundle))
      {
        localArrayList.add(zzb(str1, (Bundle)localObject2));
      }
      else
      {
        int j;
        int i;
        String str2;
        if ((localObject2 instanceof String[]))
        {
          localObject2 = (String[])localObject2;
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            str2 = localObject2[i];
            if (str2 != null) {
              localArrayList.add(zzp(str1, str2));
            }
            i += 1;
          }
        }
        else if ((localObject2 instanceof Bundle[]))
        {
          localObject2 = (Bundle[])localObject2;
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            str2 = localObject2[i];
            if (str2 != null) {
              localArrayList.add(zzb(str1, str2));
            }
            i += 1;
          }
        }
        else if ((localObject2 instanceof Boolean))
        {
          boolean bool = ((Boolean)localObject2).booleanValue();
          localObject2 = new zzpm.zzb();
          name = str1;
          zzaMt = new zzpm.zzd();
          zzaMt.zzaMv = bool;
          localArrayList.add(localObject2);
        }
        else
        {
          Log.e("SearchIndex", "Unsupported value: " + localObject2);
        }
      }
    }
    localObject1 = new zzpm.zzc();
    if (paramBundle.containsKey("type")) {
      type = paramBundle.getString("type");
    }
    zzaMu = ((zzpm.zzb[])localArrayList.toArray(new zzpm.zzb[localArrayList.size()]));
    return (zzpm.zzc)localObject1;
  }
  
  private static zzpm.zzb zzp(String paramString1, String paramString2)
  {
    zzpm.zzb localzzb = new zzpm.zzb();
    name = paramString1;
    zzaMt = new zzpm.zzd();
    zzaMt.zzamJ = paramString2;
    return localzzb;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */