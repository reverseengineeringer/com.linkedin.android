package com.linkedin.android.publishing.reader;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class ArticleFragmentFactory
  extends FragmentFactory<ArticleBundle>
{
  protected final Fragment provideFragment()
  {
    return new SocialReaderFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.reader.ArticleFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */