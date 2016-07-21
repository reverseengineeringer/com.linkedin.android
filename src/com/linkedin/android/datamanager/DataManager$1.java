package com.linkedin.android.datamanager;

import com.linkedin.android.datamanager.interfaces.LocalDataStore;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;

final class DataManager$1
  implements Runnable
{
  DataManager$1(DataManager paramDataManager, DataRequest paramDataRequest, LocalDataStore paramLocalDataStore, RecordTemplateListener paramRecordTemplateListener) {}
  
  public final void run()
  {
    this$0.executeLocalRequest(val$request, val$dataStore, val$listener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.DataManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */