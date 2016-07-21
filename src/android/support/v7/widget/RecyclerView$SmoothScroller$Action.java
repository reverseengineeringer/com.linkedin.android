package android.support.v7.widget;

import android.view.animation.Interpolator;

public final class RecyclerView$SmoothScroller$Action
{
  private boolean changed = false;
  private int consecutiveUpdates = 0;
  private int mDuration = Integer.MIN_VALUE;
  private int mDx = 0;
  private int mDy = 0;
  private Interpolator mInterpolator = null;
  int mJumpToPosition = -1;
  
  public RecyclerView$SmoothScroller$Action()
  {
    this((byte)0);
  }
  
  private RecyclerView$SmoothScroller$Action(byte paramByte) {}
  
  public final void update(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    mDx = paramInt1;
    mDy = paramInt2;
    mDuration = paramInt3;
    mInterpolator = paramInterpolator;
    changed = true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.SmoothScroller.Action
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */