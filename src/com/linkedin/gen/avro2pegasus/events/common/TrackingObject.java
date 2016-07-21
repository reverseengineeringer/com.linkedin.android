package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class TrackingObject
  implements RecordTemplate<TrackingObject>
{
  public static final TrackingObjectBuilder BUILDER = TrackingObjectBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasObjectUrn;
  public final boolean hasTrackingId;
  public final String objectUrn;
  public final String trackingId;
  
  TrackingObject(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    objectUrn = paramString1;
    trackingId = paramString2;
    hasObjectUrn = paramBoolean1;
    hasTrackingId = paramBoolean2;
    _cachedId = null;
  }
  
  public final TrackingObject accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasObjectUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("objectUrn");
      paramDataProcessor.processString(objectUrn);
    }
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(trackingId));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new TrackingObject(objectUrn, trackingId, hasObjectUrn, hasTrackingId);
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
      paramObject = (TrackingObject)paramObject;
      if (objectUrn != null)
      {
        if (objectUrn.equals(objectUrn)) {}
      }
      else {
        while (objectUrn != null) {
          return false;
        }
      }
      if (trackingId == null) {
        break;
      }
    } while (trackingId.equals(trackingId));
    for (;;)
    {
      return false;
      if (trackingId == null) {
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
    if (objectUrn != null) {}
    for (int i = objectUrn.hashCode();; i = 0)
    {
      if (trackingId != null) {
        j = trackingId.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<TrackingObject>
  {
    private boolean hasObjectUrn = false;
    private boolean hasTrackingId = false;
    private String objectUrn = null;
    private String trackingId = null;
    
    public final TrackingObject build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (TrackingObject.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new TrackingObject(objectUrn, trackingId, hasObjectUrn, hasTrackingId);
        if (!hasObjectUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.TrackingObject", "objectUrn");
        }
      } while (hasTrackingId);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.TrackingObject", "trackingId");
    }
    
    public final Builder setObjectUrn(String paramString)
    {
      if (paramString == null)
      {
        hasObjectUrn = false;
        objectUrn = null;
        return this;
      }
      hasObjectUrn = true;
      objectUrn = paramString;
      return this;
    }
    
    public final Builder setTrackingId(String paramString)
    {
      if (paramString == null)
      {
        hasTrackingId = false;
        trackingId = null;
        return this;
      }
      hasTrackingId = true;
      trackingId = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.TrackingObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */