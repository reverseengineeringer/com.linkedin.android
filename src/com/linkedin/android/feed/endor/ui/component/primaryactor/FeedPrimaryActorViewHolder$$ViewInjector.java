package com.linkedin.android.feed.endor.ui.component.primaryactor;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ui.TintableImageView;

public class FeedPrimaryActorViewHolder$$ViewInjector<T extends FeedPrimaryActorViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    actorImage = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755712, "field 'actorImage'"), 2131755712, "field 'actorImage'"));
    actorInfoContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755713, "field 'actorInfoContainer'"), 2131755713, "field 'actorInfoContainer'"));
    actorName = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755714, "field 'actorName'"), 2131755714, "field 'actorName'"));
    actorHeadline = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755715, "field 'actorHeadline'"), 2131755715, "field 'actorHeadline'"));
    secondaryHeadline = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755716, "field 'secondaryHeadline'"), 2131755716, "field 'secondaryHeadline'"));
    actionButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755717, "field 'actionButton'"), 2131755717, "field 'actionButton'"));
    sponsoredFollowButton = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755718, "field 'sponsoredFollowButton'"), 2131755718, "field 'sponsoredFollowButton'"));
    controlDropdown = ((TintableImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755720, "field 'controlDropdown'"), 2131755720, "field 'controlDropdown'"));
    downloadButton = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755719, "field 'downloadButton'"), 2131755719, "field 'downloadButton'"));
  }
  
  public void reset(T paramT)
  {
    actorImage = null;
    actorInfoContainer = null;
    actorName = null;
    actorHeadline = null;
    secondaryHeadline = null;
    actionButton = null;
    sponsoredFollowButton = null;
    controlDropdown = null;
    downloadButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */