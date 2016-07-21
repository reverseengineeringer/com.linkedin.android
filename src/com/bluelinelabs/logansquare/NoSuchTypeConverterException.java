package com.bluelinelabs.logansquare;

public class NoSuchTypeConverterException
  extends RuntimeException
{
  public NoSuchTypeConverterException(Class paramClass)
  {
    super("Class " + paramClass.getCanonicalName() + " does not having a TypeConverter defined. TypeConverters can be added using LoganSquare.registerTypeConverter().");
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.NoSuchTypeConverterException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */