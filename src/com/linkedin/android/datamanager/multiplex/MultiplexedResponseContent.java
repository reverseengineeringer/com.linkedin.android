package com.linkedin.android.datamanager.multiplex;

import com.linkedin.data.lite.RecordTemplate;
import java.util.Collections;
import java.util.Map;

public final class MultiplexedResponseContent
  implements RecordTemplate<MultiplexedResponseContent>
{
  public final boolean hasResponses;
  public final Map<String, IndividualResponse> responses;
  
  public MultiplexedResponseContent(Map<String, IndividualResponse> paramMap, boolean paramBoolean)
  {
    if (paramMap == null) {}
    for (paramMap = null;; paramMap = Collections.unmodifiableMap(paramMap))
    {
      responses = paramMap;
      hasResponses = paramBoolean;
      return;
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
      paramObject = (MultiplexedResponseContent)paramObject;
      if (responses == null) {
        break;
      }
    } while (responses.equals(responses));
    for (;;)
    {
      return false;
      if (responses == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    if (responses != null) {}
    for (int i = responses.hashCode();; i = 0) {
      return i + 527;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.MultiplexedResponseContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */