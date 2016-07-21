package com.linkedin.android.fission.interfaces;

import java.io.IOException;

public abstract interface FissileModelSearchCursor<T extends FissileModel>
{
  public abstract void close()
    throws IOException;
  
  public abstract T next()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.linkedin.android.fission.interfaces.FissileModelSearchCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */