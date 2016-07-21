package com.linkedin.CrossPromoLib.utils;

public final class Sequence
  implements Runnable
{
  private final Runnable[] items;
  
  public Sequence(Runnable... paramVarArgs)
  {
    items = paramVarArgs;
  }
  
  public final void run()
  {
    Runnable[] arrayOfRunnable = items;
    int j = arrayOfRunnable.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRunnable[i].run();
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.Sequence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */