package com.googlecode.concurrentlinkedhashmap;

abstract interface Linked<T extends Linked<T>>
{
  public abstract T getNext();
  
  public abstract T getPrevious();
  
  public abstract void setNext(T paramT);
  
  public abstract void setPrevious(T paramT);
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.Linked
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */