package com.linkedin.android.messaging.participantdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.messaging.BaseMessengerActivity;
import com.linkedin.messengerlib.utils.BackPressListener;

public class ParticipantDetailsActivity
  extends BaseMessengerActivity
{
  private boolean isGroupConversation;
  
  private boolean isBackPressProcessedByChildFragment()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag("participantDetailsFragment");
    return ((localFragment instanceof BackPressListener)) && (((BackPressListener)localFragment).onBackPressed());
  }
  
  public final Fragment buildNewChildFragment()
  {
    return new ParticipantDetailsFragment();
  }
  
  protected final Bundle getArguments()
  {
    Bundle localBundle = super.getArguments();
    if (localBundle != null) {
      localBundle.putAll(new ParticipantDetailsBundleBuilder(isGroupConversation).build());
    }
    return localBundle;
  }
  
  public final String getChildFragmentTag()
  {
    return "participantDetailsFragment";
  }
  
  public final int getContentViewResId()
  {
    return 2130969019;
  }
  
  public final int getFragmentContainerResId()
  {
    return 2131756820;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1) && (!isGroupConversation))
    {
      isGroupConversation = true;
      paramIntent = new ParticipantDetailsFragment();
      paramIntent.setArguments(getArguments());
      getSupportFragmentManager().beginTransaction().replace(2131756820, paramIntent, "participantDetailsFragment").commit();
    }
  }
  
  public void onBackPressed()
  {
    if (!isBackPressProcessedByChildFragment()) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {}
    for (isGroupConversation = paramBundle.getBoolean("is_group_conversation");; isGroupConversation = ParticipantDetailsBundleBuilder.isGroupConversation(getIntent().getExtras()))
    {
      setContentView(2130969019);
      performInjections();
      setupChildFragment();
      return;
    }
  }
  
  protected final void onNavigationClick()
  {
    if (!isBackPressProcessedByChildFragment()) {
      super.onNavigationClick();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle != null) {
      paramBundle.putBoolean("is_group_conversation", isGroupConversation);
    }
  }
  
  public final void performInjections()
  {
    activityComponent.inject(this);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.participantdetails.ParticipantDetailsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */