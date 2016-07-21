package com.linkedin.android.feed.updates.common.comment.detail;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;

public class CommentDetailLayoutManager
  extends LinearLayoutManager
{
  public CommentDetailLayoutManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void smoothScrollToPosition$7d69765f(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext())
    {
      public final int calculateDtToFit(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5)
      {
        return paramAnonymousInt3 - paramAnonymousInt1;
      }
      
      public final PointF computeScrollVectorForPosition(int paramAnonymousInt)
      {
        return CommentDetailLayoutManager.this.computeScrollVectorForPosition(paramAnonymousInt);
      }
    };
    mTargetPosition = paramInt;
    startSmoothScroll(paramRecyclerView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */