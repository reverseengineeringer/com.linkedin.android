package com.linkedin.android.feed.channel;

import com.linkedin.android.feed.actions.UpdateActionPublisher;
import com.linkedin.android.feed.actions.UpdateActionPublisher.DeleteUpdateActionListener;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class ChannelFragment$7
  implements UpdateActionPublisher.DeleteUpdateActionListener
{
  ChannelFragment$7(ChannelFragment paramChannelFragment, Update paramUpdate, FragmentComponent paramFragmentComponent, UpdateActionModel paramUpdateActionModel) {}
  
  public final void onDeleteUpdateAction()
  {
    ChannelFragment.access$600(this$0, val$update.urn.toString());
    UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(this$0.getPageInstance()), val$fragmentComponent, val$update.urn.toString(), val$updateAction, val$update);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */