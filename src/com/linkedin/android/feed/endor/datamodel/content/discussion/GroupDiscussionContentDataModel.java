package com.linkedin.android.feed.endor.datamodel.content.discussion;

import com.linkedin.android.feed.endor.datamodel.content.AnnotatedTextContentDataModel;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public class GroupDiscussionContentDataModel
  extends AnnotatedTextContentDataModel
{
  public MiniGroup group;
  public String title;
  
  public GroupDiscussionContentDataModel(AnnotatedText paramAnnotatedText, String paramString, MiniGroup paramMiniGroup)
  {
    super(paramAnnotatedText);
    title = paramString;
    group = paramMiniGroup;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */