package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

final class zzbh$zza
{
  ByteArrayOutputStream zztu = new ByteArrayOutputStream(4096);
  Base64OutputStream zztv = new Base64OutputStream(zztu, 10);
  
  public final String toString()
  {
    try
    {
      zztv.close();
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          zztu.close();
          String str = zztu.toString();
          return str;
        }
        catch (IOException localIOException2)
        {
          zzin.zzb("HashManager: Unable to convert to Base64.", localIOException2);
          return "";
        }
        finally
        {
          zztu = null;
          zztv = null;
        }
        localIOException1 = localIOException1;
        zzin.zzb("HashManager: Unable to convert to Base64.", localIOException1);
      }
    }
  }
  
  public final void write(byte[] paramArrayOfByte)
    throws IOException
  {
    zztv.write(paramArrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbh.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */