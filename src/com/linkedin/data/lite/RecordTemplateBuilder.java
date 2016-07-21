package com.linkedin.data.lite;

public abstract interface RecordTemplateBuilder<T extends RecordTemplate<T>>
{
  public abstract T build(String paramString)
    throws BuilderException;
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.RecordTemplateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */