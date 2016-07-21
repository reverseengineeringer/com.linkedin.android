package com.linkedin.messengerlib.consumers;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.File;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorImage;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.CompanyRecruitReason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor.Reason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsights.Entity;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.SchoolRecruitReason;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.messaging.Event;
import com.linkedin.android.pegasus.gen.voyager.messaging.EventsMetadata;
import com.linkedin.android.pegasus.gen.voyager.messaging.MessagingCompany;
import com.linkedin.android.pegasus.gen.voyager.messaging.MessagingMember;
import com.linkedin.android.pegasus.gen.voyager.messaging.MessagingProfile;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventSubtype;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.MessageEvent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.ParticipantChangeEvent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.StickerEvent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.StickerEvent.CustomContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailActionType;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailStatus;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailType;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.ShareContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailAdUnit;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent.SubContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailLeadGenSubContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailLegalText;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStatus;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailType;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import com.linkedin.data.lite.JsonGenerator;
import com.linkedin.data.lite.JsonGeneratorException;
import com.linkedin.data.lite.JsonGeneratorFactory;
import com.linkedin.messengerlib.R.string;
import com.linkedin.messengerlib.database.DatabaseExecutor;
import com.linkedin.messengerlib.database.MessengerDatabaseHelper.ActorType;
import com.linkedin.messengerlib.database.MessengerDatabaseHelper.CustomContentType;
import com.linkedin.messengerlib.database.MessengerDatabaseHelper.EventContentType;
import com.linkedin.messengerlib.database.MessengerDatabaseHelper.EventStatus;
import com.linkedin.messengerlib.database.MessengerDatabaseHelper.InsightType;
import com.linkedin.messengerlib.database.MessengerDatabaseHelper.ShareContentType;
import com.linkedin.messengerlib.database.MessengerProvider;
import com.linkedin.messengerlib.event.PendingEvent;
import com.linkedin.messengerlib.sticker.LocalSticker;
import com.linkedin.messengerlib.sync.MessengerSyncUris;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.ParticipantChangeEventModel;
import com.linkedin.messengerlib.utils.UrnUtil;
import com.linkedin.xmsg.Name;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

public class EventsDataManager
  extends BaseDataManager
{
  private static final String TAG = EventsDataManager.class.getCanonicalName();
  
  public EventsDataManager(Context paramContext, DataManager paramDataManager)
  {
    super(paramContext, paramDataManager);
  }
  
  private long addEvent(ContentValues paramContentValues)
  {
    try
    {
      beginTransactionNonExclusive();
      long l = safeInsertOrUpdate(paramContentValues, MessengerProvider.EVENTS_URI, new String[] { paramContentValues.getAsString("remote_id") }, "remote_id=?");
      if (l != -1L) {
        setTransactionSuccessful();
      }
      return l;
    }
    finally
    {
      endTransaction();
    }
  }
  
  private long addOrUpdateEvent(Event paramEvent, long paramLong, MessengerDatabaseHelper.EventStatus paramEventStatus)
  {
    ContentValues localContentValues;
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        beginTransactionNonExclusive();
        localContentValues = new ContentValues();
        if (from.messagingMemberValue != null)
        {
          localContentValues.put("actor_id", Long.valueOf(dataManager.actorDataManager.addOrUpdateActor(from.messagingMemberValue.miniProfile)));
          localContentValues.put("conversation_id", Long.valueOf(paramLong));
          localContentValues.put("remote_id", entityUrn.getLastId());
          if (paramEventStatus == MessengerDatabaseHelper.EventStatus.PUSHED)
          {
            localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            localContentValues.put("event_status", paramEventStatus.name());
            localContentValues.put("subtype", subtype.name());
            localObject1 = MessengerDatabaseHelper.EventContentType.UNKNOWN;
            if (eventContent.participantChangeEventValue == null) {
              break label463;
            }
            localObject1 = MessengerDatabaseHelper.EventContentType.PARTICIPANT_CHANGE;
            localContentValues.put("event_content_type", ((MessengerDatabaseHelper.EventContentType)localObject1).name());
            localObject2 = MessengerDatabaseHelper.CustomContentType.NONE;
            localObject1 = localObject2;
            if (eventContent.messageEventValue != null)
            {
              localObject1 = localObject2;
              if (eventContent.messageEventValue.customContent != null)
              {
                localObject3 = eventContent.messageEventValue.customContent;
                if (inmailContentValue == null) {
                  break label520;
                }
                localObject1 = MessengerDatabaseHelper.CustomContentType.INMAIL;
              }
            }
            localObject2 = localObject1;
            if (eventContent.stickerEventValue != null)
            {
              localObject2 = localObject1;
              if (eventContent.stickerEventValue.customContent != null)
              {
                localObject2 = localObject1;
                if (eventContent.stickerEventValue.customContent.groupContentValue != null) {
                  localObject2 = MessengerDatabaseHelper.CustomContentType.GROUP;
                }
              }
            }
            localContentValues.put("custom_content_type", ((MessengerDatabaseHelper.CustomContentType)localObject2).name());
            localObject2 = MessengerDatabaseHelper.ShareContentType.NONE;
            localObject1 = localObject2;
            if (eventContent.messageEventValue != null)
            {
              localObject1 = localObject2;
              if (eventContent.messageEventValue.shareContent != null)
              {
                localObject3 = eventContent.messageEventValue.shareContent;
                if (shareArticleValue == null) {
                  break label540;
                }
                localObject1 = MessengerDatabaseHelper.ShareContentType.ARTICLE;
              }
            }
            localContentValues.put("share_content_type", ((MessengerDatabaseHelper.ShareContentType)localObject1).name());
            paramEvent = entityUrn.getLastId();
            paramLong = safeInsert(localContentValues, MessengerProvider.EVENTS_URI);
            if (paramLong == -1L) {
              break;
            }
            setTransactionSuccessful();
            return paramLong;
          }
        }
        else
        {
          if (from.messagingCompanyValue == null) {
            continue;
          }
          localContentValues.put("actor_id", Long.valueOf(dataManager.actorDataManager.addOrUpdateActor(from.messagingCompanyValue.miniCompany, null)));
          continue;
        }
        localContentValues.put("timestamp", Long.valueOf(createdAt));
      }
      finally
      {
        endTransaction();
      }
      continue;
      label463:
      if (eventContent.messageEventValue != null)
      {
        if (eventContent.messageEventValue.shareContent != null) {
          localObject1 = MessengerDatabaseHelper.EventContentType.SHARED_UPDATE;
        } else {
          localObject1 = MessengerDatabaseHelper.EventContentType.MESSAGE;
        }
      }
      else if (eventContent.stickerEventValue != null)
      {
        localObject1 = MessengerDatabaseHelper.EventContentType.STICKER;
        continue;
        label520:
        localObject1 = localObject2;
        if (groupContentValue != null)
        {
          localObject1 = MessengerDatabaseHelper.CustomContentType.GROUP;
          continue;
          label540:
          localObject1 = localObject2;
          if (updateValue != null) {
            localObject1 = MessengerDatabaseHelper.ShareContentType.ACTIVITY;
          }
        }
      }
    }
    if (MessengerDatabaseHelper.EventStatus.RECEIVED_PRELOAD == paramEventStatus) {
      localContentValues.remove("event_status");
    }
    paramLong = safeUpdate(localContentValues, MessengerProvider.EVENTS_URI, new String[] { paramEvent }, "remote_id=?");
    if (paramLong != -1L) {
      setTransactionSuccessful();
    }
    endTransaction();
    return paramLong;
  }
  
  private long addOrUpdateEventConversationNameUpdate(String paramString, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("event_id", Long.valueOf(paramLong));
    localContentValues.put("conversation_name", paramString);
    try
    {
      beginTransactionNonExclusive();
      paramLong = safeInsertOrUpdate(localContentValues, MessengerProvider.EVENT_CUSTOM_CONTENT_CONVERSATION_NAME_UPDATE_URI, String.valueOf(paramLong), "event_id");
      if (paramLong != -1L) {
        setTransactionSuccessful();
      }
      return paramLong;
    }
    finally
    {
      endTransaction();
    }
  }
  
  private long addOrUpdateInmail(InmailContent paramInmailContent, long paramLong)
  {
    Object localObject2 = new ContentValues();
    ((ContentValues)localObject2).put("event_id", Long.valueOf(paramLong));
    ((ContentValues)localObject2).put("inmail_status", status.name());
    ((ContentValues)localObject2).put("inmail_action_type", actionType.name());
    ((ContentValues)localObject2).put("inmail_type", inmailType.name());
    ((ContentValues)localObject2).put("is_sender_recruiter", Boolean.valueOf(recruiterInmail));
    Object localObject1;
    Object localObject3;
    long l;
    if (senderCompanyInsights != null)
    {
      localObject1 = senderCompanyInsights.insights;
      if (!((List)localObject1).isEmpty())
      {
        localObject1 = (EntitiesFlavor)((List)localObject1).get(0);
        if (senderCompanyInsights == null) {
          break label492;
        }
        localObject3 = senderCompanyInsights.entity.miniCompanyValue;
        if (localObject3 == null) {
          break label492;
        }
        l = dataManager.actorDataManager.addOrUpdateActor((MiniCompany)localObject3, senderCompanyInsights.entityInfo);
        label165:
        if (l != -1L) {
          ((ContentValues)localObject2).put("recruiting_company_id", Long.valueOf(l));
        }
      }
    }
    for (;;)
    {
      try
      {
        beginTransactionNonExclusive();
        l = safeInsertOrUpdate((ContentValues)localObject2, MessengerProvider.EVENT_CUSTOM_CONTENT_INMAILS_URI, String.valueOf(paramLong), "event_id");
        I18NManager localI18NManager;
        if (l != -1L)
        {
          if (localObject1 == null) {
            continue;
          }
          localObject3 = new ContentValues();
          localI18NManager = dataManager.i18NManager;
          ((ContentValues)localObject3).put("event_custom_content_inmail_id", Long.valueOf(l));
          ((ContentValues)localObject3).put("insight_priority", Integer.valueOf(0));
          if (reason.inNetworkReasonValue == null) {
            continue;
          }
          paramInmailContent = MessengerDatabaseHelper.InsightType.IN_NETWORK;
          localObject1 = reason.inNetworkReasonValue;
          localObject2 = topConnections;
          if (!((List)localObject2).isEmpty())
          {
            addProfileLogoUrl((ContentValues)localObject3, get0miniProfile, "insight_profile_logo_url_one");
            if (((List)localObject2).size() > 1) {
              addProfileLogoUrl((ContentValues)localObject3, get1miniProfile, "insight_profile_logo_url_two");
            }
            if (((List)localObject2).size() > 2) {
              addProfileLogoUrl((ContentValues)localObject3, get2miniProfile, "insight_profile_logo_url_three");
            }
          }
          localObject2 = localI18NManager.getString(R.string.messenger_inmail_insight_in_network_reason, new Object[] { Integer.valueOf(totalNumberOfConnections) });
          localObject1 = paramInmailContent;
          paramInmailContent = (InmailContent)localObject2;
          ((ContentValues)localObject3).put("insight_type", ((MessengerDatabaseHelper.InsightType)localObject1).toString());
          ((ContentValues)localObject3).put("insight_text", paramInmailContent);
          paramLong = safeInsertOrUpdate((ContentValues)localObject3, MessengerProvider.EVENT_CUSTOM_CONTENT_INMAIL_INSIGHTS_URI, String.valueOf(l), "event_custom_content_inmail_id");
          if (paramLong != -1L) {
            setTransactionSuccessful();
          }
        }
        return l;
        localObject1 = null;
        break;
        label492:
        l = -1L;
        break label165;
        if (reason.companyRecruitReasonValue != null)
        {
          localObject2 = MessengerDatabaseHelper.InsightType.COMPANY_RECRUIT;
          paramInmailContent = reason.companyRecruitReasonValue;
          localObject1 = ActorDataManager.getPictureUrl(currentCompany.logo);
          if (localObject1 != null) {
            ((ContentValues)localObject3).put("insight_entity_logo_url", (String)localObject1);
          }
          paramInmailContent = localI18NManager.getString(R.string.messenger_inmail_insight_former_employee_recruit_reason, new Object[] { Integer.valueOf(totalNumberOfPastCoworkers) });
          localObject1 = localObject2;
        }
        else if (reason.schoolRecruitReasonValue != null)
        {
          localObject2 = MessengerDatabaseHelper.InsightType.SCHOOL_RECRUIT;
          paramInmailContent = reason.schoolRecruitReasonValue;
          localObject1 = ActorDataManager.getPictureUrl(mostRecentSchool.logo);
          if (localObject1 != null) {
            ((ContentValues)localObject3).put("insight_entity_logo_url", (String)localObject1);
          }
          paramInmailContent = localI18NManager.getString(R.string.messenger_inmail_insight_school_alumni_recruit_reason, new Object[] { Integer.valueOf(totalNumberOfAlumni) });
          localObject1 = localObject2;
          continue;
          setTransactionSuccessful();
        }
        else
        {
          paramLong = -1L;
        }
      }
      finally
      {
        endTransaction();
      }
    }
  }
  
  /* Error */
  private long addOrUpdateMessage(Event paramEvent, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 32	com/linkedin/messengerlib/consumers/EventsDataManager:beginTransactionNonExclusive	()V
    //   4: new 44	android/content/ContentValues
    //   7: dup
    //   8: invokespecial 66	android/content/ContentValues:<init>	()V
    //   11: astore 7
    //   13: aload_1
    //   14: getfield 163	com/linkedin/android/pegasus/gen/voyager/messaging/Event:eventContent	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/EventContent;
    //   17: getfield 185	com/linkedin/android/pegasus/gen/voyager/messaging/event/EventContent:messageEventValue	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent;
    //   20: astore 8
    //   22: aload 7
    //   24: ldc_w 294
    //   27: lload_2
    //   28: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: invokevirtual 112	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   34: aload 7
    //   36: ldc_w 526
    //   39: aload 8
    //   41: getfield 528	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:body	Ljava/lang/String;
    //   44: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload 8
    //   49: getfield 532	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:attributedBody	Lcom/linkedin/android/pegasus/gen/pemberly/text/AttributedText;
    //   52: astore 9
    //   54: aload 9
    //   56: ifnull +16 -> 72
    //   59: aload 7
    //   61: ldc_w 534
    //   64: aload 9
    //   66: invokestatic 540	com/linkedin/messengerlib/utils/ParcelerUtil:parcelModel	(Lcom/linkedin/data/lite/RecordTemplate;)Ljava/lang/String;
    //   69: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 7
    //   74: ldc_w 542
    //   77: aload 8
    //   79: getfield 544	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:subject	Ljava/lang/String;
    //   82: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload 8
    //   87: getfield 547	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:attachments	Ljava/util/List;
    //   90: astore 9
    //   92: aload 9
    //   94: ifnull +213 -> 307
    //   97: aload 9
    //   99: invokeinterface 366 1 0
    //   104: ifne +203 -> 307
    //   107: iconst_1
    //   108: istore 6
    //   110: aload 7
    //   112: ldc_w 549
    //   115: iload 6
    //   117: invokestatic 347	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   120: invokevirtual 350	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   123: aload_0
    //   124: lload_2
    //   125: aload 7
    //   127: invokespecial 553	com/linkedin/messengerlib/consumers/EventsDataManager:insertOrUpdateMessage	(JLandroid/content/ContentValues;)J
    //   130: lstore 4
    //   132: aload_1
    //   133: getfield 150	com/linkedin/android/pegasus/gen/voyager/messaging/Event:subtype	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/EventSubtype;
    //   136: getstatic 556	com/linkedin/android/pegasus/gen/voyager/messaging/event/EventSubtype:SPONSORED_INMAIL	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/EventSubtype;
    //   139: if_acmpne +10 -> 149
    //   142: aload_0
    //   143: aload_1
    //   144: lload_2
    //   145: invokespecial 559	com/linkedin/messengerlib/consumers/EventsDataManager:addOrUpdateSpinMail	(Lcom/linkedin/android/pegasus/gen/voyager/messaging/Event;J)J
    //   148: pop2
    //   149: aload 8
    //   151: getfield 562	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:hasShareContent	Z
    //   154: ifeq +22 -> 176
    //   157: aload 8
    //   159: getfield 230	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:shareContent	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/ShareContent;
    //   162: ifnull +14 -> 176
    //   165: aload_0
    //   166: aload 8
    //   168: getfield 230	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:shareContent	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/ShareContent;
    //   171: lload_2
    //   172: invokespecial 566	com/linkedin/messengerlib/consumers/EventsDataManager:addOrUpdateShareContent	(Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/ShareContent;J)J
    //   175: pop2
    //   176: aload 8
    //   178: getfield 569	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:hasCustomContent	Z
    //   181: ifeq +74 -> 255
    //   184: aload 8
    //   186: getfield 191	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:customContent	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/CustomContent;
    //   189: ifnull +66 -> 255
    //   192: aload 8
    //   194: getfield 191	com/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent:customContent	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/CustomContent;
    //   197: astore_1
    //   198: aload_1
    //   199: getfield 273	com/linkedin/android/pegasus/gen/voyager/messaging/event/message/CustomContent:groupContentValue	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/GroupContent;
    //   202: ifnull +16 -> 218
    //   205: aload_0
    //   206: aload_1
    //   207: getfield 273	com/linkedin/android/pegasus/gen/voyager/messaging/event/message/CustomContent:groupContentValue	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/GroupContent;
    //   210: getfield 575	com/linkedin/android/pegasus/gen/voyager/messaging/event/message/GroupContent:group	Lcom/linkedin/android/pegasus/gen/voyager/entities/shared/MiniGroup;
    //   213: lload_2
    //   214: invokevirtual 579	com/linkedin/messengerlib/consumers/EventsDataManager:addOrUpdateEventGroup	(Lcom/linkedin/android/pegasus/gen/voyager/entities/shared/MiniGroup;J)J
    //   217: pop2
    //   218: aload_1
    //   219: getfield 197	com/linkedin/android/pegasus/gen/voyager/messaging/event/message/CustomContent:inmailContentValue	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/InmailContent;
    //   222: ifnull +13 -> 235
    //   225: aload_0
    //   226: aload_1
    //   227: getfield 197	com/linkedin/android/pegasus/gen/voyager/messaging/event/message/CustomContent:inmailContentValue	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/InmailContent;
    //   230: lload_2
    //   231: invokespecial 581	com/linkedin/messengerlib/consumers/EventsDataManager:addOrUpdateInmail	(Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/InmailContent;J)J
    //   234: pop2
    //   235: aload_1
    //   236: getfield 585	com/linkedin/android/pegasus/gen/voyager/messaging/event/message/CustomContent:conversationNameUpdateContentValue	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/ConversationNameUpdateContent;
    //   239: ifnull +16 -> 255
    //   242: aload_0
    //   243: aload_1
    //   244: getfield 585	com/linkedin/android/pegasus/gen/voyager/messaging/event/message/CustomContent:conversationNameUpdateContentValue	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/message/ConversationNameUpdateContent;
    //   247: getfield 590	com/linkedin/android/pegasus/gen/voyager/messaging/event/message/ConversationNameUpdateContent:newName	Ljava/lang/String;
    //   250: lload_2
    //   251: invokespecial 592	com/linkedin/messengerlib/consumers/EventsDataManager:addOrUpdateEventConversationNameUpdate	(Ljava/lang/String;J)J
    //   254: pop2
    //   255: iload 6
    //   257: ifeq +30 -> 287
    //   260: aload_0
    //   261: getfield 84	com/linkedin/messengerlib/consumers/EventsDataManager:dataManager	Lcom/linkedin/messengerlib/consumers/DataManager;
    //   264: getfield 596	com/linkedin/messengerlib/consumers/DataManager:attachmentDataManager	Lcom/linkedin/messengerlib/consumers/AttachmentDataManager;
    //   267: lload 4
    //   269: invokevirtual 602	com/linkedin/messengerlib/consumers/AttachmentDataManager:deleteAttachments	(J)V
    //   272: aload_0
    //   273: getfield 84	com/linkedin/messengerlib/consumers/EventsDataManager:dataManager	Lcom/linkedin/messengerlib/consumers/DataManager;
    //   276: getfield 596	com/linkedin/messengerlib/consumers/DataManager:attachmentDataManager	Lcom/linkedin/messengerlib/consumers/AttachmentDataManager;
    //   279: aload 9
    //   281: lload 4
    //   283: invokevirtual 606	com/linkedin/messengerlib/consumers/AttachmentDataManager:addOrUpdateAttachments	(Ljava/util/List;J)I
    //   286: pop
    //   287: lload 4
    //   289: ldc2_w 55
    //   292: lcmp
    //   293: ifeq +7 -> 300
    //   296: aload_0
    //   297: invokevirtual 59	com/linkedin/messengerlib/consumers/EventsDataManager:setTransactionSuccessful	()V
    //   300: aload_0
    //   301: invokevirtual 62	com/linkedin/messengerlib/consumers/EventsDataManager:endTransaction	()V
    //   304: lload 4
    //   306: lreturn
    //   307: iconst_0
    //   308: istore 6
    //   310: goto -200 -> 110
    //   313: astore_1
    //   314: aload_0
    //   315: invokevirtual 62	com/linkedin/messengerlib/consumers/EventsDataManager:endTransaction	()V
    //   318: aload_1
    //   319: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	EventsDataManager
    //   0	320	1	paramEvent	Event
    //   0	320	2	paramLong	long
    //   130	175	4	l	long
    //   108	201	6	bool	boolean
    //   11	115	7	localContentValues	ContentValues
    //   20	173	8	localMessageEvent	MessageEvent
    //   52	228	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	54	313	finally
    //   59	72	313	finally
    //   72	92	313	finally
    //   97	107	313	finally
    //   110	149	313	finally
    //   149	176	313	finally
    //   176	218	313	finally
    //   218	235	313	finally
    //   235	255	313	finally
    //   260	287	313	finally
    //   296	300	313	finally
  }
  
  private long addOrUpdateShareContent(ShareContent paramShareContent, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("event_id", Long.valueOf(paramLong));
    if (updateValue != null)
    {
      localContentValues.put("object_data", getShareContentJsonString(paramShareContent));
      if (updateValue.hasEntityUrn)
      {
        paramShareContent = updateValue.entityUrn.toString();
        localContentValues.put("urn", paramShareContent);
        localContentValues.put("share_type", MessengerDatabaseHelper.ShareContentType.ACTIVITY.name());
      }
    }
    while (shareArticleValue == null) {
      for (;;)
      {
        try
        {
          beginTransactionNonExclusive();
          paramLong = safeInsertOrUpdate(localContentValues, MessengerProvider.MESSAGE_EVENT_SHARE_CONTENT_URI, String.valueOf(paramLong), "event_id");
          if (paramLong != -1L) {
            setTransactionSuccessful();
          }
          return paramLong;
        }
        finally
        {
          endTransaction();
        }
        paramShareContent = "";
      }
    }
    localContentValues.put("object_data", getShareContentJsonString(paramShareContent));
    if (shareArticleValue.hasUrn) {}
    for (paramShareContent = shareArticleValue.urn.toString();; paramShareContent = "")
    {
      localContentValues.put("urn", paramShareContent);
      localContentValues.put("share_type", MessengerDatabaseHelper.ShareContentType.ARTICLE.name());
      break;
    }
  }
  
  private long addOrUpdateSpinMail(Event paramEvent, long paramLong)
  {
    for (;;)
    {
      ContentValues localContentValues;
      try
      {
        beginTransactionNonExclusive();
        localContentValues = new ContentValues();
        MessageEvent localMessageEvent = eventContent.messageEventValue;
        localContentValues.put("event_id", Long.valueOf(paramLong));
        int i;
        if ((hasCustomContent) && (customContent.spInmailContentValue != null))
        {
          i = 1;
          if (i != 0)
          {
            localObject1 = customContent.spInmailContentValue;
            if (spInmailType != SpInmailType.LANDING_PAGE) {
              continue;
            }
            localContentValues.put("spinmail_type", SpInmailType.LANDING_PAGE.name());
            if (status != SpInmailStatus.ACTIONED) {
              break label533;
            }
            localContentValues.put("spinmail_status", SpInmailStatus.ACTIONED.name());
            if (hasBody) {
              localContentValues.put("body", body);
            }
            if (hasBodyTracking) {
              localContentValues.put("body_tracking", bodyTracking);
            }
            if (hasOpenTracking) {
              localContentValues.put("open_tracking", openTracking);
            }
            if (hasLegalText)
            {
              if (legalText.hasStaticLegalText) {
                localContentValues.put("static_legal_text", legalText.staticLegalText);
              }
              if (legalText.hasStaticLegalTextTracking) {
                localContentValues.put("static_legal_text_tracking", legalText.staticLegalTextTracking);
              }
              if (legalText.hasCustomLegalText) {
                localContentValues.put("custom_legal_text", legalText.customLegalText);
              }
              if (legalText.hasCustomLegalTextTracking) {
                localContentValues.put("custom_legal_text_tracking", legalText.customLegalTextTracking);
              }
            }
          }
          if (from != null)
          {
            localObject2 = from;
            localObject3 = null;
            paramEvent = null;
            localObject1 = MessengerDatabaseHelper.ActorType.PEOPLE;
            if (messagingMemberValue == null) {
              break label645;
            }
            localObject1 = MessengerDatabaseHelper.ActorType.PEOPLE;
            localObject3 = messagingMemberValue;
            if (!hasAlternateName) {
              break label561;
            }
            localObject2 = alternateName;
            if (!hasAlternateImage) {
              break label619;
            }
            localObject3 = ActorDataManager.getPictureUrl(alternateImage);
            paramEvent = (Event)localObject1;
            localObject1 = localObject3;
            localContentValues.put("actor_type", paramEvent.name());
            localContentValues.put("sender_name", (String)localObject2);
            if (localObject1 != null) {
              localContentValues.put("photo_url", (String)localObject1);
            }
          }
          paramLong = safeInsertOrUpdate(localContentValues, MessengerProvider.MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_URI, String.valueOf(paramLong), "event_id");
          if (i != 0)
          {
            paramEvent = customContent.spInmailContentValue;
            if (spInmailType != SpInmailType.LANDING_PAGE) {
              break label747;
            }
            addOrUpdateSpinMailStandard(subContent.spInmailStandardSubContentValue, paramLong);
          }
          if (paramLong != -1L) {
            setTransactionSuccessful();
          }
          return paramLong;
        }
        else
        {
          i = 0;
          continue;
        }
        if (spInmailType != SpInmailType.LEADGEN) {
          continue;
        }
        localContentValues.put("spinmail_type", SpInmailType.LEADGEN.name());
        continue;
        if (status != SpInmailStatus.PENDING) {
          continue;
        }
      }
      finally
      {
        endTransaction();
      }
      label533:
      localContentValues.put("spinmail_status", SpInmailStatus.PENDING.name());
      continue;
      label561:
      Object localObject2 = Name.builder().setFirstName(miniProfile.firstName).setLastName(miniProfile.lastName);
      localObject2 = new I18NManager(appContext).getString("{0,name,full}", new Object[] { localObject2 });
      continue;
      label619:
      if (miniProfile.hasPicture)
      {
        paramEvent = ActorDataManager.getPictureUrl(miniProfile.picture);
        break label790;
        label645:
        if (messagingCompanyValue != null)
        {
          paramEvent = MessengerDatabaseHelper.ActorType.COMPANY;
          MessagingCompany localMessagingCompany = messagingCompanyValue;
          if (hasAlternateName) {}
          for (localObject2 = alternateName;; localObject2 = miniCompany.name)
          {
            if (!hasAlternateImage) {
              break label713;
            }
            localObject1 = ActorDataManager.getPictureUrl(alternateImage);
            break;
          }
          label713:
          localObject1 = paramEvent;
          localObject3 = localObject2;
          if (miniCompany.hasLogo)
          {
            localObject1 = ActorDataManager.getPictureUrl(miniCompany.logo);
            continue;
            label747:
            if (spInmailType != SpInmailType.LEADGEN) {
              continue;
            }
            addOrUpdateSpinMailLeadGen(subContent.spInmailLeadGenSubContentValue, paramLong);
            continue;
          }
        }
        localObject2 = null;
        paramEvent = (Event)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
      }
      label790:
      Object localObject3 = paramEvent;
      paramEvent = (Event)localObject1;
      Object localObject1 = localObject3;
    }
  }
  
  private long addOrUpdateSpinMailLeadGen(SpInmailLeadGenSubContent paramSpInmailLeadGenSubContent, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("message_event_custom_content_sponsored_inmails_id", Long.valueOf(paramLong));
    localContentValues.put("action_text", actionText);
    if (hasAfterActionText) {
      localContentValues.put("after_action_text", afterActionText);
    }
    if (hasLeadGenInterestedTracking) {
      localContentValues.put("leadgen_interested_tracking", leadGenInterestedTracking);
    }
    if (hasLeadGenSharedEmailTracking) {
      localContentValues.put("leadgen_shared_email_tracking", leadGenSharedEmailTracking);
    }
    if (hasAdUnit)
    {
      localContentValues.put("adunit", ActorDataManager.getPictureUrl(adUnit.adUnit));
      if (adUnit.hasAdUnitTracking) {
        localContentValues.put("adunit_tracking", adUnit.adUnitTracking);
      }
    }
    try
    {
      beginTransactionNonExclusive();
      paramLong = safeInsertOrUpdate(localContentValues, MessengerProvider.MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_LEADGEN_URI, String.valueOf(paramLong), "message_event_custom_content_sponsored_inmails_id");
      if (paramLong != -1L) {
        setTransactionSuccessful();
      }
      return paramLong;
    }
    finally
    {
      endTransaction();
    }
  }
  
  private long addOrUpdateSpinMailStandard(SpInmailStandardSubContent paramSpInmailStandardSubContent, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("message_event_custom_content_sponsored_inmails_id", Long.valueOf(paramLong));
    localContentValues.put("action_text", actionText);
    localContentValues.put("action_url", action);
    localContentValues.put("actionTracking", actionTracking);
    if (hasAdUnit)
    {
      localContentValues.put("adunit", ActorDataManager.getPictureUrl(adUnit.adUnit));
      if (adUnit.hasAdUnitTracking) {
        localContentValues.put("adunit_tracking", adUnit.adUnitTracking);
      }
    }
    try
    {
      beginTransactionNonExclusive();
      paramLong = safeInsertOrUpdate(localContentValues, MessengerProvider.MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_STANDARD_URI, String.valueOf(paramLong), "message_event_custom_content_sponsored_inmails_id");
      if (paramLong != -1L) {
        setTransactionSuccessful();
      }
      return paramLong;
    }
    finally
    {
      endTransaction();
    }
  }
  
  private long addOutgoingMessage(String paramString1, List<File> paramList, EventSubtype paramEventSubtype, long paramLong, String paramString2, MiniProfile paramMiniProfile)
  {
    long l = getActorFromProfileRemoteId(entityUrn.toString());
    if (l != -1L) {
      try
      {
        beginTransactionNonExclusive();
        paramMiniProfile = new ContentValues();
        paramMiniProfile.put("actor_id", Long.valueOf(l));
        paramMiniProfile.put("conversation_id", Long.valueOf(paramLong));
        paramMiniProfile.put("remote_id", paramString2);
        paramMiniProfile.put("subtype", paramEventSubtype.name());
        paramMiniProfile.put("custom_content_type", MessengerDatabaseHelper.CustomContentType.NONE.name());
        paramMiniProfile.put("event_content_type", MessengerDatabaseHelper.EventContentType.MESSAGE.name());
        paramMiniProfile.put("share_content_type", MessengerDatabaseHelper.ShareContentType.NONE.name());
        paramMiniProfile.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        paramMiniProfile.put("event_status", MessengerDatabaseHelper.EventStatus.PENDING.name());
        paramLong = addEvent(paramMiniProfile);
        paramEventSubtype = new ContentValues();
        paramEventSubtype.put("event_id", Long.valueOf(paramLong));
        paramEventSubtype.put("body", paramString1);
        if ((paramList != null) && (!paramList.isEmpty())) {}
        for (boolean bool = true;; bool = false)
        {
          paramEventSubtype.put("has_attachments", Boolean.valueOf(bool));
          l = safeInsertOrUpdate(paramEventSubtype, MessengerProvider.MESSAGE_EVENTS_URI, String.valueOf(paramLong), "event_id");
          if (bool) {
            dataManager.attachmentDataManager.addOrUpdateAttachments(paramList, l);
          }
          if (l != -1L) {
            setTransactionSuccessful();
          }
          return paramLong;
        }
        return -1L;
      }
      finally
      {
        endTransaction();
      }
    }
  }
  
  private long addOutgoingParticipantChange(List<MiniProfile> paramList, long paramLong, String paramString, MiniProfile paramMiniProfile, ActorDataManager.ParticipantChangeEventType paramParticipantChangeEventType)
  {
    long l1 = getActorFromProfileRemoteId(entityUrn.toString());
    if (l1 != -1L) {
      try
      {
        beginTransactionNonExclusive();
        paramMiniProfile = new ContentValues();
        paramMiniProfile.put("actor_id", Long.valueOf(l1));
        paramMiniProfile.put("conversation_id", Long.valueOf(paramLong));
        paramMiniProfile.put("remote_id", paramString);
        paramMiniProfile.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        paramMiniProfile.put("event_status", MessengerDatabaseHelper.EventStatus.PENDING.name());
        paramMiniProfile.put("subtype", EventSubtype.PARTICIPANT_CHANGE.name());
        paramMiniProfile.put("event_content_type", MessengerDatabaseHelper.EventContentType.PARTICIPANT_CHANGE.name());
        paramMiniProfile.put("custom_content_type", MessengerDatabaseHelper.CustomContentType.NONE.name());
        paramMiniProfile.put("share_content_type", MessengerDatabaseHelper.ShareContentType.NONE.name());
        long l2 = safeInsert(paramMiniProfile, MessengerProvider.EVENTS_URI);
        insertOrUpdateParticipants(paramList, paramParticipantChangeEventType, paramLong, l2, l1);
        if (l2 != -1L) {
          setTransactionSuccessful();
        }
        return l2;
      }
      finally
      {
        endTransaction();
      }
    }
    return -1L;
  }
  
  private long addOutgoingStickerEvent(LocalSticker paramLocalSticker, EventSubtype paramEventSubtype, long paramLong, String paramString, MiniProfile paramMiniProfile)
  {
    long l = getActorFromProfileRemoteId(entityUrn.toString());
    if (l != -1L) {
      try
      {
        beginTransactionNonExclusive();
        paramMiniProfile = new ContentValues();
        paramMiniProfile.put("actor_id", Long.valueOf(l));
        paramMiniProfile.put("conversation_id", Long.valueOf(paramLong));
        paramMiniProfile.put("remote_id", paramString);
        paramMiniProfile.put("subtype", paramEventSubtype.name());
        paramMiniProfile.put("custom_content_type", MessengerDatabaseHelper.CustomContentType.NONE.name());
        paramMiniProfile.put("event_content_type", MessengerDatabaseHelper.EventContentType.STICKER.name());
        paramMiniProfile.put("share_content_type", MessengerDatabaseHelper.ShareContentType.NONE.name());
        paramMiniProfile.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        paramMiniProfile.put("event_status", MessengerDatabaseHelper.EventStatus.PENDING.name());
        paramLong = addEvent(paramMiniProfile);
        if (paramLong != -1L)
        {
          paramEventSubtype = new ContentValues();
          paramEventSubtype.put("event_id", Long.valueOf(paramLong));
          paramEventSubtype.put("remote_id", remoteId);
          paramEventSubtype.put("media_id", mediaId);
          if (safeInsertOrUpdate(paramEventSubtype, MessengerProvider.STICKER_EVENTS_URI, String.valueOf(paramLong), "event_id") != -1L) {
            setTransactionSuccessful();
          }
        }
        return paramLong;
      }
      finally
      {
        endTransaction();
      }
    }
    return -1L;
  }
  
  private static void addProfileLogoUrl(ContentValues paramContentValues, MiniProfile paramMiniProfile, String paramString)
  {
    if ((picture != null) && (picture.mediaProcessorImageValue != null)) {
      paramContentValues.put(paramString, picture.mediaProcessorImageValue.id);
    }
  }
  
  private long getActorFromProfileRemoteId(String paramString)
  {
    paramString = dataManager.actorDataManager.getActorForRemoteId(paramString);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToNext())
      {
        long l = ActorDataManager.ActorsForConversationCursor.getId(paramString);
        return l;
      }
      return -1L;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public static ShareContent getShareContentFromString(String paramString)
  {
    DataTemplateParser localDataTemplateParser = com.linkedin.android.datamanager.DataManager.PARSER_FACTORY.createParser();
    try
    {
      paramString = (ShareContent)localDataTemplateParser.parseUnion(new ByteArrayInputStream(paramString.getBytes()), ShareContent.BUILDER);
      return paramString;
    }
    catch (DataReaderException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static String getShareContentJsonString(ShareContent paramShareContent)
  {
    try
    {
      StringWriter localStringWriter = new StringWriter();
      com.linkedin.android.datamanager.DataManager.GENERATOR_FACTORY.createJsonGenerator().generate(paramShareContent, localStringWriter);
      paramShareContent = localStringWriter.toString();
      return paramShareContent;
    }
    catch (JsonGeneratorException paramShareContent) {}
    return null;
  }
  
  private long insertOrUpdateMessage(long paramLong, ContentValues paramContentValues)
  {
    try
    {
      beginTransactionNonExclusive();
      paramLong = safeInsertOrUpdate(paramContentValues, MessengerProvider.MESSAGE_EVENTS_URI, String.valueOf(paramLong), "event_id");
      if (paramLong != -1L) {
        setTransactionSuccessful();
      }
      return paramLong;
    }
    finally
    {
      endTransaction();
    }
  }
  
  private long insertOrUpdateParticipantChangeEventToActor(MessagingProfile paramMessagingProfile, long paramLong, ActorDataManager.ParticipantChangeEventType paramParticipantChangeEventType)
  {
    try
    {
      beginTransactionNonExclusive();
      long l = dataManager.actorDataManager.addOrUpdateActor(messagingMemberValue.miniProfile);
      paramMessagingProfile = new ContentValues();
      paramMessagingProfile.put("actor_id", Long.valueOf(l));
      paramMessagingProfile.put("event_id", Long.valueOf(paramLong));
      paramMessagingProfile.put("participant_change_event_type", paramParticipantChangeEventType.toString());
      paramLong = safeInsertOrUpdate(paramMessagingProfile, MessengerProvider.PARTICIPANT_CHANGE_EVENT_TO_ACTORS_URI, new String[] { String.valueOf(l), String.valueOf(paramLong) }, "actor_id=? AND event_id=?");
      if (paramLong != -1L) {
        setTransactionSuccessful();
      }
      return paramLong;
    }
    finally
    {
      endTransaction();
    }
  }
  
  private long insertOrUpdateParticipantChangeToActors(long paramLong1, long paramLong2, long paramLong3, ActorDataManager.ParticipantChangeEventType paramParticipantChangeEventType)
  {
    try
    {
      beginTransactionNonExclusive();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("actor_id", Long.valueOf(paramLong1));
      localContentValues.put("event_id", Long.valueOf(paramLong3));
      localContentValues.put("participant_change_event_type", paramParticipantChangeEventType.toString());
      paramLong1 = safeInsertOrUpdate(localContentValues, MessengerProvider.PARTICIPANT_CHANGE_EVENT_TO_ACTORS_URI, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong3) }, "actor_id=? AND event_id=?");
      if (paramLong1 != -1L) {
        setTransactionSuccessful();
      }
      return paramLong1;
    }
    finally
    {
      endTransaction();
    }
  }
  
  private void insertOrUpdateParticipants(List<MiniProfile> paramList, ActorDataManager.ParticipantChangeEventType paramParticipantChangeEventType, long paramLong1, long paramLong2, long paramLong3)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MiniProfile localMiniProfile = (MiniProfile)paramList.next();
      long l = dataManager.actorDataManager.addOrUpdateActor(localMiniProfile);
      insertOrUpdateParticipantChangeToActors(l, paramLong3, paramLong2, paramParticipantChangeEventType);
      if (paramParticipantChangeEventType == ActorDataManager.ParticipantChangeEventType.ADD) {
        dataManager.conversationDataManager.addConversationsToActors(paramLong1, l);
      }
    }
  }
  
  /* Error */
  private long saveMessageOrStickerEvent(Event paramEvent, long paramLong, MessengerDatabaseHelper.EventStatus paramEventStatus)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 32	com/linkedin/messengerlib/consumers/EventsDataManager:beginTransactionNonExclusive	()V
    //   4: aload_0
    //   5: aload_1
    //   6: lload_2
    //   7: aload 4
    //   9: invokespecial 1082	com/linkedin/messengerlib/consumers/EventsDataManager:addOrUpdateEvent	(Lcom/linkedin/android/pegasus/gen/voyager/messaging/Event;JLcom/linkedin/messengerlib/database/MessengerDatabaseHelper$EventStatus;)J
    //   12: lstore_2
    //   13: aload_1
    //   14: getfield 163	com/linkedin/android/pegasus/gen/voyager/messaging/Event:eventContent	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/EventContent;
    //   17: getfield 185	com/linkedin/android/pegasus/gen/voyager/messaging/event/EventContent:messageEventValue	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/MessageEvent;
    //   20: ifnull +34 -> 54
    //   23: lload_2
    //   24: ldc2_w 55
    //   27: lcmp
    //   28: ifeq +20 -> 48
    //   31: aload_0
    //   32: aload_1
    //   33: lload_2
    //   34: invokespecial 1084	com/linkedin/messengerlib/consumers/EventsDataManager:addOrUpdateMessage	(Lcom/linkedin/android/pegasus/gen/voyager/messaging/Event;J)J
    //   37: ldc2_w 55
    //   40: lcmp
    //   41: ifeq +7 -> 48
    //   44: aload_0
    //   45: invokevirtual 59	com/linkedin/messengerlib/consumers/EventsDataManager:setTransactionSuccessful	()V
    //   48: aload_0
    //   49: invokevirtual 62	com/linkedin/messengerlib/consumers/EventsDataManager:endTransaction	()V
    //   52: lload_2
    //   53: lreturn
    //   54: aload_1
    //   55: getfield 163	com/linkedin/android/pegasus/gen/voyager/messaging/Event:eventContent	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/EventContent;
    //   58: getfield 204	com/linkedin/android/pegasus/gen/voyager/messaging/event/EventContent:stickerEventValue	Lcom/linkedin/android/pegasus/gen/voyager/messaging/event/StickerEvent;
    //   61: ifnull -13 -> 48
    //   64: lload_2
    //   65: ldc2_w 55
    //   68: lcmp
    //   69: ifeq -21 -> 48
    //   72: aload_0
    //   73: getfield 84	com/linkedin/messengerlib/consumers/EventsDataManager:dataManager	Lcom/linkedin/messengerlib/consumers/DataManager;
    //   76: getfield 1088	com/linkedin/messengerlib/consumers/DataManager:stickersDataManager	Lcom/linkedin/messengerlib/consumers/StickersDataManager;
    //   79: aload_1
    //   80: lload_2
    //   81: invokevirtual 1093	com/linkedin/messengerlib/consumers/StickersDataManager:addOrUpdateStickerEvent	(Lcom/linkedin/android/pegasus/gen/voyager/messaging/Event;J)J
    //   84: ldc2_w 55
    //   87: lcmp
    //   88: ifeq -40 -> 48
    //   91: aload_0
    //   92: invokevirtual 59	com/linkedin/messengerlib/consumers/EventsDataManager:setTransactionSuccessful	()V
    //   95: goto -47 -> 48
    //   98: astore_1
    //   99: aload_0
    //   100: invokevirtual 62	com/linkedin/messengerlib/consumers/EventsDataManager:endTransaction	()V
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	EventsDataManager
    //   0	105	1	paramEvent	Event
    //   0	105	2	paramLong	long
    //   0	105	4	paramEventStatus	MessengerDatabaseHelper.EventStatus
    // Exception table:
    //   from	to	target	type
    //   0	23	98	finally
    //   31	48	98	finally
    //   54	64	98	finally
    //   72	95	98	finally
  }
  
  private int updateEvent(long paramLong, ContentValues paramContentValues)
  {
    try
    {
      beginTransactionNonExclusive();
      String str = paramContentValues.getAsString("remote_id");
      if (str != null)
      {
        Cursor localCursor = appContext.getContentResolver().query(MessengerProvider.EVENTS_URI, null, "remote_id=?", new String[] { str }, null);
        if (localCursor != null)
        {
          while (localCursor.moveToNext()) {
            if (paramLong != EventsDataManager.EventCursor.getId(localCursor))
            {
              Log.e(TAG, "Found duplicate event for remoteId " + str);
              long l = EventsDataManager.EventCursor.getId(localCursor);
              safeDelete(MessengerProvider.EVENTS_URI, new String[] { String.valueOf(l) }, "_id=?");
            }
          }
          localCursor.close();
        }
      }
    }
    finally
    {
      endTransaction();
    }
    int i = appContext.getContentResolver().update(MessengerProvider.EVENTS_URI, paramContentValues, "_id=?", new String[] { String.valueOf(paramLong) });
    if (i != -1) {
      setTransactionSuccessful();
    }
    endTransaction();
    return i;
  }
  
  private int updateEventStatus(long paramLong, String paramString, Long paramLong1, MessengerDatabaseHelper.EventStatus paramEventStatus)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramLong1 != null) {
      localContentValues.put("timestamp", paramLong1);
    }
    localContentValues.put("event_status", paramEventStatus.name());
    if (paramString != null) {
      localContentValues.put("remote_id", paramString);
    }
    return updateEvent(paramLong, localContentValues);
  }
  
  private long updateMessage(long paramLong, ContentValues paramContentValues)
  {
    try
    {
      beginTransactionNonExclusive();
      paramLong = appContext.getContentResolver().update(MessengerProvider.MESSAGE_EVENTS_URI, paramContentValues, "_id=?", new String[] { String.valueOf(paramLong) });
      if (paramLong != -1L) {
        setTransactionSuccessful();
      }
      return paramLong;
    }
    finally
    {
      endTransaction();
    }
  }
  
  final long addOrUpdateEventGroup(MiniGroup paramMiniGroup, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("event_id", Long.valueOf(paramLong));
    localContentValues.put("group_name", groupName);
    try
    {
      beginTransactionNonExclusive();
      paramLong = safeInsertOrUpdate(localContentValues, MessengerProvider.EVENT_CUSTOM_CONTENT_GROUPS_URI, String.valueOf(paramLong), "event_id");
      if (paramLong != -1L) {
        setTransactionSuccessful();
      }
      return paramLong;
    }
    finally
    {
      endTransaction();
    }
  }
  
  public final void failPendingEvents(String paramString, List<PendingEvent> paramList)
  {
    try
    {
      beginTransactionNonExclusive();
      String str = MessengerDatabaseHelper.EventStatus.PENDING.name();
      Object localObject = MessengerProvider.EVENTS_VIEW_URI;
      paramString = getTableCursor(new String[] { paramString, str }, (Uri)localObject, new String[] { "conversation_remote_id", "event_status" }, "timestamp ASC");
      if (paramString != null)
      {
        while (paramString.moveToNext())
        {
          long l1 = EventsDataManager.EventCursor.getId(paramString);
          str = EventsDataManager.EventCursor.getEventRemoteId(paramString);
          long l2 = EventsDataManager.EventCursor.getMessageTimestamp(paramString);
          int j = 1;
          localObject = paramList.iterator();
          do
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (nexteventId != l1);
          int i = 0;
          if (i != 0) {
            updateEventStatus(l1, str, Long.valueOf(l2), MessengerDatabaseHelper.EventStatus.FAILED);
          }
        }
        paramString.close();
      }
    }
    finally
    {
      endTransaction();
      appContext.getContentResolver().notifyChange(MessengerProvider.EVENTS_VIEW_URI, null);
      appContext.getContentResolver().notifyChange(MessengerProvider.CONVERSATIONS_VIEW_URI, null);
    }
    setTransactionSuccessful();
    endTransaction();
    appContext.getContentResolver().notifyChange(MessengerProvider.EVENTS_VIEW_URI, null);
    appContext.getContentResolver().notifyChange(MessengerProvider.CONVERSATIONS_VIEW_URI, null);
  }
  
  public final Cursor getEventForEventRemoteId(String paramString)
  {
    Uri localUri = MessengerProvider.EVENTS_VIEW_URI;
    return getTableCursor(new String[] { paramString }, localUri, new String[] { "remote_id" }, "timestamp ASC");
  }
  
  public final Cursor getEventsForConversationId(long paramLong)
  {
    return getTableCursor(paramLong, MessengerProvider.EVENTS_VIEW_URI, "conversation_id", "timestamp DESC");
  }
  
  public final Cursor getEventsForConversationIdWithEventStatus(long paramLong, MessengerDatabaseHelper.EventStatus paramEventStatus)
  {
    paramEventStatus = paramEventStatus.name();
    Uri localUri = MessengerProvider.EVENTS_VIEW_URI;
    return getTableCursor(new String[] { String.valueOf(paramLong), paramEventStatus }, localUri, new String[] { "conversation_id", "event_status" }, "timestamp ASC");
  }
  
  public final Cursor getSponsoredInMailCursor(long paramLong)
  {
    return getTableCursor(paramLong, MessengerProvider.MESSAGE_EVENT_CUSTOM_CONTENT_SPONSORED_INMAILS_URI, "event_id", null);
  }
  
  public final Cursor getTableCursor(long paramLong, Uri paramUri, String paramString1, String paramString2)
  {
    return getTableCursor(new String[] { String.valueOf(paramLong) }, paramUri, new String[] { paramString1 }, paramString2);
  }
  
  public final Cursor getTableCursor(String[] paramArrayOfString1, Uri paramUri, String[] paramArrayOfString2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfString2.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString2[i];
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" AND ");
      }
      localStringBuilder.append(str).append("=?");
      i += 1;
    }
    return appContext.getContentResolver().query(paramUri, null, localStringBuilder.toString(), paramArrayOfString1, paramString);
  }
  
  public final void removeParticipantChange(int paramInt)
  {
    try
    {
      beginTransactionNonExclusive();
      safeDelete(MessengerProvider.PARTICIPANT_CHANGE_EVENT_TO_ACTORS_URI, new String[] { String.valueOf(paramInt) }, "event_id=?");
      safeDelete(MessengerProvider.EVENTS_URI, new String[] { String.valueOf(paramInt) }, "_id=?");
      setTransactionSuccessful();
      return;
    }
    finally
    {
      endTransaction();
      appContext.getContentResolver().notifyChange(MessengerProvider.EVENTS_VIEW_URI, null);
      appContext.getContentResolver().notifyChange(MessengerProvider.CONVERSATIONS_VIEW_URI, null);
    }
  }
  
  public final void saveAllEvents(List<Event> paramList, long paramLong, MessengerDatabaseHelper.EventStatus paramEventStatus)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      saveEvent((Event)paramList.next(), paramLong, paramEventStatus);
    }
  }
  
  public final void saveAndNotifyEventAsync(Event paramEvent)
  {
    long l1 = -1L;
    Object localObject = UrnUtil.getConversationRemoteIdFromEventUrn(entityUrn);
    localObject = dataManager.conversationDataManager.getConversationByRemoteId((String)localObject);
    long l2 = l1;
    if (localObject != null) {}
    try
    {
      if (((Cursor)localObject).moveToFirst()) {
        l1 = ConversationDataManager.ConversationCursor.getConversationId((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      l2 = l1;
      if (l2 == -1L)
      {
        appContext.getContentResolver().notifyChange(MessengerSyncUris.REQUEST_CONVERSATIONS_SYNC_FROM_NETWORK, null);
        return;
      }
    }
    finally
    {
      ((Cursor)localObject).close();
    }
    DatabaseExecutor.getInstance().execute(new EventsDataManager.1(this, paramEvent, l2));
  }
  
  public final void saveAndNotifyEvents(CollectionTemplate<Event, EventsMetadata> paramCollectionTemplate, long paramLong)
  {
    saveAndNotifyEvents(paramCollectionTemplate, paramLong, false);
  }
  
  /* Error */
  public final void saveAndNotifyEvents(CollectionTemplate<Event, EventsMetadata> paramCollectionTemplate, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1270	com/linkedin/android/pegasus/gen/collection/CollectionTemplate:elements	Ljava/util/List;
    //   4: astore 7
    //   6: aload_0
    //   7: invokevirtual 32	com/linkedin/messengerlib/consumers/EventsDataManager:beginTransactionNonExclusive	()V
    //   10: iload 4
    //   12: ifne +155 -> 167
    //   15: new 8	com/linkedin/messengerlib/consumers/EventsDataManager$EventsGapDetector
    //   18: dup
    //   19: aload_0
    //   20: aload 7
    //   22: lload_2
    //   23: invokespecial 1273	com/linkedin/messengerlib/consumers/EventsDataManager$EventsGapDetector:<init>	(Lcom/linkedin/messengerlib/consumers/EventsDataManager;Ljava/util/List;J)V
    //   26: invokevirtual 1276	com/linkedin/messengerlib/consumers/EventsDataManager$EventsGapDetector:hasGap	()Z
    //   29: ifeq +138 -> 167
    //   32: getstatic 22	com/linkedin/messengerlib/consumers/EventsDataManager:TAG	Ljava/lang/String;
    //   35: ldc_w 1278
    //   38: iconst_1
    //   39: anewarray 451	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: lload_2
    //   45: invokestatic 302	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   48: aastore
    //   49: invokestatic 1281	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: invokestatic 1284	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   55: pop
    //   56: aload_0
    //   57: lload_2
    //   58: getstatic 1287	com/linkedin/messengerlib/database/MessengerDatabaseHelper$EventStatus:RECEIVED	Lcom/linkedin/messengerlib/database/MessengerDatabaseHelper$EventStatus;
    //   61: invokevirtual 1289	com/linkedin/messengerlib/consumers/EventsDataManager:getEventsForConversationIdWithEventStatus	(JLcom/linkedin/messengerlib/database/MessengerDatabaseHelper$EventStatus;)Landroid/database/Cursor;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +101 -> 167
    //   69: aload_1
    //   70: invokeinterface 1234 1 0
    //   75: ifeq +86 -> 161
    //   78: aload_1
    //   79: invokestatic 1171	com/linkedin/messengerlib/consumers/EventsDataManager$EventCursor:getMessageTimestamp	(Landroid/database/Cursor;)J
    //   82: lstore 5
    //   84: new 1110	java/lang/StringBuilder
    //   87: dup
    //   88: ldc 114
    //   90: invokespecial 1114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: astore 9
    //   95: aload 9
    //   97: ldc_w 1291
    //   100: invokevirtual 1118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 9
    //   106: ldc -122
    //   108: invokevirtual 1118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 9
    //   114: ldc_w 1293
    //   117: invokevirtual 1118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: getstatic 38	com/linkedin/messengerlib/database/MessengerProvider:EVENTS_URI	Landroid/net/Uri;
    //   124: astore 8
    //   126: aload 9
    //   128: invokevirtual 1119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore 9
    //   133: aload_0
    //   134: aload 8
    //   136: iconst_2
    //   137: anewarray 40	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: lload_2
    //   143: invokestatic 302	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: lload 5
    //   151: invokestatic 302	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   154: aastore
    //   155: aload 9
    //   157: invokevirtual 1131	com/linkedin/messengerlib/consumers/EventsDataManager:safeDelete	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;)I
    //   160: pop
    //   161: aload_1
    //   162: invokeinterface 975 1 0
    //   167: iload 4
    //   169: ifeq +52 -> 221
    //   172: getstatic 132	com/linkedin/messengerlib/database/MessengerDatabaseHelper$EventStatus:PUSHED	Lcom/linkedin/messengerlib/database/MessengerDatabaseHelper$EventStatus;
    //   175: astore_1
    //   176: aload_0
    //   177: aload 7
    //   179: lload_2
    //   180: aload_1
    //   181: invokevirtual 1295	com/linkedin/messengerlib/consumers/EventsDataManager:saveAllEvents	(Ljava/util/List;JLcom/linkedin/messengerlib/database/MessengerDatabaseHelper$EventStatus;)V
    //   184: aload_0
    //   185: invokevirtual 59	com/linkedin/messengerlib/consumers/EventsDataManager:setTransactionSuccessful	()V
    //   188: aload_0
    //   189: invokevirtual 62	com/linkedin/messengerlib/consumers/EventsDataManager:endTransaction	()V
    //   192: aload_0
    //   193: getfield 798	com/linkedin/messengerlib/consumers/EventsDataManager:appContext	Landroid/content/Context;
    //   196: invokevirtual 1101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   199: getstatic 1156	com/linkedin/messengerlib/database/MessengerProvider:EVENTS_VIEW_URI	Landroid/net/Uri;
    //   202: aconst_null
    //   203: invokevirtual 1185	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   206: aload_0
    //   207: getfield 798	com/linkedin/messengerlib/consumers/EventsDataManager:appContext	Landroid/content/Context;
    //   210: invokevirtual 1101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   213: getstatic 1188	com/linkedin/messengerlib/database/MessengerProvider:CONVERSATIONS_VIEW_URI	Landroid/net/Uri;
    //   216: aconst_null
    //   217: invokevirtual 1185	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   220: return
    //   221: getstatic 1287	com/linkedin/messengerlib/database/MessengerDatabaseHelper$EventStatus:RECEIVED	Lcom/linkedin/messengerlib/database/MessengerDatabaseHelper$EventStatus;
    //   224: astore_1
    //   225: goto -49 -> 176
    //   228: astore_1
    //   229: aload_0
    //   230: invokevirtual 62	com/linkedin/messengerlib/consumers/EventsDataManager:endTransaction	()V
    //   233: aload_0
    //   234: getfield 798	com/linkedin/messengerlib/consumers/EventsDataManager:appContext	Landroid/content/Context;
    //   237: invokevirtual 1101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   240: getstatic 1156	com/linkedin/messengerlib/database/MessengerProvider:EVENTS_VIEW_URI	Landroid/net/Uri;
    //   243: aconst_null
    //   244: invokevirtual 1185	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   247: aload_0
    //   248: getfield 798	com/linkedin/messengerlib/consumers/EventsDataManager:appContext	Landroid/content/Context;
    //   251: invokevirtual 1101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   254: getstatic 1188	com/linkedin/messengerlib/database/MessengerProvider:CONVERSATIONS_VIEW_URI	Landroid/net/Uri;
    //   257: aconst_null
    //   258: invokevirtual 1185	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   261: aload_1
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	EventsDataManager
    //   0	263	1	paramCollectionTemplate	CollectionTemplate<Event, EventsMetadata>
    //   0	263	2	paramLong	long
    //   0	263	4	paramBoolean	boolean
    //   82	68	5	l	long
    //   4	174	7	localList	List
    //   124	11	8	localUri	Uri
    //   93	63	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	10	228	finally
    //   15	65	228	finally
    //   69	161	228	finally
    //   161	167	228	finally
    //   172	176	228	finally
    //   176	188	228	finally
    //   221	225	228	finally
  }
  
  public final long saveEvent(Event paramEvent, long paramLong, MessengerDatabaseHelper.EventStatus paramEventStatus)
  {
    switch (EventsDataManager.2.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$messaging$event$EventSubtype[subtype.ordinal()])
    {
    default: 
      Log.e(TAG, "unknown event type: " + subtype.name());
      return -1L;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      return saveMessageOrStickerEvent(paramEvent, paramLong, paramEventStatus);
    }
    ParticipantChangeEventModel localParticipantChangeEventModel = new ParticipantChangeEventModel(eventContent.participantChangeEventValue);
    Object localObject;
    if (participantChangeEvent.addedParticipants.size() > 0)
    {
      localObject = participantChangeEvent.addedParticipants;
      paramLong = addOrUpdateEvent(paramEvent, paramLong, paramEventStatus);
      if ((paramLong == -1L) || (localObject == null)) {
        return paramLong;
      }
      paramEventStatus = ((List)localObject).iterator();
      label176:
      do
      {
        if (!paramEventStatus.hasNext()) {
          break;
        }
        localObject = (MessagingProfile)paramEventStatus.next();
      } while (localObject == null);
      if (participantChangeEvent.addedParticipants.size() <= 0) {
        break label265;
      }
      paramEvent = ActorDataManager.ParticipantChangeEventType.ADD;
    }
    for (;;)
    {
      insertOrUpdateParticipantChangeEventToActor((MessagingProfile)localObject, paramLong, paramEvent);
      break label176;
      if (participantChangeEvent.hasRemovedParticipants)
      {
        localObject = participantChangeEvent.removedParticipants;
        break;
      }
      localObject = null;
      break;
      label265:
      if (participantChangeEvent.hasRemovedParticipants) {
        paramEvent = ActorDataManager.ParticipantChangeEventType.REMOVE;
      } else {
        paramEvent = ActorDataManager.ParticipantChangeEventType.UNKNOWN;
      }
    }
    return paramLong;
  }
  
  public final long saveOutgoingMessage(String paramString1, List<File> paramList, EventSubtype paramEventSubtype, long paramLong, String paramString2, MiniProfile paramMiniProfile)
  {
    try
    {
      beginTransactionNonExclusive();
      paramLong = addOutgoingMessage(paramString1, paramList, paramEventSubtype, paramLong, paramString2, paramMiniProfile);
      if (paramLong != -1L) {
        setTransactionSuccessful();
      }
      return paramLong;
    }
    finally
    {
      endTransaction();
      appContext.getContentResolver().notifyChange(MessengerProvider.EVENTS_VIEW_URI, null);
      appContext.getContentResolver().notifyChange(MessengerProvider.CONVERSATIONS_VIEW_URI, null);
    }
  }
  
  public final long saveOutgoingStickerEvent(LocalSticker paramLocalSticker, EventSubtype paramEventSubtype, long paramLong, String paramString, MiniProfile paramMiniProfile)
  {
    paramLong = addOutgoingStickerEvent(paramLocalSticker, paramEventSubtype, paramLong, paramString, paramMiniProfile);
    appContext.getContentResolver().notifyChange(MessengerProvider.EVENTS_VIEW_URI, null);
    appContext.getContentResolver().notifyChange(MessengerProvider.CONVERSATIONS_VIEW_URI, null);
    return paramLong;
  }
  
  public final long saveParticipantChange(List<MiniProfile> paramList, long paramLong, String paramString, MiniProfile paramMiniProfile, ActorDataManager.ParticipantChangeEventType paramParticipantChangeEventType)
  {
    try
    {
      beginTransactionNonExclusive();
      paramLong = addOutgoingParticipantChange(paramList, paramLong, paramString, paramMiniProfile, paramParticipantChangeEventType);
      if (paramLong != -1L) {
        setTransactionSuccessful();
      }
      return paramLong;
    }
    finally
    {
      endTransaction();
      appContext.getContentResolver().notifyChange(MessengerProvider.EVENTS_VIEW_URI, null);
      appContext.getContentResolver().notifyChange(MessengerProvider.CONVERSATIONS_VIEW_URI, null);
    }
  }
  
  public final void setEventStatus(long paramLong, String paramString, Long paramLong1, MessengerDatabaseHelper.EventStatus paramEventStatus)
  {
    try
    {
      beginTransactionNonExclusive();
      Long localLong = paramLong1;
      if (paramLong1 != null)
      {
        localLong = paramLong1;
        if (paramLong1.longValue() == -1L) {
          localLong = Long.valueOf(System.currentTimeMillis());
        }
      }
      if (updateEventStatus(paramLong, paramString, localLong, paramEventStatus) != -1) {
        setTransactionSuccessful();
      }
      return;
    }
    finally
    {
      endTransaction();
      appContext.getContentResolver().notifyChange(MessengerProvider.EVENTS_VIEW_URI, null);
      appContext.getContentResolver().notifyChange(MessengerProvider.CONVERSATIONS_VIEW_URI, null);
    }
  }
  
  /* Error */
  public final void setMessageAttachments(long paramLong, List<File> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 32	com/linkedin/messengerlib/consumers/EventsDataManager:beginTransactionNonExclusive	()V
    //   4: aload_0
    //   5: getfield 84	com/linkedin/messengerlib/consumers/EventsDataManager:dataManager	Lcom/linkedin/messengerlib/consumers/DataManager;
    //   8: getfield 596	com/linkedin/messengerlib/consumers/DataManager:attachmentDataManager	Lcom/linkedin/messengerlib/consumers/AttachmentDataManager;
    //   11: lload_1
    //   12: invokevirtual 602	com/linkedin/messengerlib/consumers/AttachmentDataManager:deleteAttachments	(J)V
    //   15: aload_0
    //   16: getfield 84	com/linkedin/messengerlib/consumers/EventsDataManager:dataManager	Lcom/linkedin/messengerlib/consumers/DataManager;
    //   19: getfield 596	com/linkedin/messengerlib/consumers/DataManager:attachmentDataManager	Lcom/linkedin/messengerlib/consumers/AttachmentDataManager;
    //   22: aload_3
    //   23: lload_1
    //   24: invokevirtual 606	com/linkedin/messengerlib/consumers/AttachmentDataManager:addOrUpdateAttachments	(Ljava/util/List;J)I
    //   27: pop
    //   28: aload_3
    //   29: invokeinterface 366 1 0
    //   34: ifne +70 -> 104
    //   37: iconst_1
    //   38: istore 4
    //   40: new 44	android/content/ContentValues
    //   43: dup
    //   44: invokespecial 66	android/content/ContentValues:<init>	()V
    //   47: astore_3
    //   48: aload_3
    //   49: ldc_w 549
    //   52: iload 4
    //   54: invokestatic 347	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: invokevirtual 350	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   60: aload_0
    //   61: lload_1
    //   62: aload_3
    //   63: invokespecial 1353	com/linkedin/messengerlib/consumers/EventsDataManager:updateMessage	(JLandroid/content/ContentValues;)J
    //   66: pop2
    //   67: aload_0
    //   68: invokevirtual 59	com/linkedin/messengerlib/consumers/EventsDataManager:setTransactionSuccessful	()V
    //   71: aload_0
    //   72: invokevirtual 62	com/linkedin/messengerlib/consumers/EventsDataManager:endTransaction	()V
    //   75: aload_0
    //   76: getfield 798	com/linkedin/messengerlib/consumers/EventsDataManager:appContext	Landroid/content/Context;
    //   79: invokevirtual 1101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   82: getstatic 1156	com/linkedin/messengerlib/database/MessengerProvider:EVENTS_VIEW_URI	Landroid/net/Uri;
    //   85: aconst_null
    //   86: invokevirtual 1185	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   89: aload_0
    //   90: getfield 798	com/linkedin/messengerlib/consumers/EventsDataManager:appContext	Landroid/content/Context;
    //   93: invokevirtual 1101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   96: getstatic 1188	com/linkedin/messengerlib/database/MessengerProvider:CONVERSATIONS_VIEW_URI	Landroid/net/Uri;
    //   99: aconst_null
    //   100: invokevirtual 1185	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   103: return
    //   104: iconst_0
    //   105: istore 4
    //   107: goto -67 -> 40
    //   110: astore_3
    //   111: aload_0
    //   112: invokevirtual 62	com/linkedin/messengerlib/consumers/EventsDataManager:endTransaction	()V
    //   115: aload_0
    //   116: getfield 798	com/linkedin/messengerlib/consumers/EventsDataManager:appContext	Landroid/content/Context;
    //   119: invokevirtual 1101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   122: getstatic 1156	com/linkedin/messengerlib/database/MessengerProvider:EVENTS_VIEW_URI	Landroid/net/Uri;
    //   125: aconst_null
    //   126: invokevirtual 1185	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   129: aload_0
    //   130: getfield 798	com/linkedin/messengerlib/consumers/EventsDataManager:appContext	Landroid/content/Context;
    //   133: invokevirtual 1101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   136: getstatic 1188	com/linkedin/messengerlib/database/MessengerProvider:CONVERSATIONS_VIEW_URI	Landroid/net/Uri;
    //   139: aconst_null
    //   140: invokevirtual 1185	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   143: aload_3
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	EventsDataManager
    //   0	145	1	paramLong	long
    //   0	145	3	paramList	List<File>
    //   38	68	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	37	110	finally
    //   40	71	110	finally
  }
  
  public final String unparcelAttributedText(String paramString)
  {
    String str = "";
    Cursor localCursor = getEventForEventRemoteId(paramString);
    paramString = str;
    if (localCursor != null) {
      paramString = str;
    }
    try
    {
      if (localCursor.moveToFirst())
      {
        str = localCursor.getString(localCursor.getColumnIndex("attributed_body"));
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          paramString = "";
        }
      }
      return paramString;
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.consumers.EventsDataManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */