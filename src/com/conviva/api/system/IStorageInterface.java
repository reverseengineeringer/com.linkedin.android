package com.conviva.api.system;

public abstract interface IStorageInterface
{
  public abstract void loadData(String paramString1, String paramString2, ICallbackInterface paramICallbackInterface);
  
  public abstract void saveData(String paramString1, String paramString2, String paramString3, ICallbackInterface paramICallbackInterface);
}

/* Location:
 * Qualified Name:     com.conviva.api.system.IStorageInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */