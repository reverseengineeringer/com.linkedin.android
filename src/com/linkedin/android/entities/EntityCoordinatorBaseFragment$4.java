package com.linkedin.android.entities;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class EntityCoordinatorBaseFragment$4
  extends TrackingOnClickListener
{
  EntityCoordinatorBaseFragment$4(EntityCoordinatorBaseFragment paramEntityCoordinatorBaseFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (this$0.isDetached()) {
      return;
    }
    paramView = this$0.fragmentComponent.intentRegistry().search.newIntent(this$0.getActivity(), SearchBundleBuilder.create().setQueryString(this$0.searchBarText.getText().toString()));
    this$0.getActivity().startActivity(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityCoordinatorBaseFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */