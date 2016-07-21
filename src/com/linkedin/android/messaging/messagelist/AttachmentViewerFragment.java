package com.linkedin.android.messaging.messagelist;

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
import com.linkedin.messengerlib.downloads.MessengerFileTransferManager;
import com.linkedin.messengerlib.shared.MessengerTrackableInterface;
import java.util.Set;
import javax.inject.Inject;

public class AttachmentViewerFragment
  extends BaseMessengerFragment
  implements MessengerTrackableInterface
{
  private static final String TAG = AttachmentViewerFragment.class.getCanonicalName();
  @Inject
  FlagshipDataManager dataManager;
  private com.linkedin.messengerlib.ui.images.AttachmentViewerFragment fragment;
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
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, null, null, memberUtil, null, new MessagingRequestTracking(getPageInstance(), "messaging_photo_viewer"), null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969008, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    messagingLibProvider.detach();
    super.onDestroy();
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    super.onRequestPermissionsResult(paramSet1, paramSet2);
    if (fragment != null) {
      fragment.fileTransferManager.onRequestPermissionsResult$27a8552b(paramSet2);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragment = new com.linkedin.messengerlib.ui.images.AttachmentViewerFragment();
    fragment.setArguments(getArguments());
    getChildFragmentManager().beginTransaction().replace(2131756801, fragment).commit();
  }
  
  public final String pageKey()
  {
    return "messaging_photo_viewer";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.AttachmentViewerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */