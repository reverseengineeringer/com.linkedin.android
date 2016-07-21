package com.linkedin.android.feed.actions;

import android.view.View;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedToggleCommentOrderingDialogOnClickListener
  extends TrackingOnClickListener
{
  private FragmentComponent fragmentComponent;
  private SortOrder sortOrder;
  private TrackingData trackingData;
  private Urn updateUrn;
  
  public FeedToggleCommentOrderingDialogOnClickListener(FragmentComponent paramFragmentComponent, TrackingData paramTrackingData, Urn paramUrn, SortOrder paramSortOrder, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    fragmentComponent = paramFragmentComponent;
    trackingData = paramTrackingData;
    updateUrn = paramUrn;
    sortOrder = paramSortOrder;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    new FeedToggleCommentOrderingDialog(fragmentComponent, trackingData, updateUrn, sortOrder).show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.FeedToggleCommentOrderingDialogOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */