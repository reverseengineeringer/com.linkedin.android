package com.linkedin.android.feed.endor.datamodel.social;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;

public final class LikeDataModel
{
  public ActorDataModel actor;
  public final long createTime;
  public String threadId;
  
  public LikeDataModel(ActorDataModel paramActorDataModel, String paramString, long paramLong)
  {
    actor = paramActorDataModel;
    threadId = paramString;
    createTime = paramLong;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.social.LikeDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */