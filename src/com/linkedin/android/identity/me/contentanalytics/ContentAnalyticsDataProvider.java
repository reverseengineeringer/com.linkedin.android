package com.linkedin.android.identity.me.contentanalytics;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.shared.Routes;
import javax.inject.Inject;

public class ContentAnalyticsDataProvider
  extends DataProvider<ContentAnalyticsDataProvider.ContentAnalyticsState, DataProvider.DataProviderListener>
{
  static final Uri CONTENT_ANALYTICS_HEADER_ROUTE = Routes.ME_CONTENT_ANALYTICS_HEADER.buildUponRoot();
  static final Uri CONTENT_ANALYTICS_HIGHLIGHTS_ROUTE = Routes.ME_CONTENT_ANALYTICS_HIGHLIGHTS.buildUponRoot().buildUpon().appendQueryParameter("q", "socialUpdateAnalytics").build();
  public static final String TAG = ContentAnalyticsDataProvider.class.getSimpleName();
  
  @Inject
  public ContentAnalyticsDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */