package com.linkedin.android.growth.login.phoneverification;

import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.app.BaseActivity;
import javax.inject.Inject;

public final class CountrySelectorManager
{
  final BaseActivity activity;
  
  @Inject
  public CountrySelectorManager(BaseActivity paramBaseActivity)
  {
    activity = paramBaseActivity;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.CountrySelectorManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */