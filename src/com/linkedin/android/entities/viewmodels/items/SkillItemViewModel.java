package com.linkedin.android.entities.viewmodels.items;

import com.linkedin.android.entities.viewholders.SkillItemViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class SkillItemViewModel
  extends ViewModel<SkillItemViewHolder>
{
  public String name;
  public boolean sharedSkill;
  
  public final ViewHolderCreator<SkillItemViewHolder> getCreator()
  {
    return SkillItemViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.SkillItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */