package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Update$Builder
  implements RecordTemplateBuilder<Update>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasHighlightedComments = false;
  private boolean hasHighlightedLikes = false;
  private boolean hasId = false;
  private boolean hasInsight = false;
  private boolean hasIsSponsored = false;
  private boolean hasPermalink = false;
  private boolean hasSocialDetail = false;
  private boolean hasTracking = false;
  private boolean hasTrackingId = false;
  private boolean hasUrn = false;
  private boolean hasValue = false;
  private List<Comment> highlightedComments = null;
  private List<Like> highlightedLikes = null;
  private String id = null;
  private AnnotatedText insight = null;
  private boolean isSponsored = false;
  private String permalink = null;
  private SocialDetail socialDetail = null;
  private TrackingData tracking = null;
  private String trackingId = null;
  private Urn urn = null;
  private Update.Value value = null;
  
  public Update$Builder() {}
  
  public Update$Builder(Update paramUpdate)
  {
    socialDetail = socialDetail;
    insight = insight;
    value = value;
    id = id;
    urn = urn;
    entityUrn = entityUrn;
    isSponsored = isSponsored;
    tracking = tracking;
    trackingId = trackingId;
    highlightedLikes = highlightedLikes;
    highlightedComments = highlightedComments;
    permalink = permalink;
    hasSocialDetail = hasSocialDetail;
    hasInsight = hasInsight;
    hasValue = hasValue;
    hasId = hasId;
    hasUrn = hasUrn;
    hasEntityUrn = hasEntityUrn;
    hasIsSponsored = hasIsSponsored;
    hasTracking = hasTracking;
    hasTrackingId = hasTrackingId;
    hasHighlightedLikes = hasHighlightedLikes;
    hasHighlightedComments = hasHighlightedComments;
    hasPermalink = hasPermalink;
  }
  
  public final Update build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final Update build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Update.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (highlightedLikes != null)
    {
      paramFlavor = highlightedLikes.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Like)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Update", "highlightedLikes");
            if (!hasHighlightedLikes) {
              highlightedLikes = Collections.emptyList();
            }
            if (!hasHighlightedComments) {
              highlightedComments = Collections.emptyList();
            }
            if (!hasValue) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Update", "value");
            }
            if (hasIsSponsored) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Update", "isSponsored");
          }
        }
      }
    }
    if (highlightedComments != null)
    {
      paramFlavor = highlightedComments.iterator();
      while (paramFlavor.hasNext()) {
        if ((Comment)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Update", "highlightedComments");
        }
      }
    }
    return new Update(socialDetail, insight, value, id, urn, entityUrn, isSponsored, tracking, trackingId, highlightedLikes, highlightedComments, permalink, hasSocialDetail, hasInsight, hasValue, hasId, hasUrn, hasEntityUrn, hasIsSponsored, hasTracking, hasTrackingId, hasHighlightedLikes, hasHighlightedComments, hasPermalink);
  }
  
  public final Builder setEntityUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramUrn;
    return this;
  }
  
  public final Builder setIsSponsored(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      hasIsSponsored = false;
      isSponsored = false;
      return this;
    }
    hasIsSponsored = true;
    isSponsored = paramBoolean.booleanValue();
    return this;
  }
  
  public final Builder setSocialDetail(SocialDetail paramSocialDetail)
  {
    if (paramSocialDetail == null)
    {
      hasSocialDetail = false;
      socialDetail = null;
      return this;
    }
    hasSocialDetail = true;
    socialDetail = paramSocialDetail;
    return this;
  }
  
  public final Builder setUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasUrn = false;
      urn = null;
      return this;
    }
    hasUrn = true;
    urn = paramUrn;
    return this;
  }
  
  public final Builder setValue(Update.Value paramValue)
  {
    if (paramValue == null)
    {
      hasValue = false;
      value = null;
      return this;
    }
    hasValue = true;
    value = paramValue;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Update.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */