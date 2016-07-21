package com.linkedin.android.messaging.participantdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.integration.MessagingLibProvider;
import com.linkedin.android.messaging.integration.MessagingRequestTracking;
import com.linkedin.android.messaging.stickers.BaseMessengerFragment;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.shared.MessengerTrackableInterface;
import com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment.AddParticipantCallbacks;
import javax.inject.Inject;

public class AddParticipantFragment
  extends BaseMessengerFragment
  implements MessengerTrackableInterface
{
  private static final String TAG = AddParticipantFragment.class.getCanonicalName();
  AddParticipantFragment.AddParticipantCallbacks addParticipantCallbacks;
  @Inject
  FlagshipDataManager dataManager;
  com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment fragment;
  @Inject
  MediaCenter mediaCenter;
  @Inject
  MemberUtil memberUtil;
  private MessagingLibProvider messagingLibProvider;
  @Inject
  NetworkClient networkClient;
  
  public final MessengerLibApi getMessengerLibApi()
  {
    return messagingLibProvider;
  }
  
  public final Tracker getParentFragmentTracker()
  {
    return tracker;
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, null, null, memberUtil, null, new MessagingRequestTracking(getPageInstance(), "messaging_add_people"), null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969006, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    messagingLibProvider.detach();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getActivity().getIntent().getExtras();
    fragment = new com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment();
    fragment.callbacks = addParticipantCallbacks;
    fragment.setArguments(paramView);
    getChildFragmentManager().beginTransaction().replace(2131756798, fragment).commit();
  }
  
  public final String pageKey()
  {
    return "messaging_add_people";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.participantdetails.AddParticipantFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */