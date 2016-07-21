package com.googlecode.concurrentlinkedhashmap;

import java.util.concurrent.atomic.AtomicReference;

final class ConcurrentLinkedHashMap$Node
  extends AtomicReference<ConcurrentLinkedHashMap.WeightedValue<V>>
  implements Linked<ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node>
{
  final K key;
  ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node next;
  ConcurrentLinkedHashMap<K, V>.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node prev;
  
  ConcurrentLinkedHashMap$Node(K paramK, ConcurrentLinkedHashMap.WeightedValue<V> paramWeightedValue)
  {
    super(localObject);
    key = paramWeightedValue;
  }
  
  final V getValue()
  {
    return (V)getvalue;
  }
  
  final void makeDead()
  {
    ConcurrentLinkedHashMap.WeightedValue localWeightedValue;
    do
    {
      localWeightedValue = (ConcurrentLinkedHashMap.WeightedValue)get();
    } while (!compareAndSet(localWeightedValue, new ConcurrentLinkedHashMap.WeightedValue(value, 0)));
    ConcurrentLinkedHashMap localConcurrentLinkedHashMap = this$0;
    weightedSize -= Math.abs(weight);
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Node
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */