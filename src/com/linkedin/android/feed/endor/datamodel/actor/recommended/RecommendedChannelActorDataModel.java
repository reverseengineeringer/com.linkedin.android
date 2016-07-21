package com.linkedin.android.feed.endor.datamodel.actor.recommended;

import com.linkedin.android.feed.endor.datamodel.actor.ChannelActorDataModel;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public final class RecommendedChannelActorDataModel
  extends RecommendedActorDataModel<ChannelActorDataModel>
{
  public final String trackingId;
  
  public RecommendedChannelActorDataModel(ChannelActorDataModel paramChannelActorDataModel, AnnotatedText paramAnnotatedText, String paramString)
  {
    super(paramChannelActorDataModel, paramAnnotatedText);
    trackingId = paramString;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.actor.recommended.RecommendedChannelActorDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */