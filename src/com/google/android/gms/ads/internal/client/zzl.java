package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzl
{
  public static String zzuq = null;
  public zzm zzup;
  
  public zzl()
  {
    ClientApi.retainReference();
    if (zzuq != null) {
      try
      {
        zzup = ((zzm)zzl.class.getClassLoader().loadClass(zzuq).newInstance());
        return;
      }
      catch (Exception localException)
      {
        zzb.zzd("Failed to instantiate ClientApi class.", localException);
        zzup = new zzai();
        return;
      }
    }
    zzb.zzaK("No client jar implementation found.");
    zzup = new zzai();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */