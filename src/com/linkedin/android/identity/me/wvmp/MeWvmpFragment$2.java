package com.linkedin.android.identity.me.wvmp;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.events.ReplayableEventSubscriber;
import com.linkedin.android.infra.events.SettingsChangedEvent;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.Subscribe;

final class MeWvmpFragment$2
  extends ReplayableEventSubscriber<SettingsChangedEvent>
{
  MeWvmpFragment$2(MeWvmpFragment paramMeWvmpFragment, Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public final void consumeEvents$61fb9e66()
  {
    MeWvmpFragment localMeWvmpFragment = (MeWvmpFragment)fragmentWeakReference.get();
    if (localMeWvmpFragment != null)
    {
      this$0.getActivity();
      MeWvmpFragment.access$000$75c16cf9$45dced3b(localMeWvmpFragment);
    }
  }
  
  @Subscribe
  public final void onEvent(SettingsChangedEvent paramSettingsChangedEvent)
  {
    consumeEvent(paramSettingsChangedEvent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmp.MeWvmpFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */