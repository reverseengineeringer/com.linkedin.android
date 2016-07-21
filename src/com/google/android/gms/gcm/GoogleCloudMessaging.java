package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzc;
import com.google.android.gms.iid.zzd;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleCloudMessaging
{
  public static int zzaLM = 5000000;
  public static int zzaLN = 6500000;
  public static int zzaLO = 7000000;
  static GoogleCloudMessaging zzaLP;
  private static final AtomicInteger zzaLS = new AtomicInteger(1);
  private Context context;
  private PendingIntent zzaLQ;
  private Map<String, Handler> zzaLR = Collections.synchronizedMap(new HashMap());
  private final BlockingQueue<Intent> zzaLT = new LinkedBlockingQueue();
  final Messenger zzaLU = new Messenger(new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) || (!(obj instanceof Intent))) {
        Log.w("GCM", "Dropping invalid message");
      }
      paramAnonymousMessage = (Intent)obj;
      if ("com.google.android.c2dm.intent.REGISTRATION".equals(paramAnonymousMessage.getAction())) {
        GoogleCloudMessaging.zza(GoogleCloudMessaging.this).add(paramAnonymousMessage);
      }
      while (GoogleCloudMessaging.zza(GoogleCloudMessaging.this, paramAnonymousMessage)) {
        return;
      }
      paramAnonymousMessage.setPackage(GoogleCloudMessaging.zzb(GoogleCloudMessaging.this).getPackageName());
      GoogleCloudMessaging.zzb(GoogleCloudMessaging.this).sendBroadcast(paramAnonymousMessage);
    }
  });
  
  public static GoogleCloudMessaging getInstance(Context paramContext)
  {
    try
    {
      if (zzaLP == null)
      {
        GoogleCloudMessaging localGoogleCloudMessaging = new GoogleCloudMessaging();
        zzaLP = localGoogleCloudMessaging;
        context = paramContext.getApplicationContext();
      }
      paramContext = zzaLP;
      return paramContext;
    }
    finally {}
  }
  
  private void zza(String paramString1, String paramString2, long paramLong, int paramInt, Bundle paramBundle)
    throws IOException
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Missing 'to'");
    }
    Object localObject1 = new Intent("com.google.android.gcm.intent.SEND");
    if (paramBundle != null) {
      ((Intent)localObject1).putExtras(paramBundle);
    }
    zzs((Intent)localObject1);
    ((Intent)localObject1).setPackage(zzaJ(context));
    ((Intent)localObject1).putExtra("google.to", paramString1);
    ((Intent)localObject1).putExtra("google.message_id", paramString2);
    ((Intent)localObject1).putExtra("google.ttl", Long.toString(paramLong));
    ((Intent)localObject1).putExtra("google.delay", Integer.toString(paramInt));
    ((Intent)localObject1).putExtra("google.from", zzdZ(paramString1));
    if (zzaJ(context).contains(".gsf"))
    {
      localObject1 = new Bundle();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = paramBundle.get(str);
        if ((localObject2 instanceof String)) {
          ((Bundle)localObject1).putString("gcm." + str, (String)localObject2);
        }
      }
      ((Bundle)localObject1).putString("google.to", paramString1);
      ((Bundle)localObject1).putString("google.message_id", paramString2);
      InstanceID.getInstance(context).zzc("GCM", "upstream", (Bundle)localObject1);
      return;
    }
    context.sendOrderedBroadcast((Intent)localObject1, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
  }
  
  public static String zzaJ(Context paramContext)
  {
    return zzc.zzaN(paramContext);
  }
  
  public static int zzaK(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = getPackageInfozzaJ0versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -1;
  }
  
  private String zzdZ(String paramString)
  {
    int i = paramString.indexOf('@');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    InstanceID.getInstance(context);
    return InstanceID.zzyB().zzi("", str, "GCM");
  }
  
  private boolean zzr(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getStringExtra("In-Reply-To");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramIntent.hasExtra("error")) {
        localObject1 = paramIntent.getStringExtra("google.message_id");
      }
    }
    if (localObject1 != null)
    {
      localObject1 = (Handler)zzaLR.remove(localObject1);
      if (localObject1 != null)
      {
        localObject2 = Message.obtain();
        obj = paramIntent;
        return ((Handler)localObject1).sendMessage((Message)localObject2);
      }
    }
    return false;
  }
  
  public void send(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
    throws IOException
  {
    zza(paramString1, paramString2, paramLong, -1, paramBundle);
  }
  
  void zzs(Intent paramIntent)
  {
    try
    {
      if (zzaLQ == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        zzaLQ = PendingIntent.getBroadcast(context, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", zzaLQ);
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.GoogleCloudMessaging
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */