package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public class zzab
  extends zzk<String>
{
  private final zzm.zzb<String> zzaG;
  
  private zzab(String paramString, zzm.zzb<String> paramzzb, zzm.zza paramzza)
  {
    super(paramString, paramzza);
    zzaG = paramzzb;
  }
  
  public zzab(String paramString, zzm.zzb<String> paramzzb, zzm.zza paramzza, byte paramByte)
  {
    this(paramString, paramzzb, paramzza);
  }
  
  protected final zzm<String> zza(zzi paramzzi)
  {
    try
    {
      String str1 = new String(data, zzx.zzb(zzA, "ISO-8859-1"));
      return new zzm(str1, zzx.zzb(paramzzi));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2 = new String(data);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */