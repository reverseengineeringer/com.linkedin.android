package com.linkedin.messengerlib.shared;

import android.app.Activity;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.utils.I18NManager;

public abstract interface BaseFragment$BaseFragmentApi
{
  public abstract Activity getActivity();
  
  public abstract I18NManager getI18nManager();
  
  public abstract MessengerLibApi getMessengerLibApi();
  
  public abstract void showLongSnackbar(String paramString);
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.shared.BaseFragment.BaseFragmentApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */