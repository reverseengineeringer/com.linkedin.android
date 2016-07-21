package com.linkedin.android.relationships.meetings;

import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import javax.inject.Inject;

public final class MeetingDetailsDataProvider
  extends DataProvider<MeetingDetailsDataProvider.State, DataProvider.DataProviderListener>
{
  @Inject
  public MeetingDetailsDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.meetings.MeetingDetailsDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */