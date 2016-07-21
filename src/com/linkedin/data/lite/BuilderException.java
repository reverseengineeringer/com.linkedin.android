package com.linkedin.data.lite;

public abstract class BuilderException
  extends Exception
{
  String _name;
  
  public BuilderException(String paramString)
  {
    _name = paramString;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.BuilderException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */