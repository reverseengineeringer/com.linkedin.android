package com.linkedin.android.networking;

import android.content.Context;
import android.util.Log;
import com.linkedin.android.networking.brotli.BrotliInputStream;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.networking.interfaces.InternationalizationApi;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.RequestDelegate;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.response.LinkedInRawResponse;
import com.linkedin.android.networking.streams.CachingInputStream;
import com.linkedin.android.networking.util.ByteArrayPool;
import com.linkedin.android.networking.util.ExceptionUtil;
import com.linkedin.android.networking.util.HeaderUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

public class LinkedInNetwork
{
  public static final ByteArrayPool BYTE_ARRAY_POOL;
  private static final ResponseListener<Object, Object> DUMMY_RESPONSE_LISTENER = new ResponseListener()
  {
    public final void onFailure(int paramAnonymousInt, Object paramAnonymousObject, Map<String, List<String>> paramAnonymousMap, IOException paramAnonymousIOException) {}
    
    public final void onSuccess(int paramAnonymousInt, Object paramAnonymousObject, Map<String, List<String>> paramAnonymousMap) {}
    
    public final Object parseErrorResponse(RawResponse paramAnonymousRawResponse)
      throws IOException
    {
      return null;
    }
    
    public final Object parseSuccessResponse(RawResponse paramAnonymousRawResponse)
      throws IOException
    {
      return null;
    }
  };
  private static final RequestBody EMPTY_REQUEST_BODY;
  public static boolean ENABLE_BROTLI;
  private static final String TAG = LinkedInNetwork.class.getSimpleName();
  private final CookieUtil cookieUtil;
  private final InternationalizationApi internationalizationApi;
  private boolean isBrotliLibraryLoaded = false;
  private boolean loadBrotliRan = false;
  private final AbstractNetworkClient networkHelper;
  public final OkHttpClient okHttpClient;
  
  static
  {
    BYTE_ARRAY_POOL = new ByteArrayPool();
    ENABLE_BROTLI = false;
    EMPTY_REQUEST_BODY = RequestBody.create(null, new byte[0]);
  }
  
  public LinkedInNetwork(AbstractNetworkClient paramAbstractNetworkClient, OkHttpClient paramOkHttpClient, CookieUtil paramCookieUtil, InternationalizationApi paramInternationalizationApi)
  {
    networkHelper = paramAbstractNetworkClient;
    okHttpClient = paramOkHttpClient;
    cookieUtil = paramCookieUtil;
    internationalizationApi = paramInternationalizationApi;
  }
  
  /* Error */
  private static RequestBody getRequestBody(AbstractRequest paramAbstractRequest, Request.Builder paramBuilder)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 383	com/linkedin/android/networking/request/AbstractRequest:requestDelegate	Lcom/linkedin/android/networking/interfaces/RequestDelegate;
    //   4: ifnull +29 -> 33
    //   7: aload_0
    //   8: getfield 383	com/linkedin/android/networking/request/AbstractRequest:requestDelegate	Lcom/linkedin/android/networking/interfaces/RequestDelegate;
    //   11: invokeinterface 389 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +15 -> 33
    //   21: aload_2
    //   22: astore_0
    //   23: aload_0
    //   24: ifnonnull +17 -> 41
    //   27: getstatic 64	com/linkedin/android/networking/LinkedInNetwork:EMPTY_REQUEST_BODY	Lokhttp3/RequestBody;
    //   30: astore_2
    //   31: aload_2
    //   32: areturn
    //   33: aload_0
    //   34: getfield 393	com/linkedin/android/networking/request/AbstractRequest:requestBody	Lcom/linkedin/android/networking/interfaces/RequestBody;
    //   37: astore_0
    //   38: goto -15 -> 23
    //   41: aload_0
    //   42: instanceof 395
    //   45: ifeq +83 -> 128
    //   48: aload_0
    //   49: checkcast 395	com/linkedin/android/networking/interfaces/MultipartRequestBody
    //   52: astore_1
    //   53: aload_1
    //   54: instanceof 397
    //   57: ifeq +13 -> 70
    //   60: aload_1
    //   61: checkcast 397	com/linkedin/android/networking/request/LinkedInRequestBodyFactory$OkHttpWrapperMultipartRequestBody
    //   64: invokeinterface 401 1 0
    //   69: areturn
    //   70: new 403	okhttp3/MultipartBody$Builder
    //   73: dup
    //   74: invokespecial 404	okhttp3/MultipartBody$Builder:<init>	()V
    //   77: astore_0
    //   78: aload_1
    //   79: invokeinterface 408 1 0
    //   84: invokeinterface 414 1 0
    //   89: astore_1
    //   90: aload_1
    //   91: invokeinterface 420 1 0
    //   96: ifeq +27 -> 123
    //   99: aload_0
    //   100: aconst_null
    //   101: aload_1
    //   102: invokeinterface 424 1 0
    //   107: checkcast 426	com/linkedin/android/networking/interfaces/RequestBody
    //   110: invokestatic 431	com/linkedin/android/networking/request/LinkedInRequestBodyAdapter:getRequestBody	(Lcom/linkedin/android/networking/interfaces/RequestBody;)Lokhttp3/RequestBody;
    //   113: invokestatic 436	okhttp3/MultipartBody$Part:create	(Lokhttp3/Headers;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Part;
    //   116: invokevirtual 440	okhttp3/MultipartBody$Builder:addPart	(Lokhttp3/MultipartBody$Part;)Lokhttp3/MultipartBody$Builder;
    //   119: pop
    //   120: goto -30 -> 90
    //   123: aload_0
    //   124: invokevirtual 442	okhttp3/MultipartBody$Builder:build	()Lokhttp3/MultipartBody;
    //   127: areturn
    //   128: aload_0
    //   129: invokestatic 431	com/linkedin/android/networking/request/LinkedInRequestBodyAdapter:getRequestBody	(Lcom/linkedin/android/networking/interfaces/RequestBody;)Lokhttp3/RequestBody;
    //   132: astore_3
    //   133: aload_3
    //   134: astore_2
    //   135: aload_0
    //   136: invokeinterface 445 1 0
    //   141: ifeq -110 -> 31
    //   144: new 447	com/linkedin/android/networking/request/LinkedInRequestBodyAdapter$2
    //   147: dup
    //   148: aload_3
    //   149: invokespecial 450	com/linkedin/android/networking/request/LinkedInRequestBodyAdapter$2:<init>	(Lokhttp3/RequestBody;)V
    //   152: astore_2
    //   153: new 452	okio/Buffer
    //   156: dup
    //   157: invokespecial 453	okio/Buffer:<init>	()V
    //   160: astore_3
    //   161: aload_2
    //   162: aload_3
    //   163: invokevirtual 457	okhttp3/RequestBody:writeTo	(Lokio/BufferedSink;)V
    //   166: new 459	com/linkedin/android/networking/request/LinkedInRequestBodyAdapter$1
    //   169: dup
    //   170: aload_2
    //   171: aload_3
    //   172: invokespecial 462	com/linkedin/android/networking/request/LinkedInRequestBodyAdapter$1:<init>	(Lokhttp3/RequestBody;Lokio/Buffer;)V
    //   175: astore_2
    //   176: aload_1
    //   177: getfield 467	okhttp3/Request$Builder:headers	Lokhttp3/Headers$Builder;
    //   180: ldc_w 469
    //   183: ldc_w 471
    //   186: invokevirtual 476	okhttp3/Headers$Builder:add	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;
    //   189: pop
    //   190: aload_2
    //   191: areturn
    //   192: astore_1
    //   193: getstatic 47	com/linkedin/android/networking/LinkedInNetwork:TAG	Ljava/lang/String;
    //   196: ldc_w 478
    //   199: aload_1
    //   200: invokestatic 325	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   203: pop
    //   204: aload_0
    //   205: invokestatic 431	com/linkedin/android/networking/request/LinkedInRequestBodyAdapter:getRequestBody	(Lcom/linkedin/android/networking/interfaces/RequestBody;)Lokhttp3/RequestBody;
    //   208: areturn
    //   209: astore_1
    //   210: goto -17 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramAbstractRequest	AbstractRequest
    //   0	213	1	paramBuilder	Request.Builder
    //   16	175	2	localObject1	Object
    //   132	40	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   144	176	192	java/io/IOException
    //   176	190	209	java/io/IOException
  }
  
  private static ResponseListener getResponseListener(AbstractRequest paramAbstractRequest)
  {
    if ((isCanceled) || (responseListener == null)) {
      return DUMMY_RESPONSE_LISTENER;
    }
    return responseListener;
  }
  
  public static InputStream getUncompressedInputStream(ResponseBody paramResponseBody, String paramString, long paramLong, boolean paramBoolean)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      if ("br".equals(paramString)) {
        localObject1 = new BrotliInputStream(paramResponseBody.byteStream(), BYTE_ARRAY_POOL);
      }
    }
    else {
      if (localObject1 != null) {
        break label125;
      }
    }
    label125:
    for (paramResponseBody = paramResponseBody.byteStream();; paramResponseBody = (ResponseBody)localObject1)
    {
      if (paramBoolean)
      {
        if (paramLong > 2147483647L)
        {
          throw new IOException("Cannot cache input streams longer than INT_MAX");
          localObject1 = localObject2;
          if (!"gzip".equals(paramString)) {
            break;
          }
          localObject1 = Okio.buffer(new GzipSource(paramResponseBody.source())).inputStream();
          break;
        }
        return new CachingInputStream(paramResponseBody, BYTE_ARRAY_POOL, (int)paramLong);
      }
      return paramResponseBody;
    }
  }
  
  public final Request getOkHttpRequest(AbstractRequest paramAbstractRequest)
    throws IOException
  {
    Request.Builder localBuilder = new Request.Builder();
    localBuilder.url(paramAbstractRequest.getUrl());
    Object localObject = networkHelper.customHeaders.entrySet().iterator();
    Map.Entry localEntry;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localBuilder.header((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localObject = paramAbstractRequest.getHeaders().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localBuilder.header((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    if ((ENABLE_BROTLI) && (!loadBrotliRan)) {}
    try
    {
      System.loadLibrary("Brotli");
      isBrotliLibraryLoaded = true;
      loadBrotliRan = true;
      if ((ENABLE_BROTLI) && (isBrotliLibraryLoaded))
      {
        HeaderUtil.setAcceptEncodingHeader(localBuilder, "br, gzip");
        HeaderUtil.setCsrfHeader(localBuilder, cookieUtil, paramAbstractRequest.getUrl());
        localObject = networkHelper.appContext;
        paramAbstractRequest.getUrl();
        HeaderUtil.setDefaultHeaders$515aa7a8(localBuilder, (Context)localObject, networkHelper.getStoreId(), networkHelper.getAdvertiserId(), networkHelper.isAdTrackingLimited(), networkHelper.getMpName(), networkHelper.getMpVersion());
        HeaderUtil.setLangHeader(localBuilder, networkHelper.getLang());
        if (!isCacheable)
        {
          localObject = new CacheControl.Builder();
          noStore = true;
          localObject = ((CacheControl.Builder)localObject).build().toString();
          if (!((String)localObject).isEmpty()) {
            break label428;
          }
          localBuilder.removeHeader("Cache-Control");
        }
        if ((requestDelegate == null) || (!requestDelegate.isRequestMethodTypeOverride())) {
          break label441;
        }
        i = requestDelegate.getRequestMethodType();
        switch (i)
        {
        default: 
          return localBuilder.build();
        }
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Log.e(TAG, "UnsatisfiedLinkError while loading Brotli native library", localUnsatisfiedLinkError);
        continue;
        HeaderUtil.setAcceptEncodingHeader(localBuilder, "gzip");
        continue;
        label428:
        localBuilder.header("Cache-Control", localUnsatisfiedLinkError);
        continue;
        label441:
        int i = method;
        continue;
        localBuilder.method("GET", null);
        continue;
        localBuilder.method("POST", getRequestBody(paramAbstractRequest, localBuilder));
        continue;
        localBuilder.method("PUT", getRequestBody(paramAbstractRequest, localBuilder));
        continue;
        localBuilder.method("DELETE", getRequestBody(paramAbstractRequest, localBuilder));
        continue;
        localBuilder.method("PATCH", getRequestBody(paramAbstractRequest, localBuilder));
        continue;
        localBuilder.method("HEAD", null);
      }
    }
  }
  
  public final void performRequest(final AbstractRequest paramAbstractRequest)
  {
    okHttpClient.dispatcher.executorService().submit(new Runnable()
    {
      public final void run()
      {
        LinkedInNetwork.access$000(LinkedInNetwork.this, paramAbstractRequest);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.LinkedInNetwork
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */