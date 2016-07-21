package com.linkedin.android.growth.abi;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class AbiIntent
  extends IntentFactory<AbiIntentBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, AbiActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */