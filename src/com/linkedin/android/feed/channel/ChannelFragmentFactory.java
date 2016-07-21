package com.linkedin.android.feed.channel;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class ChannelFragmentFactory
  extends FragmentFactory<ChannelBundle>
{
  protected final Fragment provideFragment()
  {
    return new ChannelFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */