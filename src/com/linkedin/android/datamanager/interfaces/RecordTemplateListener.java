package com.linkedin.android.datamanager.interfaces;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.data.lite.RecordTemplate;

public abstract interface RecordTemplateListener<RESPONSE extends RecordTemplate<RESPONSE>>
{
  public abstract void onResponse(DataStoreResponse<RESPONSE> paramDataStoreResponse);
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.interfaces.RecordTemplateListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */