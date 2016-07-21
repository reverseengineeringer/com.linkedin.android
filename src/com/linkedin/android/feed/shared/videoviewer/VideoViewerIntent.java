package com.linkedin.android.feed.shared.videoviewer;

import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class VideoViewerIntent
  extends IntentFactory<VideoViewerBundle>
{
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, VideoViewerActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */