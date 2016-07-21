package com.linkedin.android.growth.login.sso;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class SSOFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<SSOFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968878;
    }
  };
  @InjectView(2131756291)
  Button continueButton;
  @InjectView(2131756296)
  Button joinNow;
  @InjectView(2131756293)
  ImageView plusIcon;
  @InjectView(2131756292)
  ImageView profilePicture;
  @InjectView(2131756295)
  Button signIn;
  
  public SSOFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.sso.SSOFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */