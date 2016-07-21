package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class EndorsementCard$Builder
  implements RecordTemplateBuilder<EndorsementCard>
{
  private List<Endorsement> endorsements = null;
  private ActorMiniProfile endorser = null;
  private boolean hasEndorsements = false;
  private boolean hasEndorser = false;
  private boolean hasInsight = false;
  private boolean hasMessageAvailable = false;
  private boolean hasNumEndorsements = false;
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private Insight insight = null;
  private boolean messageAvailable = false;
  private long numEndorsements = 0L;
  private long publishedAt = 0L;
  public boolean read = false;
  
  public EndorsementCard$Builder() {}
  
  public EndorsementCard$Builder(EndorsementCard paramEndorsementCard)
  {
    publishedAt = publishedAt;
    endorser = endorser;
    endorsements = endorsements;
    numEndorsements = numEndorsements;
    insight = insight;
    read = read;
    messageAvailable = messageAvailable;
    hasPublishedAt = hasPublishedAt;
    hasEndorser = hasEndorser;
    hasEndorsements = hasEndorsements;
    hasNumEndorsements = hasNumEndorsements;
    hasInsight = hasInsight;
    hasRead = hasRead;
    hasMessageAvailable = hasMessageAvailable;
  }
  
  public final EndorsementCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (EndorsementCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (endorsements != null)
    {
      paramFlavor = endorsements.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Endorsement)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "endorsements");
            if (!hasPublishedAt) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "publishedAt");
            }
            if (!hasEndorser) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "endorser");
            }
            if (!hasEndorsements) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "endorsements");
            }
            if (hasRead) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "read");
          }
        }
      }
    }
    return new EndorsementCard(publishedAt, endorser, endorsements, numEndorsements, insight, read, messageAvailable, hasPublishedAt, hasEndorser, hasEndorsements, hasNumEndorsements, hasInsight, hasRead, hasMessageAvailable);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */