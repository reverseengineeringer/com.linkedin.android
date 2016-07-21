package com.linkedin.android.growth.contactsync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.linkedin.android.infra.performance.CrashReporter;

public class AuthenticatorService
  extends Service
{
  private Authenticator authenticator;
  
  public IBinder onBind(Intent paramIntent)
  {
    return authenticator.getIBinder();
  }
  
  public void onCreate()
  {
    CrashReporter.logComponentInfo("Starting service " + AuthenticatorService.class.getSimpleName(), null);
    super.onCreate();
    authenticator = new Authenticator(this);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.AuthenticatorService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */