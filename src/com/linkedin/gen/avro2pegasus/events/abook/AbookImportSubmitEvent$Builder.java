package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class AbookImportSubmitEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<AbookImportSubmitEvent>
{
  public String abookImportTransactionId = null;
  public boolean hasAbookImportTransactionId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasProviderName = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private ProviderName providerName = null;
  private UserRequestHeader requestHeader = null;
  
  private AbookImportSubmitEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AbookImportSubmitEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new AbookImportSubmitEvent(header, abookImportTransactionId, mobileHeader, providerName, requestHeader, hasHeader, hasAbookImportTransactionId, hasMobileHeader, hasProviderName, hasRequestHeader);
    } while (hasHeader);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportSubmitEvent", "header");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportSubmitEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */