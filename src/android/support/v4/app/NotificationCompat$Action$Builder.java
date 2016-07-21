package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;

public final class NotificationCompat$Action$Builder
{
  public final Bundle mExtras;
  public final int mIcon = 2130837890;
  public final PendingIntent mIntent;
  public ArrayList<RemoteInput> mRemoteInputs;
  public final CharSequence mTitle;
  
  public NotificationCompat$Action$Builder(CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private NotificationCompat$Action$Builder(CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    mIntent = paramPendingIntent;
    mExtras = paramBundle;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat.Action.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */