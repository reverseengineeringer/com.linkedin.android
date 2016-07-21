package com.linkedin.android.feed.endor.datamodel.transformer;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.CompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.ExternalAuthorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.AnnotatedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ArticleContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ImageContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.JobContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.VideoContentDataModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.feed.ExternalAuthor;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle.Author;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareImage;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareJob;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareText;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateContent.Content;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareVideo;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.MiniArticle;

public final class ShareUpdateContentTransformer
{
  public static AnnotatedTextContentDataModel toDataModel(FragmentComponent paramFragmentComponent, ShareUpdateContent.Content paramContent)
    throws UpdateException
  {
    if (shareTextValue != null) {
      return new AnnotatedTextContentDataModel(shareTextValue.text);
    }
    if (shareArticleValue != null) {
      return toDataModel(paramFragmentComponent, shareArticleValue);
    }
    if (shareImageValue != null)
    {
      paramFragmentComponent = shareImageValue;
      return new ImageContentDataModel(image, text);
    }
    if (shareJobValue != null) {
      return toDataModel(paramFragmentComponent, shareJobValue);
    }
    if (shareVideoValue != null) {
      return toDataModel(shareVideoValue);
    }
    throw new UpdateException("unknown share update content");
  }
  
  public static ArticleContentDataModel toDataModel(FragmentComponent paramFragmentComponent, ShareArticle paramShareArticle)
  {
    CompanyActorDataModel localCompanyActorDataModel = null;
    if (publisher != null) {
      localCompanyActorDataModel = ActorDataTransformer.toDataModel(paramFragmentComponent, publisher);
    }
    Object localObject = author;
    String str1;
    String str2;
    label86:
    LixManager localLixManager;
    if (localObject != null)
    {
      str1 = Util.retrieveRumSessionId(paramFragmentComponent);
      if (externalAuthorValue != null)
      {
        localObject = new ExternalAuthorDataModel(externalAuthorValue, externalAuthorValue.name, str1);
        str2 = subtitle;
        if (article == null) {
          break label192;
        }
        str1 = article.article.ampUrl;
        localLixManager = paramFragmentComponent.lixManager();
        if (resolvedUrl == null) {
          break label198;
        }
      }
    }
    label192:
    label198:
    for (paramFragmentComponent = resolvedUrl;; paramFragmentComponent = url)
    {
      return new ArticleContentDataModel(localLixManager, paramFragmentComponent, str1, title, subtitle, description, image, localCompanyActorDataModel, (ActorDataModel)localObject, articleType, text, str2);
      if (influencerActorValue != null)
      {
        localObject = ActorDataTransformer.toDataModel(paramFragmentComponent, influencerActorValue, null);
        break;
      }
      if (memberActorValue != null)
      {
        localObject = ActorDataTransformer.toDataModel(paramFragmentComponent, memberActorValue, null);
        break;
      }
      localObject = null;
      break;
      str1 = null;
      break label86;
    }
  }
  
  public static JobContentDataModel toDataModel(FragmentComponent paramFragmentComponent, ShareJob paramShareJob)
  {
    CompanyActorDataModel localCompanyActorDataModel = null;
    if (companyActor != null) {
      localCompanyActorDataModel = ActorDataTransformer.toDataModel(paramFragmentComponent, companyActor);
    }
    return new JobContentDataModel(miniJob, miniJob.listDate, miniJob.title, miniJob.location, miniJob.logo, localCompanyActorDataModel, text);
  }
  
  public static VideoContentDataModel toDataModel(ShareVideo paramShareVideo)
  {
    return new VideoContentDataModel(url, title, subtitle, description, image, text, duration, numViews);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.ShareUpdateContentTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */