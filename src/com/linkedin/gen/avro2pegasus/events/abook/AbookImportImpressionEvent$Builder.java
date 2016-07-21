package com.linkedin.gen.avro2pegasus.events.abook;

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

public final class AbookImportImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<AbookImportImpressionEvent>
{
  public String abookImportTransactionId = null;
  private String autoFilledEmail = null;
  public AbookImportEmailProvider autoSelectedEmailProvider = null;
  public boolean hasAbookImportTransactionId = false;
  private boolean hasAutoFilledEmail = false;
  public boolean hasAutoSelectedEmailProvider = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasOrderOfEmailProviderss = false;
  private boolean hasRequestHeader = false;
  public boolean hasSocialProofCount = false;
  private boolean hasSocialProofType = false;
  public boolean hasSource = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public List<AbookImportEmailProvider> orderOfEmailProviderss = null;
  private UserRequestHeader requestHeader = null;
  public int socialProofCount = 0;
  private String socialProofType = null;
  public String source = null;
  
  private AbookImportImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AbookImportImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (orderOfEmailProviderss != null)
    {
      paramFlavor = orderOfEmailProviderss.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((AbookImportEmailProvider)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "orderOfEmailProviderss");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "header");
            }
            if (!hasAbookImportTransactionId) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "abookImportTransactionId");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "requestHeader");
            }
            if (!hasAutoSelectedEmailProvider) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "autoSelectedEmailProvider");
            }
            if (!hasOrderOfEmailProviderss) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "orderOfEmailProviderss");
            }
            if (hasSocialProofCount) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "socialProofCount");
          }
        }
      }
    }
    return new AbookImportImpressionEvent(header, abookImportTransactionId, requestHeader, source, autoFilledEmail, autoSelectedEmailProvider, orderOfEmailProviderss, socialProofType, socialProofCount, mobileHeader, hasHeader, hasAbookImportTransactionId, hasRequestHeader, hasSource, hasAutoFilledEmail, hasAutoSelectedEmailProvider, hasOrderOfEmailProviderss, hasSocialProofType, hasSocialProofCount, hasMobileHeader);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */