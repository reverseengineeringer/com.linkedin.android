package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

final class DevicePowerStateListener
{
  private static final IntentFilter FILTER_BATTERY_CHANGED = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  private static final IntentFilter FILTER_POWER_CONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
  private static final IntentFilter FILTER_POWER_DISCONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
  final Context context;
  boolean isPowerConnected;
  final BroadcastReceiver powerConnectedReceiver;
  final BroadcastReceiver powerDisconnectedReceiver;
  final AtomicBoolean receiversRegistered;
  
  public DevicePowerStateListener(Context paramContext)
  {
    context = paramContext;
    Intent localIntent = paramContext.registerReceiver(null, FILTER_BATTERY_CHANGED);
    if (localIntent != null) {
      i = localIntent.getIntExtra("status", -1);
    }
    if ((i == 2) || (i == 5)) {}
    for (boolean bool = true;; bool = false)
    {
      isPowerConnected = bool;
      powerConnectedReceiver = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          DevicePowerStateListener.access$002(DevicePowerStateListener.this, true);
        }
      };
      powerDisconnectedReceiver = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          DevicePowerStateListener.access$002(DevicePowerStateListener.this, false);
        }
      };
      paramContext.registerReceiver(powerConnectedReceiver, FILTER_POWER_CONNECTED);
      paramContext.registerReceiver(powerDisconnectedReceiver, FILTER_POWER_DISCONNECTED);
      receiversRegistered = new AtomicBoolean(true);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.DevicePowerStateListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */