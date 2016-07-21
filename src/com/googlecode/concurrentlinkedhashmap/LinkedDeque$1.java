package com.googlecode.concurrentlinkedhashmap;

final class LinkedDeque$1
  extends LinkedDeque.AbstractLinkedIterator
{
  LinkedDeque$1(LinkedDeque paramLinkedDeque, Linked paramLinked)
  {
    super(paramLinkedDeque, paramLinked);
  }
  
  final E computeNext()
  {
    return cursor.getNext();
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.LinkedDeque.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */