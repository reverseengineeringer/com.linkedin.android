package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class zzmm<E>
  extends AbstractSet<E>
{
  private final ArrayMap<E, E> zzanZ;
  
  public zzmm()
  {
    zzanZ = new ArrayMap();
  }
  
  private zzmm(int paramInt)
  {
    zzanZ = new ArrayMap(paramInt);
  }
  
  public zzmm(Collection<E> paramCollection)
  {
    this(paramCollection.size());
    addAll(paramCollection);
  }
  
  private boolean zza(zzmm<? extends E> paramzzmm)
  {
    int i = size();
    zzanZ.putAll(zzanZ);
    return size() > i;
  }
  
  public final boolean add(E paramE)
  {
    if (zzanZ.containsKey(paramE)) {
      return false;
    }
    zzanZ.put(paramE, paramE);
    return true;
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof zzmm)) {
      return zza((zzmm)paramCollection);
    }
    return super.addAll(paramCollection);
  }
  
  public final void clear()
  {
    zzanZ.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return zzanZ.containsKey(paramObject);
  }
  
  public final Iterator<E> iterator()
  {
    return zzanZ.keySet().iterator();
  }
  
  public final boolean remove(Object paramObject)
  {
    if (!zzanZ.containsKey(paramObject)) {
      return false;
    }
    zzanZ.remove(paramObject);
    return true;
  }
  
  public final int size()
  {
    return zzanZ.size();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */