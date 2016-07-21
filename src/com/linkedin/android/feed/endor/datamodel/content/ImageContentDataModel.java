package com.linkedin.android.feed.endor.datamodel.content;

import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public final class ImageContentDataModel
  extends AnnotatedTextContentDataModel
{
  public Image image;
  
  public ImageContentDataModel(Image paramImage, AnnotatedText paramAnnotatedText)
  {
    super(paramAnnotatedText);
    image = paramImage;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.ImageContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */