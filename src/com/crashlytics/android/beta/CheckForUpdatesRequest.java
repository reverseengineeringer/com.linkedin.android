package com.crashlytics.android.beta;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class CheckForUpdatesRequest
  extends AbstractSpiCall
{
  private final CheckForUpdatesResponseTransform responseTransform;
  
  public CheckForUpdatesRequest(Kit paramKit, String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, CheckForUpdatesResponseTransform paramCheckForUpdatesResponseTransform)
  {
    super(paramKit, paramString1, paramString2, paramHttpRequestFactory, HttpMethod.GET);
    responseTransform = paramCheckForUpdatesResponseTransform;
  }
  
  public final CheckForUpdatesResponse invoke(String paramString1, String paramString2, BuildProperties paramBuildProperties)
  {
    String str2 = null;
    String str1 = null;
    localObject2 = str1;
    localObject1 = str2;
    try
    {
      HashMap localHashMap = new HashMap();
      localObject2 = str1;
      localObject1 = str2;
      localHashMap.put("build_version", versionCode);
      localObject2 = str1;
      localObject1 = str2;
      localHashMap.put("display_version", versionName);
      localObject2 = str1;
      localObject1 = str2;
      localHashMap.put("instance", buildId);
      localObject2 = str1;
      localObject1 = str2;
      localHashMap.put("source", "3");
      localObject2 = str1;
      localObject1 = str2;
      paramBuildProperties = getHttpRequest(localHashMap);
      localObject2 = paramBuildProperties;
      localObject1 = paramBuildProperties;
      paramString1 = paramBuildProperties.header("Accept", "application/json").header("User-Agent", "Crashlytics Android SDK/" + kit.getVersion()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).header("X-CRASHLYTICS-API-KEY", paramString1).header("X-CRASHLYTICS-BETA-TOKEN", "3:" + paramString2);
      localObject2 = paramString1;
      localObject1 = paramString1;
      Fabric.getLogger().d("Beta", "Checking for updates from " + url);
      localObject2 = paramString1;
      localObject1 = paramString1;
      Fabric.getLogger().d("Beta", "Checking for updates query params are: " + localHashMap);
      localObject2 = paramString1;
      localObject1 = paramString1;
      if (200 == paramString1.code()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject2 = paramString1;
        localObject1 = paramString1;
        Fabric.getLogger().d("Beta", "Checking for updates was successful");
        localObject2 = paramString1;
        localObject1 = paramString1;
        paramString2 = new JSONObject(paramString1.body());
        localObject2 = paramString1;
        localObject1 = paramString1;
        paramBuildProperties = paramString2.optString("url", null);
        localObject2 = paramString1;
        localObject1 = paramString1;
        str1 = paramString2.optString("version_string", null);
        localObject2 = paramString1;
        localObject1 = paramString1;
        str2 = paramString2.optString("build_version", null);
        localObject2 = paramString1;
        localObject1 = paramString1;
        paramString2 = new CheckForUpdatesResponse(paramBuildProperties, str1, paramString2.optString("display_version", null), str2, paramString2.optString("identifier", null), paramString2.optString("instance_identifier", null));
        if (paramString1 != null)
        {
          paramString1 = paramString1.header("X-REQUEST-ID");
          Fabric.getLogger().d("Fabric", "Checking for updates request ID: " + paramString1);
        }
        return paramString2;
      }
      localObject2 = paramString1;
      localObject1 = paramString1;
      Fabric.getLogger().e("Beta", "Checking for updates failed. Response code: " + paramString1.code());
      if (paramString1 != null)
      {
        paramString1 = paramString1.header("X-REQUEST-ID");
        Fabric.getLogger().d("Fabric", "Checking for updates request ID: " + paramString1);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        localObject1 = localObject2;
        Fabric.getLogger().e("Beta", "Error while checking for updates from " + url, paramString1);
        if (localObject2 != null)
        {
          paramString1 = ((HttpRequest)localObject2).header("X-REQUEST-ID");
          Fabric.getLogger().d("Fabric", "Checking for updates request ID: " + paramString1);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label667;
      }
      paramString2 = ((HttpRequest)localObject1).header("X-REQUEST-ID");
      Fabric.getLogger().d("Fabric", "Checking for updates request ID: " + paramString2);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.CheckForUpdatesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */