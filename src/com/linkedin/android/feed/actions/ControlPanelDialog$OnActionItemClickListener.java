package com.linkedin.android.feed.actions;

import com.linkedin.android.feed.viewmodels.models.BaseActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public abstract interface ControlPanelDialog$OnActionItemClickListener<T extends BaseActionModel>
{
  public abstract void onActionPerformed$23f734e3(Update paramUpdate, T paramT);
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.ControlPanelDialog.OnActionItemClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */