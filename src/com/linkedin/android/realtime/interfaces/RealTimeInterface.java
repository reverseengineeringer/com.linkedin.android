package com.linkedin.android.realtime.interfaces;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.realtime.RealTimeConfiguration;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.DataTemplateBuilder;

public abstract interface RealTimeInterface
{
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract RealTimeConfiguration getConfiguration();
  
  public abstract void setCallbackInterface(RealTimeCallbackInterface paramRealTimeCallbackInterface);
  
  public abstract <T extends DataTemplate<T>> void subscribe(Urn paramUrn, DataTemplateBuilder<T> paramDataTemplateBuilder, SubscriberInterface paramSubscriberInterface);
}

/* Location:
 * Qualified Name:     com.linkedin.android.realtime.interfaces.RealTimeInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */