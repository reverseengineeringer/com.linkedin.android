package android.support.v4.widget;

final class AutoScrollHelper$ClampedScroller
{
  long mDeltaTime = 0L;
  int mDeltaX = 0;
  int mDeltaY = 0;
  int mEffectiveRampDown;
  int mRampDownDuration;
  int mRampUpDuration;
  long mStartTime = Long.MIN_VALUE;
  long mStopTime = -1L;
  float mStopValue;
  float mTargetVelocityX;
  float mTargetVelocityY;
  
  final float getValueAt(long paramLong)
  {
    if (paramLong < mStartTime) {
      return 0.0F;
    }
    if ((mStopTime < 0L) || (paramLong < mStopTime)) {
      return 0.5F * AutoScrollHelper.access$900$483d241b((float)(paramLong - mStartTime) / mRampUpDuration);
    }
    long l = mStopTime;
    return 1.0F - mStopValue + mStopValue * AutoScrollHelper.access$900$483d241b((float)(paramLong - l) / mEffectiveRampDown);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.AutoScrollHelper.ClampedScroller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */