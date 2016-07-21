package com.googlecode.concurrentlinkedhashmap;

abstract class ConcurrentLinkedHashMap$AbstractTask
  implements ConcurrentLinkedHashMap.Task
{
  final int order;
  ConcurrentLinkedHashMap.Task task;
  
  ConcurrentLinkedHashMap$AbstractTask(ConcurrentLinkedHashMap paramConcurrentLinkedHashMap)
  {
    int i = nextOrder;
    nextOrder = (i + 1);
    order = i;
  }
  
  public final ConcurrentLinkedHashMap.Task getNext()
  {
    return task;
  }
  
  public final int getOrder()
  {
    return order;
  }
  
  public final void setNext(ConcurrentLinkedHashMap.Task paramTask)
  {
    task = paramTask;
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.AbstractTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */