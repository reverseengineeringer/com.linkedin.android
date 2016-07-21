package com.linkedin.android.feed.shared.imageviewer;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class ImageViewerFragmentFactory_Factory
  implements Factory<ImageViewerFragmentFactory>
{
  private final MembersInjector<ImageViewerFragmentFactory> membersInjector;
  
  static
  {
    if (!ImageViewerFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private ImageViewerFragmentFactory_Factory(MembersInjector<ImageViewerFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<ImageViewerFragmentFactory> create(MembersInjector<ImageViewerFragmentFactory> paramMembersInjector)
  {
    return new ImageViewerFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */