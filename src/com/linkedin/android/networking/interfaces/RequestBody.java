package com.linkedin.android.networking.interfaces;

public abstract interface RequestBody
{
  public abstract byte[] getBody();
  
  public abstract String getType();
  
  public abstract boolean shouldGzip();
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.interfaces.RequestBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */