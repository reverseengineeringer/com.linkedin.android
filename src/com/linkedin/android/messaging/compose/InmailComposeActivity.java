package com.linkedin.android.messaging.compose;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.messaging.BaseMessengerActivity;
import com.linkedin.messengerlib.ui.compose.ComposeFragment.TitleChangeListener;

public class InmailComposeActivity
  extends BaseMessengerActivity
{
  @InjectView(2131755468)
  Toolbar toolbar;
  
  public final Fragment buildNewChildFragment()
  {
    return new InmailComposeFragment();
  }
  
  public final String getChildFragmentTag()
  {
    return "inmailComposeFragment";
  }
  
  public final int getContentViewResId()
  {
    return 2130969014;
  }
  
  public final int getFragmentContainerResId()
  {
    return 2131756810;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        onNavigationClick();
      }
    });
  }
  
  public final void performInjections()
  {
    activityComponent.inject(this);
    ButterKnife.inject(this);
  }
  
  public final Fragment setupChildFragment()
  {
    InmailComposeFragment localInmailComposeFragment = (InmailComposeFragment)super.setupChildFragment();
    titleChangeListener = new ComposeFragment.TitleChangeListener()
    {
      public final void onTitleChange(String paramAnonymousString)
      {
        toolbar.setTitle(paramAnonymousString);
      }
      
      public final void onTitleChangeDefault()
      {
        toolbar.setTitle("");
      }
    };
    return localInmailComposeFragment;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.compose.InmailComposeActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */