package com.linkedin.android.datamanager.multiplex;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.jackson.JacksonJsonGenerator;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class IndividualResponse
  implements RecordTemplate<IndividualResponse>
{
  public final IndividualBody body;
  public final long bodySize;
  public final String bodyString;
  public final boolean hasBody;
  public final boolean hasHeaders;
  public final boolean hasStatus;
  public final Map<String, String> headers;
  public final DataManagerException responseParseException;
  public final int status;
  
  IndividualResponse(int paramInt, Map<String, String> paramMap, IndividualBody paramIndividualBody, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, DataManagerException paramDataManagerException)
  {
    status = paramInt;
    if (paramMap == null)
    {
      paramMap = null;
      headers = paramMap;
      body = paramIndividualBody;
      bodyString = null;
      hasStatus = paramBoolean1;
      hasHeaders = paramBoolean2;
      if ((!paramBoolean3) || (paramIndividualBody == null)) {
        break label81;
      }
    }
    label81:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      hasBody = paramBoolean1;
      bodySize = paramLong;
      responseParseException = paramDataManagerException;
      return;
      paramMap = Collections.unmodifiableMap(paramMap);
      break;
    }
  }
  
  public final IndividualResponse accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    if (!(paramDataProcessor instanceof JacksonJsonGenerator)) {
      throw new DataProcessorException("Only JacksonGenerator supported");
    }
    paramDataProcessor.startRecord();
    if (hasStatus)
    {
      paramDataProcessor.startRecordField$505cff1c("status");
      paramDataProcessor.processInt(status);
    }
    if (hasHeaders)
    {
      paramDataProcessor.startRecordField$505cff1c("headers");
      headers.size();
      paramDataProcessor.startMap$13462e();
      int i = 0;
      Iterator localIterator = headers.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramDataProcessor.processMapKey((String)localEntry.getKey(), i);
        paramDataProcessor.processString((String)localEntry.getValue());
        i += 1;
      }
      paramDataProcessor.endMap();
    }
    if (body != null)
    {
      paramDataProcessor.startRecordField$505cff1c("body");
      body.accept(paramDataProcessor);
    }
    for (;;)
    {
      paramDataProcessor.endRecord();
      return null;
      if (bodyString != null)
      {
        paramDataProcessor.startRecordField$505cff1c("body");
        ((JacksonJsonGenerator)paramDataProcessor).processJsonString(bodyString);
      }
    }
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
      paramObject = (IndividualResponse)paramObject;
      if (status != status) {
        return false;
      }
      if (headers != null)
      {
        if (headers.equals(headers)) {}
      }
      else {
        while (headers != null) {
          return false;
        }
      }
      if (body == null) {
        break;
      }
    } while (body.equals(body));
    for (;;)
    {
      return false;
      if (body == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = status;
    if (headers != null) {}
    for (int i = headers.hashCode();; i = 0)
    {
      if (body != null) {
        j = body.hashCode();
      }
      return (i + (k + 527) * 31) * 31 + j;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.IndividualResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */