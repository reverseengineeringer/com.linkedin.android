package com.linkedin.android.infra.shared;

import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.restli.common.ErrorResponse;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils
{
  private static final String TAG = ExceptionUtils.class.getSimpleName();
  
  public static String getStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    return localStringWriter.getBuffer().toString();
  }
  
  public static VoyagerUserVisibleException getUserVisibleException(DataManagerException paramDataManagerException)
  {
    if ((paramDataManagerException == null) || (errorResponse == null) || (errorResponse.headers() == null)) {}
    for (;;)
    {
      return null;
      if (!"true".equals(errorResponse.getHeader("X-RestLi-Error-Response"))) {
        continue;
      }
      try
      {
        paramDataManagerException = (ErrorResponse)DataManager.PARSER_FACTORY.createParser().parseRecord(errorResponse.body(false), ErrorResponse.BUILDER);
        if ((exceptionClass == null) || (!exceptionClass.endsWith("VoyagerUserVisibleException"))) {
          continue;
        }
        paramDataManagerException = new VoyagerUserVisibleException(message, serviceErrorCode);
        return paramDataManagerException;
      }
      catch (DataReaderException paramDataManagerException)
      {
        Log.e(TAG, paramDataManagerException);
        return null;
      }
      catch (IOException paramDataManagerException)
      {
        for (;;) {}
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.ExceptionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */