package com.linkedin.android.feed.channel;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class ChannelIntent
  extends IntentFactory<ChannelBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ChannelActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */