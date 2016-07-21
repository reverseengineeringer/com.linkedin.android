package com.linkedin.android.infra.shared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.design.widget.Snackbar;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.litrackinglib.metric.Tracker;

public final class InternetConnectionMonitor
{
  public final Context appContext;
  public final BroadcastReceiver connectivityBroadcastReceiver;
  public boolean internetSnackbarLixEnabled;
  private final LixManager lixManager;
  Snackbar snackbar;
  final SnackbarUtil snackbarUtil;
  final Tracker tracker;
  
  public InternetConnectionMonitor(Context paramContext, LixManager paramLixManager, SnackbarUtil paramSnackbarUtil, Tracker paramTracker)
  {
    appContext = paramContext;
    lixManager = paramLixManager;
    snackbarUtil = paramSnackbarUtil;
    tracker = paramTracker;
    lixManager.addTreatmentListener(Lix.INFRA_NO_INTERNET_CONNECTION_SNACKBAR, new InternetConnectionMonitor.2(this));
    internetSnackbarLixEnabled = lixManager.getTreatment(Lix.INFRA_NO_INTERNET_CONNECTION_SNACKBAR).equals("enabled");
    connectivityBroadcastReceiver = new InternetConnectionMonitor.1(this);
  }
  
  public final void dismissSnackbar()
  {
    if (snackbar != null)
    {
      snackbar.dismiss();
      snackbar = null;
    }
  }
  
  public final void registerInternetCheckReceiver()
  {
    if (internetSnackbarLixEnabled)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      appContext.registerReceiver(connectivityBroadcastReceiver, localIntentFilter);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.InternetConnectionMonitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */