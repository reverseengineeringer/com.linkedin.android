package com.linkedin.android.feed.endor.ui.transformer;

import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.content.ImageContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentImageDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.UpdateDataModelTransformer;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.commentary.FeedCommentaryTransformer;
import com.linkedin.android.feed.endor.ui.component.discussiontitle.FeedDiscussionTitleTransformer;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorTransformer;
import com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar.FeedSocialActionsBarTransformer;
import com.linkedin.android.feed.endor.ui.component.socialsummary.FeedSocialSummaryTransformer;
import com.linkedin.android.feed.endor.ui.component.unsupported.FeedUnsupportedTransformer;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.ArrayList;

public final class FeedImageViewerContentDetailTransformer
  extends FeedTransformerUtils
{
  public static ImageViewerFragmentViewModelHolder toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Update paramUpdate)
  {
    UpdateDataModel localUpdateDataModel = UpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, FeedDataModelMetadata.DEFAULT);
    paramUpdate = UpdateDataModel.getContentDataModel(localUpdateDataModel);
    if ((paramUpdate instanceof ImageContentDataModel)) {
      paramUpdate = image;
    }
    while (paramUpdate == null)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Can't provide a non-single update, non-image content data model to the FeedImageViewerFragmentTransformer!"));
      return new ImageViewerFragmentViewModelHolder(null, FeedUnsupportedTransformer.toUnsupportedViewModel(paramFragmentComponent, paramFeedComponentsViewPool, pegasusUpdate, "Can't provide a non-single update, non-image content data model to the FeedImageViewerFragmentTransformer!"));
      if ((paramUpdate instanceof GroupDiscussionContentImageDataModel)) {
        paramUpdate = contentImage;
      } else {
        paramUpdate = null;
      }
    }
    SingleUpdateDataModel localSingleUpdateDataModel = (SingleUpdateDataModel)localUpdateDataModel;
    ArrayList localArrayList = new ArrayList();
    safeAdd(localArrayList, FeedPrimaryActorTransformer.toViewModel(localSingleUpdateDataModel, paramFragmentComponent, false));
    safeAdd(localArrayList, FeedDiscussionTitleTransformer.toViewModel(localUpdateDataModel, paramFragmentComponent));
    safeAdd(localArrayList, FeedCommentaryTransformer.toViewModel(localSingleUpdateDataModel, paramFragmentComponent));
    safeAdd(localArrayList, FeedSocialSummaryTransformer.toViewModel(localSingleUpdateDataModel, paramFragmentComponent));
    safeAdd(localArrayList, FeedSocialActionsBarTransformer.toViewModel(localSingleUpdateDataModel, paramFragmentComponent));
    return new ImageViewerFragmentViewModelHolder(paramUpdate, new FeedSingleUpdateViewModel(pegasusUpdate, paramFragmentComponent, paramFeedComponentsViewPool, localArrayList, null));
  }
  
  public static final class ImageViewerFragmentViewModelHolder
  {
    public FeedUpdateViewModel contentDetailViewModel;
    public Image image;
    
    public ImageViewerFragmentViewModelHolder(Image paramImage, FeedUpdateViewModel paramFeedUpdateViewModel)
    {
      image = paramImage;
      contentDetailViewModel = paramFeedUpdateViewModel;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.transformer.FeedImageViewerContentDetailTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */