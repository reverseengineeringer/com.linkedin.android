package com.linkedin.android.messaging.compose;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.BaseMessengerActivity;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.attachment.PendingAttachment;
import com.linkedin.messengerlib.ui.compose.ComposeFragment.ComposeProgressListener;
import com.linkedin.messengerlib.ui.compose.ComposeFragment.TitleChangeListener;
import com.linkedin.messengerlib.ui.compose.MessageCreateFragment;
import com.linkedin.messengerlib.ui.compose.ToolbarProgressBar;
import com.linkedin.messengerlib.ui.dialogs.EventLongPressDialogFragment.EventLongPressDialogHost;
import com.linkedin.messengerlib.ui.dialogs.SendImageApprovalDialogFragment.SendImageApprovalDialogHost;
import com.linkedin.messengerlib.ui.messagelist.MessageListFragment;

public class ComposeActivity
  extends BaseMessengerActivity
  implements EventLongPressDialogFragment.EventLongPressDialogHost, SendImageApprovalDialogFragment.SendImageApprovalDialogHost
{
  private ComposeFragment fragment;
  @InjectView(2131755468)
  Toolbar toolbar;
  private ToolbarProgressBar toolbarProgressBar;
  
  private String getInitialToolbarTitle()
  {
    return getResources().getString(2131232821);
  }
  
  public final Fragment buildNewChildFragment()
  {
    return new ComposeFragment();
  }
  
  public final String getChildFragmentTag()
  {
    return "composeFragment";
  }
  
  public final int getContentViewResId()
  {
    return 2130969009;
  }
  
  public final int getFragmentContainerResId()
  {
    return 2131756802;
  }
  
  public final MessengerLibApi getMessengerLibApi()
  {
    if (fragment != null) {
      return fragment.messagingLibProvider;
    }
    return null;
  }
  
  public final Tracker getTracker()
  {
    if (fragment != null) {
      return fragment.tracker;
    }
    return null;
  }
  
  public void onBackPressed()
  {
    if ((fragment != null) && (fragment.onBackPressed())) {
      return;
    }
    super.onBackPressed();
  }
  
  public final void onCancelSendImageAction()
  {
    if (fragment != null)
    {
      ComposeFragment localComposeFragment = fragment;
      if (composeFragment != null) {
        composeFragment.pendingAttachment.clear();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setSupportActionBar(toolbar);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.setTitle(getInitialToolbarTitle());
    }
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        onNavigationClick();
      }
    });
  }
  
  public final void onEventLongPressCopyAction()
  {
    if (fragment != null)
    {
      Object localObject = fragment;
      if (composeFragment != null)
      {
        localObject = composeFragment;
        if (messageListFragment != null) {
          messageListFragment.onEventLongPressCopyAction();
        }
      }
    }
  }
  
  public final void onSendImageAction(ManagedBitmap paramManagedBitmap)
  {
    if (fragment != null)
    {
      ComposeFragment localComposeFragment = fragment;
      if (composeFragment != null) {
        composeFragment.onSendImageAction(paramManagedBitmap);
      }
    }
  }
  
  public final void performInjections()
  {
    activityComponent.inject(this);
    ButterKnife.inject(this);
  }
  
  public final Fragment setupChildFragment()
  {
    fragment = ((ComposeFragment)super.setupChildFragment());
    fragment.titleChangeListener = new ComposeFragment.TitleChangeListener()
    {
      public final void onTitleChange(String paramAnonymousString)
      {
        ActionBar localActionBar = getSupportActionBar();
        if (localActionBar != null) {
          localActionBar.setTitle(paramAnonymousString);
        }
      }
      
      public final void onTitleChangeDefault()
      {
        ActionBar localActionBar = getSupportActionBar();
        if (localActionBar != null) {
          localActionBar.setTitle(ComposeActivity.this.getInitialToolbarTitle());
        }
      }
    };
    fragment.composeProgressListener = new ComposeFragment.ComposeProgressListener()
    {
      public final void onComposeFinished()
      {
        if (toolbarProgressBar != null) {
          toolbarProgressBar.setVisibility(8);
        }
      }
      
      public final void onComposeProgress(int paramAnonymousInt)
      {
        Object localObject;
        ViewGroup.LayoutParams localLayoutParams;
        if (toolbarProgressBar == null)
        {
          localObject = ComposeActivity.access$200(ComposeActivity.this);
          if (localObject != null)
          {
            ComposeActivity.access$102(ComposeActivity.this, (ToolbarProgressBar)LayoutInflater.from(ComposeActivity.this).inflate(2130969107, (ViewGroup)localObject, false));
            localLayoutParams = toolbarProgressBar.getLayoutParams();
            height = toolbar.getHeight();
            toolbarProgressBar.setLayoutParams(localLayoutParams);
            ((ViewGroup)localObject).addView(toolbarProgressBar);
          }
        }
        if (toolbarProgressBar != null)
        {
          toolbarProgressBar.setVisibility(0);
          localObject = toolbarProgressBar;
          int i = toolbar.getWidth();
          localLayoutParams = progressBar.getLayoutParams();
          float f = paramAnonymousInt / 100.0F;
          width = ((int)(i * f));
          progressBar.setLayoutParams(localLayoutParams);
        }
      }
    };
    return fragment;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.compose.ComposeActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */