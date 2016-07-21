package com.crashlytics.android.beta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class AbstractCheckForUpdatesController
  implements UpdatesController
{
  private Beta beta;
  private BetaSettingsData betaSettings;
  private BuildProperties buildProps;
  private Context context;
  private CurrentTimeProvider currentTimeProvider;
  final AtomicBoolean externallyReady;
  private HttpRequestFactory httpRequestFactory;
  private IdManager idManager;
  final AtomicBoolean initialized = new AtomicBoolean();
  private long lastCheckTimeMillis = 0L;
  private PreferenceStore preferenceStore;
  
  public AbstractCheckForUpdatesController()
  {
    this(false);
  }
  
  public AbstractCheckForUpdatesController(boolean paramBoolean)
  {
    externallyReady = new AtomicBoolean(paramBoolean);
  }
  
  @SuppressLint({"CommitPrefEdits"})
  protected final void checkForUpdates()
  {
    long l1;
    String str;
    synchronized (preferenceStore)
    {
      if (preferenceStore.get().contains("last_update_check")) {
        preferenceStore.save(preferenceStore.edit().remove("last_update_check"));
      }
      l1 = currentTimeProvider.getCurrentTimeMillis();
      long l2 = betaSettings.updateSuspendDurationSeconds * 1000L;
      Fabric.getLogger().d("Beta", "Check for updates delay: " + l2);
      Fabric.getLogger().d("Beta", "Check for updates last check time: " + lastCheckTimeMillis);
      l2 = lastCheckTimeMillis + l2;
      Fabric.getLogger().d("Beta", "Check for updates current time: " + l1 + ", next check time: " + l2);
      if (l1 < l2) {}
    }
    Fabric.getLogger().d("Beta", "Check for updates next check time was not passed");
  }
  
  public final void initialize(Context paramContext, Beta paramBeta, IdManager paramIdManager, BetaSettingsData paramBetaSettingsData, BuildProperties paramBuildProperties, PreferenceStore paramPreferenceStore, CurrentTimeProvider paramCurrentTimeProvider, HttpRequestFactory paramHttpRequestFactory)
  {
    context = paramContext;
    beta = paramBeta;
    idManager = paramIdManager;
    betaSettings = paramBetaSettingsData;
    buildProps = paramBuildProperties;
    preferenceStore = paramPreferenceStore;
    currentTimeProvider = paramCurrentTimeProvider;
    httpRequestFactory = paramHttpRequestFactory;
    initialized.set(true);
    if (externallyReady.get()) {
      checkForUpdates();
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.AbstractCheckForUpdatesController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */