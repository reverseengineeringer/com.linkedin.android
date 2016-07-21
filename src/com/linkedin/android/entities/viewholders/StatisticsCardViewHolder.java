package com.linkedin.android.entities.viewholders;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.entities.cards.StatisticsView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class StatisticsCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<StatisticsCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968672;
    }
  };
  @InjectView(2131755446)
  public StatisticsView statisticsView;
  
  public StatisticsCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.StatisticsCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */