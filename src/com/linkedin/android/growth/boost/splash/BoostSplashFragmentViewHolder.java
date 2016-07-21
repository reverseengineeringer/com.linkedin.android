package com.linkedin.android.growth.boost.splash;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class BoostSplashFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<BoostSplashFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968805;
    }
  };
  @InjectView(2131755988)
  TextView messageBody;
  @InjectView(2131755989)
  TextView messageFooter;
  @InjectView(2131755987)
  TextView messageHeading;
  
  public BoostSplashFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.splash.BoostSplashFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */