package com.linkedin.android.identity.me.wvmp.privatemode;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class MeWvmpPrivateModeIntentBuilder
  extends IntentFactory<MeWvmpPrivateModeBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, MeWvmpPrivateModeActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmp.privatemode.MeWvmpPrivateModeIntentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */