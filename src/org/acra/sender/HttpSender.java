package org.acra.sender;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.log.ACRALog;
import org.acra.util.HttpRequest;
import org.acra.util.JSONReportBuilder;
import org.acra.util.JSONReportBuilder.JSONReportException;
import org.json.JSONObject;

public final class HttpSender
  implements ReportSender
{
  private final Uri mFormUri;
  private final Map<ReportField, String> mMapping;
  private final Method mMethod;
  private String mPassword;
  private final Type mType;
  private String mUsername;
  
  public HttpSender(Method paramMethod, Type paramType)
  {
    mMethod = paramMethod;
    mFormUri = null;
    mMapping = null;
    mType = paramType;
    mUsername = null;
    mPassword = null;
  }
  
  private Map<String, String> remap(Map<ReportField, String> paramMap)
  {
    Object localObject2 = ACRA.getConfig().customReportContent();
    Object localObject1 = localObject2;
    if (localObject2.length == 0) {
      localObject1 = ACRAConstants.DEFAULT_REPORT_FIELDS;
    }
    localObject2 = new HashMap(paramMap.size());
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject3 = localObject1[i];
      if ((mMapping == null) || (mMapping.get(localObject3) == null)) {
        ((Map)localObject2).put(((ReportField)localObject3).toString(), paramMap.get(localObject3));
      }
      for (;;)
      {
        i += 1;
        break;
        ((Map)localObject2).put(mMapping.get(localObject3), paramMap.get(localObject3));
      }
    }
    return (Map<String, String>)localObject2;
  }
  
  public final void send(Context paramContext, CrashReportData paramCrashReportData)
    throws ReportSenderException
  {
    Object localObject = null;
    for (;;)
    {
      String str;
      HttpRequest localHttpRequest;
      try
      {
        if (mFormUri == null)
        {
          paramContext = new URL(ACRA.getConfig().formUri());
          ACRA.log.d(ACRA.LOG_TAG, "Connect to " + paramContext.toString());
          if (mUsername == null) {
            break label348;
          }
          str = mUsername;
          if (mPassword == null) {
            break label375;
          }
          localObject = mPassword;
          localHttpRequest = new HttpRequest();
          connectionTimeOut = ACRA.getConfig().connectionTimeout();
          socketTimeOut = ACRA.getConfig().socketTimeout();
          login = str;
          password = ((String)localObject);
          headers = getConfigmHttpHeaders;
          switch (1.$SwitchMap$org$acra$sender$HttpSender$Type[mType.ordinal()])
          {
          case 1: 
            str = HttpRequest.getParamsAsFormString(remap(paramCrashReportData));
            localObject = paramContext;
            switch (mMethod)
            {
            case ???: 
              throw new UnsupportedOperationException("Unknown method: " + mMethod.name());
            }
            break;
          }
        }
      }
      catch (IOException paramContext)
      {
        throw new ReportSenderException("Error while sending " + ACRA.getConfig().reportType() + " report via Http " + mMethod.name(), paramContext);
        paramContext = new URL(mFormUri.toString());
        continue;
      }
      catch (JSONReportBuilder.JSONReportException paramContext)
      {
        throw new ReportSenderException("Error while sending " + ACRA.getConfig().reportType() + " report via Http " + mMethod.name(), paramContext);
      }
      label348:
      if (ACRAConfiguration.isNull(ACRA.getConfig().formUriBasicAuthLogin()))
      {
        str = null;
      }
      else
      {
        str = ACRA.getConfig().formUriBasicAuthLogin();
        continue;
        label375:
        if (!ACRAConfiguration.isNull(ACRA.getConfig().formUriBasicAuthPassword()))
        {
          localObject = ACRA.getConfig().formUriBasicAuthPassword();
          continue;
          str = JSONReportBuilder.buildJSONReport(paramCrashReportData).toString();
          continue;
          localObject = new URL(paramContext.toString() + '/' + paramCrashReportData.getProperty(ReportField.REPORT_ID));
          localHttpRequest.send((URL)localObject, mMethod, str, mType);
          return;
        }
      }
    }
  }
  
  public static enum Method
  {
    POST,  PUT;
    
    private Method() {}
  }
  
  public static abstract enum Type
  {
    FORM,  JSON;
    
    private Type() {}
    
    public abstract String getContentType();
  }
}

/* Location:
 * Qualified Name:     org.acra.sender.HttpSender
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */