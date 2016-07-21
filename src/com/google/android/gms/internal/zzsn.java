package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzsn
{
  final ByteBuffer zzbui;
  
  private zzsn(ByteBuffer paramByteBuffer)
  {
    zzbui = paramByteBuffer;
    zzbui.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private zzsn(byte[] paramArrayOfByte, int paramInt)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, 0, paramInt));
  }
  
  public static int zzC(int paramInt1, int paramInt2)
  {
    int i = zzmA(paramInt1);
    if (paramInt2 >= 0) {}
    for (paramInt1 = zzmC(paramInt2);; paramInt1 = 10) {
      return paramInt1 + i;
    }
  }
  
  private static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128) {
        break;
      }
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4) {
              break label439;
            }
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c)) {
                j = paramInt2;
              }
            }
            else
            {
              throw new IllegalArgumentException("Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label439:
      if ((55296 <= i) && (i <= 57343) && ((paramInt2 + 1 == paramCharSequence.length()) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2 + 1))))) {
        throw new IllegalArgumentException("Unpaired surrogate at index " + paramInt2);
      }
      throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }
  
  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (paramByteBuffer.hasArray()) {
      try
      {
        paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    }
    zzb(paramCharSequence, paramByteBuffer);
  }
  
  private void zzau(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        zzmz((int)paramLong);
        return;
      }
      zzmz((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public static int zzav(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((0x8000000000000000 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  private static void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128) {
        paramByteBuffer.put((byte)i);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c)) {
              k = j;
            }
          }
          else
          {
            throw new IllegalArgumentException("Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static zzsn zzb$46aa22ba(byte[] paramArrayOfByte, int paramInt)
  {
    return new zzsn(paramArrayOfByte, paramInt);
  }
  
  public static int zzc(int paramInt, zzsu paramzzsu)
  {
    paramInt = zzmA(paramInt);
    int i = paramzzsu.getSerializedSize();
    return paramInt + (i + zzmC(i));
  }
  
  private static int zzc(CharSequence paramCharSequence)
  {
    int k = 0;
    int n = paramCharSequence.length();
    int j = 0;
    while ((j < n) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    for (;;)
    {
      int i;
      if (j < n)
      {
        int m = paramCharSequence.charAt(j);
        if (m < 2048)
        {
          i += (127 - m >>> 31);
          j += 1;
        }
        else
        {
          int i2 = paramCharSequence.length();
          if (j < i2)
          {
            int i3 = paramCharSequence.charAt(j);
            if (i3 < 2048)
            {
              k += (127 - i3 >>> 31);
              m = j;
            }
            for (;;)
            {
              j = m + 1;
              break;
              int i1 = k + 2;
              m = j;
              k = i1;
              if (55296 <= i3)
              {
                m = j;
                k = i1;
                if (i3 <= 57343)
                {
                  if (Character.codePointAt(paramCharSequence, j) < 65536) {
                    throw new IllegalArgumentException("Unpaired surrogate at index " + j);
                  }
                  m = j + 1;
                  k = i1;
                }
              }
            }
          }
          i += k;
        }
      }
      else
      {
        for (;;)
        {
          if (i < n) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i + 4294967296L));
          }
          return i;
        }
        i = n;
      }
    }
  }
  
  public static int zzd(int paramInt, long paramLong)
  {
    return zzmA(paramInt) + zzav(paramLong);
  }
  
  public static int zzgO(String paramString)
  {
    int i = zzc(paramString);
    return i + zzmC(i);
  }
  
  public static int zzmA(int paramInt)
  {
    return zzmC(zzsx.zzF(paramInt, 0));
  }
  
  public static int zzmC(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  private void zzmz(int paramInt)
    throws IOException
  {
    byte b = (byte)paramInt;
    if (!zzbui.hasRemaining()) {
      throw new zza(zzbui.position(), zzbui.limit());
    }
    zzbui.put(b);
  }
  
  public static int zzo(int paramInt, String paramString)
  {
    return zzmA(paramInt) + zzgO(paramString);
  }
  
  public final void zzA(int paramInt1, int paramInt2)
    throws IOException
  {
    zzE(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      zzmB(paramInt2);
      return;
    }
    zzau(paramInt2);
  }
  
  public final void zzE(int paramInt1, int paramInt2)
    throws IOException
  {
    zzmB(zzsx.zzF(paramInt1, paramInt2));
  }
  
  public final void zzJo()
  {
    if (zzbui.remaining() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public final void zza(int paramInt, long paramLong)
    throws IOException
  {
    zzE(paramInt, 0);
    zzau(paramLong);
  }
  
  public final void zza(int paramInt, zzsu paramzzsu)
    throws IOException
  {
    zzE(paramInt, 2);
    zzc(paramzzsu);
  }
  
  public final void zzb(int paramInt, float paramFloat)
    throws IOException
  {
    zzE(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    if (zzbui.remaining() < 4) {
      throw new zza(zzbui.position(), zzbui.limit());
    }
    zzbui.putInt(paramInt);
  }
  
  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zzE(paramInt, 0);
    zzau(paramLong);
  }
  
  public final void zzc(zzsu paramzzsu)
    throws IOException
  {
    zzmB(paramzzsu.getCachedSize());
    paramzzsu.writeTo(this);
  }
  
  public final void zze(int paramInt, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    zzE(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    zzmz(paramInt);
  }
  
  public final void zzmB(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzmz(paramInt);
        return;
      }
      zzmz(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void zzn(int paramInt, String paramString)
    throws IOException
  {
    zzE(paramInt, 2);
    int i;
    try
    {
      paramInt = zzmC(paramString.length());
      if (paramInt != zzmC(paramString.length() * 3)) {
        break label156;
      }
      i = zzbui.position();
      if (zzbui.remaining() < paramInt) {
        throw new zza(paramInt + i, zzbui.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      zza localzza = new zza(zzbui.position(), zzbui.limit());
      localzza.initCause(paramString);
      throw localzza;
    }
    zzbui.position(i + paramInt);
    zza(paramString, zzbui);
    int j = zzbui.position();
    zzbui.position(i);
    zzmB(j - i - paramInt);
    zzbui.position(j);
    return;
    label156:
    zzmB(zzc(paramString));
    zza(paramString, zzbui);
  }
  
  public static final class zza
    extends IOException
  {
    zza(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */