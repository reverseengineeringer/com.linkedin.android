package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzpz.zza;
import com.google.android.gms.internal.zzpz.zzb;
import com.google.android.gms.internal.zzpz.zze;
import com.google.android.gms.internal.zzqb.zzb;
import com.google.android.gms.internal.zzqb.zze;
import com.google.android.gms.internal.zzsn;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zze
  extends zzz
{
  private static final Map<String, String> zzaVB;
  private final zzc zzaVC;
  private final zzaf zzaVD = new zzaf(zzjl());
  
  static
  {
    ArrayMap localArrayMap = new ArrayMap(13);
    zzaVB = localArrayMap;
    localArrayMap.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
    zzaVB.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
    zzaVB.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
    zzaVB.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
    zzaVB.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
    zzaVB.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
    zzaVB.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
    zzaVB.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
    zzaVB.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
    zzaVB.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
    zzaVB.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
    zzaVB.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
    zzaVB.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
  }
  
  zze(zzw paramzzw)
  {
    super(paramzzw);
    paramzzw = zzjQ();
    zzaVC = new zzc(getContext(), paramzzw);
  }
  
  private boolean zzCw()
  {
    return getContext().getDatabasePath(zzjQ()).exists();
  }
  
  private boolean zza(String paramString, int paramInt, zzpz.zzb paramzzb)
  {
    zzjv();
    zzjk();
    zzx.zzcM(paramString);
    zzx.zzz(paramzzb);
    if (TextUtils.isEmpty(zzaZw))
    {
      zzAozzaWF.zze("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(paramInt), String.valueOf(zzaZv));
      return false;
    }
    try
    {
      byte[] arrayOfByte = new byte[paramzzb.getSerializedSize()];
      Object localObject = zzsn.zzb$46aa22ba(arrayOfByte, arrayOfByte.length);
      paramzzb.writeTo((zzsn)localObject);
      ((zzsn)localObject).zzJo();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", paramString);
      ((ContentValues)localObject).put("audience_id", Integer.valueOf(paramInt));
      ((ContentValues)localObject).put("filter_id", zzaZv);
      ((ContentValues)localObject).put("event_name", zzaZw);
      ((ContentValues)localObject).put("data", arrayOfByte);
      return false;
    }
    catch (IOException paramString)
    {
      try
      {
        if (getWritableDatabase().insertWithOnConflict("event_filters", null, (ContentValues)localObject, 5) == -1L) {
          zzAozzaWC.zzfg("Failed to insert event filter (got -1)");
        }
        return true;
      }
      catch (SQLiteException paramString)
      {
        zzAozzaWC.zzj("Error storing event filter", paramString);
      }
      paramString = paramString;
      zzAozzaWC.zzj("Configuration loss. Failed to serialize event filter", paramString);
      return false;
    }
  }
  
  private boolean zza(String paramString, int paramInt, zzpz.zze paramzze)
  {
    zzjv();
    zzjk();
    zzx.zzcM(paramString);
    zzx.zzz(paramzze);
    if (TextUtils.isEmpty(zzaZL))
    {
      zzAozzaWF.zze("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(paramInt), String.valueOf(zzaZv));
      return false;
    }
    try
    {
      byte[] arrayOfByte = new byte[paramzze.getSerializedSize()];
      Object localObject = zzsn.zzb$46aa22ba(arrayOfByte, arrayOfByte.length);
      paramzze.writeTo((zzsn)localObject);
      ((zzsn)localObject).zzJo();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", paramString);
      ((ContentValues)localObject).put("audience_id", Integer.valueOf(paramInt));
      ((ContentValues)localObject).put("filter_id", zzaZv);
      ((ContentValues)localObject).put("property_name", zzaZL);
      ((ContentValues)localObject).put("data", arrayOfByte);
      try
      {
        if (getWritableDatabase().insertWithOnConflict("property_filters", null, (ContentValues)localObject, 5) == -1L)
        {
          zzAozzaWC.zzfg("Failed to insert property filter (got -1)");
          return false;
        }
      }
      catch (SQLiteException paramString)
      {
        zzAozzaWC.zzj("Error storing property filter", paramString);
        return false;
      }
      return true;
    }
    catch (IOException paramString)
    {
      zzAozzaWC.zzj("Configuration loss. Failed to serialize property filter", paramString);
      return false;
    }
  }
  
  private Object zzb(Cursor paramCursor, int paramInt)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 11) {
      i = paramCursor.getType(paramInt);
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        zzAozzaWC.zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i));
        return null;
        CursorWindow localCursorWindow = ((SQLiteCursor)paramCursor).getWindow();
        i = paramCursor.getPosition();
        if (localCursorWindow.isNull(i, paramInt)) {
          i = 0;
        } else if (localCursorWindow.isLong(i, paramInt)) {
          i = 1;
        } else if (localCursorWindow.isFloat(i, paramInt)) {
          i = 2;
        } else if (localCursorWindow.isString(i, paramInt)) {
          i = 3;
        } else if (localCursorWindow.isBlob(i, paramInt)) {
          i = 4;
        } else {
          i = -1;
        }
        break;
      }
    }
    zzAozzaWC.zzfg("Loaded invalid null value from database");
    return null;
    return Long.valueOf(paramCursor.getLong(paramInt));
    return Float.valueOf(paramCursor.getFloat(paramInt));
    return paramCursor.getString(paramInt);
    zzAozzaWC.zzfg("Loaded invalid blob type value, ignoring it");
    return null;
  }
  
  private String zzjQ()
  {
    if (!zzd.zzkr()) {
      return zzd.zzkR();
    }
    if (zzCp().zzks()) {
      return zzd.zzkR();
    }
    zzAozzaWG.zzfg("Using secondary database");
    return zzd.zzkS();
  }
  
  public final void beginTransaction()
  {
    zzjv();
    getWritableDatabase().beginTransaction();
  }
  
  public final void endTransaction()
  {
    zzjv();
    getWritableDatabase().endTransaction();
  }
  
  final SQLiteDatabase getWritableDatabase()
  {
    zzjk();
    try
    {
      SQLiteDatabase localSQLiteDatabase = zzaVC.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzAozzaWF.zzj("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  public final void setTransactionSuccessful()
  {
    zzjv();
    getWritableDatabase().setTransactionSuccessful();
  }
  
  public final void zzA(String paramString, int paramInt)
  {
    zzx.zzcM(paramString);
    zzjk();
    zzjv();
    try
    {
      getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[] { paramString, paramString, String.valueOf(paramInt) });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzAozzaWC.zze("Error pruning currencies", paramString, localSQLiteException);
    }
  }
  
  /* Error */
  final com.google.android.gms.internal.zzqb.zzf zzC(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   4: aload_0
    //   5: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   8: aload_1
    //   9: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 4
    //   19: aload 4
    //   21: ldc_w 410
    //   24: iconst_1
    //   25: anewarray 189	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc_w 412
    //   33: aastore
    //   34: ldc_w 414
    //   37: iconst_2
    //   38: anewarray 189	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: aload_1
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: iload_2
    //   48: invokestatic 400	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   51: aastore
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 418	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 5
    //   60: aload 5
    //   62: astore 4
    //   64: aload 5
    //   66: invokeinterface 421 1 0
    //   71: istore_3
    //   72: iload_3
    //   73: ifne +19 -> 92
    //   76: aload 5
    //   78: ifnull +10 -> 88
    //   81: aload 5
    //   83: invokeinterface 424 1 0
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: areturn
    //   92: aload 5
    //   94: astore 4
    //   96: aload 5
    //   98: iconst_0
    //   99: invokeinterface 428 2 0
    //   104: invokestatic 434	com/google/android/gms/internal/zzsm:zzD	([B)Lcom/google/android/gms/internal/zzsm;
    //   107: astore 7
    //   109: aload 5
    //   111: astore 4
    //   113: new 436	com/google/android/gms/internal/zzqb$zzf
    //   116: dup
    //   117: invokespecial 437	com/google/android/gms/internal/zzqb$zzf:<init>	()V
    //   120: astore 6
    //   122: aload 5
    //   124: astore 4
    //   126: aload 6
    //   128: aload 7
    //   130: invokevirtual 441	com/google/android/gms/internal/zzqb$zzf:zzH	(Lcom/google/android/gms/internal/zzsm;)Lcom/google/android/gms/internal/zzqb$zzf;
    //   133: pop
    //   134: aload 6
    //   136: astore_1
    //   137: aload 5
    //   139: ifnull -49 -> 90
    //   142: aload 5
    //   144: invokeinterface 424 1 0
    //   149: aload 6
    //   151: areturn
    //   152: astore 7
    //   154: aload 5
    //   156: astore 4
    //   158: aload_0
    //   159: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   162: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   165: ldc_w 443
    //   168: aload_1
    //   169: aload 7
    //   171: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   174: goto -40 -> 134
    //   177: astore_1
    //   178: aload 5
    //   180: astore 4
    //   182: aload_0
    //   183: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   186: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   189: ldc_w 445
    //   192: aload_1
    //   193: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   196: aload 5
    //   198: ifnull +10 -> 208
    //   201: aload 5
    //   203: invokeinterface 424 1 0
    //   208: aconst_null
    //   209: areturn
    //   210: astore_1
    //   211: aconst_null
    //   212: astore 4
    //   214: aload 4
    //   216: ifnull +10 -> 226
    //   219: aload 4
    //   221: invokeinterface 424 1 0
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: goto -15 -> 214
    //   232: astore_1
    //   233: aconst_null
    //   234: astore 5
    //   236: goto -58 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	zze
    //   0	239	1	paramString	String
    //   0	239	2	paramInt	int
    //   71	2	3	bool	boolean
    //   17	203	4	localObject	Object
    //   58	177	5	localCursor	Cursor
    //   120	30	6	localzzf	com.google.android.gms.internal.zzqb.zzf
    //   107	22	7	localzzsm	com.google.android.gms.internal.zzsm
    //   152	18	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   126	134	152	java/io/IOException
    //   64	72	177	android/database/sqlite/SQLiteException
    //   96	109	177	android/database/sqlite/SQLiteException
    //   113	122	177	android/database/sqlite/SQLiteException
    //   126	134	177	android/database/sqlite/SQLiteException
    //   158	174	177	android/database/sqlite/SQLiteException
    //   19	60	210	finally
    //   64	72	228	finally
    //   96	109	228	finally
    //   113	122	228	finally
    //   126	134	228	finally
    //   158	174	228	finally
    //   182	196	228	finally
    //   19	60	232	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final String zzCq()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_1
    //   8: aload_1
    //   9: ldc_w 448
    //   12: aconst_null
    //   13: invokevirtual 452	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: astore_2
    //   19: aload_1
    //   20: invokeinterface 421 1 0
    //   25: ifeq +29 -> 54
    //   28: aload_1
    //   29: astore_2
    //   30: aload_1
    //   31: iconst_0
    //   32: invokeinterface 356 2 0
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_1
    //   41: ifnull +11 -> 52
    //   44: aload_1
    //   45: invokeinterface 424 1 0
    //   50: aload_3
    //   51: astore_2
    //   52: aload_2
    //   53: areturn
    //   54: aload 4
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull -6 -> 52
    //   61: aload_1
    //   62: invokeinterface 424 1 0
    //   67: aconst_null
    //   68: areturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: astore_2
    //   74: aload_0
    //   75: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   78: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   81: ldc_w 454
    //   84: aload_3
    //   85: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: aload 4
    //   90: astore_2
    //   91: aload_1
    //   92: ifnull -40 -> 52
    //   95: aload_1
    //   96: invokeinterface 424 1 0
    //   101: aconst_null
    //   102: areturn
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +9 -> 116
    //   110: aload_2
    //   111: invokeinterface 424 1 0
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: goto -13 -> 106
    //   122: astore_3
    //   123: goto -51 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	zze
    //   7	89	1	localObject1	Object
    //   103	14	1	localObject2	Object
    //   118	1	1	localObject3	Object
    //   18	93	2	localObject4	Object
    //   37	14	3	str	String
    //   69	16	3	localSQLiteException1	SQLiteException
    //   122	1	3	localSQLiteException2	SQLiteException
    //   1	88	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	69	android/database/sqlite/SQLiteException
    //   8	17	103	finally
    //   19	28	118	finally
    //   30	38	118	finally
    //   74	88	118	finally
    //   19	28	122	android/database/sqlite/SQLiteException
    //   30	38	122	android/database/sqlite/SQLiteException
  }
  
  final void zzCr()
  {
    zzjk();
    zzjv();
    if (!zzCw()) {}
    int i;
    do
    {
      do
      {
        long l1;
        long l2;
        do
        {
          return;
          l1 = zzCozzaXm.get();
          l2 = zzjl().elapsedRealtime();
        } while (Math.abs(l2 - l1) <= zzd.zzBR());
        zzCozzaXm.set(l2);
        zzjk();
        zzjv();
      } while (!zzCw());
      i = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(zzjl().currentTimeMillis()), String.valueOf(zzd.zzBQ()) });
    } while (i <= 0);
    zzAozzaWK.zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(i));
  }
  
  /* Error */
  public final zzi zzI(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_2
    //   9: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   17: aload_0
    //   18: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   21: aload_0
    //   22: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: ldc_w 517
    //   28: iconst_3
    //   29: anewarray 189	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 519
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc_w 521
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc_w 523
    //   49: aastore
    //   50: ldc_w 525
    //   53: iconst_2
    //   54: anewarray 189	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_2
    //   64: aastore
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 418	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 4
    //   73: aload 4
    //   75: invokeinterface 421 1 0
    //   80: istore_3
    //   81: iload_3
    //   82: ifne +19 -> 101
    //   85: aload 4
    //   87: ifnull +10 -> 97
    //   90: aload 4
    //   92: invokeinterface 424 1 0
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: areturn
    //   101: new 527	com/google/android/gms/measurement/internal/zzi
    //   104: dup
    //   105: aload_1
    //   106: aload_2
    //   107: aload 4
    //   109: iconst_0
    //   110: invokeinterface 338 2 0
    //   115: aload 4
    //   117: iconst_1
    //   118: invokeinterface 338 2 0
    //   123: aload 4
    //   125: iconst_2
    //   126: invokeinterface 338 2 0
    //   131: invokespecial 530	com/google/android/gms/measurement/internal/zzi:<init>	(Ljava/lang/String;Ljava/lang/String;JJJ)V
    //   134: astore 5
    //   136: aload 4
    //   138: invokeinterface 533 1 0
    //   143: ifeq +16 -> 159
    //   146: aload_0
    //   147: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   150: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   153: ldc_w 535
    //   156: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   159: aload 5
    //   161: astore_1
    //   162: aload 4
    //   164: ifnull -65 -> 99
    //   167: aload 4
    //   169: invokeinterface 424 1 0
    //   174: aload 5
    //   176: areturn
    //   177: astore 5
    //   179: aconst_null
    //   180: astore 4
    //   182: aload_0
    //   183: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   186: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   189: ldc_w 537
    //   192: aload_1
    //   193: aload_2
    //   194: aload 5
    //   196: invokevirtual 541	com/google/android/gms/measurement/internal/zzp$zza:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   199: aload 4
    //   201: ifnull +10 -> 211
    //   204: aload 4
    //   206: invokeinterface 424 1 0
    //   211: aconst_null
    //   212: areturn
    //   213: astore_1
    //   214: aload 5
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +9 -> 227
    //   221: aload_2
    //   222: invokeinterface 424 1 0
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: aload 4
    //   232: astore_2
    //   233: goto -16 -> 217
    //   236: astore_1
    //   237: aload 4
    //   239: astore_2
    //   240: goto -23 -> 217
    //   243: astore 5
    //   245: goto -63 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	zze
    //   0	248	1	paramString1	String
    //   0	248	2	paramString2	String
    //   80	2	3	bool	boolean
    //   71	167	4	localCursor	Cursor
    //   1	174	5	localzzi	zzi
    //   177	38	5	localSQLiteException1	SQLiteException
    //   243	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   21	73	177	android/database/sqlite/SQLiteException
    //   21	73	213	finally
    //   73	81	229	finally
    //   101	159	229	finally
    //   182	199	236	finally
    //   73	81	243	android/database/sqlite/SQLiteException
    //   101	159	243	android/database/sqlite/SQLiteException
  }
  
  public final void zzJ(String paramString1, String paramString2)
  {
    zzx.zzcM(paramString1);
    zzx.zzcM(paramString2);
    zzjk();
    zzjv();
    try
    {
      int i = getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      zzAozzaWK.zzj("Deleted user attribute rows:", Integer.valueOf(i));
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzAozzaWC.zzd("Error deleting user attribute", paramString1, paramString2, localSQLiteException);
    }
  }
  
  /* Error */
  public final zzai zzK(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_2
    //   9: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   17: aload_0
    //   18: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   21: aload_0
    //   22: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: ldc_w 544
    //   28: iconst_2
    //   29: anewarray 189	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 552
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc_w 554
    //   43: aastore
    //   44: ldc_w 525
    //   47: iconst_2
    //   48: anewarray 189	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_2
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 418	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 4
    //   67: aload 4
    //   69: invokeinterface 421 1 0
    //   74: istore_3
    //   75: iload_3
    //   76: ifne +19 -> 95
    //   79: aload 4
    //   81: ifnull +10 -> 91
    //   84: aload 4
    //   86: invokeinterface 424 1 0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: areturn
    //   95: new 556	com/google/android/gms/measurement/internal/zzai
    //   98: dup
    //   99: aload_1
    //   100: aload_2
    //   101: aload 4
    //   103: iconst_0
    //   104: invokeinterface 338 2 0
    //   109: aload_0
    //   110: aload 4
    //   112: iconst_1
    //   113: invokespecial 558	com/google/android/gms/measurement/internal/zze:zzb	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   116: invokespecial 561	com/google/android/gms/measurement/internal/zzai:<init>	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   119: astore 5
    //   121: aload 4
    //   123: invokeinterface 533 1 0
    //   128: ifeq +16 -> 144
    //   131: aload_0
    //   132: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   135: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   138: ldc_w 563
    //   141: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   144: aload 5
    //   146: astore_1
    //   147: aload 4
    //   149: ifnull -56 -> 93
    //   152: aload 4
    //   154: invokeinterface 424 1 0
    //   159: aload 5
    //   161: areturn
    //   162: astore 5
    //   164: aconst_null
    //   165: astore 4
    //   167: aload_0
    //   168: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   171: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   174: ldc_w 565
    //   177: aload_1
    //   178: aload_2
    //   179: aload 5
    //   181: invokevirtual 541	com/google/android/gms/measurement/internal/zzp$zza:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   184: aload 4
    //   186: ifnull +10 -> 196
    //   189: aload 4
    //   191: invokeinterface 424 1 0
    //   196: aconst_null
    //   197: areturn
    //   198: astore_1
    //   199: aload 5
    //   201: astore_2
    //   202: aload_2
    //   203: ifnull +9 -> 212
    //   206: aload_2
    //   207: invokeinterface 424 1 0
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: aload 4
    //   217: astore_2
    //   218: goto -16 -> 202
    //   221: astore_1
    //   222: aload 4
    //   224: astore_2
    //   225: goto -23 -> 202
    //   228: astore 5
    //   230: goto -63 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	zze
    //   0	233	1	paramString1	String
    //   0	233	2	paramString2	String
    //   74	2	3	bool	boolean
    //   65	158	4	localCursor	Cursor
    //   1	159	5	localzzai	zzai
    //   162	38	5	localSQLiteException1	SQLiteException
    //   228	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   21	67	162	android/database/sqlite/SQLiteException
    //   21	67	198	finally
    //   67	75	214	finally
    //   95	144	214	finally
    //   167	184	221	finally
    //   67	75	228	android/database/sqlite/SQLiteException
    //   95	144	228	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  final Map<Integer, List<zzpz.zzb>> zzL(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   4: aload_0
    //   5: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   8: aload_1
    //   9: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_2
    //   14: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: new 24	android/support/v4/util/ArrayMap
    //   21: dup
    //   22: invokespecial 568	android/support/v4/util/ArrayMap:<init>	()V
    //   25: astore 8
    //   27: aload_0
    //   28: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore 5
    //   33: aload 5
    //   35: ldc -12
    //   37: iconst_2
    //   38: anewarray 189	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc -30
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: ldc -21
    //   50: aastore
    //   51: ldc_w 570
    //   54: iconst_2
    //   55: anewarray 189	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: aload_1
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_2
    //   65: aastore
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: invokevirtual 418	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 5
    //   74: aload 5
    //   76: astore_2
    //   77: aload 5
    //   79: invokeinterface 421 1 0
    //   84: ifne +24 -> 108
    //   87: aload 5
    //   89: astore_2
    //   90: invokestatic 575	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   93: astore_1
    //   94: aload 5
    //   96: ifnull +10 -> 106
    //   99: aload 5
    //   101: invokeinterface 424 1 0
    //   106: aload_1
    //   107: areturn
    //   108: aload 5
    //   110: astore_2
    //   111: aload 5
    //   113: iconst_1
    //   114: invokeinterface 428 2 0
    //   119: invokestatic 434	com/google/android/gms/internal/zzsm:zzD	([B)Lcom/google/android/gms/internal/zzsm;
    //   122: astore 6
    //   124: aload 5
    //   126: astore_2
    //   127: new 155	com/google/android/gms/internal/zzpz$zzb
    //   130: dup
    //   131: invokespecial 576	com/google/android/gms/internal/zzpz$zzb:<init>	()V
    //   134: astore 9
    //   136: aload 5
    //   138: astore_2
    //   139: aload 9
    //   141: aload 6
    //   143: invokevirtual 580	com/google/android/gms/internal/zzpz$zzb:zzu	(Lcom/google/android/gms/internal/zzsm;)Lcom/google/android/gms/internal/zzpz$zzb;
    //   146: pop
    //   147: aload 5
    //   149: astore_2
    //   150: aload 5
    //   152: iconst_0
    //   153: invokeinterface 583 2 0
    //   158: istore_3
    //   159: aload 5
    //   161: astore_2
    //   162: aload 8
    //   164: iload_3
    //   165: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: invokeinterface 585 2 0
    //   173: checkcast 587	java/util/List
    //   176: astore 7
    //   178: aload 7
    //   180: astore 6
    //   182: aload 7
    //   184: ifnonnull +32 -> 216
    //   187: aload 5
    //   189: astore_2
    //   190: new 589	java/util/ArrayList
    //   193: dup
    //   194: invokespecial 590	java/util/ArrayList:<init>	()V
    //   197: astore 6
    //   199: aload 5
    //   201: astore_2
    //   202: aload 8
    //   204: iload_3
    //   205: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: aload 6
    //   210: invokeinterface 40 3 0
    //   215: pop
    //   216: aload 5
    //   218: astore_2
    //   219: aload 6
    //   221: aload 9
    //   223: invokeinterface 594 2 0
    //   228: pop
    //   229: aload 5
    //   231: astore_2
    //   232: aload 5
    //   234: invokeinterface 533 1 0
    //   239: istore 4
    //   241: iload 4
    //   243: ifne -135 -> 108
    //   246: aload 5
    //   248: ifnull +10 -> 258
    //   251: aload 5
    //   253: invokeinterface 424 1 0
    //   258: aload 8
    //   260: areturn
    //   261: astore 6
    //   263: aload 5
    //   265: astore_2
    //   266: aload_0
    //   267: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   270: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   273: ldc_w 596
    //   276: aload_1
    //   277: aload 6
    //   279: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   282: goto -53 -> 229
    //   285: astore_1
    //   286: aload 5
    //   288: astore_2
    //   289: aload_0
    //   290: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   293: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   296: ldc_w 598
    //   299: aload_1
    //   300: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   303: aload 5
    //   305: ifnull +10 -> 315
    //   308: aload 5
    //   310: invokeinterface 424 1 0
    //   315: aconst_null
    //   316: areturn
    //   317: astore_1
    //   318: aconst_null
    //   319: astore_2
    //   320: aload_2
    //   321: ifnull +9 -> 330
    //   324: aload_2
    //   325: invokeinterface 424 1 0
    //   330: aload_1
    //   331: athrow
    //   332: astore_1
    //   333: goto -13 -> 320
    //   336: astore_1
    //   337: aconst_null
    //   338: astore 5
    //   340: goto -54 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	zze
    //   0	343	1	paramString1	String
    //   0	343	2	paramString2	String
    //   158	47	3	i	int
    //   239	3	4	bool	boolean
    //   31	308	5	localObject1	Object
    //   122	98	6	localObject2	Object
    //   261	17	6	localIOException	IOException
    //   176	7	7	localList	List
    //   25	234	8	localArrayMap	ArrayMap
    //   134	88	9	localzzb	zzpz.zzb
    // Exception table:
    //   from	to	target	type
    //   139	147	261	java/io/IOException
    //   77	87	285	android/database/sqlite/SQLiteException
    //   90	94	285	android/database/sqlite/SQLiteException
    //   111	124	285	android/database/sqlite/SQLiteException
    //   127	136	285	android/database/sqlite/SQLiteException
    //   139	147	285	android/database/sqlite/SQLiteException
    //   150	159	285	android/database/sqlite/SQLiteException
    //   162	178	285	android/database/sqlite/SQLiteException
    //   190	199	285	android/database/sqlite/SQLiteException
    //   202	216	285	android/database/sqlite/SQLiteException
    //   219	229	285	android/database/sqlite/SQLiteException
    //   232	241	285	android/database/sqlite/SQLiteException
    //   266	282	285	android/database/sqlite/SQLiteException
    //   33	74	317	finally
    //   77	87	332	finally
    //   90	94	332	finally
    //   111	124	332	finally
    //   127	136	332	finally
    //   139	147	332	finally
    //   150	159	332	finally
    //   162	178	332	finally
    //   190	199	332	finally
    //   202	216	332	finally
    //   219	229	332	finally
    //   232	241	332	finally
    //   266	282	332	finally
    //   289	303	332	finally
    //   33	74	336	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  final Map<Integer, List<zzpz.zze>> zzM(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   4: aload_0
    //   5: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   8: aload_1
    //   9: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_2
    //   14: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: new 24	android/support/v4/util/ArrayMap
    //   21: dup
    //   22: invokespecial 568	android/support/v4/util/ArrayMap:<init>	()V
    //   25: astore 8
    //   27: aload_0
    //   28: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore 5
    //   33: aload 5
    //   35: ldc_w 284
    //   38: iconst_2
    //   39: anewarray 189	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc -30
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc -21
    //   51: aastore
    //   52: ldc_w 603
    //   55: iconst_2
    //   56: anewarray 189	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload_2
    //   66: aastore
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 418	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore 5
    //   75: aload 5
    //   77: astore_2
    //   78: aload 5
    //   80: invokeinterface 421 1 0
    //   85: ifne +24 -> 109
    //   88: aload 5
    //   90: astore_2
    //   91: invokestatic 575	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   94: astore_1
    //   95: aload 5
    //   97: ifnull +10 -> 107
    //   100: aload 5
    //   102: invokeinterface 424 1 0
    //   107: aload_1
    //   108: areturn
    //   109: aload 5
    //   111: astore_2
    //   112: aload 5
    //   114: iconst_1
    //   115: invokeinterface 428 2 0
    //   120: invokestatic 434	com/google/android/gms/internal/zzsm:zzD	([B)Lcom/google/android/gms/internal/zzsm;
    //   123: astore 6
    //   125: aload 5
    //   127: astore_2
    //   128: new 272	com/google/android/gms/internal/zzpz$zze
    //   131: dup
    //   132: invokespecial 604	com/google/android/gms/internal/zzpz$zze:<init>	()V
    //   135: astore 9
    //   137: aload 5
    //   139: astore_2
    //   140: aload 9
    //   142: aload 6
    //   144: invokevirtual 608	com/google/android/gms/internal/zzpz$zze:zzx	(Lcom/google/android/gms/internal/zzsm;)Lcom/google/android/gms/internal/zzpz$zze;
    //   147: pop
    //   148: aload 5
    //   150: astore_2
    //   151: aload 5
    //   153: iconst_0
    //   154: invokeinterface 583 2 0
    //   159: istore_3
    //   160: aload 5
    //   162: astore_2
    //   163: aload 8
    //   165: iload_3
    //   166: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: invokeinterface 585 2 0
    //   174: checkcast 587	java/util/List
    //   177: astore 7
    //   179: aload 7
    //   181: astore 6
    //   183: aload 7
    //   185: ifnonnull +32 -> 217
    //   188: aload 5
    //   190: astore_2
    //   191: new 589	java/util/ArrayList
    //   194: dup
    //   195: invokespecial 590	java/util/ArrayList:<init>	()V
    //   198: astore 6
    //   200: aload 5
    //   202: astore_2
    //   203: aload 8
    //   205: iload_3
    //   206: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   209: aload 6
    //   211: invokeinterface 40 3 0
    //   216: pop
    //   217: aload 5
    //   219: astore_2
    //   220: aload 6
    //   222: aload 9
    //   224: invokeinterface 594 2 0
    //   229: pop
    //   230: aload 5
    //   232: astore_2
    //   233: aload 5
    //   235: invokeinterface 533 1 0
    //   240: istore 4
    //   242: iload 4
    //   244: ifne -135 -> 109
    //   247: aload 5
    //   249: ifnull +10 -> 259
    //   252: aload 5
    //   254: invokeinterface 424 1 0
    //   259: aload 8
    //   261: areturn
    //   262: astore 6
    //   264: aload 5
    //   266: astore_2
    //   267: aload_0
    //   268: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   271: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   274: ldc_w 596
    //   277: aload_1
    //   278: aload 6
    //   280: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   283: goto -53 -> 230
    //   286: astore_1
    //   287: aload 5
    //   289: astore_2
    //   290: aload_0
    //   291: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   294: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   297: ldc_w 598
    //   300: aload_1
    //   301: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   304: aload 5
    //   306: ifnull +10 -> 316
    //   309: aload 5
    //   311: invokeinterface 424 1 0
    //   316: aconst_null
    //   317: areturn
    //   318: astore_1
    //   319: aconst_null
    //   320: astore_2
    //   321: aload_2
    //   322: ifnull +9 -> 331
    //   325: aload_2
    //   326: invokeinterface 424 1 0
    //   331: aload_1
    //   332: athrow
    //   333: astore_1
    //   334: goto -13 -> 321
    //   337: astore_1
    //   338: aconst_null
    //   339: astore 5
    //   341: goto -54 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	zze
    //   0	344	1	paramString1	String
    //   0	344	2	paramString2	String
    //   159	47	3	i	int
    //   240	3	4	bool	boolean
    //   31	309	5	localObject1	Object
    //   123	98	6	localObject2	Object
    //   262	17	6	localIOException	IOException
    //   177	7	7	localList	List
    //   25	235	8	localArrayMap	ArrayMap
    //   135	88	9	localzze	zzpz.zze
    // Exception table:
    //   from	to	target	type
    //   140	148	262	java/io/IOException
    //   78	88	286	android/database/sqlite/SQLiteException
    //   91	95	286	android/database/sqlite/SQLiteException
    //   112	125	286	android/database/sqlite/SQLiteException
    //   128	137	286	android/database/sqlite/SQLiteException
    //   140	148	286	android/database/sqlite/SQLiteException
    //   151	160	286	android/database/sqlite/SQLiteException
    //   163	179	286	android/database/sqlite/SQLiteException
    //   191	200	286	android/database/sqlite/SQLiteException
    //   203	217	286	android/database/sqlite/SQLiteException
    //   220	230	286	android/database/sqlite/SQLiteException
    //   233	242	286	android/database/sqlite/SQLiteException
    //   267	283	286	android/database/sqlite/SQLiteException
    //   33	75	318	finally
    //   78	88	333	finally
    //   91	95	333	finally
    //   112	125	333	finally
    //   128	137	333	finally
    //   140	148	333	finally
    //   151	160	333	finally
    //   163	179	333	finally
    //   191	200	333	finally
    //   203	217	333	finally
    //   220	230	333	finally
    //   233	242	333	finally
    //   267	283	333	finally
    //   290	304	333	finally
    //   33	75	337	android/database/sqlite/SQLiteException
  }
  
  public final void zzZ(long paramLong)
  {
    zzjk();
    zzjv();
    if (getWritableDatabase().delete("queue", "rowid=?", new String[] { String.valueOf(paramLong) }) != 1) {
      zzAozzaWC.zzfg("Deleted fewer rows from queue than expected");
    }
  }
  
  /* Error */
  public final zza zza(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   9: aload_0
    //   10: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   13: new 6	com/google/android/gms/measurement/internal/zze$zza
    //   16: dup
    //   17: invokespecial 616	com/google/android/gms/measurement/internal/zze$zza:<init>	()V
    //   20: astore 8
    //   22: aload_0
    //   23: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 9
    //   28: aload 9
    //   30: ldc_w 618
    //   33: iconst_4
    //   34: anewarray 189	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 62
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc 70
    //   46: aastore
    //   47: dup
    //   48: iconst_2
    //   49: ldc 66
    //   51: aastore
    //   52: dup
    //   53: iconst_3
    //   54: ldc 74
    //   56: aastore
    //   57: ldc_w 620
    //   60: iconst_1
    //   61: anewarray 189	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: aload_3
    //   67: aastore
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 418	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore 7
    //   76: aload 7
    //   78: astore 6
    //   80: aload 7
    //   82: invokeinterface 421 1 0
    //   87: ifne +36 -> 123
    //   90: aload 7
    //   92: astore 6
    //   94: aload_0
    //   95: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   98: getfield 175	com/google/android/gms/measurement/internal/zzp:zzaWF	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   101: ldc_w 622
    //   104: aload_3
    //   105: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   108: aload 7
    //   110: ifnull +10 -> 120
    //   113: aload 7
    //   115: invokeinterface 424 1 0
    //   120: aload 8
    //   122: areturn
    //   123: aload 7
    //   125: astore 6
    //   127: aload 7
    //   129: iconst_0
    //   130: invokeinterface 338 2 0
    //   135: lload_1
    //   136: lcmp
    //   137: ifne +54 -> 191
    //   140: aload 7
    //   142: astore 6
    //   144: aload 8
    //   146: aload 7
    //   148: iconst_1
    //   149: invokeinterface 338 2 0
    //   154: putfield 626	com/google/android/gms/measurement/internal/zze$zza:zzaVF	J
    //   157: aload 7
    //   159: astore 6
    //   161: aload 8
    //   163: aload 7
    //   165: iconst_2
    //   166: invokeinterface 338 2 0
    //   171: putfield 629	com/google/android/gms/measurement/internal/zze$zza:zzaVE	J
    //   174: aload 7
    //   176: astore 6
    //   178: aload 8
    //   180: aload 7
    //   182: iconst_3
    //   183: invokeinterface 338 2 0
    //   188: putfield 632	com/google/android/gms/measurement/internal/zze$zza:zzaVG	J
    //   191: aload 7
    //   193: astore 6
    //   195: aload 8
    //   197: aload 8
    //   199: getfield 626	com/google/android/gms/measurement/internal/zze$zza:zzaVF	J
    //   202: lconst_1
    //   203: ladd
    //   204: putfield 626	com/google/android/gms/measurement/internal/zze$zza:zzaVF	J
    //   207: iload 4
    //   209: ifeq +19 -> 228
    //   212: aload 7
    //   214: astore 6
    //   216: aload 8
    //   218: aload 8
    //   220: getfield 629	com/google/android/gms/measurement/internal/zze$zza:zzaVE	J
    //   223: lconst_1
    //   224: ladd
    //   225: putfield 629	com/google/android/gms/measurement/internal/zze$zza:zzaVE	J
    //   228: iload 5
    //   230: ifeq +19 -> 249
    //   233: aload 7
    //   235: astore 6
    //   237: aload 8
    //   239: aload 8
    //   241: getfield 632	com/google/android/gms/measurement/internal/zze$zza:zzaVG	J
    //   244: lconst_1
    //   245: ladd
    //   246: putfield 632	com/google/android/gms/measurement/internal/zze$zza:zzaVG	J
    //   249: aload 7
    //   251: astore 6
    //   253: new 217	android/content/ContentValues
    //   256: dup
    //   257: invokespecial 219	android/content/ContentValues:<init>	()V
    //   260: astore 10
    //   262: aload 7
    //   264: astore 6
    //   266: aload 10
    //   268: ldc 62
    //   270: lload_1
    //   271: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   274: invokevirtual 635	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   277: aload 7
    //   279: astore 6
    //   281: aload 10
    //   283: ldc 66
    //   285: aload 8
    //   287: getfield 629	com/google/android/gms/measurement/internal/zze$zza:zzaVE	J
    //   290: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   293: invokevirtual 635	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   296: aload 7
    //   298: astore 6
    //   300: aload 10
    //   302: ldc 70
    //   304: aload 8
    //   306: getfield 626	com/google/android/gms/measurement/internal/zze$zza:zzaVF	J
    //   309: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: invokevirtual 635	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   315: aload 7
    //   317: astore 6
    //   319: aload 10
    //   321: ldc 74
    //   323: aload 8
    //   325: getfield 632	com/google/android/gms/measurement/internal/zze$zza:zzaVG	J
    //   328: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   331: invokevirtual 635	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   334: aload 7
    //   336: astore 6
    //   338: aload 9
    //   340: ldc_w 618
    //   343: aload 10
    //   345: ldc_w 620
    //   348: iconst_1
    //   349: anewarray 189	java/lang/String
    //   352: dup
    //   353: iconst_0
    //   354: aload_3
    //   355: aastore
    //   356: invokevirtual 639	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   359: pop
    //   360: aload 7
    //   362: ifnull +10 -> 372
    //   365: aload 7
    //   367: invokeinterface 424 1 0
    //   372: aload 8
    //   374: areturn
    //   375: astore_3
    //   376: aconst_null
    //   377: astore 7
    //   379: aload 7
    //   381: astore 6
    //   383: aload_0
    //   384: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   387: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   390: ldc_w 641
    //   393: aload_3
    //   394: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   397: aload 7
    //   399: ifnull +10 -> 409
    //   402: aload 7
    //   404: invokeinterface 424 1 0
    //   409: aload 8
    //   411: areturn
    //   412: astore_3
    //   413: aconst_null
    //   414: astore 6
    //   416: aload 6
    //   418: ifnull +10 -> 428
    //   421: aload 6
    //   423: invokeinterface 424 1 0
    //   428: aload_3
    //   429: athrow
    //   430: astore_3
    //   431: goto -15 -> 416
    //   434: astore_3
    //   435: goto -56 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	zze
    //   0	438	1	paramLong	long
    //   0	438	3	paramString	String
    //   0	438	4	paramBoolean1	boolean
    //   0	438	5	paramBoolean2	boolean
    //   78	344	6	localCursor1	Cursor
    //   74	329	7	localCursor2	Cursor
    //   20	390	8	localzza	zza
    //   26	313	9	localSQLiteDatabase	SQLiteDatabase
    //   260	84	10	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   22	76	375	android/database/sqlite/SQLiteException
    //   22	76	412	finally
    //   80	90	430	finally
    //   94	108	430	finally
    //   127	140	430	finally
    //   144	157	430	finally
    //   161	174	430	finally
    //   178	191	430	finally
    //   195	207	430	finally
    //   216	228	430	finally
    //   237	249	430	finally
    //   253	262	430	finally
    //   266	277	430	finally
    //   281	296	430	finally
    //   300	315	430	finally
    //   319	334	430	finally
    //   338	360	430	finally
    //   383	397	430	finally
    //   80	90	434	android/database/sqlite/SQLiteException
    //   94	108	434	android/database/sqlite/SQLiteException
    //   127	140	434	android/database/sqlite/SQLiteException
    //   144	157	434	android/database/sqlite/SQLiteException
    //   161	174	434	android/database/sqlite/SQLiteException
    //   178	191	434	android/database/sqlite/SQLiteException
    //   195	207	434	android/database/sqlite/SQLiteException
    //   216	228	434	android/database/sqlite/SQLiteException
    //   237	249	434	android/database/sqlite/SQLiteException
    //   253	262	434	android/database/sqlite/SQLiteException
    //   266	277	434	android/database/sqlite/SQLiteException
    //   281	296	434	android/database/sqlite/SQLiteException
    //   300	315	434	android/database/sqlite/SQLiteException
    //   319	334	434	android/database/sqlite/SQLiteException
    //   338	360	434	android/database/sqlite/SQLiteException
  }
  
  public final void zza(zzqb.zze paramzze)
  {
    zzjk();
    zzjv();
    zzx.zzz(paramzze);
    zzx.zzcM(appId);
    zzx.zzz(zzbaq);
    zzCr();
    long l = zzjl().currentTimeMillis();
    if ((zzbaq.longValue() < l - zzd.zzBQ()) || (zzbaq.longValue() > zzd.zzBQ() + l)) {
      zzAozzaWF.zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(l), zzbaq);
    }
    try
    {
      byte[] arrayOfByte = new byte[paramzze.getSerializedSize()];
      Object localObject = zzsn.zzb$46aa22ba(arrayOfByte, arrayOfByte.length);
      paramzze.writeTo((zzsn)localObject);
      ((zzsn)localObject).zzJo();
      arrayOfByte = zzCk().zzg(arrayOfByte);
      zzAozzaWK.zzj("Saving bundle, size", Integer.valueOf(arrayOfByte.length));
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", appId);
      ((ContentValues)localObject).put("bundle_end_timestamp", zzbaq);
      ((ContentValues)localObject).put("data", arrayOfByte);
      return;
    }
    catch (IOException paramzze)
    {
      try
      {
        if (getWritableDatabase().insert("queue", null, (ContentValues)localObject) == -1L) {
          zzAozzaWC.zzfg("Failed to insert bundle (got -1)");
        }
        return;
      }
      catch (SQLiteException paramzze)
      {
        zzAozzaWC.zzj("Error storing bundle", paramzze);
      }
      paramzze = paramzze;
      zzAozzaWC.zzj("Data loss. Failed to serialize bundle", paramzze);
      return;
    }
  }
  
  public final void zza(zza paramzza)
  {
    zzx.zzz(paramzza);
    zzjk();
    zzjv();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzza.zzwK());
    localContentValues.put("app_instance_id", paramzza.zzBj());
    localContentValues.put("gmp_app_id", paramzza.zzBk());
    localContentValues.put("resettable_device_id_hash", paramzza.zzBl());
    localContentValues.put("last_bundle_index", Long.valueOf(paramzza.zzBr()));
    localContentValues.put("last_bundle_start_timestamp", Long.valueOf(paramzza.zzBm()));
    localContentValues.put("last_bundle_end_timestamp", Long.valueOf(paramzza.zzBn()));
    localContentValues.put("app_version", paramzza.zzli());
    localContentValues.put("app_store", paramzza.zzBo());
    localContentValues.put("gmp_version", Long.valueOf(paramzza.zzBp()));
    localContentValues.put("dev_cert_hash", Long.valueOf(paramzza.zzBq()));
    localContentValues.put("measurement_enabled", Boolean.valueOf(paramzza.zzAr()));
    zzaTV.zzCn().zzjk();
    localContentValues.put("day", Long.valueOf(zzaVm));
    zzaTV.zzCn().zzjk();
    localContentValues.put("daily_public_events_count", Long.valueOf(zzaVn));
    zzaTV.zzCn().zzjk();
    localContentValues.put("daily_events_count", Long.valueOf(zzaVo));
    zzaTV.zzCn().zzjk();
    localContentValues.put("daily_conversions_count", Long.valueOf(zzaVp));
    zzaTV.zzCn().zzjk();
    localContentValues.put("config_fetched_time", Long.valueOf(zzaVr));
    zzaTV.zzCn().zzjk();
    localContentValues.put("failed_config_fetch_time", Long.valueOf(zzaVs));
    try
    {
      if (getWritableDatabase().insertWithOnConflict("apps", null, localContentValues, 5) == -1L) {
        zzAozzaWC.zzfg("Failed to insert/update app (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzza)
    {
      zzAozzaWC.zzj("Error storing app", paramzza);
    }
  }
  
  /* Error */
  public final void zza(zzh paramzzh, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   4: aload_0
    //   5: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   8: aload_1
    //   9: invokestatic 153	com/google/android/gms/common/internal/zzx:zzz	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: aload_1
    //   14: getfield 782	com/google/android/gms/measurement/internal/zzh:zzaUa	Ljava/lang/String;
    //   17: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   20: pop
    //   21: new 784	com/google/android/gms/internal/zzqb$zzb
    //   24: dup
    //   25: invokespecial 785	com/google/android/gms/internal/zzqb$zzb:<init>	()V
    //   28: astore 5
    //   30: aload 5
    //   32: aload_1
    //   33: getfield 788	com/google/android/gms/measurement/internal/zzh:zzaVN	J
    //   36: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   39: putfield 791	com/google/android/gms/internal/zzqb$zzb:zzbag	Ljava/lang/Long;
    //   42: aload 5
    //   44: aload_1
    //   45: getfield 795	com/google/android/gms/measurement/internal/zzh:zzaVO	Lcom/google/android/gms/measurement/internal/EventParams;
    //   48: getfield 801	com/google/android/gms/measurement/internal/EventParams:zzaVS	Landroid/os/Bundle;
    //   51: invokevirtual 806	android/os/Bundle:size	()I
    //   54: anewarray 808	com/google/android/gms/internal/zzqb$zzc
    //   57: putfield 812	com/google/android/gms/internal/zzqb$zzb:zzbae	[Lcom/google/android/gms/internal/zzqb$zzc;
    //   60: aload_1
    //   61: getfield 795	com/google/android/gms/measurement/internal/zzh:zzaVO	Lcom/google/android/gms/measurement/internal/EventParams;
    //   64: invokevirtual 816	com/google/android/gms/measurement/internal/EventParams:iterator	()Ljava/util/Iterator;
    //   67: astore 6
    //   69: iconst_0
    //   70: istore 4
    //   72: aload 6
    //   74: invokeinterface 821 1 0
    //   79: ifeq +75 -> 154
    //   82: aload 6
    //   84: invokeinterface 825 1 0
    //   89: checkcast 189	java/lang/String
    //   92: astore 8
    //   94: new 808	com/google/android/gms/internal/zzqb$zzc
    //   97: dup
    //   98: invokespecial 826	com/google/android/gms/internal/zzqb$zzc:<init>	()V
    //   101: astore 7
    //   103: aload 5
    //   105: getfield 812	com/google/android/gms/internal/zzqb$zzb:zzbae	[Lcom/google/android/gms/internal/zzqb$zzc;
    //   108: iload 4
    //   110: aload 7
    //   112: aastore
    //   113: aload 7
    //   115: aload 8
    //   117: putfield 829	com/google/android/gms/internal/zzqb$zzc:name	Ljava/lang/String;
    //   120: aload_1
    //   121: getfield 795	com/google/android/gms/measurement/internal/zzh:zzaVO	Lcom/google/android/gms/measurement/internal/EventParams;
    //   124: getfield 801	com/google/android/gms/measurement/internal/EventParams:zzaVS	Landroid/os/Bundle;
    //   127: aload 8
    //   129: invokevirtual 832	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   132: astore 8
    //   134: aload_0
    //   135: invokevirtual 664	com/google/android/gms/measurement/internal/zze:zzCk	()Lcom/google/android/gms/measurement/internal/zzaj;
    //   138: aload 7
    //   140: aload 8
    //   142: invokevirtual 835	com/google/android/gms/measurement/internal/zzaj:zza	(Lcom/google/android/gms/internal/zzqb$zzc;Ljava/lang/Object;)V
    //   145: iload 4
    //   147: iconst_1
    //   148: iadd
    //   149: istore 4
    //   151: goto -79 -> 72
    //   154: aload 5
    //   156: invokevirtual 836	com/google/android/gms/internal/zzqb$zzb:getSerializedSize	()I
    //   159: newarray <illegal type>
    //   161: astore 6
    //   163: aload 6
    //   165: aload 6
    //   167: arraylength
    //   168: invokestatic 208	com/google/android/gms/internal/zzsn:zzb$46aa22ba	([BI)Lcom/google/android/gms/internal/zzsn;
    //   171: astore 7
    //   173: aload 5
    //   175: aload 7
    //   177: invokevirtual 837	com/google/android/gms/internal/zzqb$zzb:writeTo	(Lcom/google/android/gms/internal/zzsn;)V
    //   180: aload 7
    //   182: invokevirtual 215	com/google/android/gms/internal/zzsn:zzJo	()V
    //   185: aload_0
    //   186: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   189: getfield 511	com/google/android/gms/measurement/internal/zzp:zzaWK	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   192: ldc_w 839
    //   195: aload_1
    //   196: getfield 842	com/google/android/gms/measurement/internal/zzh:mName	Ljava/lang/String;
    //   199: aload 6
    //   201: arraylength
    //   202: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   208: new 217	android/content/ContentValues
    //   211: dup
    //   212: invokespecial 219	android/content/ContentValues:<init>	()V
    //   215: astore 5
    //   217: aload 5
    //   219: ldc -35
    //   221: aload_1
    //   222: getfield 782	com/google/android/gms/measurement/internal/zzh:zzaUa	Ljava/lang/String;
    //   225: invokevirtual 224	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 5
    //   230: ldc_w 843
    //   233: aload_1
    //   234: getfield 842	com/google/android/gms/measurement/internal/zzh:mName	Ljava/lang/String;
    //   237: invokevirtual 224	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload 5
    //   242: ldc_w 845
    //   245: aload_1
    //   246: getfield 848	com/google/android/gms/measurement/internal/zzh:zzaez	J
    //   249: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   252: invokevirtual 635	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   255: aload 5
    //   257: ldc_w 850
    //   260: lload_2
    //   261: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   264: invokevirtual 635	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   267: aload 5
    //   269: ldc -21
    //   271: aload 6
    //   273: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   276: aload_0
    //   277: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   280: ldc_w 852
    //   283: aconst_null
    //   284: aload 5
    //   286: invokevirtual 678	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   289: ldc2_w 251
    //   292: lcmp
    //   293: ifne +16 -> 309
    //   296: aload_0
    //   297: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   300: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   303: ldc_w 854
    //   306: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   309: return
    //   310: astore_1
    //   311: aload_0
    //   312: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   315: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   318: ldc_w 856
    //   321: aload_1
    //   322: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   325: return
    //   326: astore_1
    //   327: aload_0
    //   328: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   331: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   334: ldc_w 858
    //   337: aload_1
    //   338: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   341: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	zze
    //   0	342	1	paramzzh	zzh
    //   0	342	2	paramLong	long
    //   70	80	4	i	int
    //   28	257	5	localObject1	Object
    //   67	205	6	localObject2	Object
    //   101	80	7	localObject3	Object
    //   92	49	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   154	185	310	java/io/IOException
    //   276	309	326	android/database/sqlite/SQLiteException
  }
  
  public final void zza(zzi paramzzi)
  {
    zzx.zzz(paramzzi);
    zzjk();
    zzjv();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", zzaUa);
    localContentValues.put("name", mName);
    localContentValues.put("lifetime_count", Long.valueOf(zzaVP));
    localContentValues.put("current_bundle_count", Long.valueOf(zzaVQ));
    localContentValues.put("last_fire_timestamp", Long.valueOf(zzaVR));
    try
    {
      if (getWritableDatabase().insertWithOnConflict("events", null, localContentValues, 5) == -1L) {
        zzAozzaWC.zzfg("Failed to insert/update event aggregates (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzzi)
    {
      zzAozzaWC.zzj("Error storing event aggregates", paramzzi);
    }
  }
  
  /* Error */
  final void zza(String paramString, int paramInt, com.google.android.gms.internal.zzqb.zzf paramzzf)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   4: aload_0
    //   5: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   8: aload_1
    //   9: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_3
    //   14: invokestatic 153	com/google/android/gms/common/internal/zzx:zzz	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: pop
    //   18: aload_3
    //   19: invokevirtual 876	com/google/android/gms/internal/zzqb$zzf:getSerializedSize	()I
    //   22: newarray <illegal type>
    //   24: astore 4
    //   26: aload 4
    //   28: aload 4
    //   30: arraylength
    //   31: invokestatic 208	com/google/android/gms/internal/zzsn:zzb$46aa22ba	([BI)Lcom/google/android/gms/internal/zzsn;
    //   34: astore 5
    //   36: aload_3
    //   37: aload 5
    //   39: invokevirtual 877	com/google/android/gms/internal/zzqb$zzf:writeTo	(Lcom/google/android/gms/internal/zzsn;)V
    //   42: aload 5
    //   44: invokevirtual 215	com/google/android/gms/internal/zzsn:zzJo	()V
    //   47: new 217	android/content/ContentValues
    //   50: dup
    //   51: invokespecial 219	android/content/ContentValues:<init>	()V
    //   54: astore_3
    //   55: aload_3
    //   56: ldc -35
    //   58: aload_1
    //   59: invokevirtual 224	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_3
    //   63: ldc -30
    //   65: iload_2
    //   66: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: invokevirtual 229	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   72: aload_3
    //   73: ldc_w 412
    //   76: aload 4
    //   78: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   81: aload_0
    //   82: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   85: ldc_w 410
    //   88: aconst_null
    //   89: aload_3
    //   90: iconst_5
    //   91: invokevirtual 250	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   94: ldc2_w 251
    //   97: lcmp
    //   98: ifne +16 -> 114
    //   101: aload_0
    //   102: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   105: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   108: ldc_w 879
    //   111: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   114: return
    //   115: astore_1
    //   116: aload_0
    //   117: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   120: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   123: ldc_w 881
    //   126: aload_1
    //   127: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   130: return
    //   131: astore_1
    //   132: aload_0
    //   133: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   136: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   139: ldc_w 883
    //   142: aload_1
    //   143: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   146: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	zze
    //   0	147	1	paramString	String
    //   0	147	2	paramInt	int
    //   0	147	3	paramzzf	com.google.android.gms.internal.zzqb.zzf
    //   24	53	4	arrayOfByte	byte[]
    //   34	9	5	localzzsn	zzsn
    // Exception table:
    //   from	to	target	type
    //   18	47	115	java/io/IOException
    //   81	114	131	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final void zza(String paramString, long paramLong, zzb paramzzb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload 4
    //   5: invokestatic 153	com/google/android/gms/common/internal/zzx:zzz	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: pop
    //   9: aload_0
    //   10: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   13: aload_0
    //   14: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   17: aload 7
    //   19: astore 6
    //   21: aload_0
    //   22: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 10
    //   27: aload 7
    //   29: astore 6
    //   31: aconst_null
    //   32: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +204 -> 239
    //   38: aload 7
    //   40: astore 6
    //   42: aload 10
    //   44: ldc_w 886
    //   47: iconst_1
    //   48: anewarray 189	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: lload_2
    //   54: invokestatic 501	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   57: aastore
    //   58: invokevirtual 452	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore_1
    //   62: aload_1
    //   63: astore 6
    //   65: aload_1
    //   66: astore 7
    //   68: aload_1
    //   69: invokeinterface 421 1 0
    //   74: istore 5
    //   76: iload 5
    //   78: ifne +14 -> 92
    //   81: aload_1
    //   82: ifnull +9 -> 91
    //   85: aload_1
    //   86: invokeinterface 424 1 0
    //   91: return
    //   92: aload_1
    //   93: astore 6
    //   95: aload_1
    //   96: astore 7
    //   98: aload_1
    //   99: iconst_0
    //   100: invokeinterface 356 2 0
    //   105: astore 8
    //   107: aload_1
    //   108: astore 6
    //   110: aload_1
    //   111: astore 7
    //   113: aload_1
    //   114: iconst_1
    //   115: invokeinterface 356 2 0
    //   120: astore 9
    //   122: aload_1
    //   123: astore 6
    //   125: aload_1
    //   126: astore 7
    //   128: aload_1
    //   129: invokeinterface 424 1 0
    //   134: aload 9
    //   136: astore 7
    //   138: aload_1
    //   139: astore 6
    //   141: aload 6
    //   143: astore_1
    //   144: aload 10
    //   146: ldc_w 888
    //   149: iconst_1
    //   150: anewarray 189	java/lang/String
    //   153: dup
    //   154: iconst_0
    //   155: ldc_w 890
    //   158: aastore
    //   159: ldc_w 892
    //   162: iconst_2
    //   163: anewarray 189	java/lang/String
    //   166: dup
    //   167: iconst_0
    //   168: aload 8
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload 7
    //   175: aastore
    //   176: aconst_null
    //   177: aconst_null
    //   178: ldc_w 894
    //   181: ldc_w 896
    //   184: invokevirtual 899	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   187: astore 9
    //   189: aload 9
    //   191: astore_1
    //   192: aload 9
    //   194: astore 6
    //   196: aload 9
    //   198: invokeinterface 421 1 0
    //   203: ifne +140 -> 343
    //   206: aload 9
    //   208: astore_1
    //   209: aload 9
    //   211: astore 6
    //   213: aload_0
    //   214: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   217: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   220: ldc_w 901
    //   223: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   226: aload 9
    //   228: ifnull -137 -> 91
    //   231: aload 9
    //   233: invokeinterface 424 1 0
    //   238: return
    //   239: aload 7
    //   241: astore 6
    //   243: aload 10
    //   245: ldc_w 903
    //   248: iconst_1
    //   249: anewarray 189	java/lang/String
    //   252: dup
    //   253: iconst_0
    //   254: aconst_null
    //   255: aastore
    //   256: invokevirtual 452	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   259: astore 8
    //   261: aload 8
    //   263: astore 6
    //   265: aload 8
    //   267: astore 7
    //   269: aload 8
    //   271: invokeinterface 421 1 0
    //   276: istore 5
    //   278: iload 5
    //   280: ifne +16 -> 296
    //   283: aload 8
    //   285: ifnull -194 -> 91
    //   288: aload 8
    //   290: invokeinterface 424 1 0
    //   295: return
    //   296: aload 8
    //   298: astore 6
    //   300: aload 8
    //   302: astore 7
    //   304: aload 8
    //   306: iconst_0
    //   307: invokeinterface 356 2 0
    //   312: astore 9
    //   314: aload 8
    //   316: astore 6
    //   318: aload 8
    //   320: astore 7
    //   322: aload 8
    //   324: invokeinterface 424 1 0
    //   329: aload 9
    //   331: astore 7
    //   333: aload 8
    //   335: astore 6
    //   337: aload_1
    //   338: astore 8
    //   340: goto -199 -> 141
    //   343: aload 9
    //   345: astore_1
    //   346: aload 9
    //   348: astore 6
    //   350: aload 9
    //   352: iconst_0
    //   353: invokeinterface 428 2 0
    //   358: invokestatic 434	com/google/android/gms/internal/zzsm:zzD	([B)Lcom/google/android/gms/internal/zzsm;
    //   361: astore 11
    //   363: aload 9
    //   365: astore_1
    //   366: aload 9
    //   368: astore 6
    //   370: new 644	com/google/android/gms/internal/zzqb$zze
    //   373: dup
    //   374: invokespecial 904	com/google/android/gms/internal/zzqb$zze:<init>	()V
    //   377: astore 12
    //   379: aload 9
    //   381: astore_1
    //   382: aload 9
    //   384: astore 6
    //   386: aload 12
    //   388: aload 11
    //   390: invokevirtual 908	com/google/android/gms/internal/zzqb$zze:zzG	(Lcom/google/android/gms/internal/zzsm;)Lcom/google/android/gms/internal/zzqb$zze;
    //   393: pop
    //   394: aload 9
    //   396: astore_1
    //   397: aload 9
    //   399: astore 6
    //   401: aload 9
    //   403: invokeinterface 533 1 0
    //   408: ifeq +23 -> 431
    //   411: aload 9
    //   413: astore_1
    //   414: aload 9
    //   416: astore 6
    //   418: aload_0
    //   419: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   422: getfield 175	com/google/android/gms/measurement/internal/zzp:zzaWF	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   425: ldc_w 910
    //   428: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   431: aload 9
    //   433: astore_1
    //   434: aload 9
    //   436: astore 6
    //   438: aload 9
    //   440: invokeinterface 424 1 0
    //   445: aload 9
    //   447: astore_1
    //   448: aload 9
    //   450: astore 6
    //   452: aload 4
    //   454: aload 12
    //   456: invokeinterface 912 2 0
    //   461: aload 9
    //   463: astore_1
    //   464: aload 9
    //   466: astore 6
    //   468: aload 10
    //   470: ldc_w 852
    //   473: iconst_4
    //   474: anewarray 189	java/lang/String
    //   477: dup
    //   478: iconst_0
    //   479: ldc_w 894
    //   482: aastore
    //   483: dup
    //   484: iconst_1
    //   485: ldc_w 843
    //   488: aastore
    //   489: dup
    //   490: iconst_2
    //   491: ldc_w 845
    //   494: aastore
    //   495: dup
    //   496: iconst_3
    //   497: ldc -21
    //   499: aastore
    //   500: ldc_w 892
    //   503: iconst_2
    //   504: anewarray 189	java/lang/String
    //   507: dup
    //   508: iconst_0
    //   509: aload 8
    //   511: aastore
    //   512: dup
    //   513: iconst_1
    //   514: aload 7
    //   516: aastore
    //   517: aconst_null
    //   518: aconst_null
    //   519: ldc_w 894
    //   522: aconst_null
    //   523: invokevirtual 899	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   526: astore 7
    //   528: aload 7
    //   530: astore_1
    //   531: aload_1
    //   532: astore 6
    //   534: aload_1
    //   535: astore 7
    //   537: aload_1
    //   538: invokeinterface 421 1 0
    //   543: ifne +72 -> 615
    //   546: aload_1
    //   547: astore 6
    //   549: aload_1
    //   550: astore 7
    //   552: aload_0
    //   553: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   556: getfield 175	com/google/android/gms/measurement/internal/zzp:zzaWF	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   559: ldc_w 914
    //   562: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   565: aload_1
    //   566: ifnull -475 -> 91
    //   569: aload_1
    //   570: invokeinterface 424 1 0
    //   575: return
    //   576: astore 4
    //   578: aload 9
    //   580: astore_1
    //   581: aload 9
    //   583: astore 6
    //   585: aload_0
    //   586: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   589: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   592: ldc_w 916
    //   595: aload 8
    //   597: aload 4
    //   599: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   602: aload 9
    //   604: ifnull -513 -> 91
    //   607: aload 9
    //   609: invokeinterface 424 1 0
    //   614: return
    //   615: aload_1
    //   616: astore 6
    //   618: aload_1
    //   619: astore 7
    //   621: aload_1
    //   622: iconst_0
    //   623: invokeinterface 338 2 0
    //   628: lstore_2
    //   629: aload_1
    //   630: astore 6
    //   632: aload_1
    //   633: astore 7
    //   635: aload_1
    //   636: iconst_3
    //   637: invokeinterface 428 2 0
    //   642: invokestatic 434	com/google/android/gms/internal/zzsm:zzD	([B)Lcom/google/android/gms/internal/zzsm;
    //   645: astore 9
    //   647: aload_1
    //   648: astore 6
    //   650: aload_1
    //   651: astore 7
    //   653: new 784	com/google/android/gms/internal/zzqb$zzb
    //   656: dup
    //   657: invokespecial 785	com/google/android/gms/internal/zzqb$zzb:<init>	()V
    //   660: astore 10
    //   662: aload_1
    //   663: astore 6
    //   665: aload_1
    //   666: astore 7
    //   668: aload 10
    //   670: aload 9
    //   672: invokevirtual 919	com/google/android/gms/internal/zzqb$zzb:zzD	(Lcom/google/android/gms/internal/zzsm;)Lcom/google/android/gms/internal/zzqb$zzb;
    //   675: pop
    //   676: aload_1
    //   677: astore 6
    //   679: aload_1
    //   680: astore 7
    //   682: aload 10
    //   684: aload_1
    //   685: iconst_1
    //   686: invokeinterface 356 2 0
    //   691: putfield 920	com/google/android/gms/internal/zzqb$zzb:name	Ljava/lang/String;
    //   694: aload_1
    //   695: astore 6
    //   697: aload_1
    //   698: astore 7
    //   700: aload 10
    //   702: aload_1
    //   703: iconst_2
    //   704: invokeinterface 338 2 0
    //   709: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   712: putfield 923	com/google/android/gms/internal/zzqb$zzb:zzbaf	Ljava/lang/Long;
    //   715: aload_1
    //   716: astore 6
    //   718: aload_1
    //   719: astore 7
    //   721: aload 4
    //   723: lload_2
    //   724: aload 10
    //   726: invokeinterface 926 4 0
    //   731: istore 5
    //   733: iload 5
    //   735: ifne +39 -> 774
    //   738: aload_1
    //   739: ifnull -648 -> 91
    //   742: aload_1
    //   743: invokeinterface 424 1 0
    //   748: return
    //   749: astore 9
    //   751: aload_1
    //   752: astore 6
    //   754: aload_1
    //   755: astore 7
    //   757: aload_0
    //   758: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   761: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   764: ldc_w 928
    //   767: aload 8
    //   769: aload 9
    //   771: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   774: aload_1
    //   775: astore 6
    //   777: aload_1
    //   778: astore 7
    //   780: aload_1
    //   781: invokeinterface 533 1 0
    //   786: istore 5
    //   788: iload 5
    //   790: ifne -175 -> 615
    //   793: aload_1
    //   794: ifnull -703 -> 91
    //   797: aload_1
    //   798: invokeinterface 424 1 0
    //   803: return
    //   804: astore_1
    //   805: aload 6
    //   807: astore 7
    //   809: aload_0
    //   810: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   813: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   816: ldc_w 930
    //   819: aload_1
    //   820: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   823: aload 6
    //   825: ifnull -734 -> 91
    //   828: aload 6
    //   830: invokeinterface 424 1 0
    //   835: return
    //   836: astore 4
    //   838: aconst_null
    //   839: astore_1
    //   840: aload_1
    //   841: ifnull +9 -> 850
    //   844: aload_1
    //   845: invokeinterface 424 1 0
    //   850: aload 4
    //   852: athrow
    //   853: astore 4
    //   855: aload 7
    //   857: astore_1
    //   858: goto -18 -> 840
    //   861: astore 4
    //   863: goto -23 -> 840
    //   866: astore_1
    //   867: goto -62 -> 805
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	this	zze
    //   0	870	1	paramString	String
    //   0	870	2	paramLong	long
    //   0	870	4	paramzzb	zzb
    //   74	715	5	bool	boolean
    //   19	810	6	localObject1	Object
    //   1	855	7	localObject2	Object
    //   105	663	8	localObject3	Object
    //   120	551	9	localObject4	Object
    //   749	21	9	localIOException	IOException
    //   25	700	10	localObject5	Object
    //   361	28	11	localzzsm	com.google.android.gms.internal.zzsm
    //   377	78	12	localzze	zzqb.zze
    // Exception table:
    //   from	to	target	type
    //   386	394	576	java/io/IOException
    //   668	676	749	java/io/IOException
    //   21	27	804	android/database/sqlite/SQLiteException
    //   31	38	804	android/database/sqlite/SQLiteException
    //   42	62	804	android/database/sqlite/SQLiteException
    //   68	76	804	android/database/sqlite/SQLiteException
    //   98	107	804	android/database/sqlite/SQLiteException
    //   113	122	804	android/database/sqlite/SQLiteException
    //   128	134	804	android/database/sqlite/SQLiteException
    //   243	261	804	android/database/sqlite/SQLiteException
    //   269	278	804	android/database/sqlite/SQLiteException
    //   304	314	804	android/database/sqlite/SQLiteException
    //   322	329	804	android/database/sqlite/SQLiteException
    //   537	546	804	android/database/sqlite/SQLiteException
    //   552	565	804	android/database/sqlite/SQLiteException
    //   621	629	804	android/database/sqlite/SQLiteException
    //   635	647	804	android/database/sqlite/SQLiteException
    //   653	662	804	android/database/sqlite/SQLiteException
    //   668	676	804	android/database/sqlite/SQLiteException
    //   682	694	804	android/database/sqlite/SQLiteException
    //   700	715	804	android/database/sqlite/SQLiteException
    //   721	733	804	android/database/sqlite/SQLiteException
    //   757	774	804	android/database/sqlite/SQLiteException
    //   780	788	804	android/database/sqlite/SQLiteException
    //   21	27	836	finally
    //   31	38	836	finally
    //   42	62	836	finally
    //   243	261	836	finally
    //   68	76	853	finally
    //   98	107	853	finally
    //   113	122	853	finally
    //   128	134	853	finally
    //   269	278	853	finally
    //   304	314	853	finally
    //   322	329	853	finally
    //   537	546	853	finally
    //   552	565	853	finally
    //   621	629	853	finally
    //   635	647	853	finally
    //   653	662	853	finally
    //   668	676	853	finally
    //   682	694	853	finally
    //   700	715	853	finally
    //   721	733	853	finally
    //   757	774	853	finally
    //   780	788	853	finally
    //   809	823	853	finally
    //   144	189	861	finally
    //   196	206	861	finally
    //   213	226	861	finally
    //   350	363	861	finally
    //   370	379	861	finally
    //   386	394	861	finally
    //   401	411	861	finally
    //   418	431	861	finally
    //   438	445	861	finally
    //   452	461	861	finally
    //   468	528	861	finally
    //   585	602	861	finally
    //   144	189	866	android/database/sqlite/SQLiteException
    //   196	206	866	android/database/sqlite/SQLiteException
    //   213	226	866	android/database/sqlite/SQLiteException
    //   350	363	866	android/database/sqlite/SQLiteException
    //   370	379	866	android/database/sqlite/SQLiteException
    //   386	394	866	android/database/sqlite/SQLiteException
    //   401	411	866	android/database/sqlite/SQLiteException
    //   418	431	866	android/database/sqlite/SQLiteException
    //   438	445	866	android/database/sqlite/SQLiteException
    //   452	461	866	android/database/sqlite/SQLiteException
    //   468	528	866	android/database/sqlite/SQLiteException
    //   585	602	866	android/database/sqlite/SQLiteException
  }
  
  public final boolean zza(zzai paramzzai)
  {
    zzx.zzz(paramzzai);
    zzjk();
    zzjv();
    if (zzK(zzaUa, mName) == null)
    {
      long l;
      if (zzaj.zzfq(mName))
      {
        l = zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[] { zzaUa });
        zzd.zzBL();
        if (l < 25L) {}
      }
      else
      {
        do
        {
          return false;
          l = zzb("select count(1) from user_attributes where app_id=?", new String[] { zzaUa });
          zzd.zzBM();
        } while (l >= 50L);
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", zzaUa);
    localContentValues.put("name", mName);
    localContentValues.put("set_timestamp", Long.valueOf(zzaZp));
    paramzzai = zzNc;
    zzx.zzcM("value");
    zzx.zzz(paramzzai);
    if ((paramzzai instanceof String)) {
      localContentValues.put("value", (String)paramzzai);
    }
    try
    {
      for (;;)
      {
        if (getWritableDatabase().insertWithOnConflict("user_attributes", null, localContentValues, 5) == -1L) {
          zzAozzaWC.zzfg("Failed to insert/update user property (got -1)");
        }
        return true;
        if ((paramzzai instanceof Long))
        {
          localContentValues.put("value", (Long)paramzzai);
        }
        else
        {
          if (!(paramzzai instanceof Float)) {
            break;
          }
          localContentValues.put("value", (Float)paramzzai);
        }
      }
      throw new IllegalArgumentException("Invalid value type");
    }
    catch (SQLiteException paramzzai)
    {
      for (;;)
      {
        zzAozzaWC.zzj("Error storing user property", paramzzai);
      }
    }
  }
  
  /* Error */
  final long zza$6e791f8(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aload 7
    //   14: aload_1
    //   15: aload_2
    //   16: invokevirtual 452	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 421 1 0
    //   26: ifeq +23 -> 49
    //   29: aload_2
    //   30: iconst_0
    //   31: invokeinterface 338 2 0
    //   36: lstore_3
    //   37: aload_2
    //   38: ifnull +9 -> 47
    //   41: aload_2
    //   42: invokeinterface 424 1 0
    //   47: lload_3
    //   48: lreturn
    //   49: aload_2
    //   50: ifnull +9 -> 59
    //   53: aload_2
    //   54: invokeinterface 424 1 0
    //   59: lconst_0
    //   60: lreturn
    //   61: astore 5
    //   63: aload 6
    //   65: astore_2
    //   66: aload 5
    //   68: astore 6
    //   70: aload_2
    //   71: astore 5
    //   73: aload_0
    //   74: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   77: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   80: ldc_w 979
    //   83: aload_1
    //   84: aload 6
    //   86: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   89: aload_2
    //   90: astore 5
    //   92: aload 6
    //   94: athrow
    //   95: astore_1
    //   96: aload 5
    //   98: ifnull +10 -> 108
    //   101: aload 5
    //   103: invokeinterface 424 1 0
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_2
    //   112: astore 5
    //   114: goto -18 -> 96
    //   117: astore 6
    //   119: goto -49 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	zze
    //   0	122	1	paramString	String
    //   0	122	2	paramArrayOfString	String[]
    //   36	12	3	l	long
    //   7	1	5	localObject	Object
    //   61	6	5	localSQLiteException1	SQLiteException
    //   71	42	5	arrayOfString	String[]
    //   10	83	6	localSQLiteException2	SQLiteException
    //   117	1	6	localSQLiteException3	SQLiteException
    //   4	9	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   12	20	61	android/database/sqlite/SQLiteException
    //   12	20	95	finally
    //   73	89	95	finally
    //   92	95	95	finally
    //   20	37	110	finally
    //   20	37	117	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final String zzaa(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   7: aload_0
    //   8: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   11: aload_0
    //   12: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: ldc_w 982
    //   18: iconst_1
    //   19: anewarray 189	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: lload_1
    //   25: invokestatic 501	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   28: aastore
    //   29: invokevirtual 452	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_3
    //   33: aload_3
    //   34: astore 4
    //   36: aload_3
    //   37: invokeinterface 421 1 0
    //   42: ifne +40 -> 82
    //   45: aload_3
    //   46: astore 4
    //   48: aload_0
    //   49: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   52: getfield 511	com/google/android/gms/measurement/internal/zzp:zzaWK	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   55: ldc_w 984
    //   58: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   61: aload 6
    //   63: astore 4
    //   65: aload_3
    //   66: ifnull +13 -> 79
    //   69: aload_3
    //   70: invokeinterface 424 1 0
    //   75: aload 6
    //   77: astore 4
    //   79: aload 4
    //   81: areturn
    //   82: aload_3
    //   83: astore 4
    //   85: aload_3
    //   86: iconst_0
    //   87: invokeinterface 356 2 0
    //   92: astore 5
    //   94: aload 5
    //   96: astore 4
    //   98: aload_3
    //   99: ifnull -20 -> 79
    //   102: aload_3
    //   103: invokeinterface 424 1 0
    //   108: aload 5
    //   110: areturn
    //   111: astore 5
    //   113: aconst_null
    //   114: astore_3
    //   115: aload_3
    //   116: astore 4
    //   118: aload_0
    //   119: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   122: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   125: ldc_w 986
    //   128: aload 5
    //   130: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   133: aload 6
    //   135: astore 4
    //   137: aload_3
    //   138: ifnull -59 -> 79
    //   141: aload_3
    //   142: invokeinterface 424 1 0
    //   147: aconst_null
    //   148: areturn
    //   149: astore_3
    //   150: aconst_null
    //   151: astore 4
    //   153: aload 4
    //   155: ifnull +10 -> 165
    //   158: aload 4
    //   160: invokeinterface 424 1 0
    //   165: aload_3
    //   166: athrow
    //   167: astore_3
    //   168: goto -15 -> 153
    //   171: astore 5
    //   173: goto -58 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	zze
    //   0	176	1	paramLong	long
    //   32	110	3	localCursor	Cursor
    //   149	17	3	localObject1	Object
    //   167	1	3	localObject2	Object
    //   34	125	4	localObject3	Object
    //   92	17	5	str	String
    //   111	18	5	localSQLiteException1	SQLiteException
    //   171	1	5	localSQLiteException2	SQLiteException
    //   1	133	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	33	111	android/database/sqlite/SQLiteException
    //   11	33	149	finally
    //   36	45	167	finally
    //   48	61	167	finally
    //   85	94	167	finally
    //   118	133	167	finally
    //   36	45	171	android/database/sqlite/SQLiteException
    //   48	61	171	android/database/sqlite/SQLiteException
    //   85	94	171	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final long zzb(zzqb.zze paramzze)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   4: aload_0
    //   5: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   8: aload_1
    //   9: invokestatic 153	com/google/android/gms/common/internal/zzx:zzz	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: aload_1
    //   14: getfield 647	com/google/android/gms/internal/zzqb$zze:appId	Ljava/lang/String;
    //   17: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   20: pop
    //   21: aload_1
    //   22: invokevirtual 659	com/google/android/gms/internal/zzqb$zze:getSerializedSize	()I
    //   25: newarray <illegal type>
    //   27: astore 4
    //   29: aload 4
    //   31: aload 4
    //   33: arraylength
    //   34: invokestatic 208	com/google/android/gms/internal/zzsn:zzb$46aa22ba	([BI)Lcom/google/android/gms/internal/zzsn;
    //   37: astore 5
    //   39: aload_1
    //   40: aload 5
    //   42: invokevirtual 660	com/google/android/gms/internal/zzqb$zze:writeTo	(Lcom/google/android/gms/internal/zzsn;)V
    //   45: aload 5
    //   47: invokevirtual 215	com/google/android/gms/internal/zzsn:zzJo	()V
    //   50: aload_0
    //   51: invokevirtual 664	com/google/android/gms/measurement/internal/zze:zzCk	()Lcom/google/android/gms/measurement/internal/zzaj;
    //   54: aload 4
    //   56: invokevirtual 991	com/google/android/gms/measurement/internal/zzaj:zzr	([B)J
    //   59: lstore_2
    //   60: new 217	android/content/ContentValues
    //   63: dup
    //   64: invokespecial 219	android/content/ContentValues:<init>	()V
    //   67: astore 5
    //   69: aload 5
    //   71: ldc -35
    //   73: aload_1
    //   74: getfield 647	com/google/android/gms/internal/zzqb$zze:appId	Ljava/lang/String;
    //   77: invokevirtual 224	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload 5
    //   82: ldc_w 850
    //   85: lload_2
    //   86: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 635	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   92: aload 5
    //   94: ldc_w 890
    //   97: aload 4
    //   99: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   102: aload_0
    //   103: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   106: ldc_w 888
    //   109: aconst_null
    //   110: aload 5
    //   112: iconst_4
    //   113: invokevirtual 250	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   116: pop2
    //   117: lload_2
    //   118: lreturn
    //   119: astore_1
    //   120: aload_0
    //   121: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   124: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   127: ldc_w 993
    //   130: aload_1
    //   131: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   141: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   144: ldc_w 995
    //   147: aload_1
    //   148: invokevirtual 267	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	zze
    //   0	153	1	paramzze	zzqb.zze
    //   59	59	2	l	long
    //   27	71	4	arrayOfByte	byte[]
    //   37	74	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	50	119	java/io/IOException
    //   102	117	136	android/database/sqlite/SQLiteException
  }
  
  final long zzb(String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Object localObject = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = localSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject = paramArrayOfString;
        long l = paramArrayOfString.getLong(0);
        if (paramArrayOfString != null) {
          paramArrayOfString.close();
        }
        return l;
      }
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      throw new SQLiteException("Database returned empty set");
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject = arrayOfString;
      zzAozzaWC.zze("Database error", paramString, paramArrayOfString);
      localObject = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
    }
  }
  
  final void zzb(String paramString, zzpz.zza[] paramArrayOfzza)
  {
    zzjv();
    zzjk();
    zzx.zzcM(paramString);
    zzx.zzz(paramArrayOfzza);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    Object localObject1;
    int j;
    int i1;
    for (;;)
    {
      try
      {
        zzjv();
        zzjk();
        zzx.zzcM(paramString);
        localObject1 = getWritableDatabase();
        ((SQLiteDatabase)localObject1).delete("property_filters", "app_id=?", new String[] { paramString });
        ((SQLiteDatabase)localObject1).delete("event_filters", "app_id=?", new String[] { paramString });
        int n = paramArrayOfzza.length;
        j = 0;
        if (j >= n) {
          break label465;
        }
        localObject1 = paramArrayOfzza[j];
        zzjv();
        zzjk();
        zzx.zzcM(paramString);
        zzx.zzz(localObject1);
        zzx.zzz(zzaZt);
        zzx.zzz(zzaZs);
        if (zzaZr == null)
        {
          zzAozzaWF.zzfg("Audience with no ID");
        }
        else
        {
          i1 = zzaZr.intValue();
          localObject2 = zzaZt;
          k = localObject2.length;
          i = 0;
          if (i < k) {
            if (zzaZv == null) {
              zzAozzaWF.zze("Event filter with no ID. Audience definition ignored. appId, audienceId", paramString, zzaZr);
            }
          }
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      i += 1;
    }
    Object localObject2 = zzaZs;
    int k = localObject2.length;
    int i = 0;
    label259:
    label311:
    label333:
    int m;
    int i2;
    if (i < k)
    {
      if (zzaZv != null) {
        break label490;
      }
      zzAozzaWF.zze("Property filter with no ID. Audience definition ignored. appId, audienceId", paramString, zzaZr);
    }
    else
    {
      localObject2 = zzaZt;
      k = localObject2.length;
      i = 0;
      if (i < k)
      {
        if (zza(paramString, i1, localObject2[i])) {
          break label497;
        }
        i = 0;
        m = i;
        if (i != 0)
        {
          localObject1 = zzaZs;
          i2 = localObject1.length;
          k = 0;
        }
      }
    }
    for (;;)
    {
      m = i;
      if (k < i2)
      {
        if (!zza(paramString, i1, localObject1[k])) {
          m = 0;
        }
      }
      else
      {
        if (m == 0)
        {
          zzjv();
          zzjk();
          zzx.zzcM(paramString);
          localObject1 = getWritableDatabase();
          ((SQLiteDatabase)localObject1).delete("property_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(i1) });
          ((SQLiteDatabase)localObject1).delete("event_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(i1) });
          break label481;
          label465:
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          return;
          i = 1;
          break label333;
        }
        label481:
        j += 1;
        break;
        label490:
        i += 1;
        break label259;
        label497:
        i += 1;
        break label311;
      }
      k += 1;
    }
  }
  
  public final void zzd(String paramString, byte[] paramArrayOfByte)
  {
    zzx.zzcM(paramString);
    zzjk();
    zzjv();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("remote_config", paramArrayOfByte);
    try
    {
      if (getWritableDatabase().update("apps", localContentValues, "app_id = ?", new String[] { paramString }) == 0L) {
        zzAozzaWC.zzfg("Failed to update remote config (got 0)");
      }
      return;
    }
    catch (SQLiteException paramString)
    {
      zzAozzaWC.zzj("Error storing remote config", paramString);
    }
  }
  
  /* Error */
  public final List<zzai> zzeX(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_0
    //   9: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   12: aload_0
    //   13: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   16: new 589	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 590	java/util/ArrayList:<init>	()V
    //   23: astore 8
    //   25: aload_0
    //   26: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 6
    //   31: invokestatic 954	com/google/android/gms/measurement/internal/zzd:zzBM	()I
    //   34: istore_2
    //   35: aload 6
    //   37: ldc_w 544
    //   40: iconst_3
    //   41: anewarray 189	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: ldc_w 843
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: ldc_w 552
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: ldc_w 554
    //   61: aastore
    //   62: ldc_w 620
    //   65: iconst_1
    //   66: anewarray 189	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: aload_1
    //   72: aastore
    //   73: aconst_null
    //   74: aconst_null
    //   75: ldc_w 894
    //   78: iload_2
    //   79: invokestatic 400	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   82: invokevirtual 899	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 6
    //   87: aload 6
    //   89: invokeinterface 421 1 0
    //   94: istore_3
    //   95: iload_3
    //   96: ifne +18 -> 114
    //   99: aload 6
    //   101: ifnull +10 -> 111
    //   104: aload 6
    //   106: invokeinterface 424 1 0
    //   111: aload 8
    //   113: areturn
    //   114: aload 6
    //   116: iconst_0
    //   117: invokeinterface 356 2 0
    //   122: astore 7
    //   124: aload 6
    //   126: iconst_1
    //   127: invokeinterface 338 2 0
    //   132: lstore 4
    //   134: aload_0
    //   135: aload 6
    //   137: iconst_2
    //   138: invokespecial 558	com/google/android/gms/measurement/internal/zze:zzb	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   141: astore 9
    //   143: aload 9
    //   145: ifnonnull +43 -> 188
    //   148: aload_0
    //   149: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   152: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   155: ldc_w 1038
    //   158: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   161: aload 6
    //   163: invokeinterface 533 1 0
    //   168: istore_3
    //   169: iload_3
    //   170: ifne -56 -> 114
    //   173: aload 6
    //   175: ifnull +10 -> 185
    //   178: aload 6
    //   180: invokeinterface 424 1 0
    //   185: aload 8
    //   187: areturn
    //   188: aload 8
    //   190: new 556	com/google/android/gms/measurement/internal/zzai
    //   193: dup
    //   194: aload_1
    //   195: aload 7
    //   197: lload 4
    //   199: aload 9
    //   201: invokespecial 561	com/google/android/gms/measurement/internal/zzai:<init>	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   204: invokeinterface 594 2 0
    //   209: pop
    //   210: goto -49 -> 161
    //   213: astore 7
    //   215: aload_0
    //   216: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   219: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   222: ldc_w 1040
    //   225: aload_1
    //   226: aload 7
    //   228: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   231: aload 6
    //   233: ifnull +10 -> 243
    //   236: aload 6
    //   238: invokeinterface 424 1 0
    //   243: aconst_null
    //   244: areturn
    //   245: astore_1
    //   246: aload 7
    //   248: astore 6
    //   250: aload 6
    //   252: ifnull +10 -> 262
    //   255: aload 6
    //   257: invokeinterface 424 1 0
    //   262: aload_1
    //   263: athrow
    //   264: astore_1
    //   265: goto -15 -> 250
    //   268: astore_1
    //   269: goto -19 -> 250
    //   272: astore 7
    //   274: aconst_null
    //   275: astore 6
    //   277: goto -62 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	zze
    //   0	280	1	paramString	String
    //   34	45	2	i	int
    //   94	76	3	bool	boolean
    //   132	66	4	l	long
    //   29	247	6	localObject1	Object
    //   1	195	7	str	String
    //   213	34	7	localSQLiteException1	SQLiteException
    //   272	1	7	localSQLiteException2	SQLiteException
    //   23	166	8	localArrayList	java.util.ArrayList
    //   141	59	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   87	95	213	android/database/sqlite/SQLiteException
    //   114	143	213	android/database/sqlite/SQLiteException
    //   148	161	213	android/database/sqlite/SQLiteException
    //   161	169	213	android/database/sqlite/SQLiteException
    //   188	210	213	android/database/sqlite/SQLiteException
    //   25	87	245	finally
    //   87	95	264	finally
    //   114	143	264	finally
    //   148	161	264	finally
    //   161	169	264	finally
    //   188	210	264	finally
    //   215	231	268	finally
    //   25	87	272	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public final zza zzeY(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   9: aload_0
    //   10: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   13: aload_0
    //   14: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc_w 618
    //   20: bipush 17
    //   22: anewarray 189	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 692
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: ldc_w 697
    //   36: aastore
    //   37: dup
    //   38: iconst_2
    //   39: ldc_w 702
    //   42: aastore
    //   43: dup
    //   44: iconst_3
    //   45: ldc_w 707
    //   48: aastore
    //   49: dup
    //   50: iconst_4
    //   51: ldc 58
    //   53: aastore
    //   54: dup
    //   55: iconst_5
    //   56: ldc_w 715
    //   59: aastore
    //   60: dup
    //   61: bipush 6
    //   63: ldc 32
    //   65: aastore
    //   66: dup
    //   67: bipush 7
    //   69: ldc 42
    //   71: aastore
    //   72: dup
    //   73: bipush 8
    //   75: ldc 46
    //   77: aastore
    //   78: dup
    //   79: bipush 9
    //   81: ldc 50
    //   83: aastore
    //   84: dup
    //   85: bipush 10
    //   87: ldc 54
    //   89: aastore
    //   90: dup
    //   91: bipush 11
    //   93: ldc 62
    //   95: aastore
    //   96: dup
    //   97: bipush 12
    //   99: ldc 66
    //   101: aastore
    //   102: dup
    //   103: bipush 13
    //   105: ldc 70
    //   107: aastore
    //   108: dup
    //   109: bipush 14
    //   111: ldc 74
    //   113: aastore
    //   114: dup
    //   115: bipush 15
    //   117: ldc 82
    //   119: aastore
    //   120: dup
    //   121: bipush 16
    //   123: ldc 86
    //   125: aastore
    //   126: ldc_w 620
    //   129: iconst_1
    //   130: anewarray 189	java/lang/String
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: aastore
    //   137: aconst_null
    //   138: aconst_null
    //   139: aconst_null
    //   140: invokevirtual 418	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   143: astore 7
    //   145: aload 7
    //   147: astore 6
    //   149: aload 7
    //   151: invokeinterface 421 1 0
    //   156: istore_3
    //   157: iload_3
    //   158: ifne +19 -> 177
    //   161: aload 7
    //   163: ifnull +10 -> 173
    //   166: aload 7
    //   168: invokeinterface 424 1 0
    //   173: aconst_null
    //   174: astore_1
    //   175: aload_1
    //   176: areturn
    //   177: aload 7
    //   179: astore 6
    //   181: new 687	com/google/android/gms/measurement/internal/zza
    //   184: dup
    //   185: aload_0
    //   186: getfield 1044	com/google/android/gms/measurement/internal/zze:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   189: aload_1
    //   190: invokespecial 1047	com/google/android/gms/measurement/internal/zza:<init>	(Lcom/google/android/gms/measurement/internal/zzw;Ljava/lang/String;)V
    //   193: astore 8
    //   195: aload 7
    //   197: astore 6
    //   199: aload 8
    //   201: aload 7
    //   203: iconst_0
    //   204: invokeinterface 356 2 0
    //   209: invokevirtual 1050	com/google/android/gms/measurement/internal/zza:zzeM	(Ljava/lang/String;)V
    //   212: aload 7
    //   214: astore 6
    //   216: aload 8
    //   218: aload 7
    //   220: iconst_1
    //   221: invokeinterface 356 2 0
    //   226: invokevirtual 1053	com/google/android/gms/measurement/internal/zza:zzeN	(Ljava/lang/String;)V
    //   229: aload 7
    //   231: astore 6
    //   233: aload 8
    //   235: aload 7
    //   237: iconst_2
    //   238: invokeinterface 356 2 0
    //   243: invokevirtual 1056	com/google/android/gms/measurement/internal/zza:zzeO	(Ljava/lang/String;)V
    //   246: aload 7
    //   248: astore 6
    //   250: aload 8
    //   252: aload 7
    //   254: iconst_3
    //   255: invokeinterface 338 2 0
    //   260: invokevirtual 1059	com/google/android/gms/measurement/internal/zza:zzS	(J)V
    //   263: aload 7
    //   265: astore 6
    //   267: aload 8
    //   269: aload 7
    //   271: iconst_4
    //   272: invokeinterface 338 2 0
    //   277: invokevirtual 1062	com/google/android/gms/measurement/internal/zza:zzO	(J)V
    //   280: aload 7
    //   282: astore 6
    //   284: aload 8
    //   286: aload 7
    //   288: iconst_5
    //   289: invokeinterface 338 2 0
    //   294: invokevirtual 1065	com/google/android/gms/measurement/internal/zza:zzP	(J)V
    //   297: aload 7
    //   299: astore 6
    //   301: aload 8
    //   303: aload 7
    //   305: bipush 6
    //   307: invokeinterface 356 2 0
    //   312: invokevirtual 1068	com/google/android/gms/measurement/internal/zza:setAppVersion	(Ljava/lang/String;)V
    //   315: aload 7
    //   317: astore 6
    //   319: aload 8
    //   321: aload 7
    //   323: bipush 7
    //   325: invokeinterface 356 2 0
    //   330: invokevirtual 1071	com/google/android/gms/measurement/internal/zza:zzeP	(Ljava/lang/String;)V
    //   333: aload 7
    //   335: astore 6
    //   337: aload 8
    //   339: aload 7
    //   341: bipush 8
    //   343: invokeinterface 338 2 0
    //   348: invokevirtual 1074	com/google/android/gms/measurement/internal/zza:zzQ	(J)V
    //   351: aload 7
    //   353: astore 6
    //   355: aload 8
    //   357: aload 7
    //   359: bipush 9
    //   361: invokeinterface 338 2 0
    //   366: invokevirtual 1077	com/google/android/gms/measurement/internal/zza:zzR	(J)V
    //   369: aload 7
    //   371: astore 6
    //   373: aload 7
    //   375: bipush 10
    //   377: invokeinterface 1080 2 0
    //   382: ifeq +448 -> 830
    //   385: iconst_1
    //   386: istore_2
    //   387: goto +551 -> 938
    //   390: aload 7
    //   392: astore 6
    //   394: aload 8
    //   396: iload_3
    //   397: invokevirtual 1084	com/google/android/gms/measurement/internal/zza:setMeasurementEnabled	(Z)V
    //   400: aload 7
    //   402: astore 6
    //   404: aload 7
    //   406: bipush 11
    //   408: invokeinterface 338 2 0
    //   413: lstore 4
    //   415: aload 7
    //   417: astore 6
    //   419: aload 8
    //   421: getfield 745	com/google/android/gms/measurement/internal/zza:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   424: invokevirtual 751	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   427: invokevirtual 754	com/google/android/gms/measurement/internal/zzv:zzjk	()V
    //   430: aload 7
    //   432: astore 6
    //   434: aload 8
    //   436: getfield 1088	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   439: istore_3
    //   440: aload 7
    //   442: astore 6
    //   444: aload 8
    //   446: getfield 757	com/google/android/gms/measurement/internal/zza:zzaVm	J
    //   449: lload 4
    //   451: lcmp
    //   452: ifeq +400 -> 852
    //   455: iconst_1
    //   456: istore_2
    //   457: aload 7
    //   459: astore 6
    //   461: aload 8
    //   463: iload_2
    //   464: iload_3
    //   465: ior
    //   466: putfield 1088	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   469: aload 7
    //   471: astore 6
    //   473: aload 8
    //   475: lload 4
    //   477: putfield 757	com/google/android/gms/measurement/internal/zza:zzaVm	J
    //   480: aload 7
    //   482: astore 6
    //   484: aload 7
    //   486: bipush 12
    //   488: invokeinterface 338 2 0
    //   493: lstore 4
    //   495: aload 7
    //   497: astore 6
    //   499: aload 8
    //   501: getfield 745	com/google/android/gms/measurement/internal/zza:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   504: invokevirtual 751	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   507: invokevirtual 754	com/google/android/gms/measurement/internal/zzv:zzjk	()V
    //   510: aload 7
    //   512: astore 6
    //   514: aload 8
    //   516: getfield 1088	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   519: istore_3
    //   520: aload 7
    //   522: astore 6
    //   524: aload 8
    //   526: getfield 760	com/google/android/gms/measurement/internal/zza:zzaVn	J
    //   529: lload 4
    //   531: lcmp
    //   532: ifeq +325 -> 857
    //   535: iconst_1
    //   536: istore_2
    //   537: aload 7
    //   539: astore 6
    //   541: aload 8
    //   543: iload_2
    //   544: iload_3
    //   545: ior
    //   546: putfield 1088	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   549: aload 7
    //   551: astore 6
    //   553: aload 8
    //   555: lload 4
    //   557: putfield 760	com/google/android/gms/measurement/internal/zza:zzaVn	J
    //   560: aload 7
    //   562: astore 6
    //   564: aload 7
    //   566: bipush 13
    //   568: invokeinterface 338 2 0
    //   573: lstore 4
    //   575: aload 7
    //   577: astore 6
    //   579: aload 8
    //   581: getfield 745	com/google/android/gms/measurement/internal/zza:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   584: invokevirtual 751	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   587: invokevirtual 754	com/google/android/gms/measurement/internal/zzv:zzjk	()V
    //   590: aload 7
    //   592: astore 6
    //   594: aload 8
    //   596: getfield 1088	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   599: istore_3
    //   600: aload 7
    //   602: astore 6
    //   604: aload 8
    //   606: getfield 763	com/google/android/gms/measurement/internal/zza:zzaVo	J
    //   609: lload 4
    //   611: lcmp
    //   612: ifeq +250 -> 862
    //   615: iconst_1
    //   616: istore_2
    //   617: aload 7
    //   619: astore 6
    //   621: aload 8
    //   623: iload_2
    //   624: iload_3
    //   625: ior
    //   626: putfield 1088	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   629: aload 7
    //   631: astore 6
    //   633: aload 8
    //   635: lload 4
    //   637: putfield 763	com/google/android/gms/measurement/internal/zza:zzaVo	J
    //   640: aload 7
    //   642: astore 6
    //   644: aload 7
    //   646: bipush 14
    //   648: invokeinterface 338 2 0
    //   653: lstore 4
    //   655: aload 7
    //   657: astore 6
    //   659: aload 8
    //   661: getfield 745	com/google/android/gms/measurement/internal/zza:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   664: invokevirtual 751	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   667: invokevirtual 754	com/google/android/gms/measurement/internal/zzv:zzjk	()V
    //   670: aload 7
    //   672: astore 6
    //   674: aload 8
    //   676: getfield 1088	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   679: istore_3
    //   680: aload 7
    //   682: astore 6
    //   684: aload 8
    //   686: getfield 766	com/google/android/gms/measurement/internal/zza:zzaVp	J
    //   689: lload 4
    //   691: lcmp
    //   692: ifeq +175 -> 867
    //   695: iconst_1
    //   696: istore_2
    //   697: aload 7
    //   699: astore 6
    //   701: aload 8
    //   703: iload_2
    //   704: iload_3
    //   705: ior
    //   706: putfield 1088	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   709: aload 7
    //   711: astore 6
    //   713: aload 8
    //   715: lload 4
    //   717: putfield 766	com/google/android/gms/measurement/internal/zza:zzaVp	J
    //   720: aload 7
    //   722: astore 6
    //   724: aload 8
    //   726: aload 7
    //   728: bipush 15
    //   730: invokeinterface 338 2 0
    //   735: invokevirtual 1091	com/google/android/gms/measurement/internal/zza:zzT	(J)V
    //   738: aload 7
    //   740: astore 6
    //   742: aload 8
    //   744: aload 7
    //   746: bipush 16
    //   748: invokeinterface 338 2 0
    //   753: invokevirtual 1094	com/google/android/gms/measurement/internal/zza:zzU	(J)V
    //   756: aload 7
    //   758: astore 6
    //   760: aload 8
    //   762: getfield 745	com/google/android/gms/measurement/internal/zza:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   765: invokevirtual 751	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   768: invokevirtual 754	com/google/android/gms/measurement/internal/zzv:zzjk	()V
    //   771: aload 7
    //   773: astore 6
    //   775: aload 8
    //   777: iconst_0
    //   778: putfield 1088	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   781: aload 7
    //   783: astore 6
    //   785: aload 7
    //   787: invokeinterface 533 1 0
    //   792: ifeq +20 -> 812
    //   795: aload 7
    //   797: astore 6
    //   799: aload_0
    //   800: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   803: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   806: ldc_w 1096
    //   809: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   812: aload 8
    //   814: astore_1
    //   815: aload 7
    //   817: ifnull -642 -> 175
    //   820: aload 7
    //   822: invokeinterface 424 1 0
    //   827: aload 8
    //   829: areturn
    //   830: aload 7
    //   832: astore 6
    //   834: aload 7
    //   836: bipush 10
    //   838: invokeinterface 583 2 0
    //   843: istore_2
    //   844: goto +94 -> 938
    //   847: iconst_0
    //   848: istore_3
    //   849: goto -459 -> 390
    //   852: iconst_0
    //   853: istore_2
    //   854: goto -397 -> 457
    //   857: iconst_0
    //   858: istore_2
    //   859: goto -322 -> 537
    //   862: iconst_0
    //   863: istore_2
    //   864: goto -247 -> 617
    //   867: iconst_0
    //   868: istore_2
    //   869: goto -172 -> 697
    //   872: astore 8
    //   874: aconst_null
    //   875: astore 7
    //   877: aload 7
    //   879: astore 6
    //   881: aload_0
    //   882: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   885: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   888: ldc_w 1098
    //   891: aload_1
    //   892: aload 8
    //   894: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   897: aload 7
    //   899: ifnull +10 -> 909
    //   902: aload 7
    //   904: invokeinterface 424 1 0
    //   909: aconst_null
    //   910: areturn
    //   911: astore_1
    //   912: aconst_null
    //   913: astore 6
    //   915: aload 6
    //   917: ifnull +10 -> 927
    //   920: aload 6
    //   922: invokeinterface 424 1 0
    //   927: aload_1
    //   928: athrow
    //   929: astore_1
    //   930: goto -15 -> 915
    //   933: astore 8
    //   935: goto -58 -> 877
    //   938: iload_2
    //   939: ifeq -92 -> 847
    //   942: iconst_1
    //   943: istore_3
    //   944: goto -554 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	947	0	this	zze
    //   0	947	1	paramString	String
    //   386	320	2	bool1	boolean
    //   843	96	2	i	int
    //   156	788	3	bool2	boolean
    //   413	303	4	l	long
    //   147	774	6	localCursor1	Cursor
    //   143	760	7	localCursor2	Cursor
    //   193	635	8	localzza	zza
    //   872	21	8	localSQLiteException1	SQLiteException
    //   933	1	8	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   13	145	872	android/database/sqlite/SQLiteException
    //   13	145	911	finally
    //   149	157	929	finally
    //   181	195	929	finally
    //   199	212	929	finally
    //   216	229	929	finally
    //   233	246	929	finally
    //   250	263	929	finally
    //   267	280	929	finally
    //   284	297	929	finally
    //   301	315	929	finally
    //   319	333	929	finally
    //   337	351	929	finally
    //   355	369	929	finally
    //   373	385	929	finally
    //   394	400	929	finally
    //   404	415	929	finally
    //   419	430	929	finally
    //   434	440	929	finally
    //   444	455	929	finally
    //   461	469	929	finally
    //   473	480	929	finally
    //   484	495	929	finally
    //   499	510	929	finally
    //   514	520	929	finally
    //   524	535	929	finally
    //   541	549	929	finally
    //   553	560	929	finally
    //   564	575	929	finally
    //   579	590	929	finally
    //   594	600	929	finally
    //   604	615	929	finally
    //   621	629	929	finally
    //   633	640	929	finally
    //   644	655	929	finally
    //   659	670	929	finally
    //   674	680	929	finally
    //   684	695	929	finally
    //   701	709	929	finally
    //   713	720	929	finally
    //   724	738	929	finally
    //   742	756	929	finally
    //   760	771	929	finally
    //   775	781	929	finally
    //   785	795	929	finally
    //   799	812	929	finally
    //   834	844	929	finally
    //   881	897	929	finally
    //   149	157	933	android/database/sqlite/SQLiteException
    //   181	195	933	android/database/sqlite/SQLiteException
    //   199	212	933	android/database/sqlite/SQLiteException
    //   216	229	933	android/database/sqlite/SQLiteException
    //   233	246	933	android/database/sqlite/SQLiteException
    //   250	263	933	android/database/sqlite/SQLiteException
    //   267	280	933	android/database/sqlite/SQLiteException
    //   284	297	933	android/database/sqlite/SQLiteException
    //   301	315	933	android/database/sqlite/SQLiteException
    //   319	333	933	android/database/sqlite/SQLiteException
    //   337	351	933	android/database/sqlite/SQLiteException
    //   355	369	933	android/database/sqlite/SQLiteException
    //   373	385	933	android/database/sqlite/SQLiteException
    //   394	400	933	android/database/sqlite/SQLiteException
    //   404	415	933	android/database/sqlite/SQLiteException
    //   419	430	933	android/database/sqlite/SQLiteException
    //   434	440	933	android/database/sqlite/SQLiteException
    //   444	455	933	android/database/sqlite/SQLiteException
    //   461	469	933	android/database/sqlite/SQLiteException
    //   473	480	933	android/database/sqlite/SQLiteException
    //   484	495	933	android/database/sqlite/SQLiteException
    //   499	510	933	android/database/sqlite/SQLiteException
    //   514	520	933	android/database/sqlite/SQLiteException
    //   524	535	933	android/database/sqlite/SQLiteException
    //   541	549	933	android/database/sqlite/SQLiteException
    //   553	560	933	android/database/sqlite/SQLiteException
    //   564	575	933	android/database/sqlite/SQLiteException
    //   579	590	933	android/database/sqlite/SQLiteException
    //   594	600	933	android/database/sqlite/SQLiteException
    //   604	615	933	android/database/sqlite/SQLiteException
    //   621	629	933	android/database/sqlite/SQLiteException
    //   633	640	933	android/database/sqlite/SQLiteException
    //   644	655	933	android/database/sqlite/SQLiteException
    //   659	670	933	android/database/sqlite/SQLiteException
    //   674	680	933	android/database/sqlite/SQLiteException
    //   684	695	933	android/database/sqlite/SQLiteException
    //   701	709	933	android/database/sqlite/SQLiteException
    //   713	720	933	android/database/sqlite/SQLiteException
    //   724	738	933	android/database/sqlite/SQLiteException
    //   742	756	933	android/database/sqlite/SQLiteException
    //   760	771	933	android/database/sqlite/SQLiteException
    //   775	781	933	android/database/sqlite/SQLiteException
    //   785	795	933	android/database/sqlite/SQLiteException
    //   799	812	933	android/database/sqlite/SQLiteException
    //   834	844	933	android/database/sqlite/SQLiteException
  }
  
  public final long zzeZ(String paramString)
  {
    zzx.zzcM(paramString);
    zzjk();
    zzjv();
    try
    {
      int i = getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[] { paramString, String.valueOf(Math.max(0, Math.min(1000000, zzCp().zzb(paramString, zzl.zzaWn)))) });
      return i;
    }
    catch (SQLiteException paramString)
    {
      zzAozzaWC.zzj("Error deleting over the limit events", paramString);
    }
    return 0L;
  }
  
  /* Error */
  public final byte[] zzfa(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   9: aload_0
    //   10: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   13: aload_0
    //   14: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc_w 618
    //   20: iconst_1
    //   21: anewarray 189	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 78
    //   28: aastore
    //   29: ldc_w 620
    //   32: iconst_1
    //   33: anewarray 189	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 418	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore 4
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: invokeinterface 421 1 0
    //   58: istore_2
    //   59: iload_2
    //   60: ifne +19 -> 79
    //   63: aload 4
    //   65: ifnull +10 -> 75
    //   68: aload 4
    //   70: invokeinterface 424 1 0
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: areturn
    //   79: aload 4
    //   81: astore_3
    //   82: aload 4
    //   84: iconst_0
    //   85: invokeinterface 428 2 0
    //   90: astore 5
    //   92: aload 4
    //   94: astore_3
    //   95: aload 4
    //   97: invokeinterface 533 1 0
    //   102: ifeq +19 -> 121
    //   105: aload 4
    //   107: astore_3
    //   108: aload_0
    //   109: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   112: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   115: ldc_w 1125
    //   118: invokevirtual 261	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   121: aload 5
    //   123: astore_1
    //   124: aload 4
    //   126: ifnull -49 -> 77
    //   129: aload 4
    //   131: invokeinterface 424 1 0
    //   136: aload 5
    //   138: areturn
    //   139: astore 5
    //   141: aconst_null
    //   142: astore 4
    //   144: aload 4
    //   146: astore_3
    //   147: aload_0
    //   148: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   151: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   154: ldc_w 1127
    //   157: aload_1
    //   158: aload 5
    //   160: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   163: aload 4
    //   165: ifnull +10 -> 175
    //   168: aload 4
    //   170: invokeinterface 424 1 0
    //   175: aconst_null
    //   176: areturn
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +9 -> 190
    //   184: aload_3
    //   185: invokeinterface 424 1 0
    //   190: aload_1
    //   191: athrow
    //   192: astore_1
    //   193: goto -13 -> 180
    //   196: astore 5
    //   198: goto -54 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	zze
    //   0	201	1	paramString	String
    //   58	2	2	bool	boolean
    //   50	135	3	localCursor1	Cursor
    //   46	123	4	localCursor2	Cursor
    //   90	47	5	arrayOfByte	byte[]
    //   139	20	5	localSQLiteException1	SQLiteException
    //   196	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   13	48	139	android/database/sqlite/SQLiteException
    //   13	48	177	finally
    //   51	59	192	finally
    //   82	92	192	finally
    //   95	105	192	finally
    //   108	121	192	finally
    //   147	163	192	finally
    //   51	59	196	android/database/sqlite/SQLiteException
    //   82	92	196	android/database/sqlite/SQLiteException
    //   95	105	196	android/database/sqlite/SQLiteException
    //   108	121	196	android/database/sqlite/SQLiteException
  }
  
  protected final void zziJ() {}
  
  /* Error */
  public final List<android.util.Pair<zzqb.zze, Long>> zzn(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: invokevirtual 143	com/google/android/gms/measurement/internal/zze:zzjk	()V
    //   7: aload_0
    //   8: invokevirtual 140	com/google/android/gms/measurement/internal/zze:zzjv	()V
    //   11: iload_2
    //   12: ifle +111 -> 123
    //   15: iconst_1
    //   16: istore 4
    //   18: iload 4
    //   20: invokestatic 1133	com/google/android/gms/common/internal/zzx:zzac	(Z)V
    //   23: iload_3
    //   24: ifle +105 -> 129
    //   27: iload 5
    //   29: istore 4
    //   31: iload 4
    //   33: invokestatic 1133	com/google/android/gms/common/internal/zzx:zzac	(Z)V
    //   36: aload_1
    //   37: invokestatic 149	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 242	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc_w 493
    //   48: iconst_2
    //   49: anewarray 189	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc_w 894
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: ldc -21
    //   62: aastore
    //   63: ldc_w 620
    //   66: iconst_1
    //   67: anewarray 189	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: aconst_null
    //   75: aconst_null
    //   76: ldc_w 894
    //   79: iload_2
    //   80: invokestatic 400	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   83: invokevirtual 899	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore 8
    //   88: aload 8
    //   90: invokeinterface 421 1 0
    //   95: ifne +40 -> 135
    //   98: invokestatic 1137	java/util/Collections:emptyList	()Ljava/util/List;
    //   101: astore 9
    //   103: aload 9
    //   105: astore_1
    //   106: aload 8
    //   108: ifnull +13 -> 121
    //   111: aload 8
    //   113: invokeinterface 424 1 0
    //   118: aload 9
    //   120: astore_1
    //   121: aload_1
    //   122: areturn
    //   123: iconst_0
    //   124: istore 4
    //   126: goto -108 -> 18
    //   129: iconst_0
    //   130: istore 4
    //   132: goto -101 -> 31
    //   135: new 589	java/util/ArrayList
    //   138: dup
    //   139: invokespecial 590	java/util/ArrayList:<init>	()V
    //   142: astore 9
    //   144: iconst_0
    //   145: istore_2
    //   146: aload 8
    //   148: iconst_0
    //   149: invokeinterface 338 2 0
    //   154: lstore 6
    //   156: aload 8
    //   158: iconst_1
    //   159: invokeinterface 428 2 0
    //   164: astore 10
    //   166: aload_0
    //   167: invokevirtual 664	com/google/android/gms/measurement/internal/zze:zzCk	()Lcom/google/android/gms/measurement/internal/zzaj;
    //   170: aload 10
    //   172: invokevirtual 1140	com/google/android/gms/measurement/internal/zzaj:zzp	([B)[B
    //   175: astore 10
    //   177: aload 9
    //   179: invokeinterface 1142 1 0
    //   184: ifne +12 -> 196
    //   187: aload 10
    //   189: arraylength
    //   190: iload_2
    //   191: iadd
    //   192: iload_3
    //   193: if_icmpgt +70 -> 263
    //   196: aload 10
    //   198: invokestatic 434	com/google/android/gms/internal/zzsm:zzD	([B)Lcom/google/android/gms/internal/zzsm;
    //   201: astore 11
    //   203: new 644	com/google/android/gms/internal/zzqb$zze
    //   206: dup
    //   207: invokespecial 904	com/google/android/gms/internal/zzqb$zze:<init>	()V
    //   210: astore 12
    //   212: aload 12
    //   214: aload 11
    //   216: invokevirtual 908	com/google/android/gms/internal/zzqb$zze:zzG	(Lcom/google/android/gms/internal/zzsm;)Lcom/google/android/gms/internal/zzqb$zze;
    //   219: pop
    //   220: aload 10
    //   222: arraylength
    //   223: iload_2
    //   224: iadd
    //   225: istore_2
    //   226: aload 9
    //   228: aload 12
    //   230: lload 6
    //   232: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   235: invokestatic 1148	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   238: invokeinterface 594 2 0
    //   243: pop
    //   244: aload 8
    //   246: invokeinterface 533 1 0
    //   251: istore 4
    //   253: iload 4
    //   255: ifeq +8 -> 263
    //   258: iload_2
    //   259: iload_3
    //   260: if_icmple +138 -> 398
    //   263: aload 9
    //   265: astore_1
    //   266: aload 8
    //   268: ifnull -147 -> 121
    //   271: aload 8
    //   273: invokeinterface 424 1 0
    //   278: aload 9
    //   280: areturn
    //   281: astore 10
    //   283: aload_0
    //   284: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   287: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   290: ldc_w 1150
    //   293: aload_1
    //   294: aload 10
    //   296: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   299: goto -55 -> 244
    //   302: astore 10
    //   304: aload_0
    //   305: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   308: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   311: ldc_w 1152
    //   314: aload_1
    //   315: aload 10
    //   317: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   320: goto -76 -> 244
    //   323: astore 9
    //   325: aconst_null
    //   326: astore 8
    //   328: aload_0
    //   329: invokevirtual 169	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   332: getfield 255	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   335: ldc_w 1154
    //   338: aload_1
    //   339: aload 9
    //   341: invokevirtual 198	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   344: invokestatic 1137	java/util/Collections:emptyList	()Ljava/util/List;
    //   347: astore 9
    //   349: aload 9
    //   351: astore_1
    //   352: aload 8
    //   354: ifnull -233 -> 121
    //   357: aload 8
    //   359: invokeinterface 424 1 0
    //   364: aload 9
    //   366: areturn
    //   367: astore_1
    //   368: aconst_null
    //   369: astore 8
    //   371: aload 8
    //   373: ifnull +10 -> 383
    //   376: aload 8
    //   378: invokeinterface 424 1 0
    //   383: aload_1
    //   384: athrow
    //   385: astore_1
    //   386: goto -15 -> 371
    //   389: astore_1
    //   390: goto -19 -> 371
    //   393: astore 9
    //   395: goto -67 -> 328
    //   398: goto -252 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	zze
    //   0	401	1	paramString	String
    //   0	401	2	paramInt1	int
    //   0	401	3	paramInt2	int
    //   16	238	4	bool1	boolean
    //   1	27	5	bool2	boolean
    //   154	77	6	l	long
    //   86	291	8	localCursor	Cursor
    //   101	178	9	localObject	Object
    //   323	17	9	localSQLiteException1	SQLiteException
    //   347	18	9	localList	List
    //   393	1	9	localSQLiteException2	SQLiteException
    //   164	57	10	arrayOfByte	byte[]
    //   281	14	10	localIOException1	IOException
    //   302	14	10	localIOException2	IOException
    //   201	14	11	localzzsm	com.google.android.gms.internal.zzsm
    //   210	19	12	localzze	zzqb.zze
    // Exception table:
    //   from	to	target	type
    //   156	177	281	java/io/IOException
    //   212	220	302	java/io/IOException
    //   41	88	323	android/database/sqlite/SQLiteException
    //   41	88	367	finally
    //   88	103	385	finally
    //   135	144	385	finally
    //   146	156	385	finally
    //   156	177	385	finally
    //   177	196	385	finally
    //   196	212	385	finally
    //   212	220	385	finally
    //   220	244	385	finally
    //   244	253	385	finally
    //   283	299	385	finally
    //   304	320	385	finally
    //   328	349	389	finally
    //   88	103	393	android/database/sqlite/SQLiteException
    //   135	144	393	android/database/sqlite/SQLiteException
    //   146	156	393	android/database/sqlite/SQLiteException
    //   156	177	393	android/database/sqlite/SQLiteException
    //   177	196	393	android/database/sqlite/SQLiteException
    //   196	212	393	android/database/sqlite/SQLiteException
    //   212	220	393	android/database/sqlite/SQLiteException
    //   220	244	393	android/database/sqlite/SQLiteException
    //   244	253	393	android/database/sqlite/SQLiteException
    //   283	299	393	android/database/sqlite/SQLiteException
    //   304	320	393	android/database/sqlite/SQLiteException
  }
  
  public final void zzz(List<Long> paramList)
  {
    zzx.zzz(paramList);
    zzjk();
    zzjv();
    StringBuilder localStringBuilder = new StringBuilder("rowid in (");
    int i = 0;
    while (i < paramList.size())
    {
      if (i != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(((Long)paramList.get(i)).longValue());
      i += 1;
    }
    localStringBuilder.append(")");
    i = getWritableDatabase().delete("raw_events", localStringBuilder.toString(), null);
    if (i != paramList.size()) {
      zzAozzaWC.zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(i), Integer.valueOf(paramList.size()));
    }
  }
  
  public static final class zza
  {
    long zzaVE;
    long zzaVF;
    long zzaVG;
  }
  
  static abstract interface zzb
  {
    public abstract boolean zza(long paramLong, zzqb.zzb paramzzb);
    
    public abstract void zzc(zzqb.zze paramzze);
  }
  
  private final class zzc
    extends SQLiteOpenHelper
  {
    zzc(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void zza(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
      throws SQLiteException
    {
      if (!zza(paramSQLiteDatabase, paramString1)) {
        paramSQLiteDatabase.execSQL(paramString2);
      }
      for (;;)
      {
        int i;
        try
        {
          paramString2 = zzb(paramSQLiteDatabase, paramString1);
          paramString3 = paramString3.split(",");
          int j = paramString3.length;
          i = 0;
          if (i >= j) {
            break;
          }
          Object localObject = paramString3[i];
          if (!paramString2.remove(localObject)) {
            throw new SQLiteException("Table " + paramString1 + " is missing required column: " + (String)localObject);
          }
        }
        catch (SQLiteException paramSQLiteDatabase)
        {
          zzAo().zzaWC.zzj("Failed to verify columns on table that was just created", paramString1);
          throw paramSQLiteDatabase;
        }
        i += 1;
      }
      if (paramMap != null)
      {
        paramString3 = paramMap.entrySet().iterator();
        while (paramString3.hasNext())
        {
          paramMap = (Map.Entry)paramString3.next();
          if (!paramString2.remove(paramMap.getKey())) {
            paramSQLiteDatabase.execSQL((String)paramMap.getValue());
          }
        }
      }
      if (!paramString2.isEmpty()) {
        throw new SQLiteException("Table " + paramString1 + " table has extra columns");
      }
    }
    
    /* Error */
    private boolean zza(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_1
      //   4: ldc 121
      //   6: iconst_1
      //   7: anewarray 38	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 123
      //   14: aastore
      //   15: ldc 125
      //   17: iconst_1
      //   18: anewarray 38	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_2
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 129	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_1
      //   32: aload_1
      //   33: astore 4
      //   35: aload 4
      //   37: astore_1
      //   38: aload 4
      //   40: invokeinterface 134 1 0
      //   45: istore_3
      //   46: aload 4
      //   48: ifnull +10 -> 58
      //   51: aload 4
      //   53: invokeinterface 138 1 0
      //   58: iload_3
      //   59: ireturn
      //   60: astore 5
      //   62: aconst_null
      //   63: astore 4
      //   65: aload 4
      //   67: astore_1
      //   68: aload_0
      //   69: getfield 13	com/google/android/gms/measurement/internal/zze$zzc:zzaVH	Lcom/google/android/gms/measurement/internal/zze;
      //   72: invokevirtual 69	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
      //   75: getfield 141	com/google/android/gms/measurement/internal/zzp:zzaWF	Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   78: ldc -113
      //   80: aload_2
      //   81: aload 5
      //   83: invokevirtual 147	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   86: aload 4
      //   88: ifnull +10 -> 98
      //   91: aload 4
      //   93: invokeinterface 138 1 0
      //   98: iconst_0
      //   99: ireturn
      //   100: astore_1
      //   101: aload 4
      //   103: astore_2
      //   104: aload_2
      //   105: ifnull +9 -> 114
      //   108: aload_2
      //   109: invokeinterface 138 1 0
      //   114: aload_1
      //   115: athrow
      //   116: astore 4
      //   118: aload_1
      //   119: astore_2
      //   120: aload 4
      //   122: astore_1
      //   123: goto -19 -> 104
      //   126: astore 5
      //   128: goto -63 -> 65
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	131	0	this	zzc
      //   0	131	1	paramSQLiteDatabase	SQLiteDatabase
      //   0	131	2	paramString	String
      //   45	14	3	bool	boolean
      //   1	101	4	localSQLiteDatabase	SQLiteDatabase
      //   116	5	4	localObject	Object
      //   60	22	5	localSQLiteException1	SQLiteException
      //   126	1	5	localSQLiteException2	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	60	android/database/sqlite/SQLiteException
      //   3	32	100	finally
      //   38	46	116	finally
      //   68	86	116	finally
      //   38	46	126	android/database/sqlite/SQLiteException
    }
    
    private static Set<String> zzb(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      HashSet localHashSet = new HashSet();
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM " + paramString + " LIMIT 0", null);
      try
      {
        Collections.addAll(localHashSet, paramSQLiteDatabase.getColumnNames());
        return localHashSet;
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
    }
    
    public final SQLiteDatabase getWritableDatabase()
    {
      int i = 1;
      Object localObject1 = zze.zza(zze.this);
      zzd.zzBN();
      if (zzCv == 0L) {}
      while (i == 0)
      {
        throw new SQLiteException("Database open failed");
        if (zzqW.elapsedRealtime() - zzCv < 3600000L) {
          i = 0;
        }
      }
      try
      {
        localObject1 = super.getWritableDatabase();
        return (SQLiteDatabase)localObject1;
      }
      catch (SQLiteException localSQLiteException1)
      {
        zze.zza(zze.this).start();
        zzAo().zzaWC.zzfg("Opening the database failed, dropping and recreating it");
        Object localObject2 = zze.zzb(zze.this);
        getContext().getDatabasePath((String)localObject2).delete();
        try
        {
          localObject2 = super.getWritableDatabase();
          zzazzCv = 0L;
          return (SQLiteDatabase)localObject2;
        }
        catch (SQLiteException localSQLiteException2)
        {
          zzAo().zzaWC.zzj("Failed to open freshly created database", localSQLiteException2);
          throw localSQLiteException2;
        }
      }
    }
    
    public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
        paramSQLiteDatabase.setReadable(false, false);
        paramSQLiteDatabase.setWritable(false, false);
        paramSQLiteDatabase.setReadable(true, true);
        paramSQLiteDatabase.setWritable(true, true);
      }
    }
    
    public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        zza(paramSQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
        zza(paramSQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
        zza(paramSQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.zzCx());
        zza(paramSQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
        zza(paramSQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        zza(paramSQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
        zza(paramSQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
        zza(paramSQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
        zza(paramSQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        return;
      }
      finally
      {
        localCursor.close();
      }
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */