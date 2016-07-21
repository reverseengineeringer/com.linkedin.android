package com.linkedin.android.messaging.conversationlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.integration.MessagingLibProvider;
import com.linkedin.android.messaging.integration.MessagingRequestTracking;
import com.linkedin.android.messaging.stickers.BaseMessengerFragment;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.messengerlib.MessengerDrawableResources;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.MessengerLixManager;
import com.linkedin.messengerlib.shared.MessengerTrackableInterface;
import com.linkedin.messengerlib.utils.FilterConstants;
import java.util.Timer;
import javax.inject.Inject;

public final class ConversationSearchListFragment
  extends BaseMessengerFragment
  implements MessengerTrackableInterface
{
  private ImageButton clearButton;
  @Inject
  FlagshipDataManager dataManager;
  private int filter = 6;
  private ViewGroup filterInfoContainer;
  private TextView filterInfoLabel;
  private TextView filterInfoValue;
  private ImageView filterRemoveBtn;
  private com.linkedin.messengerlib.ui.conversationlist.ConversationSearchListFragment libraryFragment;
  @Inject
  MediaCenter mediaCenter;
  @Inject
  MediaUploader mediaUploader;
  @Inject
  MemberUtil memberUtil;
  private MessagingLibProvider messagingLibProvider;
  @Inject
  NetworkClient networkClient;
  @Inject
  PhotoUtils photoUtils;
  private String searchKeyword = "";
  private Timer timer;
  private Toolbar toolbar;
  
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
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    timer = new Timer();
    fragmentComponent.inject(this);
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, null, mediaUploader, memberUtil, photoUtils, new MessagingRequestTracking(getPageInstance(), "messaging_search"), null);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130969012, paramViewGroup, false);
    toolbar = ((Toolbar)paramLayoutInflater.findViewById(2131756805));
    libraryFragment = new com.linkedin.messengerlib.ui.conversationlist.ConversationSearchListFragment();
    if (lixManager.isFilterEnabled())
    {
      paramViewGroup = getActivity().getIntent().getExtras();
      if ((paramViewGroup == null) || (!paramViewGroup.containsKey("filter"))) {
        break label250;
      }
    }
    label250:
    for (int i = paramViewGroup.getInt("filter");; i = 6)
    {
      filter = i;
      paramViewGroup = new Bundle();
      paramViewGroup.putInt("filterValue", filter);
      libraryFragment.setArguments(paramViewGroup);
      if (filter != 6)
      {
        filterInfoContainer = ((ViewGroup)paramLayoutInflater.findViewById(2131756838));
        filterInfoLabel = ((TextView)paramLayoutInflater.findViewById(2131756839));
        filterInfoValue = ((TextView)paramLayoutInflater.findViewById(2131756840));
        filterRemoveBtn = ((ImageView)paramLayoutInflater.findViewById(2131756841));
        filterInfoContainer.setVisibility(0);
        MessengerDrawableResources.setImageResource(drawableResources, filterRemoveBtn, 7);
        filterInfoLabel.setText(getLocalizedString(2131232898));
        filterInfoValue.setText(getLocalizedString(FilterConstants.getFilterStringResId(filter)));
        filterRemoveBtn.setOnClickListener(new ConversationSearchListFragment.1(this, tracker, "dismiss_filter", new TrackingEventBuilder[0]));
      }
      return paramLayoutInflater;
    }
  }
  
  public final void onDestroy()
  {
    timer.cancel();
    timer = null;
    super.onDestroy();
  }
  
  public final void onDestroyView()
  {
    messagingLibProvider.detach();
    super.onDestroyView();
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = toolbar;
    paramView.setNavigationIcon(2130838633);
    paramView.setNavigationOnClickListener(new ConversationSearchListFragment.2(this, tracker, "search_back", new TrackingEventBuilder[0]));
    paramBundle = (EditText)paramView.findViewById(2131756806);
    paramBundle.setOnEditorActionListener(new ConversationSearchListFragment.3(this, paramBundle));
    paramBundle.addTextChangedListener(new ConversationSearchListFragment.4(this));
    clearButton = ((ImageButton)paramView.findViewById(2131756807));
    clearButton.setOnClickListener(new ConversationSearchListFragment.5(this, tracker, "search_cancel", new TrackingEventBuilder[0], paramBundle));
    clearButton.setVisibility(8);
    getChildFragmentManager().beginTransaction().replace(2131756808, libraryFragment).commit();
  }
  
  public final String pageKey()
  {
    return "messaging_search";
  }
  
  public final void performSearch(String paramString, int paramInt)
  {
    searchKeyword = paramString;
    if (libraryFragment != null) {
      libraryFragment.performSearch(paramString, paramInt);
    }
  }
  
  public final void showDefault()
  {
    if (libraryFragment != null) {
      libraryFragment.showDefault();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.conversationlist.ConversationSearchListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */