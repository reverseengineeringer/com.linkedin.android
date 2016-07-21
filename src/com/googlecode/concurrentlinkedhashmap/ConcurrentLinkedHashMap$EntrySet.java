package com.googlecode.concurrentlinkedhashmap;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

final class ConcurrentLinkedHashMap$EntrySet
  extends AbstractSet<Map.Entry<K, V>>
{
  final ConcurrentLinkedHashMap<K, V> map = this$0;
  
  ConcurrentLinkedHashMap$EntrySet(ConcurrentLinkedHashMap paramConcurrentLinkedHashMap) {}
  
  public final void clear()
  {
    map.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    ConcurrentLinkedHashMap.Node localNode;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      localNode = (ConcurrentLinkedHashMap.Node)map.data.get(((Map.Entry)paramObject).getKey());
    } while ((localNode == null) || (!localNode.getValue().equals(((Map.Entry)paramObject).getValue())));
    return true;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    return new ConcurrentLinkedHashMap.EntryIterator(this$0);
  }
  
  public final boolean remove(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    return map.remove(((Map.Entry)paramObject).getKey(), ((Map.Entry)paramObject).getValue());
  }
  
  public final int size()
  {
    return map.size();
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */