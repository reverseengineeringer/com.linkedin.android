package com.linkedin.android.feed.endor.datamodel.content.discussion;

import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public final class GroupDiscussionContentImageDataModel
  extends GroupDiscussionContentDataModel
{
  public String contentId;
  public Image contentImage;
  public String contentUrl;
  
  public GroupDiscussionContentImageDataModel(AnnotatedText paramAnnotatedText, String paramString1, String paramString2, String paramString3, Image paramImage, MiniGroup paramMiniGroup)
  {
    super(paramAnnotatedText, paramString1, paramMiniGroup);
    contentId = paramString2;
    contentUrl = paramString3;
    contentImage = paramImage;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentImageDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */