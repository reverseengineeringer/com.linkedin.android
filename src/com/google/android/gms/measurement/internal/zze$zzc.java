package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.internal.zzmq;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zze$zzc
  extends SQLiteOpenHelper
{
  zze$zzc(zze paramzze, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
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
        zzaVH.zzAo().zzaWC.zzj("Failed to verify columns on table that was just created", paramString1);
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
    Object localObject1 = zze.zza(zzaVH);
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
      zze.zza(zzaVH).start();
      zzaVH.zzAo().zzaWC.zzfg("Opening the database failed, dropping and recreating it");
      Object localObject2 = zze.zzb(zzaVH);
      zzaVH.getContext().getDatabasePath((String)localObject2).delete();
      try
      {
        localObject2 = super.getWritableDatabase();
        zzazzaVH).zzCv = 0L;
        return (SQLiteDatabase)localObject2;
      }
      catch (SQLiteException localSQLiteException2)
      {
        zzaVH.zzAo().zzaWC.zzj("Failed to open freshly created database", localSQLiteException2);
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

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zze.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */