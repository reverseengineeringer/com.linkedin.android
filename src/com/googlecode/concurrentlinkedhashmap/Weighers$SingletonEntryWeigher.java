package com.googlecode.concurrentlinkedhashmap;

 enum Weighers$SingletonEntryWeigher
  implements EntryWeigher<Object, Object>
{
  INSTANCE;
  
  private Weighers$SingletonEntryWeigher() {}
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.Weighers.SingletonEntryWeigher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */