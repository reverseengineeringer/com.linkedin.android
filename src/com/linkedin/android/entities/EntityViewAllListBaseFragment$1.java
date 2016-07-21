package com.linkedin.android.entities;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.shared.NavigationUtils;

final class EntityViewAllListBaseFragment$1
  implements View.OnClickListener
{
  EntityViewAllListBaseFragment$1(EntityViewAllListBaseFragment paramEntityViewAllListBaseFragment) {}
  
  public final void onClick(View paramView)
  {
    NavigationUtils.onUpPressed(this$0.getActivity(), false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityViewAllListBaseFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */