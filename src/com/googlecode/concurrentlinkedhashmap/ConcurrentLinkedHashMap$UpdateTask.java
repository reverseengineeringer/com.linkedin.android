package com.googlecode.concurrentlinkedhashmap;

final class ConcurrentLinkedHashMap$UpdateTask
  extends ConcurrentLinkedHashMap.ReadTask
{
  final int weightDifference;
  
  public ConcurrentLinkedHashMap$UpdateTask(ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node paramConcurrentLinkedHashMap, int paramInt)
  {
    super(paramConcurrentLinkedHashMap, paramInt);
    int i;
    weightDifference = i;
  }
  
  public final boolean isWrite()
  {
    return true;
  }
  
  public final void run()
  {
    super.run();
    ConcurrentLinkedHashMap localConcurrentLinkedHashMap = this$0;
    weightedSize += weightDifference;
    this$0.evict();
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.UpdateTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */