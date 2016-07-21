package com.linkedin.android.feed.endor.datamodel.actor.recommended;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public abstract class RecommendedActorDataModel<T extends ActorDataModel>
{
  public final T actor;
  public final AnnotatedText reason;
  
  public RecommendedActorDataModel(T paramT, AnnotatedText paramAnnotatedText)
  {
    actor = paramT;
    reason = paramAnnotatedText;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.actor.recommended.RecommendedActorDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */