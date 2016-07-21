package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzhb
final class zzjh
{
  final Object zzNm = new Object();
  private final List<Runnable> zzNn = new ArrayList();
  final List<Runnable> zzNo = new ArrayList();
  boolean zzNp = false;
  
  static void zze(Runnable paramRunnable)
  {
    zza.zzMS.post(paramRunnable);
  }
  
  public final void zzhK()
  {
    synchronized (zzNm)
    {
      if (zzNp) {
        return;
      }
      Iterator localIterator1 = zzNn.iterator();
      if (localIterator1.hasNext()) {
        zziq.zza((Runnable)localIterator1.next());
      }
    }
    Iterator localIterator2 = zzNo.iterator();
    while (localIterator2.hasNext()) {
      zze((Runnable)localIterator2.next());
    }
    zzNn.clear();
    zzNo.clear();
    zzNp = true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */