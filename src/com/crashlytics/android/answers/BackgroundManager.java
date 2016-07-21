package com.crashlytics.android.answers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicReference;

final class BackgroundManager
{
  final AtomicReference<ScheduledFuture<?>> backgroundFutureRef = new AtomicReference();
  final ScheduledExecutorService executorService;
  volatile boolean flushOnBackground = true;
  boolean inBackground = true;
  final List<Listener> listeners = new ArrayList();
  
  public BackgroundManager(ScheduledExecutorService paramScheduledExecutorService)
  {
    executorService = paramScheduledExecutorService;
  }
  
  public static abstract interface Listener
  {
    public abstract void onBackground();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.BackgroundManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */