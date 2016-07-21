package com.linkedin.android.infra.modules;

import android.support.v4.app.Fragment;
import dagger.Module;
import dagger.Provides;

@Module
public final class FragmentModule
{
  private Fragment fragment;
  
  public FragmentModule(Fragment paramFragment)
  {
    fragment = paramFragment;
  }
  
  @Provides
  public final Fragment provideFragment()
  {
    return fragment;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.modules.FragmentModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */