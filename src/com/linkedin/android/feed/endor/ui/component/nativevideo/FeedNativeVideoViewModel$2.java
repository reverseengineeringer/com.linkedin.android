package com.linkedin.android.feed.endor.ui.component.nativevideo;

import android.widget.ProgressBar;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ui.TintableImageButton;
import com.linkedin.android.video.listener.SimplePlayerViewListener;

final class FeedNativeVideoViewModel$2
  extends SimplePlayerViewListener
{
  FeedNativeVideoViewModel$2(FeedNativeVideoViewModel paramFeedNativeVideoViewModel, FeedNativeVideoViewHolder paramFeedNativeVideoViewHolder) {}
  
  public final void onStateChanged(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      localFeedNativeVideoViewHolder = val$holder;
      playButton.setVisibility(8);
      spinner.setVisibility(0);
      thumbnail.setVisibility(0);
      return;
    case 1: 
    case 2: 
    case 5: 
      FeedNativeVideoViewModel.access$100$725a87e6(val$holder);
      return;
    }
    FeedNativeVideoViewHolder localFeedNativeVideoViewHolder = val$holder;
    spinner.setVisibility(8);
    playButton.setVisibility(8);
    thumbnail.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.nativevideo.FeedNativeVideoViewModel.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */