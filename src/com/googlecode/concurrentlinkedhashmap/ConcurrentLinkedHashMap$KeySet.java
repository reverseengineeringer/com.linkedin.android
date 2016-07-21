package com.googlecode.concurrentlinkedhashmap;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

final class ConcurrentLinkedHashMap$KeySet
  extends AbstractSet<K>
{
  final ConcurrentLinkedHashMap<K, V> map = this$0;
  
  ConcurrentLinkedHashMap$KeySet(ConcurrentLinkedHashMap paramConcurrentLinkedHashMap) {}
  
  public final void clear()
  {
    map.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return this$0.containsKey(paramObject);
  }
  
  public final Iterator<K> iterator()
  {
    return new ConcurrentLinkedHashMap.KeyIterator(this$0);
  }
  
  public final boolean remove(Object paramObject)
  {
    return map.remove(paramObject) != null;
  }
  
  public final int size()
  {
    return map.size();
  }
  
  public final Object[] toArray()
  {
    return map.data.keySet().toArray();
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    return map.data.keySet().toArray(paramArrayOfT);
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.KeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */