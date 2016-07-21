package com.linkedin.android.datamanager.local;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.data.lite.RecordTemplate;

public abstract interface LocalDataStoreListener<RESPONSE extends RecordTemplate<RESPONSE>>
{
  public abstract void onResponse(RESPONSE paramRESPONSE, DataManagerException paramDataManagerException);
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.local.LocalDataStoreListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */