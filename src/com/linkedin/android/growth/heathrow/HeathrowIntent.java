package com.linkedin.android.growth.heathrow;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class HeathrowIntent
  extends IntentFactory<HeathrowRoutingIntentBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, HeathrowRoutingActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */