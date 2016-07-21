package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public final class NotificationCompat$Builder
{
  public ArrayList<NotificationCompat.Action> mActions = new ArrayList();
  String mCategory;
  public int mColor = 0;
  public CharSequence mContentInfo;
  public PendingIntent mContentIntent;
  public CharSequence mContentText;
  public CharSequence mContentTitle;
  public Context mContext;
  Bundle mExtras;
  PendingIntent mFullScreenIntent;
  String mGroupKey;
  boolean mGroupSummary;
  public Bitmap mLargeIcon;
  boolean mLocalOnly = false;
  public Notification mNotification = new Notification();
  public int mNumber;
  public ArrayList<String> mPeople;
  public int mPriority;
  int mProgress;
  boolean mProgressIndeterminate;
  int mProgressMax;
  Notification mPublicVersion;
  boolean mShowWhen = true;
  String mSortKey;
  public NotificationCompat.Style mStyle;
  public CharSequence mSubText;
  RemoteViews mTickerView;
  public boolean mUseChronometer;
  int mVisibility = 0;
  
  public NotificationCompat$Builder(Context paramContext)
  {
    mContext = paramContext;
    mNotification.when = System.currentTimeMillis();
    mNotification.audioStreamType = -1;
    mPriority = 0;
    mPeople = new ArrayList();
  }
  
  protected static CharSequence limitCharSequenceLength(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    while (paramCharSequence.length() <= 5120) {
      return paramCharSequence;
    }
    return paramCharSequence.subSequence(0, 5120);
  }
  
  public final Notification build()
  {
    NotificationCompat.NotificationCompatImpl localNotificationCompatImpl = NotificationCompat.access$200();
    new NotificationCompat.BuilderExtender();
    return localNotificationCompatImpl.build$ab8b522(this);
  }
  
  public final Builder setAutoCancel$7abcb88d()
  {
    Notification localNotification = mNotification;
    flags |= 0x10;
    return this;
  }
  
  public final Builder setContentIntent(PendingIntent paramPendingIntent)
  {
    mContentIntent = paramPendingIntent;
    return this;
  }
  
  public final Builder setContentText(CharSequence paramCharSequence)
  {
    mContentText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public final Builder setContentTitle(CharSequence paramCharSequence)
  {
    mContentTitle = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public final Builder setDeleteIntent(PendingIntent paramPendingIntent)
  {
    mNotification.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public final Builder setSmallIcon(int paramInt)
  {
    mNotification.icon = paramInt;
    return this;
  }
  
  public final Builder setStyle(NotificationCompat.Style paramStyle)
  {
    if (mStyle != paramStyle)
    {
      mStyle = paramStyle;
      if (mStyle != null)
      {
        paramStyle = mStyle;
        if (mBuilder != this)
        {
          mBuilder = this;
          if (mBuilder != null) {
            mBuilder.setStyle(paramStyle);
          }
        }
      }
    }
    return this;
  }
  
  public final Builder setTicker(CharSequence paramCharSequence)
  {
    mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public final Builder setWhen(long paramLong)
  {
    mNotification.when = paramLong;
    return this;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */