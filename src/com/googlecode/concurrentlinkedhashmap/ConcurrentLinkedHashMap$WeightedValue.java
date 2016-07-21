package com.googlecode.concurrentlinkedhashmap;

final class ConcurrentLinkedHashMap$WeightedValue<V>
{
  final V value;
  final int weight;
  
  ConcurrentLinkedHashMap$WeightedValue(V paramV, int paramInt)
  {
    weight = paramInt;
    value = paramV;
  }
  
  final boolean hasValue(Object paramObject)
  {
    return (paramObject == value) || (value.equals(paramObject));
  }
  
  final boolean isAlive()
  {
    return weight > 0;
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.WeightedValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */