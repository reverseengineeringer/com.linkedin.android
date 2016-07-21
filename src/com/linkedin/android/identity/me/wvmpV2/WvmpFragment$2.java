package com.linkedin.android.identity.me.wvmpV2;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.events.ReplayableEventSubscriber;
import com.linkedin.android.infra.events.SettingsChangedEvent;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.Subscribe;

final class WvmpFragment$2
  extends ReplayableEventSubscriber<SettingsChangedEvent>
{
  WvmpFragment$2(WvmpFragment paramWvmpFragment, Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public final void consumeEvents$61fb9e66()
  {
    WvmpFragment localWvmpFragment = (WvmpFragment)fragmentWeakReference.get();
    if (localWvmpFragment != null)
    {
      this$0.getActivity();
      WvmpFragment.access$000$3ec57a73$69547227(localWvmpFragment);
    }
  }
  
  @Subscribe
  public final void onEvent(SettingsChangedEvent paramSettingsChangedEvent)
  {
    consumeEvent(paramSettingsChangedEvent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmpV2.WvmpFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */