package com.linkedin.android.messaging.reconnect;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.messaging.BaseMessengerActivity;

public class ReconnectActivity
  extends BaseMessengerActivity
{
  public final Fragment buildNewChildFragment()
  {
    return new ReconnectFragment();
  }
  
  public final String getChildFragmentTag()
  {
    return "reconnectFragment";
  }
  
  public final int getContentViewResId()
  {
    return 2130968929;
  }
  
  public final int getFragmentContainerResId()
  {
    return 2131756509;
  }
  
  public final void performInjections()
  {
    activityComponent.inject(this);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.reconnect.ReconnectActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */