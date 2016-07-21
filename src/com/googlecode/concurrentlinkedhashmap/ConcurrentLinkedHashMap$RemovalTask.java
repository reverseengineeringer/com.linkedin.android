package com.googlecode.concurrentlinkedhashmap;

final class ConcurrentLinkedHashMap$RemovalTask
  extends ConcurrentLinkedHashMap.AbstractTask
{
  final ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node node;
  
  ConcurrentLinkedHashMap$RemovalTask(ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node paramConcurrentLinkedHashMap)
  {
    super(paramConcurrentLinkedHashMap);
    ConcurrentLinkedHashMap.Node localNode;
    node = localNode;
  }
  
  public final boolean isWrite()
  {
    return true;
  }
  
  public final void run()
  {
    this$0.evictionDeque.remove(node);
    node.makeDead();
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.RemovalTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */