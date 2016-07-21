package com.linkedin.android.identity.me.shared.profilehost;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class MeProfileHostIntentBuilder
  extends IntentFactory<MeProfileHostBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, MeProfileHostActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.shared.profilehost.MeProfileHostIntentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */