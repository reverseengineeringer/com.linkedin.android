package com.linkedin.android.feed.endor.ui;

import android.content.Context;
import android.text.TextUtils;
import com.linkedin.android.feed.FeedTrackableFragment;
import com.linkedin.android.feed.endor.ui.component.endoffeed.FeedEndOfFeedViewModel;
import com.linkedin.android.feed.endor.ui.highlightedplaceholder.FeedHighlightedPlaceholderViewModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewModel;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdateInfo;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.LoadingViewHolder;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeedAdapter
  extends EndlessViewModelAdapter<FeedItemViewModel>
{
  public ApplicationComponent appComponent;
  private boolean containsHero;
  public List<? extends FeedItemViewModel> highlightedItemViewModels;
  public int lastPageTracked;
  private String nextPagePageKey;
  public boolean onScreen;
  private final Runnable pageViewRunnable = new Runnable()
  {
    public final void run()
    {
      if (pendingPageView != null)
      {
        pendingPageView.send();
        FeedAdapter.access$002$5e79ba79(FeedAdapter.this);
      }
    }
  };
  private PageViewEvent pendingPageView;
  private final Set<String> updatesToRelayOut = new HashSet();
  
  public FeedAdapter(Context paramContext, ApplicationComponent paramApplicationComponent, FeedTrackableFragment paramFeedTrackableFragment)
  {
    super(paramContext, paramApplicationComponent.mediaCenter(), null);
    appComponent = paramApplicationComponent;
    nextPagePageKey = paramFeedTrackableFragment.loadMorePageKey();
  }
  
  private boolean containsHero()
  {
    if (isEmpty()) {
      containsHero = false;
    }
    return containsHero;
  }
  
  private FeedItemViewModel getFirstNonHeroItem()
  {
    FeedItemViewModel localFeedItemViewModel = null;
    if (containsHero()) {
      if (values.size() > 1) {
        localFeedItemViewModel = (FeedItemViewModel)values.get(1);
      }
    }
    while (values.isEmpty()) {
      return localFeedItemViewModel;
    }
    return (FeedItemViewModel)values.get(0);
  }
  
  private void removeLoadingViewsIfNecessary()
  {
    FeedItemViewModel localFeedItemViewModel = getFirstNonHeroItem();
    if (containsHighlightedUpdates()) {
      localFeedItemViewModel = (FeedItemViewModel)getItemAtPosition(highlightedItemViewModels.size());
    }
    if ((localFeedItemViewModel instanceof FeedLoadingAnimationViewModel)) {
      removeValue(localFeedItemViewModel);
    }
  }
  
  public final void appendValues(List<? extends FeedItemViewModel> paramList)
  {
    removeLoadingViewsIfNecessary();
    super.appendValues(paramList);
  }
  
  public final boolean containsHighlightedUpdates()
  {
    if (isEmpty()) {}
    while ((highlightedItemViewModels == null) || (highlightedItemViewModels.isEmpty())) {
      return false;
    }
    return true;
  }
  
  public final boolean containsUpdate(FeedUpdateViewModel paramFeedUpdateViewModel)
  {
    int i = 0;
    while (i < values.size())
    {
      Object localObject = (FeedItemViewModel)values.get(i);
      if ((localObject instanceof FeedUpdateViewModel))
      {
        localObject = (FeedUpdateViewModel)localObject;
        if ((updateUrn != null) && (updateUrn.equals(updateUrn))) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public final FeedUpdateViewModel getUpdateViewModel(String paramString)
  {
    return FeedUpdateUtils.getUpdateViewModel(values, paramString);
  }
  
  public final boolean hasUpdates()
  {
    int j = 0;
    if (containsHero()) {
      j = 0 + 1;
    }
    int i = j;
    if ((getFirstNonHeroItem() instanceof FeedLoadingAnimationViewModel)) {
      i = j + 1;
    }
    j = i;
    if (isShowingNoMoresUpdatesView()) {
      j = i + 1;
    }
    return values.size() - j > 0;
  }
  
  public final void insertHighlightedPlaceholderViews(FragmentComponent paramFragmentComponent, HighlightedUpdateInfo[] paramArrayOfHighlightedUpdateInfo)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfHighlightedUpdateInfo.length);
    int i = 0;
    if (i < paramArrayOfHighlightedUpdateInfo.length)
    {
      if (type == "ACCEPTED_INVITATION") {}
      for (int j = 2131231251;; j = 2131231250)
      {
        localArrayList.add(new FeedHighlightedPlaceholderViewModel(paramFragmentComponent.i18NManager().getString(j)));
        i += 1;
        break;
      }
    }
    removeHighlightedItemViewModels();
    highlightedItemViewModels = localArrayList;
    prependValues(highlightedItemViewModels);
  }
  
  public final void insertLoadingViews()
  {
    if (!(getFirstNonHeroItem() instanceof FeedLoadingAnimationViewModel))
    {
      if (containsHighlightedUpdates()) {
        insertValues(Collections.singletonList(new FeedLoadingAnimationViewModel()), highlightedItemViewModels.size());
      }
    }
    else {
      return;
    }
    prependValues(Collections.singletonList(new FeedLoadingAnimationViewModel()));
  }
  
  public final void insertValues(List<? extends FeedItemViewModel> paramList, int paramInt)
  {
    removeLoadingViewsIfNecessary();
    super.insertValues(paramList, paramInt);
  }
  
  public final boolean isShowingNoMoresUpdatesView()
  {
    if (values.size() > 0) {}
    for (FeedItemViewModel localFeedItemViewModel = (FeedItemViewModel)values.get(values.size() - 1);; localFeedItemViewModel = null) {
      return localFeedItemViewModel instanceof FeedEndOfFeedViewModel;
    }
  }
  
  public void onBindViewHolder(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramBaseViewHolder, paramInt);
    FeedItemViewModel localFeedItemViewModel = (FeedItemViewModel)getItemAtPosition(paramInt);
    if ((!onScreen) || (localFeedItemViewModel == null) || ((paramBaseViewHolder instanceof LoadingViewHolder)) || ((localFeedItemViewModel instanceof FeedEndOfFeedViewModel)))
    {
      if (!(localFeedItemViewModel instanceof FeedUpdateViewModel)) {
        break label224;
      }
      paramBaseViewHolder = (FeedUpdateViewModel)localFeedItemViewModel;
      if (!updatesToRelayOut.contains(updateUrn)) {
        break label189;
      }
      updatesToRelayOut.remove(updateUrn);
    }
    label189:
    label224:
    while (!(localFeedItemViewModel instanceof CrossPromoHeroViewModel))
    {
      return;
      if (containsHero()) {}
      for (int i = paramInt - 1;; i = paramInt)
      {
        i /= 10;
        if (i == lastPageTracked) {
          break;
        }
        if (pendingPageView != null) {
          appComponent.delayedExecution().stopDelayedExecution(pageViewRunnable);
        }
        pendingPageView = new PageViewEvent(appComponent.tracker(), nextPagePageKey, false);
        appComponent.delayedExecution().postTrackingDelayedExecution(pageViewRunnable);
        lastPageTracked = i;
        break;
      }
      if (containsHero()) {
        paramInt -= 1;
      }
      for (;;)
      {
        paramBaseViewHolder.trackImpressionIfSponsored(Tracker.createPageInstanceHeader(appComponent.tracker().getCurrentPageInstance()), paramInt);
        return;
      }
    }
    ((CrossPromoHeroViewModel)localFeedItemViewModel).trackImpression();
  }
  
  public final void onLeave()
  {
    onScreen = false;
    appComponent.delayedExecution().stopDelayedExecution(pageViewRunnable);
  }
  
  public final void prependValues(List<? extends FeedItemViewModel> paramList)
  {
    removeLoadingViewsIfNecessary();
    super.prependValues(paramList);
  }
  
  public final boolean relayoutUpdateIfNecessary(FeedUpdateViewModel paramFeedUpdateViewModel)
  {
    return relayoutUpdateIfNecessary(paramFeedUpdateViewModel, updateUrn);
  }
  
  public final boolean relayoutUpdateIfNecessary(FeedUpdateViewModel paramFeedUpdateViewModel, String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < values.size())
      {
        Object localObject = (FeedItemViewModel)values.get(i);
        if ((localObject instanceof FeedUpdateViewModel))
        {
          localObject = (FeedUpdateViewModel)localObject;
          if (TextUtils.equals(updateUrn, paramString))
          {
            if (changeViewModel((ViewModel)localObject, paramFeedUpdateViewModel) == 2) {
              updatesToRelayOut.add(updateUrn);
            }
            bool1 = true;
          }
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final void removeHighlightedItemViewModels()
  {
    if (containsHighlightedUpdates())
    {
      removeValues(0, highlightedItemViewModels.size());
      highlightedItemViewModels.clear();
    }
  }
  
  public final int removeUpdateIfFound(String paramString)
  {
    int i = 0;
    while (i < values.size())
    {
      FeedItemViewModel localFeedItemViewModel = (FeedItemViewModel)values.get(i);
      if (((localFeedItemViewModel instanceof FeedUpdateViewModel)) && (TextUtils.equals(updateUrn, paramString)))
      {
        values.remove(i);
        notifyItemRemoved(i);
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final void setHero(FeedItemViewModel paramFeedItemViewModel)
  {
    if (paramFeedItemViewModel == null)
    {
      if (containsHero())
      {
        containsHero = false;
        removeValueAtPosition(0);
      }
      return;
    }
    setHero(null);
    prependValues(Collections.singletonList(paramFeedItemViewModel));
    containsHero = true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */