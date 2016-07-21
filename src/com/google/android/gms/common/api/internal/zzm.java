package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zznk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzm
{
  private static final ExecutorService zzaiv = Executors.newFixedThreadPool(2, new zznk("GAC_Executor"));
  
  public static ExecutorService zzpN()
  {
    return zzaiv;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */