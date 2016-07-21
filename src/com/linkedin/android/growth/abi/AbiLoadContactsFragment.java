package com.linkedin.android.growth.abi;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseLegoWidget;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.growth.utils.ProgressBarUtil;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportDropReason;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationDiscardReason;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class AbiLoadContactsFragment
  extends LegoFragment
{
  AbiDataProvider abiDataProvider;
  @InjectView(2131755951)
  @Optional
  TextView abiResultsLoadingToolbarText;
  boolean didContactsUpload;
  @Inject
  FlagshipSharedPreferences flagshipSharedPreferences;
  private boolean haveContactsResultsBeenUsed;
  private boolean isAbiAutoSyncOn;
  @InjectView(2131755920)
  @Optional
  ProgressBar loadContactsProgressBar;
  @InjectView(2131755954)
  @Optional
  ProgressBar resultsLoadingProgressBarHorizontal;
  private boolean shouldUseResultsLoadingScreen;
  @Inject
  SnackbarUtil snackbar;
  
  private void startProgressBarForLoading()
  {
    if (shouldUseResultsLoadingScreen)
    {
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
      return;
    }
    fragmentComponent.progressBarUtil();
    ProgressBarUtil.setProgressDecelerate$c7af0ba(loadContactsProgressBar);
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
    if ("enabled".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS)))
    {
      shouldUseResultsLoadingScreen = true;
      return paramLayoutInflater.inflate(2130968794, paramViewGroup, false);
    }
    shouldUseResultsLoadingScreen = false;
    return paramLayoutInflater.inflate(2130968782, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (!isAdded()) {}
    while (("enabled".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS))) && (isAbiAutoSyncOn) && (paramType == DataStore.Type.LOCAL)) {
      return;
    }
    if (isAbiAutoSyncOn)
    {
      paramType = AbookImportInvitationDiscardReason.CONTACTS_FETCH;
      trackAbookImportInvitationImpressionDiscardEvent(paramType);
      if (("control".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.LIX_ABI_ERROR_HANDLING))) || (!(getActivity() instanceof AbiErrorListener))) {
        break label140;
      }
      paramType = (AbiErrorListener)getActivity();
      if (!didContactsUpload) {
        break label133;
      }
    }
    label133:
    for (int i = 2131231342;; i = 2131231341)
    {
      paramType.onAbiError(i);
      return;
      paramType = AbookImportInvitationDiscardReason.CONTACTS_UPLOAD;
      break;
    }
    label140:
    paramType = snackbar.make(2131231373, 0);
    if (paramType != null) {
      paramType.show();
    }
    getActivity().onBackPressed();
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    boolean bool2 = true;
    if (!isAdded()) {}
    do
    {
      return;
      if (!abiDataProvider.isContactsDataAvailable()) {
        break label209;
      }
      if (didContactsUpload)
      {
        flagshipSharedPreferences.setAbiLastSyncTimestamp(new Date().getTime());
        flagshipSharedPreferences.setAbiLastUploadedMaxContactId(flagshipSharedPreferences.getAbiLastReadMaxContactId());
      }
      if ((!isAbiAutoSyncOn) || (paramMap == null)) {
        break label189;
      }
      if (!"enabled".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS))) {
        break;
      }
    } while (haveContactsResultsBeenUsed);
    haveContactsResultsBeenUsed = true;
    paramSet = fragmentComponent.abiCacheUtils();
    AbiDataProvider localAbiDataProvider = abiDataProvider;
    if (paramType == DataStore.Type.NETWORK)
    {
      bool1 = true;
      paramSet.updatePastImportedContactsResultsAndItsLegoCacheUpdatedTimestamp(paramMap, localAbiDataProvider, bool1);
      if ("enabled".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS)))
      {
        paramSet = abiDataProvider;
        if (paramType != DataStore.Type.LOCAL) {
          break label203;
        }
      }
    }
    label189:
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramSet.fetchAndFilterByUnblockedMemberContacts(bool1);
      legoWidget.finishCurrentFragment();
      return;
      bool1 = false;
      break;
    }
    label209:
    trackAbookImportInvitationImpressionDiscardEvent(AbookImportInvitationDiscardReason.NO_CONTACTS_RECEIVED);
    if ((!"control".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.LIX_ABI_ERROR_HANDLING))) && ((getActivity() instanceof AbiErrorListener)))
    {
      ((AbiErrorListener)getActivity()).onAbiError(2131231344);
      return;
    }
    paramType = snackbar.make(2131231373, 0);
    if (paramType != null) {
      paramType.show();
    }
    getActivity().onBackPressed();
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    super.onRequestPermissionsResult(paramSet1, paramSet2);
    if (paramSet2.isEmpty())
    {
      applicationComponent.flagshipSharedPreferences().setAbiAutoSync(true, applicationComponent.memberUtil().getProfileId());
      startProgressBarForLoading();
      fragmentComponent.activity().getSupportLoaderManager().initLoader$71be8de6(new LoaderManager.LoaderCallbacks()
      {
        public final Loader<List<RawContact>> onCreateLoader$e57f803(int paramAnonymousInt)
        {
          return new AbiContactsLoader(fragmentComponent.activity(), fragmentComponent.abiContactsReader());
        }
        
        public final void onLoaderReset$5dda1f52() {}
      });
      return;
    }
    trackAbookImportDropEvent(AbookImportDropReason.SYSTEM_CONTACTS_READ_PERMISSION_DENIED);
    paramSet1 = snackbar.make(2131231371, 0);
    if (paramSet1 != null) {
      paramSet1.show();
    }
    getActivity().onBackPressed();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    if (fragmentComponent.activity() == null) {
      return;
    }
    abiDataProvider = fragmentComponent.activity().activityComponent.abiDataProvider();
    isAbiAutoSyncOn = applicationComponent.flagshipSharedPreferences().isAbiAutoSync(applicationComponent.memberUtil().getProfileId());
    if (isAbiAutoSyncOn)
    {
      startProgressBarForLoading();
      abiDataProvider.fetchPastImportedContactsAndItsLegoFlow(getActivity(), abiDataProvider.getDataStoreFilterTypeForFetchingPastImportedContactsAndItsLegoFlow(fragmentComponent.lixManager()), busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()));
      OwlTrackingUtils.trackAbookImportSubmitEvent(abiDataProvider.state).abookImportTransactionId, fragmentComponent.lixManager(), fragmentComponent.tracker());
      return;
    }
    paramView = getParentFragment();
    if ((paramView instanceof AbiSplashBaseLegoWidget))
    {
      ((BaseFragment)paramView).requestPermission("android.permission.READ_CONTACTS", 2131231380, 2131231379);
      return;
    }
    requestPermission("android.permission.READ_CONTACTS", 2131231380, 2131231379);
  }
  
  public final String pageKey()
  {
    return "abi_loading";
  }
  
  final void trackAbookImportDropEvent(AbookImportDropReason paramAbookImportDropReason)
  {
    OwlTrackingUtils.trackAbookImportDropEvent(fragmentComponent.tracker(), fragmentComponent.lixManager(), abiDataProvider.state).abookImportTransactionId, paramAbookImportDropReason);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiLoadContactsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */