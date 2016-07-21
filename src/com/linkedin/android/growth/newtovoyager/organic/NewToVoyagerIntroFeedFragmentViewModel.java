package com.linkedin.android.growth.newtovoyager.organic;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.support.v7.widget.CardView;
import android.text.Spanned;
import android.view.View;
import com.linkedin.android.infra.ViewHolderCreator;

public final class NewToVoyagerIntroFeedFragmentViewModel
  extends NewToVoyagerIntroBaseFragmentViewModel<NewToVoyagerIntroFeedFragmentViewHolder>
{
  public Spanned feedPostTitle;
  public Spanned feedTrendTitle;
  
  public final ViewHolderCreator<NewToVoyagerIntroFeedFragmentViewHolder> getCreator()
  {
    return NewToVoyagerIntroFeedFragmentViewHolder.CREATOR;
  }
  
  protected final void populateAnimatorSet(AnimatorSet paramAnimatorSet)
  {
    paramAnimatorSet.playSequentially(new Animator[] { moveVertically(viewHolder).trendingCardView), expandElastically(viewHolder).trendingCardIcon), moveVertically(viewHolder).postCardView), expandElastically(viewHolder).postCardIcon) });
  }
  
  protected final void resetViews()
  {
    viewHolder).trendingCardView.setTranslationY(2000.0F);
    viewHolder).postCardView.setTranslationY(2000.0F);
    viewHolder).trendingCardIcon.setVisibility(4);
    viewHolder).postCardIcon.setVisibility(4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFeedFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */