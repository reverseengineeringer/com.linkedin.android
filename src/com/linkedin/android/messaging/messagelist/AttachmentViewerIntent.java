package com.linkedin.android.messaging.messagelist;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class AttachmentViewerIntent
  extends IntentFactory<AttachmentViewerBundleBuilder>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, AttachmentViewerActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.AttachmentViewerIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */