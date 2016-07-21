package com.linkedin.android.feed.shared.videoviewer;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class VideoViewerIntent_Factory
  implements Factory<VideoViewerIntent>
{
  private final MembersInjector<VideoViewerIntent> membersInjector;
  
  static
  {
    if (!VideoViewerIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private VideoViewerIntent_Factory(MembersInjector<VideoViewerIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<VideoViewerIntent> create(MembersInjector<VideoViewerIntent> paramMembersInjector)
  {
    return new VideoViewerIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */