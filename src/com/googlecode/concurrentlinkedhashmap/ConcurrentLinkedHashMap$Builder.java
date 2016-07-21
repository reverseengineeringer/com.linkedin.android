package com.googlecode.concurrentlinkedhashmap;

public final class ConcurrentLinkedHashMap$Builder<K, V>
{
  long capacity = -1L;
  int concurrencyLevel = 16;
  int initialCapacity = 16;
  EvictionListener<K, V> listener = ConcurrentLinkedHashMap.DiscardingListener.INSTANCE;
  EntryWeigher<? super K, ? super V> weigher = Weighers.SingletonEntryWeigher.INSTANCE;
  
  public final ConcurrentLinkedHashMap<K, V> build()
  {
    if (capacity >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ConcurrentLinkedHashMap.checkState(bool);
      return new ConcurrentLinkedHashMap(this, (byte)0);
    }
  }
  
  public final Builder<K, V> initialCapacity$5a8ffd72()
  {
    ConcurrentLinkedHashMap.checkArgument(true);
    initialCapacity = 50;
    return this;
  }
  
  public final Builder<K, V> maximumWeightedCapacity$401f0453()
  {
    if (50L >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ConcurrentLinkedHashMap.checkArgument(bool);
      capacity = 50L;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */