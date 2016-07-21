package com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.socialbar.FeedBaseSocialBarViewModel;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.shared.ViewUtils;

public final class FeedSocialActionsBarViewModel
  extends FeedBaseSocialBarViewModel<FeedSocialActionsBarViewHolder, FeedSocialActionsBarLayout>
{
  private boolean invertColors;
  
  public FeedSocialActionsBarViewModel(FeedSocialActionsBarLayout paramFeedSocialActionsBarLayout, boolean paramBoolean)
  {
    super(paramFeedSocialActionsBarLayout);
    invertColors = paramBoolean;
  }
  
  private void onViewModelChange$41adcffb(FeedSocialActionsBarViewHolder paramFeedSocialActionsBarViewHolder)
  {
    setupListeners(paramFeedSocialActionsBarViewHolder);
    setupLikeButton(paramFeedSocialActionsBarViewHolder, true);
  }
  
  private void setupLikeButton(FeedSocialActionsBarViewHolder paramFeedSocialActionsBarViewHolder, boolean paramBoolean)
  {
    Context localContext = likeButtonLayout.getContext();
    int j = ContextCompat.getColor(localContext, 2131624191);
    int i;
    Object localObject;
    if (invertColors)
    {
      i = 2131624337;
      i = ContextCompat.getColor(localContext, i);
      localObject = likeButtonText;
      if (!isLiked) {
        break label103;
      }
      i = j;
      label51:
      ((TextView)localObject).setTextColor(i);
      likeButton.setLikeState(isLiked, paramBoolean);
      localObject = likeButtonLayout;
      if (!isLiked) {
        break label106;
      }
    }
    label103:
    label106:
    for (paramFeedSocialActionsBarViewHolder = localContext.getString(2131231095);; paramFeedSocialActionsBarViewHolder = localContext.getString(2131231093))
    {
      ((LinearLayout)localObject).setContentDescription(paramFeedSocialActionsBarViewHolder);
      return;
      i = 2131624336;
      break;
      break label51;
    }
  }
  
  private void setupListeners(FeedSocialActionsBarViewHolder paramFeedSocialActionsBarViewHolder)
  {
    ViewUtils.setOnClickListenerAndUpdateVisibility(replyButtonLayout, replyClickListener);
    ViewUtils.setOnClickListenerAndUpdateVisibility(reshareButtonLayout, reshareClickListener);
    ViewUtils.setOnClickListenerAndUpdateVisibility(likeButtonLayout, likeClickListener);
  }
  
  public final ViewHolderCreator<FeedSocialActionsBarViewHolder> getCreator()
  {
    return FeedSocialActionsBarViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar.FeedSocialActionsBarViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */