package com.linkedin.android.feed.promptresponselist;

import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.video.ISystemDelegate;
import com.linkedin.android.video.tracking.IPlayerEventTracker;

public class PlayerLibDelegate
  implements ISystemDelegate, IPlayerEventTracker
{
  private static PlayerLibDelegate singleton;
  private ApplicationComponent appComponent;
  
  private PlayerLibDelegate(ApplicationComponent paramApplicationComponent)
  {
    appComponent = paramApplicationComponent;
  }
  
  public static PlayerLibDelegate getInstance(ApplicationComponent paramApplicationComponent)
  {
    if (singleton == null) {}
    try
    {
      if (singleton == null) {
        singleton = new PlayerLibDelegate(paramApplicationComponent);
      }
      return singleton;
    }
    finally {}
  }
  
  public AudioManager getAudioManager()
  {
    return (AudioManager)appComponent.appContext().getSystemService("audio");
  }
  
  public ConnectivityManager getConnectivityManager()
  {
    return (ConnectivityManager)appComponent.appContext().getSystemService("connectivity");
  }
  
  public TelephonyManager getTelephonyManager()
  {
    return (TelephonyManager)appComponent.appContext().getSystemService("phone");
  }
  
  public void sendEvent(TrackingEventBuilder paramTrackingEventBuilder)
  {
    appComponent.tracker().send(paramTrackingEventBuilder);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.PlayerLibDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */