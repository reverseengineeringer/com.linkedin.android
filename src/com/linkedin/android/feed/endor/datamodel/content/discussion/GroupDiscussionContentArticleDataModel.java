package com.linkedin.android.feed.endor.datamodel.content.discussion;

import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public final class GroupDiscussionContentArticleDataModel
  extends GroupDiscussionContentDataModel
{
  public String contentDescription;
  public String contentId;
  public Image contentImage;
  public String contentSource;
  public String contentTitle;
  public String contentUrl;
  
  public GroupDiscussionContentArticleDataModel(AnnotatedText paramAnnotatedText, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Image paramImage, MiniGroup paramMiniGroup)
  {
    super(paramAnnotatedText, paramString1, paramMiniGroup);
    contentId = paramString2;
    contentUrl = paramString3;
    contentTitle = paramString4;
    contentSource = paramString5;
    contentDescription = paramString6;
    contentImage = paramImage;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentArticleDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */