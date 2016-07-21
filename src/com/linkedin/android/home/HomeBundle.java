package com.linkedin.android.home;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;

public class HomeBundle
  implements BundleBuilder
{
  public HomeTabInfo activeTab = HomeTabInfo.getDefault();
  public BundleBuilder activeTabBundleBuilder;
  
  public static HomeTabInfo getActiveTab(FlagshipSharedPreferences paramFlagshipSharedPreferences, Bundle paramBundle)
  {
    paramFlagshipSharedPreferences = paramFlagshipSharedPreferences.getLastActiveTab();
    if (paramBundle == null) {
      return paramFlagshipSharedPreferences;
    }
    return HomeTabInfo.tabForId(paramBundle.getInt("activeTab", HomeTabInfo.idForTab(paramFlagshipSharedPreferences)));
  }
  
  public static Bundle getActiveTabBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getBundle("activeTabBundle");
    }
    return null;
  }
  
  public Bundle build()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("activeTab", HomeTabInfo.idForTab(activeTab));
    if (activeTabBundleBuilder != null) {
      localBundle.putBundle("activeTabBundle", activeTabBundleBuilder.build());
    }
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.home.HomeBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */