package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Card$Builder
  implements RecordTemplateBuilder<Card>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasObjectUrn = false;
  private boolean hasTrackingId = false;
  public boolean hasValue = false;
  private Urn objectUrn = null;
  private String trackingId = null;
  public Card.Value value = null;
  
  public Card$Builder() {}
  
  public Card$Builder(Card paramCard)
  {
    value = value;
    objectUrn = objectUrn;
    trackingId = trackingId;
    entityUrn = entityUrn;
    hasValue = hasValue;
    hasObjectUrn = hasObjectUrn;
    hasTrackingId = hasTrackingId;
    hasEntityUrn = hasEntityUrn;
  }
  
  public final Card build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Card.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Card(value, objectUrn, trackingId, entityUrn, hasValue, hasObjectUrn, hasTrackingId, hasEntityUrn);
      if (!hasValue) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Card", "value");
      }
      if (!hasObjectUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Card", "objectUrn");
      }
      if (!hasTrackingId) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Card", "trackingId");
      }
    } while (hasEntityUrn);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Card", "entityUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.Card.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */