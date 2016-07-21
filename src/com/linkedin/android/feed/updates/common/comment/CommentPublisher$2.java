package com.linkedin.android.feed.updates.common.comment;

import android.content.Context;
import com.linkedin.android.infra.data.OptimisticWrite.PreWriteModelTransformer;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;

public final class CommentPublisher$2
  implements OptimisticWrite.PreWriteModelTransformer
{
  public CommentPublisher$2(CommentPublisher paramCommentPublisher, Context paramContext) {}
  
  public final RecordTemplate transform(RecordTemplate paramRecordTemplate)
  {
    Comment localComment = null;
    String str;
    if ((paramRecordTemplate instanceof Comment))
    {
      localComment = (Comment)paramRecordTemplate;
      str = urn.getId();
    }
    try
    {
      localComment = new Comment.Builder(localComment).setSocialDetail(new SocialDetail.Builder(socialDetail).setEntityUrn(Urn.createFromTuple("mockSocialDetailUrn", new Object[] { urn })).setUrn(urn).setThreadId(str).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
      if (localComment != null) {
        return localComment;
      }
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Util.safeThrow$7a8b4789(new RuntimeException(localBuilderException));
        Object localObject = null;
      }
    }
    return paramRecordTemplate;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.CommentPublisher.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */