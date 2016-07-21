package com.linkedin.android.feed.endor.ui.component.miniheader;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;

public final class FeedMiniHeaderTransformer
{
  public static FeedBasicTextViewModel toViewModel(FragmentComponent paramFragmentComponent, UpdateDataModel paramUpdateDataModel)
  {
    if (!(paramUpdateDataModel instanceof ConnectionUpdateDataModel)) {}
    do
    {
      return null;
      localObject1 = (ConnectionUpdateDataModel)paramUpdateDataModel;
    } while (!(actor instanceof MemberActorDataModel));
    FeedBasicTextViewModel localFeedBasicTextViewModel = new FeedBasicTextViewModel(new FeedMiniHeaderLayout(paramFragmentComponent.context().getResources()));
    Object localObject2 = pegasusUpdate;
    MemberActorDataModel localMemberActorDataModel = (MemberActorDataModel)actor;
    paramUpdateDataModel = formattedName;
    Object localObject1 = paramFragmentComponent.i18NManager().getString(2131231165, new Object[] { paramUpdateDataModel });
    int i = ((String)localObject1).indexOf(paramUpdateDataModel);
    paramFragmentComponent = FeedTracking.newProfileSpan$6c198643((MiniProfile)metadata, paramFragmentComponent, 2131623958, "connected_actor", (Update)localObject2);
    localObject2 = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
    ((SpannableStringBuilder)localObject2).setSpan(paramFragmentComponent, i, paramUpdateDataModel.length() + i, 17);
    text = ((CharSequence)localObject2);
    return localFeedBasicTextViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.miniheader.FeedMiniHeaderTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */