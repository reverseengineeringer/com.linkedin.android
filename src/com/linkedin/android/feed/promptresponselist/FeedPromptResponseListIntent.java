package com.linkedin.android.feed.promptresponselist;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class FeedPromptResponseListIntent
  extends IntentFactory<PromptResponseListBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, FeedPromptResponseListActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */