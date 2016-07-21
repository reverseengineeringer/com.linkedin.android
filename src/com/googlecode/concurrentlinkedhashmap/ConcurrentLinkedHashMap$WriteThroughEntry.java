package com.googlecode.concurrentlinkedhashmap;

import java.util.AbstractMap.SimpleEntry;

final class ConcurrentLinkedHashMap$WriteThroughEntry
  extends AbstractMap.SimpleEntry<K, V>
{
  ConcurrentLinkedHashMap$WriteThroughEntry(ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node paramConcurrentLinkedHashMap)
  {
    super(key, ((ConcurrentLinkedHashMap.Node)localObject).getValue());
  }
  
  public final V setValue(V paramV)
  {
    this$0.put(getKey(), paramV);
    return (V)super.setValue(paramV);
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.WriteThroughEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */