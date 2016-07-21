package com.linkedin.android.growth.newtovoyager.organic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.infra.ViewHolderCreator;

public final class NewToVoyagerIntroWelcomeFragment
  extends NewToVoyagerIntroBaseFragment<NewToVoyagerIntroWelcomeFragmentViewHolder, NewToVoyagerIntroWelcomeFragmentViewModel>
{
  protected final ViewHolderCreator<NewToVoyagerIntroWelcomeFragmentViewHolder> getViewHolderCreator()
  {
    return NewToVoyagerIntroWelcomeFragmentViewHolder.CREATOR;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968821, paramViewGroup, false);
  }
  
  public final String pageKey()
  {
    return "onboarding_new_to_voyager_intro";
  }
  
  public static final class NewToVoyagerSkipEvent {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroWelcomeFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */