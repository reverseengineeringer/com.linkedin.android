package com.linkedin.android.growth.login.prereg.intro;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.growth.boost.BoostEligibilityFetchedEvent;
import com.linkedin.android.growth.boost.BoostUtil;
import com.linkedin.android.growth.login.prereg.PreRegPropFragment;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.TrackableFragment.EnterTooEarlyException;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostEligibility;
import com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData;
import com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo;
import com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent.Builder;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class PreRegIntroFragment
  extends PreRegPropFragment<PreRegIntroFragmentViewHolder, PreRegIntroFragmentViewModel>
{
  private boolean boostPromoInserted;
  @Inject
  Bus bus;
  @InjectView(2131756193)
  HorizontalViewPagerCarousel carousel;
  @Inject
  I18NManager i18NManager;
  @InjectView(2131756189)
  LinearLayout linearLayout;
  @InjectView(2131756188)
  ScrollView scrollView;
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  
  private void displayBoostPromo(Context paramContext)
  {
    Object localObject = BoostUtil.getBoostEligibilityModelFromPreferences(sharedPreferences);
    if ((localObject != null) && (userEligible) && (!boostPromoInserted))
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2130968804, linearLayout, false);
      ((TextView)paramContext.findViewById(2131755984)).setText(i18NManager.getString(2131231648, new Object[] { promotionData.carrierName }));
      ((TextView)paramContext.findViewById(2131755985)).setText(i18NManager.getString(2131231647, new Object[] { promotionData.formattedSubscriptionPrice, promotionData.subscriptionName }));
      carousel.setVisibility(4);
      localObject = (RelativeLayout.LayoutParams)scrollView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131756192);
      scrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      linearLayout.addView(paramContext);
      boostPromoInserted = true;
    }
  }
  
  private void sendPromoViewEvent()
  {
    Tracker localTracker;
    PromotionImpressionEvent.Builder localBuilder;
    Object localObject;
    if (boostPromoInserted)
    {
      localTracker = tracker;
      localBuilder = new PromotionImpressionEvent.Builder();
      localObject = BoostUtil.getPhoneNumberInfo(getActivity());
      if (localObject != null) {
        break label84;
      }
      hasPhoneNumberInfo = false;
      phoneNumberInfo = null;
      localObject = sharedPreferences;
      getActivity();
      localObject = Collections.singletonList(BoostUtil.getProductUrn$63ab225c((FlagshipSharedPreferences)localObject));
      if (localObject != null) {
        break label97;
      }
      hasProductUrns = false;
    }
    for (productUrns = null;; productUrns = ((List)localObject))
    {
      localTracker.send(localBuilder);
      PreRegPropFragment.promoViewed = true;
      return;
      label84:
      hasPhoneNumberInfo = true;
      phoneNumberInfo = ((PhoneNumberInfo)localObject);
      break;
      label97:
      hasProductUrns = true;
    }
  }
  
  public final void doEnter()
    throws TrackableFragment.EnterTooEarlyException
  {
    super.doEnter();
    sendPromoViewEvent();
  }
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    if (!Bus.isSubscribed(this)) {
      Bus.subscribe(this);
    }
    displayBoostPromo(getActivity());
  }
  
  protected final ViewHolderCreator<PreRegIntroFragmentViewHolder> getViewHolderCreator()
  {
    return PreRegIntroFragmentViewHolder.CREATOR;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boostPromoInserted = false;
    return paramLayoutInflater.inflate(2130968858, paramViewGroup, false);
  }
  
  @Subscribe
  public final void onEvent(BoostEligibilityFetchedEvent paramBoostEligibilityFetchedEvent)
  {
    displayBoostPromo(getActivity());
    if (isActive) {
      sendPromoViewEvent();
    }
  }
  
  public final String pageKey()
  {
    return "reg_logged_out";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */