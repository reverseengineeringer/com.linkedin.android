package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Reshare$Builder
  implements RecordTemplateBuilder<Reshare>
{
  public List<UpdateAction> actions = null;
  public SocialActor actor = null;
  private AttributedText attributedText = null;
  public long createdTime = 0L;
  public boolean edited = false;
  public boolean hasActions = false;
  public boolean hasActor = false;
  private boolean hasAttributedText = false;
  public boolean hasCreatedTime = false;
  public boolean hasEdited = false;
  private boolean hasHeader = false;
  public boolean hasOriginalUpdate = false;
  public boolean hasShareAudience = false;
  private boolean hasShareUrn = false;
  private boolean hasText = false;
  private boolean hasTracking = false;
  private boolean hasTrackingId = false;
  public boolean hasUrn = false;
  private AttributedText header = null;
  public Update originalUpdate = null;
  public ShareAudience shareAudience = null;
  private Urn shareUrn = null;
  private AnnotatedText text = null;
  private TrackingData tracking = null;
  private String trackingId = null;
  public Urn urn = null;
  
  public Reshare$Builder() {}
  
  public Reshare$Builder(Reshare paramReshare)
  {
    shareAudience = shareAudience;
    actions = actions;
    urn = urn;
    text = text;
    attributedText = attributedText;
    originalUpdate = originalUpdate;
    actor = actor;
    createdTime = createdTime;
    trackingId = trackingId;
    tracking = tracking;
    header = header;
    edited = edited;
    shareUrn = shareUrn;
    hasShareAudience = hasShareAudience;
    hasActions = hasActions;
    hasUrn = hasUrn;
    hasText = hasText;
    hasAttributedText = hasAttributedText;
    hasOriginalUpdate = hasOriginalUpdate;
    hasActor = hasActor;
    hasCreatedTime = hasCreatedTime;
    hasTrackingId = hasTrackingId;
    hasTracking = hasTracking;
    hasHeader = hasHeader;
    hasEdited = hasEdited;
    hasShareUrn = hasShareUrn;
  }
  
  public final Reshare build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Reshare.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
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
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "actions");
            if (!hasActions) {
              actions = Collections.emptyList();
            }
            if (!hasShareAudience) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "shareAudience");
            }
            if (!hasOriginalUpdate) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "originalUpdate");
            }
            if (!hasActor) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "actor");
            }
            if (hasCreatedTime) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "createdTime");
          }
        }
      }
    }
    return new Reshare(shareAudience, actions, urn, text, attributedText, originalUpdate, actor, createdTime, trackingId, tracking, header, edited, shareUrn, hasShareAudience, hasActions, hasUrn, hasText, hasAttributedText, hasOriginalUpdate, hasActor, hasCreatedTime, hasTrackingId, hasTracking, hasHeader, hasEdited, hasShareUrn);
  }
  
  public final Builder setText(AnnotatedText paramAnnotatedText)
  {
    if (paramAnnotatedText == null)
    {
      hasText = false;
      text = null;
      return this;
    }
    hasText = true;
    text = paramAnnotatedText;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Reshare.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */