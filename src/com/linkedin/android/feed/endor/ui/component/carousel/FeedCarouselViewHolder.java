package com.linkedin.android.feed.endor.ui.component.carousel;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedCarouselViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedCarouselViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968712;
    }
  };
  @InjectView(2131755613)
  FeedCarouselRecyclerView carousel;
  
  public FeedCarouselViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */