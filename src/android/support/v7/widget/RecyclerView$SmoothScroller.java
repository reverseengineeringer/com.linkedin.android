package android.support.v7.widget;

import android.view.View;
import android.view.animation.Interpolator;

public abstract class RecyclerView$SmoothScroller
{
  public RecyclerView.LayoutManager mLayoutManager;
  boolean mPendingInitialRun;
  RecyclerView mRecyclerView;
  private final Action mRecyclingAction = new Action();
  boolean mRunning;
  public int mTargetPosition = -1;
  View mTargetView;
  
  public final int getChildCount()
  {
    return mRecyclerView.mLayout.getChildCount();
  }
  
  public void onChildAttachedToWindow(View paramView)
  {
    if (RecyclerView.getChildLayoutPosition(paramView) == mTargetPosition) {
      mTargetView = paramView;
    }
  }
  
  protected abstract void onSeekTargetStep$64702b56(int paramInt1, int paramInt2, Action paramAction);
  
  public abstract void onStop();
  
  public abstract void onTargetFound$68abd3fe(View paramView, Action paramAction);
  
  protected final void stop()
  {
    if (!mRunning) {
      return;
    }
    onStop();
    mRecyclerView.mState.mTargetPosition = -1;
    mTargetView = null;
    mTargetPosition = -1;
    mPendingInitialRun = false;
    mRunning = false;
    RecyclerView.LayoutManager.access$6000(mLayoutManager, this);
    mLayoutManager = null;
    mRecyclerView = null;
  }
  
  public static final class Action
  {
    private boolean changed = false;
    private int consecutiveUpdates = 0;
    private int mDuration = Integer.MIN_VALUE;
    private int mDx = 0;
    private int mDy = 0;
    private Interpolator mInterpolator = null;
    int mJumpToPosition = -1;
    
    public Action()
    {
      this((byte)0);
    }
    
    private Action(byte paramByte) {}
    
    public final void update(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      mDx = paramInt1;
      mDy = paramInt2;
      mDuration = paramInt3;
      mInterpolator = paramInterpolator;
      changed = true;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.SmoothScroller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */