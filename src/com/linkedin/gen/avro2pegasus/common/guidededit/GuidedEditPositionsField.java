package com.linkedin.gen.avro2pegasus.common.guidededit;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GuidedEditPositionsField
  implements RecordTemplate<GuidedEditPositionsField>
{
  public static final GuidedEditPositionsFieldBuilder BUILDER = GuidedEditPositionsFieldBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasPositions;
  public final List<String> positions;
  
  GuidedEditPositionsField(List<String> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      positions = paramList;
      hasPositions = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  public final GuidedEditPositionsField accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    Iterator localIterator = null;
    boolean bool = false;
    if (hasPositions)
    {
      paramDataProcessor.startRecordField$505cff1c("positions");
      positions.size();
      paramDataProcessor.startArray$13462e();
      localObject = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      localIterator = positions.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject != null) {
          ((List)localObject).add(str);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label196;
      }
    }
    label196:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label262;
      }
      try
      {
        if (hasPositions) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField", "positions");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (positions != null)
    {
      paramDataProcessor = positions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField", "positions");
        }
      }
    }
    return new GuidedEditPositionsField((List)localObject, bool);
    label262:
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
      paramObject = (GuidedEditPositionsField)paramObject;
      if (positions == null) {
        break;
      }
    } while (positions.equals(positions));
    for (;;)
    {
      return false;
      if (positions == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (positions != null) {}
    for (int i = positions.hashCode();; i = 0)
    {
      i += 527;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<GuidedEditPositionsField>
  {
    public boolean hasPositions = false;
    public List<String> positions = null;
    
    public final GuidedEditPositionsField build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (GuidedEditPositionsField.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (positions != null)
      {
        paramFlavor = positions.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField", "positions");
              if (hasPositions) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField", "positions");
            }
          }
        }
      }
      return new GuidedEditPositionsField(positions, hasPositions);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */