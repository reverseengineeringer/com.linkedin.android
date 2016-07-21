package com.linkedin.android.feed.endor.ui.component.actorcard;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.imageloader.LiImageView;

public class FeedActorCardViewHolder$$ViewInjector<T extends FeedActorCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    actorImage = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755603, "field 'actorImage'"), 2131755603, "field 'actorImage'"));
    actorName = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755604, "field 'actorName'"), 2131755604, "field 'actorName'"));
    actorHeadline = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755605, "field 'actorHeadline'"), 2131755605, "field 'actorHeadline'"));
    secondaryHeadline = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755606, "field 'secondaryHeadline'"), 2131755606, "field 'secondaryHeadline'"));
    actionButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755608, "field 'actionButton'"), 2131755608, "field 'actionButton'"));
  }
  
  public void reset(T paramT)
  {
    actorImage = null;
    actorName = null;
    actorHeadline = null;
    secondaryHeadline = null;
    actionButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.actorcard.FeedActorCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */