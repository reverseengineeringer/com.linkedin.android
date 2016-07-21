package com.linkedin.android.fission.interfaces;

import java.io.IOException;

public abstract interface FissionTransaction
{
  public abstract void abort()
    throws IOException;
  
  public abstract void commit()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.linkedin.android.fission.interfaces.FissionTransaction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */