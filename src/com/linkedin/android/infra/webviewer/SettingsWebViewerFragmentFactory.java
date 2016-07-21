package com.linkedin.android.infra.webviewer;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class SettingsWebViewerFragmentFactory
  extends FragmentFactory<WebViewerBundle>
{
  protected final Fragment provideFragment()
  {
    return new SettingsWebViewerFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.SettingsWebViewerFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */