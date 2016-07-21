package com.linkedin.android.growth.abi.splash;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.growth.abi.AbiActivity;
import com.linkedin.android.growth.abi.AbiDataProvider;
import com.linkedin.android.growth.abi.AbiDataProvider.AbiState;
import com.linkedin.android.growth.abi.AbiIntentBundle;
import com.linkedin.android.growth.abi.AbiTransformer;
import com.linkedin.android.growth.abi.AbiTransformer.4;
import com.linkedin.android.growth.heathrow.HeathrowLandingUtil;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import com.linkedin.android.relationships.connectFlow.ConnectFlowActionHelper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.JsonGeneratorException;
import java.util.ArrayList;

public class MainAbiSplashFragment
  extends AbiSplashBaseFragment
{
  private AbiDataProvider abiDataProvider;
  private String abiSource;
  private MiniProfile contextualMiniProfile;
  @InjectView(2131755966)
  @Optional
  ImageView splashImage;
  @InjectView(2131755978)
  @Optional
  Toolbar toolBarForAcceptInvite;
  @InjectView(2131755962)
  @Optional
  Toolbar toolBarForNonAcceptInvite;
  @InjectView(2131758309)
  @Optional
  RelativeLayout topCard;
  @InjectView(2131755967)
  @Optional
  LinearLayout topCardContainer;
  
  private void setupToolbar(Toolbar paramToolbar)
  {
    if (paramToolbar == null)
    {
      CrashReporter.reportNonFatal(new Throwable("Toolbar for ABI new intro page is null"));
      return;
    }
    paramToolbar.setNavigationOnClickListener(new TrackingOnClickListener(tracker, "cancel", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        NavigationUtils.onUpPressed(getActivity(), true);
      }
    });
  }
  
  private boolean shouldShowHeathrowAbiSplash()
  {
    return (!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.LIX_HEATHROW_ABIINTRONEWSCREN))) && (contextualMiniProfile != null) && ((HeathrowSource.EMAIL_DEEPLINK_ACCEPTINVITE.getAbookImportImpressionEventSource().equals(abiSource)) || (HeathrowSource.PROFILE_ACCEPTINVITE.getAbookImportImpressionEventSource().equals(abiSource)));
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    abiDataProvider = getActivityactivityComponent.abiDataProvider();
    abiSource = AbiIntentBundle.getAbiSource(getArguments());
    if (paramBundle != null) {}
    try
    {
      paramBundle = (CollectionTemplate)RecordParceler.unparcel(CollectionTemplate.of(Connection.BUILDER), "socialProofMiniProfiles", paramBundle);
      if (paramBundle != null) {
        abiDataProvider.state).socialProofConnections = paramBundle;
      }
      return;
    }
    catch (DataReaderException paramBundle)
    {
      getContext();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Model unparcel of social proof connections failed"));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (contextualMiniProfile != null) {}
    for (paramBundle = contextualMiniProfile;; paramBundle = abiDataProvider.state).contextualMiniProfile)
    {
      contextualMiniProfile = paramBundle;
      if (!shouldShowHeathrowAbiSplash()) {
        break;
      }
      return paramLayoutInflater.inflate(2130968802, paramViewGroup, false);
    }
    if (AbiActivity.shouldShowSocialProofSplash(fragmentComponent.lixManager(), abiSource)) {
      return paramLayoutInflater.inflate(2130968801, paramViewGroup, false);
    }
    return paramLayoutInflater.inflate(2130968797, paramViewGroup, false);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    CollectionTemplate localCollectionTemplate;
    if ((abiDataProvider != null) && (AbiActivity.shouldShowSocialProofSplash(fragmentComponent.lixManager(), abiSource)))
    {
      localCollectionTemplate = ((AbiDataProvider.AbiState)abiDataProvider.state).getConnectionsCollection();
      if (localCollectionTemplate == null) {}
    }
    try
    {
      RecordParceler.parcel(localCollectionTemplate, "socialProofMiniProfiles", paramBundle);
      return;
    }
    catch (JsonGeneratorException paramBundle)
    {
      getContext();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Model parcel of social proof connections failed"));
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (shouldShowHeathrowAbiSplash())
    {
      paramView = (AcceptInviteAbiSplashViewHolder)AcceptInviteAbiSplashViewHolder.CREATOR.createViewHolder(paramView);
      localObject1 = abiSplashLegoWidget;
      localObject2 = fragmentComponent;
      localObject3 = contextualMiniProfile;
      AcceptInviteAbiSplashViewModel localAcceptInviteAbiSplashViewModel = new AcceptInviteAbiSplashViewModel();
      I18NManager localI18NManager = ((FragmentComponent)localObject2).i18NManager();
      headingText = ((FragmentComponent)localObject2).i18NManager().getSpannedString(2131231387, new Object[] { I18NManager.getName((MiniProfile)localObject3) });
      profileImage = new ImageModel(picture, GhostImageUtils.getPerson(2131492967, (MiniProfile)localObject3), Util.retrieveRumSessionId((FragmentComponent)localObject2));
      viewProfileText = ((FragmentComponent)localObject2).i18NManager().getSpannedString(2131231389, new Object[] { I18NManager.getName((MiniProfile)localObject3) });
      viewProfileClickListener = ConnectFlowActionHelper.createViewProfileClickListener((FragmentComponent)localObject2, (MiniProfile)localObject3);
      rationaleMessageText = localI18NManager.getString(2131231388, new Object[] { I18NManager.getName((MiniProfile)localObject3) });
      disclaimerText = localI18NManager.getString(2131231374);
      learnMoreListener = new AbiTransformer.4(((FragmentComponent)localObject2).tracker(), "learn_more", new TrackingEventBuilder[0], (AbiSplashBaseLegoWidget)localObject1);
      getLayoutInflater(paramBundle);
      localAcceptInviteAbiSplashViewModel.onBindViewHolder$6427a5a2(fragmentComponent.mediaCenter(), paramView);
      if (HeathrowSource.PROFILE_ACCEPTINVITE.getAbookImportImpressionEventSource().equals(abiSource))
      {
        toolBarForAcceptInvite.setNavigationIcon(2130838633);
        toolBarForAcceptInvite.setNavigationContentDescription(2131232791);
      }
    }
    label447:
    do
    {
      for (;;)
      {
        setupToolbar(toolBarForAcceptInvite);
        return;
        if (HeathrowSource.EMAIL_DEEPLINK_ACCEPTINVITE.getAbookImportImpressionEventSource().equals(abiSource))
        {
          toolBarForAcceptInvite.setNavigationIcon(2130838634);
          toolBarForAcceptInvite.setNavigationContentDescription(2131232792);
        }
      }
      if (AbiActivity.shouldShowSocialProofSplash(fragmentComponent.lixManager(), abiSource))
      {
        localObject1 = (AbiSocialProofSplashViewHolder)AbiSocialProofSplashViewHolder.CREATOR.createViewHolder(paramView);
        paramView = ((AbiDataProvider.AbiState)abiDataProvider.state).getConnectionsCollection();
        if (paramView != null)
        {
          paramView = elements;
          localObject2 = abiSplashLegoWidget;
          localObject3 = fragmentComponent;
          if (paramView == null) {
            break label447;
          }
        }
        for (;;)
        {
          paramView = AbiTransformer.toAbiSocialProofSplashViewModel((AbiSplashBaseLegoWidget)localObject2, (FragmentComponent)localObject3, paramView);
          getLayoutInflater(paramBundle);
          paramView.onBindViewHolder$2ba32518(fragmentComponent.mediaCenter(), (AbiSocialProofSplashViewHolder)localObject1);
          setupToolbar(toolBarForNonAcceptInvite);
          return;
          paramView = null;
          break;
          paramView = new ArrayList();
        }
      }
      paramView = (MainAbiSplashViewHolder)MainAbiSplashViewHolder.CREATOR.createViewHolder(paramView);
      localObject1 = abiSplashLegoWidget;
      localObject2 = fragmentComponent;
      localObject1 = AbiTransformer.toMainAbiSplashViewModel((AbiSplashBaseLegoWidget)localObject1, (FragmentComponent)localObject2, ((FragmentComponent)localObject2).i18NManager().getString(2131231375));
      getLayoutInflater(paramBundle);
      fragmentComponent.mediaCenter();
      ((MainAbiSplashViewModel)localObject1).onBindViewHolder$70b7bbd6(paramView);
      setupToolbar(toolBarForNonAcceptInvite);
    } while (!legoWidget.isFirstWidgetInLegoFlow);
    if (contextualMiniProfile != null) {}
    for (paramView = contextualMiniProfile;; paramView = abiDataProvider.state).contextualMiniProfile)
    {
      contextualMiniProfile = paramView;
      paramView = fragmentComponent;
      ((BaseActivity)getActivity()).getLayoutInflater();
      HeathrowLandingUtil.setupTopCard$21706835(paramView, applicationComponent.mediaCenter(), topCard, topCardContainer, contextualMiniProfile, true, abiDataProvider.state).heathrowSource);
      if ((getResourcesgetConfigurationorientation != 2) || (topCardContainer.getVisibility() != 0)) {
        break;
      }
      splashImage.setVisibility(8);
      return;
    }
  }
  
  public final String pageKey()
  {
    return "abi_intro";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.MainAbiSplashFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */