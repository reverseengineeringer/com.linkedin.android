package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.ui.LineChart;

public class TrendCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<TrendCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968674;
    }
  };
  @InjectView(2131755456)
  public View divider;
  @InjectView(2131755455)
  public TextView endDate;
  @InjectView(2131755457)
  public TextView footerText;
  @InjectView(2131755396)
  public TextView header;
  @InjectView(2131755449)
  public TextView insightText;
  @InjectView(2131755450)
  public LineChart lineChart;
  @InjectView(2131755454)
  public TextView startDate;
  @InjectView(2131755452)
  public TextView yAxisBottom;
  @InjectView(2131755451)
  public TextView yAxisTop;
  
  private TrendCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.TrendCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */