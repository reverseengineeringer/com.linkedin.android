package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class NewToVoyagerFeedCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<NewToVoyagerFeedCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968820;
    }
  };
  @InjectView(2131756036)
  Button continueButton;
  @InjectView(2131756034)
  TextView headingTextView;
  @InjectView(2131756037)
  Button notNowButton;
  @InjectView(2131756033)
  ImageView promoImage;
  
  public NewToVoyagerFeedCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */