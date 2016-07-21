package com.googlecode.concurrentlinkedhashmap;

abstract interface ConcurrentLinkedHashMap$Task
  extends Runnable
{
  public abstract Task getNext();
  
  public abstract int getOrder();
  
  public abstract boolean isWrite();
  
  public abstract void setNext(Task paramTask);
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Task
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */