package com.google.android.gms.auth.api.signin.internal;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class zzm$zzb<K, V>
  extends LinkedHashMap<K, V>
{
  private final int zzav = 20;
  
  protected final boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > zzav;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzm.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */