package com.linkedin.android.feed.shared.videoviewer;

import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.network.MediaCenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class VideoViewerFragment_MembersInjector
  implements MembersInjector<VideoViewerFragment>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final Provider<MediaCenter> mediaCenterProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!VideoViewerFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private VideoViewerFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<MediaCenter> paramProvider, Provider<ActivityComponent> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    mediaCenterProvider = paramProvider;
    assert (paramProvider1 != null);
    activityComponentProvider = paramProvider1;
  }
  
  public static MembersInjector<VideoViewerFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<MediaCenter> paramProvider, Provider<ActivityComponent> paramProvider1)
  {
    return new VideoViewerFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */