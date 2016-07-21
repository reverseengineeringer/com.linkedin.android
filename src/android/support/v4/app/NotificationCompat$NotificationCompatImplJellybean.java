package android.support.v4.app;

import android.app.Notification;

class NotificationCompat$NotificationCompatImplJellybean
  extends NotificationCompat.NotificationCompatImplBase
{
  public Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatJellybean.Builder localBuilder = new NotificationCompatJellybean.Builder(mContext, mNotification, mContentTitle, mContentText, mContentInfo, mTickerView, mNumber, mContentIntent, mFullScreenIntent, mLargeIcon, mProgressMax, mProgress, mProgressIndeterminate, mUseChronometer, mPriority, mSubText, mLocalOnly, mExtras, mGroupKey, mGroupSummary, mSortKey);
    NotificationCompat.access$000(localBuilder, mActions);
    NotificationCompat.access$100(localBuilder, mStyle);
    return localBuilder.build();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */