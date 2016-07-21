package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class EmployeeQuoteItemViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968683;
    }
  };
  @InjectView(2131755487)
  public TextView body;
  public EntityItemViewHolder entityItemViewHolder;
  
  private EmployeeQuoteItemViewHolder(View paramView)
  {
    super(paramView);
    entityItemViewHolder = ((EntityItemViewHolder)EntityItemViewHolder.CREATOR.createViewHolder(paramView));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EmployeeQuoteItemViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */