package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class DiscussionWithImage$Builder
  implements RecordTemplateBuilder<DiscussionWithImage>
{
  public AnnotatedText body = null;
  public String contentId = null;
  public Image contentImage = null;
  public String contentUrl = null;
  public boolean hasBody = false;
  public boolean hasContentId = false;
  public boolean hasContentImage = false;
  public boolean hasContentUrl = false;
  public boolean hasTitle = false;
  public String title = null;
  
  public final DiscussionWithImage build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (DiscussionWithImage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new DiscussionWithImage(title, body, contentId, contentUrl, contentImage, hasTitle, hasBody, hasContentId, hasContentUrl, hasContentImage);
      if (!hasTitle) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "title");
      }
      if (!hasContentId) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "contentId");
      }
      if (!hasContentUrl) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "contentUrl");
      }
    } while (hasContentImage);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "contentImage");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */