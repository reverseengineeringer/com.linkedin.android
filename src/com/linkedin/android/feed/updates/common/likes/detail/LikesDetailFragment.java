package com.linkedin.android.feed.updates.common.likes.detail;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.SocialDetailTransformer;
import com.linkedin.android.feed.endor.datamodel.transformer.UpdateException;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.detailheader.FeedDetailSectionHeaderTransformer;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewModel;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewTransformer;
import com.linkedin.android.feed.endor.ui.transformer.LikesDetailTransformer;
import com.linkedin.android.feed.events.FeedToggleLikeOrderingEvent;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.utils.FeedCollectionHelper;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Likes;
import com.linkedin.android.pegasus.gen.voyager.feed.Likes.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;

public class LikesDetailFragment
  extends PageFragment
  implements FeedPageType
{
  private static final String TAG = LikesDetailFragment.class.getSimpleName();
  private int feedType;
  private Like highlightedLike;
  private boolean initialLoadComplete;
  private LikesDataProvider likesDataProvider;
  private CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Like, Metadata>> likesDataProviderListener;
  private LikesDetailAdapter likesDetailAdapter;
  @InjectView(2131755824)
  FeedComponentsView likesHeader;
  private LinearLayoutManager likesLayoutManager;
  @InjectView(2131755825)
  RecyclerView likesRecyclerView;
  private boolean loadingMore;
  private SocialDetail socialDetail;
  @InjectView(2131755468)
  Toolbar toolbar;
  private TrackingData trackingData;
  private String updateEntityUrnString;
  private Urn updateUrn;
  private String updateUrnString;
  private final FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  
  private void fetchUpdateFromNetwork()
  {
    RecordTemplateListener local3 = new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<Update> paramAnonymousDataStoreResponse)
      {
        if (!isAdded()) {}
        do
        {
          return;
          if ((model != null) && (model).socialDetail != null) && (error == null) && (!initialLoadComplete))
          {
            LikesDetailFragment.access$602(LikesDetailFragment.this, model).tracking);
            LikesDetailFragment.this.setupSocialDetail(model).socialDetail);
            return;
          }
        } while ((error == null) || (type != DataStore.Type.NETWORK));
        getActivity();
        Util.safeThrow$7a8b4789(new RuntimeException("We couldn't get the update or social detail! we should probably throw a toast now for the user", error));
        getActivity().onBackPressed();
      }
    };
    if (updateUrnString == null) {
      return;
    }
    initialLoadComplete = false;
    likesDetailAdapter.showLoadingView(true);
    fragmentComponent.dataManager().submit(Request.get().url(FeedRouteUtils.getSingleUpdateUrl(fragmentComponent, updateUrnString, 0, null)).customHeaders(Tracker.createPageInstanceHeader(getPageInstance())).builder(Update.BUILDER).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener(local3));
  }
  
  private void setLikers(SocialDetail paramSocialDetail)
  {
    Object localObject = LikesDetailTransformer.toLikeViewModels(fragmentComponent, trackingData, updateUrn, likes.elements, highlightedLike);
    likesDetailAdapter.setValues((List)localObject);
    if ((BaseActivity)getActivity() != null) {
      localObject = getActivityactivityComponent;
    }
    try
    {
      Metadata localMetadata = new Metadata.Builder().build(RecordTemplate.Flavor.RECORD);
      paramSocialDetail = new CollectionTemplate(likes.elements, localMetadata, likes.paging, null, null, true, true, true);
      likesDataProvider.initWithCollectionTemplate((ActivityComponent)localObject, paramSocialDetail);
      showLoadingViewIfNecessary$1385ff();
      return;
    }
    catch (BuilderException paramSocialDetail)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Error building metadata model", paramSocialDetail));
    }
  }
  
  private void setupSocialDetail(SocialDetail paramSocialDetail)
  {
    FeedDividerViewModel localFeedDividerViewModel = null;
    if (threadId == null)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to perform setup as Social detail is null"));
      getActivity().onBackPressed();
      return;
    }
    long l = totalSocialActivityCounts.numLikes;
    Object localObject2 = fragmentComponent.i18NManager().getString(2131231300, new Object[] { Long.valueOf(l) });
    Object localObject3 = toolbar;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = null;
    }
    ((Toolbar)localObject3).setTitle((CharSequence)localObject1);
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = fragmentComponent.intentRegistry().home;
        FragmentActivity localFragmentActivity = getActivity();
        HomeBundle localHomeBundle = new HomeBundle();
        activeTab = HomeTabInfo.NOTIFICATIONS;
        paramAnonymousView = paramAnonymousView.newIntent(localFragmentActivity, localHomeBundle);
        NavigationUtils.navigateUp(getActivity(), paramAnonymousView, false);
      }
    });
    if (!FeedLixHelper.isEnabled(applicationComponent.lixManager(), Lix.FEED_TOGGLE_LIKES_ORDERING)) {
      likesHeader.setVisibility(8);
    }
    for (;;)
    {
      setLikers(paramSocialDetail);
      initialLoadComplete = true;
      return;
      likesHeader.setVisibility(0);
      try
      {
        localObject2 = Urn.createFromString(updateUrnString);
        localObject1 = fragmentComponent;
        localObject3 = FeedDataModelMetadata.DEFAULT;
        if (paramSocialDetail == null)
        {
          localObject1 = localFeedDividerViewModel;
          localObject1 = FeedDetailSectionHeaderTransformer.toViewModel(fragmentComponent, (SocialDetailDataModel)localObject1, 2131231255, trackingData, (Urn)localObject2);
          if (localObject1 == null) {
            continue;
          }
          localFeedDividerViewModel = FeedDividerViewTransformer.getDefaultViewModel();
          likesHeader.renderComponents(Arrays.asList(new FeedComponentViewModel[] { localObject1, localFeedDividerViewModel }), viewPool, applicationComponent.mediaCenter());
        }
      }
      catch (UpdateException localUpdateException)
      {
        for (;;)
        {
          getContext();
          Util.safeThrow$7a8b4789(new RuntimeException(localUpdateException));
          break;
          SocialDetailDataModel localSocialDetailDataModel = SocialDetailTransformer.toDataModel(localUpdateException, paramSocialDetail, Collections.emptyList(), highlightedLike);
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;) {}
      }
    }
  }
  
  private void showLoadingViewIfNecessary$1385ff()
  {
    LikesDetailAdapter localLikesDetailAdapter = likesDetailAdapter;
    if (likesDataProvider.hasMoreLikes()) {}
    for (boolean bool = true;; bool = false)
    {
      localLikesDetailAdapter.showLoadingView(bool);
      return;
    }
  }
  
  public final void doEnter()
  {
    super.doEnter();
    Tracker localTracker = tracker;
    String str;
    if (feedType == 9) {
      str = "group_detail_likes";
    }
    for (;;)
    {
      new PageViewEvent(localTracker, str, false).send();
      return;
      if (feedType == 8) {
        str = "prop_detail_likes";
      } else if (feedType == 13) {
        str = "comment_detail_likes";
      } else {
        str = "feed_detail_likes";
      }
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public final int feedType()
  {
    return 15;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      updateUrnString = LikesDetailBundleBuilder.getUpdateUrnString(localBundle);
      if (updateUrnString == null)
      {
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Dang it, we don't have updateUrnString"));
      }
      updateUrn = LikesDetailBundleBuilder.getUpdateUrn(localBundle);
      if (updateUrn == null)
      {
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Dang it, we don't have updateUrn"));
      }
      if (localBundle != null) {
        break label240;
      }
      paramBundle = null;
      updateEntityUrnString = paramBundle;
      trackingData = ((TrackingData)RecordParceler.quietUnparcel(TrackingData.BUILDER, "trackingData", localBundle));
      socialDetail = ((SocialDetail)RecordParceler.quietUnparcel(SocialDetail.BUILDER, "socialDetail", localBundle));
      if (localBundle != null) {
        break label251;
      }
    }
    label240:
    label251:
    for (int i = 1;; i = localBundle.getInt("feedType"))
    {
      feedType = i;
      highlightedLike = ((Like)RecordParceler.quietUnparcel(Like.BUILDER, "highlightedLike", localBundle));
      if ((BaseActivity)getActivity() != null)
      {
        likesDataProvider = getActivityactivityComponent.likesDataProvider();
        likesDataProviderListener = new CollectionDataProvider.CollectionDataProviderListener()
        {
          public final void onDataFinishedLoading(DataStore.Type paramAnonymousType, DataManagerException paramAnonymousDataManagerException) {}
          
          public final void onFetching()
          {
            if ((!isAdded()) || (likesDetailAdapter == null)) {}
            while (!initialLoadComplete) {
              return;
            }
            likesDetailAdapter.showLoadingView(true);
          }
          
          public final void onFinishedFetching()
          {
            if ((!isAdded()) || (likesDetailAdapter == null)) {}
            while (!initialLoadComplete) {
              return;
            }
            likesDetailAdapter.showLoadingView(false);
          }
        };
        likesDataProvider.addListener(likesDataProviderListener);
      }
      likesDetailAdapter = new LikesDetailAdapter(getActivity(), applicationComponent.mediaCenter());
      return;
      paramBundle = localBundle.getString("updateEntityUrn");
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968759, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    if (likesDataProvider != null) {
      likesDataProvider.removeListener(likesDataProviderListener);
    }
    likesDataProviderListener = null;
    likesDataProvider = null;
    likesDetailAdapter = null;
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    if (likesRecyclerView != null) {
      likesRecyclerView.setAdapter(null);
    }
    if (likesLayoutManager != null)
    {
      likesLayoutManager.mRecycleChildrenOnDetach = true;
      likesLayoutManager = null;
    }
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(FeedToggleLikeOrderingEvent paramFeedToggleLikeOrderingEvent)
  {
    Object localObject = order;
    for (;;)
    {
      try
      {
        if (socialDetail.likes.metadata == null) {
          continue;
        }
        localBuilder = new Metadata.Builder(socialDetail.likes.metadata);
        localBuilder.setSort((SortOrder)localObject);
        localObject = new Likes.Builder(socialDetail.likes);
        ((Likes.Builder)localObject).setElements(Collections.emptyList()).setMetadata(localBuilder.build(RecordTemplate.Flavor.RECORD)).setPaging(new CollectionMetadata.Builder().setStart(Integer.valueOf(0)).setCount(Integer.valueOf(0)).setTotal(Integer.valueOf(socialDetail.likes.paging.total)).setLinks(Collections.emptyList()).build(RecordTemplate.Flavor.RECORD));
        socialDetail = new SocialDetail.Builder(socialDetail).setLikes(((Likes.Builder)localObject).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
      }
      catch (BuilderException localBuilderException)
      {
        Metadata.Builder localBuilder;
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("failed to updateLikesSortOrder by sortOrder", localBuilderException));
        continue;
        setupSocialDetail(socialDetail);
        initialLoadComplete = false;
        if ((likesDataProvider == null) || (socialDetail == null) || (socialDetail.threadId == null)) {
          continue;
        }
        paramFeedToggleLikeOrderingEvent = FeedRouteUtils.getBaseLikesDetailRoute(socialDetail.threadId, order);
        LikesDataProvider localLikesDataProvider = likesDataProvider;
        localObject = Tracker.createPageInstanceHeader(getPageInstance());
        String str = getRumSessionId();
        if (state).collectionHelper != null) {
          continue;
        }
        Util.safeThrow(new RuntimeException("Collection helper is null. Please make sure initWithCollectionTemplatehas been called"));
        return;
        state).collectionHelper.fetchInitialData((Map)localObject, 3, paramFeedToggleLikeOrderingEvent.toString(), localLikesDataProvider.modelListener(false), str);
      }
      if (isAdded()) {
        continue;
      }
      return;
      localBuilder = new Metadata.Builder();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    likesLayoutManager = new LinearLayoutManager(getActivity());
    likesRecyclerView.setLayoutManager(likesLayoutManager);
    likesRecyclerView.setAdapter(likesDetailAdapter);
    likesRecyclerView.addOnScrollListener(new InfiniteScrollListener()
    {
      public final void loadMore()
      {
        if ((socialDetail == null) || (socialDetail.threadId == null)) {}
        while ((!initialLoadComplete) || (loadingMore) || (!likesDataProvider.hasMoreLikes())) {
          return;
        }
        LikesDetailFragment.access$202(LikesDetailFragment.this, true);
        Object localObject2 = socialDetail.threadId;
        Object localObject1 = socialDetail;
        if ((localObject1 != null) && (likes.metadata != null) && (likes.metadata.sort != null)) {}
        Map localMap;
        String str;
        for (localObject1 = likes.metadata.sort;; localObject1 = SortOrder.$UNKNOWN)
        {
          localObject1 = FeedRouteUtils.getBaseLikesDetailRoute((String)localObject2, (SortOrder)localObject1);
          localObject2 = likesDataProvider;
          localMap = Tracker.createPageInstanceHeader(getPageInstance());
          str = getRumSessionId();
          if (state).collectionHelper != null) {
            break;
          }
          Util.safeThrow(new RuntimeException("Collection helper is null. Please make sure initWithCollectionTemplatehas been called"));
          return;
        }
        state).collectionHelper.fetchLoadMoreData(localMap, 1, null, (Uri)localObject1, ((LikesDataProvider)localObject2).modelListener(true), str);
      }
    });
    if (socialDetail != null) {
      setupSocialDetail(socialDetail);
    }
    while (TextUtils.isEmpty(updateUrnString)) {
      return;
    }
    paramView = new DefaultModelListener()
    {
      public final void onCacheError(DataManagerException paramAnonymousDataManagerException)
      {
        LikesDetailFragment.this.fetchUpdateFromNetwork();
      }
    };
    if (updateEntityUrnString != null)
    {
      FeedBundleBuilder.loadUpdateFromCache(fragmentComponent.dataManager(), paramView, updateEntityUrnString);
      return;
    }
    fetchUpdateFromNetwork();
  }
  
  public final String pageKey()
  {
    return "detail_likes_base";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */