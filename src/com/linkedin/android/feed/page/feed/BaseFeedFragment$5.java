package com.linkedin.android.feed.page.feed;

import com.linkedin.android.feed.actions.UpdateActionPublisher;
import com.linkedin.android.feed.actions.UpdateActionPublisher.DeleteUpdateActionListener;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class BaseFeedFragment$5
  implements UpdateActionPublisher.DeleteUpdateActionListener
{
  BaseFeedFragment$5(BaseFeedFragment paramBaseFeedFragment, Update paramUpdate, FragmentComponent paramFragmentComponent, UpdateActionModel paramUpdateActionModel) {}
  
  public final void onDeleteUpdateAction()
  {
    this$0.deleteUpdate(val$update.urn.toString());
    UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(this$0.getPageInstance()), val$fragmentComponent, val$update.urn.toString(), val$updateAction, val$update);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.BaseFeedFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */