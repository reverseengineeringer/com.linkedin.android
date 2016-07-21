package com.google.android.gms.internal;

import java.security.MessageDigest;

@zzhb
public final class zzbj
  extends zzbg
{
  private MessageDigest zztw;
  
  public final byte[] zzu(String arg1)
  {
    int i = 0;
    ??? = ???.split(" ");
    byte[] arrayOfByte1 = new byte[???.length];
    while (i < ???.length)
    {
      int j = zzbi.zzx(???[i]);
      arrayOfByte1[i] = ((byte)((j & 0xFF000000) >> 24 ^ j & 0xFF ^ (0xFF00 & j) >> 8 ^ (0xFF0000 & j) >> 16));
      i += 1;
    }
    zztw = zzcL();
    for (;;)
    {
      synchronized (zzpV)
      {
        if (zztw == null) {
          return new byte[0];
        }
        zztw.reset();
        zztw.update(arrayOfByte1);
        arrayOfByte1 = zztw.digest();
        if (arrayOfByte1.length > 4)
        {
          i = 4;
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
          return arrayOfByte2;
        }
      }
      i = localObject.length;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */