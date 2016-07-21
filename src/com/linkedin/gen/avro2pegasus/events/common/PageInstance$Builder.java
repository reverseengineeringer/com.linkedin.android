package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PageInstance$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.PageInstance.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */