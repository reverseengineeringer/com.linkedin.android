package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

public class InstanceIDListenerService
  extends Service
{
  static String ACTION = "action";
  private static String zzaLH = "gcm.googleapis.com/refresh";
  private static String zzaMY = "google.com/iid";
  private static String zzaMZ = "CMD";
  MessengerCompat zzaMW = new MessengerCompat(new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      InstanceIDListenerService.zza(InstanceIDListenerService.this, paramAnonymousMessage, MessengerCompat.zzc(paramAnonymousMessage));
    }
  });
  BroadcastReceiver zzaMX = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        paramAnonymousIntent.getStringExtra("registration_id");
        Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + paramAnonymousIntent.getExtras());
      }
      zzp(paramAnonymousIntent);
      stop();
    }
  };
  int zzaNa;
  int zzaNb;
  
  static void zza(Context paramContext, zzd paramzzd)
  {
    paramzzd.zzyG();
    paramzzd = new Intent("com.google.android.gms.iid.InstanceID");
    paramzzd.putExtra(zzaMZ, "RST");
    paramzzd.setPackage(paramContext.getPackageName());
    paramContext.startService(paramzzd);
  }
  
  static void zzaM(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.android.gms.iid.InstanceID");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra(zzaMZ, "SYNC");
    paramContext.startService(localIntent);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))) {
      return zzaMW.getBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
    localIntentFilter.addCategory(getPackageName());
    registerReceiver(zzaMX, localIntentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
  }
  
  public void onDestroy()
  {
    unregisterReceiver(zzaMX);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    try
    {
      zzaNa += 1;
      if (paramInt2 > zzaNb) {
        zzaNb = paramInt2;
      }
      if (paramIntent == null)
      {
        stop();
        return 2;
      }
    }
    finally {}
    try
    {
      if ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))
      {
        if (Build.VERSION.SDK_INT <= 18)
        {
          Intent localIntent = (Intent)paramIntent.getParcelableExtra("GSF");
          if (localIntent != null)
          {
            startService(localIntent);
            return 1;
          }
        }
        zzp(paramIntent);
      }
      stop();
      if (paramIntent.getStringExtra("from") != null) {
        GcmReceiver.completeWakefulIntent(paramIntent);
      }
      return 2;
    }
    finally
    {
      stop();
    }
  }
  
  public void onTokenRefresh() {}
  
  final void stop()
  {
    try
    {
      zzaNa -= 1;
      if (zzaNa == 0) {
        stopSelf(zzaNb);
      }
      if (Log.isLoggable("InstanceID", 3)) {
        Log.d("InstanceID", "Stop " + zzaNa + " " + zzaNb);
      }
      return;
    }
    finally {}
  }
  
  public final void zzp(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("subtype");
    Object localObject1;
    Object localObject2;
    if (str == null)
    {
      localObject1 = InstanceID.getInstance(this);
      localObject2 = paramIntent.getStringExtra(zzaMZ);
      if ((paramIntent.getStringExtra("error") == null) && (paramIntent.getStringExtra("registration_id") == null)) {
        break label107;
      }
      if (Log.isLoggable("InstanceID", 3)) {
        Log.d("InstanceID", "Register result in service " + str);
      }
      InstanceID.zzyC().zzw(paramIntent);
    }
    label107:
    label319:
    do
    {
      do
      {
        return;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("subtype", str);
        localObject1 = InstanceID.zza(this, (Bundle)localObject1);
        break;
        if (Log.isLoggable("InstanceID", 3)) {
          Log.d("InstanceID", "Service command " + str + " " + (String)localObject2 + " " + paramIntent.getExtras());
        }
        if (paramIntent.getStringExtra("unregistered") != null)
        {
          localObject2 = InstanceID.zzyB();
          if (str == null) {}
          for (localObject1 = "";; localObject1 = str)
          {
            ((zzd)localObject2).zzef((String)localObject1);
            InstanceID.zzyC().zzw(paramIntent);
            return;
          }
        }
        if (zzaLH.equals(paramIntent.getStringExtra("from")))
        {
          InstanceID.zzyB().zzef(str);
          onTokenRefresh();
          return;
        }
        if ("RST".equals(localObject2))
        {
          zzaMU = 0L;
          paramIntent = InstanceID.zzaMQ;
          str = zzaMT;
          paramIntent.zzec(str + "|");
          zzaMS = null;
          onTokenRefresh();
          return;
        }
        if (!"RST_FULL".equals(localObject2)) {
          break label319;
        }
      } while (InstanceID.zzyB().isEmpty());
      InstanceID.zzyB().zzyG();
      onTokenRefresh();
      return;
      if ("SYNC".equals(localObject2))
      {
        InstanceID.zzyB().zzef(str);
        onTokenRefresh();
        return;
      }
    } while (!"PING".equals(localObject2));
    try
    {
      GoogleCloudMessaging.getInstance(this).send(zzaMY, zzc.zzyF(), 0L, paramIntent.getExtras());
      return;
    }
    catch (IOException paramIntent)
    {
      Log.w("InstanceID", "Failed to send ping response");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.InstanceIDListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */