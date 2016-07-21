package com.linkedin.android.messaging.messagelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.home.HomeFragmentDataProvider;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mediaupload.MediaUploadFinishedEvent;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.mediaupload.UploadFailedEvent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.l2m.notification.NotificationCacheUtils;
import com.linkedin.android.l2m.notification.NotificationDisplayUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.integration.MessagingLibProvider;
import com.linkedin.android.messaging.integration.MessagingRequestTracking;
import com.linkedin.android.messaging.stickers.BaseMessengerFragment;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.downloads.MessengerFileTransferManager;
import com.linkedin.messengerlib.shared.MessengerTrackableInterface;
import com.linkedin.messengerlib.ui.compose.MessageCreateFragment;
import com.linkedin.messengerlib.ui.messagelist.LinearFacepileView;
import com.linkedin.messengerlib.ui.messagelist.SpinMailFragment;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

public final class MessageListFragment
  extends BaseMessengerFragment
  implements OnBackPressedListener, MessengerTrackableInterface
{
  @Inject
  FlagshipCacheManager cacheManager;
  private Urn conversationUrn;
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  Bus eventBus;
  @Inject
  MediaCenter mediaCenter;
  @Inject
  MediaUploader mediaUploader;
  @Inject
  MemberUtil memberUtil;
  com.linkedin.messengerlib.ui.messagelist.MessageListFragment messageListFragment;
  MessagingLibProvider messagingLibProvider;
  @Inject
  NetworkClient networkClient;
  OnMetaDataChangeListener onMetaDataChangeListener;
  @Inject
  PhotoUtils photoUtils;
  private SpinMailFragment spinMailFragment;
  
  public static MessageListFragment newInstance(MessageListBundleBuilder paramMessageListBundleBuilder)
  {
    MessageListFragment localMessageListFragment = new MessageListFragment();
    localMessageListFragment.setArguments(paramMessageListBundleBuilder.build());
    return localMessageListFragment;
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if (conversationUrn != null)
    {
      HomeFragmentDataProvider localHomeFragmentDataProvider = getActivityactivityComponent.homeFragmentDataProvider();
      HomeTabInfo localHomeTabInfo = HomeTabInfo.MESSAGING;
      String str = conversationUrn.toString();
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      localHomeFragmentDataProvider.clearSomeBadgeCount(localHomeTabInfo, new String[] { str }, localMap);
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    Bus.subscribe(this);
  }
  
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
  
  public final String loadMorePageKey()
  {
    return "messaging_conversation_detail";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = getChildFragmentManager();
    if ((localObject != null) && (((FragmentManager)localObject).getFragments() != null))
    {
      localObject = ((FragmentManager)localObject).getFragments().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        if (localFragment != null)
        {
          int i;
          switch (paramInt1)
          {
          default: 
            i = paramInt1;
          }
          for (;;)
          {
            localFragment.onActivityResult(i, paramInt2, paramIntent);
            break;
            i = 1001;
            continue;
            i = 1002;
          }
        }
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    if (messageListFragment != null) {
      return messageListFragment.onBackPressed();
    }
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, null, mediaUploader, memberUtil, photoUtils, new MessagingRequestTracking(getPageInstance(), "messaging_conversation_detail"), null);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969017, paramViewGroup, false);
  }
  
  public final void onDestroy()
  {
    messagingLibProvider.detach();
    super.onDestroy();
  }
  
  public final void onDestroyView()
  {
    if (messageListFragment != null) {
      messageListFragment.setOnMetaDataChangeListener(null);
    }
    super.onDestroyView();
  }
  
  @Subscribe
  public final void onEvent(MediaUploadFinishedEvent paramMediaUploadFinishedEvent)
  {
    if (messageListFragment != null) {
      try
      {
        String str1 = responseModel.getString("value");
        String str2 = responseModel.optString("status");
        if ((str2 != null) && (str2.equals("ERROR")))
        {
          messageListFragment.fileTransferManager.onUploadFailure(uploadId, filePath, new Exception("Upload error with value " + str1));
          return;
        }
        str2 = responseModel.getString("filename");
        messageListFragment.fileTransferManager.onUploadSuccess(uploadId, filePath, str1, str2);
        return;
      }
      catch (JSONException localJSONException)
      {
        messageListFragment.fileTransferManager.onUploadFailure(uploadId, filePath, localJSONException);
      }
    }
  }
  
  @Subscribe
  public final void onEvent(UploadFailedEvent paramUploadFailedEvent)
  {
    if (messageListFragment != null) {
      messageListFragment.fileTransferManager.onUploadFailure(uploadId, filePath, new Exception(error));
    }
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    super.onRequestPermissionsResult(paramSet1, paramSet2);
    if (messageListFragment != null) {
      messageListFragment.fileTransferManager.onRequestPermissionsResult$27a8552b(paramSet2);
    }
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    int i = 1;
    super.onViewCreated(paramView, paramBundle);
    paramView = getArguments();
    paramBundle = MessageListBundleBuilder.getConversationRemoteId(paramView);
    conversationUrn = Urn.createFromTuple("fs_conversation", new Object[] { paramBundle });
    if (paramBundle != null)
    {
      int j = paramBundle.hashCode();
      NotificationCacheUtils.deleteNotificationFromCache(cacheManager, j);
      applicationComponent.notificationDisplayUtils().cancel(j);
    }
    if ((paramView != null) && (paramView.getBoolean("IS_SPINMAIL")))
    {
      if (i == 0) {
        break label188;
      }
      spinMailFragment = new SpinMailFragment();
      spinMailFragment.setOnMetaDataChangeListener(new MessageListFragment.1(this));
      spinMailFragment.setArguments(paramView);
      paramView = (BaseActivity)getActivity();
      if ((paramView instanceof MessageListActivity))
      {
        paramView = facepileImage;
        if (paramView != null) {
          paramView.setOnClickListener(null);
        }
      }
      label153:
      paramBundle = getChildFragmentManager().beginTransaction();
      if (i == 0) {
        break label266;
      }
    }
    label188:
    label266:
    for (paramView = spinMailFragment;; paramView = messageListFragment)
    {
      paramBundle.replace(2131756815, paramView).commit();
      return;
      i = 0;
      break;
      messageListFragment = new com.linkedin.messengerlib.ui.messagelist.MessageListFragment();
      messageListFragment.setOnMetaDataChangeListener(new MessageListFragment.2(this));
      messageListFragment.networkRefreshListener = new MessageListFragment.3(this, paramBundle);
      messageListFragment.setArguments(paramView);
      paramView = new MessageListFragment.4(this);
      messageListFragment.onCameraClickListener = new MessageListFragment.5(this, paramView);
      break label153;
    }
  }
  
  public final String pageKey()
  {
    return "messaging_conversation_detail";
  }
  
  public final String refreshPageKey()
  {
    return "messaging_conversation_detail";
  }
  
  public static abstract interface OnMetaDataChangeListener
  {
    public abstract void participantChange(MessengerLibApi paramMessengerLibApi, List<MiniProfile> paramList);
    
    public abstract void participantChangeByName(String paramString);
    
    public abstract void participantChangeByProfiles(List<MiniProfile> paramList);
    
    public abstract void participantChangeCompany(MessengerLibApi paramMessengerLibApi, MiniCompany paramMiniCompany);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.MessageListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */