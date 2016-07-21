package com.linkedin.android.growth.login.prereg.jobs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class PreRegJobsFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<PreRegJobsFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968859;
    }
  };
  @InjectView(2131756214)
  LinearLayout cardContainer;
  @InjectView(2131756219)
  View connectBackground;
  @InjectView(2131756220)
  Button connectButton;
  @InjectView(2131756218)
  ViewGroup connectButtonContainer;
  @InjectView(2131756221)
  ImageView connectIcon;
  @InjectView(2131756216)
  TextView topCardHeadline;
  @InjectView(2131756217)
  TextView topCardLocation;
  @InjectView(2131756215)
  TextView topCardName;
  @InjectView(2131756213)
  ImageView topCardPhoto;
  
  public PreRegJobsFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.jobs.PreRegJobsFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */