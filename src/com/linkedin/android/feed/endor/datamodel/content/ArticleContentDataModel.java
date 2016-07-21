package com.linkedin.android.feed.endor.datamodel.content;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.CompanyActorDataModel;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.ArticleType;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public final class ArticleContentDataModel
  extends AnnotatedTextContentDataModel
{
  public String ampUrl;
  public ArticleType articleType;
  public ActorDataModel author;
  public String description;
  public String formattedSource;
  public String fullUrl;
  public Image image;
  public CompanyActorDataModel publisher;
  public String subtitle;
  public String title;
  public String url;
  
  public ArticleContentDataModel(LixManager paramLixManager, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Image paramImage, CompanyActorDataModel paramCompanyActorDataModel, ActorDataModel paramActorDataModel, ArticleType paramArticleType, AnnotatedText paramAnnotatedText, String paramString6)
  {
    super(paramAnnotatedText);
    if ((paramString2 != null) && (FeedLixHelper.isEnabled(paramLixManager, Lix.FEED_AMP_ARTICLES))) {}
    for (paramLixManager = paramString2;; paramLixManager = paramString1)
    {
      url = paramLixManager;
      fullUrl = paramString1;
      ampUrl = paramString2;
      title = paramString3;
      articleType = paramArticleType;
      subtitle = paramString4;
      description = paramString5;
      image = paramImage;
      publisher = paramCompanyActorDataModel;
      author = paramActorDataModel;
      formattedSource = paramString6;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.ArticleContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */