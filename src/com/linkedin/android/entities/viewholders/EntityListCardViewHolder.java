package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class EntityListCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator BROWSE_MAP_CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968660;
    }
  };
  public static final ViewHolderCreator CARD_CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968664;
    }
  };
  @InjectView(2131755398)
  public LinearLayout container;
  @InjectView(2131755399)
  public ImageView divider;
  @InjectView(2131755396)
  public TextView header;
  @InjectView(2131755400)
  public Button viewAllButton;
  
  public EntityListCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityListCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */