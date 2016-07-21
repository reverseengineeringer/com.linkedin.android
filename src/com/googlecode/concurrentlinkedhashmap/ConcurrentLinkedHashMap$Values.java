package com.googlecode.concurrentlinkedhashmap;

import java.util.AbstractCollection;
import java.util.Iterator;

final class ConcurrentLinkedHashMap$Values
  extends AbstractCollection<V>
{
  ConcurrentLinkedHashMap$Values(ConcurrentLinkedHashMap paramConcurrentLinkedHashMap) {}
  
  public final void clear()
  {
    this$0.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return this$0.containsValue(paramObject);
  }
  
  public final Iterator<V> iterator()
  {
    return new ConcurrentLinkedHashMap.ValueIterator(this$0);
  }
  
  public final int size()
  {
    return this$0.size();
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Values
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */