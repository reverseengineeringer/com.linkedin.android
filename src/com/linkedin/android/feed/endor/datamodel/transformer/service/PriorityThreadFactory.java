package com.linkedin.android.feed.endor.datamodel.transformer.service;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class PriorityThreadFactory
  implements ThreadFactory
{
  private final ThreadGroup group;
  private final String namePrefix;
  private final int priority;
  private final AtomicInteger threadNumber = new AtomicInteger(1);
  
  public PriorityThreadFactory(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      group = ((ThreadGroup)localObject);
      namePrefix = (paramString + "-thread-");
      priority = 10;
      return;
    }
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(group, paramRunnable, namePrefix + threadNumber.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != priority) {
      paramRunnable.setPriority(priority);
    }
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.service.PriorityThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */