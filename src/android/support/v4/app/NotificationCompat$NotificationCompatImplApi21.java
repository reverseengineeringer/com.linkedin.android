package android.support.v4.app;

import android.app.Notification;

final class NotificationCompat$NotificationCompatImplApi21
  extends NotificationCompat.NotificationCompatImplApi20
{
  public final Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatApi21.Builder localBuilder = new NotificationCompatApi21.Builder(mContext, mNotification, mContentTitle, mContentText, mContentInfo, mTickerView, mNumber, mContentIntent, mFullScreenIntent, mLargeIcon, mProgressMax, mProgress, mProgressIndeterminate, mShowWhen, mUseChronometer, mPriority, mSubText, mLocalOnly, mCategory, mPeople, mExtras, mColor, mVisibility, mPublicVersion, mGroupKey, mGroupSummary, mSortKey);
    NotificationCompat.access$000(localBuilder, mActions);
    NotificationCompat.access$100(localBuilder, mStyle);
    return localBuilder.build();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplApi21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */