package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class BarItemViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968682;
    }
  };
  @InjectView(2131755485)
  public TextView caption;
  @InjectView(2131755483)
  public View emptyBar;
  @InjectView(2131755482)
  public View fullBar;
  @InjectView(2131755484)
  public TextView value;
  
  public BarItemViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.BarItemViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */