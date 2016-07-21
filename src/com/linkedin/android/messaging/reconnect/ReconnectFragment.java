package com.linkedin.android.messaging.reconnect;

import android.os.Bundle;
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
import com.linkedin.messengerlib.ui.reconnect.ReconnectFragmentBundleBuilder;
import javax.inject.Inject;

public final class ReconnectFragment
  extends BaseMessengerFragment
  implements MessengerTrackableInterface
{
  @Inject
  FlagshipDataManager dataManager;
  private com.linkedin.messengerlib.ui.reconnect.ReconnectFragment fragment;
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
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, null, null, memberUtil, null, new MessagingRequestTracking(getPageInstance(), "messaging_reconnect"), null);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968929, paramViewGroup, false);
  }
  
  public final void onDestroy()
  {
    messagingLibProvider.detach();
    super.onDestroy();
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragment = new com.linkedin.messengerlib.ui.reconnect.ReconnectFragment();
    paramView = new ReconnectFragmentBundleBuilder();
    bundle.putInt("RECONNECT_BRIEFING_TOOLBAR_LAYOUT", 2130969023);
    paramView = paramView.build();
    fragment.setArguments(paramView);
    getChildFragmentManager().beginTransaction().replace(2131756509, fragment).commit();
  }
  
  public final String pageKey()
  {
    return "messaging_reconnect";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.reconnect.ReconnectFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */