package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.ArrayList;
import java.util.List;

final class MediaBrowserServiceCompat$ServiceCallbacksCompat
  implements MediaBrowserServiceCompat.ServiceCallbacks
{
  final Messenger mCallbacks;
  
  MediaBrowserServiceCompat$ServiceCallbacksCompat(MediaBrowserServiceCompat paramMediaBrowserServiceCompat, Messenger paramMessenger)
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

/* Location:
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacksCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */