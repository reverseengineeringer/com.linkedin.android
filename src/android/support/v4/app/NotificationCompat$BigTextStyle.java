package android.support.v4.app;

public final class NotificationCompat$BigTextStyle
  extends NotificationCompat.Style
{
  CharSequence mBigText;
  
  public final BigTextStyle bigText(CharSequence paramCharSequence)
  {
    mBigText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompat.BigTextStyle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */