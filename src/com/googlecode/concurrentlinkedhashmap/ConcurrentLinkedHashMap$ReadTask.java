package com.googlecode.concurrentlinkedhashmap;

class ConcurrentLinkedHashMap$ReadTask
  extends ConcurrentLinkedHashMap.AbstractTask
{
  final ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node node;
  
  ConcurrentLinkedHashMap$ReadTask(ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node paramConcurrentLinkedHashMap)
  {
    super(paramConcurrentLinkedHashMap);
    ConcurrentLinkedHashMap.Node localNode;
    node = localNode;
  }
  
  public boolean isWrite()
  {
    return false;
  }
  
  public void run()
  {
    if (this$0.evictionDeque.contains(node))
    {
      LinkedDeque localLinkedDeque = this$0.evictionDeque;
      ConcurrentLinkedHashMap.Node localNode = node;
      if (localNode != last)
      {
        localLinkedDeque.unlink(localNode);
        localLinkedDeque.linkLast(localNode);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.ReadTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */