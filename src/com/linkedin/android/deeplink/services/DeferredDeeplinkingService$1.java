package com.linkedin.android.deeplink.services;

import android.support.v4.util.Pair;
import com.linkedin.android.deeplink.IDeferredDeeplinkingService.Stub;
import com.linkedin.android.deeplink.helper.DeferredDeeplinkHelper;

final class DeferredDeeplinkingService$1
  extends IDeferredDeeplinkingService.Stub
{
  DeferredDeeplinkingService$1(DeferredDeeplinkingService paramDeferredDeeplinkingService) {}
  
  public final void clearDeferredDeeplink(String paramString)
  {
    if (DeferredDeeplinkingService.verifyCallerSignature(this$0, getCallingUid())) {
      DeferredDeeplinkHelper.getInstance().clearDeferredLink(paramString);
    }
  }
  
  public final String getDeferredDeeplink(String paramString)
  {
    Object localObject2 = null;
    DeferredDeeplinkingService localDeferredDeeplinkingService = this$0;
    Object localObject1 = localObject2;
    if (DeferredDeeplinkingService.verifyCallerSignature(localDeferredDeeplinkingService, getCallingUid()))
    {
      paramString = DeferredDeeplinkHelper.create(localDeferredDeeplinkingService).getLocalDeferredDeeplink(paramString);
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = (String)first;
      }
    }
    return (String)localObject1;
  }
  
  public final long getDeferredDeeplinkTimestamp(String paramString)
  {
    long l2 = 0L;
    DeferredDeeplinkingService localDeferredDeeplinkingService = this$0;
    long l1 = l2;
    if (DeferredDeeplinkingService.verifyCallerSignature(localDeferredDeeplinkingService, getCallingUid()))
    {
      paramString = DeferredDeeplinkHelper.create(localDeferredDeeplinkingService).getLocalDeferredDeeplink(paramString);
      l1 = l2;
      if (paramString != null) {
        l1 = ((Long)second).longValue();
      }
    }
    return l1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.services.DeferredDeeplinkingService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */