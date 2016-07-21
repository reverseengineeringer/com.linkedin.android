package com.linkedin.android.identity.me.shared.actorlist;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class MeActorListIntentBuilder
  extends IntentFactory<MeActorListBundleBuilder>
{
  public final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, MeActorListActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.shared.actorlist.MeActorListIntentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */