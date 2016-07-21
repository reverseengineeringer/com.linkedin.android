package com.linkedin.android.datamanager;

import android.support.v4.util.ArrayMap;

public final class MultiplexRequestException
  extends DataManagerException
{
  public final ArrayMap<String, DataManagerException> requiredRequestFailures;
  
  public MultiplexRequestException(ArrayMap<String, DataManagerException> paramArrayMap)
  {
    super("Required requests failed!", new Object[0]);
    requiredRequestFailures = paramArrayMap;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("Failures:");
    int i = 0;
    while (i < requiredRequestFailures.size())
    {
      DataManagerException localDataManagerException = (DataManagerException)requiredRequestFailures.get(requiredRequestFailures.keyAt(i));
      if (localDataManagerException != null) {
        localStringBuilder.append('\n').append(localDataManagerException.toString());
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.MultiplexRequestException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */