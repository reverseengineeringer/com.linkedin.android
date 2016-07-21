package com.google.android.exoplayer.upstream;

public abstract interface Allocator
{
  public abstract Allocation allocate();
  
  public abstract void blockWhileTotalBytesAllocatedExceeds(int paramInt)
    throws InterruptedException;
  
  public abstract int getIndividualAllocationLength();
  
  public abstract int getTotalBytesAllocated();
  
  public abstract void release(Allocation paramAllocation);
  
  public abstract void trim(int paramInt);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.Allocator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */