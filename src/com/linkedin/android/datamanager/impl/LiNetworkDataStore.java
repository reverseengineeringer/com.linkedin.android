package com.linkedin.android.datamanager.impl;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequest;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.interfaces.EventListener;
import com.linkedin.android.datamanager.multiplex.MultiplexedRequestContent;
import com.linkedin.android.datamanager.net.DefaultNetworkDataStore;
import com.linkedin.android.datamanager.net.NetworkResponseListener;
import com.linkedin.android.datamanager.perf.NetworkPerfEventListener;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.MultipartRequestBody;
import com.linkedin.android.networking.interfaces.RequestDelegate.ContentType;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.request.DefaultRequestDelegate;
import com.linkedin.android.networking.request.LinkedInRequestBodyFactory;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.data.lite.JsonGenerator;
import com.linkedin.data.lite.JsonGeneratorException;
import com.linkedin.data.lite.JsonGeneratorFactory;
import com.linkedin.data.lite.RecordTemplate;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LiNetworkDataStore
  extends DefaultNetworkDataStore
{
  private static final String TAG = LiNetworkDataStore.class.getSimpleName();
  protected final Context context;
  protected final AbstractNetworkClient networkClient;
  
  public LiNetworkDataStore(AbstractNetworkClient paramAbstractNetworkClient, Context paramContext)
  {
    networkClient = paramAbstractNetworkClient;
    context = paramContext;
  }
  
  private AbstractRequest createBodyRequest(int paramInt, String paramString1, Map<String, String> paramMap, String paramString2, RecordTemplate paramRecordTemplate, NetworkResponseListener<?> paramNetworkResponseListener, boolean paramBoolean)
  {
    if (paramRecordTemplate == null)
    {
      paramNetworkResponseListener.onFailure(-1, null, null, new DataManagerException("Null model", new Object[0]));
      return null;
    }
    RecordTemplate localRecordTemplate = null;
    Object localObject = null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      try
      {
        DataManager.GENERATOR_FACTORY.createJsonGenerator().generate(paramRecordTemplate, new OutputStreamWriter(localByteArrayOutputStream));
        paramRecordTemplate = localByteArrayOutputStream.toByteArray();
        localRecordTemplate = paramRecordTemplate;
      }
      catch (JsonGeneratorException paramRecordTemplate)
      {
        paramRecordTemplate = paramRecordTemplate;
        paramRecordTemplate = new IOException(paramRecordTemplate);
        try
        {
          localByteArrayOutputStream.close();
        }
        catch (IOException paramRecordTemplate) {}
        continue;
      }
      finally {}
      try
      {
        localByteArrayOutputStream.close();
        paramRecordTemplate = (RecordTemplate)localObject;
      }
      catch (IOException paramRecordTemplate) {}
    }
    if (localRecordTemplate == null)
    {
      paramNetworkResponseListener.onFailure(-1, null, null, new DataManagerException("Error serializing model", new Object[] { paramRecordTemplate }));
      return null;
    }
    try
    {
      localByteArrayOutputStream.close();
      throw paramString1;
      if (paramString2 != null)
      {
        paramRecordTemplate = LinkedInRequestBodyFactory.createMultipart();
        paramRecordTemplate.addPart(LinkedInRequestBodyFactory.create("application/x-www-form-urlencoded", paramString2.getBytes()));
        paramRecordTemplate.addPart(LinkedInRequestBodyFactory.create(RequestDelegate.ContentType.JSON_CONTENT_TYPE, localRecordTemplate));
      }
      for (paramString2 = RequestDelegateBuilder.create().setBody(paramRecordTemplate);; paramString2 = RequestDelegateBuilder.create().setBody(LinkedInRequestBodyFactory.create(RequestDelegate.ContentType.JSON_CONTENT_TYPE, localRecordTemplate)))
      {
        if (paramMap != null) {
          paramString2.setAdditionalHeaders(paramMap);
        }
        return getRelativeRequest$243f90fd(paramInt, paramString1, paramNetworkResponseListener, paramString2, paramBoolean);
      }
    }
    catch (IOException paramMap)
    {
      for (;;) {}
    }
  }
  
  private AbstractRequest getRelativeRequest$243f90fd(int paramInt, String paramString, NetworkResponseListener<?> paramNetworkResponseListener, RequestDelegateBuilder paramRequestDelegateBuilder, boolean paramBoolean)
  {
    RequestFactory localRequestFactory = networkClient.getRequestFactory();
    DefaultRequestDelegate localDefaultRequestDelegate = null;
    if (paramRequestDelegateBuilder != null) {
      localDefaultRequestDelegate = requestDelegate;
    }
    paramString = localRequestFactory.getRelativeRequest$3868be9b(paramInt, paramString, paramNetworkResponseListener, localDefaultRequestDelegate);
    absoluteUrl = paramString.getUrl();
    cacheInputResponseStream = paramBoolean;
    return paramString;
  }
  
  public final <RESPONSE extends RecordTemplate<RESPONSE>> void execute(DataRequest<RESPONSE> paramDataRequest, NetworkResponseListener<RESPONSE> paramNetworkResponseListener)
  {
    Object localObject1 = dataRequestWrapper.url;
    Object localObject2 = dataRequestWrapper.model;
    Map localMap2 = dataRequestWrapper.params;
    Map localMap1 = dataRequestWrapper.customHeaders;
    String str1 = dataRequestWrapper.urlEncodedData;
    int i = dataRequestWrapper.timeout;
    switch (paramDataRequest.getMethod())
    {
    }
    do
    {
      do
      {
        return;
        localObject2 = eventListener;
        str1 = dataRequestWrapper.trackingSessionId;
        paramDataRequest = (DataRequest<RESPONSE>)localObject1;
        if (localMap2 != null)
        {
          paramDataRequest = Uri.parse((String)localObject1).buildUpon();
          if (!localMap2.isEmpty())
          {
            localObject1 = localMap2.keySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              String str2 = (String)((Iterator)localObject1).next();
              paramDataRequest.appendQueryParameter(str2, (String)localMap2.get(str2));
            }
          }
          paramDataRequest = paramDataRequest.build().toString();
        }
        localObject1 = null;
        if (localMap1 != null) {
          localObject1 = RequestDelegateBuilder.create().setAdditionalHeaders(localMap1);
        }
        paramDataRequest = getRelativeRequest$243f90fd(0, paramDataRequest, paramNetworkResponseListener, (RequestDelegateBuilder)localObject1, false);
        if ((localObject2 != null) && (str1 != null))
        {
          perfEventListener = new NetworkPerfEventListener((EventListener)localObject2, str1);
          ((EventListener)localObject2).networkRequestEnqueued(str1, paramDataRequest.getUrl());
        }
        networkClient.add(paramDataRequest);
        return;
        paramDataRequest = createBodyRequest(2, (String)localObject1, localMap1, null, (RecordTemplate)localObject2, paramNetworkResponseListener, false);
      } while (paramDataRequest == null);
      networkClient.add(paramDataRequest);
      return;
      localObject2 = networkClient;
      paramDataRequest = null;
      if (localMap1 != null) {
        paramDataRequest = RequestDelegateBuilder.create().setAdditionalHeaders(localMap1);
      }
      ((AbstractNetworkClient)localObject2).add(getRelativeRequest$243f90fd(3, (String)localObject1, paramNetworkResponseListener, paramDataRequest, false));
      return;
      paramNetworkResponseListener = createBodyRequest(1, (String)localObject1, localMap1, str1, (RecordTemplate)localObject2, paramNetworkResponseListener, dataRequestWrapper.model instanceof MultiplexedRequestContent);
      localObject1 = eventListener;
      paramDataRequest = dataRequestWrapper.trackingSessionId;
    } while (paramNetworkResponseListener == null);
    if ((localObject1 != null) && (paramDataRequest != null))
    {
      perfEventListener = new NetworkPerfEventListener((EventListener)localObject1, paramDataRequest);
      ((EventListener)localObject1).networkRequestEnqueued(paramDataRequest, paramNetworkResponseListener.getUrl());
    }
    if (i == 0)
    {
      networkClient.add(paramNetworkResponseListener);
      return;
    }
    socketTimeoutMillis = i;
    networkClient.add(paramNetworkResponseListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.impl.LiNetworkDataStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */