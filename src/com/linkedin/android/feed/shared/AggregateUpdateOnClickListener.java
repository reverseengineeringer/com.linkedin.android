package com.linkedin.android.feed.shared;

import android.support.v4.app.Fragment;
import android.view.View;
import com.linkedin.android.feed.aggregate.AggregateBundle;
import com.linkedin.android.feed.aggregate.AggregateIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class AggregateUpdateOnClickListener
  extends TrackingOnClickListener
{
  private final FragmentComponent fragmentComponent;
  private final Update update;
  
  public AggregateUpdateOnClickListener(Update paramUpdate, FragmentComponent paramFragmentComponent, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    update = paramUpdate;
    fragmentComponent = paramFragmentComponent;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = new AggregateBundle(update);
    fragmentComponent.fragment().startActivityForResult(fragmentComponent.intentRegistry().aggregate.newIntent(fragmentComponent.fragment().getActivity(), paramView), 14);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.AggregateUpdateOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */