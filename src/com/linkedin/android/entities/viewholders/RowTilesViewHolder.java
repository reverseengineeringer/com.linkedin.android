package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class RowTilesViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<RowTilesViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968697;
    }
  };
  @InjectView(2131755540)
  public RelativeLayout tileLeft;
  @InjectView(2131755541)
  public RelativeLayout tileRight;
  
  public RowTilesViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.RowTilesViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */