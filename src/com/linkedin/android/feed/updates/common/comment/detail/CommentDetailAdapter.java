package com.linkedin.android.feed.updates.common.comment.detail;

import android.content.Context;
import com.linkedin.android.feed.detail.BaseDetailAdapter;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingTransformer;
import com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingViewModel;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.lang.ref.WeakReference;

public final class CommentDetailAdapter
  extends BaseDetailAdapter
{
  WeakReference<CommentDetailDataProvider> detailDataProvider;
  Comment parentComment;
  
  public CommentDetailAdapter(Context paramContext, MediaCenter paramMediaCenter, FeedComponentsViewPool paramFeedComponentsViewPool)
  {
    super(paramContext, paramMediaCenter, paramFeedComponentsViewPool);
  }
  
  protected final boolean hasNextComments()
  {
    CommentDetailDataProvider localCommentDetailDataProvider;
    if (detailDataProvider == null)
    {
      localCommentDetailDataProvider = null;
      if (localCommentDetailDataProvider == null) {
        break label117;
      }
      if (((state).commentsCollectionHelper != null) && (state).commentsCollectionHelper.getPaging() != null) && (state).commentsCollectionHelper.getPaging().total == 0)) || (state).commentsCollectionHelper == null) || (!state).commentsCollectionHelper.hasMoreDataToFetch())) {
        break label112;
      }
    }
    label112:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label117;
      }
      return true;
      localCommentDetailDataProvider = (CommentDetailDataProvider)detailDataProvider.get();
      break;
    }
    label117:
    return false;
  }
  
  protected final boolean hasPreviousComments()
  {
    CommentDetailDataProvider localCommentDetailDataProvider;
    if (detailDataProvider == null)
    {
      localCommentDetailDataProvider = null;
      if (localCommentDetailDataProvider == null) {
        break label69;
      }
      if ((state).commentsCollectionHelper == null) || (!state).commentsCollectionHelper.hasPreviousDataToFetch())) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label69;
      }
      return true;
      localCommentDetailDataProvider = (CommentDetailDataProvider)detailDataProvider.get();
      break;
    }
    label69:
    return false;
  }
  
  protected final FeedCommentLoadingViewModel toLoadNextViewModel$638ce296(FragmentComponent paramFragmentComponent, Update paramUpdate)
  {
    return FeedCommentLoadingTransformer.toViewModel(paramFragmentComponent, paramUpdate, parentComment, 1, false, true);
  }
  
  protected final FeedCommentLoadingViewModel toLoadPreviousViewModel(FragmentComponent paramFragmentComponent, Update paramUpdate, boolean paramBoolean)
  {
    return FeedCommentLoadingTransformer.toViewModel(paramFragmentComponent, paramUpdate, parentComment, 0, paramBoolean, true);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */