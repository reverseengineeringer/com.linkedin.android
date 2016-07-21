package com.linkedin.gen.avro2pegasus.events.mentions;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;

public final class MentionResultHit
  implements RecordTemplate<MentionResultHit>
{
  public static final MentionResultHitBuilder BUILDER = MentionResultHitBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasIsCacheHit;
  public final boolean hasPosition;
  public final boolean isCacheHit;
  public final ListPosition position;
  
  MentionResultHit(String paramString, ListPosition paramListPosition, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entityUrn = paramString;
    position = paramListPosition;
    isCacheHit = paramBoolean1;
    hasEntityUrn = paramBoolean2;
    hasPosition = paramBoolean3;
    hasIsCacheHit = paramBoolean4;
    _cachedId = null;
  }
  
  public final MentionResultHit accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      paramDataProcessor.processString(entityUrn);
    }
    ListPosition localListPosition = null;
    boolean bool = false;
    if (hasPosition)
    {
      paramDataProcessor.startRecordField$505cff1c("position");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localListPosition = position.accept(paramDataProcessor);
      if (localListPosition == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      if (hasIsCacheHit)
      {
        paramDataProcessor.startRecordField$505cff1c("isCacheHit");
        paramDataProcessor.processBoolean(isCacheHit);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasEntityUrn) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localListPosition = (ListPosition)paramDataProcessor.processDataTemplate(position);
      break;
    }
    label165:
    if (!hasPosition) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit", "position");
    }
    return new MentionResultHit(entityUrn, localListPosition, isCacheHit, hasEntityUrn, bool, hasIsCacheHit);
    label210:
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
      paramObject = (MentionResultHit)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (position != null)
      {
        if (position.equals(position)) {}
      }
      else {
        while (position != null) {
          return false;
        }
      }
    } while (isCacheHit == isCacheHit);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (position == null) {
        break label81;
      }
    }
    label81:
    for (int j = position.hashCode();; j = 0)
    {
      if (isCacheHit) {
        k = 1;
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<MentionResultHit>
  {
    public String entityUrn = null;
    public boolean hasEntityUrn = false;
    public boolean hasIsCacheHit = false;
    public boolean hasPosition = false;
    public boolean isCacheHit = false;
    public ListPosition position = null;
    
    public final MentionResultHit build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MentionResultHit.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new MentionResultHit(entityUrn, position, isCacheHit, hasEntityUrn, hasPosition, hasIsCacheHit);
        if (!hasIsCacheHit) {
          isCacheHit = false;
        }
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit", "entityUrn");
        }
      } while (hasPosition);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit", "position");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */