package com.linkedin.android.growth.newtovoyager.organic;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class NewToVoyagerIntroIntent
  extends IntentFactory<NewToVoyagerIntroBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, NewToVoyagerIntroActivity.class).setFlags(536936448);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */