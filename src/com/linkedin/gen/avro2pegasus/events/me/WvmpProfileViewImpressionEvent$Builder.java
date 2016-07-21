package com.linkedin.gen.avro2pegasus.events.me;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class WvmpProfileViewImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<WvmpProfileViewImpressionEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasProfileViews = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public List<WvmpProfileViewImpression> profileViews = null;
  private UserRequestHeader requestHeader = null;
  
  private WvmpProfileViewImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (WvmpProfileViewImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (profileViews != null)
    {
      paramFlavor = profileViews.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((WvmpProfileViewImpression)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpressionEvent", "profileViews");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpressionEvent", "requestHeader");
            }
            if (hasProfileViews) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpressionEvent", "profileViews");
          }
        }
      }
    }
    return new WvmpProfileViewImpressionEvent(header, requestHeader, mobileHeader, profileViews, hasHeader, hasRequestHeader, hasMobileHeader, hasProfileViews);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */