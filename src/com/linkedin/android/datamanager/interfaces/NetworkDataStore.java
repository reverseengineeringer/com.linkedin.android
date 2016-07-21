package com.linkedin.android.datamanager.interfaces;

import com.linkedin.android.datamanager.DataRequest;
import com.linkedin.android.datamanager.net.NetworkResponseListener;
import com.linkedin.data.lite.RecordTemplate;

public abstract interface NetworkDataStore
  extends DataStore
{
  public abstract <RESPONSE extends RecordTemplate<RESPONSE>> void execute(DataRequest<RESPONSE> paramDataRequest, NetworkResponseListener<RESPONSE> paramNetworkResponseListener);
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.interfaces.NetworkDataStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */