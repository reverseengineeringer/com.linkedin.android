package com.linkedin.android.feed.actions;

import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.view.View;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.spans.TrackingClickableSpan;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.lang.ref.WeakReference;
import java.util.Map;

public class UndoRemovalClickableSpan
  extends TrackingClickableSpan
{
  private int color;
  private final WeakReference<FragmentComponent> fragmentComponentRef;
  private Update update;
  private UpdateActionModel updateAction;
  
  public UndoRemovalClickableSpan(FragmentComponent paramFragmentComponent, Update paramUpdate, UpdateActionModel paramUpdateActionModel, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    fragmentComponentRef = new WeakReference(paramFragmentComponent);
    update = paramUpdate;
    updateAction = paramUpdateActionModel;
    color = ContextCompat.getColor(paramFragmentComponent.context(), 2131623998);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = (FragmentComponent)fragmentComponentRef.get();
    if (paramView != null)
    {
      Map localMap = Tracker.createPageInstanceHeader(paramView.tracker().getCurrentPageInstance());
      UpdateActionPublisher.handleUndoRemovalAction(paramView, update, updateAction, localMap);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(color);
    paramTextPaint.setUnderlineText(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.UndoRemovalClickableSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */