package com.linkedin.android.messaging;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class MessagingFragmentFactory
  extends FragmentFactory<MessagingBundleBuilder>
{
  public final Fragment provideFragment()
  {
    return new MessagingFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.MessagingFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */