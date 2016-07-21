package com.linkedin.android.growth.login.prereg.messaging;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PreRegMessagingFragmentViewHolder$$ViewInjector<T extends PreRegMessagingFragmentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    dialogBox1 = ((View)paramFinder.findRequiredView(paramObject, 2131756195, "field 'dialogBox1'"));
    dialogBox2 = ((View)paramFinder.findRequiredView(paramObject, 2131756196, "field 'dialogBox2'"));
    dialogBox3 = ((View)paramFinder.findRequiredView(paramObject, 2131756197, "field 'dialogBox3'"));
    dialogBox4 = ((View)paramFinder.findRequiredView(paramObject, 2131756198, "field 'dialogBox4'"));
  }
  
  public void reset(T paramT)
  {
    dialogBox1 = null;
    dialogBox2 = null;
    dialogBox3 = null;
    dialogBox4 = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.messaging.PreRegMessagingFragmentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */