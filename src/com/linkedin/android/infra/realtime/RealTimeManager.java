package com.linkedin.android.infra.realtime;

import android.content.Context;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.realtime.interfaces.RealTimeCallbackInterface;
import com.linkedin.android.realtime.interfaces.RealTimeInterface;
import javax.inject.Inject;

public class RealTimeManager
{
  private static final String TAG = RealTimeManager.class.getCanonicalName();
  public final Context context;
  private int currentState = 0;
  public final LixManager lixManager;
  public final NetworkClient networkClient;
  public RealTimeInterface realTime;
  public final RealTimeCallbackInterface realTimeCallbackInterface = new RealTimeManager.1(this);
  public final TopicRegistry topicRegistry;
  private final Tracker tracker;
  
  @Inject
  public RealTimeManager(Tracker paramTracker, LixManager paramLixManager, NetworkClient paramNetworkClient, Context paramContext, TopicRegistry paramTopicRegistry)
  {
    tracker = paramTracker;
    lixManager = paramLixManager;
    context = paramContext;
    networkClient = paramNetworkClient;
    topicRegistry = paramTopicRegistry;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.realtime.RealTimeManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */