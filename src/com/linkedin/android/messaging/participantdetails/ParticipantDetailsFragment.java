package com.linkedin.android.messaging.participantdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.linkedin.messengerlib.ui.participantdetails.SingleParticipantDetailsFragment;
import com.linkedin.messengerlib.utils.BackPressListener;
import javax.inject.Inject;

public class ParticipantDetailsFragment
  extends BaseMessengerFragment
  implements MessengerTrackableInterface, BackPressListener
{
  private static final String TAG = ParticipantDetailsFragment.class.getCanonicalName();
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  MediaCenter mediaCenter;
  @Inject
  MemberUtil memberUtil;
  private MessagingLibProvider messagingLibProvider;
  @Inject
  NetworkClient networkClient;
  private String pageKey;
  
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
    return true;
  }
  
  public final boolean onBackPressed()
  {
    Fragment localFragment = getChildFragmentManager().findFragmentByTag("ParticipantDetailsFragmentChildFragmentTag");
    return ((localFragment instanceof BackPressListener)) && (((BackPressListener)localFragment).onBackPressed());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, null, null, memberUtil, null, new MessagingRequestTracking(getPageInstance(), pageKey()), null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969020, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    messagingLibProvider.detach();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getArguments();
    if (ParticipantDetailsBundleBuilder.isGroupConversation(paramBundle)) {
      paramView = new com.linkedin.messengerlib.ui.participantdetails.ParticipantDetailsFragment();
    }
    for (pageKey = "messaging_group_topcard";; pageKey = "messaging_topcard")
    {
      paramView.setArguments(paramBundle);
      getChildFragmentManager().beginTransaction().replace(2131756821, paramView, "ParticipantDetailsFragmentChildFragmentTag").commit();
      return;
      paramView = new SingleParticipantDetailsFragment();
    }
  }
  
  public final String pageKey()
  {
    if (pageKey == null) {
      if (!ParticipantDetailsBundleBuilder.isGroupConversation(getActivity().getIntent().getExtras())) {
        break label34;
      }
    }
    label34:
    for (pageKey = "messaging_group_topcard";; pageKey = "messaging_topcard") {
      return pageKey;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.participantdetails.ParticipantDetailsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */