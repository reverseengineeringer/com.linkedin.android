package com.linkedin.android.growth.utils;

import android.text.TextUtils;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel;
import com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportDropEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportDropReason;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportEmailProvider;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationCreateEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationDiscardReason;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportSubmitEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.InvitationSentTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class OwlTrackingUtils
{
  private static final String TAG = OwlTrackingUtils.class.getSimpleName();
  
  public static InvitationCountPerChannel buildInvitationCountPerChannel(LixManager paramLixManager, int paramInt1, int paramInt2)
  {
    if (!"control".equals(paramLixManager.getTreatment(Lix.GROWTH_ABOOK_IMPORT_INVITATION_COUNT_PER_CHANNEL))) {
      for (;;)
      {
        Integer localInteger;
        try
        {
          paramLixManager = new InvitationCountPerChannel.Builder();
          localInteger = Integer.valueOf(paramInt1);
          if (localInteger == null)
          {
            hasEmailCount = false;
            emailCount = 0;
            localInteger = Integer.valueOf(paramInt2);
            if (localInteger == null)
            {
              hasSmsCount = false;
              smsCount = 0;
              return paramLixManager.build(RecordTemplate.Flavor.RECORD);
            }
          }
          else
          {
            hasEmailCount = true;
            emailCount = localInteger.intValue();
            continue;
          }
          hasSmsCount = true;
        }
        catch (BuilderException paramLixManager)
        {
          Log.e(TAG, "Exception when building InvitationCountPerChannel", paramLixManager);
          CrashReporter.reportNonFatal(new Throwable("Exception when building InvitationCountPerChannel", paramLixManager));
          return null;
        }
        smsCount = localInteger.intValue();
      }
    }
    return null;
  }
  
  public static InvitationCountPerChannel buildInvitationCountPerChannelForEmail(LixManager paramLixManager, int paramInt)
  {
    return buildInvitationCountPerChannel(paramLixManager, paramInt, 0);
  }
  
  public static InvitationCountPerChannel buildInvitationCountPerChannelForSms(LixManager paramLixManager, int paramInt)
  {
    return buildInvitationCountPerChannel(paramLixManager, 0, paramInt);
  }
  
  public static String generateAbookImportTransactionId()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  public static AbookImportImpressionEvent.Builder getAbookImportImpressionEventBuilder(String paramString1, String paramString2)
  {
    AbookImportImpressionEvent.Builder localBuilder = new AbookImportImpressionEvent.Builder();
    if (paramString1 == null)
    {
      hasAbookImportTransactionId = false;
      abookImportTransactionId = null;
      paramString1 = AbookImportEmailProvider.OTHERS;
      if (paramString1 != null) {
        break label118;
      }
      hasAutoSelectedEmailProvider = false;
      autoSelectedEmailProvider = null;
      label40:
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "mobile-voyager-other";
      }
      if (paramString1 != null) {
        break label131;
      }
      hasSource = false;
      source = null;
      label66:
      paramString1 = Collections.emptyList();
      if (paramString1 != null) {
        break label144;
      }
      hasOrderOfEmailProviderss = false;
    }
    for (orderOfEmailProviderss = null;; orderOfEmailProviderss = paramString1)
    {
      paramString1 = Integer.valueOf(0);
      if (paramString1 != null) {
        break label157;
      }
      hasSocialProofCount = false;
      socialProofCount = 0;
      return localBuilder;
      hasAbookImportTransactionId = true;
      abookImportTransactionId = paramString1;
      break;
      label118:
      hasAutoSelectedEmailProvider = true;
      autoSelectedEmailProvider = paramString1;
      break label40;
      label131:
      hasSource = true;
      source = paramString1;
      break label66;
      label144:
      hasOrderOfEmailProviderss = true;
    }
    label157:
    hasSocialProofCount = true;
    socialProofCount = paramString1.intValue();
    return localBuilder;
  }
  
  public static AbookImportInvitationCreateEvent.Builder getAbookImportInvitationCreateEventBuilder(String paramString1, String paramString2, InvitationSentTo paramInvitationSentTo, int paramInt, LixManager paramLixManager)
  {
    AbookImportInvitationCreateEvent.Builder localBuilder = new AbookImportInvitationCreateEvent.Builder().setAbookImportTransactionId(paramString2);
    if (paramInvitationSentTo == null)
    {
      hasInvitationType = false;
      invitationType = null;
      paramInvitationSentTo = Integer.valueOf(paramInt);
      if (paramInvitationSentTo != null) {
        break label122;
      }
      hasNumberOfInvitationsSent = false;
      numberOfInvitationsSent = 0;
      label50:
      paramInvitationSentTo = new ArrayList(0);
      hasInvitationReceiptEmails = true;
      invitationReceiptEmails = paramInvitationSentTo;
      if (!shouldAddAbookFetchTransactionId(paramString1, paramString2, paramLixManager)) {
        break label155;
      }
      if (paramString1 != null) {
        break label140;
      }
      hasAbookFetchTransactionId = false;
    }
    for (abookFetchTransactionId = null;; abookFetchTransactionId = paramString1)
    {
      localBuilder.setAbookImportTransactionId(paramString2);
      return localBuilder;
      hasInvitationType = true;
      invitationType = paramInvitationSentTo;
      break;
      label122:
      hasNumberOfInvitationsSent = true;
      numberOfInvitationsSent = paramInvitationSentTo.intValue();
      break label50;
      label140:
      hasAbookFetchTransactionId = true;
    }
    label155:
    localBuilder.setAbookImportTransactionId(paramString1);
    return localBuilder;
  }
  
  public static AbookImportInvitationImpressionEvent.Builder getAbookImportInvitationImpressionEventBuilder(String paramString1, String paramString2, LixManager paramLixManager)
  {
    AbookImportInvitationImpressionEvent.Builder localBuilder = new AbookImportInvitationImpressionEvent.Builder().setAbookImportTransactionId(paramString2);
    Integer localInteger = Integer.valueOf(0);
    if (localInteger == null)
    {
      hasNumberOfContactsPortedFromPhoneNumber = false;
      numberOfContactsPortedFromPhoneNumber = 0;
      localInteger = Integer.valueOf(0);
      if (localInteger != null) {
        break label123;
      }
      hasNumberOfExistingContacts = false;
      numberOfExistingContacts = 0;
      label54:
      localInteger = Integer.valueOf(0);
      if (localInteger != null) {
        break label140;
      }
      hasNumberOfNewContacts = false;
      numberOfNewContacts = 0;
      label75:
      if (!shouldAddAbookFetchTransactionId(paramString1, paramString2, paramLixManager)) {
        break label170;
      }
      if (paramString1 != null) {
        break label157;
      }
      hasAbookFetchTransactionId = false;
    }
    for (abookFetchTransactionId = null;; abookFetchTransactionId = paramString1)
    {
      localBuilder.setAbookImportTransactionId(paramString2);
      return localBuilder;
      hasNumberOfContactsPortedFromPhoneNumber = true;
      numberOfContactsPortedFromPhoneNumber = localInteger.intValue();
      break;
      label123:
      hasNumberOfExistingContacts = true;
      numberOfExistingContacts = localInteger.intValue();
      break label54;
      label140:
      hasNumberOfNewContacts = true;
      numberOfNewContacts = localInteger.intValue();
      break label75;
      label157:
      hasAbookFetchTransactionId = true;
    }
    label170:
    localBuilder.setAbookImportTransactionId(paramString1);
    return localBuilder;
  }
  
  private static boolean shouldAddAbookFetchTransactionId(String paramString1, String paramString2, LixManager paramLixManager)
  {
    return ("enabled".equalsIgnoreCase(paramLixManager.getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS))) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!paramString1.equals(paramString2));
  }
  
  public static void trackAbookImportDropEvent(Tracker paramTracker, LixManager paramLixManager, String paramString, AbookImportDropReason paramAbookImportDropReason)
  {
    if (!"control".equals(paramLixManager.getTreatment(Lix.GROWTH_ABOOK_IMPORT_DROP_EVENT)))
    {
      paramLixManager = new AbookImportDropEvent.Builder();
      if (paramString != null) {
        break label59;
      }
      hasAbookImportTransactionId = false;
      abookImportTransactionId = null;
      if (paramAbookImportDropReason != null) {
        break label72;
      }
      hasAbookImportDropReason = false;
    }
    for (abookImportDropReason = null;; abookImportDropReason = paramAbookImportDropReason)
    {
      paramTracker.send(paramLixManager);
      return;
      label59:
      hasAbookImportTransactionId = true;
      abookImportTransactionId = paramString;
      break;
      label72:
      hasAbookImportDropReason = true;
    }
  }
  
  public static String trackAbookImportImpressionEvent(Tracker paramTracker, LixManager paramLixManager, String paramString)
  {
    String str = "";
    if (!"control".equals(paramLixManager.getTreatment(Lix.ABOOK_IMPORT_IMPRESSION_EVENT)))
    {
      str = generateAbookImportTransactionId();
      paramTracker.send(getAbookImportImpressionEventBuilder(str, paramString));
    }
    return str;
  }
  
  public static void trackAbookImportInvitationImpressionDiscardEvent(Tracker paramTracker, LixManager paramLixManager, String paramString, AbookImportInvitationDiscardReason paramAbookImportInvitationDiscardReason)
  {
    if (!"control".equals(paramLixManager.getTreatment(Lix.GROWTH_ABOOK_IMPORT_INVITATION_IMPRESSION_DISCARD_EVENT))) {
      for (;;)
      {
        try
        {
          paramLixManager = new AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason.Builder();
          if (paramAbookImportInvitationDiscardReason == null)
          {
            hasAbookImportInvitationDiscardReasonValue = false;
            abookImportInvitationDiscardReasonValue = null;
            paramLixManager = new AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason(abookImportInvitationDiscardReasonValue, hasAbookImportInvitationDiscardReasonValue);
            paramAbookImportInvitationDiscardReason = new AbookImportInvitationImpressionDiscardEvent.Builder();
            if (paramString == null)
            {
              hasAbookImportTransactionId = false;
              abookImportTransactionId = null;
              hasAbookImportInvitationDiscardReason = true;
              abookImportInvitationDiscardReason = paramLixManager;
              paramTracker.send(paramAbookImportInvitationDiscardReason);
            }
          }
          else
          {
            hasAbookImportInvitationDiscardReasonValue = true;
            abookImportInvitationDiscardReasonValue = paramAbookImportInvitationDiscardReason;
            continue;
          }
          hasAbookImportTransactionId = true;
        }
        catch (BuilderException paramTracker)
        {
          Log.e(TAG, "Exception when building AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason", paramTracker);
          CrashReporter.reportNonFatal(new Throwable("Exception when building AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason", paramTracker));
          return;
        }
        abookImportTransactionId = paramString;
      }
    }
  }
  
  public static void trackAbookImportSubmitEvent(String paramString, LixManager paramLixManager, Tracker paramTracker)
  {
    if (!"control".equals(paramLixManager.getTreatment(Lix.LIX_ABOOK_IMPORT_SUBMIT_EVENT)))
    {
      paramLixManager = new AbookImportSubmitEvent.Builder();
      if (paramString != null) {
        break label45;
      }
      hasAbookImportTransactionId = false;
    }
    for (abookImportTransactionId = null;; abookImportTransactionId = paramString)
    {
      paramTracker.send(paramLixManager);
      return;
      label45:
      hasAbookImportTransactionId = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.utils.OwlTrackingUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */