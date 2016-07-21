package com.linkedin.android.entities.shared.events;

import com.linkedin.android.entities.EntityPagerAdapter.TabType;

public final class EntitiesTabSwitchEvent
{
  public EntityPagerAdapter.TabType tabType;
  
  public EntitiesTabSwitchEvent(EntityPagerAdapter.TabType paramTabType)
  {
    tabType = paramTabType;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.events.EntitiesTabSwitchEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */