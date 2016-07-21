package com.linkedin.gen.avro2pegasus.events.prop;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PropImpressionEvent
  implements RecordTemplate<PropImpressionEvent>
{
  public static final PropImpressionEventBuilder BUILDER = PropImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<Entity> entities;
  public final boolean hasEntities;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasModuleKey;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final String moduleKey;
  public final UserRequestHeader requestHeader;
  
  PropImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, List<Entity> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    moduleKey = paramString;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      entities = paramEventHeader;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasModuleKey = paramBoolean4;
      hasEntities = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  private PropImpressionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    Object localObject4;
    boolean bool3;
    label148:
    label160:
    int i;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label351;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label360;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label378;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label388;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label406;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasModuleKey)
      {
        paramDataProcessor.startRecordField$505cff1c("moduleKey");
        paramDataProcessor.processString(moduleKey);
      }
      localObject1 = null;
      localEntity = null;
      bool4 = false;
      if (!hasEntities) {
        break label446;
      }
      paramDataProcessor.startRecordField$505cff1c("entities");
      entities.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localEntity;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = entities.iterator();
      label260:
      if (!localIterator.hasNext()) {
        break label432;
      }
      localEntity = (Entity)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label416;
      }
    }
    label351:
    label360:
    label378:
    label388:
    label406:
    label416:
    for (Entity localEntity = localEntity.accept(paramDataProcessor);; localEntity = (Entity)paramDataProcessor.processDataTemplate(localEntity))
    {
      if ((localObject1 != null) && (localEntity != null)) {
        ((List)localObject1).add(localEntity);
      }
      i += 1;
      break label260;
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      bool3 = false;
      localObject4 = localObject1;
      break label160;
    }
    label432:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label446:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label634;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "requestHeader");
    }
    if (!hasModuleKey) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "moduleKey");
    }
    if (!hasEntities) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "entities");
    }
    if (entities != null)
    {
      paramDataProcessor = entities.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Entity)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "entities");
        }
      }
    }
    return new PropImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, moduleKey, (List)localObject1, bool1, bool2, bool3, hasModuleKey, bool4);
    label634:
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
      paramObject = (PropImpressionEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (moduleKey != null)
      {
        if (moduleKey.equals(moduleKey)) {}
      }
      else {
        while (moduleKey != null) {
          return false;
        }
      }
      if (entities == null) {
        break;
      }
    } while (entities.equals(entities));
    for (;;)
    {
      return false;
      if (entities == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label134;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label139;
      }
      k = mobileHeader.hashCode();
      label60:
      if (moduleKey == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = moduleKey.hashCode();; m = 0)
    {
      if (entities != null) {
        n = entities.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<PropImpressionEvent>
  {
    private List<Entity> entities = null;
    private boolean hasEntities = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasModuleKey = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private String moduleKey = null;
    private UserRequestHeader requestHeader = null;
    
    private PropImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PropImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (entities != null)
      {
        paramFlavor = entities.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((Entity)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "entities");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "requestHeader");
              }
              if (!hasModuleKey) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "moduleKey");
              }
              if (hasEntities) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "entities");
            }
          }
        }
      }
      return new PropImpressionEvent(header, requestHeader, mobileHeader, moduleKey, entities, hasHeader, hasRequestHeader, hasMobileHeader, hasModuleKey, hasEntities);
    }
    
    public final Builder setEntities(List<Entity> paramList)
    {
      hasEntities = true;
      entities = paramList;
      return this;
    }
    
    public final Builder setModuleKey(String paramString)
    {
      hasModuleKey = true;
      moduleKey = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */