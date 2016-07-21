package com.linkedin.android.feed.endor.ui.component.richmedia;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ui.AspectRatioImageView;
import com.linkedin.android.infra.ui.TintableImageButton;

public class FeedRichMediaViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedRichMediaViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968733;
    }
  };
  @InjectView(2131755722)
  public AspectRatioImageView imageView;
  @InjectView(2131755723)
  public TintableImageButton playButton;
  
  public FeedRichMediaViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */