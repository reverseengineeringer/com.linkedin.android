package com.crashlytics.android.answers;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class BackgroundManager$1
  implements Runnable
{
  BackgroundManager$1(BackgroundManager paramBackgroundManager) {}
  
  public final void run()
  {
    this$0.backgroundFutureRef.set(null);
    Iterator localIterator = this$0.listeners.iterator();
    while (localIterator.hasNext()) {
      ((BackgroundManager.Listener)localIterator.next()).onBackground();
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.BackgroundManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */