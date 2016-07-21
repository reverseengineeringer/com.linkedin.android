package com.linkedin.android.feed.updates.common.comment.detail;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.detail.BaseDetailAdapter;
import com.linkedin.android.feed.detail.BaseSocialFooterManager.SocialFooterStateChangeListener;
import com.linkedin.android.feed.detail.FeedUpdateDetailBundleBuilder;
import com.linkedin.android.feed.detail.FeedUpdateDetailFragmentFactory;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata.Builder;
import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentLongClickHandler;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentTransformer;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModel;
import com.linkedin.android.feed.endor.ui.component.comment.FeedReplyLongClickHandler;
import com.linkedin.android.feed.events.FeedCommentHeaderShareClickEvent;
import com.linkedin.android.feed.events.FeedCommentLongClickEvent;
import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.events.FeedCommentViewRepliesClickEvent;
import com.linkedin.android.feed.events.FeedReplyButtonClickEvent;
import com.linkedin.android.feed.events.FeedReplyLongClickEvent;
import com.linkedin.android.feed.events.FeedReplyUpdateEvent;
import com.linkedin.android.feed.events.LoadMoreEvent;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.updates.common.footer.SocialFooterViewHolder;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.VoyagerShakeDelegate.ShakeDebugDataProvider;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.consistency.ModelListConsistencyCoordinator;
import com.linkedin.consistency.ModelListItemChangedListener;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class CommentDetailFragment
  extends PageFragment
  implements BaseSocialFooterManager.SocialFooterStateChangeListener, FeedPageType, VoyagerShakeDelegate.ShakeDebugDataProvider
{
  private static final String TAG = CommentDetailFragment.class.getSimpleName();
  @Inject
  ActivityComponent activityComponent;
  private int anchorPoint;
  private Comment comment;
  private final ModelListItemChangedListener<Comment> commentChangedListener = new ModelListItemChangedListener() {};
  private ModelListConsistencyCoordinator<Comment> commentConsistencyCoordinator;
  private String commentUrn;
  private CommentDetailAdapter detailAdapter;
  @InjectView(2131755597)
  FrameLayout detailContainer;
  private CommentDetailDataProvider detailDataProvider;
  @InjectView(2131755598)
  RecyclerView detailRecyclerView;
  @InjectView(2131755599)
  View dismissComposeView;
  private LinearLayoutManager feedLayoutManager;
  @Inject
  FragmentComponent fragmentComponent;
  private boolean isMentionPopulated;
  @Inject
  KeyboardUtil keyboardUtil;
  private boolean lastCommentLoadEmpty;
  @InjectView(2131755595)
  View loading;
  private String mentionWorkFlowId;
  @Inject
  MentionsPresenter mentionsPresenter;
  @InjectView(2131755600)
  RecyclerView mentionsRecyclerView;
  private int previousPage;
  private Comment reply;
  private final ModelListItemChangedListener<Comment> replyChangedListener = new ModelListItemChangedListener() {};
  private SocialFooterViewHolder socialFooter;
  private CommentDetailSocialFooterManager socialFooterManager;
  private String threadId;
  @InjectView(2131755468)
  Toolbar toolbar;
  private Update update;
  private final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  private String updateUrn;
  private FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  @Inject
  ViewPortManager viewPortManager;
  
  private FeedDataModelMetadata getDataModelMetadata(int paramInt)
  {
    FeedDataModelMetadata.Builder localBuilder = new FeedDataModelMetadata.Builder();
    String[] arrayOfString;
    if (reply != null)
    {
      arrayOfString = new String[1];
      arrayOfString[0] = reply.urn.toString();
    }
    for (;;)
    {
      highlightedReplyUrns = arrayOfString;
      pendingState = paramInt;
      return localBuilder.build();
      arrayOfString = null;
    }
  }
  
  private String getDetailPageKey()
  {
    switch (previousPage)
    {
    default: 
      return "feed_comment_detail";
    case 9: 
      return "group_comment_detail";
    case 8: 
      return "prop_comment_detail";
    }
    Update localUpdate = update;
    if (localUpdate != null)
    {
      if (value.discussionUpdateValue != null) {
        return "group_comment_detail";
      }
      if (value.propUpdateValue != null) {
        return "prop_comment_detail";
      }
    }
    return "feed_comment_detail";
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
    detailAdapter.resetLoadingViews(fragmentComponent, update);
    lastCommentLoadEmpty = true;
  }
  
  private static List<Comment> mergeReplies(List<Comment> paramList, Comment paramComment, SortOrder paramSortOrder)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    if (paramComment == null) {
      return localArrayList;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label59;
      }
      if (Util.safeEquals(urn, geturn)) {
        break;
      }
      i += 1;
    }
    label59:
    if ((paramSortOrder == SortOrder.RELEVANCE) || (paramSortOrder == SortOrder.REV_CHRON))
    {
      localArrayList.add(0, paramComment);
      return localArrayList;
    }
    localArrayList.add(paramComment);
    return localArrayList;
  }
  
  private void setupCommentAndFetchSocialDetail()
  {
    final Object localObject1;
    final Object localObject2;
    if ((comment != null) && (update != null))
    {
      localObject1 = comment;
      localObject2 = update;
      if ((detailAdapter != null) && (commentConsistencyCoordinator != null)) {
        break label151;
      }
    }
    for (;;)
    {
      localObject2 = FeedRouteUtils.getSocialDetailUrl(fragmentComponent, commentUrn, null);
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if (!TextUtils.isEmpty(getRumSessionId()))
      {
        localObject1 = detailDataProvider;
        localObject3 = busSubscriberId;
        localObject4 = getRumSessionId();
        localObject5 = Tracker.createPageInstanceHeader(getPageInstance());
        state).socialDetailRoute = ((String)localObject2);
        localObject2 = Request.get().url((String)localObject2).customHeaders((Map)localObject5).builder(SocialDetail.BUILDER).listener(((CommentDetailDataProvider)localObject1).newModelListener((String)localObject3, (String)localObject4)).filter(DataManager.DataStoreFilter.NETWORK_ONLY).trackingSessionId((String)localObject4);
        activityComponent.dataManager().submit((Request.Builder)localObject2);
      }
      return;
      label151:
      if (socialDetail != null)
      {
        threadId = socialDetail.threadId;
        commentConsistencyCoordinator.listenForUpdates((DataTemplate)localObject1, commentChangedListener);
        fragmentComponent.updateChangeCoordinator().listenForUpdates((DataTemplate)localObject2, updateChangedListener);
        localObject3 = getDataModelMetadata(0);
        localObject4 = FeedCommentTransformer.toViewModel(fragmentComponent, viewPool, (Comment)localObject1, (Update)localObject2, (FeedDataModelMetadata)localObject3);
        if (localObject4 != null) {
          detailAdapter.changeViewModel(0, (ViewModel)localObject4);
        }
        localObject4 = new ModelsTransformedCallback()
        {
          public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramAnonymousModelsData)
          {
            if ((!isAdded()) || (detailAdapter == null) || (commentConsistencyCoordinator == null)) {
              return;
            }
            CommentDetailFragment.access$1100(CommentDetailFragment.this, localObject2, localObject1);
            detailAdapter.addNewComments(viewModels, 0, fragmentComponent, localObject2);
            commentConsistencyCoordinator.listenForUpdates(inputModels, replyChangedListener);
            CommentDetailFragment.access$1300$27b9cf55(CommentDetailFragment.this);
          }
        };
        localObject5 = mergeReplies(socialDetail.comments.elements, reply, FeedUpdateUtils.getCommentsSortOrder(socialDetail));
        FeedCommentTransformer.toViewModels(fragmentComponent, viewPool, (List)localObject5, (Comment)localObject1, (Update)localObject2, (FeedDataModelMetadata)localObject3, (ModelsTransformedCallback)localObject4);
      }
    }
  }
  
  private void showErrorMsg(int paramInt, String paramString)
  {
    Snackbar localSnackbar = fragmentComponent.snackbarUtil().make(paramInt, 0);
    if (localSnackbar != null) {
      SnackbarUtil.showWithErrorTracking$6c58675c(localSnackbar, tracker, getPageInstance(), paramString);
    }
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
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
    if (detailDataProvider != null) {
      detailDataProvider.unregister(this);
    }
    if (socialFooterManager != null) {
      Bus.unsubscribe(socialFooterManager);
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    if (detailDataProvider != null) {
      detailDataProvider.register(this);
    }
    if (socialFooterManager != null) {
      socialFooterManager.onResume();
    }
  }
  
  public final int feedType()
  {
    return 13;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final void onCollectionDataEvent(final int paramInt, CollectionTemplate paramCollectionTemplate, DataStore.Type paramType, String paramString1, String paramString2)
  {
    paramCollectionTemplate = elements;
    if (CollectionUtils.isEmpty(paramCollectionTemplate))
    {
      handleEmptyCommentsResponse();
      return;
    }
    lastCommentLoadEmpty = false;
    paramType = new ModelsTransformedCallback()
    {
      public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramAnonymousModelsData)
      {
        if ((!isAdded()) || (detailAdapter == null) || (commentConsistencyCoordinator == null)) {
          return;
        }
        if (CollectionUtils.isEmpty(viewModels))
        {
          CommentDetailFragment.this.handleEmptyCommentsResponse();
          return;
        }
        if (paramInt == 5) {
          detailAdapter.addNewComments(viewModels, 3, fragmentComponent, update);
        }
        for (;;)
        {
          commentConsistencyCoordinator.listenForUpdates(inputModels, replyChangedListener);
          return;
          if (paramInt == 6) {
            detailAdapter.addNewComments(viewModels, 2, fragmentComponent, update);
          }
        }
      }
    };
    FeedCommentTransformer.toViewModels(fragmentComponent, viewPool, paramCollectionTemplate, comment, update, FeedDataModelMetadata.DEFAULT, paramType);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool2 = false;
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    commentConsistencyCoordinator = new ModelListConsistencyCoordinator(fragmentComponent.consistencyManager());
    paramBundle = getArguments();
    getContext();
    Bundle localBundle = (Bundle)Util.ensureNonNull$d953a71(paramBundle, "You are not allowed to enter comment detail without arguments!");
    if (localBundle == null)
    {
      i = 0;
      anchorPoint = i;
      paramBundle = (Update)RecordParceler.quietUnparcel(Update.BUILDER, "update", localBundle);
      getContext();
      update = ((Update)Util.ensureNonNull$d953a71(paramBundle, "We don't have update in comment detail!"));
      if (localBundle != null) {
        break label339;
      }
      paramBundle = null;
      label116:
      getContext();
      updateUrn = ((String)Util.ensureNonNull$d953a71(paramBundle, "We don't have updateUrn in comment detail!"));
      comment = ((Comment)RecordParceler.quietUnparcel(Comment.BUILDER, "comment", localBundle));
      if (localBundle != null) {
        break label351;
      }
      paramBundle = (Bundle)localObject;
      label161:
      getContext();
      commentUrn = ((String)Util.ensureNonNull$d953a71(paramBundle, "We don't have commentUrn in comment detail!"));
      reply = ((Comment)RecordParceler.quietUnparcel(Comment.BUILDER, "reply", localBundle));
      if (localBundle != null) {
        break label363;
      }
    }
    label339:
    label351:
    label363:
    for (int i = -1;; i = localBundle.getInt("previousPage", -1))
    {
      previousPage = i;
      boolean bool1 = bool2;
      if (localBundle != null)
      {
        bool1 = bool2;
        if (localBundle.getBoolean("populateMention", false)) {
          bool1 = true;
        }
      }
      isMentionPopulated = bool1;
      detailDataProvider = activityComponent.commentDetailDataProvider();
      mentionWorkFlowId = String.valueOf(System.currentTimeMillis());
      detailAdapter = new CommentDetailAdapter(activityComponent.context(), applicationComponent.mediaCenter(), viewPool);
      detailAdapter.detailDataProvider = new WeakReference(detailDataProvider);
      detailAdapter.parentComment = comment;
      return;
      i = localBundle.getInt("anchorPoint", 0);
      break;
      paramBundle = localBundle.getString("updateUrn");
      break label116;
      paramBundle = localBundle.getString("commentUrn");
      break label161;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968708, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    showLoadingView(false);
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return;
    }
    if (paramSet.contains(detailDataProvider.state).singleCommentRoute))
    {
      showErrorMsg(2131231155, "Failed to load single comment");
      return;
    }
    if (paramSet.contains(detailDataProvider.state).socialDetailRoute))
    {
      showErrorMsg(2131231155, "Failed to load comment social detail");
      return;
    }
    if (detailAdapter != null) {
      detailAdapter.resetLoadingViews(fragmentComponent, update);
    }
    showErrorMsg(2131231278, "Failed to load more replies");
  }
  
  protected final void onDataReady(final DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (paramSet == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramSet.contains(detailDataProvider.state).singleCommentRoute)) {
              break;
            }
            paramType = (CommentDetailDataProvider.CommentDetailState)detailDataProvider.state;
            comment = ((Comment)paramType.getModel(singleCommentRoute));
            setupCommentAndFetchSocialDetail();
          } while (detailAdapter == null);
          detailAdapter.parentComment = comment;
          return;
        } while (!paramSet.contains(detailDataProvider.state).socialDetailRoute));
        paramType = (CommentDetailDataProvider.CommentDetailState)detailDataProvider.state;
        paramSet = (SocialDetail)paramType.getModel(socialDetailRoute);
      } while ((comment == null) || (paramSet == null));
      detailDataProvider.initCommentsCollectionTemplate(paramSet, fragmentComponent.dataManager());
      paramType = comment;
      paramMap = comments.elements;
    } while ((detailAdapter == null) || (commentConsistencyCoordinator == null));
    paramSet = getDataModelMetadata(0);
    Object localObject = FeedCommentTransformer.toViewModel(fragmentComponent, viewPool, paramType, update, paramSet);
    if (localObject != null) {
      detailAdapter.changeViewModel(0, (ViewModel)localObject);
    }
    localObject = new ModelsTransformedCallback()
    {
      public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramAnonymousModelsData)
      {
        if ((!isAdded()) || (detailAdapter == null) || (commentConsistencyCoordinator == null)) {
          return;
        }
        CommentDetailFragment.access$1100(CommentDetailFragment.this, update, paramType);
        detailAdapter.addNewComments(viewModels, 1, fragmentComponent, update);
        if (reply != null)
        {
          int i = detailAdapter.getIndexOfCommentWithId(reply.urn.toString());
          if (i >= 0) {
            detailRecyclerView.smoothScrollToPosition(i);
          }
        }
        commentConsistencyCoordinator.listenForUpdates(inputModels, replyChangedListener);
        CommentDetailFragment.access$1300$27b9cf55(CommentDetailFragment.this);
      }
    };
    paramMap = mergeReplies(paramMap, reply, FeedUpdateUtils.getCommentsSortOrder(socialDetail));
    FeedCommentTransformer.toViewModels(fragmentComponent, viewPool, paramMap, paramType, update, paramSet, (ModelsTransformedCallback)localObject);
  }
  
  public void onDestroy()
  {
    detailAdapter = null;
    mentionsPresenter.cleanUp();
    commentConsistencyCoordinator.removeListener(commentChangedListener);
    commentConsistencyCoordinator.removeListener(replyChangedListener);
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
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(FeedCommentHeaderShareClickEvent paramFeedCommentHeaderShareClickEvent)
  {
    FeedTracking.trackCommentClick(fragmentComponent, "header_share", ActionCategory.VIEW, "viewUpdateDetail", update, comment);
    if (previousPage == 0)
    {
      String str = updateUrn;
      if (update != null) {}
      for (paramFeedCommentHeaderShareClickEvent = update.entityUrn;; paramFeedCommentHeaderShareClickEvent = null)
      {
        paramFeedCommentHeaderShareClickEvent = FeedUpdateDetailBundleBuilder.create(str, paramFeedCommentHeaderShareClickEvent, update);
        paramFeedCommentHeaderShareClickEvent = applicationComponent.fragmentRegistry().feedDetail.newFragment(paramFeedCommentHeaderShareClickEvent);
        fragmentComponent.fragmentManager().beginTransaction().replace(2131755759, paramFeedCommentHeaderShareClickEvent).addToBackStack(null).commit();
        return;
      }
    }
    FeedNavigationUtils.navigateUp(activityComponent, true);
  }
  
  @Subscribe
  public void onEvent(FeedCommentLongClickEvent paramFeedCommentLongClickEvent)
  {
    if (update == null) {}
    for (Update localUpdate = update;; localUpdate = update)
    {
      FeedCommentLongClickHandler.handleLongClick(fragmentComponent, localUpdate, comment, actions);
      return;
    }
  }
  
  @Subscribe
  public void onEvent(FeedCommentUpdateEvent paramFeedCommentUpdateEvent)
  {
    if (detailAdapter == null) {}
    do
    {
      return;
      if (updateEventType == 9)
      {
        getActivity().onBackPressed();
        return;
      }
    } while ((updateEventType != 8) && (updateEventType != 10));
    commentConsistencyCoordinator.listenForUpdates(changedComment, commentChangedListener);
    if (updateEventType == 8) {}
    for (int i = 3;; i = 0)
    {
      FeedDataModelMetadata localFeedDataModelMetadata = getDataModelMetadata(i);
      Object localObject = FeedCommentTransformer.toViewModel(fragmentComponent, viewPool, changedComment, newUpdate, localFeedDataModelMetadata);
      if (localObject != null) {
        detailAdapter.changeViewModel(0, (ViewModel)localObject);
      }
      if (changedComment.socialDetail == null) {
        break;
      }
      localObject = new ModelsTransformedCallback()
      {
        public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramAnonymousModelsData)
        {
          if ((!isAdded()) || (detailAdapter == null)) {}
          for (;;)
          {
            return;
            paramAnonymousModelsData = viewModels.iterator();
            while (paramAnonymousModelsData.hasNext())
            {
              FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)paramAnonymousModelsData.next();
              if ((localFeedComponentViewModel instanceof FeedCommentViewModel)) {
                detailAdapter.changeCommentWithId(commentUrn, localFeedComponentViewModel);
              }
            }
          }
        }
      };
      FeedCommentTransformer.toViewModels(fragmentComponent, viewPool, changedComment.socialDetail.comments.elements, changedComment, newUpdate, localFeedDataModelMetadata, (ModelsTransformedCallback)localObject);
      return;
    }
  }
  
  @Subscribe
  public void onEvent(FeedCommentViewRepliesClickEvent paramFeedCommentViewRepliesClickEvent)
  {
    if (detailAdapter == null) {}
    label60:
    for (;;)
    {
      return;
      paramFeedCommentViewRepliesClickEvent = detailAdapter;
      int i = 0;
      if (i < paramFeedCommentViewRepliesClickEvent.getItemCount()) {
        if (!((FeedComponentViewModel)paramFeedCommentViewRepliesClickEvent.getItemAtPosition(i) instanceof FeedCommentViewModel)) {}
      }
      for (;;)
      {
        if (i < 0) {
          break label60;
        }
        detailRecyclerView.smoothScrollToPosition(i);
        return;
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  @Subscribe
  public void onEvent(FeedReplyButtonClickEvent paramFeedReplyButtonClickEvent)
  {
    if (comment.parentCommentUrn != null) {
      socialFooterManager.populateMention(comment);
    }
    socialFooterManager.setupSocialFooterState(1);
  }
  
  @Subscribe
  public void onEvent(FeedReplyLongClickEvent paramFeedReplyLongClickEvent)
  {
    if (comment == null) {}
    for (Comment localComment = comment;; localComment = comment)
    {
      FeedReplyLongClickHandler.handleLongClick(fragmentComponent, update, localComment, reply, actions);
      return;
    }
  }
  
  @Subscribe
  public void onEvent(FeedReplyUpdateEvent paramFeedReplyUpdateEvent)
  {
    if ((detailAdapter == null) || (detailRecyclerView == null) || (commentConsistencyCoordinator == null)) {}
    do
    {
      int i;
      Object localObject;
      do
      {
        return;
        commentConsistencyCoordinator.listenForUpdates(changedReply, replyChangedListener);
        if (updateEventType == 8) {}
        for (i = 2;; i = 0)
        {
          localObject = FeedCommentTransformer.toViewModel(fragmentComponent, viewPool, changedReply, newComment, update, getDataModelMetadata(i));
          if (localObject != null) {
            break;
          }
          getContext();
          Util.safeThrow$7a8b4789(new RuntimeException("Error transforming reply"));
          return;
        }
        if (!(localObject instanceof FeedCommentViewModel))
        {
          getContext();
          Util.safeThrow$7a8b4789(new RuntimeException("Expect a FeedCommentViewModel"));
          return;
        }
        localObject = (FeedCommentViewModel)localObject;
        if (updateEventType != 6) {
          break;
        }
        detailAdapter.addNewUserComment((FeedComponentViewModel)localObject, update.socialDetail);
        i = detailAdapter.getIndexOfCommentWithId(commentUrn);
      } while (i < 0);
      detailRecyclerView.smoothScrollToPosition(i);
      return;
      if (updateEventType == 7)
      {
        detailAdapter.changeCommentWithId(fakeId, (FeedComponentViewModel)localObject);
        return;
      }
      if ((updateEventType == 8) || (updateEventType == 10))
      {
        detailAdapter.changeCommentWithId(realId, (FeedComponentViewModel)localObject);
        return;
      }
    } while (updateEventType != 9);
    detailAdapter.deleteCommentWithId(realId);
  }
  
  @Subscribe
  public void onEvent(LoadMoreEvent paramLoadMoreEvent)
  {
    if ((usage != 1) || (!isAdded()) || (detailAdapter == null)) {}
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
          detailAdapter.animateLoadingViews(fragmentComponent, update);
          if (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_LOAD_MORE_COMMENTS_PVE)) {
            new PageViewEvent(tracker, getDetailPageKey(), false).send();
          }
          if ((detailDataProvider.state).commentsCollectionHelper == null) && (comment != null)) {
            detailDataProvider.initCommentsCollectionTemplate(comment.socialDetail, fragmentComponent.dataManager());
          }
          if (eventType != 0) {
            break;
          }
          paramLoadMoreEvent = detailDataProvider;
          localMap = Tracker.createPageInstanceHeader(getPageInstance());
          localObject = busSubscriberId;
          str = RUMHelper.pageInitLoadMore(this);
          localUri = FeedRouteUtils.getBaseCommentsRoute(threadId, null);
        } while (state).commentsCollectionHelper == null);
        localObject = paramLoadMoreEvent.getCommentsListener(localUri, (String)localObject, str, 6);
        state).commentsCollectionHelper.fetchLoadPreviousData$2fec3de(localMap, localUri, (RecordTemplateListener)localObject, str);
        return;
      } while (eventType != 1);
      paramLoadMoreEvent = detailDataProvider;
      localMap = Tracker.createPageInstanceHeader(getPageInstance());
      localObject = busSubscriberId;
      str = RUMHelper.pageInitLoadMore(this);
      localUri = FeedRouteUtils.getBaseCommentsRoute(threadId, null);
    } while (state).commentsCollectionHelper == null);
    Object localObject = paramLoadMoreEvent.getCommentsListener(localUri, (String)localObject, str, 5);
    state).commentsCollectionHelper.fetchLoadMoreData(localMap, 1, null, localUri, (RecordTemplateListener)localObject, str);
  }
  
  public final void onSocialFooterComposeState()
  {
    if ((dismissComposeView != null) && (detailRecyclerView != null))
    {
      dismissComposeView.setVisibility(0);
      View.OnClickListener local4 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          FeatureLog.i(CommentDetailFragment.TAG, "dismissComposeView onClick", "Feed Logging");
          dismissComposeView.setVisibility(8);
          socialFooterManager.setupSocialFooterState(0);
          detailRecyclerView.setEnabled(true);
          detailRecyclerView.setClickable(true);
          trackButtonShortPress("feed_detail_container");
          if ((update != null) && (update.tracking != null) && (update.urn != null)) {
            FeedTracking.trackFAE(tracker, "feed_detail_container", ActionCategory.DISMISS, "dismissReply", update.tracking, update.urn, fragmentComponent);
          }
        }
      };
      dismissComposeView.setOnClickListener(local4);
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
    if (detailAdapter != null)
    {
      feedLayoutManager = new CommentDetailLayoutManager(getActivity());
      detailRecyclerView.setLayoutManager(feedLayoutManager);
      detailRecyclerView.setAdapter(detailAdapter);
      detailRecyclerView.setRecycledViewPool(viewPool);
      viewPortManager.container = detailRecyclerView;
      detailAdapter.setViewPortManager(viewPortManager);
      detailRecyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
    }
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((mentionsRecyclerView != null) && (mentionsRecyclerView.getVisibility() == 0) && (socialFooterManager != null))
        {
          socialFooterManager.displaySuggestions(false);
          return;
        }
        paramAnonymousView = keyboardUtil;
        KeyboardUtil.hideKeyboard(socialFooter.reply);
        FeedNavigationUtils.navigateUp(activityComponent, false);
      }
    });
    socialFooter = new SocialFooterViewHolder(paramView);
    socialFooterManager = new CommentDetailSocialFooterManager(fragmentComponent, mentionsPresenter, mentionsRecyclerView, socialFooter, mentionWorkFlowId);
    socialFooterManager.setSocialFooterStateChangeListener(this);
    if ((update == null) && (comment == null))
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Update and comment both are null"));
      if ((isMentionPopulated) && ((reply != null) || (comment != null)))
      {
        paramBundle = socialFooterManager;
        if (reply == null) {
          break label386;
        }
      }
    }
    label386:
    for (paramView = reply;; paramView = comment)
    {
      paramBundle.populateMention(paramView);
      return;
      if (comment == null)
      {
        paramBundle = FeedRouteUtils.getSingleCommentUrl(commentUrn);
        if (TextUtils.isEmpty(getRumSessionId())) {
          break;
        }
        paramView = detailDataProvider;
        String str1 = busSubscriberId;
        String str2 = getRumSessionId();
        Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
        state).singleCommentRoute = paramBundle;
        paramBundle = Request.get().url(paramBundle).customHeaders(localMap).builder(Comment.BUILDER).listener(paramView.newModelListener(str1, str2)).filter(DataManager.DataStoreFilter.NETWORK_ONLY).trackingSessionId(str2);
        activityComponent.dataManager().submit(paramBundle);
        break;
      }
      setupCommentAndFetchSocialDetail();
      break;
    }
  }
  
  public final String pageKey()
  {
    return "comment_detail_base";
  }
  
  public final String provideDebugData()
  {
    String str1;
    if (update != null)
    {
      str1 = update.urn.toString();
      if (comment == null) {
        break label72;
      }
    }
    label72:
    for (String str2 = comment.urn.toString();; str2 = commentUrn)
    {
      return "Feed Comment Detail Update Id: " + str1 + " Comment Id: " + str2;
      str1 = updateUrn;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */