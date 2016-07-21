package com.linkedin.android.feed.events;

import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class UpdateExpandEvent
{
  public final Update update;
  
  public UpdateExpandEvent(Update paramUpdate)
  {
    update = paramUpdate;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.UpdateExpandEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */