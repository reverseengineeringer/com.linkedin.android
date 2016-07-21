package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AdvertisingInfo;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.events.EventsStorageListener;
import io.fabric.sdk.android.services.events.GZIPQueueFileEventStorage;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public final class AnswersEventsHandler
  implements EventsStorageListener
{
  final Context context;
  final ScheduledExecutorService executor;
  final AnswersFilesManagerProvider filesManagerProvider;
  final Kit kit;
  final SessionMetadataCollector metadataCollector;
  final HttpRequestFactory requestFactory;
  SessionAnalyticsManagerStrategy strategy = new DisabledSessionAnalyticsManagerStrategy();
  
  public AnswersEventsHandler(Kit paramKit, Context paramContext, AnswersFilesManagerProvider paramAnswersFilesManagerProvider, SessionMetadataCollector paramSessionMetadataCollector, HttpRequestFactory paramHttpRequestFactory, ScheduledExecutorService paramScheduledExecutorService)
  {
    kit = paramKit;
    context = paramContext;
    filesManagerProvider = paramAnswersFilesManagerProvider;
    metadataCollector = paramSessionMetadataCollector;
    requestFactory = paramHttpRequestFactory;
    executor = paramScheduledExecutorService;
  }
  
  final void executeAsync(Runnable paramRunnable)
  {
    try
    {
      executor.submit(paramRunnable);
      return;
    }
    catch (Exception paramRunnable)
    {
      Fabric.getLogger().e("Answers", "Failed to submit events task", paramRunnable);
    }
  }
  
  public final void onRollOver$552c4e01()
  {
    executeAsync(new Runnable()
    {
      public final void run()
      {
        try
        {
          strategy.sendEvents();
          return;
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("Answers", "Failed to send events files", localException);
        }
      }
    });
  }
  
  public final void processEvent(final SessionEvent.Builder paramBuilder, boolean paramBoolean1, final boolean paramBoolean2)
  {
    paramBuilder = new Runnable()
    {
      public final void run()
      {
        try
        {
          strategy.processEvent(paramBuilder);
          if (paramBoolean2) {
            strategy.rollFileOver();
          }
          return;
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("Answers", "Failed to process event", localException);
        }
      }
    };
    if (paramBoolean1) {
      try
      {
        executor.submit(paramBuilder).get();
        return;
      }
      catch (Exception paramBuilder)
      {
        Fabric.getLogger().e("Answers", "Failed to run events task", paramBuilder);
        return;
      }
    }
    executeAsync(paramBuilder);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersEventsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */