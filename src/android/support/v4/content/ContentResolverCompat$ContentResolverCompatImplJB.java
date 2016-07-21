package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

final class ContentResolverCompat$ContentResolverCompatImplJB
  extends ContentResolverCompat.ContentResolverCompatImplBase
{
  public final Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, android.support.v4.os.CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null) {}
    for (;;)
    {
      try
      {
        paramCancellationSignal = paramCancellationSignal.getCancellationSignalObject();
        paramContentResolver = paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (android.os.CancellationSignal)paramCancellationSignal);
        return paramContentResolver;
      }
      catch (Exception paramContentResolver)
      {
        if (!(paramContentResolver instanceof android.os.OperationCanceledException)) {
          continue;
        }
        throw new android.support.v4.os.OperationCanceledException();
        throw paramContentResolver;
      }
      paramCancellationSignal = null;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.ContentResolverCompat.ContentResolverCompatImplJB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */