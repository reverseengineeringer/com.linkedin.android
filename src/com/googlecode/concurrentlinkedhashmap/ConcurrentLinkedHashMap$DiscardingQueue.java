package com.googlecode.concurrentlinkedhashmap;

import java.util.AbstractQueue;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class ConcurrentLinkedHashMap$DiscardingQueue
  extends AbstractQueue<Object>
{
  public final boolean add(Object paramObject)
  {
    return true;
  }
  
  public final Iterator<Object> iterator()
  {
    return Collections.emptyList().iterator();
  }
  
  public final boolean offer(Object paramObject)
  {
    return true;
  }
  
  public final Object peek()
  {
    return null;
  }
  
  public final Object poll()
  {
    return null;
  }
  
  public final int size()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DiscardingQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */