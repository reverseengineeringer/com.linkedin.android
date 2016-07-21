package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.Locale;

@zzhb
public final class zzh
{
  private static final String zzFV = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[] { "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time" });
  private static zzh zzFX;
  static final Object zzpV = new Object();
  private final zza zzFW;
  
  private zzh(Context paramContext)
  {
    zzFW = new zza(paramContext, "google_inapp_purchase.db");
  }
  
  public static zzh zzy(Context paramContext)
  {
    synchronized (zzpV)
    {
      if (zzFX == null) {
        zzFX = new zzh(paramContext);
      }
      paramContext = zzFX;
      return paramContext;
    }
  }
  
  public final int getRecordCount()
  {
    localObject4 = null;
    Object localObject1 = null;
    Object localObject5;
    synchronized (zzpV)
    {
      localObject5 = getWritableDatabase();
      if (localObject5 == null) {
        return 0;
      }
    }
    try
    {
      localObject5 = ((SQLiteDatabase)localObject5).rawQuery("select count(*) from InAppPurchase", null);
      localObject1 = localObject5;
      localObject4 = localObject5;
      if (((Cursor)localObject5).moveToFirst())
      {
        localObject1 = localObject5;
        localObject4 = localObject5;
        int i = ((Cursor)localObject5).getInt(0);
        if (localObject5 != null) {
          ((Cursor)localObject5).close();
        }
        return i;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        localObject4 = localObject2;
        zzin.zzaK("Error getting record count" + localSQLiteException.getMessage());
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
      }
    }
    finally
    {
      if (localObject4 == null) {
        break label160;
      }
      ((Cursor)localObject4).close();
    }
    return 0;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = zzFW.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzin.zzaK("Error opening writable conversion tracking database");
    }
    return null;
  }
  
  public final void zza(zzf paramzzf)
  {
    if (paramzzf == null) {
      return;
    }
    SQLiteDatabase localSQLiteDatabase;
    synchronized (zzpV)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null) {
        return;
      }
    }
    localSQLiteDatabase.delete("InAppPurchase", String.format(Locale.US, "%s = %d", new Object[] { "purchase_id", Long.valueOf(zzFP) }), null);
  }
  
  public final class zza
    extends SQLiteOpenHelper
  {
    public zza(Context paramContext, String paramString)
    {
      super(paramString, null, 4);
    }
    
    public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL(zzh.zzFV);
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      zzin.zzaJ("Database updated from version " + paramInt1 + " to version " + paramInt2);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
      onCreate(paramSQLiteDatabase);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */