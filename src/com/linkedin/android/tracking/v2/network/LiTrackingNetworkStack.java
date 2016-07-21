package com.linkedin.android.tracking.v2.network;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.litrackinglib.network.IRequestData;
import com.linkedin.android.litrackinglib.network.IResponseHandler;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RequestDelegate.ContentType;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.request.LinkedInRequestBodyFactory;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import java.util.Map;

public class LiTrackingNetworkStack
  implements TrackingNetworkStack
{
  public static boolean SHOULD_GZIP_REQUEST_BODY = false;
  private static final String TAG = LiTrackingNetworkStack.class.getSimpleName();
  private Context appContext;
  private AbstractNetworkClient networkClient;
  
  public LiTrackingNetworkStack(Context paramContext, AbstractNetworkClient paramAbstractNetworkClient)
  {
    appContext = paramContext.getApplicationContext();
    networkClient = paramAbstractNetworkClient;
  }
  
  public final void postData(IRequestData paramIRequestData, IResponseHandler paramIResponseHandler)
  {
    RequestDelegateBuilder localRequestDelegateBuilder = RequestDelegateBuilder.create();
    Object localObject = paramIRequestData.getRequestHeaders();
    ArrayMap localArrayMap = new ArrayMap();
    if (localObject != null) {
      localArrayMap.putAll((Map)localObject);
    }
    localObject = paramIRequestData.getPostBody();
    if (localObject != null) {
      localRequestDelegateBuilder.setBody(LinkedInRequestBodyFactory.create(RequestDelegate.ContentType.JSON_CONTENT_TYPE, ((String)localObject).getBytes(), SHOULD_GZIP_REQUEST_BODY));
    }
    localRequestDelegateBuilder.setAdditionalHeaders(localArrayMap);
    paramIResponseHandler = new NetworkResponseListener(paramIRequestData, paramIResponseHandler);
    paramIRequestData = networkClient.getRequestFactory().getAbsoluteRequest$3868be9b(1, paramIRequestData.getRequestUrl(), paramIResponseHandler, requestDelegate);
    FeatureLog.d(TAG, "Sending Request.. " + paramIRequestData.toString(), "Tracking");
    networkClient.add(paramIRequestData);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.network.LiTrackingNetworkStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */