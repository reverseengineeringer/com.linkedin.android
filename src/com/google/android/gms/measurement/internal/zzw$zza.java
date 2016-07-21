package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqb.zzb;
import com.google.android.gms.internal.zzqb.zze;
import java.util.ArrayList;
import java.util.List;

final class zzw$zza
  implements zze.zzb
{
  zzqb.zze zzaYt;
  List<Long> zzaYu;
  long zzaYv;
  List<zzqb.zzb> zzpH;
  
  private zzw$zza(zzw paramzzw) {}
  
  private static long zza(zzqb.zzb paramzzb)
  {
    return zzbaf.longValue() / 1000L / 60L / 60L;
  }
  
  public final boolean zza(long paramLong, zzqb.zzb paramzzb)
  {
    zzx.zzz(paramzzb);
    if (zzpH == null) {
      zzpH = new ArrayList();
    }
    if (zzaYu == null) {
      zzaYu = new ArrayList();
    }
    if ((zzpH.size() > 0) && (zza((zzqb.zzb)zzpH.get(0)) != zza(paramzzb))) {
      return false;
    }
    long l = zzaYv + paramzzb.getSerializedSize();
    if (l >= zzd.zzBT()) {
      return false;
    }
    zzaYv = l;
    zzpH.add(paramzzb);
    zzaYu.add(Long.valueOf(paramLong));
    return zzpH.size() < zzd.zzBU();
  }
  
  public final void zzc(zzqb.zze paramzze)
  {
    zzx.zzz(paramzze);
    zzaYt = paramzze;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzw.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */