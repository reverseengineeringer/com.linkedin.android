package com.googlecode.concurrentlinkedhashmap;

public final class Weighers
{
  private Weighers()
  {
    throw new AssertionError();
  }
  
  static enum SingletonEntryWeigher
    implements EntryWeigher<Object, Object>
  {
    INSTANCE;
    
    private SingletonEntryWeigher() {}
  }
}

/* Location:
 * Qualified Name:     com.googlecode.concurrentlinkedhashmap.Weighers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */