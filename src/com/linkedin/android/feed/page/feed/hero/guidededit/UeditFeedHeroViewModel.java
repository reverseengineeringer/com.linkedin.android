package com.linkedin.android.feed.page.feed.hero.guidededit;

import android.view.View.OnClickListener;
import android.widget.Button;
import com.linkedin.android.feed.page.feed.hero.FeedHeroViewHolder;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditCategoryName;

public final class UeditFeedHeroViewModel
  extends ViewModel<FeedHeroViewHolder>
{
  public View.OnClickListener cancelOnClickListener;
  public String dismissButtonText;
  public String entryButtonText;
  public String flowTrackingId;
  public GuidedEditCategoryName guidedEditCategoryName;
  public boolean hasFiredImpression;
  public ImageModel icon;
  public LegoTrackingDataProvider legoTrackingDataProvider;
  public String legoTrackingId;
  public String subtext;
  public String title;
  public View.OnClickListener toastOnClickListener;
  
  public final ViewHolderCreator<FeedHeroViewHolder> getCreator()
  {
    return FeedHeroViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$7d9602dc(MediaCenter paramMediaCenter, FeedHeroViewHolder paramFeedHeroViewHolder)
  {
    icon.setImageView(paramMediaCenter, logo);
    ViewUtils.setTextAndUpdateVisibility(title, title);
    ViewUtils.setTextAndUpdateVisibility(text, subtext);
    prompt.setText(entryButtonText);
    prompt.setOnClickListener(toastOnClickListener);
    dismiss.setText(dismissButtonText);
    dismiss.setOnClickListener(cancelOnClickListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.guidededit.UeditFeedHeroViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */