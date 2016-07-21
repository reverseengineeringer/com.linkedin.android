package com.linkedin.android.feed.updates.common.comment.detail;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class CommentDetailBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  private CommentDetailBundleBuilder(String paramString1, String paramString2)
  {
    bundle.putString("updateUrn", paramString1);
    bundle.putString("commentUrn", paramString2);
    bundle.putInt("feedType", 13);
  }
  
  public static CommentDetailBundleBuilder create(String paramString1, String paramString2)
  {
    return new CommentDetailBundleBuilder(paramString1, paramString2);
  }
  
  public final CommentDetailBundleBuilder anchor(int paramInt)
  {
    bundle.putInt("anchorPoint", paramInt);
    return this;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final CommentDetailBundleBuilder comment(Comment paramComment)
  {
    RecordParceler.quietParcel(paramComment, "comment", bundle);
    bundle.putString("commentUrn", urn.toString());
    return this;
  }
  
  public final CommentDetailBundleBuilder populateMention(boolean paramBoolean)
  {
    bundle.putBoolean("populateMention", paramBoolean);
    return this;
  }
  
  public final CommentDetailBundleBuilder previousPage(int paramInt)
  {
    bundle.putInt("previousPage", paramInt);
    return this;
  }
  
  public final CommentDetailBundleBuilder reply(Comment paramComment)
  {
    RecordParceler.quietParcel(paramComment, "reply", bundle);
    return this;
  }
  
  public final CommentDetailBundleBuilder update(Update paramUpdate)
  {
    RecordParceler.quietParcel(paramUpdate, "update", bundle);
    bundle.putString("updateUrn", urn.toString());
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */