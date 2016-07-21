package com.linkedin.android.feed.endor.datamodel.content;

import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public final class VideoContentDataModel
  extends AnnotatedTextContentDataModel
{
  public String description;
  public long duration;
  public Image image;
  public int numViews;
  public String subTitle;
  public String title;
  public String url;
  
  public VideoContentDataModel(String paramString1, String paramString2, String paramString3, String paramString4, Image paramImage, AnnotatedText paramAnnotatedText, long paramLong, int paramInt)
  {
    super(paramAnnotatedText);
    url = paramString1;
    title = paramString2;
    subTitle = paramString3;
    description = paramString4;
    image = paramImage;
    duration = paramLong;
    numViews = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.VideoContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */