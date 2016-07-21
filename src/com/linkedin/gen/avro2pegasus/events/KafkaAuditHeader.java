package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class KafkaAuditHeader
  implements RecordTemplate<KafkaAuditHeader>
{
  public static final KafkaAuditHeaderBuilder BUILDER = KafkaAuditHeaderBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String appName;
  public final boolean hasAppName;
  public final boolean hasInstance;
  public final boolean hasMessageId;
  public final boolean hasServer;
  public final boolean hasTime;
  public final String instance;
  public final String messageId;
  public final String server;
  public final long time;
  
  KafkaAuditHeader(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    time = paramLong;
    server = paramString1;
    instance = paramString2;
    appName = paramString3;
    messageId = paramString4;
    hasTime = paramBoolean1;
    hasServer = paramBoolean2;
    hasInstance = paramBoolean3;
    hasAppName = paramBoolean4;
    hasMessageId = paramBoolean5;
    _cachedId = null;
  }
  
  public final KafkaAuditHeader accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
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
    if (hasMessageId)
    {
      paramDataProcessor.startRecordField$505cff1c("messageId");
      BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(messageId));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new KafkaAuditHeader(time, server, instance, appName, messageId, hasTime, hasServer, hasInstance, hasAppName, hasMessageId);
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
      paramObject = (KafkaAuditHeader)paramObject;
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
      if (messageId == null) {
        break;
      }
    } while (messageId.equals(messageId));
    for (;;)
    {
      return false;
      if (messageId == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int n = (int)(time ^ time >>> 32);
    int i;
    int j;
    if (server != null)
    {
      i = server.hashCode();
      if (instance == null) {
        break label131;
      }
      j = instance.hashCode();
      label60:
      if (appName == null) {
        break label136;
      }
    }
    label131:
    label136:
    for (int k = appName.hashCode();; k = 0)
    {
      if (messageId != null) {
        m = messageId.hashCode();
      }
      i = (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.KafkaAuditHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */