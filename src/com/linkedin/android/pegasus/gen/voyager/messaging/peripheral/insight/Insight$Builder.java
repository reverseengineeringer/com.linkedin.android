package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight;

import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Insight$Builder
  implements RecordTemplateBuilder<Insight>
{
  public AttributedText body = null;
  public boolean hasBody = false;
  public boolean hasPreFilledText = false;
  public boolean hasTitle = false;
  public boolean hasTrackingId = false;
  public boolean hasType = false;
  public AttributedText preFilledText = null;
  public AttributedText title = null;
  public String trackingId = null;
  public InsightType type = null;
  
  public final Insight build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Insight.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Insight(title, body, preFilledText, type, trackingId, hasTitle, hasBody, hasPreFilledText, hasType, hasTrackingId);
      if (!hasTitle) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "title");
      }
      if (!hasBody) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "body");
      }
      if (!hasType) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "type");
      }
    } while (hasTrackingId);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "trackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */