package com.linkedin.android.feed.followhub;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class FollowHubIntent
  extends IntentFactory<FollowHubBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, FollowHubActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */