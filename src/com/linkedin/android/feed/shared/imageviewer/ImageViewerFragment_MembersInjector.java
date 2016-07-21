package com.linkedin.android.feed.shared.imageviewer;

import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ImageViewerFragment_MembersInjector
  implements MembersInjector<ImageViewerFragment>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final Provider<FragmentComponent> fragmentComponentProvider;
  private final Provider<MediaCenter> mediaCenterProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!ImageViewerFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private ImageViewerFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<MediaCenter> paramProvider, Provider<ActivityComponent> paramProvider1, Provider<FragmentComponent> paramProvider2)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    mediaCenterProvider = paramProvider;
    assert (paramProvider1 != null);
    activityComponentProvider = paramProvider1;
    assert (paramProvider2 != null);
    fragmentComponentProvider = paramProvider2;
  }
  
  public static MembersInjector<ImageViewerFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<MediaCenter> paramProvider, Provider<ActivityComponent> paramProvider1, Provider<FragmentComponent> paramProvider2)
  {
    return new ImageViewerFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */