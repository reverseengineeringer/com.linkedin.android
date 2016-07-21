package com.linkedin.android.messaging.compose;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.datamanager.DataManager;
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
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.shared.MessengerTrackableInterface;
import com.linkedin.messengerlib.ui.compose.ComposeFragment.TitleChangeListener;
import com.linkedin.xmsg.Name;
import com.linkedin.xmsg.XMessageFormat;
import java.io.ByteArrayInputStream;
import javax.inject.Inject;

public class InmailComposeFragment
  extends BaseMessengerFragment
  implements MessengerTrackableInterface
{
  private static final String TAG = InmailComposeFragment.class.getCanonicalName();
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  MediaCenter mediaCenter;
  @Inject
  MemberUtil memberUtil;
  private MessagingLibProvider messagingLibProvider;
  @Inject
  NetworkClient networkClient;
  ComposeFragment.TitleChangeListener titleChangeListener;
  
  private static MiniProfile getMiniProfileFromJson(String paramString)
  {
    DataTemplateParser localDataTemplateParser = DataManager.PARSER_FACTORY.createParser();
    try
    {
      paramString = (MiniProfile)localDataTemplateParser.parseRecord(new ByteArrayInputStream(paramString.getBytes()), MiniProfile.BUILDER);
      return paramString;
    }
    catch (DataReaderException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, null, null, memberUtil, null, new MessagingRequestTracking(getPageInstance(), "messaging_compose_inmail"), null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969015, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    messagingLibProvider.detach();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new com.linkedin.messengerlib.ui.compose.InmailComposeFragment();
    paramBundle = getArguments();
    paramView.setArguments(paramBundle);
    getChildFragmentManager().beginTransaction().replace(2131756811, paramView).commit();
    paramView = paramBundle.getString("RECIPIENT_PROFILE");
    if (paramView != null)
    {
      paramView = getMiniProfileFromJson(paramView);
      if ((titleChangeListener != null) && (paramView != null)) {
        titleChangeListener.onTitleChange(XMessageFormat.format(getLocalizedString(2131232819), new Object[] { Name.builder().setFirstName(firstName).setLastName(lastName) }));
      }
    }
  }
  
  public final String pageKey()
  {
    return "messaging_compose_inmail";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.compose.InmailComposeFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */