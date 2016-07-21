package com.linkedin.data.lite;

public final class MissingRecordFieldException
  extends BuilderException
{
  private String _fieldName;
  
  public MissingRecordFieldException(String paramString1, String paramString2)
  {
    super(paramString1);
    _fieldName = paramString2;
  }
  
  public final String getMessage()
  {
    return "Required field '" + _fieldName + "' is missing when building '" + _name + "'";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.MissingRecordFieldException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */