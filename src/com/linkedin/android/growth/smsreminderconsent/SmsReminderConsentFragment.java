package com.linkedin.android.growth.smsreminderconsent;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import javax.inject.Inject;

public class SmsReminderConsentFragment
  extends PageFragment
{
  @InjectView(2131756287)
  TextView header;
  @Inject
  I18NManager i18nManager;
  @Inject
  LegoTrackingDataProvider legoTrackingDataProvider;
  private String legoTrackingToken;
  @Inject
  LixManager lixManager;
  @Inject
  MemberUtil memberUtil;
  @InjectView(2131756289)
  Button remindThemButton;
  @InjectView(2131756288)
  TextView subheader;
  @InjectView(2131756285)
  Toolbar toolbar;
  
  public final void doEnter()
  {
    super.doEnter();
    if (!TextUtils.isEmpty(legoTrackingToken)) {
      legoTrackingDataProvider.sendWidgetImpressionEvent$4bb724c7(legoTrackingToken, Visibility.SHOW);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    legoTrackingToken = SmsReminderConsentIntentBundleBuilder.getLegoTrackingToken(getArguments());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968877, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    toolbar.setNavigationOnClickListener(new SmsReminderConsentFragment.2(this, tracker, "cancel", new TrackingEventBuilder[0]));
    paramView = memberUtil.getMiniProfile();
    paramBundle = lixManager.getTreatment(Lix.LIX_GROWTH_SMS_REMINDER_CONSENT_COPY);
    if (paramView != null)
    {
      if (!"v1".equalsIgnoreCase(paramBundle)) {
        break label144;
      }
      header.setText(i18nManager.getString(2131231729, new Object[] { I18NManager.getName(paramView) }));
      subheader.setText(i18nManager.getString(2131231734));
    }
    for (;;)
    {
      remindThemButton.setOnClickListener(new SmsReminderConsentFragment.1(this, tracker, "remind_them", new TrackingEventBuilder[0]));
      return;
      label144:
      if ("v2".equalsIgnoreCase(paramBundle))
      {
        header.setText(i18nManager.getString(2131231730, new Object[] { I18NManager.getName(paramView) }));
        subheader.setText(i18nManager.getString(2131231735));
      }
      else if ("v3".equalsIgnoreCase(paramBundle))
      {
        header.setText(i18nManager.getString(2131231731, new Object[] { I18NManager.getName(paramView) }));
        subheader.setText(i18nManager.getString(2131231736));
      }
    }
  }
  
  public final String pageKey()
  {
    return "sms_reminder_consent";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */