package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PageInstance
  implements RecordTemplate<PageInstance>
{
  public static final PageInstanceBuilder BUILDER = PageInstanceBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasPageUrn;
  public final boolean hasTrackingId;
  public final String pageUrn;
  public final String trackingId;
  
  PageInstance(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    pageUrn = paramString1;
    trackingId = paramString2;
    hasPageUrn = paramBoolean1;
    hasTrackingId = paramBoolean2;
    _cachedId = null;
  }
  
  public final PageInstance accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPageUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("pageUrn");
      paramDataProcessor.processString(pageUrn);
    }
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(trackingId));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new PageInstance(pageUrn, trackingId, hasPageUrn, hasTrackingId);
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
      paramObject = (PageInstance)paramObject;
      if (pageUrn != null)
      {
        if (pageUrn.equals(pageUrn)) {}
      }
      else {
        while (pageUrn != null) {
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
    if (pageUrn != null) {}
    for (int i = pageUrn.hashCode();; i = 0)
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
    implements RecordTemplateBuilder<PageInstance>
  {
    private boolean hasPageUrn = false;
    private boolean hasTrackingId = false;
    private String pageUrn = null;
    private String trackingId = null;
    
    public final PageInstance build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PageInstance.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PageInstance(pageUrn, trackingId, hasPageUrn, hasTrackingId);
        if (!hasPageUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.PageInstance", "pageUrn");
        }
      } while (hasTrackingId);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.PageInstance", "trackingId");
    }
    
    public final Builder setPageUrn(String paramString)
    {
      if (paramString == null)
      {
        hasPageUrn = false;
        pageUrn = null;
        return this;
      }
      hasPageUrn = true;
      pageUrn = paramString;
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
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.PageInstance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */