package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.PageInstance;

public final class EventHeader
  implements RecordTemplate<EventHeader>
{
  public static final EventHeaderBuilder BUILDER = EventHeaderBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String appName;
  public final String applicationViewerUrn;
  public final KafkaAuditHeader auditHeader;
  public final String csUserUrn;
  public final String environment;
  public final String guid;
  public final boolean hasAppName;
  public final boolean hasApplicationViewerUrn;
  public final boolean hasAuditHeader;
  public final boolean hasCsUserUrn;
  public final boolean hasEnvironment;
  public final boolean hasGuid;
  public final boolean hasImpersonatorId;
  public final boolean hasInstance;
  public final boolean hasMemberId;
  public final boolean hasPageInstance;
  public final boolean hasRequestId;
  public final boolean hasServer;
  public final boolean hasService;
  public final boolean hasTestId;
  public final boolean hasTestSegmentId;
  public final boolean hasTime;
  public final boolean hasTreeId;
  public final boolean hasVersion;
  public final boolean hasViewerUrn;
  public final String impersonatorId;
  public final String instance;
  public final int memberId;
  public final PageInstance pageInstance;
  public final int requestId;
  public final String server;
  public final String service;
  public final String testId;
  public final String testSegmentId;
  public final long time;
  public final String treeId;
  public final String version;
  public final String viewerUrn;
  
  EventHeader(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, KafkaAuditHeader paramKafkaAuditHeader, PageInstance paramPageInstance, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19)
  {
    memberId = paramInt1;
    viewerUrn = paramString1;
    applicationViewerUrn = paramString2;
    csUserUrn = paramString3;
    time = paramLong;
    server = paramString4;
    service = paramString5;
    environment = paramString6;
    guid = paramString7;
    treeId = paramString8;
    requestId = paramInt2;
    impersonatorId = paramString9;
    version = paramString10;
    instance = paramString11;
    appName = paramString12;
    testId = paramString13;
    testSegmentId = paramString14;
    auditHeader = paramKafkaAuditHeader;
    pageInstance = paramPageInstance;
    hasMemberId = paramBoolean1;
    hasViewerUrn = paramBoolean2;
    hasApplicationViewerUrn = paramBoolean3;
    hasCsUserUrn = paramBoolean4;
    hasTime = paramBoolean5;
    hasServer = paramBoolean6;
    hasService = paramBoolean7;
    hasEnvironment = paramBoolean8;
    hasGuid = paramBoolean9;
    hasTreeId = paramBoolean10;
    hasRequestId = paramBoolean11;
    hasImpersonatorId = paramBoolean12;
    hasVersion = paramBoolean13;
    hasInstance = paramBoolean14;
    hasAppName = paramBoolean15;
    hasTestId = paramBoolean16;
    hasTestSegmentId = paramBoolean17;
    hasAuditHeader = paramBoolean18;
    hasPageInstance = paramBoolean19;
    _cachedId = null;
  }
  
  public final EventHeader accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasMemberId)
    {
      paramDataProcessor.startRecordField$505cff1c("memberId");
      paramDataProcessor.processInt(memberId);
    }
    if (hasViewerUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("viewerUrn");
      paramDataProcessor.processString(viewerUrn);
    }
    if (hasApplicationViewerUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("applicationViewerUrn");
      paramDataProcessor.processString(applicationViewerUrn);
    }
    if (hasCsUserUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("csUserUrn");
      paramDataProcessor.processString(csUserUrn);
    }
    if (hasTime)
    {
      paramDataProcessor.startRecordField$505cff1c("time");
      paramDataProcessor.processLong(time);
    }
    if (hasServer)
    {
      paramDataProcessor.startRecordField$505cff1c("server");
      paramDataProcessor.processString(server);
    }
    if (hasService)
    {
      paramDataProcessor.startRecordField$505cff1c("service");
      paramDataProcessor.processString(service);
    }
    if (hasEnvironment)
    {
      paramDataProcessor.startRecordField$505cff1c("environment");
      paramDataProcessor.processString(environment);
    }
    Object localObject1;
    if (hasGuid)
    {
      paramDataProcessor.startRecordField$505cff1c("guid");
      localObject1 = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(guid));
    }
    if (hasTreeId)
    {
      paramDataProcessor.startRecordField$505cff1c("treeId");
      localObject1 = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(treeId));
    }
    if (hasRequestId)
    {
      paramDataProcessor.startRecordField$505cff1c("requestId");
      paramDataProcessor.processInt(requestId);
    }
    if (hasImpersonatorId)
    {
      paramDataProcessor.startRecordField$505cff1c("impersonatorId");
      paramDataProcessor.processString(impersonatorId);
    }
    if (hasVersion)
    {
      paramDataProcessor.startRecordField$505cff1c("version");
      paramDataProcessor.processString(version);
    }
    if (hasInstance)
    {
      paramDataProcessor.startRecordField$505cff1c("instance");
      paramDataProcessor.processString(instance);
    }
    if (hasAppName)
    {
      paramDataProcessor.startRecordField$505cff1c("appName");
      paramDataProcessor.processString(appName);
    }
    if (hasTestId)
    {
      paramDataProcessor.startRecordField$505cff1c("testId");
      paramDataProcessor.processString(testId);
    }
    if (hasTestSegmentId)
    {
      paramDataProcessor.startRecordField$505cff1c("testSegmentId");
      paramDataProcessor.processString(testSegmentId);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasAuditHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("auditHeader");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = auditHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label726;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label497:
      localObject1 = null;
      bool2 = false;
      if (hasPageInstance)
      {
        paramDataProcessor.startRecordField$505cff1c("pageInstance");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label735;
        }
        localObject1 = pageInstance.accept(paramDataProcessor);
        label536:
        if (localObject1 == null) {
          break label753;
        }
      }
    }
    label726:
    label735:
    label753:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label758;
      }
      return new EventHeader(memberId, viewerUrn, applicationViewerUrn, csUserUrn, time, server, service, environment, guid, treeId, requestId, impersonatorId, version, instance, appName, testId, testSegmentId, (KafkaAuditHeader)localObject2, (PageInstance)localObject1, hasMemberId, hasViewerUrn, hasApplicationViewerUrn, hasCsUserUrn, hasTime, hasServer, hasService, hasEnvironment, hasGuid, hasTreeId, hasRequestId, hasImpersonatorId, hasVersion, hasInstance, hasAppName, hasTestId, hasTestSegmentId, bool1, bool2);
      localObject1 = (KafkaAuditHeader)paramDataProcessor.processDataTemplate(auditHeader);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label497;
      localObject1 = (PageInstance)paramDataProcessor.processDataTemplate(pageInstance);
      break label536;
    }
    label758:
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
      paramObject = (EventHeader)paramObject;
      if (memberId != memberId) {
        return false;
      }
      if (viewerUrn != null)
      {
        if (viewerUrn.equals(viewerUrn)) {}
      }
      else {
        while (viewerUrn != null) {
          return false;
        }
      }
      if (applicationViewerUrn != null)
      {
        if (applicationViewerUrn.equals(applicationViewerUrn)) {}
      }
      else {
        while (applicationViewerUrn != null) {
          return false;
        }
      }
      if (csUserUrn != null)
      {
        if (csUserUrn.equals(csUserUrn)) {}
      }
      else {
        while (csUserUrn != null) {
          return false;
        }
      }
      if (time != time) {
        return false;
      }
      if (server != null)
      {
        if (server.equals(server)) {}
      }
      else {
        while (server != null) {
          return false;
        }
      }
      if (service != null)
      {
        if (service.equals(service)) {}
      }
      else {
        while (service != null) {
          return false;
        }
      }
      if (environment != null)
      {
        if (environment.equals(environment)) {}
      }
      else {
        while (environment != null) {
          return false;
        }
      }
      if (guid != null)
      {
        if (guid.equals(guid)) {}
      }
      else {
        while (guid != null) {
          return false;
        }
      }
      if (treeId != null)
      {
        if (treeId.equals(treeId)) {}
      }
      else {
        while (treeId != null) {
          return false;
        }
      }
      if (requestId != requestId) {
        return false;
      }
      if (impersonatorId != null)
      {
        if (impersonatorId.equals(impersonatorId)) {}
      }
      else {
        while (impersonatorId != null) {
          return false;
        }
      }
      if (version != null)
      {
        if (version.equals(version)) {}
      }
      else {
        while (version != null) {
          return false;
        }
      }
      if (instance != null)
      {
        if (instance.equals(instance)) {}
      }
      else {
        while (instance != null) {
          return false;
        }
      }
      if (appName != null)
      {
        if (appName.equals(appName)) {}
      }
      else {
        while (appName != null) {
          return false;
        }
      }
      if (testId != null)
      {
        if (testId.equals(testId)) {}
      }
      else {
        while (testId != null) {
          return false;
        }
      }
      if (testSegmentId != null)
      {
        if (testSegmentId.equals(testSegmentId)) {}
      }
      else {
        while (testSegmentId != null) {
          return false;
        }
      }
      if (auditHeader != null)
      {
        if (auditHeader.equals(auditHeader)) {}
      }
      else {
        while (auditHeader != null) {
          return false;
        }
      }
      if (pageInstance == null) {
        break;
      }
    } while (pageInstance.equals(pageInstance));
    for (;;)
    {
      return false;
      if (pageInstance == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i11 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i12 = memberId;
    int i;
    int j;
    label51:
    int k;
    label66:
    int i13;
    int m;
    label97:
    int n;
    label113:
    int i1;
    label129:
    int i2;
    label145:
    int i3;
    label161:
    int i14;
    int i4;
    label183:
    int i5;
    label199:
    int i6;
    label215:
    int i7;
    label231:
    int i8;
    label247:
    int i9;
    if (viewerUrn != null)
    {
      i = viewerUrn.hashCode();
      if (applicationViewerUrn == null) {
        break label419;
      }
      j = applicationViewerUrn.hashCode();
      if (csUserUrn == null) {
        break label424;
      }
      k = csUserUrn.hashCode();
      i13 = (int)(time ^ time >>> 32);
      if (server == null) {
        break label429;
      }
      m = server.hashCode();
      if (service == null) {
        break label435;
      }
      n = service.hashCode();
      if (environment == null) {
        break label441;
      }
      i1 = environment.hashCode();
      if (guid == null) {
        break label447;
      }
      i2 = guid.hashCode();
      if (treeId == null) {
        break label453;
      }
      i3 = treeId.hashCode();
      i14 = requestId;
      if (impersonatorId == null) {
        break label459;
      }
      i4 = impersonatorId.hashCode();
      if (version == null) {
        break label465;
      }
      i5 = version.hashCode();
      if (instance == null) {
        break label471;
      }
      i6 = instance.hashCode();
      if (appName == null) {
        break label477;
      }
      i7 = appName.hashCode();
      if (testId == null) {
        break label483;
      }
      i8 = testId.hashCode();
      if (testSegmentId == null) {
        break label489;
      }
      i9 = testSegmentId.hashCode();
      label263:
      if (auditHeader == null) {
        break label495;
      }
    }
    label419:
    label424:
    label429:
    label435:
    label441:
    label447:
    label453:
    label459:
    label465:
    label471:
    label477:
    label483:
    label489:
    label495:
    for (int i10 = auditHeader.hashCode();; i10 = 0)
    {
      if (pageInstance != null) {
        i11 = pageInstance.hashCode();
      }
      i = (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + ((i3 + (i2 + (i1 + (n + (m + ((k + (j + (i + (i12 + 527) * 31) * 31) * 31) * 31 + i13) * 31) * 31) * 31) * 31) * 31) * 31 + i14) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i11;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label66;
      m = 0;
      break label97;
      n = 0;
      break label113;
      i1 = 0;
      break label129;
      i2 = 0;
      break label145;
      i3 = 0;
      break label161;
      i4 = 0;
      break label183;
      i5 = 0;
      break label199;
      i6 = 0;
      break label215;
      i7 = 0;
      break label231;
      i8 = 0;
      break label247;
      i9 = 0;
      break label263;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.EventHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */