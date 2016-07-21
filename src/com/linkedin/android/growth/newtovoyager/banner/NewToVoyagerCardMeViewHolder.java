package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class NewToVoyagerCardMeViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<NewToVoyagerCardMeViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968827;
    }
  };
  @InjectView(2131756032)
  ImageButton deleteButton;
  @InjectView(2131756034)
  TextView headingTextView;
  @InjectView(2131756035)
  TextView subheadingTextView;
  
  public NewToVoyagerCardMeViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerCardMeViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */