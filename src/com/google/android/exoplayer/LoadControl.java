package com.google.android.exoplayer;

import com.google.android.exoplayer.upstream.Allocator;

public abstract interface LoadControl
{
  public abstract Allocator getAllocator();
  
  public abstract void register(Object paramObject, int paramInt);
  
  public abstract void trimAllocator();
  
  public abstract void unregister(Object paramObject);
  
  public abstract boolean update(Object paramObject, long paramLong1, long paramLong2, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.LoadControl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */