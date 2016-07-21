package com.linkedin.android.feed.page.feed.hero.guidededit;

import android.view.View;
import com.linkedin.android.feed.page.feed.hero.FeedHeroManager;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFragmentHelper;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.profile.view.guidededitentry.GuidedEditEntryTransformer;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEntryAction;

public final class UeditFeedTransformer$1
  extends TrackingOnClickListener
{
  public UeditFeedTransformer$1(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, GuidedEditCategory paramGuidedEditCategory, UeditFeedHeroViewModel paramUeditFeedHeroViewModel, FeedHeroManager paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    GuidedEditFragmentHelper.sendGuidedEditEntryActionEvent(val$fragmentComponent.tracker(), val$guidedEditCategory, GuidedEditEntryAction.DISMISS, GuidedEditSource.FEED, val$viewModel.flowTrackingId);
    GuidedEditEntryTransformer.sendLegoActionEvent(val$guidedEditCategory, ActionCategory.DISMISS, val$fragmentComponent.legoTrackingDataProvider());
    val$feedHeroManager.dismissUEditHero(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.guidededit.UeditFeedTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */