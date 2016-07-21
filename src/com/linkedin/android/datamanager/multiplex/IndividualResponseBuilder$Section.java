package com.linkedin.android.datamanager.multiplex;

import java.io.IOException;
import java.io.InputStream;

abstract interface IndividualResponseBuilder$Section
{
  public abstract InputStream inputStream()
    throws IOException;
  
  public abstract int length();
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.IndividualResponseBuilder.Section
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */