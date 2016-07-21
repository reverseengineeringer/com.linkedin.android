package com.linkedin.android.entities.viewholders;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class PremiumRankCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968671;
    }
  };
  @InjectView(2131755441)
  public TextView applicantText;
  @InjectView(2131755438)
  public View cardLayout;
  @InjectView(2131755437)
  public CardView cardRoot;
  @InjectView(2131755443)
  public TextView description;
  @InjectView(2131755442)
  public TextView growthText;
  @InjectView(2131755444)
  public TextView link;
  @InjectView(2131755439)
  public TextView topText;
  @InjectView(2131755440)
  public TextView value;
  
  private PremiumRankCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.PremiumRankCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */