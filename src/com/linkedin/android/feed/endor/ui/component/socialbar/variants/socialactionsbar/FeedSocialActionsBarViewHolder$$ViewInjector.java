package com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.infra.ui.TintableImageView;

public class FeedSocialActionsBarViewHolder$$ViewInjector<T extends FeedSocialActionsBarViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    replyButtonLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755735, "field 'replyButtonLayout'"), 2131755735, "field 'replyButtonLayout'"));
    replyButton = ((TintableImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755736, "field 'replyButton'"), 2131755736, "field 'replyButton'"));
    replyButtonText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755737, "field 'replyButtonText'"), 2131755737, "field 'replyButtonText'"));
    reshareButtonLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755738, "field 'reshareButtonLayout'"), 2131755738, "field 'reshareButtonLayout'"));
    reshareButton = ((TintableImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755739, "field 'reshareButton'"), 2131755739, "field 'reshareButton'"));
    reshareButtonText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755740, "field 'reshareButtonText'"), 2131755740, "field 'reshareButtonText'"));
    likeButtonLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755732, "field 'likeButtonLayout'"), 2131755732, "field 'likeButtonLayout'"));
    likeButtonText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755734, "field 'likeButtonText'"), 2131755734, "field 'likeButtonText'"));
    likeButton = ((LikeButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755733, "field 'likeButton'"), 2131755733, "field 'likeButton'"));
    divider = ((View)paramFinder.findRequiredView(paramObject, 2131755730, "field 'divider'"));
  }
  
  public void reset(T paramT)
  {
    replyButtonLayout = null;
    replyButton = null;
    replyButtonText = null;
    reshareButtonLayout = null;
    reshareButton = null;
    reshareButtonText = null;
    likeButtonLayout = null;
    likeButtonText = null;
    likeButton = null;
    divider = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar.FeedSocialActionsBarViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */