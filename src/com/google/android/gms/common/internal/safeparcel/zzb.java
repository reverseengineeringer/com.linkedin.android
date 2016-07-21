package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class zzb
{
  public static int zzG(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  public static void zzH(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, double paramDouble)
  {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, float paramFloat)
  {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, long paramLong)
  {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    zzb(paramParcel, paramInt, 4);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
  
  private static <T extends Parcelable> void zza(Parcel paramParcel, T paramT, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramT.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  public static void zza$1ed7098(Parcel paramParcel, int paramInt, Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
  }
  
  public static void zza$2cfb68bf(Parcel paramParcel, int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramInt = zzG(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    zzH(paramParcel, paramInt);
  }
  
  public static <T extends Parcelable> void zza$2d7953c6(Parcel paramParcel, int paramInt1, T[] paramArrayOfT, int paramInt2)
  {
    if (paramArrayOfT == null) {
      return;
    }
    int i = zzG(paramParcel, paramInt1);
    int j = paramArrayOfT.length;
    paramParcel.writeInt(j);
    paramInt1 = 0;
    if (paramInt1 < j)
    {
      T ? = paramArrayOfT[paramInt1];
      if (? == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        zza(paramParcel, ?, paramInt2);
      }
    }
    zzH(paramParcel, i);
  }
  
  public static void zza$377a007(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2)
  {
    if (paramParcelable == null) {
      return;
    }
    paramInt1 = zzG(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    zzH(paramParcel, paramInt1);
  }
  
  public static void zza$41b439c0(Parcel paramParcel, int paramInt, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    paramInt = zzG(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    zzH(paramParcel, paramInt);
  }
  
  public static void zza$52910762(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    paramInt = zzG(paramParcel, paramInt);
    paramParcel.writeByteArray(paramArrayOfByte);
    zzH(paramParcel, paramInt);
  }
  
  public static void zza$53422a(Parcel paramParcel, int paramInt, Long paramLong)
  {
    if (paramLong == null) {
      return;
    }
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong.longValue());
  }
  
  public static void zza$62107c48(Parcel paramParcel, int paramInt, List<Integer> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = zzG(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeInt(((Integer)paramList.get(paramInt)).intValue());
      paramInt += 1;
    }
    zzH(paramParcel, i);
  }
  
  public static void zza$cdac282(Parcel paramParcel, int paramInt, IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return;
    }
    paramInt = zzG(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    zzH(paramParcel, paramInt);
  }
  
  public static void zza$f7bef55(Parcel paramParcel, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramInt = zzG(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    zzH(paramParcel, paramInt);
  }
  
  public static void zzb(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt2 << 16 | paramInt1);
  }
  
  public static void zzb$62107c48(Parcel paramParcel, int paramInt, List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramInt = zzG(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    zzH(paramParcel, paramInt);
  }
  
  public static void zzc(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    zzb(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static <T extends Parcelable> void zzc$62107c48(Parcel paramParcel, int paramInt, List<T> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = zzG(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      Parcelable localParcelable = (Parcelable)paramList.get(paramInt);
      if (localParcelable == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        zza(paramParcel, localParcelable, 0);
      }
    }
    zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */