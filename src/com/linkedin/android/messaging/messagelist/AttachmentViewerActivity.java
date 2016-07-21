package com.linkedin.android.messaging.messagelist;

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

public class AttachmentViewerActivity
  extends BaseMessengerActivity
{
  @InjectView(2131756800)
  Toolbar toolbar;
  
  public final Fragment buildNewChildFragment()
  {
    return new AttachmentViewerFragment();
  }
  
  public final String getChildFragmentTag()
  {
    return "attachmentViewerFragment";
  }
  
  public final int getContentViewResId()
  {
    return 2130969007;
  }
  
  public final int getFragmentContainerResId()
  {
    return 2131756799;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.AttachmentViewerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */