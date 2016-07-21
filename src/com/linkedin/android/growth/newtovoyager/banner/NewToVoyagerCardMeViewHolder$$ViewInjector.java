package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class NewToVoyagerCardMeViewHolder$$ViewInjector<T extends NewToVoyagerCardMeViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    headingTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756034, "field 'headingTextView'"), 2131756034, "field 'headingTextView'"));
    subheadingTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756035, "field 'subheadingTextView'"), 2131756035, "field 'subheadingTextView'"));
    deleteButton = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756032, "field 'deleteButton'"), 2131756032, "field 'deleteButton'"));
  }
  
  public void reset(T paramT)
  {
    headingTextView = null;
    subheadingTextView = null;
    deleteButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerCardMeViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */