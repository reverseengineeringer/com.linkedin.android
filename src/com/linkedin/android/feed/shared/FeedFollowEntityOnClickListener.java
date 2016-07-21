package com.linkedin.android.feed.shared;

import android.view.View;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;
import java.util.Map;

public class FeedFollowEntityOnClickListener
  extends TrackingOnClickListener
{
  private final String entityUrn;
  private final int followType;
  private final FollowingInfo followingInfo;
  private final WeakReference<FragmentComponent> fragmentComponent;
  
  public FeedFollowEntityOnClickListener(FragmentComponent paramFragmentComponent, int paramInt, String paramString1, FollowingInfo paramFollowingInfo, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString2, paramVarArgs);
    fragmentComponent = new WeakReference(paramFragmentComponent);
    followType = paramInt;
    entityUrn = paramString1;
    followingInfo = paramFollowingInfo;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (followType)
    {
    default: 
      paramView = null;
    }
    for (;;)
    {
      FragmentComponent localFragmentComponent = (FragmentComponent)fragmentComponent.get();
      if ((paramView != null) && (localFragmentComponent != null))
      {
        Map localMap = Tracker.createPageInstanceHeader(localFragmentComponent.tracker().getCurrentPageInstance());
        localFragmentComponent.followPublisher().toggleFollow(entityUrn, paramView, followingInfo, localMap);
      }
      if (followingInfo.hasEntityUrn)
      {
        localFragmentComponent.eventBus();
        Bus.publish(new ClickEvent(19, followingInfo.entityUrn.toString()));
      }
      return;
      paramView = Routes.COMPANY;
      continue;
      paramView = Routes.PROFILE;
      continue;
      paramView = Routes.SCHOOL;
      continue;
      paramView = Routes.GROUP;
      continue;
      paramView = Routes.CHANNELS;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedFollowEntityOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */