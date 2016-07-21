package com.linkedin.android.datamanager;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.EventListener;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.datamanager.multiplex.IndividualBody;
import com.linkedin.android.datamanager.multiplex.IndividualRequest;
import com.linkedin.android.datamanager.multiplex.IndividualRequest.Builder;
import com.linkedin.android.datamanager.multiplex.IndividualResponse;
import com.linkedin.android.datamanager.multiplex.MultiplexedResponseContent;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;

final class MultiplexSubmitter
{
  final DataManager dataManager;
  
  public MultiplexSubmitter(DataManager paramDataManager)
  {
    dataManager = paramDataManager;
  }
  
  private static IndividualRequest.Builder buildIndividualRequest(String paramString, List<DataRequestWrapper<?>> paramList, int paramInt)
    throws JSONException, UnsupportedEncodingException
  {
    DataRequestWrapper localDataRequestWrapper = (DataRequestWrapper)paramList.get(paramInt);
    paramList = new IndividualRequest.Builder();
    String str = method;
    if (str == null)
    {
      hasMethod = false;
      method = null;
      paramString = url.replace(paramString, "");
      if (paramString != null) {
        break label136;
      }
      hasRelativeUrl = false;
    }
    for (relativeUrl = null;; relativeUrl = paramString)
    {
      if (model != null)
      {
        paramString = new IndividualBody(model);
        hasBody = true;
        body = paramString;
      }
      if (customHeaders != null)
      {
        paramString = customHeaders;
        if (paramString != null) {
          break label149;
        }
        hasHeaders = false;
        headers = null;
      }
      return paramList;
      hasMethod = true;
      method = str;
      break;
      label136:
      hasRelativeUrl = true;
    }
    label149:
    hasHeaders = true;
    headers = paramString;
    return paramList;
  }
  
  final Map<String, IndividualRequest> buildRequestMap(MultiplexRequest paramMultiplexRequest, List<DataRequestWrapper<?>> paramList, String paramString, int paramInt)
    throws IOException, JSONException, BuilderException
  {
    if (paramInt >= paramList.size())
    {
      paramMultiplexRequest = Collections.emptyMap();
      return paramMultiplexRequest;
    }
    if (isParallel)
    {
      localObject = new ArrayMap();
      int i = paramList.size();
      for (;;)
      {
        paramMultiplexRequest = (MultiplexRequest)localObject;
        if (paramInt >= i) {
          break;
        }
        ((Map)localObject).put(String.valueOf(paramInt), buildIndividualRequest(paramString, paramList, paramInt).build(RecordTemplate.Flavor.RECORD));
        paramInt += 1;
      }
    }
    Object localObject = buildIndividualRequest(paramString, paramList, paramInt);
    paramMultiplexRequest = buildRequestMap(paramMultiplexRequest, paramList, paramString, paramInt + 1);
    if (paramMultiplexRequest == null) {
      hasDependentRequests = false;
    }
    for (dependentRequests = null;; dependentRequests = paramMultiplexRequest)
    {
      return Collections.singletonMap(String.valueOf(paramInt), ((IndividualRequest.Builder)localObject).build(RecordTemplate.Flavor.RECORD));
      hasDependentRequests = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.MultiplexSubmitter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */