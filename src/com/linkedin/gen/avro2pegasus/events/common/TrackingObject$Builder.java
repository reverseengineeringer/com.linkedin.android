package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class TrackingObject$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */