package com.google.android.gms.iid;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

final class zzc$1
  extends Handler
{
  zzc$1(zzc paramzzc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    zzc localzzc = zzaNs;
    if (paramMessage != null)
    {
      if ((obj instanceof Intent))
      {
        Object localObject = (Intent)obj;
        ((Intent)localObject).setExtrasClassLoader(MessengerCompat.class.getClassLoader());
        if (((Intent)localObject).hasExtra("google.messenger"))
        {
          localObject = ((Intent)localObject).getParcelableExtra("google.messenger");
          if ((localObject instanceof MessengerCompat)) {
            zzaNm = ((MessengerCompat)localObject);
          }
          if ((localObject instanceof Messenger)) {
            zzaNl = ((Messenger)localObject);
          }
        }
        localzzc.zzw((Intent)obj);
      }
    }
    else {
      return;
    }
    Log.w("InstanceID/Rpc", "Dropping invalid message");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.zzc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */