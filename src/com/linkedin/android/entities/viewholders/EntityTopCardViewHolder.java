package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.entities.shared.AutofitTextButton;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class EntityTopCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<EntityTopCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968702;
    }
  };
  @InjectView(2131755554)
  public ImageView coverView;
  @InjectView(2131755572)
  public AutofitTextButton ctaButton;
  @InjectView(2131755573)
  public AutofitTextButton ctaClickedButton;
  @InjectView(2131755562)
  public ImageView iconView;
  @InjectView(2131755565)
  public TextView subtitle1View;
  @InjectView(2131755566)
  public TextView subtitle2View;
  @InjectView(2131755564)
  public TextView titleView;
  
  public EntityTopCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityTopCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */