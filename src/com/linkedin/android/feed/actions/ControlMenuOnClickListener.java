package com.linkedin.android.feed.actions;

import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.List;

public final class ControlMenuOnClickListener
  extends TrackingOnClickListener
{
  public List<UpdateActionModel> actionList;
  private DialogInterface.OnDismissListener dismissListener;
  private final FragmentComponent fragmentComponent;
  public Update update;
  
  public ControlMenuOnClickListener(Update paramUpdate, List<UpdateActionModel> paramList, FragmentComponent paramFragmentComponent, DialogInterface.OnDismissListener paramOnDismissListener, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    actionList = paramList;
    fragmentComponent = paramFragmentComponent;
    dismissListener = paramOnDismissListener;
    update = paramUpdate;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (actionList.isEmpty()) {
      return;
    }
    paramView = new ControlPanelDialog.OnActionItemClickListener() {};
    ControlPanelDialog localControlPanelDialog = new ControlPanelDialog(fragmentComponent);
    update = update;
    paramView = localControlPanelDialog.setUpdateActions(actionList).setOnActionItemClickListener(paramView);
    paramView.setOnDismissListener(dismissListener);
    paramView.show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.ControlMenuOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */