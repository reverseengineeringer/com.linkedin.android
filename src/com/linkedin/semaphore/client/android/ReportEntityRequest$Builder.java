package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.security.android.ContentSource;

public final class ReportEntityRequest$Builder
  implements RecordTemplateBuilder<ReportEntityRequest>
{
  public ContentSource contentSource = null;
  public boolean hasContentSource = false;
  public boolean hasReportedEntity = false;
  public ReportEntityInfo reportedEntity = null;
  
  public final ReportEntityRequest build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ReportEntityRequest.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ReportEntityRequest(contentSource, reportedEntity, hasContentSource, hasReportedEntity);
      if (!hasContentSource) {
        throw new MissingRecordFieldException("com.linkedin.semaphore.client.android.ReportEntityRequest", "contentSource");
      }
    } while (hasReportedEntity);
    throw new MissingRecordFieldException("com.linkedin.semaphore.client.android.ReportEntityRequest", "reportedEntity");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */