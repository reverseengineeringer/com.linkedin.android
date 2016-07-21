package com.linkedin.android.feed.endor.ui.component.divider;

import android.content.Context;
import android.content.res.Resources;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.AggregatedJymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.DiscussionSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.infra.components.FragmentComponent;

public final class FeedDividerViewTransformer
{
  public static FeedDividerViewModel getDefaultViewModel()
  {
    return new FeedDividerViewModel(new FeedDividerLayout(0));
  }
  
  public static FeedDividerViewModel toViewModel(UpdateDataModel paramUpdateDataModel, FragmentComponent paramFragmentComponent)
  {
    if (UpdateDataModel.isPropUpdate(paramUpdateDataModel)) {
      return new FeedDividerViewModel(new FeedDividerLayout(paramFragmentComponent.context().getResources().getDimensionPixelSize(2131492991), paramFragmentComponent.context().getResources().getDimensionPixelSize(2131493141)));
    }
    if ((paramUpdateDataModel instanceof AggregatedJymbiiUpdateDataModel)) {
      return new FeedDividerViewModel(new FeedDividerLayout(paramFragmentComponent.context().getResources().getDimensionPixelSize(2131493123)));
    }
    if ((paramUpdateDataModel instanceof ConnectionUpdateDataModel)) {
      return new FeedDividerViewModel(new FeedDividerLayout(paramFragmentComponent.context().getResources().getDimensionPixelSize(2131493122)));
    }
    if ((paramUpdateDataModel instanceof PymkUpdateDataModel)) {
      return new FeedDividerViewModel(new FeedDividerLayout(paramFragmentComponent.context().getResources().getDimensionPixelSize(2131493124)));
    }
    if ((paramUpdateDataModel instanceof DiscussionSingleUpdateDataModel)) {
      return new FeedDividerViewModel(new FeedDividerLayout(0));
    }
    if (FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent)) {
      return new FeedDividerViewModel(new FeedDividerLayout());
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */