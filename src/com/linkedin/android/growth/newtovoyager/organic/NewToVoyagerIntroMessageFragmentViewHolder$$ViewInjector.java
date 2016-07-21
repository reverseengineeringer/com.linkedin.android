package com.linkedin.android.growth.newtovoyager.organic;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class NewToVoyagerIntroMessageFragmentViewHolder$$ViewInjector<T extends NewToVoyagerIntroMessageFragmentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    messageContainer = ((View)paramFinder.findRequiredView(paramObject, 2131756053, "field 'messageContainer'"));
    today = ((View)paramFinder.findRequiredView(paramObject, 2131756054, "field 'today'"));
    senderFirstMessage = ((View)paramFinder.findRequiredView(paramObject, 2131756055, "field 'senderFirstMessage'"));
    senderSecondMessage = ((View)paramFinder.findRequiredView(paramObject, 2131756056, "field 'senderSecondMessage'"));
    recipientIcon = ((View)paramFinder.findRequiredView(paramObject, 2131756057, "field 'recipientIcon'"));
    recipientFirstMessage = ((View)paramFinder.findRequiredView(paramObject, 2131756058, "field 'recipientFirstMessage'"));
    recipientSecondMessage = ((View)paramFinder.findRequiredView(paramObject, 2131756059, "field 'recipientSecondMessage'"));
  }
  
  public void reset(T paramT)
  {
    messageContainer = null;
    today = null;
    senderFirstMessage = null;
    senderSecondMessage = null;
    recipientIcon = null;
    recipientFirstMessage = null;
    recipientSecondMessage = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroMessageFragmentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */