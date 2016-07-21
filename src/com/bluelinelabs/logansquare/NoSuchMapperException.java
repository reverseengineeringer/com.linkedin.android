package com.bluelinelabs.logansquare;

public class NoSuchMapperException
  extends RuntimeException
{
  public NoSuchMapperException(Class paramClass, Exception paramException)
  {
    super("Class " + paramClass.getCanonicalName() + " could not be mapped to a JSON object. Perhaps it hasn't been annotated with @JsonObject?", paramException);
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.NoSuchMapperException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */