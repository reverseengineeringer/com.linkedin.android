package com.linkedin.android.growth.newtovoyager.organic;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class NewToVoyagerIntroMessageFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<NewToVoyagerIntroMessageFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968823;
    }
  };
  @InjectView(2131756053)
  View messageContainer;
  @InjectView(2131756058)
  View recipientFirstMessage;
  @InjectView(2131756057)
  View recipientIcon;
  @InjectView(2131756059)
  View recipientSecondMessage;
  @InjectView(2131756055)
  View senderFirstMessage;
  @InjectView(2131756056)
  View senderSecondMessage;
  @InjectView(2131756054)
  View today;
  
  public NewToVoyagerIntroMessageFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroMessageFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */