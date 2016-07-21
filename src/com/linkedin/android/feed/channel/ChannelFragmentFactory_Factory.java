package com.linkedin.android.feed.channel;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class ChannelFragmentFactory_Factory
  implements Factory<ChannelFragmentFactory>
{
  private final MembersInjector<ChannelFragmentFactory> membersInjector;
  
  static
  {
    if (!ChannelFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private ChannelFragmentFactory_Factory(MembersInjector<ChannelFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<ChannelFragmentFactory> create(MembersInjector<ChannelFragmentFactory> paramMembersInjector)
  {
    return new ChannelFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */