package com.linkedin.android.datamanager;

import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MultiplexRequest$Builder
{
  private final List<DataRequestWrapper.Builder<?>> builders = new ArrayList();
  public MultiplexCompletionCallback completionCallback;
  public Map<String, String> customHeaders;
  private DataManager.DataStoreFilter filter;
  private final boolean isParallel;
  public String multiplexerUrl;
  private final SparseIntArray requiredRequests = new SparseIntArray();
  public int timeout;
  public String trackingSessionId;
  
  private MultiplexRequest$Builder(boolean paramBoolean, DataManager.DataStoreFilter paramDataStoreFilter)
  {
    filter = paramDataStoreFilter;
    isParallel = paramBoolean;
  }
  
  public static Builder parallel()
  {
    return new Builder(true, DataManager.DataStoreFilter.ALL);
  }
  
  public static Builder sequential()
  {
    return new Builder(false, DataManager.DataStoreFilter.NETWORK_ONLY);
  }
  
  public final MultiplexRequest build()
  {
    if (multiplexerUrl == null) {
      throw new IllegalArgumentException("Must include multiplexer url");
    }
    ArrayList localArrayList = new ArrayList(builders.size());
    int i = 0;
    int j = builders.size();
    while (i < j)
    {
      DataRequestWrapper.Builder localBuilder = (DataRequestWrapper.Builder)builders.get(i);
      trackingSessionId = trackingSessionId;
      customHeaders = customHeaders;
      filter = DataManager.DataStoreFilter.LOCAL_ONLY;
      localArrayList.add(localBuilder.build());
      i += 1;
    }
    return new MultiplexRequest(multiplexerUrl, localArrayList, requiredRequests, filter, completionCallback, isParallel, trackingSessionId, customHeaders, timeout, (byte)0);
  }
  
  public final Builder filter(DataManager.DataStoreFilter paramDataStoreFilter)
  {
    if (isParallel) {
      filter = paramDataStoreFilter;
    }
    return this;
  }
  
  public final Builder optional(DataRequestWrapper.Builder<?> paramBuilder)
  {
    requiredRequests.put(builders.size(), 1);
    builders.add(paramBuilder);
    return this;
  }
  
  public final Builder required(DataRequestWrapper.Builder<?> paramBuilder)
  {
    requiredRequests.put(builders.size(), 0);
    builders.add(paramBuilder);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.MultiplexRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */