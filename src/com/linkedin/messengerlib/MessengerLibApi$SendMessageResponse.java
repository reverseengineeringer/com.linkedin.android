package com.linkedin.messengerlib;

import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse;

public abstract interface MessengerLibApi$SendMessageResponse
{
  public abstract void onError(Exception paramException);
  
  public abstract void onResponse(EventCreateResponse paramEventCreateResponse);
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.MessengerLibApi.SendMessageResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */