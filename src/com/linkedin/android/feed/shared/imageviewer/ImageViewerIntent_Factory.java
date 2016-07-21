package com.linkedin.android.feed.shared.imageviewer;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class ImageViewerIntent_Factory
  implements Factory<ImageViewerIntent>
{
  private final MembersInjector<ImageViewerIntent> membersInjector;
  
  static
  {
    if (!ImageViewerIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private ImageViewerIntent_Factory(MembersInjector<ImageViewerIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<ImageViewerIntent> create(MembersInjector<ImageViewerIntent> paramMembersInjector)
  {
    return new ImageViewerIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */