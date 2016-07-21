package com.linkedin.android.datamanager.net;

import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.NetworkDataStore;

public abstract class DefaultNetworkDataStore
  implements NetworkDataStore
{
  private static final String ID = DefaultNetworkDataStore.class.getSimpleName();
  
  public final int getPrecedence()
  {
    return 80;
  }
  
  public final DataStore.Type getType()
  {
    return DataStore.Type.NETWORK;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.net.DefaultNetworkDataStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */