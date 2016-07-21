package com.linkedin.android.feed.endor.ui.component.likerow;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.makeramen.roundedimageview.RoundedImageView;

public class FeedLikeRowViewHolder$$ViewInjector<T extends FeedLikeRowViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    likeActorImage = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755697, "field 'likeActorImage'"), 2131755697, "field 'likeActorImage'"));
    likeActorName = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755699, "field 'likeActorName'"), 2131755699, "field 'likeActorName'"));
    likeActorBullet = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755700, "field 'likeActorBullet'"), 2131755700, "field 'likeActorBullet'"));
    likeActorDistance = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755701, "field 'likeActorDistance'"), 2131755701, "field 'likeActorDistance'"));
    likeActorHeadline = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755702, "field 'likeActorHeadline'"), 2131755702, "field 'likeActorHeadline'"));
    likeActorInsight = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755703, "field 'likeActorInsight'"), 2131755703, "field 'likeActorInsight'"));
    likeTime = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755698, "field 'likeTime'"), 2131755698, "field 'likeTime'"));
  }
  
  public void reset(T paramT)
  {
    likeActorImage = null;
    likeActorName = null;
    likeActorBullet = null;
    likeActorDistance = null;
    likeActorHeadline = null;
    likeActorInsight = null;
    likeTime = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likerow.FeedLikeRowViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */