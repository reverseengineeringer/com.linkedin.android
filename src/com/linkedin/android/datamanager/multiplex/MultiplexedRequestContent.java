package com.linkedin.android.datamanager.multiplex;

import com.linkedin.data.lite.RecordTemplate;
import java.util.Collections;
import java.util.Map;

public final class MultiplexedRequestContent
  implements RecordTemplate<MultiplexedRequestContent>
{
  public final boolean hasRequests;
  public final Map<String, IndividualRequest> requests;
  
  public MultiplexedRequestContent(Map<String, IndividualRequest> paramMap, boolean paramBoolean)
  {
    if (paramMap == null) {}
    for (paramMap = null;; paramMap = Collections.unmodifiableMap(paramMap))
    {
      requests = paramMap;
      hasRequests = paramBoolean;
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
      paramObject = (MultiplexedRequestContent)paramObject;
      if (requests == null) {
        break;
      }
    } while (requests.equals(requests));
    for (;;)
    {
      return false;
      if (requests == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    if (requests != null) {}
    for (int i = requests.hashCode();; i = 0) {
      return i + 527;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.MultiplexedRequestContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */