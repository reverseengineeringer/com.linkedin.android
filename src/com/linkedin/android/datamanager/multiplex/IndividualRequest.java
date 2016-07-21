package com.linkedin.android.datamanager.multiplex;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullMapValueException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class IndividualRequest
  implements RecordTemplate<IndividualRequest>
{
  public final IndividualBody body;
  public final Map<String, IndividualRequest> dependentRequests;
  public final boolean hasBody;
  public final boolean hasDependentRequests;
  public final boolean hasHeaders;
  public final boolean hasMethod;
  public final boolean hasRelativeUrl;
  public final Map<String, String> headers;
  public final String method;
  public final String relativeUrl;
  
  IndividualRequest(String paramString1, Map<String, String> paramMap, String paramString2, IndividualBody paramIndividualBody, Map<String, IndividualRequest> paramMap1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    method = paramString1;
    if (paramMap == null)
    {
      paramString1 = null;
      headers = paramString1;
      relativeUrl = paramString2;
      body = paramIndividualBody;
      if (paramMap1 != null) {
        break label86;
      }
    }
    label86:
    for (paramString1 = (String)localObject;; paramString1 = Collections.unmodifiableMap(paramMap1))
    {
      dependentRequests = paramString1;
      hasMethod = paramBoolean1;
      hasHeaders = paramBoolean2;
      hasRelativeUrl = paramBoolean3;
      hasBody = paramBoolean4;
      hasDependentRequests = paramBoolean5;
      return;
      paramString1 = Collections.unmodifiableMap(paramMap);
      break;
    }
  }
  
  public final IndividualRequest accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      localObject1 = (IndividualRequest)paramDataProcessor.processDataTemplate(this);
      if (localObject1 != null) {
        return (IndividualRequest)localObject1;
      }
    }
    paramDataProcessor.startRecord();
    if (hasMethod)
    {
      paramDataProcessor.startRecordField$505cff1c("method");
      paramDataProcessor.processString(method);
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    Object localObject3;
    Object localObject4;
    if (hasHeaders)
    {
      paramDataProcessor.startRecordField$505cff1c("headers");
      headers.size();
      paramDataProcessor.startMap$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new HashMap();
      }
      i = 0;
      localObject2 = headers.entrySet().iterator();
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
      if (localObject1 == null) {
        break label458;
      }
      bool1 = true;
    }
    for (localObject2 = localObject1;; localObject2 = localObject1)
    {
      if (hasRelativeUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("relativeUrl");
        paramDataProcessor.processString(relativeUrl);
      }
      if (hasBody)
      {
        paramDataProcessor.startRecordField$505cff1c("body");
        body.accept(paramDataProcessor);
      }
      localObject1 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasDependentRequests) {
        break label481;
      }
      paramDataProcessor.startRecordField$505cff1c("dependentRequests");
      dependentRequests.size();
      paramDataProcessor.startMap$13462e();
      localObject1 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new HashMap();
      }
      i = 0;
      localObject3 = dependentRequests.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        paramDataProcessor.processMapKey((String)((Map.Entry)localObject4).getKey(), i);
        IndividualRequest localIndividualRequest = ((IndividualRequest)((Map.Entry)localObject4).getValue()).accept(paramDataProcessor);
        if ((localObject1 != null) && (localIndividualRequest != null)) {
          ((Map)localObject1).put(((Map.Entry)localObject4).getKey(), localIndividualRequest);
        }
        i += 1;
      }
      label458:
      bool1 = false;
    }
    paramDataProcessor.endMap();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label481:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new IndividualRequest(method, (Map)localObject2, relativeUrl, null, (Map)localObject1, hasMethod, bool1, hasRelativeUrl, false, bool2);
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
      paramObject = (IndividualRequest)paramObject;
      if (method != null)
      {
        if (method.equals(method)) {}
      }
      else {
        while (method != null) {
          return false;
        }
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
      if (relativeUrl != null)
      {
        if (relativeUrl.equals(relativeUrl)) {}
      }
      else {
        while (relativeUrl != null) {
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
      if (dependentRequests == null) {
        break;
      }
    } while (dependentRequests.equals(dependentRequests));
    for (;;)
    {
      return false;
      if (dependentRequests == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    int i;
    int j;
    label35:
    int k;
    if (method != null)
    {
      i = method.hashCode();
      if (headers == null) {
        break label117;
      }
      j = headers.hashCode();
      if (relativeUrl == null) {
        break label122;
      }
      k = relativeUrl.hashCode();
      label50:
      if (body == null) {
        break label127;
      }
    }
    label117:
    label122:
    label127:
    for (int m = body.hashCode();; m = 0)
    {
      if (dependentRequests != null) {
        n = dependentRequests.hashCode();
      }
      return (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label35;
      k = 0;
      break label50;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<IndividualRequest>
  {
    public IndividualBody body = null;
    public Map<String, IndividualRequest> dependentRequests = null;
    public boolean hasBody = false;
    public boolean hasDependentRequests = false;
    public boolean hasHeaders = false;
    public boolean hasMethod = false;
    public boolean hasRelativeUrl = false;
    public Map<String, String> headers = null;
    public String method = null;
    public String relativeUrl = null;
    
    public final IndividualRequest build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (IndividualRequest.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (headers != null)
      {
        paramFlavor = headers.values().iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullMapValueException("com.linkedin.restli.common.multiplexer.IndividualRequest", "headers");
              if (!hasHeaders) {
                headers = Collections.emptyMap();
              }
              if (!hasDependentRequests) {
                dependentRequests = Collections.emptyMap();
              }
              if (!hasMethod) {
                throw new MissingRecordFieldException("com.linkedin.restli.common.multiplexer.IndividualRequest", "method");
              }
              if (hasRelativeUrl) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.restli.common.multiplexer.IndividualRequest", "relativeUrl");
            }
          }
        }
      }
      if (dependentRequests != null)
      {
        paramFlavor = dependentRequests.values().iterator();
        while (paramFlavor.hasNext()) {
          if ((IndividualRequest)paramFlavor.next() == null) {
            throw new NullMapValueException("com.linkedin.restli.common.multiplexer.IndividualRequest", "dependentRequests");
          }
        }
      }
      return new IndividualRequest(method, headers, relativeUrl, body, dependentRequests, hasMethod, hasHeaders, hasRelativeUrl, hasBody, hasDependentRequests);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.IndividualRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */