package com.linkedin.android.publishing.reader;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class ArticleIntent
  extends IntentFactory<ArticleBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ArticleActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.reader.ArticleIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */