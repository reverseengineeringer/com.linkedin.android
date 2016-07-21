package com.conviva.utils;

public final class Random
{
  public static int integer32()
  {
    return Math.abs(new java.util.Random().nextInt());
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Random
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */