package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.common.DeviceIdentifierProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.HashMap;
import java.util.Map;

public final class Beta
  extends Kit<Boolean>
  implements DeviceIdentifierProvider
{
  private final MemoryValueCache<String> deviceTokenCache = new MemoryValueCache();
  private final DeviceTokenLoader deviceTokenLoader = new DeviceTokenLoader();
  private UpdatesController updatesController;
  
  private String getBetaDeviceToken(Context paramContext, String paramString)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 11) {
      if (paramString == null) {
        bool = true;
      }
    }
    while (bool)
    {
      Fabric.getLogger().d("Beta", "App was possibly installed by Beta. Getting device token");
      try
      {
        paramContext = (String)deviceTokenCache.get(paramContext, deviceTokenLoader);
        bool = "".equals(paramContext);
        if (bool)
        {
          return null;
          bool = false;
          continue;
          bool = "io.crash.air".equals(paramString);
        }
        else
        {
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        Fabric.getLogger().e("Beta", "Failed to load the Beta device token", paramContext);
        return null;
      }
    }
    Fabric.getLogger().d("Beta", "App was not installed by Beta. Skipping device token");
    return null;
  }
  
  /* Error */
  private static BuildProperties loadBuildProperties(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_0
    //   10: invokevirtual 87	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: ldc 89
    //   15: invokevirtual 95	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_0
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +125 -> 147
    //   25: aload_0
    //   26: astore_2
    //   27: aload_0
    //   28: astore_1
    //   29: new 97	java/util/Properties
    //   32: dup
    //   33: invokespecial 98	java/util/Properties:<init>	()V
    //   36: astore_3
    //   37: aload_0
    //   38: astore_2
    //   39: aload_0
    //   40: astore_1
    //   41: aload_3
    //   42: aload_0
    //   43: invokevirtual 102	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   46: aload_0
    //   47: astore_2
    //   48: aload_0
    //   49: astore_1
    //   50: new 104	com/crashlytics/android/beta/BuildProperties
    //   53: dup
    //   54: aload_3
    //   55: ldc 106
    //   57: invokevirtual 110	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   60: aload_3
    //   61: ldc 112
    //   63: invokevirtual 110	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   66: aload_3
    //   67: ldc 114
    //   69: invokevirtual 110	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   72: aload_3
    //   73: ldc 116
    //   75: invokevirtual 110	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   78: invokespecial 119	com/crashlytics/android/beta/BuildProperties:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   81: astore_3
    //   82: invokestatic 45	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   85: ldc 47
    //   87: new 121	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   94: aload_3
    //   95: getfield 126	com/crashlytics/android/beta/BuildProperties:packageName	Ljava/lang/String;
    //   98: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc -124
    //   103: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_3
    //   107: getfield 135	com/crashlytics/android/beta/BuildProperties:versionName	Ljava/lang/String;
    //   110: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc -119
    //   115: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_3
    //   119: getfield 140	com/crashlytics/android/beta/BuildProperties:versionCode	Ljava/lang/String;
    //   122: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc -114
    //   127: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: getfield 145	com/crashlytics/android/beta/BuildProperties:buildId	Ljava/lang/String;
    //   134: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokeinterface 55 3 0
    //   145: aload_3
    //   146: astore_1
    //   147: aload_1
    //   148: astore_3
    //   149: aload_0
    //   150: ifnull +9 -> 159
    //   153: aload_0
    //   154: invokevirtual 154	java/io/InputStream:close	()V
    //   157: aload_1
    //   158: astore_3
    //   159: aload_3
    //   160: areturn
    //   161: astore_0
    //   162: invokestatic 45	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   165: ldc 47
    //   167: ldc -100
    //   169: aload_0
    //   170: invokeinterface 75 4 0
    //   175: aload_1
    //   176: areturn
    //   177: astore_3
    //   178: aload_2
    //   179: astore_0
    //   180: aload 4
    //   182: astore_2
    //   183: aload_0
    //   184: astore_1
    //   185: invokestatic 45	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   188: ldc 47
    //   190: ldc -98
    //   192: aload_3
    //   193: invokeinterface 75 4 0
    //   198: aload_2
    //   199: astore_3
    //   200: aload_0
    //   201: ifnull -42 -> 159
    //   204: aload_0
    //   205: invokevirtual 154	java/io/InputStream:close	()V
    //   208: aload_2
    //   209: areturn
    //   210: astore_0
    //   211: invokestatic 45	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   214: ldc 47
    //   216: ldc -100
    //   218: aload_0
    //   219: invokeinterface 75 4 0
    //   224: aload_2
    //   225: areturn
    //   226: astore_0
    //   227: aload_1
    //   228: ifnull +7 -> 235
    //   231: aload_1
    //   232: invokevirtual 154	java/io/InputStream:close	()V
    //   235: aload_0
    //   236: athrow
    //   237: astore_1
    //   238: invokestatic 45	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   241: ldc 47
    //   243: ldc -100
    //   245: aload_1
    //   246: invokeinterface 75 4 0
    //   251: goto -16 -> 235
    //   254: astore_2
    //   255: aload_0
    //   256: astore_1
    //   257: aload_2
    //   258: astore_0
    //   259: goto -32 -> 227
    //   262: astore_1
    //   263: aload_3
    //   264: astore_2
    //   265: aload_1
    //   266: astore_3
    //   267: goto -84 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramContext	Context
    //   1	231	1	localObject1	Object
    //   237	9	1	localIOException	java.io.IOException
    //   256	1	1	localContext	Context
    //   262	4	1	localException1	Exception
    //   3	222	2	localObject2	Object
    //   254	4	2	localObject3	Object
    //   264	1	2	localObject4	Object
    //   8	152	3	localObject5	Object
    //   177	16	3	localException2	Exception
    //   199	68	3	localObject6	Object
    //   5	176	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   153	157	161	java/io/IOException
    //   9	19	177	java/lang/Exception
    //   29	37	177	java/lang/Exception
    //   41	46	177	java/lang/Exception
    //   50	82	177	java/lang/Exception
    //   204	208	210	java/io/IOException
    //   9	19	226	finally
    //   29	37	226	finally
    //   41	46	226	finally
    //   50	82	226	finally
    //   185	198	226	finally
    //   231	235	237	java/io/IOException
    //   82	145	254	finally
    //   82	145	262	java/lang/Exception
  }
  
  public final Map<IdManager.DeviceIdentifierType, String> getDeviceIdentifiers()
  {
    String str = idManager.getInstallerPackageName();
    str = getBetaDeviceToken(context, str);
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(str)) {
      localHashMap.put(IdManager.DeviceIdentifierType.FONT_TOKEN, str);
    }
    return localHashMap;
  }
  
  public final String getIdentifier()
  {
    return "com.crashlytics.sdk.android:beta";
  }
  
  public final String getVersion()
  {
    return "1.1.4.92";
  }
  
  @TargetApi(14)
  protected final boolean onPreExecute()
  {
    context.getApplicationContext();
    if (Build.VERSION.SDK_INT >= 14) {}
    for (Object localObject = new ActivityLifecycleCheckForUpdatesController(fabric.activityLifecycleManager, fabric.executorService);; localObject = new ImmediateCheckForUpdatesController())
    {
      updatesController = ((UpdatesController)localObject);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.Beta
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */