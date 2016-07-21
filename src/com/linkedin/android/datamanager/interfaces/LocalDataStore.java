package com.linkedin.android.datamanager.interfaces;

import com.linkedin.android.datamanager.DataRequest;
import com.linkedin.android.datamanager.local.LocalDataStoreListener;
import com.linkedin.data.lite.RecordTemplate;

public abstract interface LocalDataStore
  extends DataStore
{
  public abstract <RESPONSE extends RecordTemplate<RESPONSE>> void execute(DataRequest<RESPONSE> paramDataRequest, LocalDataStoreListener<RESPONSE> paramLocalDataStoreListener);
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.interfaces.LocalDataStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */