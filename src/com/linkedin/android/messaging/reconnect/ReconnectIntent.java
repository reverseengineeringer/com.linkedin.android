package com.linkedin.android.messaging.reconnect;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class ReconnectIntent
  extends IntentFactory<Object>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ReconnectActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.reconnect.ReconnectIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */