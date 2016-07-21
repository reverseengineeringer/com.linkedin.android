package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DiscussionUpdate$Builder
  implements RecordTemplateBuilder<DiscussionUpdate>
{
  private List<UpdateAction> actions = null;
  private boolean active = false;
  private SocialActor actor = null;
  private DiscussionUpdateContent.Content content = null;
  private long createdTime = 0L;
  private DiscussionSource discussionSource = null;
  private boolean featured = false;
  private boolean hasActions = false;
  private boolean hasActive = false;
  private boolean hasActor = false;
  private boolean hasContent = false;
  private boolean hasCreatedTime = false;
  private boolean hasDiscussionSource = false;
  private boolean hasFeatured = false;
  private boolean hasId = false;
  private boolean hasMiniGroup = false;
  private boolean hasTracking = false;
  private boolean hasTrackingId = false;
  private boolean hasUrn = false;
  private String id = null;
  private MiniGroup miniGroup = null;
  private TrackingData tracking = null;
  private String trackingId = null;
  private Urn urn = null;
  
  public final DiscussionUpdate build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (DiscussionUpdate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (actions != null)
    {
      paramFlavor = actions.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((UpdateAction)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "actions");
            if (!hasActions) {
              actions = Collections.emptyList();
            }
            if (!hasContent) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "content");
            }
            if (!hasActor) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "actor");
            }
            if (!hasMiniGroup) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "miniGroup");
            }
            if (hasCreatedTime) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "createdTime");
          }
        }
      }
    }
    return new DiscussionUpdate(content, actions, id, urn, discussionSource, actor, miniGroup, featured, active, createdTime, trackingId, tracking, hasContent, hasActions, hasId, hasUrn, hasDiscussionSource, hasActor, hasMiniGroup, hasFeatured, hasActive, hasCreatedTime, hasTrackingId, hasTracking);
  }
  
  public final Builder setActions(List<UpdateAction> paramList)
  {
    if ((paramList == null) || (paramList.equals(Collections.emptyList())))
    {
      hasActions = false;
      actions = Collections.emptyList();
      return this;
    }
    hasActions = true;
    actions = paramList;
    return this;
  }
  
  public final Builder setActive(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      hasActive = false;
      active = false;
      return this;
    }
    hasActive = true;
    active = paramBoolean.booleanValue();
    return this;
  }
  
  public final Builder setActor(SocialActor paramSocialActor)
  {
    if (paramSocialActor == null)
    {
      hasActor = false;
      actor = null;
      return this;
    }
    hasActor = true;
    actor = paramSocialActor;
    return this;
  }
  
  public final Builder setContent(DiscussionUpdateContent.Content paramContent)
  {
    if (paramContent == null)
    {
      hasContent = false;
      content = null;
      return this;
    }
    hasContent = true;
    content = paramContent;
    return this;
  }
  
  public final Builder setCreatedTime(Long paramLong)
  {
    if (paramLong == null)
    {
      hasCreatedTime = false;
      createdTime = 0L;
      return this;
    }
    hasCreatedTime = true;
    createdTime = paramLong.longValue();
    return this;
  }
  
  public final Builder setDiscussionSource(DiscussionSource paramDiscussionSource)
  {
    if (paramDiscussionSource == null)
    {
      hasDiscussionSource = false;
      discussionSource = null;
      return this;
    }
    hasDiscussionSource = true;
    discussionSource = paramDiscussionSource;
    return this;
  }
  
  public final Builder setFeatured(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      hasFeatured = false;
      featured = false;
      return this;
    }
    hasFeatured = true;
    featured = paramBoolean.booleanValue();
    return this;
  }
  
  public final Builder setMiniGroup(MiniGroup paramMiniGroup)
  {
    if (paramMiniGroup == null)
    {
      hasMiniGroup = false;
      miniGroup = null;
      return this;
    }
    hasMiniGroup = true;
    miniGroup = paramMiniGroup;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */