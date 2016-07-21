package com.linkedin.android.datamanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class DataRequestList
{
  private final List<DataRequest<?>> mList = new ArrayList();
  
  public final boolean add(DataRequest<?> paramDataRequest)
  {
    try
    {
      boolean bool = mList.add(paramDataRequest);
      return bool;
    }
    finally
    {
      paramDataRequest = finally;
      throw paramDataRequest;
    }
  }
  
  public final boolean contains(DataRequest<?> paramDataRequest)
  {
    try
    {
      boolean bool = mList.contains(paramDataRequest);
      return bool;
    }
    finally
    {
      paramDataRequest = finally;
      throw paramDataRequest;
    }
  }
  
  /* Error */
  public final <RESPONSE extends com.linkedin.data.lite.RecordTemplate<RESPONSE>> DataRequest<RESPONSE> getOngoingRequest(DataRequest<RESPONSE> paramDataRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/linkedin/android/datamanager/DataRequestList:mList	Ljava/util/List;
    //   6: invokeinterface 35 1 0
    //   11: astore 4
    //   13: aload 4
    //   15: invokeinterface 41 1 0
    //   20: ifeq +30 -> 50
    //   23: aload 4
    //   25: invokeinterface 45 1 0
    //   30: checkcast 47	com/linkedin/android/datamanager/DataRequest
    //   33: astore_3
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 50	com/linkedin/android/datamanager/DataRequest:equals	(Ljava/lang/Object;)Z
    //   39: istore_2
    //   40: iload_2
    //   41: ifeq -28 -> 13
    //   44: aload_3
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: areturn
    //   50: aconst_null
    //   51: astore_1
    //   52: goto -6 -> 46
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	DataRequestList
    //   0	60	1	paramDataRequest	DataRequest<RESPONSE>
    //   39	2	2	bool	boolean
    //   33	12	3	localDataRequest	DataRequest
    //   11	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	55	finally
    //   13	40	55	finally
  }
  
  public final boolean isEmpty()
  {
    try
    {
      boolean bool = mList.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean remove(DataRequest<?> paramDataRequest)
  {
    try
    {
      boolean bool = mList.remove(paramDataRequest);
      return bool;
    }
    finally
    {
      paramDataRequest = finally;
      throw paramDataRequest;
    }
  }
  
  public final boolean removeWithLowerPrecedence(int paramInt)
  {
    boolean bool = false;
    try
    {
      Iterator localIterator = mList.iterator();
      while (localIterator.hasNext()) {
        if (((DataRequest)localIterator.next()).getPrecedence() < paramInt)
        {
          localIterator.remove();
          bool = true;
        }
      }
      return bool;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.DataRequestList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */