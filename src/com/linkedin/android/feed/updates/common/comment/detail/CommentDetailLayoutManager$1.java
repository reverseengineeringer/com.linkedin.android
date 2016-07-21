package com.linkedin.android.feed.updates.common.comment.detail;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;

final class CommentDetailLayoutManager$1
  extends LinearSmoothScroller
{
  CommentDetailLayoutManager$1(CommentDetailLayoutManager paramCommentDetailLayoutManager, Context paramContext)
  {
    super(paramContext);
  }
  
  public final int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return paramInt3 - paramInt1;
  }
  
  public final PointF computeScrollVectorForPosition(int paramInt)
  {
    return this$0.computeScrollVectorForPosition(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailLayoutManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */