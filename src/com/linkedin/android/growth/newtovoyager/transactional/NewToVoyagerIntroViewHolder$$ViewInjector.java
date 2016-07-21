package com.linkedin.android.growth.newtovoyager.transactional;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class NewToVoyagerIntroViewHolder$$ViewInjector<T extends NewToVoyagerIntroViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    titleView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756070, "field 'titleView'"), 2131756070, "field 'titleView'"));
    okayButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756072, "field 'okayButton'"), 2131756072, "field 'okayButton'"));
  }
  
  public void reset(T paramT)
  {
    titleView = null;
    okayButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */