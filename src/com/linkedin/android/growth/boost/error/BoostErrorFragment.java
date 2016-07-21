package com.linkedin.android.growth.boost.error;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import javax.inject.Inject;

public final class BoostErrorFragment
  extends PageFragment
{
  @Inject
  IntentRegistry intentRegistry;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968803, paramViewGroup, false);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    paramView = (BoostErrorFragmentViewHolder)BoostErrorFragmentViewHolder.CREATOR.createViewHolder(paramView);
    paramBundle = new BoostErrorFragmentViewModel();
    continueListener = new TrackingOnClickListener(tracker, "continue", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        startActivity(intentRegistry.home.newIntent(getActivity(), new HomeBundle()));
      }
    };
    getLayoutInflater(null);
    fragmentComponent.mediaCenter();
    paramBundle.onBindViewHolder$6245ffb7(paramView);
  }
  
  public final String pageKey()
  {
    return "boost_error";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.error.BoostErrorFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */