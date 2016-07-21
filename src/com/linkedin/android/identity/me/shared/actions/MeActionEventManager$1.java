package com.linkedin.android.identity.me.shared.actions;

import com.linkedin.android.identity.me.shared.actions.events.MeActionEvent;
import org.greenrobot.eventbus.Subscribe;

final class MeActionEventManager$1
{
  MeActionEventManager$1(MeActionEventManager paramMeActionEventManager) {}
  
  @Subscribe
  public final void onEvent(MeActionEvent paramMeActionEvent)
  {
    this$0.handleActionEvent(paramMeActionEvent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.shared.actions.MeActionEventManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */