package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public final class NotificationCompat
{
  private static final NotificationCompatImpl IMPL = new NotificationCompatImplBase();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new NotificationCompatImplApi21();
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      IMPL = new NotificationCompatImplApi20();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new NotificationCompatImplKitKat();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new NotificationCompatImplJellybean();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new NotificationCompatImplIceCreamSandwich();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new NotificationCompatImplHoneycomb();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      IMPL = new NotificationCompatImplGingerbread();
      return;
    }
  }
  
  public static final class Action
    extends NotificationCompatBase.Action
  {
    public static final NotificationCompatBase.Action.Factory FACTORY = new NotificationCompatBase.Action.Factory() {};
    public PendingIntent actionIntent;
    public int icon;
    private final Bundle mExtras;
    private final RemoteInput[] mRemoteInputs;
    public CharSequence title;
    
    public Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null);
    }
    
    private Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput)
    {
      icon = paramInt;
      title = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      actionIntent = paramPendingIntent;
      if (paramBundle != null) {}
      for (;;)
      {
        mExtras = paramBundle;
        mRemoteInputs = paramArrayOfRemoteInput;
        return;
        paramBundle = new Bundle();
      }
    }
    
    public final PendingIntent getActionIntent()
    {
      return actionIntent;
    }
    
    public final Bundle getExtras()
    {
      return mExtras;
    }
    
    public final int getIcon()
    {
      return icon;
    }
    
    public final CharSequence getTitle()
    {
      return title;
    }
    
    public static final class Builder
    {
      public final Bundle mExtras;
      public final int mIcon = 2130837890;
      public final PendingIntent mIntent;
      public ArrayList<RemoteInput> mRemoteInputs;
      public final CharSequence mTitle;
      
      public Builder(CharSequence paramCharSequence, PendingIntent paramPendingIntent)
      {
        this(paramCharSequence, paramPendingIntent, new Bundle());
      }
      
      private Builder(CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
      {
        mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
        mIntent = paramPendingIntent;
        mExtras = paramBundle;
      }
    }
  }
  
  public static final class BigPictureStyle
    extends NotificationCompat.Style
  {
    Bitmap mBigLargeIcon;
    boolean mBigLargeIconSet;
    Bitmap mPicture;
  }
  
  public static final class BigTextStyle
    extends NotificationCompat.Style
  {
    CharSequence mBigText;
    
    public final BigTextStyle bigText(CharSequence paramCharSequence)
    {
      mBigText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
  }
  
  public static final class Builder
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
    
    public Builder(Context paramContext)
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
      NotificationCompat.NotificationCompatImpl localNotificationCompatImpl = NotificationCompat.IMPL;
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
  
  protected static final class BuilderExtender {}
  
  public static final class InboxStyle
    extends NotificationCompat.Style
  {
    ArrayList<CharSequence> mTexts = new ArrayList();
    
    public final InboxStyle addLine(CharSequence paramCharSequence)
    {
      mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence));
      return this;
    }
    
    public final InboxStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public final InboxStyle setSummaryText(CharSequence paramCharSequence)
    {
      mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      mSummaryTextSet = true;
      return this;
    }
  }
  
  static abstract interface NotificationCompatImpl
  {
    public abstract Notification build$ab8b522(NotificationCompat.Builder paramBuilder);
  }
  
  static class NotificationCompatImplApi20
    extends NotificationCompat.NotificationCompatImplKitKat
  {
    public Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
    {
      NotificationCompatApi20.Builder localBuilder = new NotificationCompatApi20.Builder(mContext, mNotification, mContentTitle, mContentText, mContentInfo, mTickerView, mNumber, mContentIntent, mFullScreenIntent, mLargeIcon, mProgressMax, mProgress, mProgressIndeterminate, mShowWhen, mUseChronometer, mPriority, mSubText, mLocalOnly, mPeople, mExtras, mGroupKey, mGroupSummary, mSortKey);
      NotificationCompat.access$000(localBuilder, mActions);
      NotificationCompat.access$100(localBuilder, mStyle);
      return localBuilder.build();
    }
  }
  
  static final class NotificationCompatImplApi21
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
  
  static class NotificationCompatImplBase
    implements NotificationCompat.NotificationCompatImpl
  {
    public Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
    {
      Notification localNotification = mNotification;
      localNotification.setLatestEventInfo(mContext, mContentTitle, mContentText, mContentIntent);
      if (mPriority > 0) {
        flags |= 0x80;
      }
      return localNotification;
    }
  }
  
  static final class NotificationCompatImplGingerbread
    extends NotificationCompat.NotificationCompatImplBase
  {
    public final Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
    {
      Notification localNotification = mNotification;
      Context localContext = mContext;
      CharSequence localCharSequence1 = mContentTitle;
      CharSequence localCharSequence2 = mContentText;
      PendingIntent localPendingIntent1 = mContentIntent;
      PendingIntent localPendingIntent2 = mFullScreenIntent;
      localNotification.setLatestEventInfo(localContext, localCharSequence1, localCharSequence2, localPendingIntent1);
      fullScreenIntent = localPendingIntent2;
      if (mPriority > 0) {
        flags |= 0x80;
      }
      return localNotification;
    }
  }
  
  static final class NotificationCompatImplHoneycomb
    extends NotificationCompat.NotificationCompatImplBase
  {
    public final Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
    {
      Object localObject2 = mContext;
      Notification localNotification = mNotification;
      Object localObject1 = mContentTitle;
      CharSequence localCharSequence1 = mContentText;
      CharSequence localCharSequence2 = mContentInfo;
      RemoteViews localRemoteViews = mTickerView;
      int i = mNumber;
      PendingIntent localPendingIntent2 = mContentIntent;
      PendingIntent localPendingIntent1 = mFullScreenIntent;
      paramBuilder = mLargeIcon;
      localObject2 = new Notification.Builder((Context)localObject2).setWhen(when).setSmallIcon(icon, iconLevel).setContent(contentView).setTicker(tickerText, localRemoteViews).setSound(sound, audioStreamType).setVibrate(vibrate).setLights(ledARGB, ledOnMS, ledOffMS);
      if ((flags & 0x2) != 0)
      {
        bool = true;
        localObject2 = ((Notification.Builder)localObject2).setOngoing(bool);
        if ((flags & 0x8) == 0) {
          break label284;
        }
        bool = true;
        label180:
        localObject2 = ((Notification.Builder)localObject2).setOnlyAlertOnce(bool);
        if ((flags & 0x10) == 0) {
          break label289;
        }
        bool = true;
        label201:
        localObject1 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(defaults).setContentTitle((CharSequence)localObject1).setContentText(localCharSequence1).setContentInfo(localCharSequence2).setContentIntent(localPendingIntent2).setDeleteIntent(deleteIntent);
        if ((flags & 0x80) == 0) {
          break label294;
        }
      }
      label284:
      label289:
      label294:
      for (boolean bool = true;; bool = false)
      {
        return ((Notification.Builder)localObject1).setFullScreenIntent(localPendingIntent1, bool).setLargeIcon(paramBuilder).setNumber(i).getNotification();
        bool = false;
        break;
        bool = false;
        break label180;
        bool = false;
        break label201;
      }
    }
  }
  
  static final class NotificationCompatImplIceCreamSandwich
    extends NotificationCompat.NotificationCompatImplBase
  {
    public final Notification build$ab8b522(NotificationCompat.Builder paramBuilder)
    {
      return new NotificationCompatIceCreamSandwich.Builder(mContext, mNotification, mContentTitle, mContentText, mContentInfo, mTickerView, mNumber, mContentIntent, mFullScreenIntent, mLargeIcon, mProgressMax, mProgress, mProgressIndeterminate).build();
    }
  }
  
  static class NotificationCompatImplJellybean
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
  
  static class NotificationCompatImplKitKat
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
  
  public static abstract class Style
  {
    CharSequence mBigContentTitle;
    NotificationCompat.Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet = false;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */