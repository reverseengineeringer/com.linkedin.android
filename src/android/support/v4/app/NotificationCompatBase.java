package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public final class NotificationCompatBase
{
  public static abstract class Action
  {
    public abstract PendingIntent getActionIntent();
    
    public abstract Bundle getExtras();
    
    public abstract int getIcon();
    
    public abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();
    
    public abstract CharSequence getTitle();
    
    public static abstract interface Factory {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompatBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */