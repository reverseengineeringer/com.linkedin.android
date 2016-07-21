package com.fasterxml.jackson.core;

import java.io.IOException;

public class JsonProcessingException
  extends IOException
{
  protected JsonLocation _location;
  
  protected JsonProcessingException(String paramString, JsonLocation paramJsonLocation)
  {
    this(paramString, paramJsonLocation, null);
  }
  
  protected JsonProcessingException(String paramString, JsonLocation paramJsonLocation, Throwable paramThrowable)
  {
    super(paramString);
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
    _location = paramJsonLocation;
  }
  
  public String getMessage()
  {
    Object localObject2 = super.getMessage();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "N/A";
    }
    JsonLocation localJsonLocation = _location;
    localObject2 = localObject1;
    if (localJsonLocation != null)
    {
      localObject2 = new StringBuilder(100);
      ((StringBuilder)localObject2).append((String)localObject1);
      if (localJsonLocation != null)
      {
        ((StringBuilder)localObject2).append('\n');
        ((StringBuilder)localObject2).append(" at ");
        ((StringBuilder)localObject2).append(localJsonLocation.toString());
      }
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + getMessage();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.JsonProcessingException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */