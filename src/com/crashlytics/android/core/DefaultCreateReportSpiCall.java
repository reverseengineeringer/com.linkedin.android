package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class DefaultCreateReportSpiCall
  extends AbstractSpiCall
  implements CreateReportSpiCall
{
  public DefaultCreateReportSpiCall(Kit paramKit, String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory)
  {
    super(paramKit, paramString1, paramString2, paramHttpRequestFactory, HttpMethod.POST);
  }
  
  public final boolean invoke(CreateReportRequest paramCreateReportRequest)
  {
    HttpRequest localHttpRequest = getHttpRequest(Collections.emptyMap()).header("X-CRASHLYTICS-API-KEY", apiKey).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
    CrashlyticsCore.getInstance();
    localHttpRequest = localHttpRequest.header("X-CRASHLYTICS-API-CLIENT-VERSION", "2.3.8.97");
    Iterator localIterator = report.getCustomHeaders().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHttpRequest = localHttpRequest.header((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    paramCreateReportRequest = report;
    paramCreateReportRequest = localHttpRequest.part("report[file]", paramCreateReportRequest.getFileName(), "application/octet-stream", paramCreateReportRequest.getFile()).part$d4ee95d$41e34ca7("report[identifier]", paramCreateReportRequest.getIdentifier());
    Fabric.getLogger().d("CrashlyticsCore", "Sending report to: " + url);
    int i = paramCreateReportRequest.code();
    Fabric.getLogger().d("CrashlyticsCore", "Create report request ID: " + paramCreateReportRequest.header("X-REQUEST-ID"));
    Fabric.getLogger().d("CrashlyticsCore", "Result was: " + i);
    return ResponseParser.parse(i) == 0;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.DefaultCreateReportSpiCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */