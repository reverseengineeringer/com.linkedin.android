package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class NewToVoyagerFeedCardViewModel
  extends ViewModel<NewToVoyagerFeedCardViewHolder>
{
  public View.OnClickListener continueButtonOnClickListener;
  public String heading;
  public String legoTrackingToken;
  public View.OnClickListener notNowButtonOnClickListener;
  private NewToVoyagerFeedCardViewHolder viewHolder;
  
  public final ViewHolderCreator<NewToVoyagerFeedCardViewHolder> getCreator()
  {
    return NewToVoyagerFeedCardViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$24bfd94d(NewToVoyagerFeedCardViewHolder paramNewToVoyagerFeedCardViewHolder)
  {
    viewHolder = paramNewToVoyagerFeedCardViewHolder;
    headingTextView.setText(heading);
    continueButton.setOnClickListener(continueButtonOnClickListener);
    notNowButton.setOnClickListener(notNowButtonOnClickListener);
  }
  
  public final void showHideFeedPromoImage(boolean paramBoolean)
  {
    ImageView localImageView = viewHolder.promoImage;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */