package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class DiscussionWithArticle$Builder
  implements RecordTemplateBuilder<DiscussionWithArticle>
{
  public AnnotatedText body = null;
  public String contentDescription = null;
  public String contentId = null;
  public Image contentImage = null;
  public String contentSource = null;
  public String contentTitle = null;
  public String contentUrl = null;
  public Urn contentUrn = null;
  public boolean hasBody = false;
  public boolean hasContentDescription = false;
  public boolean hasContentId = false;
  public boolean hasContentImage = false;
  public boolean hasContentSource = false;
  public boolean hasContentTitle = false;
  public boolean hasContentUrl = false;
  public boolean hasContentUrn = false;
  public boolean hasTitle = false;
  public String title = null;
  
  public final DiscussionWithArticle build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (DiscussionWithArticle.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new DiscussionWithArticle(title, body, contentId, contentUrl, contentTitle, contentSource, contentDescription, contentImage, contentUrn, hasTitle, hasBody, hasContentId, hasContentUrl, hasContentTitle, hasContentSource, hasContentDescription, hasContentImage, hasContentUrn);
      if (!hasTitle) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "title");
      }
      if (!hasContentId) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentId");
      }
      if (!hasContentUrl) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentUrl");
      }
      if (!hasContentTitle) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentTitle");
      }
    } while (hasContentSource);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentSource");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */