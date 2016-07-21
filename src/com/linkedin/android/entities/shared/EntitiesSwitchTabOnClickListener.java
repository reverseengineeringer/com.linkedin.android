package com.linkedin.android.entities.shared;

import android.view.View;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.shared.events.EntitiesTabSwitchEvent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class EntitiesSwitchTabOnClickListener
  extends TrackingOnClickListener
{
  private final FragmentComponent fragmentComponent;
  private final EntityPagerAdapter.TabType tabType;
  
  public EntitiesSwitchTabOnClickListener(FragmentComponent paramFragmentComponent, EntityPagerAdapter.TabType paramTabType, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    fragmentComponent = paramFragmentComponent;
    tabType = paramTabType;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    fragmentComponent.eventBus();
    Bus.publish(new EntitiesTabSwitchEvent(tabType));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.EntitiesSwitchTabOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */