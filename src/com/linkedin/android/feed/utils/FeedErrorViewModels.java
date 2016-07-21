package com.linkedin.android.feed.utils;

import android.content.Context;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;

public final class FeedErrorViewModels
{
  public static void setupFeedRetryErrorViewModel(Context paramContext, ErrorPageViewModel paramErrorPageViewModel, Tracker paramTracker, final Closure<Void, Void> paramClosure)
  {
    if (paramErrorPageViewModel.setupDefaultErrorConfiguration(paramContext, null) == 1)
    {
      errorHeaderText = null;
      errorDescriptionText = paramContext.getString(2131231234);
    }
    errorButtonText = paramContext.getString(2131231235);
    onErrorButtonClick = new TrackingClosure(paramTracker, "retry") {};
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedErrorViewModels
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */