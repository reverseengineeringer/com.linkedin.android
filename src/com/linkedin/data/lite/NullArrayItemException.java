package com.linkedin.data.lite;

public final class NullArrayItemException
  extends BuilderException
{
  private String _fieldName;
  
  public NullArrayItemException(String paramString1, String paramString2)
  {
    super(paramString1);
    _fieldName = paramString2;
  }
  
  public final String getMessage()
  {
    return "Found null array item in '" + _fieldName + "' when building '" + _name + "'.";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.NullArrayItemException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */