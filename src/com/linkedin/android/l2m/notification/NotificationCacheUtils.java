package com.linkedin.android.l2m.notification;

import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.logger.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class NotificationCacheUtils
{
  private static final String TAG = NotificationCacheUtils.class.getSimpleName();
  
  public static void deleteNotificationFromCache(FlagshipCacheManager paramFlagshipCacheManager, int paramInt)
  {
    Object localObject = null;
    try
    {
      FissionTransaction localFissionTransaction = paramFlagshipCacheManager.createTransaction(false);
      localObject = localFissionTransaction;
      paramFlagshipCacheManager.writeToCache(String.valueOf(paramInt), null, 0, localFissionTransaction);
      if (localFissionTransaction != null)
      {
        localObject = localFissionTransaction;
        localFissionTransaction.commit();
      }
      return;
    }
    catch (IOException paramFlagshipCacheManager)
    {
      do
      {
        Log.e(TAG, "Unable to clear the notification cache: " + paramFlagshipCacheManager.getMessage(), paramFlagshipCacheManager);
      } while (localObject == null);
      try
      {
        ((FissionTransaction)localObject).abort();
        return;
      }
      catch (IOException paramFlagshipCacheManager) {}
    }
  }
  
  /* Error */
  public static List<NotificationPayload> fetchCachedNotificationsFromId(String paramString, FlagshipCacheManager paramFlagshipCacheManager)
  {
    // Byte code:
    //   0: new 77	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 78	java/util/ArrayList:<init>	()V
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 9
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 6
    //   24: aload 9
    //   26: astore_3
    //   27: aload 10
    //   29: astore 4
    //   31: aload 11
    //   33: astore 7
    //   35: aload_1
    //   36: iconst_1
    //   37: invokevirtual 30	com/linkedin/android/infra/data/FlagshipCacheManager:createTransaction	(Z)Lcom/linkedin/android/fission/interfaces/FissionTransaction;
    //   40: astore 8
    //   42: aload 9
    //   44: astore_3
    //   45: aload 8
    //   47: astore 6
    //   49: aload 10
    //   51: astore 4
    //   53: aload 11
    //   55: astore 7
    //   57: aload 8
    //   59: astore 5
    //   61: aload_1
    //   62: aload_0
    //   63: aload 8
    //   65: invokevirtual 82	com/linkedin/android/infra/data/FlagshipCacheManager:readFromCache	(Ljava/lang/String;Lcom/linkedin/android/fission/interfaces/FissionTransaction;)Ljava/nio/ByteBuffer;
    //   68: astore_0
    //   69: aload_0
    //   70: ifnonnull +96 -> 166
    //   73: aload_0
    //   74: astore_3
    //   75: aload 8
    //   77: astore 6
    //   79: aload_0
    //   80: astore 4
    //   82: aload_0
    //   83: astore 7
    //   85: aload 8
    //   87: astore 5
    //   89: new 84	org/json/JSONArray
    //   92: dup
    //   93: invokespecial 85	org/json/JSONArray:<init>	()V
    //   96: astore 9
    //   98: goto +217 -> 315
    //   101: aload_0
    //   102: astore_3
    //   103: aload 8
    //   105: astore 6
    //   107: aload_0
    //   108: astore 4
    //   110: aload_0
    //   111: astore 7
    //   113: aload 8
    //   115: astore 5
    //   117: iload_2
    //   118: aload 9
    //   120: invokevirtual 89	org/json/JSONArray:length	()I
    //   123: if_icmpge +127 -> 250
    //   126: aload_0
    //   127: astore_3
    //   128: aload 8
    //   130: astore 6
    //   132: aload_0
    //   133: astore 4
    //   135: aload_0
    //   136: astore 7
    //   138: aload 8
    //   140: astore 5
    //   142: aload 12
    //   144: aload 9
    //   146: iload_2
    //   147: invokevirtual 93	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   150: invokestatic 99	com/linkedin/android/l2m/notification/NotificationPayload:newInstance	(Lorg/json/JSONObject;)Lcom/linkedin/android/l2m/notification/NotificationPayload;
    //   153: invokeinterface 105 2 0
    //   158: pop
    //   159: iload_2
    //   160: iconst_1
    //   161: iadd
    //   162: istore_2
    //   163: goto -62 -> 101
    //   166: aload_0
    //   167: astore_3
    //   168: aload 8
    //   170: astore 6
    //   172: aload_0
    //   173: astore 4
    //   175: aload_0
    //   176: astore 7
    //   178: aload 8
    //   180: astore 5
    //   182: new 84	org/json/JSONArray
    //   185: dup
    //   186: new 32	java/lang/String
    //   189: dup
    //   190: aload_0
    //   191: invokevirtual 111	java/nio/ByteBuffer:array	()[B
    //   194: invokespecial 114	java/lang/String:<init>	([B)V
    //   197: invokespecial 115	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   200: astore 9
    //   202: goto +113 -> 315
    //   205: astore_0
    //   206: aload 6
    //   208: astore 5
    //   210: aload_3
    //   211: astore 4
    //   213: getstatic 16	com/linkedin/android/l2m/notification/NotificationCacheUtils:TAG	Ljava/lang/String;
    //   216: ldc 117
    //   218: aload_0
    //   219: invokestatic 68	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   222: pop
    //   223: aload 5
    //   225: ifnull +13 -> 238
    //   228: aload_3
    //   229: astore 4
    //   231: aload 5
    //   233: invokeinterface 71 1 0
    //   238: aload_3
    //   239: ifnull +8 -> 247
    //   242: aload_1
    //   243: aload_3
    //   244: invokevirtual 121	com/linkedin/android/infra/data/FlagshipCacheManager:recycle	(Ljava/nio/ByteBuffer;)V
    //   247: aload 12
    //   249: areturn
    //   250: aload 8
    //   252: ifnull +26 -> 278
    //   255: aload_0
    //   256: astore_3
    //   257: aload 8
    //   259: astore 6
    //   261: aload_0
    //   262: astore 4
    //   264: aload_0
    //   265: astore 7
    //   267: aload 8
    //   269: astore 5
    //   271: aload 8
    //   273: invokeinterface 45 1 0
    //   278: aload_0
    //   279: ifnull -32 -> 247
    //   282: aload_1
    //   283: aload_0
    //   284: invokevirtual 121	com/linkedin/android/infra/data/FlagshipCacheManager:recycle	(Ljava/nio/ByteBuffer;)V
    //   287: aload 12
    //   289: areturn
    //   290: astore_0
    //   291: aload 4
    //   293: ifnull +9 -> 302
    //   296: aload_1
    //   297: aload 4
    //   299: invokevirtual 121	com/linkedin/android/infra/data/FlagshipCacheManager:recycle	(Ljava/nio/ByteBuffer;)V
    //   302: aload_0
    //   303: athrow
    //   304: astore_0
    //   305: aload 7
    //   307: astore_3
    //   308: goto -98 -> 210
    //   311: astore_0
    //   312: goto -74 -> 238
    //   315: iconst_0
    //   316: istore_2
    //   317: goto -216 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramString	String
    //   0	320	1	paramFlagshipCacheManager	FlagshipCacheManager
    //   117	200	2	i	int
    //   26	282	3	localObject1	Object
    //   29	269	4	localObject2	Object
    //   19	251	5	localObject3	Object
    //   22	238	6	localObject4	Object
    //   33	273	7	localObject5	Object
    //   40	232	8	localFissionTransaction	FissionTransaction
    //   16	185	9	localJSONArray	JSONArray
    //   10	40	10	localObject6	Object
    //   13	41	11	localObject7	Object
    //   7	281	12	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   35	42	205	java/io/IOException
    //   61	69	205	java/io/IOException
    //   89	98	205	java/io/IOException
    //   117	126	205	java/io/IOException
    //   142	159	205	java/io/IOException
    //   182	202	205	java/io/IOException
    //   271	278	205	java/io/IOException
    //   35	42	290	finally
    //   61	69	290	finally
    //   89	98	290	finally
    //   117	126	290	finally
    //   142	159	290	finally
    //   182	202	290	finally
    //   213	223	290	finally
    //   231	238	290	finally
    //   271	278	290	finally
    //   35	42	304	org/json/JSONException
    //   61	69	304	org/json/JSONException
    //   89	98	304	org/json/JSONException
    //   117	126	304	org/json/JSONException
    //   142	159	304	org/json/JSONException
    //   182	202	304	org/json/JSONException
    //   271	278	304	org/json/JSONException
    //   231	238	311	java/io/IOException
  }
  
  public static void updateCachedNotification(NotificationPayload paramNotificationPayload, FlagshipCacheManager paramFlagshipCacheManager)
  {
    Object localObject2 = null;
    String str = String.valueOf(NotificationIdUtils.computeNotificationId(paramNotificationPayload));
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONArray();
      localObject1 = localObject2;
      Iterator localIterator = fetchCachedNotificationsFromId(str, paramFlagshipCacheManager).iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = localObject2;
        ((JSONArray)localObject3).put(((NotificationPayload)localIterator.next()).toJsonObject());
      }
      return;
    }
    catch (IOException paramNotificationPayload)
    {
      Log.e(TAG, "Unable to save messenger notifications to disk", paramNotificationPayload);
      if (localObject1 != null) {}
      do
      {
        try
        {
          ((FissionTransaction)localObject1).abort();
          return;
        }
        catch (IOException paramNotificationPayload) {}
        localObject1 = localObject2;
        ((JSONArray)localObject3).put(paramNotificationPayload.toJsonObject());
        localObject1 = localObject2;
        localObject3 = ByteBuffer.wrap(((JSONArray)localObject3).toString().getBytes());
        localObject1 = localObject2;
        paramNotificationPayload = paramFlagshipCacheManager.createTransaction(false);
        localObject1 = paramNotificationPayload;
        paramFlagshipCacheManager.writeToCache(str, (ByteBuffer)localObject3, ((ByteBuffer)localObject3).array().length, paramNotificationPayload);
      } while (paramNotificationPayload == null);
      localObject1 = paramNotificationPayload;
      paramNotificationPayload.commit();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationCacheUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */