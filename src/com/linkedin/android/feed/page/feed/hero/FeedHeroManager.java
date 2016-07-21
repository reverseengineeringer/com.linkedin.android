package com.linkedin.android.feed.page.feed.hero;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.feed.FeedUpdatesDataProvider.State;
import com.linkedin.android.feed.page.feed.FeedFragment;
import com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewHolder;
import com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewModel;
import com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewModel.HeroDismissedEvent;
import com.linkedin.android.feed.page.feed.hero.crosspromo.FeedPromoInflater;
import com.linkedin.android.feed.page.feed.hero.guidededit.UeditFeedHeroViewModel;
import com.linkedin.android.feed.page.feed.hero.guidededit.UeditFeedTransformer.1;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFragmentHelper;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.identity.profile.view.guidededitentry.GuidedEditEntryTransformer;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditCategoryName;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditContextType;
import com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent.Builder;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.Subscribe;

public final class FeedHeroManager
{
  private CrossPromoHeroViewModel crossPromoViewModel;
  private Bus eventBus;
  private FeedFragment feedFragment;
  private FeedUpdatesDataProvider feedUpdatesDataProvider;
  public GuidedEditCategory guidedEditCategoryForFeed;
  public GuidedEditDataProvider guidedEditDataProvider;
  private AppBarLayout heroAppBarLayout;
  private CollapsingToolbarLayout heroContainer;
  private RecyclerView.LayoutManager layoutManager;
  private UeditFeedHeroViewModel ueditPromoViewModel;
  
  public FeedHeroManager(Bus paramBus, FeedFragment paramFeedFragment, FeedUpdatesDataProvider paramFeedUpdatesDataProvider, RecyclerView.LayoutManager paramLayoutManager, CollapsingToolbarLayout paramCollapsingToolbarLayout, AppBarLayout paramAppBarLayout)
  {
    eventBus = paramBus;
    feedFragment = paramFeedFragment;
    feedUpdatesDataProvider = paramFeedUpdatesDataProvider;
    guidedEditDataProvider = fragmentComponent.guidedEditDataProvider();
    layoutManager = paramLayoutManager;
    heroContainer = paramCollapsingToolbarLayout;
    heroAppBarLayout = paramAppBarLayout;
    Bus.subscribe(this);
    guidedEditDataProvider.register(paramFeedFragment);
    if (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.GUIDED_EDIT_U_EDIT_FEED_ENTRY))
    {
      paramBus = fragmentComponent.memberUtil().getProfileId();
      if (paramBus != null) {
        guidedEditDataProvider.fetchData(busSubscriberId, paramFeedFragment.getRumSessionId(), Tracker.createPageInstanceHeader(paramFeedFragment.getPageInstance()), paramBus, GuidedEditSource.FEED);
      }
    }
  }
  
  private void cleanupFeedHero()
  {
    if (heroContainer != null)
    {
      heroContainer.removeAllViews();
      crossPromoViewModel = null;
      ueditPromoViewModel = null;
    }
  }
  
  public final void dismissUEditHero(boolean paramBoolean)
  {
    cleanupFeedHero();
    guidedEditCategoryForFeed = null;
    if (paramBoolean) {
      feedFragment.hardRefreshFeed();
    }
  }
  
  public final void expandFeedHeroIfAvailable()
  {
    if ((heroContainer != null) && (heroContainer.getChildCount() > 0))
    {
      heroAppBarLayout.setExpanded(true, true);
      if (crossPromoViewModel != null) {
        crossPromoViewModel.trackImpression();
      }
      if (ueditPromoViewModel != null)
      {
        UeditFeedHeroViewModel localUeditFeedHeroViewModel = ueditPromoViewModel;
        Tracker localTracker = feedFragment.tracker;
        if (!hasFiredImpression)
        {
          legoTrackingDataProvider.sendWidgetImpressionEvent$4bb724c7(legoTrackingId, Visibility.SHOW);
          localTracker.send(new GuidedEditEntryImpressionEvent.Builder().setFlowTrackingId(flowTrackingId).setContextType(GuidedEditContextType.FEED).setGuidedEditCategoryName(guidedEditCategoryName));
          hasFiredImpression = true;
        }
      }
    }
  }
  
  @Subscribe
  public final void onEvent(CrossPromoHeroViewModel.HeroDismissedEvent paramHeroDismissedEvent)
  {
    showFeedHeroIfRequired();
  }
  
  public final void showFeedHeroIfRequired()
  {
    Object localObject1 = feedFragment.applicationComponent.tracker().trackingCodePrefix + "_" + feedFragment.pageKey();
    Object localObject2 = (FeedUpdatesDataProvider.State)feedUpdatesDataProvider.state;
    Object localObject3 = ((FeedUpdatesDataProvider.State)localObject2).getCrossPromo((String)localObject1);
    Object localObject4;
    I18NManager localI18NManager;
    if (localObject3 != null)
    {
      localObject4 = ((FeedUpdatesDataProvider.State)localObject2).getCrossPromoDismissed((String)localObject1);
      if ((!((AtomicBoolean)localObject4).get()) && (FeedPromoInflater.isHeroPromo((Promo)localObject3)))
      {
        feedFragment.applicationComponent.crossPromoManager();
        localObject1 = new CrossPromoHeroViewModel((String)localObject1, (Promo)localObject3, (AtomicBoolean)localObject4, ((FeedUpdatesDataProvider.State)localObject2).getCrossPromoImpressed((String)localObject1), eventBus, feedFragment.fragmentComponent);
        cleanupFeedHero();
        if (heroContainer != null)
        {
          crossPromoViewModel = ((CrossPromoHeroViewModel)localObject1);
          localObject1 = LayoutInflater.from(feedFragment.getContext());
          localObject1 = (CrossPromoHeroViewHolder)CrossPromoHeroViewHolder.CREATOR.createViewHolder(((LayoutInflater)localObject1).inflate(CrossPromoHeroViewHolder.CREATOR.getLayoutId(), null));
          localObject2 = crossPromoViewModel;
          feedFragment.fragmentComponent.mediaCenter();
          ((CrossPromoHeroViewModel)localObject2).onBindViewHolder$1c57c46f((CrossPromoHeroViewHolder)localObject1);
          heroContainer.addView(itemView, new CollapsingToolbarLayout.LayoutParams(-1, -2));
          if (com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(layoutManager)[0] > 1) {
            break label467;
          }
          feedFragment.scrollToTop();
        }
        for (;;)
        {
          i = 1;
          if ((i == 0) && (crossPromoViewModel == null) && (guidedEditCategoryForFeed != null) && (ueditPromoViewModel == null) && (FeedLixHelper.isEnabled(feedFragment.fragmentComponent.lixManager(), Lix.GUIDED_EDIT_U_EDIT_FEED_ENTRY)))
          {
            localObject3 = guidedEditCategoryForFeed;
            localObject4 = feedFragment.fragmentComponent;
            localI18NManager = ((FragmentComponent)localObject4).i18NManager();
            localObject2 = new UeditFeedHeroViewModel();
          }
          switch (com.linkedin.android.feed.page.feed.hero.guidededit.UeditFeedTransformer.2.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$identity$guidededit$CategoryNames[id.ordinal()])
          {
          default: 
            localObject1 = null;
            if (localObject1 != null)
            {
              cleanupFeedHero();
              if (heroContainer != null)
              {
                localObject2 = LayoutInflater.from(feedFragment.getContext());
                localObject2 = (FeedHeroViewHolder)FeedHeroViewHolder.CREATOR.createViewHolder(((LayoutInflater)localObject2).inflate(FeedHeroViewHolder.CREATOR.getLayoutId(), heroContainer));
                ((UeditFeedHeroViewModel)localObject1).onBindViewHolder$7d9602dc(feedFragment.fragmentComponent.mediaCenter(), (FeedHeroViewHolder)localObject2);
                ueditPromoViewModel = ((UeditFeedHeroViewModel)localObject1);
                if (com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(layoutManager)[0] > 1) {
                  break label981;
                }
                feedFragment.scrollToTop();
              }
            }
            return;
            label467:
            heroAppBarLayout.setExpanded(false, false);
          }
        }
      }
      if (((AtomicBoolean)localObject4).get()) {
        cleanupFeedHero();
      }
    }
    for (;;)
    {
      i = 0;
      break;
      if (((FeedUpdatesDataProvider.State)localObject2).getCrossPromoError((String)localObject1) == null) {
        feedUpdatesDataProvider.fetchCrossPromo((String)localObject1, feedFragment.busSubscriberId, feedFragment.getRumSessionId());
      }
    }
    icon = new ImageModel(null, 2130838485, null);
    title = localI18NManager.getString(2131231904, new Object[] { I18NManager.getName(((FragmentComponent)localObject4).memberUtil().getMiniProfile()) });
    int i = FeedLixHelper.parseInt$7e416bce(((FragmentComponent)localObject4).lixManager(), Lix.GUIDED_EDIT_FEED_ENTRY_TEXT, 1);
    localObject1 = ((FragmentComponent)localObject4).i18NManager();
    if (i == 2)
    {
      localObject1 = ((I18NManager)localObject1).getString(2131231906);
      label613:
      subtext = ((String)localObject1);
      entryButtonText = localI18NManager.getString(2131231817);
      guidedEditCategoryName = GuidedEditCategoryName.ADD_CURRENT_POSITION;
    }
    for (;;)
    {
      flowTrackingId = GuidedEditFragmentHelper.generateRandomTrackingId();
      if (CollectionUtils.isNonEmpty(tasks)) {
        legoTrackingId = tasks.get(0)).legoTrackingId;
      }
      legoTrackingDataProvider = ((FragmentComponent)localObject4).legoTrackingDataProvider();
      dismissButtonText = localI18NManager.getString(2131231871);
      toastOnClickListener = GuidedEditEntryTransformer.toGuidedEditEntryOnClickListener((FragmentComponent)localObject4, (GuidedEditCategory)localObject3, ((FragmentComponent)localObject4).profileDataProvider(), ((FragmentComponent)localObject4).legoTrackingDataProvider(), ((FragmentComponent)localObject4).tracker(), GuidedEditSource.FEED, flowTrackingId);
      cancelOnClickListener = new UeditFeedTransformer.1(((FragmentComponent)localObject4).tracker(), "ge_add_current_position_dismiss", new TrackingEventBuilder[0], (FragmentComponent)localObject4, (GuidedEditCategory)localObject3, (UeditFeedHeroViewModel)localObject2, this);
      localObject1 = localObject2;
      break;
      if (i == 3)
      {
        localObject1 = ((I18NManager)localObject1).getString(2131231907);
        break label613;
      }
      if (i == 4)
      {
        localObject1 = ((I18NManager)localObject1).getString(2131231908);
        break label613;
      }
      localObject1 = ((I18NManager)localObject1).getString(2131231905);
      break label613;
      icon = new ImageModel(null, 2130838485, null);
      title = localI18NManager.getString(2131231911, new Object[] { I18NManager.getName(((FragmentComponent)localObject4).memberUtil().getMiniProfile()) });
      subtext = localI18NManager.getString(2131231912);
      entryButtonText = localI18NManager.getString(2131231844);
      guidedEditCategoryName = GuidedEditCategoryName.ADD_PAST_POSITION;
      continue;
      icon = new ImageModel(null, 2130838625, null);
      title = localI18NManager.getString(2131231909, new Object[] { I18NManager.getName(((FragmentComponent)localObject4).memberUtil().getMiniProfile()) });
      subtext = localI18NManager.getString(2131231910);
      entryButtonText = localI18NManager.getString(2131231825);
      guidedEditCategoryName = GuidedEditCategoryName.ADD_EDUCATION;
    }
    label981:
    heroAppBarLayout.setExpanded(false, false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.FeedHeroManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */