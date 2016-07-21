package com.linkedin.android.identity.me.notifications;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class NotificationsFragmentFactory
  extends FragmentFactory<NotificationsBundleBuilder>
{
  protected final Fragment provideFragment()
  {
    return new NotificationsFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.NotificationsFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */