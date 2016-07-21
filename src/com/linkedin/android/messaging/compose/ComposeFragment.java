package com.linkedin.android.messaging.compose;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
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
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.integration.MessagingLibProvider;
import com.linkedin.android.messaging.integration.MessagingRequestTracking;
import com.linkedin.android.messaging.stickers.BaseMessengerFragment;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.downloads.MessengerFileTransferManager;
import com.linkedin.messengerlib.shared.MessengerTrackableInterface;
import com.linkedin.messengerlib.ui.compose.ComposeFragment.ComposeProgressListener;
import com.linkedin.messengerlib.ui.compose.ComposeFragment.TitleChangeListener;
import com.linkedin.messengerlib.ui.compose.MessageCreateFragment;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

public class ComposeFragment
  extends BaseMessengerFragment
  implements OnBackPressedListener, MessengerTrackableInterface
{
  private static final String TAG = ComposeFragment.class.getCanonicalName();
  com.linkedin.messengerlib.ui.compose.ComposeFragment composeFragment;
  ComposeFragment.ComposeProgressListener composeProgressListener;
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
  MessagingLibProvider messagingLibProvider;
  @Inject
  NetworkClient networkClient;
  @Inject
  PhotoUtils photoUtils;
  ComposeFragment.TitleChangeListener titleChangeListener;
  private TrackingData trackingData;
  private String updateUrn;
  
  public static int getPageTitle()
  {
    return 2131233677;
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
  
  public final int getTrackingMode()
  {
    Bundle localBundle2 = getArguments();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    if (localBundle1.getInt("usage", -1) == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return 1;
    }
    return 0;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    if (composeFragment != null) {
      return composeFragment.onBackPressed();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, null, mediaUploader, memberUtil, photoUtils, new MessagingRequestTracking(getPageInstance(), pageKey()), null);
    trackingData = ShareComposeBundle.getTrackingData(getArguments());
    updateUrn = ShareComposeBundle.getUpdateId(getArguments());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969010, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    messagingLibProvider.detach();
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(MediaUploadFinishedEvent paramMediaUploadFinishedEvent)
  {
    if (composeFragment != null) {
      try
      {
        String str1 = responseModel.getString("value");
        String str2 = responseModel.optString("status");
        if ((str2 != null) && (str2.equals("ERROR")))
        {
          composeFragment.fileTransferManager.onUploadFailure(uploadId, filePath, new Exception("Upload error with value " + str1));
          return;
        }
        str2 = responseModel.getString("filename");
        composeFragment.fileTransferManager.onUploadSuccess(uploadId, filePath, str1, str2);
        return;
      }
      catch (JSONException localJSONException)
      {
        composeFragment.fileTransferManager.onUploadFailure(uploadId, filePath, localJSONException);
      }
    }
  }
  
  @Subscribe
  public void onEvent(UploadFailedEvent paramUploadFailedEvent)
  {
    if (composeFragment != null) {
      composeFragment.fileTransferManager.onUploadFailure(uploadId, filePath, new Exception(error));
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    composeFragment = new com.linkedin.messengerlib.ui.compose.ComposeFragment();
    composeFragment.composeProgressListener = composeProgressListener;
    composeFragment.titleChangeListener = titleChangeListener;
    composeFragment.fetchProfilesListener = new ComposeFragment.1(this);
    paramBundle = getArguments();
    paramView = paramBundle;
    if (paramBundle == null) {
      paramView = new Bundle();
    }
    if (ShareComposeBundle.getUpdateId(paramView) != null) {
      paramView.putString("UPDATE_URN", ShareComposeBundle.getUpdateId(paramView));
    }
    composeFragment.setArguments(paramView);
    paramView = new ComposeFragment.2(this);
    composeFragment.onCameraClickListener = new ComposeFragment.3(this, paramView);
    composeFragment.sendMessageListener = new ComposeFragment.4(this);
    getChildFragmentManager().beginTransaction().replace(2131756803, composeFragment).commit();
  }
  
  public final String pageKey()
  {
    Bundle localBundle2 = getArguments();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    if (localBundle1.getInt("usage", -1) == 0) {
      return "feed_reshare_messaging";
    }
    return "messaging_compose";
  }
  
  public final boolean shouldTrack()
  {
    Bundle localBundle2 = getArguments();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    if (localBundle1.getInt("usage", -1) == 0) {
      return getUserVisibleHint();
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.compose.ComposeFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */