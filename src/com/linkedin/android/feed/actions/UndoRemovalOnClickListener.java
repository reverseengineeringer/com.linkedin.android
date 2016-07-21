package com.linkedin.android.feed.actions;

import android.view.View;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class UndoRemovalOnClickListener
  extends TrackingOnClickListener
{
  private final WeakReference<FragmentComponent> fragmentComponentRef;
  private Update update;
  private UpdateActionModel updateAction;
  
  public UndoRemovalOnClickListener(FragmentComponent paramFragmentComponent, Update paramUpdate, UpdateActionModel paramUpdateActionModel, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    fragmentComponentRef = new WeakReference(paramFragmentComponent);
    update = paramUpdate;
    updateAction = paramUpdateActionModel;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = (FragmentComponent)fragmentComponentRef.get();
    if (paramView != null)
    {
      Map localMap = Tracker.createPageInstanceHeader(paramView.tracker().getCurrentPageInstance());
      UpdateActionPublisher.handleUndoRemovalAction(paramView, update, updateAction, localMap);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.UndoRemovalOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */