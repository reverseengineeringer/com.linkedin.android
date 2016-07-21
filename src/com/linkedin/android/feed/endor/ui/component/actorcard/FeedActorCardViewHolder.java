package com.linkedin.android.feed.endor.ui.component.actorcard;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedActorCardViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedActorCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968709;
    }
  };
  @InjectView(2131755608)
  public Button actionButton;
  @InjectView(2131755605)
  public TextView actorHeadline;
  @InjectView(2131755603)
  public LiImageView actorImage;
  @InjectView(2131755604)
  public TextView actorName;
  @InjectView(2131755606)
  public TextView secondaryHeadline;
  
  public FeedActorCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.actorcard.FeedActorCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */