package com.linkedin.android.growth.takeover;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class TakeoverIntent
  extends IntentFactory<TakeoverIntentBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, TakeoverActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.TakeoverIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */