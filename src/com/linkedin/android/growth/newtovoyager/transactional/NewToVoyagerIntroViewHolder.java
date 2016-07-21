package com.linkedin.android.growth.newtovoyager.transactional;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class NewToVoyagerIntroViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<NewToVoyagerIntroViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968826;
    }
  };
  @InjectView(2131756072)
  Button okayButton;
  @InjectView(2131756070)
  TextView titleView;
  
  public NewToVoyagerIntroViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */