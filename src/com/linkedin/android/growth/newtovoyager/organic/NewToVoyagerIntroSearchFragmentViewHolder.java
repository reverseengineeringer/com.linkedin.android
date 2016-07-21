package com.linkedin.android.growth.newtovoyager.organic;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class NewToVoyagerIntroSearchFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<NewToVoyagerIntroSearchFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968825;
    }
  };
  @InjectView(2131756067)
  View group;
  @InjectView(2131756068)
  TextView groupsTextView;
  @InjectView(2131756063)
  View jobs;
  @InjectView(2131756064)
  TextView jobsTextView;
  @InjectView(2131756065)
  View people;
  @InjectView(2131756066)
  TextView peopleTextView;
  @InjectView(2131756062)
  TextView titleTextView;
  
  public NewToVoyagerIntroSearchFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroSearchFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */