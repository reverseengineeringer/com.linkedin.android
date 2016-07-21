package com.linkedin.android.entities;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

final class EntityHeadlessProfilePageFragment$1
  implements View.OnClickListener
{
  EntityHeadlessProfilePageFragment$1(EntityHeadlessProfilePageFragment paramEntityHeadlessProfilePageFragment) {}
  
  public final void onClick(View paramView)
  {
    if (this$0.isResumed()) {
      this$0.getActivity().onBackPressed();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityHeadlessProfilePageFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */