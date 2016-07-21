package com.linkedin.android.feed.detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingTransformer;
import com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingViewHolder;
import com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingViewModel;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.lang.ref.WeakReference;

public final class FeedUpdateDetailAdapter
  extends BaseDetailAdapter
{
  WeakReference<FeedUpdateDetailDataProvider> detailDataProvider;
  int loadingViewHeight = -1;
  
  public FeedUpdateDetailAdapter(Context paramContext, MediaCenter paramMediaCenter, FeedComponentsViewPool paramFeedComponentsViewPool)
  {
    super(paramContext, paramMediaCenter, paramFeedComponentsViewPool);
  }
  
  protected final boolean hasNextComments()
  {
    if (detailDataProvider == null) {}
    for (FeedUpdateDetailDataProvider localFeedUpdateDetailDataProvider = null; (localFeedUpdateDetailDataProvider != null) && (localFeedUpdateDetailDataProvider.hasNextComments()); localFeedUpdateDetailDataProvider = (FeedUpdateDetailDataProvider)detailDataProvider.get()) {
      return true;
    }
    return false;
  }
  
  protected final boolean hasPreviousComments()
  {
    FeedUpdateDetailDataProvider localFeedUpdateDetailDataProvider;
    if (detailDataProvider == null)
    {
      localFeedUpdateDetailDataProvider = null;
      if (localFeedUpdateDetailDataProvider == null) {
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
      localFeedUpdateDetailDataProvider = (FeedUpdateDetailDataProvider)detailDataProvider.get();
      break;
    }
    label69:
    return false;
  }
  
  public final void onBindViewHolder(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramBaseViewHolder, paramInt);
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramBaseViewHolder instanceof FeedCommentLoadingViewHolder))
    {
      if (loadingViewHeight <= 0) {
        break label47;
      }
      localLayoutParams = new ViewGroup.LayoutParams(-1, loadingViewHeight);
      loadingViewHeight = -1;
    }
    for (;;)
    {
      itemView.setLayoutParams(localLayoutParams);
      return;
      label47:
      localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    }
  }
  
  protected final FeedCommentLoadingViewModel toLoadNextViewModel$638ce296(FragmentComponent paramFragmentComponent, Update paramUpdate)
  {
    return FeedCommentLoadingTransformer.toViewModel(paramFragmentComponent, paramUpdate, 1, false);
  }
  
  protected final FeedCommentLoadingViewModel toLoadPreviousViewModel(FragmentComponent paramFragmentComponent, Update paramUpdate, boolean paramBoolean)
  {
    return FeedCommentLoadingTransformer.toViewModel(paramFragmentComponent, paramUpdate, 0, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */