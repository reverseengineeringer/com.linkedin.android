package com.linkedin.messengerlib.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.linkedin.messengerlib.crashes.MessengerCrashReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class MessengerDatabaseHelper
  extends SQLiteOpenHelper
{
  private static final Boolean MOCK_DATA = Boolean.valueOf(false);
  private final Context context;
  private SQLiteDatabase database;
  private boolean isInMemory;
  
  public MessengerDatabaseHelper(Context paramContext, boolean paramBoolean) {}
  
  private static void DropAllTables(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramSQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE type='table'", null);
    ((Cursor)localObject2).moveToFirst();
    while (!((Cursor)localObject2).isAfterLast())
    {
      String str = ((Cursor)localObject2).getString(1);
      if ((!str.equals("android_metadata")) && (!str.equals("sqlite_sequence"))) {
        ((List)localObject1).add(str);
      }
      ((Cursor)localObject2).moveToNext();
    }
    ((Cursor)localObject2).close();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + (String)localObject2);
    }
  }
  
  private static void DropAllViews(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramSQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE type='view'", null);
    ((Cursor)localObject2).moveToFirst();
    while (!((Cursor)localObject2).isAfterLast())
    {
      ((List)localObject1).add(((Cursor)localObject2).getString(1));
      ((Cursor)localObject2).moveToNext();
    }
    ((Cursor)localObject2).close();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramSQLiteDatabase.execSQL("DROP VIEW IF EXISTS " + (String)localObject2);
    }
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
      localObject1 = localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MessengerDatabaseHelper", "Error while trying to open readable messenger db", localException);
      }
    }
    finally {}
    return (SQLiteDatabase)localObject1;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      localObject3 = localSQLiteDatabase;
      localObject1 = localSQLiteDatabase;
      if (!isInMemory)
      {
        localObject1 = localSQLiteDatabase;
        localSQLiteDatabase.enableWriteAheadLogging();
        localObject3 = localSQLiteDatabase;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MessengerDatabaseHelper", "Error while trying to open writable messenger db", localException);
        Object localObject3 = localObject1;
      }
    }
    finally {}
    return (SQLiteDatabase)localObject3;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int j = 0;
    database = paramSQLiteDatabase;
    if (database != null) {}
    try
    {
      paramSQLiteDatabase = "CREATE TABLE actors (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    remote_id TEXT UNIQUE NOT NULL, /* => Server ID */\n    member_id TEXT,\n    first_name TEXT,\n    last_name TEXT,\n    initials_text TEXT,\n    photo_url TEXT,\n    background_url TEXT,\n    headline TEXT,\n    actor_type TEXT NOT NULL /* Client-side internal enum - PERSON, COMPANY */\n    );\n\nCREATE TABLE conversations (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    remote_id TEXT UNIQUE NOT NULL, /* => Server ID */\n    read INTEGER NOT NULL,\n    muted INTEGER NOT NULL,\n    unread_count INTEGER NOT NULL,\n    name TEXT\n);\n\nCREATE TABLE conversations_ui (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    conversation_id INTEGER UNIQUE NOT NULL, /* => conversations._id */\n    title TEXT,\n    num_actors INTEGER NOT NULL,\n    is_deleted INTEGER DEFAULT 0\n    );\n\nCREATE TABLE events (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    remote_id TEXT UNIQUE NOT NULL, /* => Server ID */\n    conversation_id INTEGER NOT NULL, /* => conversations._id */\n    subtype TEXT NOT NULL,\n    timestamp INTEGER NOT NULL,\n    actor_id INTEGER NOT NULL, /* => actors._id - The person who initiated this event */\n    event_status TEXT NOT NULL, /* Client-side internal enum - RECEIVED, RECEIVED_PRELOAD, PENDING, SENT, FAILED */\n    event_content_type TEXT NOT NULL, /* Client-side internal enum - NONE, PARTICIPANT_CHANGE, MESSAGE, or STICKER */\n    custom_content_type TEXT NOT NULL, /* Client-side internal enum - NONE, INMAIL, or GROUP */\n    share_content_type TEXT NOT NULL /* Client-side internal enum - NONE, ARTICLE, ACTIVITY */\n    );\n\nCREATE TABLE message_events (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    event_id INTEGER UNIQUE NOT NULL, /* => events._id */\n    body TEXT NOT NULL,\n    subject TEXT,\n    has_attachments INTEGER NOT NULL,\n    attributed_body TEXT\n    );\n\nCREATE TABLE event_custom_content_inmails (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    event_id INTEGER UNIQUE NOT NULL, /* => events._id */\n    inmail_type TEXT NOT NULL, /* Server-based enum */\n    inmail_status TEXT NOT NULL, /* Server-based enum */\n    inmail_action_type TEXT NOT NULL, /* Server-based enum */\n    sender_email TEXT, /* ContactInfo on InmailContent */\n    sender_phone_number TEXT, /* PhoneNumber from PhoneNumber on ContactInfo */\n    sender_phone_extension TEXT, /* Extension from PhoneNumber on ContactInfo */\n    is_sender_recruiter INTEGER NOT NULL, /* RecruiterInmail on InmailContent */\n    recruiting_company_id INTEGER /* Actor Id */\n    );\n\nCREATE TABLE event_custom_content_inmail_insights (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    event_custom_content_inmail_id INTEGER UNIQUE NOT NULL, /* => event_custom_content_inmails._id */\n    insight_text TEXT NOT NULL, /* Decorated insight text content */\n    insight_type TEXT NOT NULL, /* Type of insight, e.g. Company_Recruit*/\n    insight_priority TEXT, /* The index of this insight in the insights array from EntityInsight model */\n    insight_entity_logo_url TEXT, /* Logo url of the Entity from EntityInsight, e.g. url of the MiniCompany */\n    insight_profile_logo_url_one TEXT, /* Logo url of the first profile in the insight */\n    insight_profile_logo_url_two TEXT, /* Logo url of the second profile in the insight */\n    insight_profile_logo_url_three TEXT /* Logo url of the third profile in the insight */\n    );\n\nCREATE TABLE event_custom_content_groups (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    event_id INTEGER UNIQUE NOT NULL, /* => events._id */\n    group_name TEXT NOT NULL,\n    logo_url TEXT\n    );\n\nCREATE TABLE event_custom_content_conversation_name_update (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    event_id INTEGER UNIQUE NOT NULL, /* => events._id */\n    conversation_name TEXT NOT NULL\n    );\n\nCREATE TABLE message_event_share_content (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    event_id INTEGER UNIQUE NOT NULL, /* => events._id */\n    share_type TEXT NOT NULL, /* Client-side internal enum - ACTIVITY, ARTICLE */\n    urn TEXT NOT NULL,\n    object_data TEXT NOT NULL\n    );\n\nCREATE TABLE sticker_events (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    event_id INTEGER UNIQUE NOT NULL, /* => events._id */\n    remote_id TEXT NOT NULL,\n    media_id TEXT NOT NULL\n    );\n\nCREATE TABLE participant_change_event_to_actors (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    event_id INTEGER NOT NULL, /* => events._id */\n    actor_id INTEGER NOT NULL, /* => actors._id */\n    participant_change_event_type TEXT NOT NULL,\n    UNIQUE(event_id, actor_id) ON CONFLICT REPLACE\n    );\n\nCREATE TABLE attachments (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    message_event_id INTEGER NOT NULL,\n    file_name TEXT,\n    file_size INTEGER,\n    media_type TEXT,\n    url TEXT,\n    media_id TEXT,\n    width INTEGER,\n    height INTEGER,\n    attachment_type TEXT NOT NULL,\n    attachment_status TEXT,\n    UNIQUE(file_name, message_event_id) ON CONFLICT REPLACE\n    );\n\nCREATE TABLE message_event_to_attachments (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    message_event_id INTEGER NOT NULL, /* => message_events._id */\n    attachment_id INTEGER NOT NULL, /* => attachments._id */\n    UNIQUE(message_event_id, attachment_id) ON CONFLICT REPLACE\n    );\n\nCREATE TABLE conversations_to_actors (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    conversation_id INTEGER NOT NULL, /* => conversations._id */\n    actor_id INTEGER NOT NULL, /* => actors._id */\n    last_read_event_remote_id TEXT, /* => events.remote_id */\n    UNIQUE(conversation_id, actor_id) ON CONFLICT REPLACE\n    );\n\nCREATE TABLE message_event_custom_content_sponsored_inmails (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    event_id INTEGER UNIQUE NOT NULL, /* => events._id */\n    spinmail_type TEXT, /* Sponsored inmail subtype enum - LANDING_PAGE, LEADGEN */\n    spinmail_status TEXT, /* Actioned or not enum - PENDING, ACTIONED */\n    body TEXT, /* Actual body of the Sponsored InMail */\n    body_tracking TEXT,\n    open_tracking TEXT,\n    custom_legal_text TEXT,\n    static_legal_text TEXT,\n    custom_legal_text_tracking TEXT,\n    static_legal_text_tracking TEXT,\n    sender_name TEXT,\n    photo_url TEXT,\n    actor_type TEXT NOT NULL /* Client-side internal enum - PERSON, COMPANY */\n    );\n\nCREATE TABLE message_event_custom_content_sponsored_inmails_standard (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    message_event_custom_content_sponsored_inmails_id INTEGER UNIQUE NOT NULL, /* => message_event_custom_content_sponsored_inmails.id */\n    action_text TEXT,\n    action_url TEXT,\n    actionTracking TEXT,\n    adunit TEXT,\n    adunit_tracking TEXT\n    );\n\nCREATE TABLE message_event_custom_content_sponsored_inmails_leadgen (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    message_event_custom_content_sponsored_inmails_id INTEGER UNIQUE NOT NULL, /* => message_event_custom_content_sponsored_inmails.id */\n    action_text TEXT,\n    after_action_text TEXT,\n    leadgen_interested_tracking TEXT,\n    leadgen_shared_email_tracking TEXT,\n    adunit TEXT,\n    adunit_tracking TEXT\n    );\n\nCREATE TABLE sticker_packs (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    remote_id TEXT UNIQUE NOT NULL,\n    name TEXT NOT NULL,\n    author TEXT NOT NULL,\n    preview_sticker_remote_id TEXT NOT NULL,\n    timestamp INTEGER NOT NULL\n    );\n\nCREATE TABLE stickers (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    remote_id TEXT UNIQUE NOT NULL,\n    media_id TEXT NOT NULL,\n    sticker_packs_id INTEGER NOT NULL, /* => sticker_packs._id */\n    sort_id INTEGER NOT NULL\n    );\n\nCREATE TABLE recent_stickers (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    stickers_id INTEGER UNIQUE NOT NULL, /* => stickers._id */\n    timestamp INTEGER NOT NULL\n    );\n\nCREATE TABLE search (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    term TEXT,\n    filter TEXT,\n    UNIQUE(term, filter)\n    );\n\nCREATE TABLE conversations_to_search (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    conversation_id INTEGER NOT NULL,\n    event_id INTEGER,\n    search_id INTEGER NOT NULL,\n    UNIQUE(conversation_id, event_id, search_id)\n    );\n\nCREATE VIEW conversations_view AS\n    SELECT * FROM\n        (\n            SELECT  conversations.*,\n                    conversations_ui._id AS conversations_ui_id,\n                    conversations_ui.title,\n                    conversations_ui.num_actors,\n                    events._id AS last_event_id,\n                    events.remote_id AS last_event_remote_id,\n                    events.timestamp AS last_event_timestamp,\n                    events.subtype AS last_event_subtype,\n                    events.event_status AS last_event_status,\n                    events.event_content_type AS last_event_content_type,\n                    message_events.body AS last_event_body,\n                    message_events.subject as last_event_subject,\n                    message_events.has_attachments as last_event_has_attachments,\n                    actors._id AS last_event_actor_id,\n                    actors.remote_id AS last_event_actor_remote_id,\n                    actors.first_name AS last_event_actor_first_name,\n                    actors.last_name AS last_event_actor_last_name,\n                    actors.initials_text AS last_event_actor_initials_text,\n                    actors.photo_url AS last_event_actor_photo_url,\n                    actors.headline AS last_event_actor_headline\n            FROM    conversations, conversations_ui, actors, events, conversations_to_search\n            LEFT JOIN message_events on message_events.event_id = events._id\n            WHERE   conversations_ui.conversation_id = conversations._id AND\n                    events.conversation_id = conversations._id AND\n                    events.event_status != 'SEARCH_RESULT' AND\n                    events.actor_id = actors._id AND\n                    conversations._id = conversations_to_search.conversation_id AND\n                    conversations_to_search.search_id = 1\n            ORDER BY events.timestamp ASC\n        )\n    GROUP BY _id\n    ORDER BY last_event_timestamp DESC;\n\nCREATE VIEW search_view AS\n    SELECT * FROM\n        (\n            SELECT  conversations.*,\n                    conversations_ui._id AS conversations_ui_id,\n                    conversations_ui.title,\n                    conversations_ui.num_actors,\n                    conversations_to_search.search_id AS search_id,\n                    events._id AS last_event_id,\n                    events.remote_id AS last_event_remote_id,\n                    events.timestamp AS last_event_timestamp,\n                    events.subtype AS last_event_subtype,\n                    events.event_status AS last_event_status,\n                    events.event_content_type AS last_event_content_type,\n                    message_events.body AS last_event_body,\n                    message_events.subject as last_event_subject,\n                    message_events.has_attachments as last_event_has_attachments,\n                    message_events._id as last_event_message_event_id,\n                    actors._id AS last_event_actor_id,\n                    actors.remote_id AS last_event_actor_remote_id,\n                    actors.first_name AS last_event_actor_first_name,\n                    actors.last_name AS last_event_actor_last_name,\n                    actors.initials_text AS last_event_actor_initials_text,\n                    actors.photo_url AS last_event_actor_photo_url,\n                    actors.headline AS last_event_actor_headline\n            FROM    conversations, conversations_ui, actors, events, conversations_to_search\n            LEFT JOIN message_events on message_events.event_id = events._id\n            WHERE   conversations_ui.conversation_id = conversations._id AND\n                    events._id = conversations_to_search.event_id AND\n                    events.actor_id = actors._id AND\n                    conversations._id = conversations_to_search.conversation_id\n            ORDER BY events.timestamp ASC\n        )\n    ORDER BY last_event_timestamp DESC;\n\nCREATE VIEW actors_for_conversations_view AS\n    SELECT  conversations_to_actors._id AS aggregate_id,\n            conversations_to_actors.conversation_id,\n            conversations_to_actors.last_read_event_remote_id,\n            actors.*\n    FROM    actors, conversations_to_actors\n    WHERE   actors._id = conversations_to_actors.actor_id;\n\nCREATE VIEW events_view AS\n    SELECT  events.*,\n            message_events._id as message_event_id,\n            message_events.body as body,\n            message_events.attributed_body as attributed_body,\n            message_events.subject as subject,\n            conversations.remote_id as conversation_remote_id,\n            actors._id as actor_id,\n            actors.remote_id as actor_remote_id,\n            actors.first_name as actor_first_name,\n            actors.last_name as actor_last_name,\n            actors.initials_text as actor_initials_text,\n            actors.photo_url as actor_photo_url,\n            event_custom_content_groups.group_name as event_custom_content_group_name,\n            event_custom_content_inmails._id as event_custom_content_id,\n            event_custom_content_inmails.inmail_action_type as event_custom_content_inmail_action_type,\n            event_custom_content_inmails.is_sender_recruiter as event_custom_content_is_inmail_sender_recruiter,\n            event_custom_content_inmails.recruiting_company_id as event_custom_content_recruiting_company_id,\n            event_custom_content_conversation_name_update.conversation_name as event_custom_content_conversation_name_update_name\n    FROM    events, conversations, actors\n    LEFT JOIN message_events ON message_events.event_id = events._id\n    LEFT JOIN event_custom_content_groups ON event_custom_content_groups.event_id = events._id\n    LEFT JOIN event_custom_content_inmails ON event_custom_content_inmails.event_id = events._id\n    LEFT JOIN event_custom_content_conversation_name_update on event_custom_content_conversation_name_update.event_id = events._id\n    WHERE   events.actor_id = actors._id AND\n            events.conversation_id = conversations._id\n    ORDER BY events.timestamp;\n\nCREATE VIEW participant_change_actors_view AS\n    SELECT participant_change_event_to_actors._id as participant_change_event_to_actors_id,\n           participant_change_event_to_actors.event_id,\n           participant_change_event_to_actors.actor_id,\n           participant_change_event_to_actors.participant_change_event_type as participant_change_event_type,\n           actors.*\n    FROM   actors, participant_change_event_to_actors\n    WHERE  participant_change_event_to_actors.actor_id = actors._id;\n\nCREATE VIEW recent_stickers_view AS\n    SELECT stickers.*\n    FROM   stickers, recent_stickers\n    WHERE  stickers._id = recent_stickers.stickers_id\n    ORDER BY recent_stickers.timestamp DESC;\n\n/* We have a default search filter that applies to all NORMAL conversation items so we can select them */\nINSERT INTO search (_id, term, filter) VALUES (1, NULL, NULL);\n\nCREATE INDEX \"conv_to_actors_conv_id\" on conversations_to_actors (conversation_id);\nCREATE INDEX \"conv_to_actors_actor_id\" on conversations_to_actors (actor_id);\nCREATE INDEX \"events_conv_id\" on events (conversation_id);\nCREATE INDEX \"participant_change_event_to_actors_event_id\" on participant_change_event_to_actors (event_id);\nCREATE INDEX \"participant_change_event_to_actors_actor_id\" on participant_change_event_to_actors (actor_id);\nCREATE INDEX \"msg_to_attach_msg_id\" on message_event_to_attachments (message_event_id);\nCREATE INDEX \"custom_content_spinmail\" on message_event_custom_content_sponsored_inmails (event_id);\nCREATE INDEX \"spinmail_standard\" on message_event_custom_content_sponsored_inmails_standard (message_event_custom_content_sponsored_inmails_id);\nCREATE INDEX \"spinmail_leadgen\" on message_event_custom_content_sponsored_inmails_leadgen (message_event_custom_content_sponsored_inmails_id);\n\nPRAGMA user_version = 4;".split("(?m);\\s*$");
      int k = paramSQLiteDatabase.length;
      int i = 0;
      String str;
      while (i < k)
      {
        str = paramSQLiteDatabase[i];
        database.execSQL(str);
        i += 1;
      }
      if (MOCK_DATA.booleanValue())
      {
        paramSQLiteDatabase = "INSERT INTO actors (_id, remote_id, display_name, initials_text, photo_url) VALUES (1, \"act1\", \"Austin Powers\", \"AP\", \"https://media.licdn.com/mpr/mpr/shrink_200_200/p/8/005/018/153/33a883c.jpg\");\nINSERT INTO actors (_id, remote_id, display_name, initials_text, photo_url) VALUES (2, \"act2\", \"Bruce Wayne\", \"BW\", \"https://media.licdn.com/mpr/mpr/shrink_200_200/p/7/000/209/3aa/1683ac9.jpg\");\n\nINSERT INTO conversations (_id, remote_id, summary_text, timestamp) VALUES (1, \"conv1\", \"Alfred got me new socks for the batsuit!\", 1422440889);\nINSERT INTO conversations (_id, remote_id, summary_text, timestamp) VALUES (2, \"conv2\", \"Should I endorse Dr. Evil?\", 1422140889);\nINSERT INTO conversations (_id, remote_id, summary_text, timestamp) VALUES (3, \"conv3\", \"Whatever... you should endorse me for being awesome\", 1421140889);\n\nINSERT INTO conversations_ui (_id, conversation_id, title, num_actors) VALUES (1, 1, \"Austin Powers\", 1);\nINSERT INTO conversations_ui (_id, conversation_id, title, num_actors) VALUES (2, 2, \"Bruce Wayne\", 1);\nINSERT INTO conversations_ui (_id, conversation_id, title, num_actors) VALUES (3, 3, \"Austin Powers, Bruce Wayne\", 2);\n\n\nINSERT INTO conversations_to_actors (_id, conversation_id, actor_id) VALUES (1, 1, 1, \"123\");\nINSERT INTO conversations_to_actors (_id, conversation_id, actor_id) VALUES (2, 2, 2, \"122\");\nINSERT INTO conversations_to_actors (_id, conversation_id, actor_id) VALUES (3, 3, 1, \"113\");\nINSERT INTO conversations_to_actors (_id, conversation_id, actor_id) VALUES (4, 3, 2, \"153\");\n\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (1, \"msg1\", 1, \"Hey Austin you there?\", 1491140889, -1, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (2, \"msg2\", 1, \"Dude where are you?\", 1481140889, -1, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (3, \"msg3\", 1, \"You do know I'm the international man of mystery right?\", 1481240889, 1, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (4, \"msg4\", 1, \"mmkay.. anyway want to come over for margaritas?\", 1481340889, -1, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (5, \"msg5\", 1, \"kinda busy saving the world and such...\", 1481440889, 1, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (6, \"msg6\", 1, \"Should I endorse Dr. Evil?\", 1481540889, -1, 0, 0);\n\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (7, \"msg7\", 2, \"Where is she!?\", 1491140889, 2, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (8, \"msg8\", 2, \"Where is who?\", 1491240889, -1, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (9, \"msg9\", 2, \"Rachel, where is she!?\", 1491340889, 2, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (10, \"msg10\", 2, \"Bruce get a grip dude she's at home watching TV. Hows the whole batman thing going? Any new toys?\", 1491440889, -1, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (11, \"msg11\", 2, \"Alfred got me new socks for the batsuit!\", 1495140889, 2, 1, 0);\n\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (12, \"msg12\", 3, \"Who is this bruce guy?\", 1491140889, 1, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (13, \"msg13\", 3, \"Where is she!?\", 1491240889, 2, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (14, \"msg14\", 3, \"Bruce! Dude it's getting old. When you aren't wearing the suit you can use your normal voice mmkay?\", 1491340889, -1, 1, 0);\nINSERT INTO messages (_id, remote_id, conversation_id, body, timestamp, actor_id, read, message_status) VALUES (15, \"msg15\", 3, \"Whatever... you should endorse me for being awesome\", 1491340889, 2, 1, 0);\n\nINSERT INTO attachments (_id, media_id, file_name, url, description, attachment_status) VALUES (1, \"media-id-1\", \"batman.jpg\", \"http://www.billboard.com/files/styles/promo_650/public/stylus/2398469-the-dark-knight-rises-617-409.jpg\", \"\", 0);\n\nINSERT INTO messages_to_attachments (_id, message_id, attachment_id) VALUES (1, 15, 1);".split("(?m);\\s*$");
        k = paramSQLiteDatabase.length;
        i = j;
        while (i < k)
        {
          str = paramSQLiteDatabase[i];
          database.execSQL(str);
          i += 1;
        }
      }
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      Log.e("MessengerDatabaseHelper", "SQL Exception while creating messenger db", paramSQLiteDatabase);
      MessengerCrashReporter.getCrashReporter().reportNonFatal(paramSQLiteDatabase);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      Log.e("MessengerDatabaseHelper", "Exception while creating messenger db", paramSQLiteDatabase);
      MessengerCrashReporter.getCrashReporter().reportNonFatal(paramSQLiteDatabase);
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Log.w("MessengerDatabaseHelper", "Upgrading database from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    if (paramSQLiteDatabase != null)
    {
      DropAllTables(paramSQLiteDatabase);
      DropAllViews(paramSQLiteDatabase);
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public final boolean recreateDatabase()
  {
    DatabaseExecutor localDatabaseExecutor = DatabaseExecutor.getInstance();
    if (executorService != null) {
      executorService.shutdown();
    }
    try
    {
      if (!executorService.awaitTermination(60L, TimeUnit.SECONDS))
      {
        executorService.shutdownNow();
        if (!executorService.awaitTermination(60L, TimeUnit.SECONDS)) {
          Log.e(DatabaseExecutor.TAG, "Pool did not terminate");
        }
      }
      executorService = null;
      com.linkedin.messengerlib.me.MeFetcher.meProfile = null;
      if (database != null)
      {
        DropAllTables(database);
        DropAllViews(database);
        onCreate(database);
        return true;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        executorService.shutdownNow();
        Thread.currentThread().interrupt();
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.database.MessengerDatabaseHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */