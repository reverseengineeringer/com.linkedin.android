package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ReportEntityResponse
  implements RecordTemplate<ReportEntityResponse>
{
  public static final ReportEntityResponseBuilder BUILDER = ReportEntityResponseBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final ReportEntityClientAction clientAction;
  public final boolean hasClientAction;
  public final boolean hasStatus;
  public final ReportEntityResponseStatus status;
  
  ReportEntityResponse(ReportEntityResponseStatus paramReportEntityResponseStatus, ReportEntityClientAction paramReportEntityClientAction, boolean paramBoolean1, boolean paramBoolean2)
  {
    status = paramReportEntityResponseStatus;
    clientAction = paramReportEntityClientAction;
    hasStatus = paramBoolean1;
    hasClientAction = paramBoolean2;
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
      paramObject = (ReportEntityResponse)paramObject;
      if (status != null)
      {
        if (status.equals(status)) {}
      }
      else {
        while (status != null) {
          return false;
        }
      }
      if (clientAction == null) {
        break;
      }
    } while (clientAction.equals(clientAction));
    for (;;)
    {
      return false;
      if (clientAction == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (status != null) {}
    for (int i = status.hashCode();; i = 0)
    {
      if (clientAction != null) {
        j = clientAction.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<ReportEntityResponse>
  {
    public ReportEntityClientAction clientAction = null;
    public boolean hasClientAction = false;
    private boolean hasStatus = false;
    private ReportEntityResponseStatus status = null;
    
    public final ReportEntityResponse build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ReportEntityResponse.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ReportEntityResponse(status, clientAction, hasStatus, hasClientAction);
      } while (hasStatus);
      throw new MissingRecordFieldException("com.linkedin.semaphore.client.android.ReportEntityResponse", "status");
    }
    
    public final Builder setStatus(ReportEntityResponseStatus paramReportEntityResponseStatus)
    {
      if (paramReportEntityResponseStatus == null)
      {
        hasStatus = false;
        status = null;
        return this;
      }
      hasStatus = true;
      status = paramReportEntityResponseStatus;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */