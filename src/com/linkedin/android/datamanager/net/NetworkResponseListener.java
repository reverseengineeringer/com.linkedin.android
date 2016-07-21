package com.linkedin.android.datamanager.net;

import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequest;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataRequestWrapper.Builder;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.EventListener;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import com.linkedin.data.lite.RecordTemplate;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class NetworkResponseListener<RESPONSE extends RecordTemplate<RESPONSE>>
  implements ResponseListener<RESPONSE, byte[]>
{
  private static final String TAG = NetworkResponseListener.class.getSimpleName();
  public String absoluteUrl;
  public boolean cacheInputResponseStream;
  private final DataManager manager;
  private final DataRequest<RESPONSE> request;
  
  public NetworkResponseListener(DataManager paramDataManager, DataRequest<RESPONSE> paramDataRequest)
  {
    request = paramDataRequest;
    manager = paramDataManager;
  }
  
  private RESPONSE parseSuccessResponse(RawResponse paramRawResponse)
    throws IOException
  {
    if (manager.isCancelled(request)) {
      localObject1 = null;
    }
    DataTemplateBuilder localDataTemplateBuilder;
    String str1;
    do
    {
      do
      {
        return (RESPONSE)localObject1;
        manager.cancelLowerPrecedenceRequests(request);
        localDataTemplateBuilder = request.dataRequestWrapper.builder;
        if ((localDataTemplateBuilder == null) && (request.getMethod() == 0)) {
          throw new DataManagerException("Null ModelBuilder for GET Request", new Object[0]);
        }
        Object localObject2 = null;
        str1 = request.dataRequestWrapper.url;
        if (absoluteUrl != null) {}
        EventListener localEventListener;
        String str2;
        InputStream localInputStream;
        for (localObject1 = absoluteUrl;; localObject1 = str1)
        {
          localEventListener = request.eventListener;
          str2 = request.dataRequestWrapper.trackingSessionId;
          try
          {
            localInputStream = paramRawResponse.body(cacheInputResponseStream);
            if ((localInputStream != null) || (request.getMethod() != 0)) {
              break;
            }
            throw new DataManagerException("Null data", new Object[0]);
          }
          finally
          {
            if ((localEventListener != null) && (str2 != null)) {
              localEventListener.parsingDidEnd(str2, (String)localObject1);
            }
          }
        }
        if ((localEventListener != null) && (str2 != null)) {
          localEventListener.parsingWillStart(str2, (String)localObject1);
        }
        paramRawResponse = (RawResponse)localObject2;
        if (localDataTemplateBuilder != null) {
          paramRawResponse = DataManager.PARSER_FACTORY.createParser();
        }
        try
        {
          paramRawResponse = paramRawResponse.parseRecord(localInputStream, localDataTemplateBuilder);
          if ((localEventListener != null) && (str2 != null)) {
            localEventListener.parsingDidEnd(str2, (String)localObject1);
          }
          if ((paramRawResponse == null) && (request.getMethod() == 0)) {
            throw new DataManagerException("Null model", new Object[0]);
          }
        }
        catch (DataReaderException paramRawResponse)
        {
          throw new IOException(paramRawResponse);
        }
        localObject1 = paramRawResponse;
      } while (request.getMethod() != 0);
      localObject1 = paramRawResponse;
    } while (!request.dataRequestWrapper.updateCache);
    Object localObject1 = DataRequestWrapper.put().url(str1).model(paramRawResponse).builder(localDataTemplateBuilder).filter(DataManager.DataStoreFilter.LOCAL_ONLY).build();
    manager.submit((DataRequestWrapper)localObject1);
    return paramRawResponse;
  }
  
  public final void onFailure(final int paramInt, final byte[] paramArrayOfByte, final Map<String, List<String>> paramMap, IOException paramIOException)
  {
    if (manager.isCancelled(request)) {
      return;
    }
    manager.removeRequestFromPool(request);
    if (paramInt == 404) {
      manager.process404Response(request.dataRequestWrapper.url, request.dataRequestWrapper.cacheKey, paramMap);
    }
    paramArrayOfByte = new DataManagerException(paramIOException, new RawResponse()
    {
      public final InputStream body(boolean paramAnonymousBoolean)
        throws IOException
      {
        if (paramAnonymousBoolean) {
          throw new IOException("Caching streams unsupported for error responses");
        }
        if (paramArrayOfByte == null) {
          return null;
        }
        return new ByteArrayInputStream(paramArrayOfByte);
      }
      
      public final int code()
      {
        return paramInt;
      }
      
      public final long contentLength()
      {
        if (paramArrayOfByte == null) {
          return 0L;
        }
        return paramArrayOfByte.length;
      }
      
      public final String getHeader(String paramAnonymousString)
      {
        if (paramMap == null) {}
        do
        {
          return null;
          paramAnonymousString = (List)paramMap.get(paramAnonymousString);
        } while ((paramAnonymousString == null) || (paramAnonymousString.isEmpty()));
        return (String)paramAnonymousString.get(0);
      }
      
      public final Map<String, List<String>> headers()
      {
        return paramMap;
      }
    });
    request.callListeners(DataStoreResponse.errorResponse(request.dataRequestWrapper, request.getType(), paramArrayOfByte));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.net.NetworkResponseListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */