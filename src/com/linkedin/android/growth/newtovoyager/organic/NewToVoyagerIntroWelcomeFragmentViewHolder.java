package com.linkedin.android.growth.newtovoyager.organic;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class NewToVoyagerIntroWelcomeFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<NewToVoyagerIntroWelcomeFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968821;
    }
  };
  @InjectView(2131756043)
  View directionLayout;
  @InjectView(2131756042)
  View introSubtitle;
  @InjectView(2131756041)
  TextView introTitle;
  @InjectView(2131756044)
  View leftArrow;
  @InjectView(2131756040)
  Button skipButton;
  
  public NewToVoyagerIntroWelcomeFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroWelcomeFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */