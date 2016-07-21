package com.linkedin.android.entities.group.controllers;

import android.support.v7.widget.RecyclerView;
import com.linkedin.android.entities.group.GroupsViewModelAdapter;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class GroupUpdatesFragment$3
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  GroupUpdatesFragment$3(GroupUpdatesFragment paramGroupUpdatesFragment, String paramString) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {}
    GroupsViewModelAdapter localGroupsViewModelAdapter;
    do
    {
      do
      {
        return;
      } while (!(GroupUpdatesFragment.access$300(this$0) instanceof GroupsViewModelAdapter));
      localGroupsViewModelAdapter = (GroupsViewModelAdapter)GroupUpdatesFragment.access$400(this$0);
      localGroupsViewModelAdapter.prependOrRelayoutDiscussionUpdateIfNecessary((FeedUpdateViewModel)viewModel, val$existingUpdateId);
    } while (GroupUpdatesFragment.access$500(this$0) == null);
    GroupUpdatesFragment.access$600(this$0).scrollToPosition(discussionStartPosition);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupUpdatesFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */