package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class zzbg
{
  private static MessageDigest zzto = null;
  protected Object zzpV = new Object();
  
  protected final MessageDigest zzcL()
  {
    for (;;)
    {
      MessageDigest localMessageDigest;
      int i;
      synchronized (zzpV)
      {
        if (zzto != null)
        {
          localMessageDigest = zzto;
          return localMessageDigest;
        }
        i = 0;
        if (i >= 2) {}
      }
      try
      {
        zzto = MessageDigest.getInstance("MD5");
        i += 1;
        continue;
        localMessageDigest = zzto;
        return localMessageDigest;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
  }
  
  abstract byte[] zzu(String paramString);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */