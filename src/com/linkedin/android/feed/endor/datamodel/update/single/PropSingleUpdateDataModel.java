package com.linkedin.android.feed.endor.datamodel.update.single;

import android.text.Spannable;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.PropContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropType;
import java.util.List;

public final class PropSingleUpdateDataModel
  extends SingleUpdateDataModel
{
  public Spannable headerText;
  public PropType propType;
  
  public PropSingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt, long paramLong, ActorDataModel paramActorDataModel, PropContentDataModel paramPropContentDataModel, SocialDetailDataModel paramSocialDetailDataModel, Spannable paramSpannable, PropType paramPropType, CharSequence paramCharSequence)
  {
    super(paramUpdate, paramList, paramInt, paramLong, paramActorDataModel, paramPropContentDataModel, paramSocialDetailDataModel, paramCharSequence);
    headerText = paramSpannable;
    propType = paramPropType;
  }
  
  public final boolean isReshareable()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.single.PropSingleUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */