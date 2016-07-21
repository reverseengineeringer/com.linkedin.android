package com.linkedin.data.lite;

public abstract interface JsonDataReader
  extends DataReader
{
  public abstract String readJsonString()
    throws DataReaderException;
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.JsonDataReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */