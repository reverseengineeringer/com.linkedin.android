package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class NewToVoyagerPropCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<NewToVoyagerPropCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968829;
    }
  };
  @InjectView(2131756031)
  NewToVoyagerPropCardView bannerView;
  @InjectView(2131756034)
  TextView headingTextView;
  @InjectView(2131756035)
  TextView subheadingTextView;
  @InjectView(2131756075)
  View swipeArrow;
  @InjectView(2131756074)
  View swipeInstructionView;
  
  public NewToVoyagerPropCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerPropCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */