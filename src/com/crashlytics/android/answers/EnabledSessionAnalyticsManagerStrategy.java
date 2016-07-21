package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.concurrency.internal.DefaultRetryPolicy;
import io.fabric.sdk.android.services.concurrency.internal.ExponentialBackoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryState;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

final class EnabledSessionAnalyticsManagerStrategy
  implements SessionAnalyticsManagerStrategy
{
  ApiKey apiKey = new ApiKey();
  private final Context context;
  boolean customEventsEnabled = true;
  EventFilter eventFilter = new KeepAllEventFilter();
  private final ScheduledExecutorService executorService;
  private final SessionAnalyticsFilesManager filesManager;
  FilesSender filesSender;
  private final HttpRequestFactory httpRequestFactory;
  private final Kit kit;
  final SessionEventMetadata metadata;
  boolean predefinedEventsEnabled = true;
  private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference();
  volatile int rolloverIntervalSeconds = -1;
  
  public EnabledSessionAnalyticsManagerStrategy(Kit paramKit, Context paramContext, ScheduledExecutorService paramScheduledExecutorService, SessionAnalyticsFilesManager paramSessionAnalyticsFilesManager, HttpRequestFactory paramHttpRequestFactory, SessionEventMetadata paramSessionEventMetadata)
  {
    kit = paramKit;
    context = paramContext;
    executorService = paramScheduledExecutorService;
    filesManager = paramSessionAnalyticsFilesManager;
    httpRequestFactory = paramHttpRequestFactory;
    metadata = paramSessionEventMetadata;
  }
  
  private void scheduleTimeBasedFileRollOver(long paramLong1, long paramLong2)
  {
    if (rolloverFutureRef.get() == null) {}
    for (int i = 1;; i = 0)
    {
      TimeBasedFileRollOverRunnable localTimeBasedFileRollOverRunnable;
      if (i != 0)
      {
        localTimeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(context, this);
        CommonUtils.logControlled(context, "Scheduling time based file roll over every " + paramLong2 + " seconds");
      }
      try
      {
        rolloverFutureRef.set(executorService.scheduleAtFixedRate(localTimeBasedFileRollOverRunnable, paramLong1, paramLong2, TimeUnit.SECONDS));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        CommonUtils.logControlledError$43da9ce8(context, "Failed to schedule time based file roll over");
      }
    }
  }
  
  public final void cancelTimeBasedFileRollOver()
  {
    if (rolloverFutureRef.get() != null)
    {
      CommonUtils.logControlled(context, "Cancelling time-based rollover because no events are currently being generated.");
      ((ScheduledFuture)rolloverFutureRef.get()).cancel(false);
      rolloverFutureRef.set(null);
    }
  }
  
  public final void deleteAllEvents()
  {
    filesManager.deleteAllEventsFiles();
  }
  
  public final void processEvent(SessionEvent.Builder paramBuilder)
  {
    int i = 0;
    paramBuilder = new SessionEvent(metadata, timestamp, type, details, customType, customAttributes, predefinedType, predefinedAttributes, (byte)0);
    if ((!customEventsEnabled) && (SessionEvent.Type.CUSTOM.equals(type))) {
      Fabric.getLogger().d("Answers", "Custom events tracking disabled - skipping event: " + paramBuilder);
    }
    for (;;)
    {
      return;
      if ((!predefinedEventsEnabled) && (SessionEvent.Type.PREDEFINED.equals(type)))
      {
        Fabric.getLogger().d("Answers", "Predefined events tracking disabled - skipping event: " + paramBuilder);
        return;
      }
      if (eventFilter.skipEvent(paramBuilder))
      {
        Fabric.getLogger().d("Answers", "Skipping filtered event: " + paramBuilder);
        return;
      }
      try
      {
        filesManager.writeEvent(paramBuilder);
        if (rolloverIntervalSeconds != -1) {
          i = 1;
        }
        if (i == 0) {
          continue;
        }
        scheduleTimeBasedFileRollOver(rolloverIntervalSeconds, rolloverIntervalSeconds);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Fabric.getLogger().e("Answers", "Failed to write event: " + paramBuilder, localIOException);
        }
      }
    }
  }
  
  public final boolean rollFileOver()
  {
    try
    {
      boolean bool = filesManager.rollFileOver();
      return bool;
    }
    catch (IOException localIOException)
    {
      CommonUtils.logControlledError$43da9ce8(context, "Failed to roll file over.");
    }
    return false;
  }
  
  public final void sendEvents()
  {
    if (filesSender == null) {
      CommonUtils.logControlled(context, "skipping files send because we don't yet know the target endpoint");
    }
    int m;
    do
    {
      return;
      CommonUtils.logControlled(context, "Sending all files");
      int j = 0;
      List localList = filesManager.getBatchOfFilesToSend();
      for (;;)
      {
        int i = j;
        m = j;
        try
        {
          if (localList.size() > 0)
          {
            i = j;
            CommonUtils.logControlled(context, String.format(Locale.US, "attempt to send batch of %d files", new Object[] { Integer.valueOf(localList.size()) }));
            i = j;
            boolean bool = filesSender.send(localList);
            int k = j;
            if (bool)
            {
              i = j;
              k = j + localList.size();
              i = k;
              filesManager.deleteSentFiles(localList);
            }
            m = k;
            if (bool)
            {
              i = k;
              localList = filesManager.getBatchOfFilesToSend();
              j = k;
            }
          }
        }
        catch (Exception localException)
        {
          CommonUtils.logControlledError$43da9ce8(context, "Failed to send batch of analytics files to server: " + localException.getMessage());
          m = i;
        }
      }
    } while (m != 0);
    filesManager.deleteOldestInRollOverIfOverMax();
  }
  
  public final void setAnalyticsSettingsData(AnalyticsSettingsData paramAnalyticsSettingsData, String paramString)
  {
    filesSender = new AnswersRetryFilesSender(new SessionAnalyticsFilesSender(kit, paramString, analyticsURL, httpRequestFactory, ApiKey.getValue(context)), new RetryManager(new RetryState(new RandomBackoff(new ExponentialBackoff()), new DefaultRetryPolicy(5))));
    filesManager.analyticsSettingsData = paramAnalyticsSettingsData;
    customEventsEnabled = trackCustomEvents;
    Logger localLogger = Fabric.getLogger();
    StringBuilder localStringBuilder = new StringBuilder("Custom event tracking ");
    if (customEventsEnabled)
    {
      paramString = "enabled";
      localLogger.d("Answers", paramString);
      predefinedEventsEnabled = trackPredefinedEvents;
      localLogger = Fabric.getLogger();
      localStringBuilder = new StringBuilder("Predefined event tracking ");
      if (!predefinedEventsEnabled) {
        break label248;
      }
    }
    label248:
    for (paramString = "enabled";; paramString = "disabled")
    {
      localLogger.d("Answers", paramString);
      if (samplingRate > 1)
      {
        Fabric.getLogger().d("Answers", "Event sampling enabled");
        eventFilter = new SamplingEventFilter(samplingRate);
      }
      rolloverIntervalSeconds = flushIntervalSeconds;
      scheduleTimeBasedFileRollOver(0L, rolloverIntervalSeconds);
      return;
      paramString = "disabled";
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.EnabledSessionAnalyticsManagerStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */