package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzne;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil
  extends zze
{
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return zza(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return zze.getErrorPendingIntent(paramInt1, paramContext, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return zze.getErrorString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    return zze.getOpenSourceSoftwareLicenseInfo(paramContext);
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    return zze.getRemoteContext(paramContext);
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    return zze.getRemoteResource(paramContext);
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    return zze.isGooglePlayServicesAvailable(paramContext);
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    return zze.isUserRecoverableError(paramInt);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramFragment = zza(paramInt1, paramActivity, paramFragment, paramInt2, paramOnCancelListener);
    if (paramFragment == null) {
      return false;
    }
    zza(paramActivity, paramOnCancelListener, "GooglePlayServicesErrorDialog", paramFragment);
    return true;
  }
  
  @Deprecated
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    int i = paramInt;
    if (zzmu.zzaw(paramContext))
    {
      i = paramInt;
      if (paramInt == 2) {
        i = 42;
      }
    }
    if ((zzd(paramContext, i)) || (zze(paramContext, i)))
    {
      zzam(paramContext);
      return;
    }
    zza(i, paramContext);
  }
  
  @TargetApi(14)
  private static Dialog zza(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject2 = null;
    if (paramInt1 == 0) {
      return null;
    }
    int i = paramInt1;
    if (zzmu.zzaw(paramActivity))
    {
      i = paramInt1;
      if (paramInt1 == 2) {
        i = 42;
      }
    }
    paramInt1 = i;
    if (zzd(paramActivity, i)) {
      paramInt1 = 18;
    }
    Object localObject1 = localObject2;
    if (zzne.zzcp(14))
    {
      TypedValue localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, localTypedValue, true);
      localObject1 = localObject2;
      if ("Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(resourceId))) {
        localObject1 = new AlertDialog.Builder(paramActivity, 5);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new AlertDialog.Builder(paramActivity);
    }
    ((AlertDialog.Builder)localObject2).setMessage(zzg.zzc(paramActivity, paramInt1, zzao(paramActivity)));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject2).setOnCancelListener(paramOnCancelListener);
    }
    paramOnCancelListener = GoogleApiAvailability.getInstance().zza(paramActivity, paramInt1, "d");
    if (paramFragment == null)
    {
      paramOnCancelListener = new zzh(paramActivity, paramOnCancelListener, paramInt2);
      paramFragment = paramActivity.getResources();
      switch (paramInt1)
      {
      default: 
        paramFragment = paramFragment.getString(17039370);
      }
    }
    for (;;)
    {
      if (paramFragment != null) {
        ((AlertDialog.Builder)localObject2).setPositiveButton(paramFragment, paramOnCancelListener);
      }
      paramActivity = zzg.zzg(paramActivity, paramInt1);
      if (paramActivity != null) {
        ((AlertDialog.Builder)localObject2).setTitle(paramActivity);
      }
      return ((AlertDialog.Builder)localObject2).create();
      paramOnCancelListener = new zzh(paramFragment, paramOnCancelListener, paramInt2);
      break;
      paramFragment = paramFragment.getString(R.string.common_google_play_services_install_button);
      continue;
      paramFragment = paramFragment.getString(R.string.common_google_play_services_enable_button);
      continue;
      paramFragment = paramFragment.getString(R.string.common_google_play_services_update_button);
    }
  }
  
  @TargetApi(21)
  private static void zza(int paramInt, Context paramContext)
  {
    zza(paramInt, paramContext, null);
  }
  
  @TargetApi(21)
  private static void zza(int paramInt, Context paramContext, String paramString)
  {
    Object localObject2 = paramContext.getResources();
    Object localObject3 = zzao(paramContext);
    String str = zzg.zzg(paramContext, paramInt);
    Object localObject1 = str;
    if (str == null) {
      localObject1 = ((Resources)localObject2).getString(R.string.common_google_play_services_notification_ticker);
    }
    str = zzg.zzc(paramContext, paramInt, (String)localObject3);
    localObject3 = GoogleApiAvailability.getInstance().zza(paramContext, paramInt, 0, "n");
    if (zzmu.zzaw(paramContext))
    {
      zzx.zzab(zzne.zzcp(16));
      localObject1 = new Notification.Builder(paramContext).setSmallIcon(R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText((String)localObject1 + " " + str)).addAction(R.drawable.common_full_open_on_phone, ((Resources)localObject2).getString(R.string.common_open_on_phone), (PendingIntent)localObject3).build();
      if (!zzbw(paramInt)) {
        break label379;
      }
      zzafQ.set(false);
    }
    label379:
    for (paramInt = 10436;; paramInt = 39789)
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramString == null) {
        break label386;
      }
      paramContext.notify(paramString, paramInt, (Notification)localObject1);
      return;
      localObject2 = ((Resources)localObject2).getString(R.string.common_google_play_services_notification_ticker);
      if (zzne.zzcp(11))
      {
        localObject1 = new Notification.Builder(paramContext).setSmallIcon(17301642).setContentTitle((CharSequence)localObject1).setContentText(str).setContentIntent((PendingIntent)localObject3).setTicker((CharSequence)localObject2).setAutoCancel(true);
        if (zzne.zzcp(20)) {
          ((Notification.Builder)localObject1).setLocalOnly(true);
        }
        if (zzne.zzcp(16)) {
          ((Notification.Builder)localObject1).setStyle(new Notification.BigTextStyle().bigText(str));
        }
        for (localObject1 = ((Notification.Builder)localObject1).build();; localObject1 = ((Notification.Builder)localObject1).getNotification())
        {
          if (Build.VERSION.SDK_INT == 19) {
            extras.putBoolean("android.support.localOnly", true);
          }
          break;
        }
      }
      localObject2 = new NotificationCompat.Builder(paramContext).setSmallIcon(17301642).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis()).setAutoCancel$7abcb88d();
      mContentIntent = ((PendingIntent)localObject3);
      localObject1 = ((NotificationCompat.Builder)localObject2).setContentTitle((CharSequence)localObject1).setContentText(str).build();
      break;
    }
    label386:
    paramContext.notify(paramInt, (Notification)localObject1);
  }
  
  @TargetApi(11)
  public static void zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener, String paramString, Dialog paramDialog)
  {
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
      return;
    }
    if (zzne.zzcp(11))
    {
      paramActivity = paramActivity.getFragmentManager();
      ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
      return;
    }
    throw new RuntimeException("This Activity does not support Fragments.");
  }
  
  private static void zzam(Context paramContext)
  {
    paramContext = new zza(paramContext);
    paramContext.sendMessageDelayed(paramContext.obtainMessage(1), 120000L);
  }
  
  @Deprecated
  public static Intent zzbv(int paramInt)
  {
    return zze.zzbv(paramInt);
  }
  
  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt)
  {
    return zze.zzd(paramContext, paramInt);
  }
  
  @Deprecated
  public static boolean zze(Context paramContext, int paramInt)
  {
    return zze.zze(paramContext, paramInt);
  }
  
  private static final class zza
    extends Handler
  {
    private final Context zzsa;
    
    zza(Context paramContext) {}
    
    public final void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + what);
      }
      int i;
      do
      {
        return;
        i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzsa);
      } while (!GooglePlayServicesUtil.isUserRecoverableError(i));
      GooglePlayServicesUtil.zzb(i, zzsa);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */