package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class zzh$zzc
  extends zzh.zzf
{
  private final ArrayList<Api.zzb> zzahH;
  
  public zzh$zzc(ArrayList<Api.zzb> paramArrayList)
  {
    super(paramArrayList, (byte)0);
    ArrayList localArrayList;
    zzahH = localArrayList;
  }
  
  public final void zzpt()
  {
    zzj localzzj = zzahC.zzahj.zzagW;
    zzh localzzh = zzahC;
    Object localObject;
    if (zzahz == null) {
      localObject = Collections.emptySet();
    }
    for (;;)
    {
      zzahU = ((Set)localObject);
      localObject = zzahH.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Api.zzb)((Iterator)localObject).next()).zza(zzahC.zzahw, zzahC.zzahj.zzagW.zzahU);
      }
      localObject = new HashSet(zzahz.zzagh);
      Map localMap = zzahz.zzalc;
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Api localApi = (Api)localIterator.next();
        if (!zzahj.zzaio.containsKey(localApi.zzoR())) {
          ((Set)localObject).addAll(getzzXf);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzh.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */