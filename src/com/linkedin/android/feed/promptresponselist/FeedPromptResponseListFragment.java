package com.linkedin.android.feed.promptresponselist;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.FeedPromptResponseListAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.page.feed.BaseFeedFragment;
import com.linkedin.android.feed.shared.PullToRefreshListener;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.InfluencerActor;
import com.linkedin.android.pegasus.gen.voyager.feed.MemberActor;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Prompt;
import com.linkedin.android.pegasus.gen.voyager.feed.Prompt.Actor;
import com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeedPromptResponseListFragment
  extends BaseFeedFragment
{
  public static final String TAG = FeedPromptResponseListFragment.class.getSimpleName();
  @InjectView(2131755829)
  AppBarLayout appBarLayout;
  @InjectView(2131755783)
  ViewStub errorViewStub;
  private boolean initialUpdatesRendered;
  private boolean playFirstVideo;
  private Prompt prompt;
  @InjectView(2131755832)
  TextView promptActor;
  @InjectView(2131755833)
  TextView promptQuestion;
  private String promptUrn;
  @InjectView(2131755797)
  RecyclerView recyclerView;
  @InjectView(2131755831)
  Toolbar toolbar;
  private Update update;
  private String videoMetadataUrn;
  
  private void setupErrorViewStub(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ErrorPageViewModel localErrorPageViewModel;
    ErrorPageViewHolder localErrorPageViewHolder;
    if (getView() != null)
    {
      if (recyclerView != null) {
        recyclerView.setVisibility(8);
      }
      localErrorPageViewModel = new ErrorPageViewModel(errorViewStub);
      localErrorPageViewHolder = (ErrorPageViewHolder)localErrorPageViewModel.getCreator().createViewHolder(getView());
      errorDescriptionText = i18NManager.getString(paramInt1);
      errorImage = paramInt2;
      if (paramBoolean)
      {
        localLayoutInflater = getActivity().getLayoutInflater();
        applicationComponent.mediaCenter();
        localErrorPageViewModel.onBindViewHolderWithErrorTracking$18b8048(localLayoutInflater, localErrorPageViewHolder, tracker, getPageInstance());
      }
    }
    else
    {
      return;
    }
    LayoutInflater localLayoutInflater = getActivity().getLayoutInflater();
    applicationComponent.mediaCenter();
    localErrorPageViewModel.onBindViewHolder$49e9e35b(localLayoutInflater, localErrorPageViewHolder);
  }
  
  private void setupTopCard()
  {
    if (prompt == null) {}
    for (;;)
    {
      return;
      Object localObject = prompt.actor;
      if (influencerActorValue != null) {
        localObject = influencerActorValue.miniProfile;
      }
      while (localObject != null)
      {
        promptActor.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        promptActor.setText(i18NManager.getSpannedString(2131231268, new Object[] { I18NManager.getName((MiniProfile)localObject) }));
        promptQuestion.setText(AttributedTextUtils.getAttributedString(prompt.summary, getContext()));
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            NavigationUtils.onUpPressed(getActivity(), false);
          }
        });
        return;
        if (memberActorValue != null) {
          localObject = memberActorValue.miniProfile;
        } else {
          localObject = null;
        }
      }
    }
  }
  
  protected final FeedAdapter createFeedAdapter()
  {
    return new FeedPromptResponseListAdapter(getActivity(), applicationComponent, this);
  }
  
  protected final void deleteUpdate(String paramString)
  {
    feedAdapter.removeUpdateIfFound(paramString);
  }
  
  protected final void displayInitialUpdates(CollectionTemplate<Update, Metadata> paramCollectionTemplate, List<FeedUpdateViewModel> paramList, DataStore.Type paramType)
  {
    if ((prompt == null) && (!CollectionUtils.isEmpty(elements)) && (elements.get(0)).value.promptResponseUpdateValue != null))
    {
      prompt = elements.get(0)).value.promptResponseUpdateValue.prompt;
      promptUrn = prompt.urn.toString();
      setupTopCard();
    }
    if ((update != null) || (initialUpdatesRendered))
    {
      paramCollectionTemplate = new ArrayList(paramList);
      feedAdapter.renderViewModelChanges(paramCollectionTemplate);
      return;
    }
    resetFeedAdapter(paramList);
    initialUpdatesRendered = true;
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public final String enterPageKey()
  {
    return "feed_prompt_response_updates";
  }
  
  public final int feedType()
  {
    return 14;
  }
  
  protected final String getInitialFetchRoute()
  {
    return FeedRouteUtils.getPromptResponseUpdatesRoute(fragmentComponent, getFeedWidth(), promptUrn, videoMetadataUrn);
  }
  
  protected final Uri getLoadMoreRoute()
  {
    return FeedRouteUtils.getBasePromptResponseUpdatesRoute(fragmentComponent, getFeedWidth(), promptUrn, videoMetadataUrn);
  }
  
  public final String getLogTag()
  {
    return TAG;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("playFirstVideo", true);
    }
    playFirstVideo = bool;
    if (feedAdapter != null) {
      feedAdapter).playFirstVideo = playFirstVideo;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968763, paramViewGroup, false);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("playFirstVideo", feedAdapter).playFirstVideo);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getArguments();
    update = ((Update)RecordParceler.quietUnparcel(Update.BUILDER, "update", paramView));
    prompt = ((Prompt)RecordParceler.quietUnparcel(Prompt.BUILDER, "prompt", paramView));
    videoMetadataUrn = paramView.getString("videoMetadataUrn");
    if (prompt != null) {
      promptUrn = prompt.urn.toString();
    }
    paramView = (BaseActivity)getActivity();
    if (((promptUrn == null) && (videoMetadataUrn == null)) || (paramView == null))
    {
      getActivity().onBackPressed();
      return;
    }
    setupTopCard();
    if ((update == null) || (videoMetadataUrn == null)) {}
    for (;;)
    {
      appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener()
      {
        boolean offsetAdjusted;
        int scrollRange = -1;
        
        public final void onOffsetChanged(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
        {
          if (scrollRange == -1) {
            scrollRange = paramAnonymousAppBarLayout.getTotalScrollRange();
          }
          if (scrollRange + paramAnonymousInt == 0)
          {
            promptActor.setAlpha(0.0F);
            offsetAdjusted = true;
          }
          while (!offsetAdjusted) {
            return;
          }
          promptActor.setAlpha(1.0F);
          offsetAdjusted = false;
        }
      });
      return;
      paramView = new ModelTransformedCallback()
      {
        public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
        {
          if (!isAdded()) {
            return;
          }
          resetFeedAdapter(Collections.singletonList(viewModel));
        }
      };
      getFeedUpdateViewModel(fragmentComponent, viewPool, update, paramView);
    }
  }
  
  public final String pageKey()
  {
    return "feed_prompt_response_list";
  }
  
  protected final void setupRefreshListener()
  {
    final SwipeRefreshLayout localSwipeRefreshLayout = swipeRefreshLayout;
    localSwipeRefreshLayout.setOnRefreshListener(new PullToRefreshListener(fragmentComponent.tracker(), "feed_container")
    {
      public final void onRefresh()
      {
        super.onRefresh();
        localSwipeRefreshLayout.setRefreshing(true);
        String str = RUMHelper.pageInitRefresh(FeedPromptResponseListFragment.this);
        feedUpdatesDataProvider.refreshFeed(Tracker.createPageInstanceHeader(getPageInstance()), FeedRouteUtils.getPromptResponseUpdatesRoute(fragmentComponent, getFeedWidth(), promptUrn, videoMetadataUrn), str);
      }
    });
  }
  
  protected final void showEmptyMessage()
  {
    super.showEmptyMessage();
    setupErrorViewStub(2131231267, 2130838507, false);
  }
  
  public final void showErrorView(Throwable paramThrowable)
  {
    super.showErrorView(paramThrowable);
    setupErrorViewStub(2131231234, 2130838622, true);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */