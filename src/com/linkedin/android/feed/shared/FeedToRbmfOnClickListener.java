package com.linkedin.android.feed.shared;

import android.content.Context;
import android.view.View;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedBundleBuilder;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedToRbmfOnClickListener
  extends TrackingOnClickListener
{
  private FragmentComponent fragmentComponent;
  private int rbmfOrigin;
  
  public FeedToRbmfOnClickListener(FragmentComponent paramFragmentComponent, String paramString, int paramInt, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    fragmentComponent = paramFragmentComponent;
    rbmfOrigin = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = RebuildMyFeedBundleBuilder.createBundle(true).setRbmfOrigin(rbmfOrigin);
    paramView = fragmentComponent.intentRegistry().rebuildMyFeedIntent.newIntent(fragmentComponent.activity(), paramView);
    fragmentComponent.context().startActivity(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedToRbmfOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */