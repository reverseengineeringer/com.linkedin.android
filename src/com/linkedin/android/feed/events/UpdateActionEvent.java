package com.linkedin.android.feed.events;

import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class UpdateActionEvent
{
  public final Update update;
  public final UpdateActionModel updateAction;
  
  public UpdateActionEvent(Update paramUpdate, UpdateActionModel paramUpdateActionModel)
  {
    update = paramUpdate;
    updateAction = paramUpdateActionModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.UpdateActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */