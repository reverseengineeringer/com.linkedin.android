package com.linkedin.android.feed.endor.ui.component.richmedia;

import android.content.Context;
import android.content.res.Resources;
import com.linkedin.android.feed.endor.datamodel.actor.CompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ArticleContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ImageContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.NativeVideoContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.VideoContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentArticleDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentImageDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ChannelSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.LyndaSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.MentionedInNewsUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.PromptResponseSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ReshareSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaArticleLayout;
import com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaImageLayout;
import com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaLayout;
import com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaVideoLayout;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class FeedRichMediaTransformer
{
  private static ContentDataModel getContentDataModel(UpdateDataModel paramUpdateDataModel)
  {
    if ((paramUpdateDataModel instanceof AggregatedSingleUpdateDataModel)) {
      return content;
    }
    if ((paramUpdateDataModel instanceof SingleUpdateDataModel))
    {
      paramUpdateDataModel = (SingleUpdateDataModel)paramUpdateDataModel;
      if (!(paramUpdateDataModel instanceof ViralSingleUpdateDataModel)) {
        break label66;
      }
      paramUpdateDataModel = originalUpdate;
    }
    label66:
    for (;;)
    {
      Object localObject = paramUpdateDataModel;
      if ((paramUpdateDataModel instanceof ReshareSingleUpdateDataModel)) {
        localObject = originalUpdate;
      }
      return content;
      return null;
    }
  }
  
  private static FeedRichMediaViewModel setupViewModelForImage(FragmentComponent paramFragmentComponent, FeedRichMediaViewModel paramFeedRichMediaViewModel, UpdateDataModel paramUpdateDataModel, Image paramImage)
  {
    image = new ImageModel(paramImage, 2130837812, Util.retrieveRumSessionId(paramFragmentComponent));
    String str = "object";
    boolean bool = FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent);
    if ((paramUpdateDataModel instanceof ReshareSingleUpdateDataModel))
    {
      str = "original_share_object";
      bool = false;
    }
    Update localUpdate = pegasusUpdate;
    if ((paramUpdateDataModel instanceof SingleUpdateDataModel)) {
      localUpdate = getMostOriginalSharepegasusUpdate;
    }
    clickListener = FeedTracking.newImageViewerClickListener(localUpdate, bool, paramFragmentComponent, paramImage, str);
    return paramFeedRichMediaViewModel;
  }
  
  public static boolean shouldDisplayImageOfSize(FragmentComponent paramFragmentComponent, int paramInt)
  {
    return paramInt >= paramFragmentComponent.context().getResources().getInteger(2131558443);
  }
  
  public static FeedRichMediaViewModel toViewModel(FragmentComponent paramFragmentComponent, UpdateDataModel paramUpdateDataModel)
  {
    Object localObject2 = null;
    Object localObject1 = getContentDataModel(paramUpdateDataModel);
    boolean bool1;
    boolean bool4;
    boolean bool2;
    label69:
    boolean bool3;
    if (((paramUpdateDataModel instanceof ReshareSingleUpdateDataModel)) || (((paramUpdateDataModel instanceof ViralSingleUpdateDataModel)) && ((originalUpdate instanceof ReshareSingleUpdateDataModel))))
    {
      bool1 = true;
      bool4 = FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager());
      if ((!(paramUpdateDataModel instanceof AggregatedSingleUpdateDataModel)) || (!FeedViewTransformerHelpers.isAggregateFeedPage(paramFragmentComponent))) {
        break label181;
      }
      bool2 = true;
      if (!(paramUpdateDataModel instanceof SingleUpdateDataModel)) {
        break label186;
      }
      bool3 = getMostOriginalShareprimaryActor instanceof CompanyActorDataModel;
      label91:
      if (!(paramUpdateDataModel instanceof ChannelSingleUpdateDataModel)) {
        break label192;
      }
      localObject1 = new FeedRichMediaArticleLayout(paramFragmentComponent, true, bool4);
    }
    for (;;)
    {
      label111:
      if (localObject1 != null)
      {
        localObject1 = new FeedRichMediaViewModel((FeedRichMediaLayout)localObject1);
        localObject2 = getContentDataModel(paramUpdateDataModel);
        if (!(paramUpdateDataModel instanceof ViralSingleUpdateDataModel)) {
          break label849;
        }
        paramUpdateDataModel = originalUpdate;
      }
      label181:
      label186:
      label192:
      label846:
      label849:
      for (;;)
      {
        if ((localObject2 instanceof ImageContentDataModel))
        {
          localObject2 = setupViewModelForImage(paramFragmentComponent, (FeedRichMediaViewModel)localObject1, paramUpdateDataModel, image);
          return (FeedRichMediaViewModel)localObject2;
          bool1 = false;
          break;
          bool2 = false;
          break label69;
          bool3 = false;
          break label91;
          if ((paramUpdateDataModel instanceof MentionedInNewsUpdateDataModel))
          {
            localObject1 = new FeedRichMediaArticleLayout(paramFragmentComponent, true, bool4);
            break label111;
          }
          if ((localObject1 instanceof ImageContentDataModel))
          {
            localObject1 = new FeedRichMediaImageLayout(paramFragmentComponent, bool1, bool4, bool3);
            break label111;
          }
          if (((localObject1 instanceof ArticleContentDataModel)) && (image != null))
          {
            if (!bool2) {}
            for (bool1 = true;; bool1 = false)
            {
              localObject1 = new FeedRichMediaArticleLayout(paramFragmentComponent, bool1, bool4);
              break;
            }
          }
          if ((localObject1 instanceof VideoContentDataModel))
          {
            localObject1 = new FeedRichMediaVideoLayout(paramFragmentComponent, bool2);
            break label111;
          }
          if ((localObject1 instanceof NativeVideoContentDataModel))
          {
            localObject1 = (NativeVideoContentDataModel)localObject1;
            if (!bool1) {}
            for (bool1 = true;; bool1 = false)
            {
              localObject1 = new FeedRichMediaVideoLayout(paramFragmentComponent, bool1, width, height);
              break;
            }
          }
          if ((localObject1 instanceof GroupDiscussionContentImageDataModel))
          {
            localObject1 = new FeedRichMediaImageLayout(paramFragmentComponent, false, bool4, bool3);
            break label111;
          }
          if (!(localObject1 instanceof GroupDiscussionContentArticleDataModel)) {
            break label852;
          }
          localObject1 = new FeedRichMediaArticleLayout(paramFragmentComponent, true, bool4);
          break label111;
        }
        if ((localObject2 instanceof ArticleContentDataModel))
        {
          localObject2 = (ArticleContentDataModel)localObject2;
          if ((image != null) && ((image.mediaProxyImageValue == null) || (FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager())) || (shouldDisplayImageOfSize(paramFragmentComponent, image.mediaProxyImageValue.originalWidth))))
          {
            image = new ImageModel(image, 2130837812, Util.retrieveRumSessionId(paramFragmentComponent));
            clickListener = FeedTracking.newArticleClickListener(pegasusUpdate, url, title, subtitle, paramFragmentComponent);
            return (FeedRichMediaViewModel)localObject1;
          }
        }
        else
        {
          if ((localObject2 instanceof VideoContentDataModel))
          {
            localObject2 = (VideoContentDataModel)localObject2;
            image = new ImageModel(image, 2130837812, Util.retrieveRumSessionId(paramFragmentComponent));
            if ((paramUpdateDataModel instanceof LyndaSingleUpdateDataModel)) {}
            for (clickListener = FeedTracking.newLyndaVideoClickListener(pegasusUpdate, url, title, subTitle, paramFragmentComponent, false);; clickListener = FeedTracking.newVideoClickListener(pegasusUpdate, url, title, subTitle, paramFragmentComponent))
            {
              isVideo = true;
              return (FeedRichMediaViewModel)localObject1;
            }
          }
          if ((localObject2 instanceof GroupDiscussionContentImageDataModel)) {
            return setupViewModelForImage(paramFragmentComponent, (FeedRichMediaViewModel)localObject1, paramUpdateDataModel, contentImage);
          }
          if ((localObject2 instanceof NativeVideoContentDataModel))
          {
            localObject2 = (NativeVideoContentDataModel)localObject2;
            if (!(paramUpdateDataModel instanceof SingleUpdateDataModel)) {
              break label846;
            }
            paramUpdateDataModel = SingleUpdateDataModel.getMostOriginalShare((SingleUpdateDataModel)paramUpdateDataModel);
          }
        }
        for (;;)
        {
          if ((paramUpdateDataModel instanceof PromptResponseSingleUpdateDataModel))
          {
            PromptResponseSingleUpdateDataModel localPromptResponseSingleUpdateDataModel = (PromptResponseSingleUpdateDataModel)paramUpdateDataModel;
            image = new ImageModel(thumbnailUrl, 2130837812);
            clickListener = FeedTracking.newPromptResponseUpdateClickListener(pegasusUpdate, prompt, videoPlayMetadata.media, url, "object", paramFragmentComponent);
            return (FeedRichMediaViewModel)localObject1;
            if ((localObject2 instanceof GroupDiscussionContentArticleDataModel))
            {
              localObject2 = (GroupDiscussionContentArticleDataModel)localObject2;
              if (contentImage != null)
              {
                image = new ImageModel(contentImage, 2130837812, Util.retrieveRumSessionId(paramFragmentComponent));
                clickListener = FeedTracking.newArticleClickListener(pegasusUpdate, contentUrl, contentTitle, contentSource, paramFragmentComponent);
                return (FeedRichMediaViewModel)localObject1;
              }
            }
          }
          return null;
        }
      }
      label852:
      localObject1 = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */