package com.linkedin.android.datamanager.multiplex;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullMapValueException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class IndividualRequest$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.IndividualRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */