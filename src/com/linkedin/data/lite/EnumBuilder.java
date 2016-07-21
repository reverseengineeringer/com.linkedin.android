package com.linkedin.data.lite;

public abstract interface EnumBuilder<E extends Enum<E>>
{
  public abstract E build(String paramString);
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.EnumBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */