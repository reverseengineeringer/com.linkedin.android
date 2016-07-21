package com.linkedin.android.litrackinglib.network;

final class MetricQueueIntentService$DelayTracker
{
  private long timeToFire = 0L;
  private int timesThroughThisMethod = 0;
  
  public final long getTimeToFire()
  {
    try
    {
      long l = timeToFire;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int getTimesThroughThisMethod()
  {
    try
    {
      int i = timesThroughThisMethod;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean isDelayed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/linkedin/android/litrackinglib/network/MetricQueueIntentService$DelayTracker:timesThroughThisMethod	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifle +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	DelayTracker
    //   6	2	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final void reset()
  {
    try
    {
      timeToFire = 0L;
      timesThroughThisMethod = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void updateTimeToFire()
  {
    try
    {
      timesThroughThisMethod += 1;
      timeToFire = (System.currentTimeMillis() + MetricQueueIntentService.access$500() * timesThroughThisMethod);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.litrackinglib.network.MetricQueueIntentService.DelayTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */