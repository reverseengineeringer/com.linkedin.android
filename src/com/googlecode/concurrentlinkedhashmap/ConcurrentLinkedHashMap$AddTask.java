package com.googlecode.concurrentlinkedhashmap;

final class ConcurrentLinkedHashMap$AddTask
  extends ConcurrentLinkedHashMap.AbstractTask
{
  final ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node node;
  final int weight = 1;
  
  ConcurrentLinkedHashMap$AddTask(ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node paramConcurrentLinkedHashMap, int paramInt)
  {
    super(paramConcurrentLinkedHashMap);
    node = paramInt;
  }
  
  public final boolean isWrite()
  {
    return true;
  }
  
  public final void run()
  {
    ConcurrentLinkedHashMap localConcurrentLinkedHashMap = this$0;
    weightedSize += weight;
    if (((ConcurrentLinkedHashMap.WeightedValue)node.get()).isAlive())
    {
      this$0.evictionDeque.offerLast(node);
      this$0.evict();
    }
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.AddTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */