package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.common.TimeRange;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class AggregateProfileViewCard$Builder
  implements RecordTemplateBuilder<AggregateProfileViewCard>
{
  private boolean hasNumViewers = false;
  private boolean hasProfileViewCta = false;
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private boolean hasSomeViewers = false;
  private boolean hasViewsTimeRange = false;
  private long numViewers = 0L;
  private AttributedText profileViewCta = null;
  private long publishedAt = 0L;
  public boolean read = false;
  private List<ProfileViewer> someViewers = null;
  private TimeRange viewsTimeRange = null;
  
  public AggregateProfileViewCard$Builder() {}
  
  public AggregateProfileViewCard$Builder(AggregateProfileViewCard paramAggregateProfileViewCard)
  {
    publishedAt = publishedAt;
    someViewers = someViewers;
    viewsTimeRange = viewsTimeRange;
    numViewers = numViewers;
    read = read;
    profileViewCta = profileViewCta;
    hasPublishedAt = hasPublishedAt;
    hasSomeViewers = hasSomeViewers;
    hasViewsTimeRange = hasViewsTimeRange;
    hasNumViewers = hasNumViewers;
    hasRead = hasRead;
    hasProfileViewCta = hasProfileViewCta;
  }
  
  public final AggregateProfileViewCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AggregateProfileViewCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (someViewers != null)
    {
      paramFlavor = someViewers.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((ProfileViewer)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "someViewers");
            if (!hasPublishedAt) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "publishedAt");
            }
            if (!hasSomeViewers) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "someViewers");
            }
            if (!hasNumViewers) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "numViewers");
            }
            if (hasRead) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "read");
          }
        }
      }
    }
    return new AggregateProfileViewCard(publishedAt, someViewers, viewsTimeRange, numViewers, read, profileViewCta, hasPublishedAt, hasSomeViewers, hasViewsTimeRange, hasNumViewers, hasRead, hasProfileViewCta);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */