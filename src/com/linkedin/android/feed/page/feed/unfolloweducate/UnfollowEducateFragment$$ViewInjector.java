package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.utils.PulsatingView;

public class UnfollowEducateFragment$$ViewInjector<T extends UnfollowEducateFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    viewFlipper = ((ViewFlipper)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755849, "field 'viewFlipper'"), 2131755849, "field 'viewFlipper'"));
    pulsingButton = ((PulsatingView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755873, "field 'pulsingButton'"), 2131755873, "field 'pulsingButton'"));
    unfollowButton = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755846, "field 'unfollowButton'"), 2131755846, "field 'unfollowButton'"));
    controlPanelOverlay = ((View)paramFinder.findRequiredView(paramObject, 2131755842, "field 'controlPanelOverlay'"));
    unfollowButtonTopBar = ((View)paramFinder.findRequiredView(paramObject, 2131755843, "field 'unfollowButtonTopBar'"));
    unfollowButtonBottomBar = ((View)paramFinder.findRequiredView(paramObject, 2131755844, "field 'unfollowButtonBottomBar'"));
    doneButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755864, "field 'doneButton'"), 2131755864, "field 'doneButton'"));
    unfollowTitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755861, "field 'unfollowTitle'"), 2131755861, "field 'unfollowTitle'"));
    unfollowText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755862, "field 'unfollowText'"), 2131755862, "field 'unfollowText'"));
    unfollowList = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755863, "field 'unfollowList'"), 2131755863, "field 'unfollowList'"));
    unfollowFragmentContainer = ((View)paramFinder.findRequiredView(paramObject, 2131755848, "field 'unfollowFragmentContainer'"));
    skipButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755850, "field 'skipButton'"), 2131755850, "field 'skipButton'"));
  }
  
  public void reset(T paramT)
  {
    viewFlipper = null;
    pulsingButton = null;
    unfollowButton = null;
    controlPanelOverlay = null;
    unfollowButtonTopBar = null;
    unfollowButtonBottomBar = null;
    doneButton = null;
    unfollowTitle = null;
    unfollowText = null;
    unfollowList = null;
    unfollowFragmentContainer = null;
    skipButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */