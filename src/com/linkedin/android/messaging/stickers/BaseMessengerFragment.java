package com.linkedin.android.messaging.stickers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.messaging.integration.MessagingDrawableResourcesProvider;
import com.linkedin.android.messaging.integration.MessagingLixManagerProvider;
import com.linkedin.android.messaging.integration.MessengerCrashReporterDelegate;
import com.linkedin.messengerlib.MessengerDrawableResources;
import com.linkedin.messengerlib.MessengerHostBridge;
import com.linkedin.messengerlib.MessengerLixManager;
import com.linkedin.messengerlib.crashes.MessengerCrashReporter;

public abstract class BaseMessengerFragment
  extends PageFragment
  implements MessengerHostBridge
{
  public MessengerDrawableResources drawableResources = new MessagingDrawableResourcesProvider();
  public MessengerLixManager lixManager;
  
  public final MessengerDrawableResources getDrawableResources()
  {
    return drawableResources;
  }
  
  public final MessengerLixManager getLixManager()
  {
    return lixManager;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    lixManager = new MessagingLixManagerProvider(applicationComponent);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    getCrashReportercrashReporterDelegate = new MessengerCrashReporterDelegate();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.stickers.BaseMessengerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */