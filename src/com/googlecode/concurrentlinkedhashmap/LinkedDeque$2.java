package com.googlecode.concurrentlinkedhashmap;

final class LinkedDeque$2
  extends LinkedDeque.AbstractLinkedIterator
{
  LinkedDeque$2(LinkedDeque paramLinkedDeque, Linked paramLinked)
  {
    super(paramLinkedDeque, paramLinked);
  }
  
  final E computeNext()
  {
    return cursor.getPrevious();
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.LinkedDeque.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */