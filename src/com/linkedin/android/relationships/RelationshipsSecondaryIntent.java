package com.linkedin.android.relationships;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class RelationshipsSecondaryIntent
  extends IntentFactory<RelationshipsSecondaryBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, RelationshipsSecondaryActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.RelationshipsSecondaryIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */