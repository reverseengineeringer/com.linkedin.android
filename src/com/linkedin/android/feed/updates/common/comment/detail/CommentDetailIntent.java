package com.linkedin.android.feed.updates.common.comment.detail;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.feed.detail.FeedUpdateDetailActivity;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class CommentDetailIntent
  extends IntentFactory<CommentDetailBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, FeedUpdateDetailActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */