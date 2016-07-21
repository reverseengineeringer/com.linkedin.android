package com.crashlytics.android.core;

import java.util.concurrent.CountDownLatch;

final class CrashlyticsCore$OptInLatch
{
  final CountDownLatch latch = new CountDownLatch(1);
  boolean send = false;
  
  final void setOptIn(boolean paramBoolean)
  {
    send = paramBoolean;
    latch.countDown();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.OptInLatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */