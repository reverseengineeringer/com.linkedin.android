package com.linkedin.android.growth.login.prereg.people;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.growth.login.prereg.PreRegPropFragment;
import com.linkedin.android.infra.ViewHolderCreator;

public final class PreRegPeopleFragment
  extends PreRegPropFragment<PreRegPeopleFragmentViewHolder, PreRegPeopleFragmentViewModel>
{
  protected final ViewHolderCreator<PreRegPeopleFragmentViewHolder> getViewHolderCreator()
  {
    return PreRegPeopleFragmentViewHolder.CREATOR;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968861, paramViewGroup, false);
  }
  
  public final String pageKey()
  {
    return "reg_logged_out_people";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.people.PreRegPeopleFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */