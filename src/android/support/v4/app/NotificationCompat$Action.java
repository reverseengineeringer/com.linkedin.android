package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;

public final class NotificationCompat$Action
  extends NotificationCompatBase.Action
{
  public static final NotificationCompatBase.Action.Factory FACTORY = new NotificationCompatBase.Action.Factory() {};
  public PendingIntent actionIntent;
  public int icon;
  private final Bundle mExtras;
  private final RemoteInput[] mRemoteInputs;
  public CharSequence title;
  
  public NotificationCompat$Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null);
  }
  
  private NotificationCompat$Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput)
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

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat.Action
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */