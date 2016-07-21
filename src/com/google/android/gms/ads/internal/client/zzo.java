package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzhb;
import java.util.Random;

@zzhb
public final class zzo
  extends zzx.zza
{
  private Object zzpV = new Object();
  private final Random zzuy = new Random();
  private long zzuz;
  
  public zzo()
  {
    zzcY();
  }
  
  private void zzcY()
  {
    Object localObject1 = zzpV;
    int i = 3;
    long l1 = 0L;
    for (;;)
    {
      int j = i - 1;
      if (j > 0) {}
      try
      {
        long l2 = zzuy.nextInt() + 2147483648L;
        l1 = l2;
        i = j;
        if (l2 == zzuz) {
          continue;
        }
        l1 = l2;
        i = j;
        if (l2 == 0L) {
          continue;
        }
        l1 = l2;
        zzuz = l1;
        return;
      }
      finally {}
    }
  }
  
  public final long getValue()
  {
    return zzuz;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */