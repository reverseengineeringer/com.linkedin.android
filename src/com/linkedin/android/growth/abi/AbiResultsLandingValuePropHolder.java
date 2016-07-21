package com.linkedin.android.growth.abi;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class AbiResultsLandingValuePropHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<AbiResultsLandingValuePropHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968795;
    }
  };
  @InjectView(2131755955)
  LinearLayout resultLandingValuePropContainer;
  @InjectView(2131755956)
  TextView resultLandingValuePropHeader;
  @InjectView(2131755957)
  TextView resultLandingValuePropSubheader;
  
  public AbiResultsLandingValuePropHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiResultsLandingValuePropHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */