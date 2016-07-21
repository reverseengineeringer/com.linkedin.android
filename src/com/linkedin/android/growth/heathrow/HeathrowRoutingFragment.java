package com.linkedin.android.growth.heathrow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper.Builder;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.growth.abi.AbiIntent;
import com.linkedin.android.growth.abi.AbiIntentBundle;
import com.linkedin.android.growth.utils.GrowthLixHelper;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.growth.utils.RelevanceTrackingUtils;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.cardtoast.CardToast.Builder;
import com.linkedin.android.infra.ui.cardtoast.CardToastBuilders;
import com.linkedin.android.infra.ui.cardtoast.CardToastBuilders.2;
import com.linkedin.android.infra.ui.cardtoast.CrossActivityCardToastCallbacks;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.AbiRoute;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.FallbackRoute;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.FeedRoute;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.PymkRoute;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.SuggestedRoute;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.SuggestedRoute.Route;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.platformType;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.android.relationships.RelationshipsSecondaryActivity;
import com.linkedin.android.relationships.shared.RelationshipsRequestHelper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.gen.avro2pegasus.events.relevance.ErrorType;
import com.linkedin.gen.avro2pegasus.events.relevance.Route;
import com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent.Builder;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HeathrowRoutingFragment
  extends PageFragment
{
  private HeathrowFlowDataProvider dataProvider;
  @InjectView(2131756006)
  TextView heathrowRedirectTextView;
  private HeathrowSource heathrowSource;
  private String invitationIdToAccept;
  private String invitationSharedKeyToAccept;
  private MiniProfile miniProfile;
  private boolean navigationDone;
  private String profileIdString;
  private String suggestedRouteTrackingId;
  
  private void fireLegoTrackingEvent(String paramString)
  {
    if (paramString != null) {
      fragmentComponent.legoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7(paramString, Visibility.SHOW);
    }
  }
  
  private void navigateToAbi()
  {
    Object localObject = heathrowSource.getAbookImportImpressionEventSource();
    localObject = OwlTrackingUtils.trackAbookImportImpressionEvent(tracker, fragmentComponent.lixManager(), (String)localObject);
    AbiIntentBundle localAbiIntentBundle = new AbiIntentBundle().miniProfile(miniProfile);
    HeathrowSource localHeathrowSource = heathrowSource;
    bundle.putSerializable("HEATHROW_SOURCE", localHeathrowSource);
    localAbiIntentBundle.abiSource(localHeathrowSource.getAbookImportImpressionEventSource());
    localAbiIntentBundle = localAbiIntentBundle.abookImportTransactionId((String)localObject);
    if ((!"control".equalsIgnoreCase(applicationComponent.lixManager().getTreatment(Lix.LIX_HEATHROW_SUGGESTED_ROUTE_TRACKING))) && (!TextUtils.isEmpty(suggestedRouteTrackingId)))
    {
      localObject = suggestedRouteTrackingId;
      bundle.putString("suggestedRouteTrackingId", (String)localObject);
    }
    localObject = localAbiIntentBundle;
    if ("enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.HEATHROW_FORCE_ABI_SPLASH))) {
      localObject = localAbiIntentBundle.forceLaunchAbiSplash();
    }
    startActivity(fragmentComponent.intentRegistry().abi.newIntent(getActivity(), (BundleBuilder)localObject));
    getActivity().supportFinishAfterTransition();
  }
  
  private void navigateToDefaultRoute(ErrorType paramErrorType)
  {
    trackSuggestedRouteActionEvent(Route.PYMK, paramErrorType);
    navigateToPymk();
  }
  
  private void navigateToFeed()
  {
    Object localObject1 = null;
    Object localObject2 = new HomeBundle();
    activeTab = HomeTabInfo.FEED;
    activeTabBundleBuilder = new FeedBundleBuilder();
    localObject2 = applicationComponent.intentRegistry().home.newIntent(getContext(), (BundleBuilder)localObject2).addFlags(268468224);
    Object localObject3 = heathrowSource;
    MiniProfile localMiniProfile = miniProfile;
    String str = Util.retrieveRumSessionId(fragmentComponent);
    if (localMiniProfile == null) {}
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject3 = (FlagshipApplication)getContext().getApplicationContext();
        ((FlagshipApplication)localObject3).registerActivityLifecycleCallbacks(new CrossActivityCardToastCallbacks((FlagshipApplication)localObject3, (CardToast.Builder)localObject1));
      }
      startActivity((Intent)localObject2);
      return;
      if (((HeathrowSource)localObject3).getUserActionType() == com.linkedin.android.pegasus.gen.voyager.common.heathrow.UserActionType.CONNECT) {
        localObject1 = CardToastBuilders.heathrowLandingWithoutMessageButton((HeathrowSource)localObject3, localMiniProfile, "feed_invite_notification", str);
      } else if (localMiniProfile != null) {
        localObject1 = new CardToastBuilders.2((HeathrowSource)localObject3, localMiniProfile, "feed_invite_notification", str);
      }
    }
  }
  
  private void navigateToPymk()
  {
    int i = Integer.MIN_VALUE;
    if (heathrowSource.getUserActionType() == com.linkedin.android.pegasus.gen.voyager.common.heathrow.UserActionType.CONNECT)
    {
      i = 2;
      if ((miniProfile == null) || (i == Integer.MIN_VALUE)) {
        break label90;
      }
      RelationshipsSecondaryActivity.openConnectFlowPage(fragmentComponent, miniProfile.entityUrn.getId(), i);
    }
    for (;;)
    {
      getActivity().supportFinishAfterTransition();
      return;
      if ((heathrowSource.getUserActionType() != com.linkedin.android.pegasus.gen.voyager.common.heathrow.UserActionType.ACCEPT_INVITATION) && (heathrowSource.getUserActionType() != com.linkedin.android.pegasus.gen.voyager.common.heathrow.UserActionType.INVITATION_ACCEPTANCE_NOTIFICATION)) {
        break;
      }
      i = 1;
      break;
      label90:
      RelationshipsSecondaryActivity.openAddConnectionsPage(fragmentComponent, true);
    }
  }
  
  public static HeathrowRoutingFragment newInstance(HeathrowRoutingIntentBundle paramHeathrowRoutingIntentBundle)
  {
    HeathrowRoutingFragment localHeathrowRoutingFragment = new HeathrowRoutingFragment();
    localHeathrowRoutingFragment.setArguments(paramHeathrowRoutingIntentBundle.build());
    return localHeathrowRoutingFragment;
  }
  
  private void trackSuggestedRouteActionEvent(Route paramRoute, ErrorType paramErrorType)
  {
    if (!TextUtils.isEmpty(suggestedRouteTrackingId)) {
      RelevanceTrackingUtils.trackSuggestedRouteActionEvent(suggestedRouteTrackingId, tracker, fragmentComponent.lixManager(), paramRoute, paramErrorType);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      paramBundle = localBundle.getString("PROFILE_ID_STRING");
      profileIdString = paramBundle;
      miniProfile = HeathrowRoutingIntentBundle.getMiniProfile(localBundle);
      if (localBundle == null) {
        break label114;
      }
    }
    label55:
    label109:
    label114:
    for (paramBundle = (HeathrowSource)localBundle.getSerializable("HEATHROW_SOURCE");; paramBundle = null)
    {
      if (paramBundle != null)
      {
        heathrowSource = paramBundle;
        if (localBundle == null) {
          break label109;
        }
      }
      for (paramBundle = localBundle.getString("INVITATION_ID");; paramBundle = null)
      {
        invitationIdToAccept = paramBundle;
        paramBundle = (Bundle)localObject;
        if (localBundle != null) {
          paramBundle = localBundle.getString("INVITATION_SHARED_KEY");
        }
        invitationSharedKeyToAccept = paramBundle;
        return;
        paramBundle = null;
        break;
        paramBundle = HeathrowSource.UNKNOWN;
        break label55;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968814, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (!isAdded()) {
      return;
    }
    navigateToDefaultRoute(ErrorType.INTERNAL_ERROR);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (!isAdded()) {}
    label79:
    label132:
    label143:
    label184:
    do
    {
      return;
      if (!paramType.equals(DataStore.Type.NETWORK)) {
        break;
      }
      paramType = (HeathrowFlowDataProvider.State)dataProvider.state;
      paramType = (CollectionTemplate)paramType.getModel(heathrowRoute);
      if (CollectionUtils.isEmpty(paramType))
      {
        paramSet = null;
        paramType = (HeathrowFlowDataProvider.State)dataProvider.state;
        paramType = (ActionResponse)paramType.getModel(acceptInviteRoute);
        if (paramType != null) {
          break label132;
        }
        paramType = null;
        if (paramType == null) {
          break label143;
        }
        paramType = fromMember;
      }
      for (;;)
      {
        miniProfile = paramType;
        if (miniProfile != null) {
          break label184;
        }
        navigateToDefaultRoute(ErrorType.INTERNAL_ERROR);
        getActivity().finish();
        return;
        paramSet = (SuggestedRoute)elements.get(0);
        break;
        paramType = (Invitation)value;
        break label79;
        if (miniProfile == null)
        {
          paramType = (HeathrowFlowDataProvider.State)dataProvider.state;
          paramType = (MiniProfile)paramType.getModel(miniProfileRoute);
        }
        else
        {
          paramType = miniProfile;
        }
      }
    } while (navigationDone);
    navigationDone = true;
    if (paramSet == null) {
      navigateToDefaultRoute(ErrorType.INTERNAL_ERROR);
    }
    for (;;)
    {
      getActivity().finish();
      return;
      if (route.abiRouteValue != null)
      {
        fireLegoTrackingEvent(route.abiRouteValue.legoTrackingToken);
        navigateToAbi();
      }
      else if (route.feedRouteValue != null)
      {
        fireLegoTrackingEvent(route.feedRouteValue.legoTrackingToken);
        trackSuggestedRouteActionEvent(Route.FEED, null);
        navigateToFeed();
      }
      else if (route.pymkRouteValue != null)
      {
        fireLegoTrackingEvent(route.pymkRouteValue.legoTrackingToken);
        trackSuggestedRouteActionEvent(Route.PYMK, null);
        navigateToPymk();
      }
      else if (route.fallbackRouteValue != null)
      {
        paramType = route.fallbackRouteValue.fallbackRoute;
        switch (paramType)
        {
        default: 
          getContext();
          Util.safeThrow$7a8b4789(new RuntimeException("Unhandled Heathrow route, using default"));
          navigateToDefaultRoute(ErrorType.INTERNAL_ERROR);
          break;
        case ???: 
          navigateToAbi();
          break;
        case ???: 
          trackSuggestedRouteActionEvent(Route.FEED, null);
          navigateToFeed();
          break;
        case ???: 
          trackSuggestedRouteActionEvent(Route.PYMK, null);
          navigateToPymk();
          break;
        }
      }
      else
      {
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Unhandled Heathrow route, using default"));
        navigateToDefaultRoute(ErrorType.INTERNAL_ERROR);
      }
    }
    getActivity().supportFinishAfterTransition();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    String str = null;
    super.onViewCreated(paramView, paramBundle);
    paramView = heathrowRedirectTextView;
    paramBundle = heathrowSource;
    switch (2.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$common$heathrow$UserActionType[paramBundle.getUserActionType().ordinal()])
    {
    default: 
      paramView.setText(2131231421);
      dataProvider = getActivityactivityComponent.heathrowFlowDataProvider();
      if (!"control".equalsIgnoreCase(applicationComponent.lixManager().getTreatment(Lix.LIX_HEATHROW_SUGGESTED_ROUTE_TRACKING)))
      {
        localObject2 = (HeathrowFlowDataProvider.State)dataProvider.state;
        localObject3 = fragmentComponent.tracker();
        localObject4 = fragmentComponent.lixManager();
        paramView = heathrowSource.getOrigin();
      }
      switch (com.linkedin.android.growth.utils.RelevanceTrackingUtils.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$common$heathrow$Origin[paramView.ordinal()])
      {
      default: 
        paramView = com.linkedin.gen.avro2pegasus.events.relevance.Origin.OTHER;
        label208:
        paramBundle = heathrowSource.getUserActionType();
        switch (com.linkedin.android.growth.utils.RelevanceTrackingUtils.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$common$heathrow$UserActionType[paramBundle.ordinal()])
        {
        default: 
          paramBundle = com.linkedin.gen.avro2pegasus.events.relevance.UserActionType.OTHER;
          label260:
          localObject1 = "";
          if (!"control".equalsIgnoreCase(((LixManager)localObject4).getTreatment(Lix.LIX_HEATHROW_SUGGESTED_ROUTE_TRACKING)))
          {
            localObject1 = TrackingUtils.generateBase64EncodedTrackingId();
            localObject4 = new SuggestedRouteRequestEvent.Builder();
            if (localObject1 == null)
            {
              hasTrackingId = false;
              trackingId = null;
              label314:
              if (paramView != null) {
                break label694;
              }
              hasOrigin = false;
              origin = null;
              label330:
              if (paramBundle != null) {
                break label709;
              }
              hasUserActionType = false;
              userActionType = null;
              label346:
              ((Tracker)localObject3).send((TrackingEventBuilder)localObject4);
            }
          }
          else
          {
            suggestedRouteTrackingId = ((String)localObject1);
            suggestedRouteTrackingId = dataProvider.state).suggestedRouteTrackingId;
            if ((TextUtils.isEmpty(invitationIdToAccept)) || (TextUtils.isEmpty(invitationSharedKeyToAccept))) {
              break label731;
            }
            paramBundle = dataProvider;
            localObject1 = busSubscriberId;
            str = getRumSessionId();
            localObject2 = Tracker.createPageInstanceHeader(getPageInstance());
            localObject3 = invitationIdToAccept;
            localObject4 = invitationSharedKeyToAccept;
            if (heathrowSource == null) {
              break label724;
            }
          }
          break;
        }
        break;
      }
      break;
    }
    label694:
    label709:
    label724:
    for (paramView = heathrowSource;; paramView = HeathrowSource.UNKNOWN)
    {
      localObject3 = RelationshipsRequestHelper.makeAcceptInviteRequest((String)localObject3, (String)localObject4);
      state).acceptInviteRoute = url;
      state).heathrowRoute = paramBundle.buildHeathrowRoute(paramView.getOrigin(), paramView.getUserActionType(), platformType.MOBILE);
      paramView = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      paramBundle.performMultiplexedFetch((String)localObject1, str, (Map)localObject2, paramView.filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.get().url(state).heathrowRoute).builder(CollectionTemplate.of(SuggestedRoute.BUILDER))).required((DataRequestWrapper.Builder)localObject3));
      return;
      paramView.setText(2131231420);
      break;
      paramView.setText(2131231419);
      break;
      paramView.setText(2131231422);
      break;
      paramView = com.linkedin.gen.avro2pegasus.events.relevance.Origin.$UNKNOWN;
      break label208;
      paramView = com.linkedin.gen.avro2pegasus.events.relevance.Origin.EMAIL;
      break label208;
      paramView = com.linkedin.gen.avro2pegasus.events.relevance.Origin.PUSH;
      break label208;
      paramView = com.linkedin.gen.avro2pegasus.events.relevance.Origin.IN_APP_NOTIFICATION;
      break label208;
      paramView = com.linkedin.gen.avro2pegasus.events.relevance.Origin.DESKTOP_NOTIFICATION;
      break label208;
      paramView = com.linkedin.gen.avro2pegasus.events.relevance.Origin.PROFILE;
      break label208;
      paramView = com.linkedin.gen.avro2pegasus.events.relevance.Origin.PYMK;
      break label208;
      paramView = com.linkedin.gen.avro2pegasus.events.relevance.Origin.PEOPLE;
      break label208;
      paramBundle = com.linkedin.gen.avro2pegasus.events.relevance.UserActionType.$UNKNOWN;
      break label260;
      paramBundle = com.linkedin.gen.avro2pegasus.events.relevance.UserActionType.ACCEPT_INVITATION;
      break label260;
      paramBundle = com.linkedin.gen.avro2pegasus.events.relevance.UserActionType.INVITATION_ACCEPTANCE_NOTIFICATION;
      break label260;
      paramBundle = com.linkedin.gen.avro2pegasus.events.relevance.UserActionType.CONNECT;
      break label260;
      hasTrackingId = true;
      trackingId = ((String)localObject1);
      break label314;
      hasOrigin = true;
      origin = paramView;
      break label330;
      hasUserActionType = true;
      userActionType = paramBundle;
      break label346;
    }
    label731:
    int i = GrowthLixHelper.parseInt(fragmentComponent.lixManager(), Lix.LIX_HEATHROW_TIMEOUT, 2000, "value_");
    Object localObject1 = dataProvider;
    Object localObject2 = busSubscriberId;
    Object localObject3 = getRumSessionId();
    Object localObject4 = Tracker.createPageInstanceHeader(getPageInstance());
    paramBundle = heathrowSource.getUserActionType();
    Object localObject5 = heathrowSource.getOrigin();
    if (miniProfile == null) {}
    for (paramView = profileIdString;; paramView = null)
    {
      state).heathrowRoute = ((HeathrowFlowDataProvider)localObject1).buildHeathrowRoute((com.linkedin.android.pegasus.gen.voyager.common.heathrow.Origin)localObject5, paramBundle, platformType.MOBILE);
      paramBundle = ((HeathrowFlowDataProvider)localObject1).newModelListener((String)localObject2, (String)localObject3);
      localObject5 = Request.get().url(state).heathrowRoute).filter(DataManager.DataStoreFilter.NETWORK_ONLY).builder(CollectionTemplate.of(SuggestedRoute.BUILDER)).listener(paramBundle);
      paramBundle = str;
      if (paramView != null)
      {
        state).miniProfileRoute = Routes.MINIPROFILE.buildUponRoot().buildUpon().appendEncodedPath(paramView).build().toString();
        paramBundle = Request.get().url(state).miniProfileRoute).builder(MiniProfile.BUILDER);
      }
      paramView = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      paramView = paramView.filter(DataManager.DataStoreFilter.NETWORK_ONLY).required((DataRequestWrapper.Builder)localObject5);
      if (paramBundle != null) {
        paramView.optional(paramBundle);
      }
      ((HeathrowFlowDataProvider)localObject1).performMultiplexedFetch((String)localObject2, (String)localObject3, (Map)localObject4, paramView);
      fragmentComponent.delayedExecution().postDelayedExecutionOptional(new Runnable()
      {
        public final void run()
        {
          if ((!navigationDone) && (isAdded()))
          {
            HeathrowRoutingFragment.access$002$2dceeb40(HeathrowRoutingFragment.this);
            HeathrowRoutingFragment.this.navigateToDefaultRoute(ErrorType.TIMED_OUT);
          }
        }
      }, i);
      return;
    }
  }
  
  public final String pageKey()
  {
    return "heathrow_redirect";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowRoutingFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */