package com.linkedin.android.growth.onboarding.rbmf;

import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import javax.inject.Inject;

public final class RebuildMyFeedDataProvider
  extends DataProvider<RebuildMyFeedDataProvider.State, DataProvider.DataProviderListener>
{
  @Inject
  public RebuildMyFeedDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */