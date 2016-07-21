package com.linkedin.android.messaging.conversationlist;

import android.support.v4.app.Fragment;
import butterknife.ButterKnife;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.messaging.BaseMessengerActivity;

public class ConversationSearchListActivity
  extends BaseMessengerActivity
{
  private ConversationSearchListFragment searchFragment;
  
  public final Fragment buildNewChildFragment()
  {
    searchFragment = new ConversationSearchListFragment();
    return searchFragment;
  }
  
  public final String getChildFragmentTag()
  {
    return "conversationSearchListFragment";
  }
  
  public final int getContentViewResId()
  {
    return 2130969011;
  }
  
  public final int getFragmentContainerResId()
  {
    return 2131756804;
  }
  
  public final void performInjections()
  {
    activityComponent.inject(this);
    ButterKnife.inject(this);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.conversationlist.ConversationSearchListActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */