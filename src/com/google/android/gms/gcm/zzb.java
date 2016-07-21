package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

class zzb
{
  static zzb zzaLC;
  private final Context mContext;
  private final Class<? extends GcmListenerService> zzaLD;
  
  private zzb(Context paramContext, Class<? extends GcmListenerService> paramClass)
  {
    mContext = paramContext.getApplicationContext();
    zzaLD = paramClass;
  }
  
  private Notification zzB(Bundle paramBundle)
  {
    String str1 = zzf(paramBundle, "gcm.n.title");
    String str2 = zzf(paramBundle, "gcm.n.body");
    int i = zzdW(zze(paramBundle, "gcm.n.icon"));
    String str3 = zze(paramBundle, "gcm.n.color");
    Uri localUri = zzdX(zze(paramBundle, "gcm.n.sound2"));
    PendingIntent localPendingIntent3 = zzC(paramBundle);
    PendingIntent localPendingIntent2 = null;
    PendingIntent localPendingIntent1 = localPendingIntent3;
    if (GcmListenerService.zzx(paramBundle))
    {
      localPendingIntent1 = zza(paramBundle, localPendingIntent3);
      localPendingIntent2 = zzD(paramBundle);
    }
    paramBundle = new NotificationCompat.Builder(mContext).setAutoCancel$7abcb88d().setSmallIcon(i);
    if (!TextUtils.isEmpty(str1)) {
      paramBundle.setContentTitle(str1);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2)) {
        paramBundle.setContentText(str2);
      }
      if (!TextUtils.isEmpty(str3)) {
        mColor = Color.parseColor(str3);
      }
      if (localUri != null)
      {
        mNotification.sound = localUri;
        mNotification.audioStreamType = -1;
      }
      if (localPendingIntent1 != null) {
        mContentIntent = localPendingIntent1;
      }
      if (localPendingIntent2 != null) {
        paramBundle.setDeleteIntent(localPendingIntent2);
      }
      return paramBundle.build();
      paramBundle.setContentTitle(mContext.getApplicationInfo().loadLabel(mContext.getPackageManager()));
    }
  }
  
  private PendingIntent zzC(Bundle paramBundle)
  {
    Object localObject = zze(paramBundle, "gcm.n.click_action");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent((String)localObject);
      ((Intent)localObject).setPackage(mContext.getPackageName());
      ((Intent)localObject).setFlags(268435456);
    }
    label163:
    for (;;)
    {
      paramBundle = new Bundle(paramBundle);
      GcmListenerService.zzw(paramBundle);
      ((Intent)localObject).putExtras(paramBundle);
      paramBundle = paramBundle.keySet().iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        if ((str.startsWith("gcm.n.")) || (str.startsWith("gcm.notification.")))
        {
          ((Intent)localObject).removeExtra(str);
          continue;
          localObject = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
          if (localObject != null) {
            break label163;
          }
          Log.w("GcmNotification", "No activity found to launch app");
          return null;
        }
      }
      return PendingIntent.getActivity(mContext, zzyj(), (Intent)localObject, 1073741824);
    }
  }
  
  private PendingIntent zzD(Bundle paramBundle)
  {
    Intent localIntent = new Intent("com.google.android.gms.gcm.NOTIFICATION_DISMISS");
    zza(localIntent, paramBundle);
    return PendingIntent.getService(mContext, zzyj(), localIntent, 1073741824);
  }
  
  private PendingIntent zza(Bundle paramBundle, PendingIntent paramPendingIntent)
  {
    Intent localIntent = new Intent("com.google.android.gms.gcm.NOTIFICATION_OPEN");
    zza(localIntent, paramBundle);
    localIntent.putExtra("com.google.android.gms.gcm.PENDING_INTENT", paramPendingIntent);
    return PendingIntent.getService(mContext, zzyj(), localIntent, 1073741824);
  }
  
  private void zza(Intent paramIntent, Bundle paramBundle)
  {
    paramIntent.setClass(mContext, zzaLD);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.startsWith("google.c.a.")) || (str.equals("from"))) {
        paramIntent.putExtra(str, paramBundle.getString(str));
      }
    }
  }
  
  private void zza(String paramString, Notification paramNotification)
  {
    if (Log.isLoggable("GcmNotification", 3)) {
      Log.d("GcmNotification", "Showing notification");
    }
    NotificationManager localNotificationManager = (NotificationManager)mContext.getSystemService("notification");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "GCM-Notification:" + SystemClock.uptimeMillis();
    }
    localNotificationManager.notify(str, 0, paramNotification);
  }
  
  static boolean zzaI(Context paramContext)
  {
    if (((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
      return false;
    }
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (pid == i) {
          return importance == 100;
        }
      }
    }
    return false;
  }
  
  static zzb zzc(Context paramContext, Class<? extends GcmListenerService> paramClass)
  {
    try
    {
      if (zzaLC == null) {
        zzaLC = new zzb(paramContext, paramClass);
      }
      paramContext = zzaLC;
      return paramContext;
    }
    finally {}
  }
  
  private String zzdV(String paramString)
  {
    return paramString.substring(6);
  }
  
  private int zzdW(String paramString)
  {
    Resources localResources;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localResources = mContext.getResources();
      i = localResources.getIdentifier(paramString, "drawable", mContext.getPackageName());
      if (i == 0) {}
    }
    int j;
    do
    {
      do
      {
        return i;
        j = localResources.getIdentifier(paramString, "mipmap", mContext.getPackageName());
        i = j;
      } while (j != 0);
      Log.w("GcmNotification", "Icon resource " + paramString + " not found. Notification will use app icon.");
      j = mContext.getApplicationInfo().icon;
      i = j;
    } while (j != 0);
    return 17301651;
  }
  
  private Uri zzdX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((!"default".equals(paramString)) && (mContext.getResources().getIdentifier(paramString, "raw", mContext.getPackageName()) != 0)) {
      return Uri.parse("android.resource://" + mContext.getPackageName() + "/raw/" + paramString);
    }
    return RingtoneManager.getDefaultUri(2);
  }
  
  static String zze(Bundle paramBundle, String paramString)
  {
    String str2 = paramBundle.getString(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification."));
    }
    return str1;
  }
  
  private String zzf(Bundle paramBundle, String paramString)
  {
    String str = zze(paramBundle, paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = zze(paramBundle, paramString + "_loc_key");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Object localObject = mContext.getResources();
    int j = ((Resources)localObject).getIdentifier(str, "string", mContext.getPackageName());
    if (j == 0)
    {
      Log.w("GcmNotification", zzdV(new StringBuilder().append(paramString).append("_loc_key").toString()) + " resource not found: " + str + " Default value will be used.");
      return null;
    }
    paramBundle = zze(paramBundle, paramString + "_loc_args");
    if (TextUtils.isEmpty(paramBundle)) {
      return ((Resources)localObject).getString(j);
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramBundle);
      String[] arrayOfString = new String[localJSONArray.length()];
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = localJSONArray.opt(i);
        i += 1;
      }
      localObject = ((Resources)localObject).getString(j, arrayOfString);
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      Log.w("GcmNotification", "Malformed " + zzdV(new StringBuilder().append(paramString).append("_loc_args").toString()) + ": " + paramBundle + "  Default value will be used.");
      return null;
    }
    catch (MissingFormatArgumentException paramString)
    {
      for (;;)
      {
        Log.w("GcmNotification", "Missing format argument for " + localJSONException + ": " + paramBundle + " Default value will be used.", paramString);
      }
    }
  }
  
  static boolean zzy(Bundle paramBundle)
  {
    return ("1".equals(zze(paramBundle, "gcm.n.e"))) || (zze(paramBundle, "gcm.n.icon") != null);
  }
  
  private int zzyj()
  {
    return (int)SystemClock.uptimeMillis();
  }
  
  static void zzz(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith("gcm.n."))
      {
        localBundle.putString(str.substring(6), paramBundle.getString(str));
        localIterator.remove();
      }
      else if (str.startsWith("gcm.notification."))
      {
        localBundle.putString(str.substring(17), paramBundle.getString(str));
        localIterator.remove();
      }
    }
    if (!localBundle.isEmpty()) {
      paramBundle.putBundle("notification", localBundle);
    }
  }
  
  boolean zzA(Bundle paramBundle)
  {
    try
    {
      Notification localNotification = zzB(paramBundle);
      zza(zze(paramBundle, "gcm.n.tag"), localNotification);
      return true;
    }
    catch (zza paramBundle)
    {
      Log.e("GcmNotification", "Failed to show notification: " + paramBundle.getMessage());
    }
    return false;
  }
  
  private class zza
    extends IllegalArgumentException
  {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */