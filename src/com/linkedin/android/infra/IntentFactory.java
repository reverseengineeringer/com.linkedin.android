package com.linkedin.android.infra;

import android.content.Context;
import android.content.Intent;

public abstract class IntentFactory<B extends BundleBuilder>
{
  public Intent newIntent(Context paramContext, B paramB)
  {
    paramContext = provideIntent(paramContext);
    if (paramB != null) {
      paramContext.putExtras(paramB.build());
    }
    return paramContext;
  }
  
  public abstract Intent provideIntent(Context paramContext);
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.IntentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */