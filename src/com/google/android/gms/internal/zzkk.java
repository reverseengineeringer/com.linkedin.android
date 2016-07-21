package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentContents.zza;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.UsageInfo.zza;
import com.google.android.gms.appdatasearch.zza;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zza;
import com.google.android.gms.common.api.internal.zza.zzb;
import java.util.List;

public final class zzkk
  implements zzk, AppIndexApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, Action paramAction, int paramInt)
  {
    Object localObject2 = paramGoogleApiClient.getContext().getPackageName();
    long l = System.currentTimeMillis();
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putAll(zzUG);
    Object localObject1 = ((Bundle)localObject3).getBundle("object");
    if (((Bundle)localObject1).containsKey("id")) {}
    Object localObject4;
    String str;
    for (paramAction = Uri.parse(((Bundle)localObject1).getString("id"));; paramAction = null)
    {
      localObject4 = ((Bundle)localObject1).getString("name");
      str = ((Bundle)localObject1).getString("type");
      localObject1 = Uri.parse(((Bundle)localObject1).getString("url"));
      if (!zzk((Uri)localObject1)) {
        break;
      }
      if (!((Uri)localObject1).getHost().isEmpty()) {
        break label276;
      }
      throw new IllegalArgumentException("AppIndex: The web URL must have a host (follow the format http(s)://<host>/[path]). Provided URI: " + localObject1);
    }
    if (zzl((Uri)localObject1))
    {
      if ((localObject2 != null) && (!((String)localObject2).equals(((Uri)localObject1).getHost()))) {
        throw new IllegalArgumentException("AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/[host_path]. Provided URI: " + localObject1);
      }
      List localList = ((Uri)localObject1).getPathSegments();
      if ((localList.isEmpty()) || (((String)localList.get(0)).isEmpty())) {
        throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + localObject1);
      }
    }
    else
    {
      throw new IllegalArgumentException("AppIndex: The URI scheme must either be 'http(s)' or 'android-app'. If the latter, it must follow the format 'android-app://<package_name>/<scheme>/[host_path]'. Provided URI: " + localObject1);
    }
    label276:
    boolean bool1;
    boolean bool2;
    if (zzk((Uri)localObject1))
    {
      localObject1 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
      paramAction = UsageInfo.zza$262286ff((Intent)localObject1, (String)localObject4, paramAction, str);
      int j = 0;
      if (((Bundle)localObject3).containsKey(".private:ssbContext"))
      {
        paramAction.zza(DocumentSection.zzh(((Bundle)localObject3).getByteArray(".private:ssbContext")));
        ((Bundle)localObject3).remove(".private:ssbContext");
      }
      if (((Bundle)localObject3).containsKey(".private:accountName"))
      {
        zzTI = new Account(((Bundle)localObject3).getString(".private:accountName"), "com.google");
        ((Bundle)localObject3).remove(".private:accountName");
      }
      int i = j;
      if (((Bundle)localObject3).containsKey(".private:isContextOnly"))
      {
        i = j;
        if (((Bundle)localObject3).getBoolean(".private:isContextOnly"))
        {
          i = 4;
          ((Bundle)localObject3).remove(".private:isContextOnly");
        }
      }
      bool1 = false;
      if (((Bundle)localObject3).containsKey(".private:isDeviceOnly"))
      {
        bool1 = ((Bundle)localObject3).getBoolean(".private:isDeviceOnly", false);
        ((Bundle)localObject3).remove(".private:isDeviceOnly");
      }
      localObject3 = zzkj.zzg((Bundle)localObject3);
      localObject4 = new RegisterSectionInfo.zza(".private:action");
      zzUl = true;
      zzUr = ".private:action";
      zzUk = "blob";
      localObject4 = ((RegisterSectionInfo.zza)localObject4).zzmh();
      paramAction.zza(new DocumentSection(zzsu.toByteArray((zzsu)localObject3), (RegisterSectionInfo)localObject4));
      localObject3 = new UsageInfo.zza();
      zzUs = UsageInfo.zza((String)localObject2, (Intent)localObject1);
      zzUt = l;
      zzUu = i;
      localObject1 = zzTG;
      bool2 = zzTH;
      localObject2 = zzTI;
      if (zzTF == null) {
        break label760;
      }
    }
    label760:
    for (paramAction = (DocumentSection[])zzTF.toArray(new DocumentSection[zzTF.size()]);; paramAction = null)
    {
      zzUv = new DocumentContents((String)localObject1, bool2, (Account)localObject2, paramAction);
      zzUw = bool1;
      zzUy = paramInt;
      paramAction = new UsageInfo(zzUs, zzUt, zzUu, zzOJ, zzUv, zzUw, zzUx, zzUy, (byte)0);
      paramGoogleApiClient.zza(new zzc(paramGoogleApiClient)
      {
        protected final void zza(zzkf paramAnonymouszzkf)
          throws RemoteException
        {
          paramAnonymouszzkf.zza(new zzkk.zzd(this), zzUA, zzUB);
        }
      });
      if (zzl((Uri)localObject1))
      {
        localObject1 = new Intent("android.intent.action.VIEW", zzj((Uri)localObject1));
        break;
      }
      throw new RuntimeException("appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: " + localObject1);
    }
  }
  
  private static Uri zzj(Uri paramUri)
  {
    List localList = paramUri.getPathSegments();
    String str = (String)localList.get(0);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme(str);
    if (localList.size() > 1)
    {
      localBuilder.authority((String)localList.get(1));
      int i = 2;
      while (i < localList.size())
      {
        localBuilder.appendPath((String)localList.get(i));
        i += 1;
      }
    }
    localBuilder.encodedQuery(paramUri.getEncodedQuery());
    localBuilder.encodedFragment(paramUri.getEncodedFragment());
    return localBuilder.build();
  }
  
  private static boolean zzk(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equals(paramUri)) || ("https".equals(paramUri));
  }
  
  private static boolean zzl(Uri paramUri)
  {
    return "android-app".equals(paramUri.getScheme());
  }
  
  public final PendingResult<Status> end(GoogleApiClient paramGoogleApiClient, Action paramAction)
  {
    return zza(paramGoogleApiClient, paramAction, 2);
  }
  
  public final PendingResult<Status> start(GoogleApiClient paramGoogleApiClient, Action paramAction)
  {
    return zza(paramGoogleApiClient, paramAction, 1);
  }
  
  private static abstract class zzb<T extends Result>
    extends zza.zza<T, zzki>
  {
    public zzb(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected abstract void zza(zzkf paramzzkf)
      throws RemoteException;
  }
  
  private static abstract class zzc<T extends Result>
    extends zzkk.zzb<Status>
  {
    zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
  }
  
  private static final class zzd
    extends zzkh<Status>
  {
    public zzd(zza.zzb<Status> paramzzb)
    {
      super();
    }
    
    public final void zza(Status paramStatus)
    {
      zzUz.zzs(paramStatus);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */