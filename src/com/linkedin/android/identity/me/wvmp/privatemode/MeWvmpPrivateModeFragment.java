package com.linkedin.android.identity.me.wvmp.privatemode;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.identity.me.wvmp.shared.ClickableSpanUtil;
import com.linkedin.android.identity.me.wvmp.shared.SettingsClickableSpan;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.settings.SettingsTransformerHelper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public class MeWvmpPrivateModeFragment
  extends PageFragment
{
  @InjectView(2131756791)
  TextView canIBlockBody;
  @InjectView(2131756790)
  TextView canIBlockTitle;
  @InjectView(2131755468)
  Toolbar toolbar;
  @InjectView(2131756787)
  TextView whatIsPrivateModeBody;
  @InjectView(2131756786)
  TextView whatIsPrivateModeTitle;
  @InjectView(2131756789)
  TextView whyPrivateModeBody;
  @InjectView(2131756788)
  TextView whyPrivateModeTitle;
  
  public static MeWvmpPrivateModeFragment newInstance()
  {
    return new MeWvmpPrivateModeFragment();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969002, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = fragmentComponent.i18NManager();
    paramBundle = paramView.getSpannedString(2131232188, new Object[0]);
    TextView localTextView = whatIsPrivateModeBody;
    SettingsClickableSpan localSettingsClickableSpan = new SettingsClickableSpan(SettingsTransformerHelper.getFullUrl("/psettings/profile-visibility", applicationComponent), paramView.getString(2131233633), "profile_viewing", fragmentComponent, "privacy_settings_visibility", new TrackingEventBuilder[0]);
    getContext();
    localTextView.setText(ClickableSpanUtil.addLinkToStyleSpan$17ad19fc(paramBundle, localSettingsClickableSpan));
    whatIsPrivateModeBody.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = paramView.getSpannedString(2131232170, new Object[0]);
    localTextView = canIBlockBody;
    paramView = new SettingsClickableSpan(SettingsTransformerHelper.getFullUrl("/psettings/member-blocking ", applicationComponent), paramView.getString(2131233613), "member_blocking", fragmentComponent, "privacy_settings_block", new TrackingEventBuilder[0]);
    getContext();
    localTextView.setText(ClickableSpanUtil.addLinkToStyleSpan$17ad19fc(paramBundle, paramView));
    canIBlockBody.setMovementMethod(LinkMovementMethod.getInstance());
    toolbar.setTitle(2131232169);
    toolbar.setNavigationOnClickListener(new MeWvmpPrivateModeFragment.1(this));
  }
  
  public final String pageKey()
  {
    return "me_privatemode";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmp.privatemode.MeWvmpPrivateModeFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */