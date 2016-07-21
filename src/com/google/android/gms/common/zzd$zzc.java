package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzd$zzc
  extends zzd.zza
{
  private static final WeakReference<byte[]> zzafJ = new WeakReference(null);
  private WeakReference<byte[]> zzafI = zzafJ;
  
  zzd$zzc(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  final byte[] getBytes()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])zzafI.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = zzoL();
        zzafI = new WeakReference(arrayOfByte1);
      }
      return arrayOfByte1;
    }
    finally {}
  }
  
  protected abstract byte[] zzoL();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzd.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */