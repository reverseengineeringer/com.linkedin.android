package com.linkedin.android.infra.webviewer;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class WebViewerIntent
  extends IntentFactory<WebViewerBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, WebViewerActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.WebViewerIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */