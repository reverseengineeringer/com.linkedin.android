package com.linkedin.android.feed.endor.ui.component.contentdetail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.AnnotatedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ArticleContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.AttributedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.JobContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.VideoContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentArticleDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.JymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.LyndaSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ReshareSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailArticleLayout;
import com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailJobLayout;
import com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailJymbiiLayout;
import com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailLayout;
import com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailReshareLayout;
import com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailVideoLayout;
import com.linkedin.android.feed.shared.LineHeightImageSpan;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.android.pegasus.gen.voyager.feed.AppActor;
import com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;

public final class FeedContentDetailTransformer
{
  public static int getContentDetailType(UpdateDataModel paramUpdateDataModel)
  {
    if ((paramUpdateDataModel instanceof JymbiiUpdateDataModel)) {
      return 4;
    }
    ContentDataModel localContentDataModel = UpdateDataModel.getContentDataModel(paramUpdateDataModel);
    if ((localContentDataModel instanceof ArticleContentDataModel)) {
      return 1;
    }
    if ((localContentDataModel instanceof VideoContentDataModel)) {
      return 6;
    }
    if ((localContentDataModel instanceof JobContentDataModel)) {
      return 2;
    }
    if (getReshare(paramUpdateDataModel) != null) {
      return 3;
    }
    if ((localContentDataModel instanceof GroupDiscussionContentArticleDataModel)) {
      return 5;
    }
    return 0;
  }
  
  private static ReshareSingleUpdateDataModel getReshare(UpdateDataModel paramUpdateDataModel)
  {
    UpdateDataModel localUpdateDataModel = paramUpdateDataModel;
    Object localObject = localUpdateDataModel;
    if ((paramUpdateDataModel instanceof ViralSingleUpdateDataModel)) {
      localObject = originalUpdate;
    }
    if ((localObject instanceof ReshareSingleUpdateDataModel)) {
      return (ReshareSingleUpdateDataModel)localObject;
    }
    return null;
  }
  
  public static boolean shouldDisplayImageOfSize(FragmentComponent paramFragmentComponent, int paramInt)
  {
    return paramInt < paramFragmentComponent.context().getResources().getInteger(2131558443);
  }
  
  public static FeedContentDetailViewModel toViewModel(UpdateDataModel paramUpdateDataModel, FragmentComponent paramFragmentComponent, int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt != getContentDetailType(paramUpdateDataModel))) {}
    Object localObject1;
    boolean bool;
    label81:
    label120:
    do
    {
      return null;
      localObject1 = null;
      localObject2 = UpdateDataModel.getContentDataModel(paramUpdateDataModel);
      paramBoolean = false;
      if ((paramUpdateDataModel instanceof SingleUpdateDataModel))
      {
        if ((!((SingleUpdateDataModel)paramUpdateDataModel).isPublisherActor(paramFragmentComponent)) && ((!(localObject2 instanceof ArticleContentDataModel)) || (image != null))) {
          break;
        }
        paramBoolean = true;
      }
      if ((!(paramUpdateDataModel instanceof AggregatedSingleUpdateDataModel)) || (!FeedViewTransformerHelpers.isAggregateFeedPage(paramFragmentComponent))) {
        break label187;
      }
      bool = true;
      switch (paramInt)
      {
      }
    } while (localObject1 == null);
    Object localObject2 = new FeedContentDetailViewModel((FeedContentDetailLayout)localObject1);
    label187:
    Object localObject3;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    case 1: 
      do
      {
        do
        {
          do
          {
            return (FeedContentDetailViewModel)localObject1;
            paramBoolean = false;
            break;
            bool = false;
            break label81;
            localObject1 = new FeedContentDetailArticleLayout(bool, paramBoolean);
            break label120;
            localObject1 = new FeedContentDetailArticleLayout(bool);
            break label120;
            localObject1 = new FeedContentDetailVideoLayout(bool);
            break label120;
            localObject1 = new FeedContentDetailJobLayout();
            break label120;
            localObject2 = getReshare(paramUpdateDataModel);
            if (localObject2 == null) {
              break label120;
            }
            if ((originalUpdate.getActorDataModel() != null) && (originalUpdate.getActorDataModel().type == 2)) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              localObject1 = new FeedContentDetailReshareLayout(paramBoolean);
              break;
            }
            if (!(paramUpdateDataModel instanceof JymbiiUpdateDataModel)) {
              break label120;
            }
            localObject1 = new FeedContentDetailJymbiiLayout();
            break label120;
            localObject1 = UpdateDataModel.getContentDataModel(paramUpdateDataModel);
            if (!(localObject1 instanceof ArticleContentDataModel)) {
              break label1825;
            }
            localObject3 = (ArticleContentDataModel)localObject1;
            title = title;
            subtitle = formattedSource;
            if ((TextUtils.equals(url, ampUrl)) && (subtitle != null))
            {
              localObject1 = subtitle;
              Object localObject4 = paramFragmentComponent.i18NManager().getString(2131233753, new Object[] { localObject1, "<AMP icon>" });
              localObject1 = new SpannableStringBuilder((CharSequence)localObject4);
              paramInt = ((String)localObject4).lastIndexOf("<AMP icon>");
              if (paramInt >= 0)
              {
                localObject4 = paramFragmentComponent.context();
                Object localObject5 = ContextCompat.getDrawable((Context)localObject4, 2130837888);
                ((Drawable)localObject5).setBounds(0, 0, ((Drawable)localObject5).getIntrinsicWidth() / 2, ((Drawable)localObject5).getIntrinsicHeight() / 2);
                DrawableHelper.setTint((Drawable)localObject5, ContextCompat.getColor((Context)localObject4, 2131623957));
                localObject5 = new LineHeightImageSpan((Drawable)localObject5);
                marginLeftPx = ((Context)localObject4).getResources().getDimensionPixelSize(2131492987);
                ((SpannableStringBuilder)localObject1).setSpan(localObject5, paramInt, paramInt + 10, 33);
              }
              subtitle = ((CharSequence)localObject1);
            }
            if ((((paramUpdateDataModel instanceof SingleUpdateDataModel)) && (((SingleUpdateDataModel)paramUpdateDataModel).isPublisherActor(paramFragmentComponent))) || (image == null)) {
              bodyText = description;
            }
            containerClickListener = FeedTracking.newArticleClickListener(pegasusUpdate, url, title, subtitle, paramFragmentComponent);
            localObject1 = localObject2;
          } while (image == null);
          localObject1 = localObject2;
        } while (FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager()));
        localObject1 = localObject2;
      } while (!shouldDisplayImageOfSize(paramFragmentComponent, image.mediaProxyImageValue.originalWidth));
      image = new ImageModel(image, 2130837812, Util.retrieveRumSessionId(paramFragmentComponent));
      return (FeedContentDetailViewModel)localObject2;
    case 6: 
      localObject1 = UpdateDataModel.getContentDataModel(paramUpdateDataModel);
      if ((localObject1 instanceof VideoContentDataModel))
      {
        localObject1 = (VideoContentDataModel)localObject1;
        title = title;
        subtitle = subTitle;
        long l3;
        if ((paramUpdateDataModel instanceof LyndaSingleUpdateDataModel))
        {
          containerClickListener = FeedTracking.newLyndaVideoClickListener(pegasusUpdate, url, title, subTitle, paramFragmentComponent, true);
          l3 = duration;
          paramUpdateDataModel = paramFragmentComponent.i18NManager();
          if (l3 > 0L) {
            break label872;
          }
          paramUpdateDataModel = null;
          if (numViews <= 0) {
            break label1042;
          }
          if (!TextUtils.isEmpty(paramUpdateDataModel)) {
            break label1007;
          }
        }
        for (paramUpdateDataModel = paramFragmentComponent.i18NManager().getString(2131231258, new Object[] { Integer.valueOf(numViews) });; paramUpdateDataModel = paramFragmentComponent.i18NManager().getString(2131231257, new Object[] { paramUpdateDataModel, Integer.valueOf(numViews) }))
        {
          tertiaryText = paramUpdateDataModel;
          return (FeedContentDetailViewModel)localObject2;
          containerClickListener = FeedTracking.newVideoClickListener(pegasusUpdate, url, title, subTitle, paramFragmentComponent);
          break;
          long l1 = l3 / 3600L;
          long l2 = l3 % 3600L / 60L;
          l3 %= 60L;
          if (l1 == 0L)
          {
            if (l2 == 0L)
            {
              paramUpdateDataModel = paramUpdateDataModel.getString(2131233719, new Object[] { Long.valueOf(l3) });
              break label789;
            }
            paramUpdateDataModel = paramUpdateDataModel.getString(2131233718, new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
            break label789;
          }
          paramUpdateDataModel = paramUpdateDataModel.getString(2131233717, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
          break label789;
        }
        tertiaryText = paramUpdateDataModel;
        return (FeedContentDetailViewModel)localObject2;
      }
      break;
    case 2: 
      localObject1 = UpdateDataModel.getContentDataModel(paramUpdateDataModel);
      if ((localObject1 instanceof JobContentDataModel))
      {
        localObject1 = (JobContentDataModel)localObject1;
        title = title;
        if (company != null) {
          subtitle = company.formattedName;
        }
        if (logo != null) {
          image = new ImageModel(logo, GhostImageUtils.getUnstructuredJob(2131492962), Util.retrieveRumSessionId(paramFragmentComponent));
        }
        while (pegasusUpdate.value.crossPromoUpdateValue != null)
        {
          localObject1 = pegasusUpdate.value.crossPromoUpdateValue;
          containerClickListener = FeedTracking.crossPromoUpdateClickListener$71752738(pegasusUpdate, paramFragmentComponent, actor.storeUrl, actor.appId, "actor");
          return (FeedContentDetailViewModel)localObject2;
          if (company != null) {
            image = company.formattedImage;
          }
        }
        containerClickListener = FeedTracking.newJobClickListener(metadata, paramFragmentComponent, pegasusUpdate);
        return (FeedContentDetailViewModel)localObject2;
      }
      break;
    case 4: 
      localObject3 = UpdateDataModel.getContentDataModel(paramUpdateDataModel);
      if (((localObject3 instanceof JobContentDataModel)) && ((paramUpdateDataModel instanceof JymbiiUpdateDataModel)))
      {
        localObject1 = (JymbiiUpdateDataModel)paramUpdateDataModel;
        localObject3 = (JobContentDataModel)localObject3;
        title = title;
        paramUpdateDataModel = paramFragmentComponent.i18NManager();
        if (company != null) {
          if (location != null)
          {
            paramUpdateDataModel = paramUpdateDataModel.getString(2131231321, new Object[] { company.formattedName, location });
            subtitle = paramUpdateDataModel;
            if ((sponsoredTemplateType == 1) || (sponsoredTemplateType == 2)) {
              tertiaryText = paramFragmentComponent.i18NManager().getString(2131231319);
            }
            if (logo == null) {
              break label1536;
            }
            image = new ImageModel(logo, GhostImageUtils.getJob(2131492962, metadata), Util.retrieveRumSessionId(paramFragmentComponent));
          }
        }
        for (;;)
        {
          containerClickListener = FeedTracking.newJobClickListener(metadata, paramFragmentComponent, pegasusUpdate);
          time = DateUtils.getTimestampText(createdTimestamp, paramFragmentComponent.i18NManager());
          timeContentDescription = DateUtils.getTimeAgoContentDescription(createdTimestamp, paramFragmentComponent.i18NManager());
          updateUrn = urn;
          trackingData = pegasusUpdate.tracking;
          return (FeedContentDetailViewModel)localObject2;
          paramUpdateDataModel = paramUpdateDataModel.getString(2131231322, new Object[] { company.formattedName });
          break;
          paramUpdateDataModel = null;
          break;
          if (company != null) {
            image = company.formattedImage;
          }
        }
      }
      break;
    case 5: 
      localObject1 = UpdateDataModel.getContentDataModel(paramUpdateDataModel);
      if ((localObject1 instanceof GroupDiscussionContentArticleDataModel))
      {
        localObject1 = (GroupDiscussionContentArticleDataModel)localObject1;
        title = contentTitle;
        subtitle = contentSource;
        containerClickListener = FeedTracking.newArticleClickListener(pegasusUpdate, contentUrl, contentTitle, contentSource, paramFragmentComponent);
        return (FeedContentDetailViewModel)localObject2;
      }
      break;
    case 3: 
      label789:
      label872:
      label1007:
      label1042:
      label1536:
      localObject1 = getReshare(paramUpdateDataModel);
      if (localObject1 != null)
      {
        localObject3 = originalUpdate.getActorDataModel();
        if (localObject3 != null)
        {
          image = formattedImage;
          title = formattedName;
          subtitle = formattedHeadline;
          localObject3 = originalUpdate.content;
          if ((localObject3 instanceof AttributedTextContentDataModel)) {}
          for (bodyText = ((AttributedTextContentDataModel)localObject3).getText(paramFragmentComponent.context());; bodyText = ((AnnotatedTextContentDataModel)localObject3).getSpannableTextFromAnnotatedText$6e69c961(originalUpdate.pegasusUpdate, paramFragmentComponent, true, false))
          {
            containerClickListener = FeedTracking.newUpdateClickListener(originalUpdate.pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns(paramUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramUpdateDataModel), "original_share_description", "viewUpdateDetail");
            isTextExpanded = FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent);
            return (FeedContentDetailViewModel)localObject2;
            if (!(localObject3 instanceof AnnotatedTextContentDataModel)) {
              break;
            }
          }
          paramFragmentComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException("Formatting non-standard content detail"));
        }
      }
      break;
    }
    label1825:
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */