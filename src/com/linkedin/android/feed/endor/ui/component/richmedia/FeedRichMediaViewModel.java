package com.linkedin.android.feed.endor.ui.component.richmedia;

import android.net.Uri;
import android.view.LayoutInflater;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaLayout;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.ui.AspectRatioImageView;
import com.linkedin.android.infra.ui.TintableImageButton;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedRichMediaViewModel
  extends FeedComponentViewModel<FeedRichMediaViewHolder, FeedRichMediaLayout>
{
  public TrackingOnClickListener clickListener;
  public ImageModel image;
  public boolean isVideo;
  
  public FeedRichMediaViewModel(FeedRichMediaLayout paramFeedRichMediaLayout)
  {
    super(paramFeedRichMediaLayout);
  }
  
  private static boolean isLocalImage(ImageModel paramImageModel)
  {
    return (paramImageModel != null) && (((imageUri != null) && ("content".equals(imageUri.getScheme()))) || ((imageResourceId != null) && (imageResourceId.startsWith("content"))));
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedRichMediaViewHolder paramFeedRichMediaViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedRichMediaViewHolder);
    if (image != null) {
      image.setImageView(paramMediaCenter, imageView);
    }
    setClickListeners(paramFeedRichMediaViewHolder);
  }
  
  private void setClickListeners(FeedRichMediaViewHolder paramFeedRichMediaViewHolder)
  {
    imageView.setOnClickListener(clickListener);
    playButton.setOnClickListener(clickListener);
  }
  
  public final ViewHolderCreator<FeedRichMediaViewHolder> getCreator()
  {
    return FeedRichMediaViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */