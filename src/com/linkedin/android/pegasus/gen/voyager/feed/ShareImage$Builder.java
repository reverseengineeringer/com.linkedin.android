package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ShareImage$Builder
  implements RecordTemplateBuilder<ShareImage>
{
  private AttributedText attributedText = null;
  private String contentType = null;
  private String fileId = null;
  private boolean hasAttributedText = false;
  private boolean hasContentType = false;
  private boolean hasFileId = false;
  private boolean hasImage = false;
  private boolean hasOriginalImage = false;
  private boolean hasText = false;
  private Image image = null;
  private Image originalImage = null;
  private AnnotatedText text = null;
  
  public ShareImage$Builder() {}
  
  public ShareImage$Builder(ShareImage paramShareImage)
  {
    text = text;
    attributedText = attributedText;
    image = image;
    originalImage = originalImage;
    contentType = contentType;
    fileId = fileId;
    hasText = hasText;
    hasAttributedText = hasAttributedText;
    hasImage = hasImage;
    hasOriginalImage = hasOriginalImage;
    hasContentType = hasContentType;
    hasFileId = hasFileId;
  }
  
  public final ShareImage build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ShareImage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ShareImage(text, attributedText, image, originalImage, contentType, fileId, hasText, hasAttributedText, hasImage, hasOriginalImage, hasContentType, hasFileId);
      if (!hasImage) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareImage", "image");
      }
    } while (hasFileId);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareImage", "fileId");
  }
  
  public final Builder setContentType(String paramString)
  {
    if (paramString == null)
    {
      hasContentType = false;
      contentType = null;
      return this;
    }
    hasContentType = true;
    contentType = paramString;
    return this;
  }
  
  public final Builder setFileId(String paramString)
  {
    if (paramString == null)
    {
      hasFileId = false;
      fileId = null;
      return this;
    }
    hasFileId = true;
    fileId = paramString;
    return this;
  }
  
  public final Builder setImage(Image paramImage)
  {
    if (paramImage == null)
    {
      hasImage = false;
      image = null;
      return this;
    }
    hasImage = true;
    image = paramImage;
    return this;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareImage.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */