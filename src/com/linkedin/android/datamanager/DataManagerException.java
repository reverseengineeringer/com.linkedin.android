package com.linkedin.android.datamanager;

import com.linkedin.android.networking.interfaces.RawResponse;
import java.io.IOException;

public class DataManagerException
  extends IOException
{
  public final RawResponse errorResponse;
  
  public DataManagerException(String paramString, Object... paramVarArgs)
  {
    super(String.format(paramString, paramVarArgs));
    errorResponse = null;
  }
  
  public DataManagerException(Throwable paramThrowable)
  {
    super(paramThrowable);
    errorResponse = null;
  }
  
  public DataManagerException(Throwable paramThrowable, RawResponse paramRawResponse)
  {
    super(paramThrowable);
    errorResponse = paramRawResponse;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.DataManagerException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */