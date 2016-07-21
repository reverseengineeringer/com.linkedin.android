package com.linkedin.android.feed.actions;

import android.content.DialogInterface;
import com.linkedin.android.feed.events.FeedToggleCommentOrderingEvent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;

public final class FeedToggleCommentOrderingDialog
  extends BaseFeedToggleOrderingDialog
{
  public FeedToggleCommentOrderingDialog(FragmentComponent paramFragmentComponent, TrackingData paramTrackingData, Urn paramUrn, SortOrder paramSortOrder)
  {
    super(paramFragmentComponent, paramTrackingData, paramUrn, paramSortOrder);
  }
  
  protected final int getCheckedItem()
  {
    switch (sortOrder)
    {
    default: 
      return 1;
    }
    return 0;
  }
  
  protected final CharSequence[] getItems(I18NManager paramI18NManager)
  {
    return new CharSequence[] { paramI18NManager.getString(2131231307), paramI18NManager.getString(2131231276) };
  }
  
  protected final SortOrder getSortOrder(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return SortOrder.CHRON;
    }
    return SortOrder.RELEVANCE;
  }
  
  protected final String getTrackingActionType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "sortCommentsRecent";
    }
    return "sortCommentsTop";
  }
  
  protected final String getTrackingControlName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "comment_sort_toggle_recent";
    }
    return "comment_sort_toggle_top";
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != getCheckedItem())
    {
      fragmentComponent.eventBus();
      Bus.publish(new FeedToggleCommentOrderingEvent(getSortOrder(paramInt)));
    }
    super.onClick(paramDialogInterface, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.FeedToggleCommentOrderingDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */