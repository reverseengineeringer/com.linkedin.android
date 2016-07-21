package com.linkedin.android.networking;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.SparseArray;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.networking.cookies.SetCookieInterceptor;
import com.linkedin.android.networking.dns.LinkedInDns;
import com.linkedin.android.networking.interfaces.InternationalizationApi;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseDelivery;
import com.linkedin.android.networking.interfaces.StatusCodeHandler;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.response.MainThreadResponseDelivery;
import com.linkedin.android.networking.util.StatusCodeRegistry;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.internal.Util;

public abstract class AbstractNetworkClient
{
  private static final String TAG = AbstractNetworkClient.class.getSimpleName();
  public final Context appContext;
  public final CookieUtil cookieUtil;
  public final Map<String, String> customHeaders = new ArrayMap();
  private final DownloadManager downloadManager;
  private final InternationalizationApi i18n;
  public final LinkedInNetwork network;
  private final OkHttpClient okHttpClient;
  final ResponseDelivery responseDelivery;
  final StatusCodeRegistry statusCodeRegistry;
  
  public AbstractNetworkClient(Context paramContext, InternationalizationApi paramInternationalizationApi)
  {
    this(paramContext, paramInternationalizationApi, new CookieUtil(paramContext));
  }
  
  private AbstractNetworkClient(Context paramContext, InternationalizationApi paramInternationalizationApi, CookieUtil paramCookieUtil)
  {
    appContext = paramContext.getApplicationContext();
    cookieUtil = paramCookieUtil;
    okHttpClient = buildOkHttpClient(paramCookieUtil.cookieJar()).build();
    statusCodeRegistry = new StatusCodeRegistry();
    i18n = paramInternationalizationApi;
    responseDelivery = new MainThreadResponseDelivery();
    network = new LinkedInNetwork(this, okHttpClient, paramCookieUtil, i18n);
    downloadManager = new DownloadManager(this);
  }
  
  private OkHttpClient.Builder buildOkHttpClient(CookieJar paramCookieJar)
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    LinkedInDns localLinkedInDns = new LinkedInDns(forceIpv4NetworkStrategy());
    Object localObject = getInterceptors();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localBuilder.addInterceptor((Interceptor)((Iterator)localObject).next());
      }
    }
    localBuilder.addInterceptor(new SetCookieInterceptor(this));
    dns = localLinkedInDns;
    if (paramCookieJar == null) {
      throw new NullPointerException("cookieJar == null");
    }
    cookieJar = paramCookieJar;
    dispatcher = new Dispatcher(getDispatchExecutor());
    paramCookieJar = TimeUnit.MILLISECONDS;
    if (10000L < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramCookieJar == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l = paramCookieJar.toMillis(10000L);
    if (l > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    if ((l == 0L) && (10000L > 0L)) {
      throw new IllegalArgumentException("Timeout too small.");
    }
    connectTimeout = ((int)l);
    paramCookieJar = localBuilder.readTimeout(10000L, TimeUnit.MILLISECONDS).writeTimeout(10000L, TimeUnit.MILLISECONDS);
    cache = getCache();
    internalCache = null;
    return paramCookieJar;
  }
  
  public final void add(AbstractRequest paramAbstractRequest)
  {
    network.performRequest(paramAbstractRequest);
  }
  
  public boolean forceIpv4NetworkStrategy()
  {
    return false;
  }
  
  public abstract String getAdvertiserId();
  
  public Cache getCache()
  {
    return null;
  }
  
  public ExecutorService getDispatchExecutor()
  {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
  }
  
  public List<Interceptor> getInterceptors()
  {
    return null;
  }
  
  public final String getLang()
  {
    if (i18n == null) {
      return null;
    }
    return i18n.getCurrentLocale();
  }
  
  public abstract String getMpName();
  
  public abstract String getMpVersion();
  
  public abstract RequestFactory getRequestFactory();
  
  public abstract String getStoreId();
  
  public abstract boolean isAdTrackingLimited();
  
  public final AbstractNetworkClient registerStatusCodeHandler(int paramInt, StatusCodeHandler paramStatusCodeHandler)
  {
    statusCodeRegistry.handlers.put(paramInt, paramStatusCodeHandler);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.AbstractNetworkClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */