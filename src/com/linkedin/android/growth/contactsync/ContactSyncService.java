package com.linkedin.android.growth.contactsync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.linkedin.android.infra.performance.CrashReporter;

public class ContactSyncService
  extends Service
{
  private static final Object LOCK = new Object();
  private static ContactSyncAdapter syncAdapter;
  
  public IBinder onBind(Intent paramIntent)
  {
    return syncAdapter.getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    CrashReporter.logComponentInfo("Starting service " + ContactSyncService.class.getSimpleName(), null);
    super.onCreate();
    synchronized (LOCK)
    {
      if (syncAdapter == null) {
        syncAdapter = new ContactSyncAdapter(getApplicationContext());
      }
      return;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */