package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzw
{
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static zza zzy(Object paramObject)
  {
    return new zza(paramObject, (byte)0);
  }
  
  public static final class zza
  {
    private final Object zzML;
    private final List<String> zzamp;
    
    private zza(Object paramObject)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */