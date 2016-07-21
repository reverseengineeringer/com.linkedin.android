package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryState;
import io.fabric.sdk.android.services.events.FilesSender;
import java.io.File;
import java.util.List;

final class AnswersRetryFilesSender
  implements FilesSender
{
  private final SessionAnalyticsFilesSender filesSender;
  private final RetryManager retryManager;
  
  AnswersRetryFilesSender(SessionAnalyticsFilesSender paramSessionAnalyticsFilesSender, RetryManager paramRetryManager)
  {
    filesSender = paramSessionAnalyticsFilesSender;
    retryManager = paramRetryManager;
  }
  
  public final boolean send(List<File> paramList)
  {
    long l1 = System.nanoTime();
    Object localObject = retryManager;
    RetryState localRetryState = retryState;
    long l2 = backoff.getDelayMillis(retryCount);
    int i;
    if (l1 - lastRetry >= 1000000L * l2) {
      i = 1;
    }
    while (i != 0) {
      if (filesSender.send(paramList))
      {
        paramList = retryManager;
        lastRetry = 0L;
        localObject = retryState;
        retryState = new RetryState(backoff, retryPolicy);
        return true;
        i = 0;
      }
      else
      {
        paramList = retryManager;
        lastRetry = l1;
        localObject = retryState;
        retryState = new RetryState(retryCount + 1, backoff, retryPolicy);
        return false;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersRetryFilesSender
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */