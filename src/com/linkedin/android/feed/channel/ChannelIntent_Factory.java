package com.linkedin.android.feed.channel;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class ChannelIntent_Factory
  implements Factory<ChannelIntent>
{
  private final MembersInjector<ChannelIntent> membersInjector;
  
  static
  {
    if (!ChannelIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private ChannelIntent_Factory(MembersInjector<ChannelIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<ChannelIntent> create(MembersInjector<ChannelIntent> paramMembersInjector)
  {
    return new ChannelIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */