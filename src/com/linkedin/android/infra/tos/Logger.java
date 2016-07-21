package com.linkedin.android.infra.tos;

import com.linkedin.android.logger.Log;
import com.linkedin.android.tos.LogInterface;

public final class Logger
  implements LogInterface
{
  public final void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.tos.Logger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */