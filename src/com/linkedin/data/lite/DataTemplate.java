package com.linkedin.data.lite;

public abstract interface DataTemplate<T extends DataTemplate<T>>
{
  public abstract T accept(DataProcessor paramDataProcessor)
    throws DataProcessorException;
  
  public abstract String id();
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.DataTemplate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */