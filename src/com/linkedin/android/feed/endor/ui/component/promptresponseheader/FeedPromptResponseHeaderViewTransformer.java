package com.linkedin.android.feed.endor.ui.component.promptresponseheader;

import com.linkedin.android.feed.endor.datamodel.content.NativeVideoContentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.PromptResponseSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ReshareSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderLayout;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Prompt;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.List;

public final class FeedPromptResponseHeaderViewTransformer
{
  public static FeedHeaderViewModel toViewModel(FragmentComponent paramFragmentComponent, SingleUpdateDataModel paramSingleUpdateDataModel)
  {
    SingleUpdateDataModel localSingleUpdateDataModel = SingleUpdateDataModel.getMostOriginalShare(paramSingleUpdateDataModel);
    Object localObject1;
    if ((!(localSingleUpdateDataModel instanceof PromptResponseSingleUpdateDataModel)) || (FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent))) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      do
      {
        return (FeedHeaderViewModel)localObject1;
        localObject2 = (PromptResponseSingleUpdateDataModel)localSingleUpdateDataModel;
        localObject1 = AttributedTextUtils.getAttributedString(prompt.summary, paramFragmentComponent.context());
        NativeVideoContentDataModel localNativeVideoContentDataModel = (NativeVideoContentDataModel)content;
        localObject2 = FeedTracking.newPromptResponseUpdateClickListener(pegasusUpdate, prompt, videoPlayMetadata.media, url, "feed_prompt", paramFragmentComponent);
        localObject2 = new FeedHeaderViewModel(new FeedHeaderLayout(2131361905, paramSingleUpdateDataModel instanceof ReshareSingleUpdateDataModel), (CharSequence)localObject1, (TrackingOnClickListener)localObject2);
        localObject1 = localObject2;
      } while ((paramSingleUpdateDataModel instanceof ViralSingleUpdateDataModel));
      localObject1 = localObject2;
    } while (actions.isEmpty());
    controlMenuListener = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
    return (FeedHeaderViewModel)localObject2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.promptresponseheader.FeedPromptResponseHeaderViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */