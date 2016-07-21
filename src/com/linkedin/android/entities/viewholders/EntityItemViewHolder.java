package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public class EntityItemViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968684;
    }
  };
  @InjectView(2131755497)
  public TextView badge;
  @InjectView(2131755499)
  public ImageButton ctaButton;
  @InjectView(2131755500)
  public ImageButton ctaClickedButton;
  @InjectView(2131755495)
  public LinearLayout footer;
  @InjectView(2131755496)
  public TextView footerTextView;
  @InjectView(2131755489)
  public RoundedImageView image;
  public FeedBasicTextViewHolder insightViewHolder;
  @InjectView(2131755498)
  public TextView newBadge;
  @InjectView(2131755493)
  public TextView subtitle;
  @InjectView(2131755494)
  public TextView subtitle2;
  @InjectView(2131755491)
  public TextView superTitle;
  @InjectView(2131755492)
  public TextView title;
  
  private EntityItemViewHolder(View paramView)
  {
    super(paramView);
    insightViewHolder = ((FeedBasicTextViewHolder)FeedBasicTextViewHolder.CREATOR.createViewHolder(paramView));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityItemViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */