package com.linkedin.android.identity.profile.view.recentactivity.detail;

import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import javax.inject.Inject;

public final class ProfileSharesFeedDataProvider
  extends FeedUpdatesDataProvider
{
  @Inject
  public ProfileSharesFeedDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileSharesFeedDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */