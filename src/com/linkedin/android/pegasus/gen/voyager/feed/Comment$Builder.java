package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Comment$Builder
  implements RecordTemplateBuilder<Comment>
{
  private List<CommentAction> actions = null;
  private boolean canDelete = false;
  private AnnotatedText comment = null;
  private SocialActor commenter = null;
  private long createdTime = 0L;
  private Urn entityUrn = null;
  private boolean hasActions = false;
  private boolean hasCanDelete = false;
  private boolean hasComment = false;
  private boolean hasCommenter = false;
  private boolean hasCreatedTime = false;
  private boolean hasEntityUrn = false;
  private boolean hasIndex = false;
  private boolean hasInsight = false;
  public boolean hasParentCommentUrn = false;
  private boolean hasSocialDetail = false;
  private boolean hasThreadId = false;
  private boolean hasUrn = false;
  private int index = 0;
  private Insight insight = null;
  public Urn parentCommentUrn = null;
  private SocialDetail socialDetail = null;
  private String threadId = null;
  private Urn urn = null;
  
  public Comment$Builder() {}
  
  public Comment$Builder(Comment paramComment)
  {
    urn = urn;
    entityUrn = entityUrn;
    commenter = commenter;
    comment = comment;
    createdTime = createdTime;
    socialDetail = socialDetail;
    threadId = threadId;
    index = index;
    insight = insight;
    canDelete = canDelete;
    actions = actions;
    parentCommentUrn = parentCommentUrn;
    hasUrn = hasUrn;
    hasEntityUrn = hasEntityUrn;
    hasCommenter = hasCommenter;
    hasComment = hasComment;
    hasCreatedTime = hasCreatedTime;
    hasSocialDetail = hasSocialDetail;
    hasThreadId = hasThreadId;
    hasIndex = hasIndex;
    hasInsight = hasInsight;
    hasCanDelete = hasCanDelete;
    hasActions = hasActions;
    hasParentCommentUrn = hasParentCommentUrn;
  }
  
  public final Comment build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final Comment build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Comment.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (actions != null)
    {
      paramFlavor = actions.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((CommentAction)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "actions");
            if (!hasCanDelete) {
              canDelete = false;
            }
            if (!hasActions) {
              actions = Collections.emptyList();
            }
            if (!hasCommenter) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "commenter");
            }
            if (!hasComment) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "comment");
            }
            if (!hasCreatedTime) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "createdTime");
            }
            if (!hasThreadId) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "threadId");
            }
            if (hasIndex) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "index");
          }
        }
      }
    }
    return new Comment(urn, entityUrn, commenter, comment, createdTime, socialDetail, threadId, index, insight, canDelete, actions, parentCommentUrn, hasUrn, hasEntityUrn, hasCommenter, hasComment, hasCreatedTime, hasSocialDetail, hasThreadId, hasIndex, hasInsight, hasCanDelete, hasActions, hasParentCommentUrn);
  }
  
  public final Builder setActions(List<CommentAction> paramList)
  {
    if ((paramList == null) || (paramList.equals(Collections.emptyList())))
    {
      hasActions = false;
      actions = Collections.emptyList();
      return this;
    }
    hasActions = true;
    actions = paramList;
    return this;
  }
  
  public final Builder setCanDelete(Boolean paramBoolean)
  {
    if ((paramBoolean == null) || (!paramBoolean.booleanValue()))
    {
      hasCanDelete = false;
      canDelete = false;
      return this;
    }
    hasCanDelete = true;
    canDelete = paramBoolean.booleanValue();
    return this;
  }
  
  public final Builder setComment(AnnotatedText paramAnnotatedText)
  {
    if (paramAnnotatedText == null)
    {
      hasComment = false;
      comment = null;
      return this;
    }
    hasComment = true;
    comment = paramAnnotatedText;
    return this;
  }
  
  public final Builder setCommenter(SocialActor paramSocialActor)
  {
    if (paramSocialActor == null)
    {
      hasCommenter = false;
      commenter = null;
      return this;
    }
    hasCommenter = true;
    commenter = paramSocialActor;
    return this;
  }
  
  public final Builder setCreatedTime(Long paramLong)
  {
    if (paramLong == null)
    {
      hasCreatedTime = false;
      createdTime = 0L;
      return this;
    }
    hasCreatedTime = true;
    createdTime = paramLong.longValue();
    return this;
  }
  
  public final Builder setEntityUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramUrn;
    return this;
  }
  
  public final Builder setIndex(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasIndex = false;
      index = 0;
      return this;
    }
    hasIndex = true;
    index = paramInteger.intValue();
    return this;
  }
  
  public final Builder setSocialDetail(SocialDetail paramSocialDetail)
  {
    if (paramSocialDetail == null)
    {
      hasSocialDetail = false;
      socialDetail = null;
      return this;
    }
    hasSocialDetail = true;
    socialDetail = paramSocialDetail;
    return this;
  }
  
  public final Builder setThreadId(String paramString)
  {
    if (paramString == null)
    {
      hasThreadId = false;
      threadId = null;
      return this;
    }
    hasThreadId = true;
    threadId = paramString;
    return this;
  }
  
  public final Builder setUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasUrn = false;
      urn = null;
      return this;
    }
    hasUrn = true;
    urn = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Comment.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */