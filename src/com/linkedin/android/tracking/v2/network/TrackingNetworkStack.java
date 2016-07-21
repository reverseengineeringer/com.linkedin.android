package com.linkedin.android.tracking.v2.network;

import com.linkedin.android.litrackinglib.network.IRequestData;
import com.linkedin.android.litrackinglib.network.IResponseHandler;

public abstract interface TrackingNetworkStack
{
  public abstract void postData(IRequestData paramIRequestData, IResponseHandler paramIResponseHandler);
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.network.TrackingNetworkStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */