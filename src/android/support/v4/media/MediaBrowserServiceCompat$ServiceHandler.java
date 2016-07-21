package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

final class MediaBrowserServiceCompat$ServiceHandler
  extends Handler
{
  private final MediaBrowserServiceCompat.ServiceImpl mServiceImpl = new MediaBrowserServiceCompat.ServiceImpl(this$0, (byte)0);
  
  private MediaBrowserServiceCompat$ServiceHandler(MediaBrowserServiceCompat paramMediaBrowserServiceCompat) {}
  
  private void postOrRun(Runnable paramRunnable)
  {
    if (Thread.currentThread() == getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject1 = paramMessage.getData();
    switch (what)
    {
    default: 
      Log.w("MediaBrowserServiceCompat", "Unhandled message: " + paramMessage + "\n  Service version: 1\n  Client version: " + arg1);
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      Object localObject2;
      do
      {
        return;
        localObject2 = mServiceImpl;
        String str = ((Bundle)localObject1).getString("data_package_name");
        int i = ((Bundle)localObject1).getInt("data_calling_uid");
        localObject1 = ((Bundle)localObject1).getBundle("data_root_hints");
        paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(this$0, replyTo);
        if (!MediaBrowserServiceCompat.access$400(this$0, str, i)) {
          throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + str);
        }
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new MediaBrowserServiceCompat.ServiceImpl.1((MediaBrowserServiceCompat.ServiceImpl)localObject2, paramMessage, str, (Bundle)localObject1, i));
        return;
        localObject1 = mServiceImpl;
        paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(this$0, replyTo);
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new MediaBrowserServiceCompat.ServiceImpl.2((MediaBrowserServiceCompat.ServiceImpl)localObject1, paramMessage));
        return;
        localObject2 = mServiceImpl;
        str = ((Bundle)localObject1).getString("data_media_item_id");
        localObject1 = ((Bundle)localObject1).getBundle("data_options");
        paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(this$0, replyTo);
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new MediaBrowserServiceCompat.ServiceImpl.3((MediaBrowserServiceCompat.ServiceImpl)localObject2, paramMessage, str, (Bundle)localObject1));
        return;
        localObject2 = mServiceImpl;
        str = ((Bundle)localObject1).getString("data_media_item_id");
        localObject1 = ((Bundle)localObject1).getBundle("data_options");
        paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(this$0, replyTo);
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new MediaBrowserServiceCompat.ServiceImpl.4((MediaBrowserServiceCompat.ServiceImpl)localObject2, paramMessage, str, (Bundle)localObject1));
        return;
        paramMessage = mServiceImpl;
        localObject2 = ((Bundle)localObject1).getString("data_media_item_id");
        localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
      } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (localObject1 == null));
      MediaBrowserServiceCompat.access$100(this$0).postOrRun(new MediaBrowserServiceCompat.ServiceImpl.5(paramMessage, (String)localObject2, (ResultReceiver)localObject1));
      return;
    case 6: 
      localObject1 = mServiceImpl;
      paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(this$0, replyTo);
      MediaBrowserServiceCompat.access$100(this$0).postOrRun(new MediaBrowserServiceCompat.ServiceImpl.6((MediaBrowserServiceCompat.ServiceImpl)localObject1, paramMessage));
      return;
    }
    localObject1 = mServiceImpl;
    paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(this$0, replyTo);
    MediaBrowserServiceCompat.access$100(this$0).postOrRun(new MediaBrowserServiceCompat.ServiceImpl.7((MediaBrowserServiceCompat.ServiceImpl)localObject1, paramMessage));
  }
  
  public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    Bundle localBundle = paramMessage.getData();
    localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
    localBundle.putInt("data_calling_uid", Binder.getCallingUid());
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.ServiceHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */