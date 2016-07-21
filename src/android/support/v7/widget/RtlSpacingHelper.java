package android.support.v7.widget;

final class RtlSpacingHelper
{
  int mEnd = Integer.MIN_VALUE;
  int mExplicitLeft = 0;
  int mExplicitRight = 0;
  boolean mIsRelative = false;
  boolean mIsRtl = false;
  int mLeft = 0;
  int mRight = 0;
  int mStart = Integer.MIN_VALUE;
  
  public final void setRelative(int paramInt1, int paramInt2)
  {
    mStart = paramInt1;
    mEnd = paramInt2;
    mIsRelative = true;
    if (mIsRtl)
    {
      if (paramInt2 != Integer.MIN_VALUE) {
        mLeft = paramInt2;
      }
      if (paramInt1 != Integer.MIN_VALUE) {
        mRight = paramInt1;
      }
    }
    do
    {
      return;
      if (paramInt1 != Integer.MIN_VALUE) {
        mLeft = paramInt1;
      }
    } while (paramInt2 == Integer.MIN_VALUE);
    mRight = paramInt2;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RtlSpacingHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */