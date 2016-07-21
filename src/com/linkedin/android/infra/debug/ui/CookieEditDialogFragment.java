package com.linkedin.android.infra.debug.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseDialogFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import java.net.HttpCookie;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public class CookieEditDialogFragment
  extends BaseDialogFragment
{
  private static final long DEFAULT_MAX_AGE = TimeUnit.DAYS.toSeconds(100L);
  private static final String TAG = CookieEditDialogFragment.class.getSimpleName();
  @InjectView(2131756516)
  EditText cookieDomainInput;
  @InjectView(2131756518)
  EditText cookieMaxAgeInput;
  @InjectView(2131756512)
  EditText cookieNameInput;
  @InjectView(2131756514)
  EditText cookieValueInput;
  @InjectView(2131756520)
  Button deleteButton;
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  @InjectView(2131756519)
  Button updateButton;
  
  static CookieEditDialogFragment newInstance(HttpCookie paramHttpCookie)
  {
    CookieEditDialogFragment localCookieEditDialogFragment = new CookieEditDialogFragment();
    Bundle localBundle = new Bundle();
    if (paramHttpCookie != null)
    {
      localBundle.putString("COOKIE_NAME", paramHttpCookie.getName());
      localBundle.putString("COOKIE_VALUE", paramHttpCookie.getValue());
      localBundle.putString("COOKIE_DOMAIN", paramHttpCookie.getDomain());
      localBundle.putLong("COOKIE_MAX_AGE", paramHttpCookie.getMaxAge());
    }
    localCookieEditDialogFragment.setArguments(localBundle);
    return localCookieEditDialogFragment;
  }
  
  private void setDefaults()
  {
    if (TextUtils.isEmpty(cookieDomainInput.getText())) {
      cookieDomainInput.setText(sharedPreferences.getBaseUrl());
    }
    if (TextUtils.isEmpty(cookieMaxAgeInput.getText())) {
      cookieMaxAgeInput.setText(String.valueOf(DEFAULT_MAX_AGE));
    }
  }
  
  static HttpCookie unpack(Intent paramIntent)
  {
    HttpCookie localHttpCookie = new HttpCookie(paramIntent.getStringExtra("COOKIE_NAME"), paramIntent.getStringExtra("COOKIE_VALUE"));
    localHttpCookie.setDomain(paramIntent.getStringExtra("COOKIE_DOMAIN"));
    localHttpCookie.setPath("/");
    localHttpCookie.setMaxAge(paramIntent.getLongExtra("COOKIE_MAX_AGE", DEFAULT_MAX_AGE));
    localHttpCookie.setVersion(0);
    return localHttpCookie;
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968930, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ButterKnife.inject(this, paramView);
    paramBundle = getArguments().getString("COOKIE_NAME");
    String str1 = getArguments().getString("COOKIE_VALUE");
    String str2 = getArguments().getString("COOKIE_DOMAIN");
    long l = getArguments().getLong("COOKIE_MAX_AGE");
    if (paramBundle == null)
    {
      getDialog().setTitle(2131233787);
      paramView.findViewById(2131756520).setVisibility(8);
      setDefaults();
    }
    for (;;)
    {
      updateButton.setOnClickListener(new CookieEditDialogFragment.1(this));
      deleteButton.setOnClickListener(new CookieEditDialogFragment.2(this));
      return;
      getDialog().setTitle(2131233789);
      cookieNameInput.setText(paramBundle);
      cookieValueInput.setText(str1);
      cookieDomainInput.setText(str2);
      cookieMaxAgeInput.setText(String.valueOf(l));
      cookieNameInput.setEnabled(false);
      cookieDomainInput.setEnabled(false);
    }
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
 * Qualified Name:     com.linkedin.android.infra.debug.ui.CookieEditDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */