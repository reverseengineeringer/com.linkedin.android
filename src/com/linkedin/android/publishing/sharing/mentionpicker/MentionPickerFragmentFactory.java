package com.linkedin.android.publishing.sharing.mentionpicker;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class MentionPickerFragmentFactory
  extends FragmentFactory<MentionPickerBundle>
{
  protected final Fragment provideFragment()
  {
    return new MentionPickerFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */