package com.googlecode.concurrentlinkedhashmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

final class ConcurrentLinkedHashMap$ValueIterator
  implements Iterator<V>
{
  ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node current;
  final Iterator<ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node> iterator = this$0.data.values().iterator();
  
  ConcurrentLinkedHashMap$ValueIterator(ConcurrentLinkedHashMap paramConcurrentLinkedHashMap) {}
  
  public final boolean hasNext()
  {
    return iterator.hasNext();
  }
  
  public final V next()
  {
    current = ((ConcurrentLinkedHashMap.Node)iterator.next());
    return (V)current.getValue();
  }
  
  public final void remove()
  {
    if (current != null) {}
    for (boolean bool = true;; bool = false)
    {
      ConcurrentLinkedHashMap.checkState(bool);
      this$0.remove(current.key);
      current = null;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.ValueIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */