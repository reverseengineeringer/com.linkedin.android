package com.linkedin.android.feed.endor.ui.component.insight;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;
import com.linkedin.android.feed.shared.StackedImagesDrawable.Builder;
import com.linkedin.android.imageloader.ManagedDrawableWrapper;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.List;

public final class FeedInsightViewModel
  extends FeedComponentViewModel<FeedBasicTextViewHolder, FeedBasicTextLayout>
{
  TrackingOnClickListener containerClickListener;
  public List<ImageModel> images;
  public boolean isImageOval;
  private final ManagedDrawableWrapper managedDrawable = new ManagedDrawableWrapper();
  public CharSequence text;
  
  public FeedInsightViewModel(FeedBasicTextLayout paramFeedBasicTextLayout)
  {
    super(paramFeedBasicTextLayout);
  }
  
  private void updateViewHolder(FeedBasicTextViewHolder paramFeedBasicTextViewHolder, MediaCenter paramMediaCenter)
  {
    ViewUtils.setTextAndUpdateVisibility(textView, text, false);
    if ((!TextUtils.isEmpty(text)) && (CollectionUtils.isNonEmpty(images)))
    {
      int i = (int)itemView.getResources().getDimension(2131492989);
      paramMediaCenter = new StackedImagesDrawable.Builder(textView.getContext(), paramMediaCenter, images);
      imageSizeRes = 2131493129;
      hasRoundedImages = isImageOval;
      borderWidthRes = 2131493146;
      paramMediaCenter = paramMediaCenter.build();
      textView.setCompoundDrawablesWithIntrinsicBounds(paramMediaCenter, null, null, null);
      textView.setCompoundDrawablePadding(i);
      managedDrawable.setDrawable(paramMediaCenter);
    }
    ViewUtils.setOnClickListenerAndUpdateClickable(textView, containerClickListener, true);
  }
  
  public final ViewHolderCreator<FeedBasicTextViewHolder> getCreator()
  {
    return FeedBasicTextViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedBasicTextViewHolder);
    updateViewHolder(paramFeedBasicTextViewHolder, paramMediaCenter);
  }
  
  public final void onRecycleViewHolder(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    managedDrawable.release();
    super.onRecycleViewHolder(paramFeedBasicTextViewHolder);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.insight.FeedInsightViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */