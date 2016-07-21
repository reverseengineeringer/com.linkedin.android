package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ShareUpdate$Builder
  implements RecordTemplateBuilder<ShareUpdate>
{
  public List<UpdateAction> actions = null;
  public SocialActor actor = null;
  private ShareUpdateContent.Content content = null;
  public long createdTime = 0L;
  public boolean edited = false;
  public boolean hasActions = false;
  public boolean hasActor = false;
  private boolean hasContent = false;
  public boolean hasCreatedTime = false;
  public boolean hasEdited = false;
  private boolean hasHeader = false;
  public boolean hasShareAudience = false;
  private boolean hasShareUrn = false;
  private boolean hasTracking = false;
  private boolean hasTrackingId = false;
  public boolean hasUrn = false;
  private AttributedText header = null;
  public ShareAudience shareAudience = null;
  private Urn shareUrn = null;
  private TrackingData tracking = null;
  private String trackingId = null;
  public Urn urn = null;
  
  public ShareUpdate$Builder() {}
  
  public ShareUpdate$Builder(ShareUpdate paramShareUpdate)
  {
    content = content;
    shareAudience = shareAudience;
    actions = actions;
    urn = urn;
    actor = actor;
    createdTime = createdTime;
    trackingId = trackingId;
    tracking = tracking;
    header = header;
    edited = edited;
    shareUrn = shareUrn;
    hasContent = hasContent;
    hasShareAudience = hasShareAudience;
    hasActions = hasActions;
    hasUrn = hasUrn;
    hasActor = hasActor;
    hasCreatedTime = hasCreatedTime;
    hasTrackingId = hasTrackingId;
    hasTracking = hasTracking;
    hasHeader = hasHeader;
    hasEdited = hasEdited;
    hasShareUrn = hasShareUrn;
  }
  
  public final ShareUpdate build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final ShareUpdate build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ShareUpdate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
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
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "actions");
            if (!hasActions) {
              actions = Collections.emptyList();
            }
            if (!hasContent) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "content");
            }
            if (!hasShareAudience) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "shareAudience");
            }
            if (!hasActor) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "actor");
            }
            if (hasCreatedTime) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "createdTime");
          }
        }
      }
    }
    return new ShareUpdate(content, shareAudience, actions, urn, actor, createdTime, trackingId, tracking, header, edited, shareUrn, hasContent, hasShareAudience, hasActions, hasUrn, hasActor, hasCreatedTime, hasTrackingId, hasTracking, hasHeader, hasEdited, hasShareUrn);
  }
  
  public final Builder setContent(ShareUpdateContent.Content paramContent)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */