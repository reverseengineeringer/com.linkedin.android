package com.linkedin.android.search.resourcelist;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class ResourceListIntent
  extends IntentFactory<ResourceListBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ResourceListActivity.class).setFlags(536870912);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.resourcelist.ResourceListIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */