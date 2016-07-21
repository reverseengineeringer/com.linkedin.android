package com.linkedin.data.lite;

public abstract interface DataTemplateBuilder<T>
{
  public abstract T build(DataReader paramDataReader)
    throws DataReaderException;
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.DataTemplateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */