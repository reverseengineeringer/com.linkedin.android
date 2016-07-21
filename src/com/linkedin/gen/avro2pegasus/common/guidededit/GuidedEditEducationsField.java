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

public final class GuidedEditEducationsField
  implements RecordTemplate<GuidedEditEducationsField>
{
  public static final GuidedEditEducationsFieldBuilder BUILDER = GuidedEditEducationsFieldBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<String> educations;
  public final boolean hasEducations;
  
  GuidedEditEducationsField(List<String> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      educations = paramList;
      hasEducations = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  public final GuidedEditEducationsField accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    Iterator localIterator = null;
    boolean bool = false;
    if (hasEducations)
    {
      paramDataProcessor.startRecordField$505cff1c("educations");
      educations.size();
      paramDataProcessor.startArray$13462e();
      localObject = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      localIterator = educations.iterator();
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
        if (hasEducations) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField", "educations");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (educations != null)
    {
      paramDataProcessor = educations.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField", "educations");
        }
      }
    }
    return new GuidedEditEducationsField((List)localObject, bool);
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
      paramObject = (GuidedEditEducationsField)paramObject;
      if (educations == null) {
        break;
      }
    } while (educations.equals(educations));
    for (;;)
    {
      return false;
      if (educations == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (educations != null) {}
    for (int i = educations.hashCode();; i = 0)
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
    implements RecordTemplateBuilder<GuidedEditEducationsField>
  {
    public List<String> educations = null;
    public boolean hasEducations = false;
    
    public final GuidedEditEducationsField build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (GuidedEditEducationsField.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (educations != null)
      {
        paramFlavor = educations.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField", "educations");
              if (hasEducations) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField", "educations");
            }
          }
        }
      }
      return new GuidedEditEducationsField(educations, hasEducations);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */