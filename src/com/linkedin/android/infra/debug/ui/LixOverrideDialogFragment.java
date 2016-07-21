package com.linkedin.android.infra.debug.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.infra.app.BaseDialogFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.networking.cookies.CookieUtil;
import java.util.Map;
import javax.inject.Inject;

public class LixOverrideDialogFragment
  extends BaseDialogFragment
{
  private String baseUrl;
  @Inject
  CookieUtil cookieUtil;
  @InjectView(2131756554)
  Button lixAddButton;
  private String lixKey;
  @InjectView(2131756548)
  EditText lixKeyEditText;
  @InjectView(2131756543)
  Button lixResetButton;
  private String lixValue;
  @InjectView(2131756551)
  EditText lixValueEditText;
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  
  static LixOverrideDialogFragment newInstance(String paramString1, String paramString2)
  {
    LixOverrideDialogFragment localLixOverrideDialogFragment = new LixOverrideDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("LIX_KEY", paramString1);
    localBundle.putString("LIX_VALUE", paramString2);
    localLixOverrideDialogFragment.setArguments(localBundle);
    return localLixOverrideDialogFragment;
  }
  
  @OnClick({2131756553})
  public void addEnableLixOverrideAndDismiss()
  {
    cookieUtil.setLixOverride(baseUrl, lixKeyEditText.getText().toString(), "enabled");
    getDialog().dismiss();
  }
  
  @OnClick({2131756554})
  public void addLixOverrideAndDismiss()
  {
    if ((!TextUtils.isEmpty(lixKeyEditText.getText().toString())) && (!TextUtils.isEmpty(lixValueEditText.getText().toString())))
    {
      cookieUtil.setLixOverride(baseUrl, lixKeyEditText.getText().toString(), lixValueEditText.getText().toString());
      getDialog().dismiss();
    }
  }
  
  @OnClick({2131756543})
  public void dismissDialogAndRemoveLixOverride()
  {
    CookieUtil localCookieUtil;
    String str1;
    String str2;
    if (!TextUtils.isEmpty(lixKeyEditText.getText().toString()))
    {
      localCookieUtil = cookieUtil;
      str1 = baseUrl;
      str2 = lixKeyEditText.getText().toString();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break label59;
      }
    }
    for (;;)
    {
      getDialog().dismiss();
      return;
      label59:
      Map localMap = localCookieUtil.getLixOverrideKeyValues(str1);
      localMap.remove(str2);
      localCookieUtil.resetLixOverrideCookie(str1, localMap);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    lixKey = getArguments().getString("LIX_KEY", null);
    lixValue = getArguments().getString("LIX_VALUE", null);
    baseUrl = sharedPreferences.getBaseUrl();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968939, paramViewGroup, false);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    paramDialogInterface = new Intent("LIX_DIALOG_DISMISS_EVENT");
    LocalBroadcastManager.getInstance(getContext()).sendBroadcast(paramDialogInterface);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    ButterKnife.inject(this, paramView);
    if (!TextUtils.isEmpty(lixKey))
    {
      lixKeyEditText.setText(lixKey);
      lixKeyEditText.setEnabled(false);
    }
    if (!TextUtils.isEmpty(lixValue)) {
      lixValueEditText.setText(lixValue);
    }
    getDialog().setCanceledOnTouchOutside(true);
  }
  
  public final String pageKey()
  {
    return "";
  }
  
  public final boolean shouldTrackPageView()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.debug.ui.LixOverrideDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */