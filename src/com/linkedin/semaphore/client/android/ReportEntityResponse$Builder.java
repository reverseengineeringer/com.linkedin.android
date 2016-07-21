package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ReportEntityResponse$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityResponse.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */