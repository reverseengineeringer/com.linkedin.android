package com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ui.TintableImageView;

public class FeedSocialActionsBarViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedSocialActionsBarViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968735;
    }
  };
  @InjectView(2131755730)
  public View divider;
  @InjectView(2131755733)
  public LikeButton likeButton;
  @InjectView(2131755732)
  public LinearLayout likeButtonLayout;
  @InjectView(2131755734)
  public TextView likeButtonText;
  @InjectView(2131755736)
  public TintableImageView replyButton;
  @InjectView(2131755735)
  public LinearLayout replyButtonLayout;
  @InjectView(2131755737)
  public TextView replyButtonText;
  @InjectView(2131755739)
  public TintableImageView reshareButton;
  @InjectView(2131755738)
  public LinearLayout reshareButtonLayout;
  @InjectView(2131755740)
  public TextView reshareButtonText;
  
  public FeedSocialActionsBarViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar.FeedSocialActionsBarViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */