package com.linkedin.android.feed.aggregate;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class AggregateIntent
  extends IntentFactory<AggregateBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, AggregateActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */