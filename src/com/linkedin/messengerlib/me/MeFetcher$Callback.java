package com.linkedin.messengerlib.me;

import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;

public abstract interface MeFetcher$Callback
{
  public abstract void onResponse(MiniProfile paramMiniProfile);
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.me.MeFetcher.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */