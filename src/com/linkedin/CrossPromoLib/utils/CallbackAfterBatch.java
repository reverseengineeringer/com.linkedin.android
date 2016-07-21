package com.linkedin.CrossPromoLib.utils;

import android.util.Log;

public abstract class CallbackAfterBatch
{
  private static final String TAG = CallbackAfterBatch.class.getName();
  private boolean isDoneRegisteringItems = false;
  private int numItemsFetched = 0;
  private int numItemsInSet = 0;
  
  public abstract void callback();
  
  public final void complete()
  {
    try
    {
      numItemsFetched += 1;
      if ((numItemsFetched >= numItemsInSet) && (isDoneRegisteringItems)) {
        callback();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void doneRegisteringItems()
  {
    try
    {
      isDoneRegisteringItems = true;
      if (numItemsFetched >= numItemsInSet) {
        callback();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void register(int paramInt)
  {
    if (paramInt <= 0) {}
    for (;;)
    {
      try
      {
        Log.e(TAG, "Tried to register " + paramInt + " items");
        return;
      }
      finally {}
      if (!isDoneRegisteringItems) {
        numItemsInSet += paramInt;
      } else {
        Log.e(TAG, "Tried to register " + paramInt + " items after doneRegisteringItems() has been called", new IllegalStateException());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.CallbackAfterBatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */