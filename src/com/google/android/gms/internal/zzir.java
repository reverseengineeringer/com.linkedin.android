package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzir
{
  public static final Handler zzMc = new zzio(Looper.getMainLooper());
  private boolean zzMd = true;
  private boolean zzMe = false;
  private final Object zzpV = new Object();
  private String zzzN;
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    zzMc.post(paramRunnable);
  }
  
  protected static String zzK(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }
  
  public static AlertDialog.Builder zzL(Context paramContext)
  {
    return new AlertDialog.Builder(paramContext);
  }
  
  public static zzbl zzM(Context paramContext)
  {
    return new zzbl(paramContext);
  }
  
  public static DisplayMetrics zza(WindowManager paramWindowManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static String zza(zzjp paramzzjp, String paramString)
  {
    paramzzjp.getContext();
    return zza$59a1f809(paramzzjp.zzhW(), paramString);
  }
  
  private JSONArray zza(Collection<?> paramCollection)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      zza(localJSONArray, paramCollection.next());
    }
    return localJSONArray;
  }
  
  public static void zza(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
  }
  
  public static void zza(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().addOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  private static void zza(Context paramContext, String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      new zziy(paramContext, paramString, (String)paramList.next()).zzhn();
    }
  }
  
  public static void zza(Context paramContext, String paramString1, List<String> paramList, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      new zziy(paramContext, paramString1, (String)paramList.next(), paramString2).zzhn();
    }
  }
  
  private void zza(JSONArray paramJSONArray, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(zzf((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(zzG((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(zza((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      JSONArray localJSONArray = new JSONArray();
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        zza(localJSONArray, paramObject[i]);
        i += 1;
      }
      paramJSONArray.put(localJSONArray);
      return;
    }
    paramJSONArray.put(paramObject);
  }
  
  private void zza(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, zzf((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, zzG((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      if (paramString != null) {}
      for (;;)
      {
        paramJSONObject.put(paramString, zza((Collection)paramObject));
        return;
        paramString = "null";
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONObject.put(paramString, zza(Arrays.asList((Object[])paramObject)));
      return;
    }
    paramJSONObject.put(paramString, paramObject);
  }
  
  public static boolean zza(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    return paramPackageManager.checkPermission(paramString2, paramString1) == 0;
  }
  
  public static void zza$2d8d796a$11657ff2(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(true);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", paramString);
    paramHttpURLConnection.setUseCaches(false);
  }
  
  public static PopupWindow zza$490f73c3(View paramView, int paramInt1, int paramInt2)
  {
    return new PopupWindow(paramView, paramInt1, paramInt2, false);
  }
  
  private static String zza$59a1f809(zzan paramzzan, String paramString)
  {
    int k = 0;
    if (paramzzan == null) {
      return paramString;
    }
    try
    {
      Uri localUri = Uri.parse(paramString);
      int j = k;
      Object localObject;
      int m;
      int i;
      if (paramzzan.zzb(localUri))
      {
        localObject = zzan.zzov;
        m = localObject.length;
        i = 0;
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          String str = localObject[i];
          if (localUri.getPath().endsWith(str)) {
            j = 1;
          }
        }
        else
        {
          localObject = localUri;
          if (j != 0) {
            localObject = paramzzan.zza$7d090533(localUri);
          }
          paramzzan = ((Uri)localObject).toString();
          return paramzzan;
        }
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramzzan) {}
  }
  
  public static void zza$6b82a487(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject2 = paramContext.getApplicationContext();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext;
    }
    paramBundle.putString("os", Build.VERSION.RELEASE);
    paramBundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
    zzr.zzbC();
    paramBundle.putString("device", zzht());
    paramBundle.putString("appid", ((Context)localObject1).getPackageName());
    paramBundle.putString("eids", TextUtils.join(",", zzbt.zzdr()));
    if (paramString1 != null) {
      paramBundle.putString("js", paramString1);
    }
    for (;;)
    {
      paramString2 = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", paramString2);
      localObject1 = paramBundle.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        paramString2.appendQueryParameter((String)localObject2, paramBundle.getString((String)localObject2));
      }
      paramBundle.putString("gmscore_version", Integer.toString(zze.zzaj(paramContext)));
    }
    zzr.zzbC();
    paramString2 = paramString2.toString();
    paramBundle = new ArrayList();
    paramBundle.add(paramString2);
    zza(paramContext, paramString1, paramBundle);
  }
  
  public static int zzaD(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      zzin.zzaK("Could not parse value:" + paramString);
    }
    return 0;
  }
  
  public static boolean zzaE(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
  }
  
  public static void zzb(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  public static void zzb(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public static Map<String, String> zze(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzr.zzbE().zzf(paramUri).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramUri.getQueryParameter(str));
    }
    return localHashMap;
  }
  
  public static int[] zze(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.findViewById(16908290);
      if (paramActivity != null) {
        return new int[] { paramActivity.getWidth(), paramActivity.getHeight() };
      }
    }
    return zzhu();
  }
  
  public static Bitmap zzf(Context paramContext, String paramString)
  {
    zzx.zzcE("getBackgroundImage must not be called on the main UI thread.");
    try
    {
      paramContext = paramContext.openFileInput(paramString);
      paramString = BitmapFactory.decodeStream(paramContext);
      paramContext.close();
      return paramString;
    }
    catch (Exception paramContext)
    {
      zzin.e("Fail to get background image");
    }
    return null;
  }
  
  private JSONObject zzf(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }
  
  public static int[] zzf(Activity paramActivity)
  {
    int[] arrayOfInt = zze(paramActivity);
    zzn.zzcS();
    int i = zza.zzc(paramActivity, arrayOfInt[0]);
    zzn.zzcS();
    return new int[] { i, zza.zzc(paramActivity, arrayOfInt[1]) };
  }
  
  public static int[] zzh(Activity paramActivity)
  {
    Object localObject = paramActivity.getWindow();
    if (localObject != null)
    {
      View localView = ((Window)localObject).findViewById(16908290);
      if (localView != null)
      {
        localObject = new int[2];
        localObject[0] = localView.getTop();
        localObject[1] = localView.getBottom();
      }
    }
    for (;;)
    {
      zzn.zzcS();
      int i = zza.zzc(paramActivity, localObject[0]);
      zzn.zzcS();
      return new int[] { i, zza.zzc(paramActivity, localObject[1]) };
      localObject = zzhu();
    }
  }
  
  private static String zzhr()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("Mozilla/5.0 (Linux; U; Android");
    if (Build.VERSION.RELEASE != null) {
      localStringBuffer.append(" ").append(Build.VERSION.RELEASE);
    }
    localStringBuffer.append("; ").append(Locale.getDefault());
    if (Build.DEVICE != null)
    {
      localStringBuffer.append("; ").append(Build.DEVICE);
      if (Build.DISPLAY != null) {
        localStringBuffer.append(" Build/").append(Build.DISPLAY);
      }
    }
    localStringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
    return localStringBuffer.toString();
  }
  
  public static String zzhs()
  {
    Object localObject1 = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(((UUID)localObject1).getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(((UUID)localObject1).getMostSignificantBits()).toByteArray();
    localObject1 = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (i < 2)
    {
      try
      {
        Object localObject2 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject2).update(arrayOfByte1);
        ((MessageDigest)localObject2).update(arrayOfByte2);
        byte[] arrayOfByte3 = new byte[8];
        System.arraycopy(((MessageDigest)localObject2).digest(), 0, arrayOfByte3, 0, 8);
        localObject2 = new BigInteger(1, arrayOfByte3).toString();
        localObject1 = localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return (String)localObject1;
  }
  
  public static String zzht()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1)) {
      return str2;
    }
    return str1 + " " + str2;
  }
  
  private static int[] zzhu()
  {
    return new int[] { 0, 0 };
  }
  
  public static Bitmap zzk(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }
  
  public final JSONObject zzG(Map<String, ?> paramMap)
    throws JSONException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        zza(localJSONObject, str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (ClassCastException paramMap)
    {
      throw new JSONException("Could not convert map to JSON: " + paramMap.getMessage());
    }
  }
  
  public final void zza(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", zze(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(false);
  }
  
  public final String zze(final Context paramContext, String paramString)
  {
    synchronized (zzpV)
    {
      if (zzzN != null)
      {
        paramContext = zzzN;
        return paramContext;
      }
    }
    try
    {
      zzzN = zzr.zzbE().getDefaultUserAgent(paramContext);
      if (TextUtils.isEmpty(zzzN))
      {
        zzn.zzcS();
        if (!zza.zzhJ())
        {
          zzzN = null;
          zzMc.post(new Runnable()
          {
            public final void run()
            {
              synchronized (zzir.zza(zzir.this))
              {
                zzir.zza(zzir.this, zzir.zzK(paramContext));
                zzir.zza(zzir.this).notifyAll();
                return;
              }
            }
          });
          for (;;)
          {
            paramContext = zzzN;
            if (paramContext != null) {
              break;
            }
            try
            {
              zzpV.wait();
            }
            catch (InterruptedException paramContext)
            {
              zzzN = zzhr();
              zzin.zzaK("Interrupted, use default user agent: " + zzzN);
            }
          }
          paramContext = finally;
          throw paramContext;
        }
      }
      try
      {
        zzzN = zzK(paramContext);
        zzzN = (zzzN + " (Mobile; " + paramString + ")");
        paramContext = zzzN;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          zzzN = zzhr();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzir
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */