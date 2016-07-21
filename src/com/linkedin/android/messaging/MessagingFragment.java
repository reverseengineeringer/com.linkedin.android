package com.linkedin.android.messaging;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.EfficientCoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController;
import com.linkedin.android.home.HomeFragmentDataProvider;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.integration.MessagingDrawableResourcesProvider;
import com.linkedin.android.messaging.integration.MessagingLibProvider;
import com.linkedin.android.messaging.integration.MessagingLixManagerProvider;
import com.linkedin.android.messaging.integration.MessagingRequestTracking;
import com.linkedin.android.messaging.integration.MessengerCrashReporterDelegate;
import com.linkedin.messengerlib.MessengerDrawableResources;
import com.linkedin.messengerlib.MessengerHostBridge;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.MessengerLixManager;
import com.linkedin.messengerlib.crashes.MessengerCrashReporter;
import com.linkedin.messengerlib.shared.MessengerFABSupport;
import com.linkedin.messengerlib.shared.MessengerTrackableInterface;
import com.linkedin.messengerlib.tracking.MessengerTrackingUtils;
import com.linkedin.messengerlib.ui.conversationlist.ConversationListFragment;
import javax.inject.Inject;

public final class MessagingFragment
  extends ViewPagerFragment
  implements MessengerHostBridge, MessengerFABSupport, MessengerTrackableInterface
{
  private ConversationListFragment conversationListFragment;
  @Inject
  FlagshipDataManager dataManager;
  private MessengerDrawableResources drawableResources = new MessagingDrawableResourcesProvider();
  @Inject
  EmailManagementController emailSender;
  private boolean isTabActive;
  private MessengerLixManager lixManager;
  @Inject
  MediaCenter mediaCenter;
  @Inject
  MemberUtil memberUtil;
  private MessagingLibProvider messagingLibProvider;
  @Inject
  NetworkClient networkClient;
  @Inject
  SnackbarUtil snackbarUtil;
  
  private void clearBadgeCount()
  {
    if ((messagingLibProvider != null) && ((BaseActivity)getActivity() != null)) {
      getActivityactivityComponent.homeFragmentDataProvider().clearAllBadgeCountByLastUpdateTimestamp(HomeTabInfo.MESSAGING, messagingLibProvider.lastConversationListUpdateTime, Tracker.createPageInstanceHeader(getPageInstance()));
    }
  }
  
  public final void doEnter()
  {
    super.doEnter();
    isTabActive = true;
    clearBadgeCount();
    MessengerTrackingUtils.sendPageViewEvent(tracker, "messaging_conversation_list", false);
  }
  
  public final void doLeave()
  {
    super.doLeave();
    isTabActive = false;
  }
  
  public final MessengerDrawableResources getDrawableResources()
  {
    return drawableResources;
  }
  
  public final MessengerLixManager getLixManager()
  {
    return lixManager;
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
  
  public final boolean isParentFragment()
  {
    return true;
  }
  
  public final String loadMorePageKey()
  {
    return "messaging_conversation_list";
  }
  
  public final void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    lixManager = new MessagingLixManagerProvider(applicationComponent);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    messagingLibProvider = new MessagingLibProvider(fragmentComponent, applicationComponent, dataManager, mediaCenter, networkClient, emailSender, null, memberUtil, null, new MessagingRequestTracking(getPageInstance(), "messaging", "messaging_conversation_list", "messaging_conversation_list"), snackbarUtil);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969013, paramViewGroup, false);
  }
  
  public final void onDestroy()
  {
    messagingLibProvider.detach();
    messagingLibProvider = null;
    super.onDestroy();
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    getCrashReportercrashReporterDelegate = new MessengerCrashReporterDelegate();
    conversationListFragment = ((ConversationListFragment)getChildFragmentManager().findFragmentByTag("ConversationListFragmentTag"));
    if (conversationListFragment == null) {
      conversationListFragment = new ConversationListFragment();
    }
    paramView = conversationListFragment;
    shouldConsumeAndForwardScrollEvents = true;
    if (coordinatorLayout != null) {
      coordinatorLayout.setShouldConsumeAndForwardScrollEvents(true);
    }
    conversationListFragment.networkRefreshListener = new MessagingFragment.1(this);
    conversationListFragment.snackbarDelegate = new MessagingFragment.2(this);
    getChildFragmentManager().beginTransaction().replace(2131756809, conversationListFragment, "ConversationListFragmentTag").commit();
    if (getView() != null) {
      getView().postDelayed(new MessagingFragment.3(this), 500L);
    }
  }
  
  public final String pageKey()
  {
    return "messaging";
  }
  
  public final String refreshPageKey()
  {
    return "messaging_conversation_list";
  }
  
  @SuppressLint({"NewApi"})
  public final void styleFAB(FloatingActionButton paramFloatingActionButton)
  {
    paramFloatingActionButton.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), 2131624367));
    Drawable localDrawable = DrawableHelper.setTint(ContextCompat.getDrawable(getActivity(), 2130837972), ContextCompat.getColor(getContext(), 2131624058));
    DrawableCompat.setTintMode(localDrawable, PorterDuff.Mode.SRC_IN);
    paramFloatingActionButton.setImageDrawable(localDrawable);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.MessagingFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */