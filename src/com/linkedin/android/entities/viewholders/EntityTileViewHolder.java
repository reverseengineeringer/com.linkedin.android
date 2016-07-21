package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public class EntityTileViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<EntityTileViewHolder> CREATOR_TILE = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968700;
    }
  };
  public static final ViewHolderCreator<EntityTileViewHolder> CREATOR_TILE_IN_CARD = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968673;
    }
  };
  @InjectView(2131755552)
  public TextView detail;
  @InjectView(2131755550)
  public ImageView detailDivider;
  @InjectView(2131755551)
  public RoundedImageView detailIcon;
  @InjectView(2131755546)
  public RoundedImageView icon;
  @InjectView(2131755545)
  @Optional
  public RelativeLayout root;
  @InjectView(2131755548)
  public TextView subtitle;
  @InjectView(2131755547)
  public TextView title;
  
  private EntityTileViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityTileViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */