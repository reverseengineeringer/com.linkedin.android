package com.linkedin.android.infra;

public abstract interface ScreenElement
{
  public abstract boolean didEnter();
  
  public abstract void onEnter();
  
  public abstract void onLeave();
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.ScreenElement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */