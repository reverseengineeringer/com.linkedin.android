package com.linkedin.android.growth.onboarding;

import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.DataProvider;

final class OnboardingDataProvider$1
  implements RecordTemplateListener
{
  OnboardingDataProvider$1(OnboardingDataProvider paramOnboardingDataProvider, String paramString) {}
  
  public final void onResponse(DataStoreResponse paramDataStoreResponse)
  {
    int j = 0;
    if ((error == null) && (request != null) && (request.url != null) && (model != null)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ((OnboardingDataProvider.OnboardingState)this$0.state).setModel(request.url, model, "");
      return;
    }
    paramDataStoreResponse = val$widgetId;
    switch (paramDataStoreResponse.hashCode())
    {
    }
    for (i = -1;; i = j)
    {
      switch (i)
      {
      default: 
        return;
      }
      this$0.fetchCountries(null, DataManager.DataStoreFilter.NETWORK_ONLY);
      return;
      if (!paramDataStoreResponse.equals("voyager_onboarding_profile_edit_location")) {
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingDataProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */