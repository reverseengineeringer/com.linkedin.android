package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ProfileViewCard$Builder
  implements RecordTemplateBuilder<ProfileViewCard>
{
  private boolean hasHeadline = false;
  private boolean hasInsight = false;
  private boolean hasProfileViewCta = false;
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private boolean hasViewer = false;
  private AttributedText headline = null;
  private Insight insight = null;
  private AttributedText profileViewCta = null;
  private long publishedAt = 0L;
  public boolean read = false;
  private ProfileViewer viewer = null;
  
  public ProfileViewCard$Builder() {}
  
  public ProfileViewCard$Builder(ProfileViewCard paramProfileViewCard)
  {
    publishedAt = publishedAt;
    viewer = viewer;
    insight = insight;
    read = read;
    headline = headline;
    profileViewCta = profileViewCta;
    hasPublishedAt = hasPublishedAt;
    hasViewer = hasViewer;
    hasInsight = hasInsight;
    hasRead = hasRead;
    hasHeadline = hasHeadline;
    hasProfileViewCta = hasProfileViewCta;
  }
  
  public final ProfileViewCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ProfileViewCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ProfileViewCard(publishedAt, viewer, insight, read, headline, profileViewCta, hasPublishedAt, hasViewer, hasInsight, hasRead, hasHeadline, hasProfileViewCta);
      if (!hasPublishedAt) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard", "publishedAt");
      }
      if (!hasViewer) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard", "viewer");
      }
    } while (hasRead);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard", "read");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */