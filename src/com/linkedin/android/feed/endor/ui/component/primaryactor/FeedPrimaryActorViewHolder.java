package com.linkedin.android.feed.endor.ui.component.primaryactor;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ui.TintableImageView;

public class FeedPrimaryActorViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedPrimaryActorViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968732;
    }
  };
  @InjectView(2131755717)
  public Button actionButton;
  @InjectView(2131755715)
  public TextView actorHeadline;
  @InjectView(2131755712)
  public LiImageView actorImage;
  @InjectView(2131755713)
  public LinearLayout actorInfoContainer;
  @InjectView(2131755714)
  public TextView actorName;
  @InjectView(2131755720)
  public TintableImageView controlDropdown;
  @InjectView(2131755719)
  public ImageView downloadButton;
  @InjectView(2131755716)
  public TextView secondaryHeadline;
  @InjectView(2131755718)
  public ImageView sponsoredFollowButton;
  
  public FeedPrimaryActorViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */