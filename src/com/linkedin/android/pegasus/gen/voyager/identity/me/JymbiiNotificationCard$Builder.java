package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendation;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class JymbiiNotificationCard$Builder
  implements RecordTemplateBuilder<JymbiiNotificationCard>
{
  private boolean hasJobRecommendations = false;
  private boolean hasJobsCount = false;
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private List<EntitiesJobRecommendation> jobRecommendations = null;
  private long jobsCount = 0L;
  private long publishedAt = 0L;
  public boolean read = false;
  
  public JymbiiNotificationCard$Builder() {}
  
  public JymbiiNotificationCard$Builder(JymbiiNotificationCard paramJymbiiNotificationCard)
  {
    publishedAt = publishedAt;
    jobsCount = jobsCount;
    jobRecommendations = jobRecommendations;
    read = read;
    hasPublishedAt = hasPublishedAt;
    hasJobsCount = hasJobsCount;
    hasJobRecommendations = hasJobRecommendations;
    hasRead = hasRead;
  }
  
  public final JymbiiNotificationCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (JymbiiNotificationCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (jobRecommendations != null)
    {
      paramFlavor = jobRecommendations.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((EntitiesJobRecommendation)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "jobRecommendations");
            if (!hasPublishedAt) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "publishedAt");
            }
            if (!hasJobsCount) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "jobsCount");
            }
            if (!hasJobRecommendations) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "jobRecommendations");
            }
            if (hasRead) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "read");
          }
        }
      }
    }
    return new JymbiiNotificationCard(publishedAt, jobsCount, jobRecommendations, read, hasPublishedAt, hasJobsCount, hasJobRecommendations, hasRead);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */