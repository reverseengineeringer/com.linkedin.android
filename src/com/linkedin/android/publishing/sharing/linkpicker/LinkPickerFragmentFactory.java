package com.linkedin.android.publishing.sharing.linkpicker;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class LinkPickerFragmentFactory
  extends FragmentFactory<LinkPickerBundle>
{
  protected final Fragment provideFragment()
  {
    return new LinkPickerFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.linkpicker.LinkPickerFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */