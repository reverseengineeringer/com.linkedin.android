package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals;
import com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderNotificationType;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class ProfinderServiceProposalNotificationCard$Builder
  implements RecordTemplateBuilder<ProfinderServiceProposalNotificationCard>
{
  private boolean hasProfinderMiniRequestForProposals = false;
  private boolean hasProfinderNotificationType = false;
  private boolean hasProfinderServiceProposalUrl = false;
  private boolean hasProviderProfiles = false;
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private ProfinderMiniRequestForProposals profinderMiniRequestForProposals = null;
  private ProfinderNotificationType profinderNotificationType = null;
  private String profinderServiceProposalUrl = null;
  private List<ActorMiniProfile> providerProfiles = null;
  private long publishedAt = 0L;
  public boolean read = false;
  
  public ProfinderServiceProposalNotificationCard$Builder() {}
  
  public ProfinderServiceProposalNotificationCard$Builder(ProfinderServiceProposalNotificationCard paramProfinderServiceProposalNotificationCard)
  {
    profinderNotificationType = profinderNotificationType;
    profinderServiceProposalUrl = profinderServiceProposalUrl;
    publishedAt = publishedAt;
    profinderMiniRequestForProposals = profinderMiniRequestForProposals;
    providerProfiles = providerProfiles;
    read = read;
    hasProfinderNotificationType = hasProfinderNotificationType;
    hasProfinderServiceProposalUrl = hasProfinderServiceProposalUrl;
    hasPublishedAt = hasPublishedAt;
    hasProfinderMiniRequestForProposals = hasProfinderMiniRequestForProposals;
    hasProviderProfiles = hasProviderProfiles;
    hasRead = hasRead;
  }
  
  public final ProfinderServiceProposalNotificationCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ProfinderServiceProposalNotificationCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (providerProfiles != null)
    {
      paramFlavor = providerProfiles.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((ActorMiniProfile)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "providerProfiles");
            if (!hasProfinderNotificationType) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "profinderNotificationType");
            }
            if (!hasProfinderServiceProposalUrl) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "profinderServiceProposalUrl");
            }
            if (!hasPublishedAt) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "publishedAt");
            }
            if (!hasProfinderMiniRequestForProposals) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "profinderMiniRequestForProposals");
            }
            if (!hasProviderProfiles) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "providerProfiles");
            }
            if (hasRead) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "read");
          }
        }
      }
    }
    return new ProfinderServiceProposalNotificationCard(profinderNotificationType, profinderServiceProposalUrl, publishedAt, profinderMiniRequestForProposals, providerProfiles, read, hasProfinderNotificationType, hasProfinderServiceProposalUrl, hasPublishedAt, hasProfinderMiniRequestForProposals, hasProviderProfiles, hasRead);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */