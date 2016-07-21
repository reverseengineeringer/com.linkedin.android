package android.support.v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class MediaBrowserServiceCompat
  extends Service
{
  private final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap();
  private final ServiceHandler mHandler = new ServiceHandler((byte)0);
  MediaSessionCompat.Token mSession;
  
  public abstract BrowserRoot onGetRoot$16f11348();
  
  public static final class BrowserRoot
  {
    final Bundle mExtras;
    final String mRootId;
  }
  
  private final class ConnectionRecord
  {
    MediaBrowserServiceCompat.ServiceCallbacks callbacks;
    String pkg;
    MediaBrowserServiceCompat.BrowserRoot root;
    Bundle rootHints;
    HashMap<String, List<Bundle>> subscriptions = new HashMap();
    
    private ConnectionRecord() {}
  }
  
  public static class Result<T>
  {
    Object mDebug;
    private boolean mDetachCalled;
    int mFlags;
    boolean mSendResultCalled;
    
    Result(Object paramObject)
    {
      mDebug = paramObject;
    }
    
    final boolean isDone()
    {
      return (mDetachCalled) || (mSendResultCalled);
    }
    
    void onResultSent$4cfcfd12(int paramInt) {}
  }
  
  private static abstract interface ServiceCallbacks
  {
    public abstract IBinder asBinder();
    
    public abstract void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException;
    
    public abstract void onConnectFailed()
      throws RemoteException;
    
    public abstract void onLoadChildren(String paramString, List<Object> paramList, Bundle paramBundle)
      throws RemoteException;
  }
  
  private final class ServiceCallbacksCompat
    implements MediaBrowserServiceCompat.ServiceCallbacks
  {
    final Messenger mCallbacks;
    
    ServiceCallbacksCompat(Messenger paramMessenger)
    {
      mCallbacks = paramMessenger;
    }
    
    private void sendRequest(int paramInt, Bundle paramBundle)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      what = paramInt;
      arg1 = 1;
      localMessage.setData(paramBundle);
      mCallbacks.send(localMessage);
    }
    
    public final IBinder asBinder()
    {
      return mCallbacks.getBinder();
    }
    
    public final void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("extra_service_version", 1);
      paramBundle = new Bundle();
      paramBundle.putString("data_media_item_id", paramString);
      paramBundle.putParcelable("data_media_session_token", paramToken);
      paramBundle.putBundle("data_root_hints", localBundle);
      sendRequest(1, paramBundle);
    }
    
    public final void onConnectFailed()
      throws RemoteException
    {
      sendRequest(2, null);
    }
    
    public final void onLoadChildren(String paramString, List<Object> paramList, Bundle paramBundle)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putBundle("data_options", paramBundle);
      if (paramList != null) {
        if (!(paramList instanceof ArrayList)) {
          break label57;
        }
      }
      label57:
      for (paramString = (ArrayList)paramList;; paramString = new ArrayList(paramList))
      {
        localBundle.putParcelableArrayList("data_media_item_list", paramString);
        sendRequest(3, localBundle);
        return;
      }
    }
  }
  
  private final class ServiceHandler
    extends Handler
  {
    private final MediaBrowserServiceCompat.ServiceImpl mServiceImpl = new MediaBrowserServiceCompat.ServiceImpl(MediaBrowserServiceCompat.this, (byte)0);
    
    private ServiceHandler() {}
    
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
          paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, replyTo);
          if (!MediaBrowserServiceCompat.access$400(this$0, str, i)) {
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + str);
          }
          this$0.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.1((MediaBrowserServiceCompat.ServiceImpl)localObject2, paramMessage, str, (Bundle)localObject1, i));
          return;
          localObject1 = mServiceImpl;
          paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, replyTo);
          this$0.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.2((MediaBrowserServiceCompat.ServiceImpl)localObject1, paramMessage));
          return;
          localObject2 = mServiceImpl;
          str = ((Bundle)localObject1).getString("data_media_item_id");
          localObject1 = ((Bundle)localObject1).getBundle("data_options");
          paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, replyTo);
          this$0.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.3((MediaBrowserServiceCompat.ServiceImpl)localObject2, paramMessage, str, (Bundle)localObject1));
          return;
          localObject2 = mServiceImpl;
          str = ((Bundle)localObject1).getString("data_media_item_id");
          localObject1 = ((Bundle)localObject1).getBundle("data_options");
          paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, replyTo);
          this$0.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.4((MediaBrowserServiceCompat.ServiceImpl)localObject2, paramMessage, str, (Bundle)localObject1));
          return;
          paramMessage = mServiceImpl;
          localObject2 = ((Bundle)localObject1).getString("data_media_item_id");
          localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
        } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (localObject1 == null));
        this$0.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.5(paramMessage, (String)localObject2, (ResultReceiver)localObject1));
        return;
      case 6: 
        localObject1 = mServiceImpl;
        paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, replyTo);
        this$0.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.6((MediaBrowserServiceCompat.ServiceImpl)localObject1, paramMessage));
        return;
      }
      localObject1 = mServiceImpl;
      paramMessage = new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, replyTo);
      this$0.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.7((MediaBrowserServiceCompat.ServiceImpl)localObject1, paramMessage));
    }
    
    public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
  
  private final class ServiceImpl
  {
    private ServiceImpl() {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */