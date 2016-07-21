package com.linkedin.android.relationships.connections;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import com.linkedin.data.lite.JsonGenerator;
import com.linkedin.data.lite.JsonGeneratorException;
import com.linkedin.data.lite.JsonGeneratorFactory;
import com.linkedin.data.lite.UnionTemplate;
import java.io.StringWriter;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class ConnectionStoreImpl
  extends SQLiteOpenHelper
  implements ConnectionStore
{
  private static final String TAG = ConnectionStoreImpl.class.getSimpleName();
  private final FlagshipSharedPreferences sharedPreferences;
  
  @Inject
  public ConnectionStoreImpl(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    super(paramContext, "connections.db", null, 1);
    sharedPreferences = paramFlagshipSharedPreferences;
  }
  
  /* Error */
  private static Connection getConnection(Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc 42
    //   4: invokeinterface 48 2 0
    //   9: invokeinterface 52 2 0
    //   14: astore 9
    //   16: aload_0
    //   17: aload_0
    //   18: ldc 54
    //   20: invokeinterface 48 2 0
    //   25: invokeinterface 52 2 0
    //   30: astore 10
    //   32: aload_0
    //   33: aload_0
    //   34: ldc 56
    //   36: invokeinterface 48 2 0
    //   41: invokeinterface 52 2 0
    //   46: astore 7
    //   48: aload_0
    //   49: aload_0
    //   50: ldc 58
    //   52: invokeinterface 48 2 0
    //   57: invokeinterface 52 2 0
    //   62: astore 8
    //   64: aload_0
    //   65: aload_0
    //   66: ldc 60
    //   68: invokeinterface 48 2 0
    //   73: invokeinterface 52 2 0
    //   78: astore 6
    //   80: aload_0
    //   81: aload_0
    //   82: ldc 62
    //   84: invokeinterface 48 2 0
    //   89: invokeinterface 52 2 0
    //   94: astore 4
    //   96: aload_0
    //   97: aload_0
    //   98: ldc 64
    //   100: invokeinterface 48 2 0
    //   105: invokeinterface 52 2 0
    //   110: astore 5
    //   112: aload_0
    //   113: aload_0
    //   114: ldc 66
    //   116: invokeinterface 48 2 0
    //   121: invokeinterface 52 2 0
    //   126: astore_3
    //   127: aload_0
    //   128: aload_0
    //   129: ldc 68
    //   131: invokeinterface 48 2 0
    //   136: invokeinterface 52 2 0
    //   141: astore 11
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: astore_1
    //   147: aload 11
    //   149: ifnull +37 -> 186
    //   152: getstatic 74	com/linkedin/android/datamanager/DataManager:PARSER_FACTORY	Lcom/linkedin/data/lite/DataTemplateParserFactory;
    //   155: invokeinterface 80 1 0
    //   160: astore_1
    //   161: aload_1
    //   162: new 82	java/io/ByteArrayInputStream
    //   165: dup
    //   166: aload 11
    //   168: invokevirtual 88	java/lang/String:getBytes	()[B
    //   171: invokespecial 91	java/io/ByteArrayInputStream:<init>	([B)V
    //   174: getstatic 97	com/linkedin/android/pegasus/gen/voyager/common/Image:BUILDER	Lcom/linkedin/android/pegasus/gen/voyager/common/ImageBuilder;
    //   177: invokeinterface 103 3 0
    //   182: checkcast 93	com/linkedin/android/pegasus/gen/voyager/common/Image
    //   185: astore_1
    //   186: aload_0
    //   187: aload_0
    //   188: ldc 105
    //   190: invokeinterface 48 2 0
    //   195: invokeinterface 52 2 0
    //   200: astore 11
    //   202: aconst_null
    //   203: astore_2
    //   204: aload_2
    //   205: astore_0
    //   206: aload 11
    //   208: ifnull +37 -> 245
    //   211: getstatic 74	com/linkedin/android/datamanager/DataManager:PARSER_FACTORY	Lcom/linkedin/data/lite/DataTemplateParserFactory;
    //   214: invokeinterface 80 1 0
    //   219: astore_0
    //   220: aload_0
    //   221: new 82	java/io/ByteArrayInputStream
    //   224: dup
    //   225: aload 11
    //   227: invokevirtual 88	java/lang/String:getBytes	()[B
    //   230: invokespecial 91	java/io/ByteArrayInputStream:<init>	([B)V
    //   233: getstatic 97	com/linkedin/android/pegasus/gen/voyager/common/Image:BUILDER	Lcom/linkedin/android/pegasus/gen/voyager/common/ImageBuilder;
    //   236: invokeinterface 103 3 0
    //   241: checkcast 93	com/linkedin/android/pegasus/gen/voyager/common/Image
    //   244: astore_0
    //   245: new 107	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder
    //   248: dup
    //   249: invokespecial 109	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:<init>	()V
    //   252: aload_0
    //   253: invokevirtual 113	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:setBackgroundImage	(Lcom/linkedin/android/pegasus/gen/voyager/common/Image;)Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder;
    //   256: aload_1
    //   257: invokevirtual 116	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:setPicture	(Lcom/linkedin/android/pegasus/gen/voyager/common/Image;)Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder;
    //   260: aload 9
    //   262: invokevirtual 120	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:setFirstName	(Ljava/lang/String;)Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder;
    //   265: aload 10
    //   267: invokevirtual 123	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:setLastName	(Ljava/lang/String;)Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder;
    //   270: astore_0
    //   271: aload 8
    //   273: ifnonnull +150 -> 423
    //   276: aload_0
    //   277: iconst_0
    //   278: putfield 127	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:hasTrackingId	Z
    //   281: aload_0
    //   282: aconst_null
    //   283: putfield 129	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:trackingId	Ljava/lang/String;
    //   286: aload_0
    //   287: aload 7
    //   289: invokevirtual 132	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:setOccupation	(Ljava/lang/String;)Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder;
    //   292: astore_0
    //   293: new 134	com/linkedin/android/pegasus/gen/common/Urn
    //   296: dup
    //   297: aload 6
    //   299: invokespecial 137	com/linkedin/android/pegasus/gen/common/Urn:<init>	(Ljava/lang/String;)V
    //   302: astore_1
    //   303: aload_0
    //   304: iconst_1
    //   305: putfield 140	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:hasObjectUrn	Z
    //   308: aload_0
    //   309: aload_1
    //   310: putfield 143	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:objectUrn	Lcom/linkedin/android/pegasus/gen/common/Urn;
    //   313: aload_0
    //   314: new 134	com/linkedin/android/pegasus/gen/common/Urn
    //   317: dup
    //   318: aload 5
    //   320: invokespecial 137	com/linkedin/android/pegasus/gen/common/Urn:<init>	(Ljava/lang/String;)V
    //   323: invokevirtual 147	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:setEntityUrn	(Lcom/linkedin/android/pegasus/gen/common/Urn;)Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder;
    //   326: aload 4
    //   328: invokevirtual 150	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:setPublicIdentifier	(Ljava/lang/String;)Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder;
    //   331: getstatic 156	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   334: invokevirtual 160	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile;
    //   337: astore_0
    //   338: new 162	com/linkedin/android/pegasus/gen/voyager/relationships/shared/connection/Connection$Builder
    //   341: dup
    //   342: invokespecial 163	com/linkedin/android/pegasus/gen/voyager/relationships/shared/connection/Connection$Builder:<init>	()V
    //   345: astore_1
    //   346: aload_1
    //   347: iconst_1
    //   348: putfield 166	com/linkedin/android/pegasus/gen/voyager/relationships/shared/connection/Connection$Builder:hasMiniProfile	Z
    //   351: aload_1
    //   352: aload_0
    //   353: putfield 170	com/linkedin/android/pegasus/gen/voyager/relationships/shared/connection/Connection$Builder:miniProfile	Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile;
    //   356: aload_1
    //   357: new 134	com/linkedin/android/pegasus/gen/common/Urn
    //   360: dup
    //   361: aload_3
    //   362: invokespecial 137	com/linkedin/android/pegasus/gen/common/Urn:<init>	(Ljava/lang/String;)V
    //   365: invokevirtual 173	com/linkedin/android/pegasus/gen/voyager/relationships/shared/connection/Connection$Builder:setEntityUrn	(Lcom/linkedin/android/pegasus/gen/common/Urn;)Lcom/linkedin/android/pegasus/gen/voyager/relationships/shared/connection/Connection$Builder;
    //   368: invokevirtual 176	com/linkedin/android/pegasus/gen/voyager/relationships/shared/connection/Connection$Builder:build	()Lcom/linkedin/android/pegasus/gen/voyager/relationships/shared/connection/Connection;
    //   371: areturn
    //   372: astore_1
    //   373: new 178	java/lang/RuntimeException
    //   376: dup
    //   377: aload_1
    //   378: invokespecial 181	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   381: invokestatic 187	com/linkedin/android/infra/shared/Util:safeThrow	(Ljava/lang/RuntimeException;)V
    //   384: aload_2
    //   385: astore_1
    //   386: goto -200 -> 186
    //   389: astore_0
    //   390: getstatic 20	com/linkedin/android/relationships/connections/ConnectionStoreImpl:TAG	Ljava/lang/String;
    //   393: ldc -67
    //   395: aload_0
    //   396: invokestatic 195	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   399: pop
    //   400: aload_0
    //   401: invokestatic 200	com/linkedin/android/infra/performance/CrashReporter:reportNonFatal	(Ljava/lang/Throwable;)V
    //   404: aconst_null
    //   405: areturn
    //   406: astore_0
    //   407: new 178	java/lang/RuntimeException
    //   410: dup
    //   411: aload_0
    //   412: invokespecial 181	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   415: invokestatic 187	com/linkedin/android/infra/shared/Util:safeThrow	(Ljava/lang/RuntimeException;)V
    //   418: aload_2
    //   419: astore_0
    //   420: goto -175 -> 245
    //   423: aload_0
    //   424: iconst_1
    //   425: putfield 127	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:hasTrackingId	Z
    //   428: aload_0
    //   429: aload 8
    //   431: putfield 129	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile$Builder:trackingId	Ljava/lang/String;
    //   434: goto -148 -> 286
    //   437: astore_0
    //   438: goto -48 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	paramCursor	Cursor
    //   146	211	1	localObject1	Object
    //   372	6	1	localDataReaderException	com.linkedin.data.lite.DataReaderException
    //   385	1	1	localObject2	Object
    //   144	275	2	localObject3	Object
    //   126	236	3	str1	String
    //   94	233	4	str2	String
    //   110	209	5	str3	String
    //   78	220	6	str4	String
    //   46	242	7	str5	String
    //   62	368	8	str6	String
    //   14	247	9	str7	String
    //   30	236	10	str8	String
    //   141	85	11	str9	String
    // Exception table:
    //   from	to	target	type
    //   161	186	372	com/linkedin/data/lite/DataReaderException
    //   0	143	389	com/linkedin/data/lite/BuilderException
    //   152	161	389	com/linkedin/data/lite/BuilderException
    //   161	186	389	com/linkedin/data/lite/BuilderException
    //   186	202	389	com/linkedin/data/lite/BuilderException
    //   211	220	389	com/linkedin/data/lite/BuilderException
    //   220	245	389	com/linkedin/data/lite/BuilderException
    //   245	271	389	com/linkedin/data/lite/BuilderException
    //   276	286	389	com/linkedin/data/lite/BuilderException
    //   286	372	389	com/linkedin/data/lite/BuilderException
    //   373	384	389	com/linkedin/data/lite/BuilderException
    //   407	418	389	com/linkedin/data/lite/BuilderException
    //   423	434	389	com/linkedin/data/lite/BuilderException
    //   220	245	406	com/linkedin/data/lite/DataReaderException
    //   0	143	437	java/net/URISyntaxException
    //   152	161	437	java/net/URISyntaxException
    //   161	186	437	java/net/URISyntaxException
    //   186	202	437	java/net/URISyntaxException
    //   211	220	437	java/net/URISyntaxException
    //   220	245	437	java/net/URISyntaxException
    //   245	271	437	java/net/URISyntaxException
    //   276	286	437	java/net/URISyntaxException
    //   286	372	437	java/net/URISyntaxException
    //   373	384	437	java/net/URISyntaxException
    //   407	418	437	java/net/URISyntaxException
    //   423	434	437	java/net/URISyntaxException
  }
  
  private static <T extends UnionTemplate<T>> String getSerializedModel(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      DataManager.GENERATOR_FACTORY.createJsonGenerator().generate(paramT, localStringWriter);
      paramT = localStringWriter.toString();
      return paramT;
    }
    catch (JsonGeneratorException paramT)
    {
      Log.e(TAG, "Error serializing model", paramT);
    }
    return null;
  }
  
  private static void populateMiniProfile(MiniProfile paramMiniProfile, ContentValues paramContentValues)
  {
    paramContentValues.put("miniProfileEntityUrn", entityUrn.toString());
    paramContentValues.put("firstName", firstName);
    if (hasLastName) {
      paramContentValues.put("lastName", lastName);
    }
    if (hasOccupation) {
      paramContentValues.put("occupation", occupation);
    }
    if (hasTrackingId) {
      paramContentValues.put("trackingId", trackingId);
    }
    if (hasObjectUrn) {
      paramContentValues.put("objectUrn", objectUrn.toString());
    }
    String str;
    if (hasBackgroundImage)
    {
      str = getSerializedModel(backgroundImage);
      if (str != null) {
        paramContentValues.put("backgroundImage", str);
      }
    }
    if (hasPicture)
    {
      str = getSerializedModel(picture);
      if (str != null) {
        paramContentValues.put("picture", str);
      }
    }
    paramContentValues.put("publicIdentifier", publicIdentifier);
    paramContentValues.put("lastUpdatedTimestamp", Long.valueOf(System.currentTimeMillis()));
  }
  
  public final void clear()
  {
    Log.d(TAG, "Clearing connection store");
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      if (localSQLiteDatabase.delete("connections", null, null) == -1L)
      {
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        Log.e(TAG, "Could not clear connection store");
      }
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      localSQLiteDatabase.setTransactionSuccessful();
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      sharedPreferences.setConnectionStoreInitialized(false);
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.endTransaction();
      }
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      Log.e(TAG, "Exception clearing connection store", localException);
      localObject3 = localObject1;
      CrashReporter.reportNonFatal(localException);
      return;
    }
    finally
    {
      if (localObject3 != null) {
        ((SQLiteDatabase)localObject3).endTransaction();
      }
    }
  }
  
  /* Error */
  public final java.util.List<Connection> getConnections$57f3385f(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 340	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 341	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: invokevirtual 344	com/linkedin/android/relationships/connections/ConnectionStoreImpl:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: ldc_w 312
    //   22: aconst_null
    //   23: aload_1
    //   24: aload_2
    //   25: aconst_null
    //   26: aconst_null
    //   27: aload_3
    //   28: aload 4
    //   30: invokevirtual 348	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_1
    //   34: aload_1
    //   35: astore 5
    //   37: aload_1
    //   38: astore 6
    //   40: aload_1
    //   41: invokeinterface 352 1 0
    //   46: ifeq +75 -> 121
    //   49: aload_1
    //   50: astore 5
    //   52: aload_1
    //   53: astore 6
    //   55: aload_1
    //   56: invokestatic 354	com/linkedin/android/relationships/connections/ConnectionStoreImpl:getConnection	(Landroid/database/Cursor;)Lcom/linkedin/android/pegasus/gen/voyager/relationships/shared/connection/Connection;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull -27 -> 34
    //   64: aload_1
    //   65: astore 5
    //   67: aload_1
    //   68: astore 6
    //   70: aload 7
    //   72: aload_2
    //   73: invokeinterface 360 2 0
    //   78: pop
    //   79: goto -45 -> 34
    //   82: astore_1
    //   83: aload 5
    //   85: astore 6
    //   87: getstatic 20	com/linkedin/android/relationships/connections/ConnectionStoreImpl:TAG	Ljava/lang/String;
    //   90: ldc_w 362
    //   93: aload_1
    //   94: invokestatic 195	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   97: pop
    //   98: aload 5
    //   100: astore 6
    //   102: aload_1
    //   103: invokestatic 200	com/linkedin/android/infra/performance/CrashReporter:reportNonFatal	(Ljava/lang/Throwable;)V
    //   106: aload 5
    //   108: ifnull +10 -> 118
    //   111: aload 5
    //   113: invokeinterface 365 1 0
    //   118: aload 7
    //   120: areturn
    //   121: aload_1
    //   122: ifnull -4 -> 118
    //   125: aload_1
    //   126: invokeinterface 365 1 0
    //   131: aload 7
    //   133: areturn
    //   134: astore_1
    //   135: aload 6
    //   137: ifnull +10 -> 147
    //   140: aload 6
    //   142: invokeinterface 365 1 0
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	ConnectionStoreImpl
    //   0	149	1	paramString1	String
    //   0	149	2	paramArrayOfString	String[]
    //   0	149	3	paramString2	String
    //   0	149	4	paramString3	String
    //   4	108	5	str	String
    //   1	140	6	localObject	Object
    //   13	119	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   15	34	82	java/lang/Exception
    //   40	49	82	java/lang/Exception
    //   55	60	82	java/lang/Exception
    //   70	79	82	java/lang/Exception
    //   15	34	134	finally
    //   40	49	134	finally
    //   55	60	134	finally
    //   70	79	134	finally
    //   87	98	134	finally
    //   102	106	134	finally
  }
  
  public final boolean isEmpty()
  {
    localObject3 = null;
    localObject1 = null;
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        Cursor localCursor = getReadableDatabase().query("connections", null, null, null, null, null, null, "1");
        localObject1 = localCursor;
        localObject3 = localCursor;
        int i = localCursor.getCount();
        if (i != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        if (localCursor != null)
        {
          localCursor.close();
          bool2 = bool1;
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        localObject3 = localObject1;
        Log.e(TAG, "Exception when try to read database size");
        localObject3 = localObject1;
        CrashReporter.reportNonFatal(localException);
        return true;
      }
      finally
      {
        if (localObject3 == null) {
          continue;
        }
        ((Cursor)localObject3).close();
      }
      return bool2;
      bool1 = false;
    }
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    paramSQLiteDatabase.enableWriteAheadLogging();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.d(TAG, "Creating lix database");
    paramSQLiteDatabase.execSQL("CREATE TABLE connections (miniProfileEntityUrn TEXT PRIMARY KEY,connectionEntityUrn TEXT,firstName TEXT,lastName TEXT,occupation TEXT,trackingId TEXT,objectUrn TEXT,publicIdentifier TEXT,picture TEXT,backgroundImage TEXT,lastUpdatedTimestamp LONG)");
  }
  
  @Subscribe
  public void onEvent(RemoveConnectionEvent paramRemoveConnectionEvent)
  {
    writeConnection(connection, true);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Log.d(TAG, "Upgrading connections database from " + paramInt1 + " to " + paramInt2);
  }
  
  public final void updateMiniProfile(MiniProfile paramMiniProfile)
  {
    Log.d(TAG, "Updating miniprofile " + entityUrn + " in database");
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      ContentValues localContentValues = new ContentValues();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      populateMiniProfile(paramMiniProfile, localContentValues);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      if (localSQLiteDatabase.update("connections", localContentValues, "miniProfileEntityUrn=?", new String[] { entityUrn.toString() }) == -1L)
      {
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        Log.e(TAG, "Could not update miniprofile " + entityUrn);
      }
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.setTransactionSuccessful();
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.endTransaction();
      }
      return;
    }
    catch (Exception paramMiniProfile)
    {
      localObject2 = localObject1;
      Log.e(TAG, "Exception updating miniprofile in db", paramMiniProfile);
      localObject2 = localObject1;
      CrashReporter.reportNonFatal(paramMiniProfile);
      return;
    }
    finally
    {
      if (localObject2 != null) {
        ((SQLiteDatabase)localObject2).endTransaction();
      }
    }
  }
  
  public final void writeConnection(Connection paramConnection, boolean paramBoolean)
  {
    Log.d(TAG, "Writing connection " + entityUrn + " to database");
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        if (paramBoolean)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          l = localSQLiteDatabase.delete("connections", "miniProfileEntityUrn=?", new String[] { miniProfile.entityUrn.toString() });
          if (l == -1L)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            Log.e(TAG, "Could not write connection " + entityUrn);
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localSQLiteDatabase.setTransactionSuccessful();
          if (localSQLiteDatabase != null) {
            localSQLiteDatabase.endTransaction();
          }
          return;
        }
      }
      catch (Exception paramConnection)
      {
        SQLiteDatabase localSQLiteDatabase;
        long l;
        ContentValues localContentValues;
        localObject2 = localObject1;
        Log.e(TAG, "Exception saving connection to db", paramConnection);
        localObject2 = localObject1;
        CrashReporter.reportNonFatal(paramConnection);
        return;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        ((SQLiteDatabase)localObject2).endTransaction();
      }
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues = new ContentValues();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      if (hasEntityUrn)
      {
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("connectionEntityUrn", entityUrn.toString());
      }
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      populateMiniProfile(miniProfile, localContentValues);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      l = localSQLiteDatabase.insertWithOnConflict("connections", null, localContentValues, 5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.connections.ConnectionStoreImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */