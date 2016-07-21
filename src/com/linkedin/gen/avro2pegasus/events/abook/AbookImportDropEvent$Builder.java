package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class AbookImportDropEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<AbookImportDropEvent>
{
  public AbookImportDropReason abookImportDropReason = null;
  public String abookImportTransactionId = null;
  public boolean hasAbookImportDropReason = false;
  public boolean hasAbookImportTransactionId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private AbookImportDropEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AbookImportDropEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new AbookImportDropEvent(header, requestHeader, mobileHeader, abookImportTransactionId, abookImportDropReason, hasHeader, hasRequestHeader, hasMobileHeader, hasAbookImportTransactionId, hasAbookImportDropReason);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportDropEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportDropEvent", "requestHeader");
      }
      if (!hasAbookImportTransactionId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportDropEvent", "abookImportTransactionId");
      }
    } while (hasAbookImportDropReason);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportDropEvent", "abookImportDropReason");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportDropEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */