package com.linkedin.messengerlib.consumers;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import com.linkedin.messengerlib.crashes.MessengerCrashReporter;
import com.linkedin.messengerlib.database.MessengerProvider;

public class BaseDataManager
{
  private static final String TAG = BaseDataManager.class.getCanonicalName();
  protected final Context appContext;
  protected final DataManager dataManager;
  
  public BaseDataManager(Context paramContext, DataManager paramDataManager)
  {
    appContext = paramContext;
    dataManager = paramDataManager;
  }
  
  protected static boolean getBoolean(Cursor paramCursor, String paramString)
  {
    return getInt(paramCursor, paramString) != 0;
  }
  
  protected static int getInt(Cursor paramCursor, String paramString)
  {
    return paramCursor.getInt(paramCursor.getColumnIndex(paramString));
  }
  
  protected static long getLong(Cursor paramCursor, String paramString)
  {
    return paramCursor.getLong(paramCursor.getColumnIndex(paramString));
  }
  
  protected static String getString(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndex(paramString));
  }
  
  protected final void beginTransactionNonExclusive()
  {
    try
    {
      appContext.getContentResolver().insert(MessengerProvider.TRANSACTION_BEGIN_NON_EXCLUSIVE_URI, null);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.e(TAG, "We failed to begin transaction");
      MessengerCrashReporter.getCrashReporter().reportNonFatal(new Throwable("We failed to begin transaction", localIllegalArgumentException));
    }
  }
  
  protected final void endTransaction()
  {
    try
    {
      appContext.getContentResolver().insert(MessengerProvider.TRANSACTION_END_URI, null);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.e(TAG, "We failed to end transaction");
      MessengerCrashReporter.getCrashReporter().reportNonFatal(new Throwable("We failed to end transaction", localIllegalArgumentException));
    }
  }
  
  protected final int safeDelete(Uri paramUri, String[] paramArrayOfString, String paramString)
  {
    try
    {
      int i = appContext.getContentResolver().delete(paramUri, paramString, paramArrayOfString);
      return i;
    }
    catch (SQLiteException paramArrayOfString)
    {
      Log.e(TAG, "We failed to delete: " + paramUri);
      MessengerCrashReporter.getCrashReporter().reportNonFatal(new Throwable("We failed to delete: " + paramUri, paramArrayOfString));
      return 0;
    }
    catch (IllegalArgumentException paramArrayOfString)
    {
      for (;;) {}
    }
  }
  
  protected final long safeInsert(ContentValues paramContentValues, Uri paramUri)
  {
    Object localObject = null;
    try
    {
      paramContentValues = appContext.getContentResolver().insert(paramUri, paramContentValues);
      if (paramContentValues == null) {
        return -1L;
      }
    }
    catch (SQLiteException paramContentValues)
    {
      for (;;)
      {
        Log.e(TAG, "We failed to insert: " + paramUri);
        MessengerCrashReporter.getCrashReporter().reportNonFatal(new Throwable("We failed to insert: " + paramUri, paramContentValues));
        paramContentValues = (ContentValues)localObject;
      }
      return Long.parseLong(paramContentValues.getLastPathSegment());
    }
    catch (IllegalArgumentException paramContentValues)
    {
      for (;;) {}
    }
  }
  
  protected final long safeInsertOrUpdate(ContentValues paramContentValues, Uri paramUri, String paramString)
  {
    return safeInsertOrUpdate(paramContentValues, paramUri, paramString, "remote_id");
  }
  
  protected final long safeInsertOrUpdate(ContentValues paramContentValues, Uri paramUri, String paramString1, String paramString2)
  {
    paramString2 = paramString2 + "=?";
    return safeInsertOrUpdate(paramContentValues, paramUri, new String[] { paramString1 }, paramString2);
  }
  
  protected final long safeInsertOrUpdate(ContentValues paramContentValues, Uri paramUri, String[] paramArrayOfString, String paramString)
  {
    long l2 = safeUpdate(paramContentValues, paramUri, paramArrayOfString, paramString);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = safeInsert(paramContentValues, paramUri);
    }
    return l1;
  }
  
  protected final long safeUpdate(ContentValues paramContentValues, Uri paramUri, String[] paramArrayOfString, String paramString)
  {
    Object localObject = null;
    try
    {
      paramArrayOfString = appContext.getContentResolver().query(paramUri, new String[] { "_id" }, paramString, paramArrayOfString, null);
      if (paramArrayOfString == null) {}
    }
    catch (SQLiteException paramArrayOfString)
    {
      try
      {
        for (;;)
        {
          boolean bool = paramArrayOfString.moveToFirst();
          if (bool) {
            break;
          }
          if (paramArrayOfString != null) {
            paramArrayOfString.close();
          }
          l1 = -1L;
          return l1;
          paramArrayOfString = paramArrayOfString;
          Log.e(TAG, "We failed to query: " + paramUri);
          MessengerCrashReporter.getCrashReporter().reportNonFatal(new Throwable("We failed to query: " + paramUri, paramArrayOfString));
          paramArrayOfString = (String[])localObject;
        }
        long l2 = paramArrayOfString.getLong(paramArrayOfString.getColumnIndex("_id"));
        appContext.getContentResolver().update(paramUri, paramContentValues, "_id=?", new String[] { String.valueOf(l2) });
        long l1 = l2;
        return l2;
      }
      finally
      {
        if (paramArrayOfString != null) {
          paramArrayOfString.close();
        }
      }
    }
    catch (IllegalArgumentException paramArrayOfString)
    {
      for (;;) {}
    }
  }
  
  protected final void setTransactionSuccessful()
  {
    try
    {
      appContext.getContentResolver().insert(MessengerProvider.TRANSACTION_SUCCESS_URI, null);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.e(TAG, "We failed to set transaction successful");
      MessengerCrashReporter.getCrashReporter().reportNonFatal(new Throwable("We failed to set transaction successful", localIllegalArgumentException));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.consumers.BaseDataManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */