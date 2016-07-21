package com.linkedin.android.feed.aggregate;

import com.linkedin.android.feed.actions.UpdateActionPublisher;
import com.linkedin.android.feed.actions.UpdateActionPublisher.DeleteUpdateActionListener;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Map;

final class AggregateFragment$5
  implements UpdateActionPublisher.DeleteUpdateActionListener
{
  AggregateFragment$5(AggregateFragment paramAggregateFragment, Update paramUpdate, Map paramMap, FragmentComponent paramFragmentComponent, UpdateActionModel paramUpdateActionModel) {}
  
  public final void onDeleteUpdateAction()
  {
    AggregateFragment.access$200(this$0, val$update.urn.toString());
    UpdateActionPublisher.publishUpdateAction(val$trackingHeader, val$fragmentComponent, val$update.urn.toString(), val$updateAction, val$update);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */