package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.RetryState;

final class RetryManager
{
  long lastRetry;
  RetryState retryState;
  
  public RetryManager(RetryState paramRetryState)
  {
    retryState = paramRetryState;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.RetryManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */