package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzw$zza
{
  private final Object zzML;
  private final List<String> zzamp;
  
  private zzw$zza(Object paramObject)
  {
    zzML = zzx.zzz(paramObject);
    zzamp = new ArrayList();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100).append(zzML.getClass().getSimpleName()).append('{');
    int j = zzamp.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)zzamp.get(i));
      if (i < j - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    return '}';
  }
  
  public final zza zzg(String paramString, Object paramObject)
  {
    zzamp.add((String)zzx.zzz(paramString) + "=" + String.valueOf(paramObject));
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzw.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */