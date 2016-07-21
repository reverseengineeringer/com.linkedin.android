package com.googlecode.concurrentlinkedhashmap;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

final class ConcurrentLinkedHashMap$KeyIterator
  implements Iterator<K>
{
  K current;
  final Iterator<K> iterator = this$0.data.keySet().iterator();
  
  ConcurrentLinkedHashMap$KeyIterator(ConcurrentLinkedHashMap paramConcurrentLinkedHashMap) {}
  
  public final boolean hasNext()
  {
    return iterator.hasNext();
  }
  
  public final K next()
  {
    current = iterator.next();
    return (K)current;
  }
  
  public final void remove()
  {
    if (current != null) {}
    for (boolean bool = true;; bool = false)
    {
      ConcurrentLinkedHashMap.checkState(bool);
      this$0.remove(current);
      current = null;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.KeyIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */