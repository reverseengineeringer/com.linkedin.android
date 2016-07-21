package com.linkedin.android.deeplink.helper;

import com.linkedin.android.deeplink.services.DeferredDeeplinkingServiceBindingListener;

final class DeferredDeeplinkHelper$1
  implements DeferredDeeplinkingServiceBindingListener
{
  DeferredDeeplinkHelper$1(DeferredDeeplinkHelper paramDeferredDeeplinkHelper, String paramString, DeferredDeeplinkingServiceBindingListener paramDeferredDeeplinkingServiceBindingListener) {}
  
  public final void onBindSuccess()
  {
    DeferredDeeplinkHelper.access$010(this$0);
    if (DeferredDeeplinkHelper.access$100(this$0)) {
      this$0.doUnbindService(val$packageName);
    }
    while (DeferredDeeplinkHelper.access$000(this$0) != 0) {
      return;
    }
    val$listener.onBindSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.helper.DeferredDeeplinkHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */