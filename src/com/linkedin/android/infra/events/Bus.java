package com.linkedin.android.infra.events;

import android.os.Handler;
import android.os.Looper;
import com.linkedin.android.infra.shared.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusBuilder;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.SubscriberMethodFinder;
import org.greenrobot.eventbus.SubscriberMethodFinder.FindState;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

public final class Bus
{
  private static final EventBus EVENT_BUS;
  private final Handler mainHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    EventBusBuilder localEventBusBuilder = EventBus.builder();
    throwSubscriberException = false;
    EVENT_BUS = new EventBus(localEventBusBuilder);
  }
  
  public static <T> T getAndClearStickyEvent(Class<T> paramClass)
  {
    paramClass = EVENT_BUS.getStickyEvent(paramClass);
    if (paramClass != null) {
      EVENT_BUS.removeStickyEvent(paramClass);
    }
    return paramClass;
  }
  
  public static <T> T getStickyEvent(Class<T> paramClass)
  {
    return (T)EVENT_BUS.getStickyEvent(paramClass);
  }
  
  public static boolean isSubscribed(Object paramObject)
  {
    return EVENT_BUS.isRegistered(paramObject);
  }
  
  public static void publish(Object paramObject)
  {
    EVENT_BUS.post(paramObject);
  }
  
  public static void publishStickyEvent(Object paramObject)
  {
    EventBus localEventBus = EVENT_BUS;
    synchronized (stickyEvents)
    {
      stickyEvents.put(paramObject.getClass(), paramObject);
      localEventBus.post(paramObject);
      return;
    }
  }
  
  public static void subscribe(Object paramObject)
  {
    EventBus localEventBus = EVENT_BUS;
    Class localClass = paramObject.getClass();
    SubscriberMethodFinder localSubscriberMethodFinder = subscriberMethodFinder;
    Object localObject1 = (List)SubscriberMethodFinder.METHOD_CACHE.get(localClass);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localEventBus.subscribe(paramObject, (SubscriberMethod)((Iterator)localObject1).next());
        }
        if (!ignoreGeneratedIndex) {
          break label161;
        }
      }
      finally {}
      localObject1 = SubscriberMethodFinder.prepareFindState();
      ((SubscriberMethodFinder.FindState)localObject1).initForSubscriber(localClass);
      while (clazz != null)
      {
        localSubscriberMethodFinder.findUsingReflectionInSingleClass((SubscriberMethodFinder.FindState)localObject1);
        ((SubscriberMethodFinder.FindState)localObject1).moveToSuperclass();
      }
      label161:
      SubscriberMethodFinder.FindState localFindState;
      for (localObject1 = SubscriberMethodFinder.getMethodsAndRelease((SubscriberMethodFinder.FindState)localObject1); ((List)localObject1).isEmpty(); localObject1 = SubscriberMethodFinder.getMethodsAndRelease(localFindState))
      {
        throw new EventBusException("Subscriber " + localClass + " and its super classes have no public methods with the @Subscribe annotation");
        localFindState = SubscriberMethodFinder.prepareFindState();
        localFindState.initForSubscriber(localClass);
        while (clazz != null)
        {
          if ((subscriberInfo != null) && (subscriberInfo.getSuperSubscriberInfo() != null))
          {
            localObject1 = subscriberInfo.getSuperSubscriberInfo();
            if (clazz != ((SubscriberInfo)localObject1).getSubscriberClass()) {}
          }
          for (;;)
          {
            subscriberInfo = ((SubscriberInfo)localObject1);
            if (subscriberInfo == null) {
              break;
            }
            localObject1 = subscriberInfo.getSubscriberMethods();
            int j = localObject1.length;
            int i = 0;
            Object localObject2;
            while (i < j)
            {
              localObject2 = localObject1[i];
              if (localFindState.checkAdd(method, eventType)) {
                subscriberMethods.add(localObject2);
              }
              i += 1;
            }
            if (subscriberInfoIndexes != null)
            {
              localObject2 = subscriberInfoIndexes.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  localObject1 = ((SubscriberInfoIndex)((Iterator)localObject2).next()).getSubscriberInfo$7d6fca3b();
                  if (localObject1 != null) {
                    break;
                  }
                }
              }
            }
            localObject1 = null;
          }
          localSubscriberMethodFinder.findUsingReflectionInSingleClass(localFindState);
          localFindState.moveToSuperclass();
        }
      }
      SubscriberMethodFinder.METHOD_CACHE.put(localClass, localObject1);
    }
  }
  
  public static void unsubscribe(Object paramObject)
  {
    if (paramObject == null)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("subscriber is null"));
      return;
    }
    EVENT_BUS.unregister(paramObject);
  }
  
  public final void publishInMainThread(Object paramObject)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      EVENT_BUS.post(paramObject);
      return;
    }
    mainHandler.post(new Bus.1(this, paramObject));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.events.Bus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */