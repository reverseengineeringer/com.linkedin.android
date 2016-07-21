package com.linkedin.android.infra.shared;

public abstract interface Closure<IN, OUT>
{
  public abstract OUT apply(IN paramIN);
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.Closure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */