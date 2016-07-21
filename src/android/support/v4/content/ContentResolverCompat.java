package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;

public final class ContentResolverCompat
{
  private static final ContentResolverCompatImpl IMPL = new ContentResolverCompatImplBase();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new ContentResolverCompatImplJB();
      return;
    }
  }
  
  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, android.support.v4.os.CancellationSignal paramCancellationSignal)
  {
    return IMPL.query(paramContentResolver, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramCancellationSignal);
  }
  
  static abstract interface ContentResolverCompatImpl
  {
    public abstract Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, android.support.v4.os.CancellationSignal paramCancellationSignal);
  }
  
  static class ContentResolverCompatImplBase
    implements ContentResolverCompat.ContentResolverCompatImpl
  {
    public Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, android.support.v4.os.CancellationSignal paramCancellationSignal)
    {
      if ((paramCancellationSignal != null) && (paramCancellationSignal.isCanceled())) {
        throw new android.support.v4.os.OperationCanceledException();
      }
      return paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
  }
  
  static final class ContentResolverCompatImplJB
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
}

/* Location:
 * Qualified Name:     android.support.v4.content.ContentResolverCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */