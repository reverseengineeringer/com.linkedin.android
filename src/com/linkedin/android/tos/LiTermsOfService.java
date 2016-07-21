package com.linkedin.android.tos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import com.linkedin.android.tos.endpoint.Policy;
import com.linkedin.android.tos.task.ProcessPolicyAsyncTask.ProcessPolicyAsyncTaskInterface;
import java.net.HttpCookie;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LiTermsOfService
  implements LiTermsOfServiceInterface, ProcessPolicyAsyncTask.ProcessPolicyAsyncTaskInterface
{
  private static final String TAG = LiTermsOfService.class.getSimpleName();
  private int mAlertDialogTheme = 5;
  Context mContext;
  private FragmentManager mFragmentManager;
  Host mHost = Host.HOST_EI;
  private LiLogInStateInterface mLiLogInState;
  private BroadcastReceiver mMessageReceiver = new LiTermsOfService.1(this);
  private HttpNetworkInterface mNetworkInterface;
  
  public LiTermsOfService(HttpNetworkInterface paramHttpNetworkInterface, HostInterface paramHostInterface, LiLogInStateInterface paramLiLogInStateInterface, LogInterface paramLogInterface, Context paramContext, FragmentManager paramFragmentManager)
  {
    mNetworkInterface = paramHttpNetworkInterface;
    mContext = paramContext;
    mHost = paramHostInterface.getHost();
    mLiLogInState = paramLiLogInStateInterface;
    mFragmentManager = paramFragmentManager;
    mAlertDialogTheme = 2;
    Log.log = paramLogInterface;
    LocalBroadcastManager.getInstance(mContext).registerReceiver(mMessageReceiver, new IntentFilter("intent_action_for_TOS"));
  }
  
  private String csrfToken()
  {
    String str = null;
    Iterator localIterator = CookieUtils.getCookies(mNetworkInterface.getCookieStore(), mHost.toString()).iterator();
    while (localIterator.hasNext())
    {
      HttpCookie localHttpCookie = (HttpCookie)localIterator.next();
      if (localHttpCookie.getName().equals("JSESSIONID")) {
        str = localHttpCookie.getValue();
      }
    }
    Log.d(TAG, "csrfToken: " + str);
    return str;
  }
  
  private void showTermsOfServiceUpdatedDialog()
  {
    if (mContext == null) {
      throw new IllegalStateException("invalid state. please call init method first.");
    }
    if ((mFragmentManager != null) && (!mFragmentManager.isDestroyed()))
    {
      Object localObject = PreferenceManager.getDefaultSharedPreferences(mContext).edit();
      ((SharedPreferences.Editor)localObject).putLong("tos_shown_timestamp", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).apply();
      reportEventToServer("/psettings/policy/view");
      localObject = new LiTermsOfService.ToSUpdateDialogFragment();
      FragmentTransaction localFragmentTransaction = mFragmentManager.beginTransaction();
      localFragmentTransaction.add((Fragment)localObject, null);
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public final void checkPolicy()
  {
    String str = mHost.toString() + "/psettings/policy";
    mNetworkInterface.get(str, new LiTermsOfService.2(this, str));
  }
  
  public final void onTermsOfServiceUpdated(Policy paramPolicy)
  {
    Object localObject = new Date();
    Date localDate = mEffectiveDate;
    if ((localDate != null) && (localDate.compareTo((Date)localObject) > 0)) {}
    label71:
    do
    {
      return;
      if ((mMember != null) && (!mMember.equalsIgnoreCase("urn:li:member:0"))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label71;
        }
        if (!mShouldDisplay) {
          break;
        }
        showTermsOfServiceUpdatedDialog();
        return;
      }
      paramPolicy = mEffectiveYear + "/" + mEffectiveMonth + "/" + mEffectiveDay;
    } while (paramPolicy.equals(PreferenceManager.getDefaultSharedPreferences(mContext).getString("tos_viewed_version_code", "")));
    localObject = PreferenceManager.getDefaultSharedPreferences(mContext).edit();
    ((SharedPreferences.Editor)localObject).putString("tos_viewed_version_code", paramPolicy);
    ((SharedPreferences.Editor)localObject).apply();
    showTermsOfServiceUpdatedDialog();
  }
  
  final void reportEventToServer(String paramString)
  {
    if (!mLiLogInState.isLoggedInAsLinkedinMember()) {
      return;
    }
    paramString = mHost.toString() + paramString;
    byte[] arrayOfByte = ("policyType=TERMS_AND_CONDITIONS&csrfToken=" + csrfToken()).getBytes();
    mNetworkInterface.post(paramString, "application/x-www-form-urlencoded", arrayOfByte, new LiTermsOfService.3(this, paramString));
  }
  
  public final void unregisterBroadcastReceiver()
  {
    LocalBroadcastManager.getInstance(mContext).unregisterReceiver(mMessageReceiver);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tos.LiTermsOfService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */