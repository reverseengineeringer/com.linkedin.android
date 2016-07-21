package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.entities.shared.AutofitTextButton;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class EntityDetailedTopCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<EntityDetailedTopCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968701;
    }
  };
  @InjectView(2131755567)
  public LinearLayout buttonContainer;
  @InjectView(2131755557)
  public ImageView coverImageBottomGradientView;
  @InjectView(2131755556)
  public ImageView coverImageTopGradientView;
  @InjectView(2131755554)
  public ImageView coverView;
  @InjectView(2131755571)
  public TextView detailView;
  @InjectView(2131755562)
  public ImageView iconView;
  public FeedBasicTextViewHolder insightViewHolder;
  @InjectView(2131755558)
  public RelativeLayout overlayContainer;
  @InjectView(2131755569)
  public AutofitTextButton primaryButton;
  @InjectView(2131755570)
  public AutofitTextButton primaryButtonClicked;
  @InjectView(2131755568)
  public AutofitTextButton secondaryButton;
  @InjectView(2131755565)
  public TextView subtitleView1;
  @InjectView(2131755566)
  public TextView subtitleView2;
  @InjectView(2131755564)
  public TextView titleView;
  
  public EntityDetailedTopCardViewHolder(View paramView)
  {
    super(paramView);
    insightViewHolder = ((FeedBasicTextViewHolder)FeedBasicTextViewHolder.CREATOR.createViewHolder(paramView));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */