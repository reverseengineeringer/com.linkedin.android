package com.linkedin.android.growth.login.prereg.jobs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PreRegJobsFragmentViewHolder$$ViewInjector<T extends PreRegJobsFragmentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    topCardPhoto = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756213, "field 'topCardPhoto'"), 2131756213, "field 'topCardPhoto'"));
    topCardName = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756215, "field 'topCardName'"), 2131756215, "field 'topCardName'"));
    topCardHeadline = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756216, "field 'topCardHeadline'"), 2131756216, "field 'topCardHeadline'"));
    topCardLocation = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756217, "field 'topCardLocation'"), 2131756217, "field 'topCardLocation'"));
    cardContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756214, "field 'cardContainer'"), 2131756214, "field 'cardContainer'"));
    connectButtonContainer = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756218, "field 'connectButtonContainer'"), 2131756218, "field 'connectButtonContainer'"));
    connectBackground = ((View)paramFinder.findRequiredView(paramObject, 2131756219, "field 'connectBackground'"));
    connectIcon = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756221, "field 'connectIcon'"), 2131756221, "field 'connectIcon'"));
    connectButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756220, "field 'connectButton'"), 2131756220, "field 'connectButton'"));
  }
  
  public void reset(T paramT)
  {
    topCardPhoto = null;
    topCardName = null;
    topCardHeadline = null;
    topCardLocation = null;
    cardContainer = null;
    connectButtonContainer = null;
    connectBackground = null;
    connectIcon = null;
    connectButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.jobs.PreRegJobsFragmentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */