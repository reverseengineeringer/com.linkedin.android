package android.support.v7.widget;

final class LayoutState
{
  int mAvailable;
  int mCurrentPosition;
  int mEndLine = 0;
  boolean mInfinite;
  int mItemDirection;
  int mLayoutDirection;
  boolean mRecycle = true;
  int mStartLine = 0;
  boolean mStopInFocusable;
  
  public final String toString()
  {
    return "LayoutState{mAvailable=" + mAvailable + ", mCurrentPosition=" + mCurrentPosition + ", mItemDirection=" + mItemDirection + ", mLayoutDirection=" + mLayoutDirection + ", mStartLine=" + mStartLine + ", mEndLine=" + mEndLine + '}';
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.LayoutState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */