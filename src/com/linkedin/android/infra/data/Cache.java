package com.linkedin.android.infra.data;

import com.linkedin.android.fission.interfaces.FissionTransaction;

public abstract interface Cache<K, V>
{
  public abstract void clear()
    throws CacheException;
  
  public abstract FissionTransaction createTransaction(boolean paramBoolean)
    throws CacheException;
  
  public abstract V get(K paramK, FissionTransaction paramFissionTransaction)
    throws CacheException;
  
  public abstract boolean isClosed();
  
  public abstract void onTrimMemory(int paramInt);
  
  public abstract V put$7ec75917(K paramK, V paramV, int paramInt, FissionTransaction paramFissionTransaction)
    throws CacheException;
  
  public abstract V remove(K paramK, FissionTransaction paramFissionTransaction)
    throws CacheException;
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.data.Cache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */