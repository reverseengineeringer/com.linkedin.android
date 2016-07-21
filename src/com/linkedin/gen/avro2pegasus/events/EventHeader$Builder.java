package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.PageInstance;

public final class EventHeader$Builder
  implements RecordTemplateBuilder<EventHeader>
{
  private String appName = null;
  public String applicationViewerUrn = null;
  private KafkaAuditHeader auditHeader = null;
  private String csUserUrn = null;
  private String environment = null;
  public String guid = null;
  private boolean hasAppName = false;
  public boolean hasApplicationViewerUrn = false;
  private boolean hasAuditHeader = false;
  private boolean hasCsUserUrn = false;
  private boolean hasEnvironment = false;
  public boolean hasGuid = false;
  private boolean hasImpersonatorId = false;
  private boolean hasInstance = false;
  public boolean hasMemberId = false;
  public boolean hasPageInstance = false;
  private boolean hasRequestId = false;
  public boolean hasServer = false;
  public boolean hasService = false;
  private boolean hasTestId = false;
  private boolean hasTestSegmentId = false;
  private boolean hasTime = false;
  private boolean hasTreeId = false;
  private boolean hasVersion = false;
  private boolean hasViewerUrn = false;
  private String impersonatorId = null;
  private String instance = null;
  public int memberId = 0;
  public PageInstance pageInstance = null;
  private int requestId = 0;
  public String server = null;
  public String service = null;
  private String testId = null;
  private String testSegmentId = null;
  private long time = 0L;
  private String treeId = null;
  private String version = null;
  private String viewerUrn = null;
  
  public final EventHeader build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (EventHeader.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new EventHeader(memberId, viewerUrn, applicationViewerUrn, csUserUrn, time, server, service, environment, guid, treeId, requestId, impersonatorId, version, instance, appName, testId, testSegmentId, auditHeader, pageInstance, hasMemberId, hasViewerUrn, hasApplicationViewerUrn, hasCsUserUrn, hasTime, hasServer, hasService, hasEnvironment, hasGuid, hasTreeId, hasRequestId, hasImpersonatorId, hasVersion, hasInstance, hasAppName, hasTestId, hasTestSegmentId, hasAuditHeader, hasPageInstance);
      if (!hasEnvironment) {
        environment = "";
      }
      if (!hasMemberId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EventHeader", "memberId");
      }
      if (!hasTime) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EventHeader", "time");
      }
      if (!hasServer) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EventHeader", "server");
      }
      if (!hasService) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EventHeader", "service");
      }
    } while (hasGuid);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EventHeader", "guid");
  }
  
  public final Builder setTime(Long paramLong)
  {
    if (paramLong == null)
    {
      hasTime = false;
      time = 0L;
      return this;
    }
    hasTime = true;
    time = paramLong.longValue();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.EventHeader.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */