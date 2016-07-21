package com.crashlytics.android.core;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class MetaDataStore
{
  static final Charset UTF_8 = Charset.forName("UTF-8");
  private final File filesDir;
  
  public MetaDataStore(File paramFile)
  {
    filesDir = paramFile;
  }
  
  private static Map<String, String> jsonToKeysData(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramString.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, valueOrNull(paramString, str));
    }
    return localHashMap;
  }
  
  static String keysDataToJson(Map<String, String> paramMap)
    throws JSONException
  {
    return new JSONObject(paramMap).toString();
  }
  
  static String userDataToJson(UserMetaData paramUserMetaData)
    throws JSONException
  {
    new JSONObject() {}.toString();
  }
  
  private static String valueOrNull(JSONObject paramJSONObject, String paramString)
  {
    String str = null;
    if (!paramJSONObject.isNull(paramString)) {
      str = paramJSONObject.optString(paramString, null);
    }
    return str;
  }
  
  final File getKeysFileForSession(String paramString)
  {
    return new File(filesDir, paramString + "keys.meta");
  }
  
  final File getUserDataFileForSession(String paramString)
  {
    return new File(filesDir, paramString + "user.meta");
  }
  
  /* Error */
  public final Map<String, String> readKeyData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 119	com/crashlytics/android/core/MetaDataStore:getKeysFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_2
    //   6: aload_2
    //   7: invokevirtual 122	java/io/File:exists	()Z
    //   10: ifne +7 -> 17
    //   13: invokestatic 128	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   16: areturn
    //   17: aconst_null
    //   18: astore_1
    //   19: aconst_null
    //   20: astore_3
    //   21: new 130	java/io/FileInputStream
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_2
    //   30: aload_2
    //   31: invokestatic 138	io/fabric/sdk/android/services/common/CommonUtils:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   34: invokestatic 140	com/crashlytics/android/core/MetaDataStore:jsonToKeysData	(Ljava/lang/String;)Ljava/util/Map;
    //   37: astore_1
    //   38: aload_2
    //   39: ldc -114
    //   41: invokestatic 146	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: aload_3
    //   48: astore_2
    //   49: aload_1
    //   50: astore_3
    //   51: aload_2
    //   52: astore_1
    //   53: invokestatic 152	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   56: ldc -102
    //   58: ldc -100
    //   60: aload_3
    //   61: invokeinterface 162 4 0
    //   66: aload_2
    //   67: ldc -114
    //   69: invokestatic 146	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   72: invokestatic 128	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   75: areturn
    //   76: astore_2
    //   77: aload_1
    //   78: ldc -114
    //   80: invokestatic 146	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   83: aload_2
    //   84: athrow
    //   85: astore_3
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: astore_2
    //   90: goto -13 -> 77
    //   93: astore_3
    //   94: goto -43 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	MetaDataStore
    //   0	97	1	paramString	String
    //   5	62	2	localObject1	Object
    //   76	11	2	localObject2	Object
    //   89	1	2	localObject3	Object
    //   20	41	3	str	String
    //   85	4	3	localObject4	Object
    //   93	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   21	30	46	java/lang/Exception
    //   21	30	76	finally
    //   53	66	76	finally
    //   30	38	85	finally
    //   30	38	93	java/lang/Exception
  }
  
  /* Error */
  public final UserMetaData readUserData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 166	com/crashlytics/android/core/MetaDataStore:getUserDataFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_2
    //   6: aload_2
    //   7: invokevirtual 122	java/io/File:exists	()Z
    //   10: ifne +7 -> 17
    //   13: getstatic 172	com/crashlytics/android/core/UserMetaData:EMPTY	Lcom/crashlytics/android/core/UserMetaData;
    //   16: areturn
    //   17: aconst_null
    //   18: astore_1
    //   19: aconst_null
    //   20: astore_3
    //   21: new 130	java/io/FileInputStream
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_2
    //   30: new 35	org/json/JSONObject
    //   33: dup
    //   34: aload_2
    //   35: invokestatic 138	io/fabric/sdk/android/services/common/CommonUtils:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   38: invokespecial 38	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: new 168	com/crashlytics/android/core/UserMetaData
    //   45: dup
    //   46: aload_1
    //   47: ldc -82
    //   49: invokestatic 61	com/crashlytics/android/core/MetaDataStore:valueOrNull	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   52: aload_1
    //   53: ldc -80
    //   55: invokestatic 61	com/crashlytics/android/core/MetaDataStore:valueOrNull	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   58: aload_1
    //   59: ldc -78
    //   61: invokestatic 61	com/crashlytics/android/core/MetaDataStore:valueOrNull	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   64: invokespecial 181	com/crashlytics/android/core/UserMetaData:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   67: astore_1
    //   68: aload_2
    //   69: ldc -114
    //   71: invokestatic 146	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   74: aload_1
    //   75: areturn
    //   76: astore_1
    //   77: aload_3
    //   78: astore_2
    //   79: aload_1
    //   80: astore_3
    //   81: aload_2
    //   82: astore_1
    //   83: invokestatic 152	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   86: ldc -102
    //   88: ldc -100
    //   90: aload_3
    //   91: invokeinterface 162 4 0
    //   96: aload_2
    //   97: ldc -114
    //   99: invokestatic 146	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   102: getstatic 172	com/crashlytics/android/core/UserMetaData:EMPTY	Lcom/crashlytics/android/core/UserMetaData;
    //   105: areturn
    //   106: astore_2
    //   107: aload_1
    //   108: ldc -114
    //   110: invokestatic 146	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   113: aload_2
    //   114: athrow
    //   115: astore_3
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: astore_2
    //   120: goto -13 -> 107
    //   123: astore_3
    //   124: goto -43 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	MetaDataStore
    //   0	127	1	paramString	String
    //   5	92	2	localObject1	Object
    //   106	11	2	localObject2	Object
    //   119	1	2	localObject3	Object
    //   20	71	3	str	String
    //   115	4	3	localObject4	Object
    //   123	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   21	30	76	java/lang/Exception
    //   21	30	106	finally
    //   83	96	106	finally
    //   30	68	115	finally
    //   30	68	123	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.MetaDataStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */