package com.linkedin.android.growth.abi;

import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.heathrow.HeathrowLandingUtil;
import com.linkedin.android.growth.lego.LegoFlowNavigation;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.lego.LegoManager.LegoNoWidgetsException;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.growth.utils.ProgressBarUtil;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationDiscardReason;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class AbiPrepareFragment
  extends PageFragment
{
  private AbiDataProvider abiDataProvider;
  @InjectView(2131755951)
  @Optional
  TextView abiResultsLoadingToolbarText;
  @Inject
  FlagshipDataManager dataManager;
  private boolean haveContactsResultsBeenUsed;
  private boolean isFromHeathrowFlow;
  private LegoManager legoManager;
  @InjectView(2131755920)
  @Optional
  ProgressBar loadContactsProgressBar;
  @InjectView(2131755917)
  @Optional
  View loadingProgressLayout;
  @InjectView(2131758311)
  @Optional
  ImageButton messageButton;
  @InjectView(2131755949)
  @Optional
  View resultsLoadingLayout;
  @InjectView(2131755954)
  @Optional
  ProgressBar resultsLoadingProgressBarHorizontal;
  boolean shouldShowSplashPage;
  boolean shouldUseResultsLoadingScreenV2;
  @Inject
  SnackbarUtil snackbar;
  private boolean splashHasBeenShown;
  @InjectView(2131758309)
  @Optional
  RelativeLayout topCard;
  @InjectView(2131755948)
  @Optional
  LinearLayout topCardContainer;
  private MiniProfile topCardMiniProfile;
  boolean useHeathrowLoadContactsScreen;
  
  private void setupTopCard()
  {
    FragmentComponent localFragmentComponent = fragmentComponent;
    ((BaseActivity)getActivity()).getLayoutInflater();
    HeathrowLandingUtil.setupTopCard$21706835(localFragmentComponent, applicationComponent.mediaCenter(), topCard, topCardContainer, topCardMiniProfile, false, abiDataProvider.state).heathrowSource);
    if (messageButton != null)
    {
      messageButton.setEnabled(false);
      messageButton.setAlpha(getActivity().getResources().getFraction(2131689475, 1, 1));
    }
  }
  
  private void startLegoFlow()
  {
    PageContent localPageContent = ((AbiDataProvider.AbiState)abiDataProvider.state).abiLegoFlow();
    LegoFlowNavigation localLegoFlowNavigation;
    if ((getActivity() instanceof LegoFlowNavigation))
    {
      localLegoFlowNavigation = (LegoFlowNavigation)getActivity();
      if (localPageContent == null) {
        localLegoFlowNavigation.exitFlow(null);
      }
    }
    else
    {
      return;
    }
    try
    {
      legoManager.buildFlow(localPageContent, false);
      localLegoFlowNavigation.startFlow();
      return;
    }
    catch (LegoManager.LegoNoWidgetsException localLegoNoWidgetsException)
    {
      Log.e("flow has no widgets", localLegoNoWidgetsException);
      localLegoFlowNavigation.exitFlow(null);
    }
  }
  
  private void trackAbookImportInvitationImpressionDiscardEvent(AbookImportInvitationDiscardReason paramAbookImportInvitationDiscardReason)
  {
    OwlTrackingUtils.trackAbookImportInvitationImpressionDiscardEvent(fragmentComponent.tracker(), fragmentComponent.lixManager(), abiDataProvider.state).abookImportTransactionId, paramAbookImportInvitationDiscardReason);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool2 = true;
    abiDataProvider = getActivityactivityComponent.abiDataProvider();
    topCardMiniProfile = abiDataProvider.state).contextualMiniProfile;
    if (topCardMiniProfile != null)
    {
      bool1 = true;
      isFromHeathrowFlow = bool1;
      shouldUseResultsLoadingScreenV2 = "enabled".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS));
      if ((!isFromHeathrowFlow) || ("control".equals(fragmentComponent.lixManager().getTreatment(Lix.LIX_ACCEPT_INVITE_LOAD_CONTACTS_NEW_SCREEN)))) {
        break label145;
      }
    }
    label145:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      useHeathrowLoadContactsScreen = bool1;
      if (!shouldUseResultsLoadingScreenV2) {
        break label151;
      }
      return paramLayoutInflater.inflate(2130968794, paramViewGroup, false);
      bool1 = false;
      break;
    }
    label151:
    if (useHeathrowLoadContactsScreen) {
      return paramLayoutInflater.inflate(2130968793, paramViewGroup, false);
    }
    return paramLayoutInflater.inflate(2130968782, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (!isAdded()) {}
    do
    {
      do
      {
        return;
        if (paramSet == null) {
          break label112;
        }
        if (!paramSet.contains(abiDataProvider.state).connectionsRoute)) {
          break;
        }
      } while (paramType == DataStore.Type.LOCAL);
      if (paramType == DataStore.Type.NETWORK) {
        CrashReporter.reportNonFatal(new IllegalStateException("Failed to fetch connections for social proof takeover"));
      }
    } while ((paramSet.contains(abiDataProvider.state).abiLegoRoute)) && (paramSet.contains(abiDataProvider.state).contactsRoute)) && (paramType == DataStore.Type.LOCAL));
    label112:
    if (shouldShowSplashPage) {}
    for (paramType = AbookImportInvitationDiscardReason.CONTACTS_UPLOAD;; paramType = AbookImportInvitationDiscardReason.CONTACTS_FETCH)
    {
      trackAbookImportInvitationImpressionDiscardEvent(paramType);
      if (("control".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.LIX_ABI_ERROR_HANDLING))) || (!(getActivity() instanceof AbiErrorListener))) {
        break;
      }
      ((AbiErrorListener)getActivity()).onAbiError(2131231373);
      return;
    }
    paramType = snackbar.make(2131231373, 0);
    if (paramType != null) {
      paramType.show();
    }
    getActivity().onBackPressed();
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    boolean bool2 = false;
    int j = 0;
    if (!isAdded()) {}
    int i;
    do
    {
      do
      {
        return;
        if (!shouldShowSplashPage) {
          break label128;
        }
        if (!AbiActivity.shouldShowSocialProofSplash(fragmentComponent.lixManager(), abiDataProvider.state).abiSource)) {
          break;
        }
      } while (splashHasBeenShown);
      paramType = abiDataProvider;
      i = j;
      if (state).connectionsRoute != null)
      {
        i = j;
        if (((AbiDataProvider.AbiState)state).getConnectionsCollection() != null) {
          i = 1;
        }
      }
    } while ((i == 0) || (!abiDataProvider.isLegoDataAvailable()));
    splashHasBeenShown = true;
    startLegoFlow();
    return;
    startLegoFlow();
    return;
    label128:
    if ((abiDataProvider.isContactsDataAvailable()) && (abiDataProvider.isLegoDataAvailable()))
    {
      AbiDataProvider localAbiDataProvider;
      if (paramMap != null)
      {
        paramSet = fragmentComponent.abiCacheUtils();
        localAbiDataProvider = abiDataProvider;
        if (paramType != DataStore.Type.NETWORK) {
          break label279;
        }
      }
      label279:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramSet.updatePastImportedContactsResultsAndItsLegoCacheUpdatedTimestamp(paramMap, localAbiDataProvider, bool1);
        if ("enabled".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS)))
        {
          paramSet = abiDataProvider;
          bool1 = bool2;
          if (paramType == DataStore.Type.LOCAL) {
            bool1 = true;
          }
          paramSet.fetchAndFilterByUnblockedMemberContacts(bool1);
        }
        if ("enabled".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS)))
        {
          if (haveContactsResultsBeenUsed) {
            break;
          }
          haveContactsResultsBeenUsed = true;
        }
        startLegoFlow();
        return;
      }
    }
    if ((!"control".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.LIX_ABI_ERROR_HANDLING))) && ((getActivity() instanceof AbiErrorListener)))
    {
      if (paramMap == null)
      {
        trackAbookImportInvitationImpressionDiscardEvent(AbookImportInvitationDiscardReason.NO_CONTACTS_RECEIVED);
        ((AbiErrorListener)getActivity()).onAbiError(2131231344);
        return;
      }
      paramType = (DataStoreResponse)paramMap.get(abiDataProvider.state).contactsRoute);
      if ((error != null) || (statusCode >= 400) || (statusCode >= 500))
      {
        trackAbookImportInvitationImpressionDiscardEvent(AbookImportInvitationDiscardReason.CONTACTS_FETCH);
        ((AbiErrorListener)getActivity()).onAbiError(2131231341);
        return;
      }
      trackAbookImportInvitationImpressionDiscardEvent(AbookImportInvitationDiscardReason.NO_CONTACTS_RECEIVED);
      ((AbiErrorListener)getActivity()).onAbiError(2131231344);
      return;
    }
    paramType = snackbar.make(2131231373, 0);
    if (paramType != null) {
      paramType.show();
    }
    getActivity().onBackPressed();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    legoManager = getActivityactivityComponent.legoManager();
    shouldShowSplashPage = AbiPrepareBundle.shouldShowSplashPage(getArguments());
    if (shouldUseResultsLoadingScreenV2) {
      if (shouldShowSplashPage) {
        resultsLoadingLayout.setVisibility(4);
      }
    }
    while (shouldShowSplashPage)
    {
      paramView = abiDataProvider;
      Object localObject1 = busSubscriberId;
      paramBundle = getRumSessionId();
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      state).abiLegoRoute = Routes.ABI_FLOW.buildUponRoot().buildUpon().toString();
      localObject1 = paramView.newModelListener((String)localObject1, paramBundle);
      localObject1 = Request.get().url(state).abiLegoRoute).builder(PageContent.BUILDER).listener((RecordTemplateListener)localObject1).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      ((Request.Builder)localObject1).customHeaders(localMap).trackingSessionId(paramBundle);
      activityComponent.dataManager().submit((Request.Builder)localObject1);
      if (AbiActivity.shouldShowSocialProofSplash(fragmentComponent.lixManager(), abiDataProvider.state).abiSource))
      {
        paramView = abiDataProvider;
        Object localObject2 = busSubscriberId;
        paramBundle = getRumSessionId();
        localMap = Tracker.createPageInstanceHeader(getPageInstance());
        localObject1 = DataManager.DataStoreFilter.ALL;
        state).connectionsRoute = Routes.CONNECTIONS.buildPagedRouteUponRoot(0, 20).toString();
        localObject2 = paramView.newModelListener((String)localObject2, paramBundle);
        paramBundle = Request.get().url(state).connectionsRoute).builder(CollectionTemplate.of(Connection.BUILDER)).listener((RecordTemplateListener)localObject2).filter((DataManager.DataStoreFilter)localObject1).customHeaders(localMap).trackingSessionId(paramBundle);
        activityComponent.dataManager().submit(paramBundle);
      }
      return;
      if (isFromHeathrowFlow) {
        setupTopCard();
      }
      fragmentComponent.progressBarUtil();
      ProgressBarUtil.setProgressDecelerate$c7af0ba(resultsLoadingProgressBarHorizontal);
      fragmentComponent.delayedExecution().postDelayedExecutionOptional(new Runnable()
      {
        public final void run()
        {
          if ((abiResultsLoadingToolbarText != null) && (isAdded())) {
            abiResultsLoadingToolbarText.setText(fragmentComponent.i18NManager().getString(2131231345));
          }
        }
      }, 2000L);
      continue;
      if (useHeathrowLoadContactsScreen)
      {
        if (shouldShowSplashPage) {
          resultsLoadingLayout.setVisibility(4);
        } else {
          setupTopCard();
        }
      }
      else if (shouldShowSplashPage)
      {
        loadingProgressLayout.setVisibility(4);
      }
      else
      {
        fragmentComponent.progressBarUtil();
        ProgressBarUtil.setProgressDecelerate$c7af0ba(loadContactsProgressBar);
      }
    }
    abiDataProvider.fetchPastImportedContactsAndItsLegoFlow(getActivity(), abiDataProvider.getDataStoreFilterTypeForFetchingPastImportedContactsAndItsLegoFlow(fragmentComponent.lixManager()), busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()));
    OwlTrackingUtils.trackAbookImportSubmitEvent(abiDataProvider.state).abookImportTransactionId, fragmentComponent.lixManager(), fragmentComponent.tracker());
  }
  
  public final String pageKey()
  {
    if (AbiPrepareBundle.shouldShowSplashPage(getArguments())) {
      return "abi_prepare";
    }
    return "abi_loading_past_contacts";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiPrepareFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */