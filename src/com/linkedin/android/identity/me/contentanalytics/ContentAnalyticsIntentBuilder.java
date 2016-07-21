package com.linkedin.android.identity.me.contentanalytics;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class ContentAnalyticsIntentBuilder
  extends IntentFactory<ContentAnalyticsBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ContentAnalyticsActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsIntentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */