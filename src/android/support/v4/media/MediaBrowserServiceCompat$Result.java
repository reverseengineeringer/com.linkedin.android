package android.support.v4.media;

public class MediaBrowserServiceCompat$Result<T>
{
  Object mDebug;
  private boolean mDetachCalled;
  int mFlags;
  boolean mSendResultCalled;
  
  MediaBrowserServiceCompat$Result(Object paramObject)
  {
    mDebug = paramObject;
  }
  
  final boolean isDone()
  {
    return (mDetachCalled) || (mSendResultCalled);
  }
  
  void onResultSent$4cfcfd12(int paramInt) {}
}

/* Location:
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.Result
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */