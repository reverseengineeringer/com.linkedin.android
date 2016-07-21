package com.linkedin.android.feed.shared.videoviewer;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class VideoViewerBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  private VideoViewerBundle(String paramString1, String paramString2, String paramString3)
  {
    bundle.putString("url", paramString1);
    bundle.putString("title", paramString2);
    bundle.putString("subtitle", paramString3);
  }
  
  public static VideoViewerBundle create(String paramString1, String paramString2, String paramString3)
  {
    return new VideoViewerBundle(paramString1, paramString2, paramString3);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */