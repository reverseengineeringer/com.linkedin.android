package com.linkedin.android.feed.updates.common.comment.detail;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class CommentDetailFragmentFactory
  extends FragmentFactory<CommentDetailBundleBuilder>
{
  public final Fragment provideFragment()
  {
    return new CommentDetailFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */