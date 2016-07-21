package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Action
  implements RecordTemplate<Action>
{
  public static final ActionBuilder BUILDER = ActionBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final Map<String, String> actionPostData;
  public final String actionUrl;
  public final List<Action> additionalActions;
  public final List<AdditionalOptions> additionalOptions;
  public final String body;
  public final boolean hasActionPostData;
  public final boolean hasActionUrl;
  public final boolean hasAdditionalActions;
  public final boolean hasAdditionalOptions;
  public final boolean hasBody;
  public final boolean hasTitle;
  public final boolean hasTrackingId;
  public final boolean hasType;
  public final String title;
  public final String trackingId;
  public final ActionType type;
  
  Action(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, ActionType paramActionType, List<Action> paramList, List<AdditionalOptions> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    title = paramString1;
    body = paramString2;
    trackingId = paramString3;
    actionUrl = paramString4;
    if (paramMap == null)
    {
      paramString1 = null;
      actionPostData = paramString1;
      type = paramActionType;
      if (paramList != null) {
        break label130;
      }
      paramString1 = null;
      label55:
      additionalActions = paramString1;
      if (paramList1 != null) {
        break label139;
      }
    }
    label130:
    label139:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList1))
    {
      additionalOptions = paramString1;
      hasTitle = paramBoolean1;
      hasBody = paramBoolean2;
      hasTrackingId = paramBoolean3;
      hasActionUrl = paramBoolean4;
      hasActionPostData = paramBoolean5;
      hasType = paramBoolean6;
      hasAdditionalActions = paramBoolean7;
      hasAdditionalOptions = paramBoolean8;
      return;
      paramString1 = Collections.unmodifiableMap(paramMap);
      break;
      paramString1 = Collections.unmodifiableList(paramList);
      break label55;
    }
  }
  
  public final Action accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasBody)
    {
      paramDataProcessor.startRecordField$505cff1c("body");
      paramDataProcessor.processString(body);
    }
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    if (hasActionUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("actionUrl");
      paramDataProcessor.processString(actionUrl);
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    boolean bool2;
    if (hasActionPostData)
    {
      paramDataProcessor.startRecordField$505cff1c("actionPostData");
      actionPostData.size();
      paramDataProcessor.startMap$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new HashMap();
      }
      i = 0;
      localObject2 = actionPostData.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        paramDataProcessor.processMapKey((String)((Map.Entry)localObject3).getKey(), i);
        localObject4 = (String)((Map.Entry)localObject3).getValue();
        paramDataProcessor.processString((String)localObject4);
        if (localObject1 != null) {
          ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), localObject4);
        }
        i += 1;
      }
      paramDataProcessor.endMap();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasType)
      {
        paramDataProcessor.startRecordField$505cff1c("type");
        paramDataProcessor.processEnum(type);
      }
      localObject3 = null;
      localObject1 = null;
      bool2 = false;
      if (!hasAdditionalActions) {
        break label498;
      }
      paramDataProcessor.startRecordField$505cff1c("additionalActions");
      additionalActions.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = additionalActions.iterator();
      label382:
      if (!((Iterator)localObject4).hasNext()) {
        break label480;
      }
      localObject3 = (Action)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label464;
      }
    }
    label464:
    for (Object localObject3 = ((Action)localObject3).accept(paramDataProcessor);; localObject3 = (Action)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject1 != null) && (localObject3 != null)) {
        ((List)localObject1).add(localObject3);
      }
      i += 1;
      break label382;
      bool1 = false;
      localObject2 = localObject1;
      break;
    }
    label480:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool2 = true;
      localObject3 = localObject1;
      label498:
      localObject1 = null;
      localObject4 = null;
      bool3 = false;
      if (!hasAdditionalOptions) {
        break label686;
      }
      paramDataProcessor.startRecordField$505cff1c("additionalOptions");
      additionalOptions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = additionalOptions.iterator();
      label573:
      if (!localIterator.hasNext()) {
        break label672;
      }
      localObject4 = (AdditionalOptions)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label656;
      }
    }
    label656:
    for (Object localObject4 = ((AdditionalOptions)localObject4).accept(paramDataProcessor);; localObject4 = (AdditionalOptions)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject1 != null) && (localObject4 != null)) {
        ((List)localObject1).add(localObject4);
      }
      i += 1;
      break label573;
      bool2 = false;
      localObject3 = localObject1;
      break;
    }
    label672:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label686:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new Action(title, body, trackingId, actionUrl, (Map)localObject2, type, (List)localObject3, (List)localObject1, hasTitle, hasBody, hasTrackingId, hasActionUrl, bool1, hasType, bool2, bool3);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Action)paramObject;
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (body != null)
      {
        if (body.equals(body)) {}
      }
      else {
        while (body != null) {
          return false;
        }
      }
      if (trackingId != null)
      {
        if (trackingId.equals(trackingId)) {}
      }
      else {
        while (trackingId != null) {
          return false;
        }
      }
      if (actionUrl != null)
      {
        if (actionUrl.equals(actionUrl)) {}
      }
      else {
        while (actionUrl != null) {
          return false;
        }
      }
      if (actionPostData != null)
      {
        if (actionPostData.equals(actionPostData)) {}
      }
      else {
        while (actionPostData != null) {
          return false;
        }
      }
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (additionalActions != null)
      {
        if (additionalActions.equals(additionalActions)) {}
      }
      else {
        while (additionalActions != null) {
          return false;
        }
      }
      if (additionalOptions == null) {
        break;
      }
    } while (additionalOptions.equals(additionalOptions));
    for (;;)
    {
      return false;
      if (additionalOptions == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    label94:
    int i1;
    if (title != null)
    {
      i = title.hashCode();
      if (body == null) {
        break label204;
      }
      j = body.hashCode();
      if (trackingId == null) {
        break label209;
      }
      k = trackingId.hashCode();
      if (actionUrl == null) {
        break label214;
      }
      m = actionUrl.hashCode();
      if (actionPostData == null) {
        break label220;
      }
      n = actionPostData.hashCode();
      if (type == null) {
        break label226;
      }
      i1 = type.hashCode();
      label110:
      if (additionalActions == null) {
        break label232;
      }
    }
    label204:
    label209:
    label214:
    label220:
    label226:
    label232:
    for (int i2 = additionalActions.hashCode();; i2 = 0)
    {
      if (additionalOptions != null) {
        i3 = additionalOptions.hashCode();
      }
      i = (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label94;
      i1 = 0;
      break label110;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public static final class AdditionalOptions
    implements UnionTemplate<AdditionalOptions>
  {
    public static final ActionBuilder.AdditionalOptionsBuilder BUILDER = ActionBuilder.AdditionalOptionsBuilder.INSTANCE;
    private volatile int _cachedHashCode = -1;
    public final Action actionValue;
    public final boolean hasActionValue;
    public final boolean hasOpenLinkValue;
    public final OpenLink openLinkValue;
    
    public AdditionalOptions(Action paramAction, OpenLink paramOpenLink, boolean paramBoolean1, boolean paramBoolean2)
    {
      actionValue = paramAction;
      openLinkValue = paramOpenLink;
      hasActionValue = paramBoolean1;
      hasOpenLinkValue = paramBoolean2;
    }
    
    public final AdditionalOptions accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasActionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.semaphore.models.Action");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = actionValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label149;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        label56:
        localObject1 = null;
        bool2 = false;
        if (hasOpenLinkValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.semaphore.models.OpenLink");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = openLinkValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label176;
          }
        }
      }
      label149:
      label158:
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label181;
        }
        return new AdditionalOptions((Action)localObject2, (OpenLink)localObject1, bool1, bool2);
        localObject1 = (Action)paramDataProcessor.processDataTemplate(actionValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (OpenLink)paramDataProcessor.processDataTemplate(openLinkValue);
        break label95;
      }
      label181:
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (AdditionalOptions)paramObject;
        if (actionValue != null)
        {
          if (actionValue.equals(actionValue)) {}
        }
        else {
          while (actionValue != null) {
            return false;
          }
        }
        if (openLinkValue == null) {
          break;
        }
      } while (openLinkValue.equals(openLinkValue));
      for (;;)
      {
        return false;
        if (openLinkValue == null) {
          break;
        }
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (actionValue != null) {}
      for (int i = actionValue.hashCode();; i = 0)
      {
        if (openLinkValue != null) {
          j = openLinkValue.hashCode();
        }
        i = (i + 527) * 31 + j;
        _cachedHashCode = i;
        return i;
      }
    }
    
    public final String id()
    {
      return null;
    }
    
    public static final class Builder
    {
      public Action actionValue = null;
      public boolean hasActionValue = false;
      public boolean hasOpenLinkValue = false;
      public OpenLink openLinkValue = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.Action
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */