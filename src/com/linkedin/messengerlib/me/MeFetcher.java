package com.linkedin.messengerlib.me;

import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.shared.FragmentComponent;

public final class MeFetcher
{
  public static MiniProfile meProfile;
  
  public static void getMe(FragmentComponent paramFragmentComponent, Callback paramCallback)
  {
    MessengerLibApi localMessengerLibApi = paramFragmentComponent.libApi();
    if (meProfile != null) {
      paramCallback.onResponse(meProfile);
    }
    while (localMessengerLibApi == null) {
      return;
    }
    localMessengerLibApi.getMe(new MeFetcher.1(paramFragmentComponent, paramCallback));
  }
  
  public static abstract interface Callback
  {
    public abstract void onResponse(MiniProfile paramMiniProfile);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.me.MeFetcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */