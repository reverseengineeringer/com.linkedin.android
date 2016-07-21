package com.linkedin.android.feed.shared.imageviewer;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class ImageViewerFragment$6
  extends TrackingOnClickListener
{
  ImageViewerFragment$6(ImageViewerFragment paramImageViewerFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = this$0.fragmentComponent.intentRegistry().home;
    FragmentActivity localFragmentActivity = this$0.getActivity();
    HomeBundle localHomeBundle = new HomeBundle();
    activeTab = HomeTabInfo.NOTIFICATIONS;
    paramView = paramView.newIntent(localFragmentActivity, localHomeBundle);
    NavigationUtils.navigateUp(this$0.getActivity(), paramView, true);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */