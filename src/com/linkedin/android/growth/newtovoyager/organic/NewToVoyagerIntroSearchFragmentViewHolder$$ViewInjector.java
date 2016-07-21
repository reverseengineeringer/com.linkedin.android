package com.linkedin.android.growth.newtovoyager.organic;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class NewToVoyagerIntroSearchFragmentViewHolder$$ViewInjector<T extends NewToVoyagerIntroSearchFragmentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    jobs = ((View)paramFinder.findRequiredView(paramObject, 2131756063, "field 'jobs'"));
    people = ((View)paramFinder.findRequiredView(paramObject, 2131756065, "field 'people'"));
    group = ((View)paramFinder.findRequiredView(paramObject, 2131756067, "field 'group'"));
    titleTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756062, "field 'titleTextView'"), 2131756062, "field 'titleTextView'"));
    jobsTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756064, "field 'jobsTextView'"), 2131756064, "field 'jobsTextView'"));
    peopleTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756066, "field 'peopleTextView'"), 2131756066, "field 'peopleTextView'"));
    groupsTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756068, "field 'groupsTextView'"), 2131756068, "field 'groupsTextView'"));
  }
  
  public void reset(T paramT)
  {
    jobs = null;
    people = null;
    group = null;
    titleTextView = null;
    jobsTextView = null;
    peopleTextView = null;
    groupsTextView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroSearchFragmentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */