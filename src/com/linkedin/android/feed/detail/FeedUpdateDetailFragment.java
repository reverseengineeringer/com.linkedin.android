package com.linkedin.android.feed.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.actions.ControlMenuBundleBuilder;
import com.linkedin.android.feed.actions.UpdateActionPublisher;
import com.linkedin.android.feed.actions.UpdateActionPublisher.DeleteUpdateActionListener;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata.Builder;
import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentLongClickHandler;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentTransformer;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModel;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModelUtils;
import com.linkedin.android.feed.endor.ui.component.comment.FeedReplyLongClickHandler;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.events.FeedCommentButtonClickEvent;
import com.linkedin.android.feed.events.FeedCommentLongClickEvent;
import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.events.FeedOpenCommentDetailEvent;
import com.linkedin.android.feed.events.FeedReplyLongClickEvent;
import com.linkedin.android.feed.events.FeedReplyUpdateEvent;
import com.linkedin.android.feed.events.FeedToggleCommentOrderingEvent;
import com.linkedin.android.feed.events.LoadMoreEvent;
import com.linkedin.android.feed.events.MentionStartSuggestionTrackingEvent;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.tracking.MentionsTracking;
import com.linkedin.android.feed.tracking.SponsoredUpdateTracker;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailBundleBuilder;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment;
import com.linkedin.android.feed.updates.common.footer.SocialFooterViewHolder;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.feed.utils.FeedErrorViewModels.3;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.VoyagerShakeDelegate.ShakeDebugDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.consistency.ModelListConsistencyCoordinator;
import com.linkedin.consistency.ModelListItemChangedListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionActionType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class FeedUpdateDetailFragment
  extends PageFragment
  implements BaseSocialFooterManager.SocialFooterStateChangeListener, FeedPageType, VoyagerShakeDelegate.ShakeDebugDataProvider
{
  private static final String TAG;
  @Inject
  ActivityComponent activityComponent;
  private int anchorPoint;
  private final ModelListItemChangedListener<Comment> commentChangedListener = new ModelListItemChangedListener() {};
  private ModelListConsistencyCoordinator<Comment> commentConsistencyCoordinator;
  @InjectView(2131755763)
  FrameLayout contentContainer;
  private TrackingOnClickListener controlMenuClickListener;
  private SocialDetail currentSocialDetail;
  private Update currentUpdate;
  @Inject
  DelayedExecution delayedExecution;
  FeedUpdateDetailAdapter detailAdapter;
  private FeedUpdateDetailDataProvider detailDataProvider;
  @InjectView(2131755764)
  RecyclerView detailRecyclerView;
  @InjectView(2131755765)
  View dismissComposeView;
  long displayedTime;
  private ErrorPageViewHolder errorPageViewHolder;
  private ErrorPageViewModel errorViewModel;
  @InjectView(2131755762)
  ViewStub errorViewStub;
  private LinearLayoutManager feedLayoutManager;
  private int feedType;
  @InjectView(2131755865)
  LinearLayout footerContainer;
  @Inject
  FragmentComponent fragmentComponent;
  private String[] highlightedCommentUrns;
  private String[] highlightedLikeUrns;
  private String[] highlightedReplyUrns;
  private RecyclerView.OnScrollListener infiniteScrollListener = new InfiniteScrollListener()
  {
    public final void loadMore()
    {
      if ((detailDataProvider != null) && (detailDataProvider.hasNextComments()) && (!loadingMoreComments) && (!loadingSocialDetail))
      {
        FeedUpdateDetailFragment.access$502$74222c4(FeedUpdateDetailFragment.this);
        fragmentComponent.eventBus();
        Bus.publish(LoadMoreEvent.comments(1));
      }
    }
  };
  private boolean lastCommentLoadEmpty;
  @InjectView(2131755761)
  View loading;
  private boolean loadingMoreComments;
  private boolean loadingSocialDetail;
  private String mentionWorkFlowId;
  @Inject
  MentionsPresenter mentionsPresenter;
  @InjectView(2131755766)
  RecyclerView mentionsRecyclerView;
  private CharSequence menuTitle;
  private SocialFooterViewHolder socialFooter;
  private FeedUpdateDetailSocialFooterManager socialFooterManager;
  private String threadId;
  @InjectView(2131755468)
  Toolbar toolbar;
  private String trackingId;
  private final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  private String updateEntityUrnString;
  private String updateUrn;
  private FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  @Inject
  ViewPortManager viewPortManager;
  private String viralUpdateUrn;
  
  static
  {
    if (!FeedUpdateDetailFragment.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      TAG = FeedUpdateDetailFragment.class.getSimpleName();
      return;
    }
  }
  
  private void fetchSocialDetailFromNetwork()
  {
    fetchSocialDetailFromNetwork(FeedRouteUtils.getSocialDetailUrl(fragmentComponent, updateUrn, getCommentSortOrder()));
  }
  
  private void fetchSocialDetailFromNetwork(String paramString)
  {
    loadingSocialDetail = true;
    if (!TextUtils.isEmpty(getRumSessionId()))
    {
      FeedUpdateDetailDataProvider localFeedUpdateDetailDataProvider = detailDataProvider;
      String str1 = busSubscriberId;
      String str2 = getRumSessionId();
      String[] arrayOfString1 = highlightedCommentUrns;
      String[] arrayOfString2 = highlightedLikeUrns;
      String[] arrayOfString3 = highlightedReplyUrns;
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      state).socialDetailRoute = paramString;
      Object localObject = localFeedUpdateDetailDataProvider.newModelListener(str1, str2);
      paramString = Request.get().url(paramString).customHeaders(localMap).builder(SocialDetail.BUILDER).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      localObject = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      paramString = ((MultiplexRequest.Builder)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(paramString);
      FeedUpdateDetailDataProvider.addCommentRequests(paramString, arrayOfString1, localMap);
      FeedUpdateDetailDataProvider.addCommentRequests(paramString, arrayOfString3, localMap);
      FeedUpdateDetailDataProvider.addLikeRequests(paramString, arrayOfString2, localMap);
      localFeedUpdateDetailDataProvider.performMultiplexedFetch(str1, str2, localMap, paramString);
    }
  }
  
  private void fetchUpdateFromNetwork()
  {
    Object localObject = fragmentComponent;
    String str1 = updateUrn;
    String str2 = trackingId;
    localObject = FeedRouteUtils.getSingleUpdateUrl((FragmentComponent)localObject, str1, FeedRouteUtils.getCommentCount(((FragmentComponent)localObject).lixManager()), str2);
    if (!TextUtils.isEmpty(getRumSessionId())) {
      detailDataProvider.performFullUpdateFetch(busSubscriberId, getRumSessionId(), (String)localObject, highlightedCommentUrns, highlightedLikeUrns, highlightedReplyUrns, Tracker.createPageInstanceHeader(getPageInstance()));
    }
  }
  
  private SortOrder getCommentSortOrder()
  {
    if ((currentSocialDetail != null) && (currentSocialDetail.comments.metadata != null)) {
      return currentSocialDetail.comments.metadata.sort;
    }
    return null;
  }
  
  private FeedDataModelMetadata getDataModelMetadata(int paramInt)
  {
    FeedDataModelMetadata.Builder localBuilder = new FeedDataModelMetadata.Builder();
    if ((highlightedLikeUrns == null) || (highlightedLikeUrns.length <= 0)) {}
    for (Like localLike = null;; localLike = (Like)((FeedUpdateDetailDataProvider.UpdateDetailState)detailDataProvider.state).getModel(FeedRouteUtils.getSingleLikeUrl(highlightedLikeUrns[0])))
    {
      highlightedLike = localLike;
      highlightedCommentUrns = highlightedCommentUrns;
      highlightedReplyUrns = highlightedReplyUrns;
      pendingState = paramInt;
      return localBuilder.build();
    }
  }
  
  @SuppressLint({"SwitchIntDef"})
  private String getDetailPageKey()
  {
    switch (feedType)
    {
    default: 
      return "feed_detail";
    case 9: 
      return "group_detail";
    }
    return "prop_detail";
  }
  
  private List<Comment> getHighlightedComments()
  {
    int i;
    Object localObject1;
    if (highlightedCommentUrns == null)
    {
      i = 0;
      if (i > 0) {
        break label30;
      }
      localObject1 = Collections.emptyList();
    }
    label30:
    int j;
    Object localObject5;
    Object localObject2;
    label133:
    Object localObject3;
    label238:
    Map localMap;
    String[] arrayOfString;
    do
    {
      return (List<Comment>)localObject1;
      i = highlightedCommentUrns.length;
      break;
      if (highlightedReplyUrns == null)
      {
        j = 0;
        if (j > 0) {
          break label133;
        }
        localObject1 = Collections.emptyList();
      }
      for (;;)
      {
        localObject5 = new ArrayMap(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Comment)((Iterator)localObject1).next();
          if (parentCommentUrn != null) {
            ((Map)localObject5).put(parentCommentUrn.toString(), localObject2);
          }
        }
        j = highlightedReplyUrns.length;
        break;
        localObject1 = new ArrayList(j);
        localObject2 = getHighlightedCommentsOrRepliesFromUpdate();
        localObject3 = highlightedReplyUrns;
        int k = localObject3.length;
        j = 0;
        if (j < k)
        {
          localObject5 = localObject3[j];
          if (localObject5 != null)
          {
            localObject4 = ((FeedUpdateDetailDataProvider.UpdateDetailState)detailDataProvider.state).comment((String)localObject5);
            localObject5 = (Comment)((Map)localObject2).get(localObject5);
            if ((localObject4 == null) || (parentCommentUrn == null)) {
              break label238;
            }
            ((List)localObject1).add(localObject4);
          }
          for (;;)
          {
            j += 1;
            break;
            if ((localObject5 != null) && (parentCommentUrn != null)) {
              ((List)localObject1).add(localObject5);
            }
          }
        }
      }
      localObject3 = new ArrayList(i);
      localMap = getHighlightedCommentsOrRepliesFromUpdate();
      arrayOfString = highlightedCommentUrns;
      j = arrayOfString.length;
      i = 0;
      localObject1 = localObject3;
    } while (i >= j);
    Object localObject4 = arrayOfString[i];
    if (localObject4 != null)
    {
      localObject2 = null;
      localObject1 = ((FeedUpdateDetailDataProvider.UpdateDetailState)detailDataProvider.state).comment((String)localObject4);
      localObject4 = (Comment)localMap.get(localObject4);
      if ((localObject1 == null) || (parentCommentUrn != null)) {
        break label470;
      }
      label362:
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((Map)localObject5).containsKey(urn.toString())) {
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject6 = (Comment)((Map)localObject5).get(urn.toString());
        localObject2 = localObject1;
        localObject4 = socialDetail;
        if (localObject4 != null) {
          continue;
        }
        localObject1 = null;
        localObject2 = localObject1;
        FeatureLog.i(TAG, "Upserting highlighted reply", "Feed Logging");
        localObject2 = localObject1;
      }
      catch (BuilderException localBuilderException)
      {
        Object localObject6;
        label470:
        Comment.Builder localBuilder;
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException(localBuilderException));
        continue;
      }
      ((List)localObject3).add(localObject2);
      i += 1;
      break;
      localObject1 = localObject2;
      if (localObject4 == null) {
        break label362;
      }
      localObject1 = localObject2;
      if (parentCommentUrn != null) {
        break label362;
      }
      localObject1 = localObject4;
      break label362;
      localObject2 = localObject1;
      localBuilder = new Comment.Builder((Comment)localObject1);
      localObject2 = localObject1;
      localObject6 = CommentModelUtils.upsertCommentToComments(comments, (Comment)localObject6);
      localObject2 = localObject1;
      localObject1 = localBuilder.setSocialDetail(new SocialDetail.Builder((SocialDetail)localObject4).setComments((Comments)localObject6).build(RecordTemplate.Flavor.RECORD)).build();
    }
  }
  
  private Map<String, Comment> getHighlightedCommentsOrRepliesFromUpdate()
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (currentUpdate != null)
    {
      Iterator localIterator = currentUpdate.highlightedComments.iterator();
      while (localIterator.hasNext())
      {
        Comment localComment = (Comment)localIterator.next();
        if (localComment != null) {
          localArrayMap.put(urn.toString(), localComment);
        }
      }
    }
    return localArrayMap;
  }
  
  private void handleEmptyCommentsResponse()
  {
    if (detailAdapter == null) {
      return;
    }
    if (lastCommentLoadEmpty)
    {
      detailAdapter.hideLoadingViews();
      return;
    }
    detailAdapter.resetLoadingViews(fragmentComponent, currentUpdate);
    lastCommentLoadEmpty = true;
  }
  
  private void hideErrorView()
  {
    contentContainer.setVisibility(0);
    footerContainer.setVisibility(0);
    if (errorViewModel != null)
    {
      errorViewModel.remove();
      errorViewModel = null;
    }
  }
  
  private void onSocialDetailChanged(SocialDetail paramSocialDetail, final boolean paramBoolean)
  {
    setSocialDetail(paramSocialDetail);
    if ((!isAdded()) || (detailAdapter == null) || (detailDataProvider == null) || (commentConsistencyCoordinator == null)) {
      return;
    }
    detailDataProvider.initCommentsCollectionTemplate(paramSocialDetail, fragmentComponent.dataManager());
    ModelsTransformedCallback local7 = new ModelsTransformedCallback()
    {
      public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramAnonymousModelsData)
      {
        if ((!isAdded()) || (detailAdapter == null) || (commentConsistencyCoordinator == null)) {
          return;
        }
        Object localObject1 = detailAdapter;
        Object localObject2 = viewModels;
        int i;
        boolean bool;
        label169:
        Object localObject3;
        if (paramBoolean)
        {
          i = 0;
          ((FeedUpdateDetailAdapter)localObject1).addNewComments((List)localObject2, i, fragmentComponent, currentUpdate);
          if (anchorPoint == 2)
          {
            localObject1 = FeedUpdateDetailFragment.this;
            localObject2 = fragmentComponent;
            bool = paramBoolean;
            if (detailAdapter != null)
            {
              ((FragmentComponent)localObject2).timeWrapper();
              if ((System.currentTimeMillis() - displayedTime <= FeedLixHelper.parseLong(((FragmentComponent)localObject2).lixManager(), Lix.FEED_HIGHLIGHTED_COMMENT_ANCHOR_TIME, 2000L, 1L)) || (bool))
              {
                localObject2 = detailAdapter;
                i = 0;
                if (i >= ((BaseDetailAdapter)localObject2).getItemCount()) {
                  break label375;
                }
                localObject3 = (FeedComponentViewModel)((BaseDetailAdapter)localObject2).getItemAtPosition(i);
                if (localObject3 == null) {
                  break label368;
                }
                if (!(localObject3 instanceof FeedCommentViewModel)) {
                  break label286;
                }
                bool = isHighlighted;
                label212:
                if (!bool) {
                  break label368;
                }
              }
            }
          }
        }
        for (;;)
        {
          if (i >= 0) {
            detailRecyclerView.smoothScrollToPosition(i);
          }
          if (detailRecyclerView != null) {
            infiniteScrollListener.onScrolled(detailRecyclerView, 0, 0);
          }
          commentConsistencyCoordinator.listenForUpdates(inputModels, commentChangedListener);
          return;
          i = 1;
          break;
          label286:
          if ((localObject3 instanceof FeedComponentListViewModel))
          {
            localObject3 = components;
            int j = 0;
            for (;;)
            {
              if (j >= ((List)localObject3).size()) {
                break label362;
              }
              FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)((List)localObject3).get(j);
              if (((localFeedComponentViewModel instanceof FeedCommentViewModel)) && (isHighlighted))
              {
                bool = true;
                break;
              }
              j += 1;
            }
          }
          label362:
          bool = false;
          break label212;
          label368:
          i += 1;
          break label169;
          label375:
          i = -1;
        }
      }
    };
    List localList1 = comments.elements;
    List localList2 = getHighlightedComments();
    SortOrder localSortOrder = FeedUpdateUtils.getCommentsSortOrder(paramSocialDetail);
    if (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_TOGGLE_COMMENTS_ORDERING))
    {
      paramSocialDetail = localList1;
      if (localSortOrder != SortOrder.CHRON)
      {
        if (localSortOrder != SortOrder.$UNKNOWN) {
          break label147;
        }
        paramSocialDetail = localList1;
      }
    }
    for (;;)
    {
      FeedCommentTransformer.toViewModels(fragmentComponent, viewPool, paramSocialDetail, currentUpdate, getDataModelMetadata(0), local7);
      return;
      label147:
      paramSocialDetail = new ArrayList(localList1);
      int i = 0;
      if (i < localList2.size())
      {
        int j = 0;
        int k = 0;
        while (j < localList1.size())
        {
          if (Util.safeEquals(geturn, geturn))
          {
            paramSocialDetail.set(j, localList2.get(i));
            FeatureLog.i(TAG, "Updating highlighted comment", "Feed Logging");
            k = 1;
          }
          j += 1;
        }
        if (k == 0)
        {
          FeatureLog.i(TAG, "Adding highlighted comment", "Feed Logging");
          if ((localSortOrder != SortOrder.RELEVANCE) && (localSortOrder != SortOrder.REV_CHRON)) {
            break label321;
          }
          paramSocialDetail.add(0, localList2.get(i));
        }
        for (;;)
        {
          i += 1;
          break;
          label321:
          paramSocialDetail.add(localList2.get(i));
        }
      }
    }
  }
  
  private void onUpdateChanged(Update paramUpdate, final int paramInt)
  {
    setUpdate(paramUpdate);
    showLoadingView(false);
    if ((!isAdded()) || (detailAdapter == null)) {
      return;
    }
    ModelTransformedCallback local6 = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if ((!isAdded()) || (detailAdapter == null)) {
          return;
        }
        UpdateDataModel localUpdateDataModel = (UpdateDataModel)dataModel;
        FeedUpdateDetailAdapter localFeedUpdateDetailAdapter = detailAdapter;
        FeedUpdateViewModel localFeedUpdateViewModel = (FeedUpdateViewModel)viewModel;
        localFeedUpdateDetailAdapter.changeViewModel(0, new FeedComponentListViewModel(viewPool, localFeedUpdateViewModel.getComponents()));
        FeedUpdateDetailFragment.access$1402(FeedUpdateDetailFragment.this, viewModel).controlMenuClickListener);
        if ((localUpdateDataModel instanceof SingleUpdateDataModel)) {
          FeedUpdateDetailFragment.access$1502(FeedUpdateDetailFragment.this, detailTitle);
        }
        FeedUpdateDetailFragment.this.setupControlMenu();
        if ((paramInt == 1) && (currentSocialDetail != null)) {
          FeedUpdateDetailFragment.access$1800$4cc49715(FeedUpdateDetailFragment.this, currentSocialDetail);
        }
        FeedUpdateDetailFragment.access$1900(FeedUpdateDetailFragment.this, localUpdateDataModel);
      }
    };
    FeedViewTransformer.toViewModel(fragmentComponent, viewPool, paramUpdate, getDataModelMetadata(0), local6);
  }
  
  private void overrideSortOrder()
  {
    if ((!FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_TOGGLE_COMMENTS_ORDERING)) || (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL))) {}
    while ((viralUpdateUrn == null) || (currentSocialDetail == null) || (currentSocialDetail.totalSocialActivityCounts.numComments <= 10L)) {
      return;
    }
    updateCommentSortOrder(SortOrder.RELEVANCE);
  }
  
  private void propagateToOriginatingActivity(Update paramUpdate, UpdateActionModel paramUpdateActionModel)
  {
    Intent localIntent = new Intent();
    paramUpdate = ControlMenuBundleBuilder.create(urn.toString(), type, paramUpdate, actorId, actorName, mentionedEntityUrn, self, groupName).build();
    paramUpdate.putString("viralUpdateUrn", viralUpdateUrn);
    localIntent.putExtras(paramUpdate);
    fragmentComponent.activity().setResult(-1, localIntent);
    fragmentComponent.activity().finish();
  }
  
  private void setSocialDetail(SocialDetail paramSocialDetail)
  {
    currentSocialDetail = paramSocialDetail;
    if (currentSocialDetail.threadId != null) {
      threadId = currentSocialDetail.threadId;
    }
  }
  
  private void setUpdate(Update paramUpdate)
  {
    currentUpdate = paramUpdate;
    if (currentUpdate.socialDetail != null) {
      setSocialDetail(currentUpdate.socialDetail);
    }
  }
  
  private void setupControlMenu()
  {
    if (toolbar == null) {
      return;
    }
    MenuItem localMenuItem = toolbar.getMenu().findItem(2131758745);
    if (localMenuItem != null) {
      if (controlMenuClickListener == null) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setVisible(bool);
      localMenuItem.getActionView().setOnClickListener(controlMenuClickListener);
      if (menuTitle == null) {
        break;
      }
      toolbar.setTitle(menuTitle);
      return;
    }
  }
  
  private void setupUpdate(Update paramUpdate)
  {
    setUpdate(paramUpdate);
    fragmentComponent.updateChangeCoordinator().listenForUpdates(currentUpdate, updateChangedListener);
    onUpdateChanged(paramUpdate, 1);
  }
  
  private void showErrorView()
  {
    Object localObject1 = getView();
    if ((localObject1 == null) || (detailAdapter == null) || (detailAdapter.hasRenderedComponents())) {
      return;
    }
    new PageViewEvent(tracker, "feed_detail_error", false).send();
    contentContainer.setVisibility(8);
    footerContainer.setVisibility(8);
    if ((errorViewModel == null) || (errorPageViewHolder == null))
    {
      Object localObject3 = errorViewStub;
      localObject2 = tracker;
      Closure local10 = new Closure() {};
      Context localContext = ((ViewStub)localObject3).getContext();
      localObject3 = new ErrorPageViewModel((ViewStub)localObject3);
      if (((ErrorPageViewModel)localObject3).setupDefaultErrorConfiguration(localContext, null) == 1)
      {
        errorHeaderText = null;
        errorDescriptionText = localContext.getString(2131231311);
      }
      errorButtonText = localContext.getString(2131231235);
      onErrorButtonClick = new FeedErrorViewModels.3((Tracker)localObject2, "retry", local10);
      errorViewModel = ((ErrorPageViewModel)localObject3);
      errorPageViewHolder = ((ErrorPageViewHolder)errorViewModel.getCreator().createViewHolder((View)localObject1));
    }
    localObject1 = errorViewModel;
    Object localObject2 = getActivity().getLayoutInflater();
    applicationComponent.mediaCenter();
    ((ErrorPageViewModel)localObject1).onBindViewHolderWithErrorTracking$18b8048((LayoutInflater)localObject2, errorPageViewHolder, tracker, getPageInstance());
  }
  
  private void showLoadingView(boolean paramBoolean)
  {
    View localView;
    if (loading != null)
    {
      localView = loading;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void showSnackBar(int paramInt)
  {
    Snackbar localSnackbar = fragmentComponent.snackbarUtil().make(fragmentComponent.i18NManager().getString(paramInt), 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  private void updateCommentSortOrder(SortOrder paramSortOrder)
  {
    try
    {
      if (currentSocialDetail.comments.metadata != null) {}
      for (Metadata.Builder localBuilder = new Metadata.Builder(currentSocialDetail.comments.metadata);; localBuilder = new Metadata.Builder())
      {
        localBuilder.setSort(paramSortOrder);
        paramSortOrder = new Comments.Builder(currentSocialDetail.comments);
        paramSortOrder.setElements(Collections.emptyList()).setMetadata(localBuilder.build(RecordTemplate.Flavor.RECORD)).setPaging(new CollectionMetadata.Builder().setStart(Integer.valueOf(0)).setCount(Integer.valueOf(0)).setTotal(Integer.valueOf(currentSocialDetail.comments.paging.total)).setLinks(Collections.emptyList()).build(RecordTemplate.Flavor.RECORD));
        currentSocialDetail = new SocialDetail.Builder(currentSocialDetail).setComments(paramSortOrder.build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
        currentUpdate = new Update.Builder(currentUpdate).setSocialDetail(currentSocialDetail).build(RecordTemplate.Flavor.RECORD);
        return;
      }
      return;
    }
    catch (BuilderException paramSortOrder)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("failed to updateCommentSortOrder by sortOrder", paramSortOrder));
    }
  }
  
  public final void doEnter()
  {
    super.doEnter();
    new PageViewEvent(tracker, getDetailPageKey(), false).send();
    if (viewPortManager != null) {
      viewPortManager.trackAll(tracker);
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    if (viewPortManager != null) {
      viewPortManager.untrackAll();
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    if (detailDataProvider != null) {
      detailDataProvider.unregister(this);
    }
    if (socialFooterManager != null) {
      Bus.unsubscribe(socialFooterManager);
    }
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
    if ((currentUpdate != null) && (currentUpdate.tracking != null))
    {
      fragmentComponent.timeWrapper();
      long l1 = System.currentTimeMillis();
      long l2 = displayedTime;
      getContext();
      FeedTracking.trackDetailFIE$5e2dcd44(tracker, currentUpdate, currentUpdate.tracking, displayedTime, l1 - l2);
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    if (detailDataProvider != null) {
      detailDataProvider.register(this);
    }
    if (socialFooterManager != null) {
      socialFooterManager.onResume();
    }
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    fragmentComponent.timeWrapper();
    displayedTime = System.currentTimeMillis();
    if ((currentUpdate != null) && (FeedTracking.isSponsored(currentUpdate.tracking)))
    {
      assert (currentUpdate.tracking.sponsoredTracking != null);
      fragmentComponent.sponsoredUpdateTracker().trackDetailImpression(Tracker.createPageInstanceHeader(getPageInstance()), currentUpdate.tracking, currentUpdate.tracking.sponsoredTracking);
    }
  }
  
  public final int feedType()
  {
    return feedType;
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.connectionsV2DataProvider();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 15) && (paramInt2 == -1))
    {
      anchorPoint = 1;
      onUpdateChanged(currentUpdate, 1);
    }
  }
  
  protected final void onCollectionDataEvent(final int paramInt, CollectionTemplate paramCollectionTemplate, DataStore.Type paramType, String paramString1, String paramString2)
  {
    loadingMoreComments = false;
    if ((detailAdapter == null) || (commentConsistencyCoordinator == null)) {}
    do
    {
      return;
      paramCollectionTemplate = elements;
      if (CollectionUtils.isEmpty(paramCollectionTemplate))
      {
        handleEmptyCommentsResponse();
        return;
      }
      lastCommentLoadEmpty = false;
    } while ((!isAdded()) || (detailAdapter == null) || (commentConsistencyCoordinator == null));
    paramType = new ModelsTransformedCallback()
    {
      public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramAnonymousModelsData)
      {
        if ((detailAdapter == null) || (commentConsistencyCoordinator == null)) {
          return;
        }
        if (CollectionUtils.isEmpty(viewModels))
        {
          FeedUpdateDetailFragment.this.handleEmptyCommentsResponse();
          return;
        }
        if (paramInt == 5) {
          detailAdapter.addNewComments(viewModels, 3, fragmentComponent, currentUpdate);
        }
        for (;;)
        {
          commentConsistencyCoordinator.listenForUpdates(inputModels, commentChangedListener);
          return;
          if (paramInt == 6) {
            detailAdapter.addNewComments(viewModels, 2, fragmentComponent, currentUpdate);
          }
        }
      }
    };
    FeedCommentTransformer.toViewModels(fragmentComponent, viewPool, paramCollectionTemplate, currentUpdate, getDataModelMetadata(0), paramType);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    commentConsistencyCoordinator = new ModelListConsistencyCoordinator(fragmentComponent.consistencyManager());
    Bundle localBundle = getArguments();
    label75:
    label87:
    label108:
    int i;
    if (localBundle != null) {
      if (localBundle == null)
      {
        paramBundle = null;
        currentUpdate = paramBundle;
        if (currentUpdate == null) {
          break label313;
        }
        paramBundle = currentUpdate.socialDetail;
        currentSocialDetail = paramBundle;
        if (localBundle != null) {
          break label318;
        }
        paramBundle = null;
        updateUrn = paramBundle;
        viralUpdateUrn = FeedUpdateDetailBundleBuilder.getViralUpdateUrn(localBundle);
        if (localBundle != null) {
          break label330;
        }
        paramBundle = null;
        updateEntityUrnString = paramBundle;
        if (localBundle != null) {
          break label342;
        }
        i = 0;
        label120:
        anchorPoint = i;
        feedType = FeedUpdateDetailBundleBuilder.getFeedType(localBundle);
        if (localBundle != null) {
          break label355;
        }
        paramBundle = null;
        label141:
        trackingId = paramBundle;
        if (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_HIGHLIGHTED_COMMENT_ANCHOR))
        {
          if (localBundle != null) {
            break label367;
          }
          paramBundle = null;
          label171:
          highlightedCommentUrns = paramBundle;
          if (localBundle != null) {
            break label379;
          }
          paramBundle = null;
          label183:
          highlightedReplyUrns = paramBundle;
        }
        if ((highlightedCommentUrns == null) && (anchorPoint == 2)) {
          anchorPoint = 0;
        }
        if (localBundle != null) {
          break label391;
        }
        paramBundle = (Bundle)localObject;
        label215:
        highlightedLikeUrns = paramBundle;
      }
    }
    for (;;)
    {
      detailDataProvider = activityComponent.feedUpdateDetailProvider();
      mentionWorkFlowId = String.valueOf(System.currentTimeMillis());
      detailAdapter = new FeedUpdateDetailAdapter(activityComponent.context(), applicationComponent.mediaCenter(), viewPool);
      detailAdapter.detailDataProvider = new WeakReference(detailDataProvider);
      return;
      paramBundle = (Update)RecordParceler.quietUnparcel(Update.BUILDER, "update", localBundle);
      break;
      label313:
      paramBundle = null;
      break label75;
      label318:
      paramBundle = localBundle.getString("updateUrn");
      break label87;
      label330:
      paramBundle = localBundle.getString("updateEntityUrn");
      break label108;
      label342:
      i = localBundle.getInt("anchorPoint", 0);
      break label120;
      label355:
      paramBundle = localBundle.getString("trackingId");
      break label141;
      label367:
      paramBundle = localBundle.getStringArray("highlightedCommentUrns");
      break label171;
      label379:
      paramBundle = localBundle.getStringArray("highlightedReplyUrns");
      break label183;
      label391:
      paramBundle = localBundle.getStringArray("highlightedLikeUrns");
      break label215;
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("You are not allowed to enter feed detail without arguments!"));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968743, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    showLoadingView(false);
    if ((paramSet == null) || (paramSet.isEmpty())) {
      if (currentUpdate == null) {
        showErrorView();
      }
    }
    do
    {
      return;
      if (!paramSet.contains(detailDataProvider.state).updateRoute)) {
        break;
      }
      Log.e(TAG, "update fetch failed with error ", paramDataManagerException);
    } while (paramType != DataStore.Type.NETWORK);
    showErrorView();
    return;
    if (paramSet.contains(detailDataProvider.state).socialDetailRoute))
    {
      Log.e(TAG, "social detail fetch failed with error ", paramDataManagerException);
      loadingSocialDetail = false;
      return;
    }
    Log.e(TAG, "load more comments failed with error ", paramDataManagerException);
    loadingMoreComments = false;
    if (detailAdapter != null) {
      detailAdapter.resetLoadingViews(fragmentComponent, currentUpdate);
    }
    Toast.makeText(getContext(), 2131231156, 1).show();
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (paramSet == null) {}
    do
    {
      do
      {
        return;
        if (paramSet.contains(detailDataProvider.state).updateRoute))
        {
          paramType = ((FeedUpdateDetailDataProvider.UpdateDetailState)detailDataProvider.state).update();
          if (paramType != null)
          {
            setupUpdate(paramType);
            hideErrorView();
            return;
          }
          showErrorView();
          return;
        }
      } while (!paramSet.contains(detailDataProvider.state).socialDetailRoute));
      loadingSocialDetail = false;
      paramType = (FeedUpdateDetailDataProvider.UpdateDetailState)detailDataProvider.state;
      paramType = (SocialDetail)paramType.getModel(socialDetailRoute);
    } while (paramType == null);
    onSocialDetailChanged(paramType, false);
  }
  
  public void onDestroy()
  {
    detailAdapter = null;
    mentionsPresenter.cleanUp();
    fragmentComponent.updateChangeCoordinator().removeListener(updateChangedListener);
    commentConsistencyCoordinator.removeListener(commentChangedListener);
    commentConsistencyCoordinator = null;
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    if (detailRecyclerView != null) {
      detailRecyclerView.setAdapter(null);
    }
    if (feedLayoutManager != null)
    {
      feedLayoutManager.mRecycleChildrenOnDetach = true;
      feedLayoutManager = null;
    }
    socialFooter = null;
    socialFooterManager = null;
    highlightedCommentUrns = null;
    highlightedReplyUrns = null;
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(FeedCommentButtonClickEvent paramFeedCommentButtonClickEvent)
  {
    socialFooterManager.setupSocialFooterState(1);
  }
  
  @Subscribe
  public void onEvent(FeedCommentLongClickEvent paramFeedCommentLongClickEvent)
  {
    FeedCommentLongClickHandler.handleLongClick(fragmentComponent, currentUpdate, comment, actions);
  }
  
  @Subscribe
  public void onEvent(FeedCommentUpdateEvent paramFeedCommentUpdateEvent)
  {
    if ((detailRecyclerView == null) || (detailAdapter == null)) {}
    Update localUpdate;
    for (;;)
    {
      return;
      commentConsistencyCoordinator.listenForUpdates(changedComment, commentChangedListener);
      localUpdate = newUpdate;
      if (updateEventType == 8) {}
      FeedComponentViewModel localFeedComponentViewModel;
      for (int i = 3;; i = 0)
      {
        localFeedComponentViewModel = FeedCommentTransformer.toViewModel(fragmentComponent, viewPool, changedComment, localUpdate, getDataModelMetadata(i));
        if (localFeedComponentViewModel != null) {
          break;
        }
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Error transforming comment"));
        return;
      }
      FeedCommentViewModel localFeedCommentViewModel = FeedCommentViewModelUtils.getCommentViewModel(localFeedComponentViewModel);
      if (localFeedCommentViewModel == null)
      {
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Cannot get CommentViewModel"));
        return;
      }
      if (updateEventType == 6)
      {
        detailAdapter.addNewUserComment(localFeedCommentViewModel, currentSocialDetail);
        i = detailAdapter.getIndexOfCommentWithId(commentUrn);
        if (i >= 0) {
          detailRecyclerView.smoothScrollToPosition(i);
        }
      }
      else
      {
        if (updateEventType == 7)
        {
          detailAdapter.changeCommentWithId(fakeId, localFeedCommentViewModel);
          return;
        }
        if ((updateEventType == 8) || (updateEventType == 10))
        {
          detailAdapter.changeCommentWithId(realId, localFeedComponentViewModel);
          return;
        }
        if (updateEventType != 9) {
          break;
        }
        detailAdapter.deleteCommentWithId(realId);
        i = 0;
        while ((highlightedCommentUrns != null) && (i < highlightedCommentUrns.length))
        {
          if (Util.safeEquals(realId, highlightedCommentUrns[i])) {
            highlightedCommentUrns[i] = null;
          }
          i += 1;
        }
        i = 0;
        while ((highlightedReplyUrns != null) && (i < highlightedReplyUrns.length))
        {
          if (Util.safeEquals(realId, highlightedReplyUrns[i])) {
            highlightedReplyUrns[i] = null;
          }
          i += 1;
        }
      }
    }
    onUpdateChanged(localUpdate, 1);
  }
  
  @Subscribe
  public void onEvent(FeedOpenCommentDetailEvent paramFeedOpenCommentDetailEvent)
  {
    Object localObject1;
    if (comment.parentCommentUrn == null)
    {
      localObject1 = CommentDetailBundleBuilder.create(updateUrn, comment.urn.toString());
      ((CommentDetailBundleBuilder)localObject1).comment(comment);
    }
    for (;;)
    {
      ((CommentDetailBundleBuilder)localObject1).populateMention(populateMention);
      ((CommentDetailBundleBuilder)localObject1).update(currentUpdate);
      ((CommentDetailBundleBuilder)localObject1).anchor(anchor);
      ((CommentDetailBundleBuilder)localObject1).previousPage(previousPage);
      paramFeedOpenCommentDetailEvent = (BaseActivity)getActivity();
      if (paramFeedOpenCommentDetailEvent != null)
      {
        fragmentComponent.fragmentRegistry();
        localObject2 = new CommentDetailFragment();
        ((Fragment)localObject2).setArguments(((CommentDetailBundleBuilder)localObject1).build());
        paramFeedOpenCommentDetailEvent.getPageFragmentTransaction().replace(2131755759, (Fragment)localObject2).addToBackStack(null).commit();
      }
      return;
      Object localObject2 = CommentDetailBundleBuilder.create(updateUrn, comment.parentCommentUrn.toString());
      ((CommentDetailBundleBuilder)localObject2).reply(comment);
      localObject1 = localObject2;
      if (parentComment != null)
      {
        ((CommentDetailBundleBuilder)localObject2).comment(parentComment);
        localObject1 = localObject2;
      }
    }
  }
  
  @Subscribe
  public void onEvent(FeedReplyLongClickEvent paramFeedReplyLongClickEvent)
  {
    FeedReplyLongClickHandler.handleLongClick(fragmentComponent, currentUpdate, comment, reply, actions);
  }
  
  @Subscribe
  public void onEvent(FeedReplyUpdateEvent paramFeedReplyUpdateEvent)
  {
    if (detailAdapter == null) {}
    FeedComponentViewModel localFeedComponentViewModel;
    String str;
    do
    {
      return;
      commentConsistencyCoordinator.listenForUpdates(changedReply, commentChangedListener);
      if (updateEventType == 8) {}
      for (int i = 2;; i = 0)
      {
        localFeedComponentViewModel = FeedCommentTransformer.toViewModel(fragmentComponent, viewPool, newComment, currentUpdate, getDataModelMetadata(i));
        if (localFeedComponentViewModel != null) {
          break;
        }
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Error transforming reply"));
        return;
      }
      str = newComment.urn.toString();
    } while ((updateEventType != 8) && (updateEventType != 10) && (updateEventType != 9));
    detailAdapter.changeCommentWithId(str, localFeedComponentViewModel);
  }
  
  @Subscribe
  public void onEvent(FeedToggleCommentOrderingEvent paramFeedToggleCommentOrderingEvent)
  {
    int j = 0;
    updateCommentSortOrder(order);
    if ((currentUpdate == null) || (currentSocialDetail == null) || (detailDataProvider == null) || (detailAdapter == null)) {
      return;
    }
    onUpdateChanged(currentUpdate, 2);
    detailDataProvider.initCommentsCollectionTemplate(currentSocialDetail, fragmentComponent.dataManager());
    FeedUpdateDetailAdapter localFeedUpdateDetailAdapter = detailAdapter;
    int i = j;
    if (detailRecyclerView != null)
    {
      i = j;
      if (detailRecyclerView.getLayoutManager() != null)
      {
        i = j;
        if (detailRecyclerView.getLayoutManager().getChildCount() > 0)
        {
          i = detailRecyclerView.getHeight();
          View localView = detailRecyclerView.getLayoutManager().getChildAt(0);
          j = (int)localView.getY();
          i -= localView.getHeight() + j;
        }
      }
    }
    loadingViewHeight = i;
    detailAdapter.addNewComments(Collections.emptyList(), 1, fragmentComponent, currentUpdate);
    paramFeedToggleCommentOrderingEvent = order;
    fetchSocialDetailFromNetwork(FeedRouteUtils.getSocialDetailUrl(fragmentComponent, updateUrn, paramFeedToggleCommentOrderingEvent));
  }
  
  @Subscribe
  public void onEvent(LoadMoreEvent paramLoadMoreEvent)
  {
    if ((usage != 1) || (!isAdded()) || (detailAdapter == null) || (threadId == null)) {}
    Map localMap;
    String str;
    Uri localUri;
    do
    {
      do
      {
        do
        {
          return;
          detailAdapter.animateLoadingViews(fragmentComponent, currentUpdate);
          if (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_LOAD_MORE_COMMENTS_PVE)) {
            new PageViewEvent(tracker, getDetailPageKey(), false).send();
          }
          if ((detailDataProvider.state).commentsCollectionHelper == null) && (currentSocialDetail != null)) {
            detailDataProvider.initCommentsCollectionTemplate(currentSocialDetail, fragmentComponent.dataManager());
          }
          if (eventType != 0) {
            break;
          }
          paramLoadMoreEvent = detailDataProvider;
          localMap = Tracker.createPageInstanceHeader(getPageInstance());
          localObject = busSubscriberId;
          str = RUMHelper.pageInitLoadMore(this);
          localUri = FeedRouteUtils.getBaseCommentsRoute(threadId, getCommentSortOrder());
        } while (state).commentsCollectionHelper == null);
        localObject = paramLoadMoreEvent.getCommentsListener(localUri, (String)localObject, str, 6);
        state).commentsCollectionHelper.fetchLoadPreviousData$2fec3de(localMap, localUri, (RecordTemplateListener)localObject, str);
        return;
      } while (eventType != 1);
      paramLoadMoreEvent = detailDataProvider;
      localMap = Tracker.createPageInstanceHeader(getPageInstance());
      localObject = busSubscriberId;
      str = RUMHelper.pageInitLoadMore(this);
      localUri = FeedRouteUtils.getBaseCommentsRoute(threadId, getCommentSortOrder());
    } while (state).commentsCollectionHelper == null);
    Object localObject = paramLoadMoreEvent.getCommentsListener(localUri, (String)localObject, str, 5);
    state).commentsCollectionHelper.fetchLoadMoreData(localMap, 1, null, localUri, (RecordTemplateListener)localObject, str);
  }
  
  @Subscribe
  public void onEvent(MentionStartSuggestionTrackingEvent paramMentionStartSuggestionTrackingEvent)
  {
    MentionsTracking.fireMentionSuggestionStartEvent(fragmentComponent, paramMentionStartSuggestionTrackingEvent, currentUpdate, mentionWorkFlowId, mentionsPresenter.query, "comment");
  }
  
  @Subscribe
  public void onEvent(UpdateActionEvent paramUpdateActionEvent)
  {
    if (!isActive) {}
    final Update localUpdate;
    final UpdateActionModel localUpdateActionModel;
    final FragmentComponent localFragmentComponent;
    do
    {
      return;
      localUpdate = update;
      localUpdateActionModel = updateAction;
      localFragmentComponent = fragmentComponent;
      switch (type)
      {
      default: 
        UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(getPageInstance()), localFragmentComponent, urn.toString(), localUpdateActionModel, localUpdate);
      }
    } while (!UpdateActionModel.isUnfollowAction(type));
    propagateToOriginatingActivity(localUpdate, localUpdateActionModel);
    return;
    UpdateActionPublisher.showDeleteConfirmationDialog$79962340(localFragmentComponent, new UpdateActionPublisher.DeleteUpdateActionListener()
    {
      public final void onDeleteUpdateAction()
      {
        UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(getPageInstance()), localFragmentComponent, localUpdateurn.toString(), localUpdateActionModel, localUpdate);
        Intent localIntent = new Intent();
        Bundle localBundle = new ControlMenuBundleBuilder(localUpdateurn.toString()).build();
        localBundle.putString("viralUpdateUrn", viralUpdateUrn);
        localIntent.putExtras(localBundle);
        localFragmentComponent.activity().setResult(-1, localIntent);
        localFragmentComponent.activity().finish();
      }
    });
    return;
    showSnackBar(2131231190);
    return;
    showSnackBar(2131231191);
    return;
    UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(getPageInstance()), localFragmentComponent, urn.toString(), localUpdateActionModel, localUpdate);
    propagateToOriginatingActivity(localUpdate, localUpdateActionModel);
    return;
    UpdateActionPublisher.sendShareViaIntent(this, paramUpdateActionEvent);
    return;
    UpdateActionPublisher.editShare(this, paramUpdateActionEvent);
  }
  
  public final void onSocialFooterComposeState()
  {
    if ((dismissComposeView != null) && (detailRecyclerView != null))
    {
      dismissComposeView.setVisibility(0);
      View.OnClickListener local11 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          FeatureLog.i(FeedUpdateDetailFragment.TAG, "dismissComposeView onClick", "Feed Logging");
          dismissComposeView.setVisibility(8);
          socialFooterManager.setupSocialFooterState(0);
          detailRecyclerView.setEnabled(true);
          detailRecyclerView.setClickable(true);
          trackButtonShortPress("feed_detail_container");
          if ((currentUpdate != null) && (currentUpdate.tracking != null) && (currentUpdate.urn != null)) {
            FeedTracking.trackFAE(tracker, "feed_detail_container", ActionCategory.DISMISS, "dismissComment", currentUpdate.tracking, currentUpdate.urn, fragmentComponent);
          }
        }
      };
      dismissComposeView.setOnClickListener(local11);
      detailRecyclerView.setEnabled(false);
      detailRecyclerView.setClickable(false);
    }
  }
  
  public final void onSocialFooterDefaultState()
  {
    if ((dismissComposeView != null) && (detailRecyclerView != null))
    {
      dismissComposeView.setVisibility(8);
      detailRecyclerView.setEnabled(true);
      detailRecyclerView.setClickable(true);
      anchorPoint = 0;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    getActivity().getWindow().setBackgroundDrawableResource(2131624322);
    showLoadingView(true);
    if (toolbar != null)
    {
      toolbar.inflateMenu(2131820544);
      toolbar.setNavigationOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if ((mentionsRecyclerView != null) && (mentionsRecyclerView.getVisibility() == 0) && (socialFooterManager != null))
          {
            socialFooterManager.displaySuggestions(false);
            MentionsTracking.fireMentionSuggestionActionEvent(fragmentComponent, mentionsPresenter.query, mentionWorkFlowId, MentionActionType.DISMISS, null);
            return;
          }
          FeedNavigationUtils.navigateUp(activityComponent, false);
        }
      });
    }
    setupControlMenu();
    feedLayoutManager = new LinearLayoutManager(getActivity());
    detailRecyclerView.setLayoutManager(feedLayoutManager);
    detailRecyclerView.setAdapter(detailAdapter);
    detailRecyclerView.setRecycledViewPool(viewPool);
    viewPortManager.container = detailRecyclerView;
    detailAdapter.setViewPortManager(viewPortManager);
    detailRecyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
    detailRecyclerView.addOnScrollListener(infiniteScrollListener);
    socialFooter = new SocialFooterViewHolder(paramView);
    socialFooterManager = new FeedUpdateDetailSocialFooterManager(fragmentComponent, mentionsPresenter, mentionsRecyclerView, socialFooter, mentionWorkFlowId);
    socialFooterManager.setSocialFooterStateChangeListener(this);
    if (currentUpdate != null)
    {
      setupUpdate(currentUpdate);
      overrideSortOrder();
      detailDataProvider.initCommentsCollectionTemplate(currentSocialDetail, fragmentComponent.dataManager());
      fetchSocialDetailFromNetwork();
    }
    while (TextUtils.isEmpty(updateUrn)) {
      return;
    }
    if (updateEntityUrnString != null)
    {
      paramView = new DefaultModelListener()
      {
        public final void onCacheError(DataManagerException paramAnonymousDataManagerException)
        {
          if (!isAdded()) {
            return;
          }
          FeedUpdateDetailFragment.this.fetchUpdateFromNetwork();
        }
      };
      FeedBundleBuilder.loadUpdateFromCache(fragmentComponent.dataManager(), paramView, updateEntityUrnString);
      return;
    }
    fetchUpdateFromNetwork();
  }
  
  public final String pageKey()
  {
    return "detail_base";
  }
  
  public final String provideDebugData()
  {
    if (currentUpdate != null) {}
    for (String str = currentUpdate.urn.toString(); str != null; str = updateUrn) {
      return "Feed Detail Activity Id: " + str;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */