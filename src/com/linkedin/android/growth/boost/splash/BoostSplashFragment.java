package com.linkedin.android.growth.boost.splash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.growth.boost.BoostUtil;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.TrackableFragment.EnterTooEarlyException;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.Duration;
import com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostEligibility;
import com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PegasusTrackingEventBuilder;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo;
import com.linkedin.gen.avro2pegasus.events.promotions.PromotionActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent.Builder;
import com.linkedin.xmsg.Name;
import java.util.Collections;
import javax.inject.Inject;

public class BoostSplashFragment
  extends PageFragment
{
  @InjectView(2131755990)
  Button continueButton;
  @Inject
  I18NManager i18NManager;
  @Inject
  MemberUtil memberUtil;
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  
  public final void doEnter()
    throws TrackableFragment.EnterTooEarlyException
  {
    super.doEnter();
    Tracker localTracker = tracker;
    UpgradeConfirmationViewEvent.Builder localBuilder = new UpgradeConfirmationViewEvent.Builder();
    Object localObject = BoostUtil.getPhoneNumberInfo(getActivity());
    if (localObject == null)
    {
      hasPhoneNumberInfo = false;
      phoneNumberInfo = null;
      localObject = sharedPreferences;
      getActivity();
      localObject = BoostUtil.getProductUrn$63ab225c((FlagshipSharedPreferences)localObject);
      if (localObject != null) {
        break label87;
      }
      hasProductUrn = false;
    }
    for (productUrn = null;; productUrn = ((String)localObject))
    {
      localTracker.send(localBuilder);
      return;
      hasPhoneNumberInfo = true;
      phoneNumberInfo = ((PhoneNumberInfo)localObject);
      break;
      label87:
      hasProductUrn = true;
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968805, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    paramView = (BoostSplashFragmentViewHolder)BoostSplashFragmentViewHolder.CREATOR.createViewHolder(paramView);
    paramBundle = new BoostSplashFragmentViewModel();
    BoostEligibility localBoostEligibility = BoostUtil.getBoostEligibilityModelFromPreferences(sharedPreferences);
    heading = i18NManager.getString(2131230814, new Object[] { I18NManager.getName(memberUtil.getMiniProfile()).getGivenName() });
    body = i18NManager.getString(2131230812, new Object[] { Integer.valueOf(promotionData.duration.numMonths), promotionData.subscriptionName });
    footer = i18NManager.getString(2131230813, new Object[] { promotionData.carrierName });
    getLayoutInflater(null);
    fragmentComponent.mediaCenter();
    paramBundle.onBindViewHolder$2889d6ff(paramView);
    continueButton.setOnClickListener(new TrackingOnClickListener(tracker, "continue", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        Tracker localTracker = tracker;
        PromotionActionEvent.Builder localBuilder = new PromotionActionEvent.Builder().setControlUrn(PegasusTrackingEventBuilder.buildControlUrn(tracker.getCurrentPageInstance().pageKey, "continue")).setPhoneNumberInfo(BoostUtil.getPhoneNumberInfo(getActivity()));
        FlagshipSharedPreferences localFlagshipSharedPreferences = sharedPreferences;
        getActivity();
        localTracker.send(localBuilder.setProductUrns(Collections.singletonList(BoostUtil.getProductUrn$63ab225c(localFlagshipSharedPreferences))));
        super.onClick(paramAnonymousView);
        ((LegoWidget)getParentFragment()).finishCurrentFragment();
      }
    });
  }
  
  public final String pageKey()
  {
    return "boost_splash";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.splash.BoostSplashFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */