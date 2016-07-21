package com.linkedin.android.infra.app;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;

@Deprecated
public abstract interface DataProvider$DataProviderListener
{
  public abstract void onDataFinishedLoading(DataStore.Type paramType, DataManagerException paramDataManagerException);
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.DataProvider.DataProviderListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */