package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class AggregatePropCard$Builder
  implements RecordTemplateBuilder<AggregatePropCard>
{
  private boolean hasHeadline = false;
  private boolean hasPropType = false;
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private boolean hasSomeProps = false;
  private AttributedText headline = null;
  private PropType propType = null;
  private long publishedAt = 0L;
  public boolean read = false;
  private List<PropCard> someProps = null;
  
  public AggregatePropCard$Builder() {}
  
  public AggregatePropCard$Builder(AggregatePropCard paramAggregatePropCard)
  {
    propType = propType;
    headline = headline;
    someProps = someProps;
    publishedAt = publishedAt;
    read = read;
    hasPropType = hasPropType;
    hasHeadline = hasHeadline;
    hasSomeProps = hasSomeProps;
    hasPublishedAt = hasPublishedAt;
    hasRead = hasRead;
  }
  
  public final AggregatePropCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AggregatePropCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (someProps != null)
    {
      paramFlavor = someProps.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((PropCard)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "someProps");
            if (!hasPropType) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "propType");
            }
            if (!hasHeadline) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "headline");
            }
            if (!hasSomeProps) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "someProps");
            }
            if (!hasPublishedAt) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "publishedAt");
            }
            if (hasRead) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "read");
          }
        }
      }
    }
    return new AggregatePropCard(propType, headline, someProps, publishedAt, read, hasPropType, hasHeadline, hasSomeProps, hasPublishedAt, hasRead);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */