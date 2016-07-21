package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class zzsr
  implements Cloneable
{
  private zzsp<?, ?> zzbuq;
  private Object zzbur;
  List<zzsw> zzbus = new ArrayList();
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzz()];
    writeTo(zzsn.zzb$46aa22ba(arrayOfByte, arrayOfByte.length));
    return arrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof zzsr));
      paramObject = (zzsr)paramObject;
      if ((zzbur == null) || (zzbur == null)) {
        break;
      }
      bool1 = bool2;
    } while (zzbuq != zzbuq);
    if (!zzbuq.zzbuk.isArray()) {
      return zzbur.equals(zzbur);
    }
    if ((zzbur instanceof byte[])) {
      return Arrays.equals((byte[])zzbur, (byte[])zzbur);
    }
    if ((zzbur instanceof int[])) {
      return Arrays.equals((int[])zzbur, (int[])zzbur);
    }
    if ((zzbur instanceof long[])) {
      return Arrays.equals((long[])zzbur, (long[])zzbur);
    }
    if ((zzbur instanceof float[])) {
      return Arrays.equals((float[])zzbur, (float[])zzbur);
    }
    if ((zzbur instanceof double[])) {
      return Arrays.equals((double[])zzbur, (double[])zzbur);
    }
    if ((zzbur instanceof boolean[])) {
      return Arrays.equals((boolean[])zzbur, (boolean[])zzbur);
    }
    return Arrays.deepEquals((Object[])zzbur, (Object[])zzbur);
    if ((zzbus != null) && (zzbus != null)) {
      return zzbus.equals(zzbus);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), ((zzsr)paramObject).toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public final int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if (zzbur != null) {
      zzbuq.zza(zzbur, paramzzsn);
    }
    for (;;)
    {
      return;
      Iterator localIterator = zzbus.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (zzsw)localIterator.next();
        paramzzsn.zzmB(tag);
        localObject = zzbuv;
        int i = localObject.length;
        if (zzbui.remaining() < i) {
          break label96;
        }
        zzbui.put((byte[])localObject, 0, i);
      }
    }
    label96:
    throw new zzsn.zza(zzbui.position(), zzbui.limit());
  }
  
  public final zzsr zzJr()
  {
    int i = 0;
    zzsr localzzsr = new zzsr();
    try
    {
      zzbuq = zzbuq;
      if (zzbus == null) {
        zzbus = null;
      }
      for (;;)
      {
        if (zzbur == null) {
          return localzzsr;
        }
        if (!(zzbur instanceof zzsu)) {
          break;
        }
        zzbur = ((zzsu)zzbur).clone();
        return localzzsr;
        zzbus.addAll(zzbus);
      }
      if (!(zzbur instanceof byte[])) {
        break label119;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    zzbur = ((byte[])zzbur).clone();
    return localCloneNotSupportedException;
    label119:
    Object localObject1;
    Object localObject2;
    if ((zzbur instanceof byte[][]))
    {
      localObject1 = (byte[][])zzbur;
      localObject2 = new byte[localObject1.length][];
      zzbur = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((zzbur instanceof boolean[]))
    {
      zzbur = ((boolean[])zzbur).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbur instanceof int[]))
    {
      zzbur = ((int[])zzbur).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbur instanceof long[]))
    {
      zzbur = ((long[])zzbur).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbur instanceof float[]))
    {
      zzbur = ((float[])zzbur).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbur instanceof double[]))
    {
      zzbur = ((double[])zzbur).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbur instanceof zzsu[]))
    {
      localObject1 = (zzsu[])zzbur;
      localObject2 = new zzsu[localObject1.length];
      zzbur = localObject2;
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i].clone();
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  final int zzz()
  {
    int j;
    if (zzbur != null)
    {
      j = zzbuq.zzY(zzbur);
      return j;
    }
    Iterator localIterator = zzbus.iterator();
    zzsw localzzsw;
    for (int i = 0;; i = zzbuv.length + (j + 0) + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      localzzsw = (zzsw)localIterator.next();
      j = zzsn.zzmC(tag);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */