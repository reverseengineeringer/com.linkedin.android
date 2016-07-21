package com.linkedin.android.feed.endor.ui.component.nativevideo;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ui.TintableImageButton;

public class FeedNativeVideoViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedNativeVideoViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968731;
    }
  };
  @InjectView(2131755709)
  public TintableImageButton playButton;
  @InjectView(2131755710)
  public ProgressBar spinner;
  @InjectView(2131755708)
  public LiImageView thumbnail;
  @InjectView(2131755707)
  public FrameLayout videoFrame;
  
  public FeedNativeVideoViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.nativevideo.FeedNativeVideoViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */