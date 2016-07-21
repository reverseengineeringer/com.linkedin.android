package com.linkedin.android.feed.shared.videoviewer;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class VideoViewerFragmentFactory_Factory
  implements Factory<VideoViewerFragmentFactory>
{
  private final MembersInjector<VideoViewerFragmentFactory> membersInjector;
  
  static
  {
    if (!VideoViewerFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private VideoViewerFragmentFactory_Factory(MembersInjector<VideoViewerFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<VideoViewerFragmentFactory> create(MembersInjector<VideoViewerFragmentFactory> paramMembersInjector)
  {
    return new VideoViewerFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */