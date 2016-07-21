package com.linkedin.android.growth.boost.error;

import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class BoostErrorFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<BoostErrorFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968803;
    }
  };
  @InjectView(2131755982)
  Button continueButton;
  
  public BoostErrorFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.error.BoostErrorFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */