package com.linkedin.android.feed.endor.datamodel.update.single;

import android.text.Spannable;
import com.linkedin.android.feed.endor.datamodel.actor.ChannelActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.AnnotatedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class ChannelSingleUpdateDataModel
  extends SingleUpdateDataModel
{
  public Spannable headerText;
  public ChannelActorDataModel primaryActor;
  
  public ChannelSingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt, long paramLong, ChannelActorDataModel paramChannelActorDataModel, AnnotatedTextContentDataModel paramAnnotatedTextContentDataModel, SocialDetailDataModel paramSocialDetailDataModel, Spannable paramSpannable)
  {
    super(paramUpdate, paramList, paramInt, paramLong, paramChannelActorDataModel, paramAnnotatedTextContentDataModel, paramSocialDetailDataModel);
    headerText = paramSpannable;
    primaryActor = paramChannelActorDataModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.single.ChannelSingleUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */