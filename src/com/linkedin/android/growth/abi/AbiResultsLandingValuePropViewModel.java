package com.linkedin.android.growth.abi;

import android.text.TextUtils;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class AbiResultsLandingValuePropViewModel
  extends ViewModel<AbiResultsLandingValuePropHolder>
{
  public String headerText;
  public String subheaderText;
  
  public final ViewHolderCreator<AbiResultsLandingValuePropHolder> getCreator()
  {
    return AbiResultsLandingValuePropHolder.CREATOR;
  }
  
  public final void onBindViewHolder$5c3b4152(AbiResultsLandingValuePropHolder paramAbiResultsLandingValuePropHolder)
  {
    resultLandingValuePropHeader.setText(headerText);
    if (TextUtils.isEmpty(subheaderText))
    {
      resultLandingValuePropSubheader.setVisibility(8);
      return;
    }
    resultLandingValuePropSubheader.setVisibility(0);
    resultLandingValuePropSubheader.setText(subheaderText);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiResultsLandingValuePropViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */