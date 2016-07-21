package com.linkedin.android.feed.actorlist;

import com.linkedin.android.feed.endor.ui.update.actor.FeedActorUpdateDetailViewModel;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.components.FragmentComponent;

public final class FeedActorListAdapter
  extends EndlessViewModelAdapter<FeedActorUpdateDetailViewModel>
{
  FeedActorListAdapter(FragmentComponent paramFragmentComponent)
  {
    super(paramFragmentComponent.context(), paramFragmentComponent.mediaCenter(), null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.FeedActorListAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */