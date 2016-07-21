package com.linkedin.android.growth.login.prereg.messaging;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class PreRegMessagingFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<PreRegMessagingFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968860;
    }
  };
  @InjectView(2131756195)
  View dialogBox1;
  @InjectView(2131756196)
  View dialogBox2;
  @InjectView(2131756197)
  View dialogBox3;
  @InjectView(2131756198)
  View dialogBox4;
  
  public PreRegMessagingFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.messaging.PreRegMessagingFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */