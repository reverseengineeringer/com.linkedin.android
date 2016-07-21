package com.linkedin.android.feed.followhub;

import android.content.Context;
import android.view.View;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedToFollowHubOnClickListener
  extends TrackingOnClickListener
{
  private FragmentComponent fragmentComponent;
  
  public FeedToFollowHubOnClickListener(FragmentComponent paramFragmentComponent, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    fragmentComponent = paramFragmentComponent;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = FollowHubBundleBuilder.createBundle();
    paramView = fragmentComponent.intentRegistry().followHubIntent.newIntent(fragmentComponent.activity(), paramView);
    fragmentComponent.context().startActivity(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FeedToFollowHubOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */