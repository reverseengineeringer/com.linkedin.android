package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class MultiTileViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<MultiTileViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968667;
    }
  };
  @InjectView(2131755396)
  public TextView header;
  @InjectView(2131755540)
  public RelativeLayout tileLeft;
  @InjectView(2131755541)
  public RelativeLayout tileRight;
  @InjectView(2131755424)
  public LinearLayout tileRow;
  @InjectView(2131755425)
  public Button viewAllButton;
  
  public MultiTileViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.MultiTileViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */