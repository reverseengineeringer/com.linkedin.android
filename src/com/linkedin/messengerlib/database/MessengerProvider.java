package com.linkedin.messengerlib.database;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.linkedin.messengerlib.crashes.MessengerCrashReporter;
import com.linkedin.messengerlib.shared.MessengerLibInit;
import java.util.ArrayList;
import java.util.Iterator;

public class MessengerProvider
  extends ContentProvider
{
  public static final Uri ACTORS_FOR_CONVERSATIONS_VIEW_URI;
  public static final Uri ACTORS_URI;
  public static final Uri ATTACHMENTS_URI;
  public static final String AUTHORITY = MessengerLibInit.hostApplicationId + ".messenger.provider";
  public static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);
  public static final Uri CONVERSATIONS_TO_ACTORS_URI;
  public static final Uri CONVERSATIONS_TO_SEARCH_URI;
  public static final Uri CONVERSATIONS_UI_URI;
  public static final Uri CONVERSATIONS_URI;
  public static final Uri CONVERSATIONS_VIEW_URI;
  public static final Uri EVENTS_URI;
  public static final Uri EVENTS_VIEW_URI;
  public static final Uri EVENT_CUSTOM_CONTENT_CONVERSATION_NAME_UPDATE_URI;
  public static final Uri EVENT_CUSTOM_CONTENT_GROUPS_URI;
  public static final Uri EVENT_CUSTOM_CONTENT_INMAILS_URI;
  public static final Uri EVENT_CUSTOM_CONTENT_INMAIL_INSIGHTS_URI;
  public static final Uri MESSAGE_EVENTS_URI;
  public static final Uri MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_LEADGEN_URI;
  public static final Uri MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_STANDARD_URI;
  public static final Uri MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_URI;
  public static final Uri MESSAGE_EVENT_SHARE_CONTENT_URI;
  public static final Uri PARTICIPANT_CHANGE_ACTORS_VIEW_URI;
  public static final Uri PARTICIPANT_CHANGE_EVENT_TO_ACTORS_URI;
  public static final Uri RECENT_STICKERS_URI;
  public static final Uri RECENT_STICKERS_VIEW_URI;
  public static final Uri SEARCH_URI;
  public static final Uri SEARCH_VIEW_URI;
  public static final Uri STICKERS_URI;
  public static final Uri STICKER_EVENTS_URI;
  public static final Uri STICKER_PACKS_URI;
  public static final Uri TRANSACTION_BEGIN_NON_EXCLUSIVE_URI = Uri.parse(BASE_URI + "/transaction_begin_non_exclusive");
  public static final Uri TRANSACTION_BEGIN_URI = Uri.parse(BASE_URI + "/transaction_begin");
  public static final Uri TRANSACTION_END_URI = Uri.parse(BASE_URI + "/transaction_end");
  public static final Uri TRANSACTION_SUCCESS_URI = Uri.parse(BASE_URI + "/transaction_success");
  private static MessengerDatabaseHelper databaseHelper;
  private static boolean isInMemory;
  private static final UriMatcher sUriMatcher;
  private Context context;
  
  static
  {
    CONVERSATIONS_URI = Uri.parse(BASE_URI + "/conversations");
    ACTORS_URI = Uri.parse(BASE_URI + "/actors");
    CONVERSATIONS_TO_ACTORS_URI = Uri.parse(BASE_URI + "/conversations_to_actors");
    EVENTS_URI = Uri.parse(BASE_URI + "/events");
    MESSAGE_EVENTS_URI = Uri.parse(BASE_URI + "/message_events");
    MESSAGE_EVENT_SHARE_CONTENT_URI = Uri.parse(BASE_URI + "/message_event_share_content");
    EVENT_CUSTOM_CONTENT_INMAILS_URI = Uri.parse(BASE_URI + "/event_custom_content_inmails");
    EVENT_CUSTOM_CONTENT_INMAIL_INSIGHTS_URI = Uri.parse(BASE_URI + "/event_custom_content_inmail_insights");
    EVENT_CUSTOM_CONTENT_GROUPS_URI = Uri.parse(BASE_URI + "/event_custom_content_groups");
    EVENT_CUSTOM_CONTENT_CONVERSATION_NAME_UPDATE_URI = Uri.parse(BASE_URI + "/event_custom_content_conversation_name_update");
    PARTICIPANT_CHANGE_EVENT_TO_ACTORS_URI = Uri.parse(BASE_URI + "/participant_change_event_to_actors");
    MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_URI = Uri.parse(BASE_URI + "/message_event_custom_content_sponsored_inmails");
    MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_STANDARD_URI = Uri.parse(BASE_URI + "/message_event_custom_content_sponsored_inmails_standard");
    MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_LEADGEN_URI = Uri.parse(BASE_URI + "/message_event_custom_content_sponsored_inmails_leadgen");
    ATTACHMENTS_URI = Uri.parse(BASE_URI + "/attachments");
    CONVERSATIONS_UI_URI = Uri.parse(BASE_URI + "/conversations_ui");
    CONVERSATIONS_VIEW_URI = Uri.parse(BASE_URI + "/conversations_view");
    ACTORS_FOR_CONVERSATIONS_VIEW_URI = Uri.parse(BASE_URI + "/actors_for_conversations_view");
    PARTICIPANT_CHANGE_ACTORS_VIEW_URI = Uri.parse(BASE_URI + "/participant_change_actors_view");
    EVENTS_VIEW_URI = Uri.parse(BASE_URI + "/events_view");
    STICKER_PACKS_URI = Uri.parse(BASE_URI + "/sticker_packs");
    STICKERS_URI = Uri.parse(BASE_URI + "/stickers");
    RECENT_STICKERS_URI = Uri.parse(BASE_URI + "/recent_stickers");
    RECENT_STICKERS_VIEW_URI = Uri.parse(BASE_URI + "/recent_stickers_view");
    STICKER_EVENTS_URI = Uri.parse(BASE_URI + "/sticker_events");
    SEARCH_URI = Uri.parse(BASE_URI + "/search");
    CONVERSATIONS_TO_SEARCH_URI = Uri.parse(BASE_URI + "/conversations_to_search");
    SEARCH_VIEW_URI = Uri.parse(BASE_URI + "/search_view");
    UriMatcher localUriMatcher = new UriMatcher(-1);
    sUriMatcher = localUriMatcher;
    localUriMatcher.addURI(AUTHORITY, "transaction_begin_non_exclusive", 4);
    sUriMatcher.addURI(AUTHORITY, "transaction_begin", 1);
    sUriMatcher.addURI(AUTHORITY, "transaction_end", 2);
    sUriMatcher.addURI(AUTHORITY, "transaction_success", 3);
    sUriMatcher.addURI(AUTHORITY, "conversations", 1000);
    sUriMatcher.addURI(AUTHORITY, "conversations/#", 1001);
    sUriMatcher.addURI(AUTHORITY, "actors", 2000);
    sUriMatcher.addURI(AUTHORITY, "actors/#", 2001);
    sUriMatcher.addURI(AUTHORITY, "events", 3000);
    sUriMatcher.addURI(AUTHORITY, "events/#", 3001);
    sUriMatcher.addURI(AUTHORITY, "message_events", 3002);
    sUriMatcher.addURI(AUTHORITY, "event_custom_content_inmails", 3007);
    sUriMatcher.addURI(AUTHORITY, "event_custom_content_groups", 3003);
    sUriMatcher.addURI(AUTHORITY, "message_event_share_content", 3008);
    sUriMatcher.addURI(AUTHORITY, "message_event_custom_content_sponsored_inmails", 3004);
    sUriMatcher.addURI(AUTHORITY, "message_event_custom_content_sponsored_inmails_standard", 3005);
    sUriMatcher.addURI(AUTHORITY, "message_event_custom_content_sponsored_inmails_leadgen", 3006);
    sUriMatcher.addURI(AUTHORITY, "event_custom_content_conversation_name_update", 3009);
    sUriMatcher.addURI(AUTHORITY, "event_custom_content_inmail_insights", 3010);
    sUriMatcher.addURI(AUTHORITY, "attachments", 4000);
    sUriMatcher.addURI(AUTHORITY, "attachments/#", 4001);
    sUriMatcher.addURI(AUTHORITY, "conversations_to_actors", 5000);
    sUriMatcher.addURI(AUTHORITY, "conversations_to_actors/#", 5001);
    sUriMatcher.addURI(AUTHORITY, "conversations_ui", 6000);
    sUriMatcher.addURI(AUTHORITY, "conversations_ui/#", 6001);
    sUriMatcher.addURI(AUTHORITY, "conversations_view", 7000);
    sUriMatcher.addURI(AUTHORITY, "actors_for_conversations_view", 8000);
    sUriMatcher.addURI(AUTHORITY, "events_view", 9000);
    sUriMatcher.addURI(AUTHORITY, "participant_change_event_to_actors", 10000);
    sUriMatcher.addURI(AUTHORITY, "participant_change_actors_view", 10001);
    sUriMatcher.addURI(AUTHORITY, "sticker_packs", 11000);
    sUriMatcher.addURI(AUTHORITY, "sticker_packs/#", 11001);
    sUriMatcher.addURI(AUTHORITY, "stickers", 12000);
    sUriMatcher.addURI(AUTHORITY, "stickers/#", 12001);
    sUriMatcher.addURI(AUTHORITY, "recent_stickers", 12002);
    sUriMatcher.addURI(AUTHORITY, "recent_stickers_view", 13000);
    sUriMatcher.addURI(AUTHORITY, "sticker_events", 14000);
    sUriMatcher.addURI(AUTHORITY, "search", 15000);
    sUriMatcher.addURI(AUTHORITY, "search/#", 15001);
    sUriMatcher.addURI(AUTHORITY, "conversations_to_search", 15002);
    sUriMatcher.addURI(AUTHORITY, "conversations_to_search/#", 15003);
    sUriMatcher.addURI(AUTHORITY, "search_view", 15004);
  }
  
  public static boolean clearDatabase()
  {
    if (databaseHelper == null) {
      return false;
    }
    return databaseHelper.recreateDatabase();
  }
  
  private void createDatabaseHelper()
  {
    databaseHelper = new MessengerDatabaseHelper(context, isInMemory);
  }
  
  private void ensureDatabaseHelperExists()
  {
    if (databaseHelper == null) {
      createDatabaseHelper();
    }
  }
  
  private <T> T executeDatabaseOperation(DatabaseOperation<T> paramDatabaseOperation, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = getWritableDatabase(); localObject == null; localObject = getReadableDatabase())
    {
      Log.e("MessengerProvider", "single operation: db is null");
      MessengerCrashReporter.getCrashReporter().reportNonFatal(new Exception("single operation: db is null"));
      return (T)paramDatabaseOperation.getDefaultValue();
    }
    if (!((SQLiteDatabase)localObject).isOpen())
    {
      Log.e("MessengerProvider", "single operation: db is closed");
      MessengerCrashReporter.getCrashReporter().reportNonFatal(new Exception("single operation: db is closed"));
      return (T)paramDatabaseOperation.getDefaultValue();
    }
    try
    {
      localObject = paramDatabaseOperation.execute((SQLiteDatabase)localObject);
      return (T)localObject;
    }
    catch (SQLiteCantOpenDatabaseException localSQLiteCantOpenDatabaseException)
    {
      MessengerCrashReporter.getCrashReporter().reportNonFatal(localSQLiteCantOpenDatabaseException);
      Log.e("MessengerProvider", "Cannot open database. Recreating it once more to try again: " + localSQLiteCantOpenDatabaseException.getMessage());
      createDatabaseHelper();
      if (paramBoolean) {}
      for (SQLiteDatabase localSQLiteDatabase = getWritableDatabase(); localSQLiteDatabase == null; localSQLiteDatabase = getReadableDatabase())
      {
        Log.e("MessengerProvider", "single operation: db is null");
        MessengerCrashReporter.getCrashReporter().reportNonFatal(new Exception("single operation: db is null"));
        return (T)paramDatabaseOperation.getDefaultValue();
      }
      if (!localSQLiteDatabase.isOpen())
      {
        Log.e("MessengerProvider", "single operation: db is closed");
        MessengerCrashReporter.getCrashReporter().reportNonFatal(new Exception("single operation: db is closed"));
        return (T)paramDatabaseOperation.getDefaultValue();
      }
      return (T)paramDatabaseOperation.execute(localSQLiteDatabase);
    }
    catch (SQLiteFullException localSQLiteFullException)
    {
      MessengerCrashReporter.getCrashReporter().reportNonFatal(localSQLiteFullException);
      Log.e("MessengerProvider", "Cannot open write to the database because it is out of disk space.");
      return (T)paramDatabaseOperation.getDefaultValue();
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        MessengerCrashReporter.getCrashReporter().reportNonFatal(localSQLiteException);
      }
    }
  }
  
  private SQLiteDatabase getReadableDatabase()
  {
    ensureDatabaseHelperExists();
    try
    {
      SQLiteDatabase localSQLiteDatabase = databaseHelper.getReadableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteCantOpenDatabaseException localSQLiteCantOpenDatabaseException)
    {
      Log.e("MessengerProvider", "Cannot open database. Recreating it once more to try again: " + localSQLiteCantOpenDatabaseException.getMessage());
      createDatabaseHelper();
    }
    return databaseHelper.getReadableDatabase();
  }
  
  private SQLiteDatabase getWritableDatabase()
  {
    ensureDatabaseHelperExists();
    try
    {
      SQLiteDatabase localSQLiteDatabase = databaseHelper.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteCantOpenDatabaseException localSQLiteCantOpenDatabaseException)
    {
      Log.e("MessengerProvider", "Cannot open database. Recreating it once more to try again: " + localSQLiteCantOpenDatabaseException.getMessage());
      createDatabaseHelper();
    }
    return databaseHelper.getWritableDatabase();
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int j = 0;
    String str;
    switch (sUriMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Query: Unknown Uri: " + paramUri);
    case 1000: 
      str = "conversations";
    }
    SQLiteDatabase localSQLiteDatabase;
    for (;;)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase != null) {
        break;
      }
      Log.e("MessengerProvider", "bulkInsert: db is null");
      return j;
      str = "actors";
      continue;
      str = "conversations_to_actors";
      continue;
      str = "conversations_ui";
      continue;
      str = "events";
      continue;
      str = "message_events";
      continue;
      str = "event_custom_content_inmails";
      continue;
      str = "event_custom_content_groups";
      continue;
      str = "message_event_share_content";
      continue;
      str = "message_event_custom_content_sponsored_inmails";
      continue;
      str = "message_event_custom_content_sponsored_inmails_standard";
      continue;
      str = "message_event_custom_content_sponsored_inmails_leadgen";
      continue;
      str = "event_custom_content_conversation_name_update";
      continue;
      str = "event_custom_content_inmail_insights";
      continue;
      str = "participant_change_event_to_actors";
      continue;
      str = "attachments";
      continue;
      str = "sticker_packs";
      continue;
      str = "stickers";
      continue;
      str = "recent_stickers";
      continue;
      str = "recent_stickers_view";
      continue;
      str = "sticker_events";
      continue;
      str = "search";
      continue;
      str = "conversations_to_search";
      continue;
      str = "search_view";
    }
    if (!localSQLiteDatabase.isOpen())
    {
      Log.e("MessengerProvider", "bulkInsert: db is closed");
      return 0;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    localSQLiteDatabase.beginTransaction();
    j = 0;
    while (j < paramArrayOfContentValues.length)
    {
      long l = localSQLiteDatabase.insertWithOnConflict(str, null, paramArrayOfContentValues[j], 5);
      int k = i;
      if (l != -1L)
      {
        k = i + 1;
        localArrayList.add(paramUri.buildUpon().appendPath(String.valueOf(l)).build());
      }
      j += 1;
      i = k;
    }
    localSQLiteDatabase.endTransaction();
    paramUri = localArrayList.iterator();
    for (;;)
    {
      j = i;
      if (!paramUri.hasNext()) {
        break;
      }
      paramArrayOfContentValues = (Uri)paramUri.next();
      getContext().getContentResolver().notifyChange(paramArrayOfContentValues, null);
    }
  }
  
  public int delete(Uri paramUri, final String paramString, final String[] paramArrayOfString)
  {
    final String str;
    switch (sUriMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown URI for delete: " + paramUri);
    case 1000: 
      str = "conversations";
    }
    for (;;)
    {
      int i = ((Integer)executeDatabaseOperation(new DatabaseOperation() {}, true)).intValue();
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      str = "actors";
      continue;
      str = "conversations_to_actors";
      continue;
      str = "conversations_ui";
      continue;
      str = "events";
      continue;
      str = "message_events";
      continue;
      str = "event_custom_content_inmails";
      continue;
      str = "event_custom_content_groups";
      continue;
      str = "message_event_share_content";
      continue;
      str = "message_event_custom_content_sponsored_inmails";
      continue;
      str = "message_event_custom_content_sponsored_inmails_standard";
      continue;
      str = "message_event_custom_content_sponsored_inmails_leadgen";
      continue;
      str = "event_custom_content_conversation_name_update";
      continue;
      str = "event_custom_content_inmail_insights";
      continue;
      str = "attachments";
      continue;
      str = "sticker_packs";
      continue;
      str = "stickers";
      continue;
      str = "recent_stickers";
      continue;
      str = "recent_stickers_view";
      continue;
      str = "sticker_events";
      continue;
      str = "search";
      continue;
      str = "conversations_to_search";
      continue;
      str = "search_view";
      continue;
      str = "participant_change_event_to_actors";
    }
  }
  
  public String getType(Uri paramUri)
  {
    switch (sUriMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1000: 
      return "vnd.android.cursor.dir/conversations";
    case 2000: 
      return "vnd.android.cursor.dir/actors";
    case 5000: 
      return "vnd.android.cursor.dir/conversations_to_actors";
    case 6000: 
      return "vnd.android.cursor.dir/conversations_ui";
    case 3000: 
      return "vnd.android.cursor.dir/events";
    case 9000: 
      return "vnd.android.cursor.dir/events_view";
    case 3002: 
      return "vnd.android.cursor.dir/message_events";
    case 3007: 
      return "vnd.android.cursor.dir/event_custom_content_inmails";
    case 3003: 
      return "vnd.android.cursor.dir/event_custom_content_groups";
    case 3008: 
      return "vnd.android.cursor.dir/message_event_share_content";
    case 3004: 
      return "vnd.android.cursor.dir/message_event_custom_content_sponsored_inmails";
    case 3005: 
      return "vnd.android.cursor.dir/message_event_custom_content_sponsored_inmails_standard";
    case 3006: 
      return "vnd.android.cursor.dir/message_event_custom_content_sponsored_inmails_leadgen";
    case 3009: 
      return "vnd.android.cursor.dir/event_custom_content_conversation_name_update";
    case 3010: 
      return "vnd.android.cursor.dir/event_custom_content_inmail_insights";
    case 4000: 
      return "vnd.android.cursor.dir/attachments";
    case 7000: 
      return "vnd.android.cursor.dir/conversations_view";
    case 10000: 
      return "vnd.android.cursor.dir/participant_change_event_to_actors";
    case 11000: 
      return "vnd.android.cursor.dir/sticker_packs";
    case 12000: 
      return "vnd.android.cursor.dir/stickers";
    case 12002: 
      return "vnd.android.cursor.dir/recent_stickers";
    case 13000: 
      return "vnd.android.cursor.dir/recent_stickers_view";
    case 14000: 
      return "vnd.android.cursor.dir/sticker_events";
    case 15000: 
      return "vnd.android.cursor.dir/search";
    case 15002: 
      return "vnd.android.cursor.dir/conversations_to_search";
    }
    return "vnd.android.cursor.dir/search_view";
  }
  
  public Uri insert(Uri paramUri, final ContentValues paramContentValues)
  {
    final String str;
    switch (sUriMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown URI for insert: " + paramUri);
    case 1000: 
      str = "conversations";
    case 2000: 
    case 5000: 
    case 6000: 
    case 10000: 
    case 3000: 
    case 3002: 
    case 3003: 
    case 3008: 
    case 3007: 
    case 3004: 
    case 3005: 
    case 3006: 
    case 3009: 
    case 3010: 
    case 4000: 
    case 11000: 
    case 12000: 
    case 12002: 
    case 13000: 
    case 14000: 
    case 15000: 
    case 15002: 
    case 15004: 
      for (;;)
      {
        long l = ((Long)executeDatabaseOperation(new DatabaseOperation() {}, true)).longValue();
        if (l == -1L) {
          break;
        }
        paramUri = paramUri.buildUpon().appendPath(String.valueOf(l)).build();
        getContext().getContentResolver().notifyChange(paramUri, null);
        return paramUri;
        str = "actors";
        continue;
        str = "conversations_to_actors";
        continue;
        str = "conversations_ui";
        continue;
        str = "participant_change_event_to_actors";
        continue;
        str = "events";
        continue;
        str = "message_events";
        continue;
        str = "event_custom_content_groups";
        continue;
        str = "message_event_share_content";
        continue;
        str = "event_custom_content_inmails";
        continue;
        str = "message_event_custom_content_sponsored_inmails";
        continue;
        str = "message_event_custom_content_sponsored_inmails_standard";
        continue;
        str = "message_event_custom_content_sponsored_inmails_leadgen";
        continue;
        str = "event_custom_content_conversation_name_update";
        continue;
        str = "event_custom_content_inmail_insights";
        continue;
        str = "attachments";
        continue;
        str = "sticker_packs";
        continue;
        str = "stickers";
        continue;
        str = "recent_stickers";
        continue;
        str = "recent_stickers_view";
        continue;
        str = "sticker_events";
        continue;
        str = "search";
        continue;
        str = "conversations_to_search";
        continue;
        str = "search_view";
      }
    case 4: 
      executeDatabaseOperation(new DatabaseOperation() {}, true);
      return null;
    case 1: 
      executeDatabaseOperation(new DatabaseOperation() {}, true);
      return null;
    case 2: 
      if (((Boolean)executeDatabaseOperation(new DatabaseOperation() {}, true)).booleanValue()) {
        executeDatabaseOperation(new DatabaseOperation() {}, true);
      }
      return null;
    }
    executeDatabaseOperation(new DatabaseOperation() {}, true);
    return null;
    return null;
  }
  
  public boolean onCreate()
  {
    context = getContext();
    isInMemory = false;
    databaseHelper = null;
    createDatabaseHelper();
    return true;
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, final String paramString1, final String[] paramArrayOfString2, final String paramString2)
  {
    switch (sUriMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Query: Unknown Uri: " + paramUri);
    case 1000: 
      paramUri = "conversations";
    }
    for (;;)
    {
      (Cursor)executeDatabaseOperation(new DatabaseOperation() {}, false);
      paramUri = "actors";
      continue;
      paramUri = "conversations_to_actors";
      continue;
      paramUri = "conversations_ui";
      continue;
      paramUri = "participant_change_event_to_actors";
      continue;
      paramUri = "events";
      continue;
      paramUri = "events_view";
      continue;
      paramUri = "message_events";
      continue;
      paramUri = "event_custom_content_groups";
      continue;
      paramUri = "message_event_share_content";
      continue;
      paramUri = "event_custom_content_inmails";
      continue;
      paramUri = "message_event_custom_content_sponsored_inmails";
      continue;
      paramUri = "message_event_custom_content_sponsored_inmails_standard";
      continue;
      paramUri = "message_event_custom_content_sponsored_inmails_leadgen";
      continue;
      paramUri = "attachments";
      continue;
      paramUri = "conversations_view";
      continue;
      paramUri = "actors_for_conversations_view";
      continue;
      paramUri = "participant_change_actors_view";
      continue;
      paramUri = "sticker_packs";
      continue;
      paramUri = "stickers";
      continue;
      paramUri = "recent_stickers";
      continue;
      paramUri = "recent_stickers_view";
      continue;
      paramUri = "sticker_events";
      continue;
      paramUri = "search";
      continue;
      paramUri = "conversations_to_search";
      continue;
      paramUri = "search_view";
      continue;
      paramUri = "event_custom_content_conversation_name_update";
      continue;
      paramUri = "event_custom_content_inmail_insights";
    }
  }
  
  public int update(Uri paramUri, final ContentValues paramContentValues, final String paramString, final String[] paramArrayOfString)
  {
    final String str;
    switch (sUriMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown URI for insert: " + paramUri);
    case 1000: 
      str = "conversations";
    }
    for (;;)
    {
      int i = ((Integer)executeDatabaseOperation(new DatabaseOperation() {}, true)).intValue();
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      str = "actors";
      continue;
      str = "conversations_to_actors";
      continue;
      str = "conversations_ui";
      continue;
      str = "events";
      continue;
      str = "message_events";
      continue;
      str = "event_custom_content_groups";
      continue;
      str = "message_event_share_content";
      continue;
      str = "event_custom_content_inmails";
      continue;
      str = "message_event_custom_content_sponsored_inmails";
      continue;
      str = "message_event_custom_content_sponsored_inmails_standard";
      continue;
      str = "message_event_custom_content_sponsored_inmails_leadgen";
      continue;
      str = "event_custom_content_conversation_name_update";
      continue;
      str = "event_custom_content_inmail_insights";
      continue;
      str = "participant_change_event_to_actors";
      continue;
      str = "attachments";
      continue;
      str = "sticker_packs";
      continue;
      str = "stickers";
      continue;
      str = "recent_stickers";
      continue;
      str = "recent_stickers_view";
      continue;
      str = "sticker_events";
      continue;
      str = "search";
      continue;
      str = "conversations_to_search";
      continue;
      str = "search_view";
    }
  }
  
  private static abstract interface DatabaseOperation<T>
  {
    public abstract T execute(SQLiteDatabase paramSQLiteDatabase)
      throws SQLiteException;
    
    public abstract T getDefaultValue();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.database.MessengerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */