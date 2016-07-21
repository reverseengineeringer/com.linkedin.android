package com.linkedin.android.feed.tracking;

import com.linkedin.android.feed.events.MentionStartSuggestionTrackingEvent;
import com.linkedin.android.feed.mentions.MentionsUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionActionType;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit.Builder;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionType;
import com.linkedin.gen.avro2pegasus.events.search.SearchHeader;
import com.linkedin.gen.avro2pegasus.events.search.SearchHeader.Builder;
import com.linkedin.gen.avro2pegasus.events.search.SearchPlatformType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class MentionsTracking
{
  private static MentionResultHit createMentionResultHit(boolean paramBoolean, int paramInt, TypeaheadHit.HitInfo paramHitInfo)
  {
    if (paramHitInfo != null) {
      for (;;)
      {
        MentionResultHit.Builder localBuilder;
        try
        {
          localBuilder = new MentionResultHit.Builder();
          paramHitInfo = MentionsUtils.getEntityUrn(paramHitInfo);
          if (paramHitInfo == null)
          {
            hasEntityUrn = false;
            entityUrn = null;
            paramHitInfo = Boolean.valueOf(paramBoolean);
            if ((paramHitInfo == null) || (!paramHitInfo.booleanValue()))
            {
              hasIsCacheHit = false;
              isCacheHit = false;
              paramHitInfo = new ListPosition.Builder().setIndex(Integer.valueOf(paramInt)).build(RecordTemplate.Flavor.RECORD);
              hasPosition = true;
              position = paramHitInfo;
              return localBuilder.build(RecordTemplate.Flavor.RECORD);
            }
          }
          else
          {
            hasEntityUrn = true;
            entityUrn = paramHitInfo;
            continue;
          }
          hasIsCacheHit = true;
        }
        catch (BuilderException paramHitInfo)
        {
          Util.safeThrow$7a8b4789(new RuntimeException(paramHitInfo));
          return null;
        }
        isCacheHit = paramHitInfo.booleanValue();
      }
    }
    return null;
  }
  
  public static SearchHeader createSearchHeader(String paramString1, SearchPlatformType paramSearchPlatformType, String paramString2)
  {
    try
    {
      paramString1 = new SearchHeader.Builder().setRawSearchId(paramString2).setQuery(paramString1).setPlatform(paramSearchPlatformType).build(RecordTemplate.Flavor.RECORD);
      return paramString1;
    }
    catch (BuilderException paramString1)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramString1));
    }
    return null;
  }
  
  public static void fireMentionSuggestionActionEvent(FragmentComponent paramFragmentComponent, String paramString1, String paramString2, MentionActionType paramMentionActionType, MentionResultHit paramMentionResultHit)
  {
    MentionSuggestionActionEvent.Builder localBuilder;
    if (isMentionTrackingEnabled(paramFragmentComponent))
    {
      paramString1 = createSearchHeader(paramString1, SearchPlatformType.TYPEAHEAD, UUID.randomUUID().toString());
      paramFragmentComponent = paramFragmentComponent.tracker();
      localBuilder = new MentionSuggestionActionEvent.Builder();
      if (paramString1 != null) {
        break label109;
      }
      hasSearchHeader = false;
      searchHeader = null;
      if (paramMentionActionType != null) {
        break label124;
      }
      hasActionType = false;
      actionType = null;
      label69:
      if (paramString2 != null) {
        break label139;
      }
      hasMentionWorkflowId = false;
      mentionWorkflowId = null;
      label85:
      if (paramMentionResultHit != null) {
        break label154;
      }
      hasResult = false;
    }
    for (result = null;; result = paramMentionResultHit)
    {
      paramFragmentComponent.send(localBuilder);
      return;
      label109:
      hasSearchHeader = true;
      searchHeader = paramString1;
      break;
      label124:
      hasActionType = true;
      actionType = paramMentionActionType;
      break label69;
      label139:
      hasMentionWorkflowId = true;
      mentionWorkflowId = paramString2;
      break label85;
      label154:
      hasResult = true;
    }
  }
  
  public static void fireMentionSuggestionStartEvent(FragmentComponent paramFragmentComponent, MentionStartSuggestionTrackingEvent paramMentionStartSuggestionTrackingEvent, Update paramUpdate, String paramString1, String paramString2, String paramString3)
  {
    if (!isMentionTrackingEnabled(paramFragmentComponent)) {
      return;
    }
    Object localObject3 = null;
    MentionSuggestionStartEvent.Builder localBuilder = null;
    Object localObject2 = localObject3;
    Object localObject1 = localBuilder;
    if (paramUpdate != null)
    {
      localObject2 = localObject3;
      localObject1 = localBuilder;
      if (tracking != null)
      {
        localObject2 = localObject3;
        localObject1 = localBuilder;
        if (urn != null)
        {
          localObject2 = localObject3;
          localObject1 = localBuilder;
          if (entityUrn != null)
          {
            localObject2 = entityUrn.toString();
            localObject1 = urn.toString();
          }
        }
      }
    }
    try
    {
      localObject1 = new TrackingObject.Builder().setObjectUrn((String)localObject1).setTrackingId(tracking.trackingId).build(RecordTemplate.Flavor.RECORD);
      if (isExplicit)
      {
        paramUpdate = MentionType.EXPLICIT;
        if (!isExplicit) {
          break label329;
        }
        paramMentionStartSuggestionTrackingEvent = "@";
        paramString2 = createSearchHeader(paramString2, SearchPlatformType.TYPEAHEAD, UUID.randomUUID().toString());
        paramFragmentComponent = paramFragmentComponent.tracker();
        paramString3 = TrackingUtils.makeControlUrnFromControlName(paramFragmentComponent, paramString3);
        localBuilder = new MentionSuggestionStartEvent.Builder();
        if (paramString2 != null) {
          break label334;
        }
        hasSearchHeader = false;
        searchHeader = null;
        if (paramString1 != null) {
          break label350;
        }
        hasMentionWorkflowId = false;
        mentionWorkflowId = null;
        if (paramString3 != null) {
          break label365;
        }
        hasAssociatedInputControlUrn = false;
        associatedInputControlUrn = null;
        if (localObject2 != null) {
          break label381;
        }
        hasAssociatedEntityUrn = false;
        associatedEntityUrn = null;
        if (localObject1 != null) {
          break label397;
        }
        hasRootObject = false;
        rootObject = null;
        if (paramUpdate != null) {
          break label413;
        }
        hasMentionType = false;
        mentionType = null;
        if (paramMentionStartSuggestionTrackingEvent != null) {
          break label428;
        }
        hasMentionStartOperator = false;
        mentionStartOperator = null;
        paramFragmentComponent.send(localBuilder);
      }
    }
    catch (BuilderException paramUpdate)
    {
      for (;;)
      {
        Util.safeThrow$7a8b4789(new RuntimeException(paramUpdate));
        localObject1 = localBuilder;
        continue;
        paramUpdate = MentionType.IMPLICIT;
        continue;
        label329:
        paramMentionStartSuggestionTrackingEvent = null;
        continue;
        label334:
        hasSearchHeader = true;
        searchHeader = paramString2;
        continue;
        label350:
        hasMentionWorkflowId = true;
        mentionWorkflowId = paramString1;
        continue;
        label365:
        hasAssociatedInputControlUrn = true;
        associatedInputControlUrn = paramString3;
        continue;
        label381:
        hasAssociatedEntityUrn = true;
        associatedEntityUrn = ((String)localObject2);
        continue;
        label397:
        hasRootObject = true;
        rootObject = ((TrackingObject)localObject1);
        continue;
        label413:
        hasMentionType = true;
        mentionType = paramUpdate;
        continue;
        label428:
        hasMentionStartOperator = true;
        mentionStartOperator = paramMentionStartSuggestionTrackingEvent;
      }
    }
  }
  
  public static Map<String, MentionResultHit> getMentionResultHits(List<TypeaheadHit> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (CollectionUtils.isEmpty(paramList))
    {
      localObject = Collections.emptyMap();
      return (Map<String, MentionResultHit>)localObject;
    }
    HashMap localHashMap = new HashMap(paramList.size());
    int i = 1;
    for (;;)
    {
      localObject = localHashMap;
      if (i > paramList.size()) {
        break;
      }
      localObject = createMentionResultHit(paramBoolean, i, get1hitInfo);
      if (localObject != null) {
        localHashMap.put(entityUrn, localObject);
      }
      i += 1;
    }
  }
  
  public static boolean isMentionTrackingEnabled(FragmentComponent paramFragmentComponent)
  {
    return paramFragmentComponent.lixManager().getTreatment(Lix.FEED_MENTIONS_TRACKING).equals("enabled");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.MentionsTracking
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */