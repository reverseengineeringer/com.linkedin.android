package com.conviva.session;

import com.conviva.utils.CallableWithParameters.With0;

public final class Session$1ConfigLoaded
  implements CallableWithParameters.With0
{
  public Session$1ConfigLoaded(Session paramSession) {}
  
  public final void exec()
  {
    this$0.sendHeartbeat();
    this$0.createHBTimer();
  }
}

/* Location:
 * Qualified Name:     com.conviva.session.Session.1ConfigLoaded
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */