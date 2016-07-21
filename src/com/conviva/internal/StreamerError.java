package com.conviva.internal;

import com.conviva.api.Client.ErrorSeverity;

public final class StreamerError
{
  public String _errorCode;
  public Client.ErrorSeverity _severity;
  
  public StreamerError(String paramString, Client.ErrorSeverity paramErrorSeverity)
  {
    _errorCode = paramString;
    _severity = paramErrorSeverity;
  }
}

/* Location:
 * Qualified Name:     com.conviva.internal.StreamerError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */