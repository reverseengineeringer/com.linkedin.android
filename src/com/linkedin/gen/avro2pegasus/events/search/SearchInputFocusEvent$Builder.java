package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SearchInputFocusEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SearchInputFocusEvent>
{
  public String controlUrn = null;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasTagValue = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public String tagValue = null;
  
  private SearchInputFocusEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchInputFocusEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchInputFocusEvent(header, requestHeader, mobileHeader, controlUrn, tagValue, hasHeader, hasRequestHeader, hasMobileHeader, hasControlUrn, hasTagValue);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent", "requestHeader");
      }
    } while (hasControlUrn);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent", "controlUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */