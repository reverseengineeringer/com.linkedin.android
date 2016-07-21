package android.support.v4.app;

import android.app.Notification;

class NotificationCompat$NotificationCompatImplKitKat
  extends NotificationCompat.NotificationCompatImplJellybean
{
  public Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatKitKat.Builder localBuilder = new NotificationCompatKitKat.Builder(mContext, mNotification, mContentTitle, mContentText, mContentInfo, mTickerView, mNumber, mContentIntent, mFullScreenIntent, mLargeIcon, mProgressMax, mProgress, mProgressIndeterminate, mShowWhen, mUseChronometer, mPriority, mSubText, mLocalOnly, mPeople, mExtras, mGroupKey, mGroupSummary, mSortKey);
    NotificationCompat.access$000(localBuilder, mActions);
    NotificationCompat.access$100(localBuilder, mStyle);
    return localBuilder.build();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplKitKat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */