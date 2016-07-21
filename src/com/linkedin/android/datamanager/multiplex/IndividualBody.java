package com.linkedin.android.datamanager.multiplex;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.jackson.JacksonJsonGenerator;

public final class IndividualBody
  implements RecordTemplate<IndividualBody>
{
  public final String rawRecordTemplateJson;
  public final RecordTemplate recordTemplate;
  
  public IndividualBody(RecordTemplate paramRecordTemplate)
  {
    recordTemplate = paramRecordTemplate;
    rawRecordTemplateJson = null;
  }
  
  public final IndividualBody accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    if (!(paramDataProcessor instanceof JacksonJsonGenerator)) {
      throw new DataProcessorException("Processors other than JacksonJsonGenerator unsupported. Processor class: " + paramDataProcessor.getClass().getName());
    }
    if (recordTemplate != null) {
      recordTemplate.accept(paramDataProcessor);
    }
    for (;;)
    {
      return null;
      if (rawRecordTemplateJson != null) {
        ((JacksonJsonGenerator)paramDataProcessor).processJsonString(rawRecordTemplateJson);
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    return (recordTemplate != null) && (recordTemplate.equals(recordTemplate));
  }
  
  public final int hashCode()
  {
    return 17;
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.IndividualBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */