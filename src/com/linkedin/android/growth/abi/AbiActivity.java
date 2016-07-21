package com.linkedin.android.growth.abi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.growth.lego.LegoFlowNavigation;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.lego.LegoManager.LegoNoWidgetsException;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.lego.LegoWidgetContent;
import com.linkedin.android.growth.utils.GrowthLixHelper;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.growth.utils.RelevanceTrackingUtils;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.CrossActivitySnackbarCallbacks;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.JsonGeneratorException;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationDiscardReason;
import com.linkedin.gen.avro2pegasus.events.relevance.Route;
import javax.inject.Inject;

public class AbiActivity
  extends BaseActivity
  implements AbiErrorListener, LegoFlowNavigation
{
  private AbiDataProvider abiDataProvider;
  @Inject
  AbiLegoWidgetSwitch abiFragmentSwitch;
  private String abiSource;
  private String currentLegoWidgetTag;
  @Inject
  FlagshipDataManager dataManager;
  private String firstLegoWidgetTag;
  @Inject
  FlagshipSharedPreferences flagshipSharedPreferences;
  private boolean isAnyResultsShown;
  @Inject
  LegoManager legoManager;
  private boolean shouldShowSplashPage;
  
  public static void restartAbiFlow(FragmentActivity paramFragmentActivity)
  {
    if ((paramFragmentActivity instanceof AbiActivity))
    {
      if (shouldShowSplashPage)
      {
        FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
        while (localFragmentManager.getBackStackEntryCount() != 0) {
          localFragmentManager.popBackStackImmediate();
        }
        currentLegoWidgetTag = null;
        ((AbiActivity)paramFragmentActivity).startFlow();
        return;
      }
      ((AbiActivity)paramFragmentActivity).exitFlow(null);
      return;
    }
    paramFragmentActivity.onBackPressed();
  }
  
  public static boolean shouldShowSocialProofSplash(LixManager paramLixManager, String paramString)
  {
    return ("socialProof".equalsIgnoreCase(paramLixManager.getTreatment(Lix.LIX_ABI_TAKEOVER_TYPE))) && ("mobile-voyager-takeover-social-proof".equals(paramString));
  }
  
  private void switchToWidget(WidgetContent paramWidgetContent)
  {
    currentLegoWidgetTag = widgetId;
    Object localObject1 = getIntent();
    Object localObject2 = abiFragmentSwitch;
    if (localObject1 != null) {}
    for (localObject1 = ((Intent)localObject1).getExtras();; localObject1 = null)
    {
      localObject1 = ((AbiLegoWidgetSwitch)localObject2).getLegoWidget(paramWidgetContent, (Bundle)localObject1);
      if (localObject1 != null) {
        break;
      }
      moveToNextLegoWidget();
      return;
    }
    switch (((LegoWidget)localObject1).getStatus(activityComponent))
    {
    default: 
    case 3: 
      for (;;)
      {
        localObject2 = ((LegoWidget)localObject1).getArguments();
        if ((localObject2 != null) && (currentLegoWidgetTag.equalsIgnoreCase(firstLegoWidgetTag)))
        {
          ((Bundle)localObject2).putBoolean("isFirstWidgetInLegoFlow", true);
          ((LegoWidget)localObject1).setArguments((Bundle)localObject2);
        }
        getSupportFragmentManager().beginTransaction().replace(2131755909, (Fragment)localObject1, widgetId).addToBackStack(widgetId).commit();
        return;
        isAnyResultsShown = true;
      }
    }
    moveToNextLegoWidget();
  }
  
  public final void exitFlow(Intent paramIntent)
  {
    if (paramIntent != null) {
      startActivity(paramIntent);
    }
    for (;;)
    {
      supportFinishAfterTransition();
      return;
      startActivity(intentRegistry.home.newIntent(this, null).setFlags(268468224));
    }
  }
  
  public final int getFlowContainer()
  {
    return 2131755909;
  }
  
  public final int getFlowLayout()
  {
    return 2130968779;
  }
  
  public final void moveToNextGroupLegoWidget() {}
  
  public final void moveToNextLegoWidget()
  {
    WidgetContent localWidgetContent = legoManager.goToNextLegoWidget();
    if (localWidgetContent == null)
    {
      if ((GrowthLixHelper.isEnabled(activityComponent.lixManager(), Lix.LIX_ABI_ERROR_HANDLING)) && (!isAnyResultsShown))
      {
        OwlTrackingUtils.trackAbookImportInvitationImpressionDiscardEvent(activityComponent.tracker(), activityComponent.lixManager(), abiDataProvider.state).abookImportTransactionId, AbookImportInvitationDiscardReason.NO_ELIGIBLE_CONTACTS);
        onAbiError(2131231344);
        return;
      }
      exitFlow(null);
      return;
    }
    switchToWidget(localWidgetContent);
  }
  
  public final void moveToPreviousLegoWidget()
  {
    if (getSupportFragmentManager().getBackStackEntryCount() == 1)
    {
      supportFinishAfterTransition();
      return;
    }
    currentLegoWidgetTag = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 2).getName();
    if (!TextUtils.isEmpty(currentLegoWidgetTag)) {
      legoManager.skipToWidget(currentLegoWidgetTag);
    }
    getSupportFragmentManager().popBackStackImmediate();
  }
  
  public final void onAbiError(int paramInt)
  {
    if ("mobile-voyager-takeover-resultsLanding".equals(abiDataProvider.state).abiSource))
    {
      finish();
      return;
    }
    applicationComponent.app().registerActivityLifecycleCallbacks(new CrossActivitySnackbarCallbacks(applicationComponent.app(), paramInt));
    exitFlow(null);
  }
  
  public void onBackPressed()
  {
    if ((currentLegoWidgetTag == null) || (getSupportFragmentManager().findFragmentByTag(currentLegoWidgetTag) == null))
    {
      super.onBackPressed();
      int i = getSupportFragmentManager().getBackStackEntryCount();
      if (i > 0) {
        currentLegoWidgetTag = getSupportFragmentManager().getBackStackEntryAt(i - 1).getName();
      }
    }
    LegoWidget localLegoWidget;
    do
    {
      return;
      localLegoWidget = (LegoWidget)getSupportFragmentManager().findFragmentByTag(currentLegoWidgetTag);
    } while (localLegoWidget == null);
    localLegoWidget.handleBack();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    setContentView(2130968779);
    abiDataProvider = activityComponent.abiDataProvider();
    Object localObject3;
    Object localObject1;
    int i;
    label90:
    label128:
    label168:
    label201:
    Object localObject2;
    if (getIntent() != null)
    {
      localObject3 = getIntent().getExtras();
      localObject1 = flagshipSharedPreferences;
      if ((localObject3 != null) && (((Bundle)localObject3).getInt("LAUNCH_MODE", 0) == 1))
      {
        i = 1;
        boolean bool1;
        if (i == 0)
        {
          if (localObject3 != null) {
            break label522;
          }
          i = 1;
          bool1 = bool2;
          if (i != 0)
          {
            bool1 = bool2;
            if (((FlagshipSharedPreferences)localObject1).isAbiAutoSync()) {}
          }
        }
        else
        {
          if ((localObject3 == null) || (((Bundle)localObject3).getInt("LAUNCH_MODE", 0) != 2)) {
            break label544;
          }
          i = 1;
          bool1 = bool2;
          if (i == 0) {
            bool1 = true;
          }
        }
        shouldShowSplashPage = bool1;
        abiDataProvider.state).contextualMiniProfile = AbiIntentBundle.getMiniProfile((Bundle)localObject3);
        if (localObject3 != null) {
          break label549;
        }
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          activityComponent.legoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7((String)localObject1, Visibility.SHOW);
        }
        if (localObject3 != null) {
          break label562;
        }
        localObject1 = null;
        if (!TextUtils.isEmpty(AbiIntentBundle.getAbiSource((Bundle)localObject3))) {
          break label575;
        }
        localObject2 = "mobile-voyager-other";
        label217:
        abiSource = ((String)localObject2);
        abiDataProvider.state).abiSource = abiSource;
        if (("mobile-voyager-autosync-toast".equals(abiSource)) && (!"control".equals(activityComponent.lixManager().getTreatment(Lix.LIX_ABI_HIGHLIGHT_RECENT_CONTACTS)))) {
          abiDataProvider.state).shouldHighlightRecentContacts = true;
        }
        Object localObject4 = (AbiDataProvider.AbiState)abiDataProvider.state;
        if (localObject3 != null) {
          break label585;
        }
        localObject2 = null;
        label313:
        heathrowSource = ((HeathrowSource)localObject2);
        if (localObject3 != null) {
          break label601;
        }
        localObject2 = null;
        label328:
        if ((!"control".equalsIgnoreCase(activityComponent.lixManager().getTreatment(Lix.LIX_HEATHROW_SUGGESTED_ROUTE_TRACKING))) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          localObject4 = activityComponent.tracker();
          LixManager localLixManager = activityComponent.lixManager();
          if (!shouldShowSplashPage) {
            break label614;
          }
          localObject3 = Route.ABI_SPLASH;
          label396:
          RelevanceTrackingUtils.trackSuggestedRouteActionEvent((String)localObject2, (Tracker)localObject4, localLixManager, (Route)localObject3, null);
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = OwlTrackingUtils.trackAbookImportImpressionEvent(activityComponent.tracker(), activityComponent.lixManager(), abiSource);
        }
        abiDataProvider.state).abookImportTransactionId = ((String)localObject2);
      }
    }
    else
    {
      if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getString("currentLegoWidgetTag")))) {
        break label622;
      }
      getSupportFragmentManager().beginTransaction().replace(2131755909, new AbiPrepareFragmentFactory().newFragment(new AbiPrepareBundle(shouldShowSplashPage))).commit();
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label522:
      if (((Bundle)localObject3).getInt("LAUNCH_MODE", 0) == 0)
      {
        i = 1;
        break label90;
      }
      i = 0;
      break label90;
      label544:
      i = 0;
      break label128;
      label549:
      localObject1 = ((Bundle)localObject3).getString("legoTrackingToken");
      break label168;
      label562:
      localObject1 = ((Bundle)localObject3).getString("abookImportTransactionId");
      break label201;
      label575:
      localObject2 = AbiIntentBundle.getAbiSource((Bundle)localObject3);
      break label217;
      label585:
      localObject2 = (HeathrowSource)((Bundle)localObject3).getSerializable("HEATHROW_SOURCE");
      break label313;
      label601:
      localObject2 = ((Bundle)localObject3).getString("suggestedRouteTrackingId");
      break label328;
      label614:
      localObject3 = Route.ABI_RESULTS_LANDING;
      break label396;
      label622:
      currentLegoWidgetTag = paramBundle.getString("currentLegoWidgetTag");
      firstLegoWidgetTag = paramBundle.getString("firstLegoWidgetTag");
      isAnyResultsShown = paramBundle.getBoolean("isAnyResultsShownKey");
      try
      {
        paramBundle = (PageContent)RecordParceler.unparcel(PageContent.BUILDER, "currentLegoFlowTag", paramBundle);
        abiDataProvider.state).abiLegoFlow = paramBundle;
        if (paramBundle != null)
        {
          legoManager.buildFlow(paramBundle, false);
          legoManager.skipToWidget(currentLegoWidgetTag);
          return;
        }
      }
      catch (DataReaderException paramBundle)
      {
        Util.safeThrow$7a8b4789(new IllegalStateException("Error un-parceling abi lego flow", paramBundle));
        exitFlow(null);
        return;
      }
      catch (LegoManager.LegoNoWidgetsException paramBundle)
      {
        Util.safeThrow$7a8b4789(new IllegalStateException("Error building lego flow, no widgets available", paramBundle));
        exitFlow(null);
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("currentLegoWidgetTag", currentLegoWidgetTag);
    paramBundle.putString("firstLegoWidgetTag", firstLegoWidgetTag);
    paramBundle.putBoolean("isAnyResultsShownKey", isAnyResultsShown);
    PageContent localPageContent = ((AbiDataProvider.AbiState)abiDataProvider.state).abiLegoFlow();
    if (localPageContent != null) {}
    try
    {
      RecordParceler.parcel(localPageContent, "currentLegoFlowTag", paramBundle);
      return;
    }
    catch (JsonGeneratorException paramBundle)
    {
      Util.safeThrow$7a8b4789(new IllegalStateException("Error parceling abi lego flow", paramBundle));
    }
  }
  
  public final void startFlow()
  {
    try
    {
      if (currentLegoWidgetTag != null)
      {
        switchToWidget(legoManager.skipToWidget(currentLegoWidgetTag));
        return;
      }
      Object localObject = legoManager;
      currentWidget = LegoManager.getFirstNonNullWidget(page);
      localObject = currentWidget.widgetContent;
      firstLegoWidgetTag = widgetId;
      switchToWidget((WidgetContent)localObject);
      return;
    }
    catch (LegoManager.LegoNoWidgetsException localLegoNoWidgetsException)
    {
      Log.e("flow has no widgets", localLegoNoWidgetsException);
      exitFlow(null);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */