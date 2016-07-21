package com.linkedin.android.growth.abi.splash;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import javax.inject.Inject;

public class AbiLearnMoreFragment
  extends PageFragment
{
  @Inject
  FragmentManager fragmentManager;
  @Inject
  FragmentRegistry fragmentRegistry;
  @InjectView(2131755912)
  Toolbar toolbar;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968781, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    fragmentComponent.inject(this);
    super.onViewCreated(paramView, paramBundle);
    toolbar.setNavigationOnClickListener(new TrackingOnClickListener(tracker, "back", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        NavigationUtils.onUpPressed(getActivity(), true);
      }
    });
  }
  
  public final String pageKey()
  {
    return "abi_learn_more";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiLearnMoreFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */