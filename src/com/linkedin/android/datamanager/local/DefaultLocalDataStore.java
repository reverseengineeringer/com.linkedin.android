package com.linkedin.android.datamanager.local;

import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.LocalDataStore;

public abstract class DefaultLocalDataStore
  implements LocalDataStore
{
  private static final String ID = DefaultLocalDataStore.class.getSimpleName();
  
  public final int getPrecedence()
  {
    return 50;
  }
  
  public final DataStore.Type getType()
  {
    return DataStore.Type.LOCAL;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.local.DefaultLocalDataStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */