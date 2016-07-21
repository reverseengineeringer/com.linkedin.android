package com.linkedin.messengerlib.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

abstract interface MessengerProvider$DatabaseOperation<T>
{
  public abstract T execute(SQLiteDatabase paramSQLiteDatabase)
    throws SQLiteException;
  
  public abstract T getDefaultValue();
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.database.MessengerProvider.DatabaseOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */