package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

public abstract class InputDecorator
  implements Serializable
{
  public abstract InputStream decorate$44b83b11()
    throws IOException;
  
  public abstract InputStream decorate$4f0ea8f1()
    throws IOException;
  
  public abstract Reader decorate$6b9cf12f()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.InputDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */