package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.security.android.ContentSource;

public final class ReportEntityRequest
  implements RecordTemplate<ReportEntityRequest>
{
  public static final ReportEntityRequestBuilder BUILDER = ReportEntityRequestBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final ContentSource contentSource;
  public final boolean hasContentSource;
  public final boolean hasReportedEntity;
  public final ReportEntityInfo reportedEntity;
  
  ReportEntityRequest(ContentSource paramContentSource, ReportEntityInfo paramReportEntityInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    contentSource = paramContentSource;
    reportedEntity = paramReportEntityInfo;
    hasContentSource = paramBoolean1;
    hasReportedEntity = paramBoolean2;
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
      paramObject = (ReportEntityRequest)paramObject;
      if (contentSource != null)
      {
        if (contentSource.equals(contentSource)) {}
      }
      else {
        while (contentSource != null) {
          return false;
        }
      }
      if (reportedEntity == null) {
        break;
      }
    } while (reportedEntity.equals(reportedEntity));
    for (;;)
    {
      return false;
      if (reportedEntity == null) {
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
    if (contentSource != null) {}
    for (int i = contentSource.hashCode();; i = 0)
    {
      if (reportedEntity != null) {
        j = reportedEntity.hashCode();
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
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */