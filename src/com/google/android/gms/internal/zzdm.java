package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzr;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzhb
public final class zzdm
  implements zzdf
{
  private final zze zzzA;
  private final zzfn zzzB;
  private final zzdh zzzD;
  
  public zzdm(zzdh paramzzdh, zze paramzze, zzfn paramzzfn)
  {
    zzzD = paramzzdh;
    zzzA = paramzze;
    zzzB = paramzzfn;
  }
  
  private static boolean zzc(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int zzd(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("o");
    if (paramMap != null)
    {
      if ("p".equalsIgnoreCase(paramMap)) {
        return zzr.zzbE().zzhw();
      }
      if ("l".equalsIgnoreCase(paramMap)) {
        return zzr.zzbE().zzhv();
      }
      if ("c".equalsIgnoreCase(paramMap)) {
        return zzr.zzbE().zzhx();
      }
    }
    return -1;
  }
  
  private void zzo(boolean paramBoolean)
  {
    if (zzzB != null) {
      zzzB.zzp(paramBoolean);
    }
  }
  
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    Object localObject1 = (String)paramMap.get("a");
    if (localObject1 == null) {
      zzin.zzaK("Action missing from an open GMSG.");
    }
    Object localObject2;
    do
    {
      return;
      if ((zzzA != null) && (!zzzA.zzbh()))
      {
        paramMap.get("u");
        zzin.zzaI("Action was blocked because no click was detected.");
        return;
      }
      localObject2 = paramzzjp.zzhU();
      if ("expand".equalsIgnoreCase((String)localObject1))
      {
        if (paramzzjp.zzhY())
        {
          zzin.zzaK("Cannot expand WebView that is already expanded.");
          return;
        }
        zzo(false);
        ((zzjq)localObject2).zza(zzc(paramMap), zzd(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase((String)localObject1))
      {
        paramzzjp = (String)paramMap.get("u");
        zzo(false);
        if (paramzzjp != null)
        {
          ((zzjq)localObject2).zza(zzc(paramMap), zzd(paramMap), paramzzjp);
          return;
        }
        ((zzjq)localObject2).zza(zzc(paramMap), zzd(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase((String)localObject1)) {
        break;
      }
      paramMap.get("product_id");
      paramzzjp = (String)paramMap.get("report_urls");
    } while (zzzD == null);
    if ((paramzzjp != null) && (!paramzzjp.isEmpty()))
    {
      new ArrayList(Arrays.asList(paramzzjp.split(" ")));
      return;
    }
    new ArrayList();
    return;
    if (("app".equalsIgnoreCase((String)localObject1)) && ("true".equalsIgnoreCase((String)paramMap.get("play_store"))))
    {
      paramMap = (String)paramMap.get("u");
      if (TextUtils.isEmpty(paramMap))
      {
        zzin.zzaK("Destination url cannot be empty.");
        return;
      }
      new zza(paramzzjp, paramMap).zzhn();
      return;
    }
    if (("app".equalsIgnoreCase((String)localObject1)) && ("true".equalsIgnoreCase((String)paramMap.get("system_browser"))))
    {
      zzo(true);
      localObject2 = paramzzjp.getContext();
      if (TextUtils.isEmpty((String)paramMap.get("u")))
      {
        zzin.zzaK("Destination url cannot be empty.");
        return;
      }
      localObject1 = paramzzjp.zzhU();
      paramzzjp = new zzb(paramzzjp).zza((Context)localObject2, paramMap);
      try
      {
        ((zzjq)localObject1).zza(new AdLauncherIntentInfoParcel(paramzzjp));
        return;
      }
      catch (ActivityNotFoundException paramzzjp)
      {
        zzin.zzaK(paramzzjp.getMessage());
        return;
      }
    }
    zzo(true);
    localObject1 = (String)paramMap.get("u");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      zzr.zzbC();
    }
    for (paramzzjp = zzir.zza(paramzzjp, (String)localObject1);; paramzzjp = (zzjp)localObject1)
    {
      ((zzjq)localObject2).zza(new AdLauncherIntentInfoParcel((String)paramMap.get("i"), paramzzjp, (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
      return;
    }
  }
  
  public static final class zza
    extends zzim
  {
    private final String zzF;
    private final zzjp zzpD;
    private final String zzzE = "play.google.com";
    private final String zzzF = "market";
    private final int zzzG = 10;
    
    public zza(zzjp paramzzjp, String paramString)
    {
      zzpD = paramzzjp;
      zzF = paramString;
    }
    
    public final void zzbr()
    {
      int i = 0;
      Object localObject1 = zzF;
      if (i < 10) {}
      for (;;)
      {
        try
        {
          localObject2 = new URL((String)localObject1);
          boolean bool = "play.google.com".equalsIgnoreCase(((URL)localObject2).getHost());
          if (!bool) {
            continue;
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          Object localObject2;
          HttpURLConnection localHttpURLConnection;
          zzin.zzd("Error while parsing ping URL: " + (String)localObject1, localIndexOutOfBoundsException1);
          continue;
        }
        catch (IOException localIOException1)
        {
          zzin.zzd("Error while pinging URL: " + (String)localObject1, localIOException1);
          continue;
        }
        catch (RuntimeException localRuntimeException1)
        {
          zzin.zzd("Error while pinging URL: " + (String)localObject1, localRuntimeException1);
          continue;
          Object localObject4 = "";
          continue;
        }
        localObject1 = Uri.parse((String)localObject1);
        localObject2 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).setData((Uri)localObject1);
        zzr.zzbC();
        zzir.zzb(zzpD.getContext(), (Intent)localObject2);
        return;
        if (!"market".equalsIgnoreCase(((URL)localObject2).getProtocol()))
        {
          localHttpURLConnection = (HttpURLConnection)((URL)localObject2).openConnection();
          try
          {
            zzr.zzbC().zza(zzpD.getContext(), zzpD.zzhX().afmaVersion, false, localHttpURLConnection);
            int j = localHttpURLConnection.getResponseCode();
            Map localMap = localHttpURLConnection.getHeaderFields();
            if ((j >= 300) && (j <= 399))
            {
              localObject2 = null;
              if (localMap.containsKey("Location"))
              {
                localObject2 = (List)localMap.get("Location");
                if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
                  continue;
                }
                localObject2 = (String)((List)localObject2).get(0);
                if (TextUtils.isEmpty((CharSequence)localObject2))
                {
                  zzin.zzaK("Arrived at landing page, this ideally should not happen. Will open it in browser.");
                  localHttpURLConnection.disconnect();
                }
              }
              else
              {
                if (!localMap.containsKey("location")) {
                  continue;
                }
                localObject2 = (List)localMap.get("location");
                continue;
              }
            }
          }
          finally
          {
            try
            {
              localHttpURLConnection.disconnect();
              i += 1;
              localObject1 = localObject2;
            }
            catch (RuntimeException localRuntimeException2)
            {
              localObject1 = localRuntimeException1;
              localObject4 = localRuntimeException2;
              continue;
            }
            catch (IOException localIOException2)
            {
              localObject1 = localObject4;
              localObject4 = localIOException2;
              continue;
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
            {
              localObject1 = localObject4;
              localObject4 = localIndexOutOfBoundsException2;
              continue;
            }
            localObject3 = finally;
            localHttpURLConnection.disconnect();
          }
        }
      }
    }
  }
  
  public static final class zzb
  {
    final zzjp zzpD;
    
    public zzb(zzjp paramzzjp)
    {
      zzpD = paramzzjp;
    }
    
    private static Intent zza(Intent paramIntent, ResolveInfo paramResolveInfo)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setClassName(activityInfo.packageName, activityInfo.name);
      return paramIntent;
    }
    
    private static ResolveInfo zza(Context paramContext, Intent paramIntent)
    {
      return zza(paramContext, paramIntent, new ArrayList());
    }
    
    private static ResolveInfo zza(Context paramContext, Intent paramIntent, ArrayList<ResolveInfo> paramArrayList)
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return null;
      }
      List localList = paramContext.queryIntentActivities(paramIntent, 65536);
      paramContext = paramContext.resolveActivity(paramIntent, 65536);
      int i;
      if ((localList != null) && (paramContext != null))
      {
        i = 0;
        if (i < localList.size())
        {
          paramIntent = (ResolveInfo)localList.get(i);
          if ((paramContext == null) || (!activityInfo.name.equals(activityInfo.name))) {}
        }
      }
      for (;;)
      {
        paramArrayList.addAll(localList);
        return paramContext;
        i += 1;
        break;
        paramContext = null;
      }
    }
    
    private static Intent zzd(Uri paramUri)
    {
      if (paramUri == null) {
        return null;
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setData(paramUri);
      localIntent.setAction("android.intent.action.VIEW");
      return localIntent;
    }
    
    public final Intent zza(Context paramContext, Map<String, String> paramMap)
    {
      Object localObject1 = null;
      Object localObject3 = (ActivityManager)paramContext.getSystemService("activity");
      Object localObject2 = (String)paramMap.get("u");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramMap = (Map<String, String>)localObject1;
        return paramMap;
      }
      localObject1 = localObject2;
      if (zzpD != null)
      {
        zzr.zzbC();
        localObject1 = zzir.zza(zzpD, (String)localObject2);
      }
      localObject1 = Uri.parse((String)localObject1);
      boolean bool1 = Boolean.parseBoolean((String)paramMap.get("use_first_package"));
      boolean bool2 = Boolean.parseBoolean((String)paramMap.get("use_running_process"));
      if ("http".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
        paramMap = ((Uri)localObject1).buildUpon().scheme("https").build();
      }
      for (;;)
      {
        localObject2 = new ArrayList();
        Intent localIntent = zzd((Uri)localObject1);
        paramMap = zzd(paramMap);
        localObject1 = zza(paramContext, localIntent, (ArrayList)localObject2);
        if (localObject1 != null)
        {
          return zza(localIntent, (ResolveInfo)localObject1);
          if ("https".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
            paramMap = ((Uri)localObject1).buildUpon().scheme("http").build();
          }
        }
        else
        {
          if (paramMap != null)
          {
            paramMap = zza(paramContext, paramMap);
            if (paramMap != null)
            {
              localObject1 = zza(localIntent, paramMap);
              paramMap = (Map<String, String>)localObject1;
              if (zza(paramContext, (Intent)localObject1) != null) {
                break;
              }
            }
          }
          if (((ArrayList)localObject2).size() == 0) {
            return localIntent;
          }
          if ((bool2) && (localObject3 != null))
          {
            paramContext = ((ActivityManager)localObject3).getRunningAppProcesses();
            if (paramContext != null)
            {
              do
              {
                paramMap = ((ArrayList)localObject2).iterator();
                while (!((Iterator)localObject3).hasNext())
                {
                  if (!paramMap.hasNext()) {
                    break;
                  }
                  localObject1 = (ResolveInfo)paramMap.next();
                  localObject3 = paramContext.iterator();
                }
              } while (!nextprocessName.equals(activityInfo.packageName));
              return zza(localIntent, (ResolveInfo)localObject1);
            }
          }
          if (bool1) {
            return zza(localIntent, (ResolveInfo)((ArrayList)localObject2).get(0));
          }
          return localIntent;
        }
        paramMap = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */