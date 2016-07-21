package com.googlecode.concurrentlinkedhashmap;

import java.util.Iterator;

abstract class LinkedDeque$AbstractLinkedIterator
  implements Iterator<E>
{
  E cursor;
  
  LinkedDeque$AbstractLinkedIterator(E paramE)
  {
    Linked localLinked;
    cursor = localLinked;
  }
  
  abstract E computeNext();
  
  public boolean hasNext()
  {
    return cursor != null;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.LinkedDeque.AbstractLinkedIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */