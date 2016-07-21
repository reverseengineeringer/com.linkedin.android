package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ShareArticle$Builder
  implements RecordTemplateBuilder<ShareArticle>
{
  private FeedMiniArticle article = null;
  public ArticleType articleType = null;
  private AttributedText attributedText = null;
  private ShareArticle.Author author = null;
  public String description = null;
  private boolean hasArticle = false;
  public boolean hasArticleType = false;
  private boolean hasAttributedText = false;
  private boolean hasAuthor = false;
  public boolean hasDescription = false;
  public boolean hasImage = false;
  private boolean hasPublisher = false;
  public boolean hasResolvedUrl = false;
  public boolean hasSubtitle = false;
  private boolean hasText = false;
  public boolean hasTitle = false;
  public boolean hasUrl = false;
  public boolean hasUrn = false;
  public Image image = null;
  private CompanyActor publisher = null;
  public String resolvedUrl = null;
  public String subtitle = null;
  private AnnotatedText text = null;
  public String title = null;
  public String url = null;
  public Urn urn = null;
  
  public ShareArticle$Builder() {}
  
  public ShareArticle$Builder(ShareArticle paramShareArticle)
  {
    urn = urn;
    title = title;
    subtitle = subtitle;
    description = description;
    url = url;
    resolvedUrl = resolvedUrl;
    text = text;
    attributedText = attributedText;
    image = image;
    articleType = articleType;
    publisher = publisher;
    author = author;
    article = article;
    hasUrn = hasUrn;
    hasTitle = hasTitle;
    hasSubtitle = hasSubtitle;
    hasDescription = hasDescription;
    hasUrl = hasUrl;
    hasResolvedUrl = hasResolvedUrl;
    hasText = hasText;
    hasAttributedText = hasAttributedText;
    hasImage = hasImage;
    hasArticleType = hasArticleType;
    hasPublisher = hasPublisher;
    hasAuthor = hasAuthor;
    hasArticle = hasArticle;
  }
  
  public final ShareArticle build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ShareArticle.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ShareArticle(urn, title, subtitle, description, url, resolvedUrl, text, attributedText, image, articleType, publisher, author, article, hasUrn, hasTitle, hasSubtitle, hasDescription, hasUrl, hasResolvedUrl, hasText, hasAttributedText, hasImage, hasArticleType, hasPublisher, hasAuthor, hasArticle);
      if (!hasTitle) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle", "title");
      }
      if (!hasUrl) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle", "url");
      }
    } while (hasArticleType);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle", "articleType");
  }
  
  public final Builder setText(AnnotatedText paramAnnotatedText)
  {
    if (paramAnnotatedText == null)
    {
      hasText = false;
      text = null;
      return this;
    }
    hasText = true;
    text = paramAnnotatedText;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */