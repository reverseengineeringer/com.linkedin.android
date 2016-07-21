package com.linkedin.android.entities.group.controllers;

import android.support.v7.widget.RecyclerView;
import com.linkedin.android.entities.group.GroupsViewModelAdapter;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class GroupDiscussionsTabFragment$3
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  GroupDiscussionsTabFragment$3(GroupDiscussionsTabFragment paramGroupDiscussionsTabFragment, String paramString) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {}
    do
    {
      return;
      if (GroupDiscussionsTabFragment.access$000(this$0) != null) {
        GroupDiscussionsTabFragment.access$000(this$0).prependOrRelayoutDiscussionUpdateIfNecessary((FeedUpdateViewModel)viewModel, val$existingUpdateId);
      }
    } while (GroupDiscussionsTabFragment.access$100(this$0) == null);
    GroupDiscussionsTabFragment.access$200(this$0).scrollToPosition(access$000this$0).discussionStartPosition);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupDiscussionsTabFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */