package com.linkedin.android.messaging.stickers;

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
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.shared.MessengerTrackableInterface;
import javax.inject.Inject;

public class StickerStoreFragment
  extends BaseMessengerFragment
  implements MessengerTrackableInterface
{
  private static final String TAG = StickerStoreFragment.class.getCanonicalName();
  @Inject
  FlagshipDataManager dataManager;
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
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, null, null, memberUtil, null, new MessagingRequestTracking(getPageInstance(), "messaging_manage_stickers"), null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969022, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    messagingLibProvider.detach();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new com.linkedin.messengerlib.ui.stickers.StickerStoreFragment();
    getChildFragmentManager().beginTransaction().replace(2131756823, paramView).commit();
  }
  
  public final String pageKey()
  {
    return "messaging_manage_stickers";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.stickers.StickerStoreFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */