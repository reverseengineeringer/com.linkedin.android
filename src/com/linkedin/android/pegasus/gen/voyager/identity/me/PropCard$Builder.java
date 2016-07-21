package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions.CtaAction;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PropCard$Builder
  implements RecordTemplateBuilder<PropCard>
{
  private List<CtaAction> actions = null;
  private ActorMiniProfile actor = null;
  private boolean hasActions = false;
  private boolean hasActor = false;
  private boolean hasHeadline = false;
  private boolean hasInsight = false;
  private boolean hasPropType = false;
  private boolean hasPropUrn = false;
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private boolean hasSocialActivityInfo = false;
  private AttributedText headline = null;
  private AttributedText insight = null;
  private PropType propType = null;
  private Urn propUrn = null;
  private long publishedAt = 0L;
  public boolean read = false;
  private SocialActivityCounts socialActivityInfo = null;
  
  public PropCard$Builder() {}
  
  public PropCard$Builder(PropCard paramPropCard)
  {
    propUrn = propUrn;
    propType = propType;
    actor = actor;
    headline = headline;
    publishedAt = publishedAt;
    read = read;
    insight = insight;
    actions = actions;
    socialActivityInfo = socialActivityInfo;
    hasPropUrn = hasPropUrn;
    hasPropType = hasPropType;
    hasActor = hasActor;
    hasHeadline = hasHeadline;
    hasPublishedAt = hasPublishedAt;
    hasRead = hasRead;
    hasInsight = hasInsight;
    hasActions = hasActions;
    hasSocialActivityInfo = hasSocialActivityInfo;
  }
  
  public final PropCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PropCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (actions != null)
    {
      paramFlavor = actions.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((CtaAction)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "actions");
            if (!hasActions) {
              actions = Collections.emptyList();
            }
            if (!hasPropUrn) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "propUrn");
            }
            if (!hasPropType) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "propType");
            }
            if (!hasActor) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "actor");
            }
            if (!hasHeadline) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "headline");
            }
            if (!hasPublishedAt) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "publishedAt");
            }
            if (hasRead) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "read");
          }
        }
      }
    }
    return new PropCard(propUrn, propType, actor, headline, publishedAt, read, insight, actions, socialActivityInfo, hasPropUrn, hasPropType, hasActor, hasHeadline, hasPublishedAt, hasRead, hasInsight, hasActions, hasSocialActivityInfo);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */