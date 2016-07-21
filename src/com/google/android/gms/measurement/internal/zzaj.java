package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzqb.zza;
import com.google.android.gms.internal.zzqb.zzb;
import com.google.android.gms.internal.zzqb.zzc;
import com.google.android.gms.internal.zzqb.zzd;
import com.google.android.gms.internal.zzqb.zze;
import com.google.android.gms.internal.zzqb.zzf;
import com.google.android.gms.internal.zzqb.zzg;
import com.google.android.gms.internal.zzsn;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class zzaj
  extends zzy
{
  zzaj(zzw paramzzw)
  {
    super(paramzzw);
  }
  
  public static boolean zzQ(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if (paramString1 == null) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  private static Object zza(int paramInt, Object paramObject, boolean paramBoolean)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = paramObject;
        } while ((paramObject instanceof Long));
        localObject = paramObject;
      } while ((paramObject instanceof Float));
      if ((paramObject instanceof Integer)) {
        return Long.valueOf(((Integer)paramObject).intValue());
      }
      if ((paramObject instanceof Byte)) {
        return Long.valueOf(((Byte)paramObject).byteValue());
      }
      if ((paramObject instanceof Short)) {
        return Long.valueOf(((Short)paramObject).shortValue());
      }
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue()) {}
        for (long l = 1L;; l = 0L) {
          return Long.valueOf(l);
        }
      }
      if ((paramObject instanceof Double)) {
        return Float.valueOf((float)((Double)paramObject).doubleValue());
      }
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence))) {
        break;
      }
      paramObject = String.valueOf(paramObject);
      localObject = paramObject;
    } while (((String)paramObject).length() <= paramInt);
    if (paramBoolean) {
      return ((String)paramObject).substring(0, paramInt);
    }
    return null;
    return null;
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append("  ");
      i += 1;
    }
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    zza(paramStringBuilder, paramInt + 1);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append('\n');
  }
  
  public static boolean zza(Context paramContext, Class<? extends Service> paramClass)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getServiceInfo(new ComponentName(paramContext, paramClass), 4);
      if (paramContext != null)
      {
        boolean bool = enabled;
        if (bool) {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean zza(long[] paramArrayOfLong, int paramInt)
  {
    if (paramInt >= paramArrayOfLong.length * 64) {}
    while ((paramArrayOfLong[(paramInt / 64)] & 1L << paramInt % 64) == 0L) {
      return false;
    }
    return true;
  }
  
  public static long[] zza(BitSet paramBitSet)
  {
    int k = (paramBitSet.length() + 63) / 64;
    long[] arrayOfLong = new long[k];
    int i = 0;
    while (i < k)
    {
      arrayOfLong[i] = 0L;
      int j = 0;
      while ((j < 64) && (i * 64 + j < paramBitSet.length()))
      {
        if (paramBitSet.get(i * 64 + j)) {
          arrayOfLong[i] |= 1L << j;
        }
        j += 1;
      }
      i += 1;
    }
    return arrayOfLong;
  }
  
  private static void zza$4fd938b5(StringBuilder paramStringBuilder, String paramString, zzqb.zzf paramzzf)
  {
    int k = 0;
    if (paramzzf == null) {
      return;
    }
    zza(paramStringBuilder, 3);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    int m;
    int j;
    int i;
    long l;
    if (zzbaH != null)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("results: ");
      paramString = zzbaH;
      m = paramString.length;
      j = 0;
      i = 0;
      while (j < m)
      {
        l = paramString[j];
        if (i != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(Long.valueOf(l));
        j += 1;
        i += 1;
      }
      paramStringBuilder.append('\n');
    }
    if (zzbaG != null)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("status: ");
      paramString = zzbaG;
      m = paramString.length;
      i = 0;
      j = k;
      while (j < m)
      {
        l = paramString[j];
        if (i != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(Long.valueOf(l));
        j += 1;
        i += 1;
      }
      paramStringBuilder.append('\n');
    }
    zza(paramStringBuilder, 3);
    paramStringBuilder.append("}\n");
  }
  
  private static void zza$5bd3691e(StringBuilder paramStringBuilder, zzqb.zze paramzze)
  {
    if (paramzze == null) {
      return;
    }
    zza(paramStringBuilder, 1);
    paramStringBuilder.append("bundle {\n");
    zza(paramStringBuilder, 1, "protocol_version", zzbal);
    zza(paramStringBuilder, 1, "platform", zzbat);
    zza(paramStringBuilder, 1, "gmp_version", zzbax);
    zza(paramStringBuilder, 1, "uploading_gmp_version", zzbay);
    zza(paramStringBuilder, 1, "gmp_app_id", zzaVt);
    zza(paramStringBuilder, 1, "app_id", appId);
    zza(paramStringBuilder, 1, "app_version", zzaMV);
    zza(paramStringBuilder, 1, "dev_cert_hash", zzbaC);
    zza(paramStringBuilder, 1, "app_store", zzaVu);
    zza(paramStringBuilder, 1, "upload_timestamp_millis", zzbao);
    zza(paramStringBuilder, 1, "start_timestamp_millis", zzbap);
    zza(paramStringBuilder, 1, "end_timestamp_millis", zzbaq);
    zza(paramStringBuilder, 1, "previous_bundle_start_timestamp_millis", zzbar);
    zza(paramStringBuilder, 1, "previous_bundle_end_timestamp_millis", zzbas);
    zza(paramStringBuilder, 1, "app_instance_id", zzbaB);
    zza(paramStringBuilder, 1, "resettable_device_id", zzbaz);
    zza(paramStringBuilder, 1, "limited_ad_tracking", zzbaA);
    zza(paramStringBuilder, 1, "os_version", osVersion);
    zza(paramStringBuilder, 1, "device_model", zzbau);
    zza(paramStringBuilder, 1, "user_default_language", zzbav);
    zza(paramStringBuilder, 1, "time_zone_offset_minutes", zzbaw);
    zza(paramStringBuilder, 1, "bundle_sequential_index", zzbaD);
    zza(paramStringBuilder, 1, "service_upload", zzbaE);
    zza(paramStringBuilder, 1, "health_monitor", zzaVx);
    Object localObject1 = zzban;
    int j;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null)
        {
          zza(paramStringBuilder, 2);
          paramStringBuilder.append("user_property {\n");
          zza(paramStringBuilder, 2, "set_timestamp_millis", zzbaJ);
          zza(paramStringBuilder, 2, "name", name);
          zza(paramStringBuilder, 2, "string_value", zzamJ);
          zza(paramStringBuilder, 2, "int_value", zzbai);
          zza(paramStringBuilder, 2, "float_value", zzaZo);
          zza(paramStringBuilder, 2);
          paramStringBuilder.append("}\n");
        }
        i += 1;
      }
    }
    localObject1 = zzbaF;
    if (localObject1 != null)
    {
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null)
        {
          zza(paramStringBuilder, 2);
          paramStringBuilder.append("audience_membership {\n");
          zza(paramStringBuilder, 2, "audience_id", zzaZr);
          zza(paramStringBuilder, 2, "new_audience", zzbac);
          zza$4fd938b5(paramStringBuilder, "current_data", zzbaa);
          zza$4fd938b5(paramStringBuilder, "previous_data", zzbab);
          zza(paramStringBuilder, 2);
          paramStringBuilder.append("}\n");
        }
        i += 1;
      }
    }
    paramzze = zzbam;
    if (paramzze != null)
    {
      int k = paramzze.length;
      i = 0;
      while (i < k)
      {
        localObject1 = paramzze[i];
        if (localObject1 != null)
        {
          zza(paramStringBuilder, 2);
          paramStringBuilder.append("event {\n");
          zza(paramStringBuilder, 2, "name", name);
          zza(paramStringBuilder, 2, "timestamp_millis", zzbaf);
          zza(paramStringBuilder, 2, "previous_timestamp_millis", zzbag);
          zza(paramStringBuilder, 2, "count", count);
          localObject1 = zzbae;
          if (localObject1 != null)
          {
            int m = localObject1.length;
            j = 0;
            while (j < m)
            {
              localObject2 = localObject1[j];
              if (localObject2 != null)
              {
                zza(paramStringBuilder, 3);
                paramStringBuilder.append("event {\n");
                zza(paramStringBuilder, 3, "name", name);
                zza(paramStringBuilder, 3, "string_value", zzamJ);
                zza(paramStringBuilder, 3, "int_value", zzbai);
                zza(paramStringBuilder, 3, "float_value", zzaZo);
                zza(paramStringBuilder, 3);
                paramStringBuilder.append("}\n");
              }
              j += 1;
            }
          }
          zza(paramStringBuilder, 2);
          paramStringBuilder.append("}\n");
        }
        i += 1;
      }
    }
    zza(paramStringBuilder, 1);
    paramStringBuilder.append("}\n");
  }
  
  public static boolean zza$6aa51a6e(Context paramContext, Class<? extends BroadcastReceiver> paramClass)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getReceiverInfo(new ComponentName(paramContext, paramClass), 2);
      if (paramContext != null)
      {
        boolean bool = enabled;
        if (bool) {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static String zzb(zzqb.zzd paramzzd)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nbatch {\n");
    if (zzbaj != null)
    {
      paramzzd = zzbaj;
      int j = paramzzd.length;
      int i = 0;
      while (i < j)
      {
        zzqb.zze localzze = paramzzd[i];
        if (localzze != null) {
          zza$5bd3691e(localStringBuilder, localzze);
        }
        i += 1;
      }
    }
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  static MessageDigest zzbv(String paramString)
  {
    int i = 0;
    while (i < 2) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  static void zzc(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null) {
      throw new IllegalArgumentException(paramString1 + " name is required and can't be null");
    }
    if (paramString2.length() == 0) {
      throw new IllegalArgumentException(paramString1 + " name is required and can't be empty");
    }
    char c = paramString2.charAt(0);
    if ((!Character.isLetter(c)) && (c != '_')) {
      throw new IllegalArgumentException(paramString1 + " name must start with a letter or _");
    }
    int i = 1;
    while (i < paramString2.length())
    {
      c = paramString2.charAt(i);
      if ((c != '_') && (!Character.isLetterOrDigit(c))) {
        throw new IllegalArgumentException(paramString1 + " name must consist of letters, digits or _ (underscores)");
      }
      i += 1;
    }
    if (paramString2.length() > paramInt) {
      throw new IllegalArgumentException(paramString1 + " name is too long. The maximum supported length is " + paramInt);
    }
  }
  
  static boolean zzfq(String paramString)
  {
    boolean bool = false;
    zzx.zzcM(paramString);
    if (paramString.charAt(0) != '_') {
      bool = true;
    }
    return bool;
  }
  
  public static void zzfs(String paramString)
  {
    zzc("user attribute", zzd.zzBC(), paramString);
  }
  
  static int zzfu(String paramString)
  {
    if ("_ldl".equals(paramString)) {
      return zzd.zzBG();
    }
    return zzd.zzBF();
  }
  
  public static boolean zzfv(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("_"));
  }
  
  public static Object zzk(String paramString, Object paramObject)
  {
    if (zzfv(paramString)) {}
    for (int i = zzd.zzBE();; i = zzd.zzBD()) {
      return zza(i, paramObject, false);
    }
  }
  
  public static Object zzm(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString)) {
      return zza(zzfu(paramString), paramObject, true);
    }
    return zza(zzfu(paramString), paramObject, false);
  }
  
  static long zzq(byte[] paramArrayOfByte)
  {
    int j = 0;
    zzx.zzz(paramArrayOfByte);
    if (paramArrayOfByte.length > 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      zzx.zzab(bool);
      l = 0L;
      int i = paramArrayOfByte.length - 1;
      while ((i >= 0) && (i >= paramArrayOfByte.length - 8))
      {
        l += ((paramArrayOfByte[i] & 0xFF) << j);
        j += 8;
        i -= 1;
      }
    }
    return l;
  }
  
  public final void zza(Bundle paramBundle, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
    }
    do
    {
      return;
      if ((paramObject instanceof Float))
      {
        paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
        return;
      }
      if ((paramObject instanceof String))
      {
        paramBundle.putString(paramString, String.valueOf(paramObject));
        return;
      }
    } while (paramString == null);
    zzAozzaWH.zze("Not putting event parameter. Invalid value type. name, type", paramString, paramObject.getClass().getSimpleName());
  }
  
  public final void zza(zzqb.zzc paramzzc, Object paramObject)
  {
    zzx.zzz(paramObject);
    zzamJ = null;
    zzbai = null;
    zzaZo = null;
    if ((paramObject instanceof String))
    {
      zzamJ = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      zzbai = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      zzaZo = ((Float)paramObject);
      return;
    }
    zzAozzaWC.zzj("Ignoring invalid (type) event param value", paramObject);
  }
  
  public final void zza(zzqb.zzg paramzzg, Object paramObject)
  {
    zzx.zzz(paramObject);
    zzamJ = null;
    zzbai = null;
    zzaZo = null;
    if ((paramObject instanceof String))
    {
      zzamJ = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      zzbai = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      zzaZo = ((Float)paramObject);
      return;
    }
    zzAozzaWC.zzj("Ignoring invalid (type) user attribute value", paramObject);
  }
  
  final void zza(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      zzAozzaWH.zzj(paramString1 + " value can't be null. Ignoring " + paramString1, paramString2);
    }
    do
    {
      do
      {
        return;
      } while (((paramObject instanceof Long)) || ((paramObject instanceof Float)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double)) || ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence))));
      paramObject = String.valueOf(paramObject);
    } while (((String)paramObject).length() <= paramInt);
    zzAozzaWH.zze("Ignoring " + paramString1 + ". Value is too long. name, value length", paramString2, Integer.valueOf(((String)paramObject).length()));
  }
  
  public final byte[] zza(zzqb.zzd paramzzd)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramzzd.getSerializedSize()];
      zzsn localzzsn = zzsn.zzb$46aa22ba(arrayOfByte, arrayOfByte.length);
      paramzzd.writeTo(localzzsn);
      localzzsn.zzJo();
      return arrayOfByte;
    }
    catch (IOException paramzzd)
    {
      zzAozzaWC.zzj("Data loss. Failed to serialize batch", paramzzd);
    }
    return null;
  }
  
  public final boolean zzbk(String paramString)
  {
    super.zzjk();
    if (super.getContext().checkCallingOrSelfPermission(paramString) == 0) {
      return true;
    }
    zzAozzaWJ.zzj("Permission not granted", paramString);
    return false;
  }
  
  public final boolean zzc(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 <= 0L)) {}
    while (Math.abs(super.zzjl().currentTimeMillis() - paramLong1) > paramLong2) {
      return true;
    }
    return false;
  }
  
  public final byte[] zzg(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzAozzaWC.zzj("Failed to gzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public final byte[] zzp(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = localGZIPInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localGZIPInputStream.close();
    }
    catch (IOException paramArrayOfByte)
    {
      zzAozzaWC.zzj("Failed to ungzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
    paramArrayOfByte.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    return paramArrayOfByte;
  }
  
  public final long zzr(byte[] paramArrayOfByte)
  {
    zzx.zzz(paramArrayOfByte);
    MessageDigest localMessageDigest = zzbv("MD5");
    if (localMessageDigest == null)
    {
      zzAozzaWC.zzfg("Failed to get MD5");
      return 0L;
    }
    return zzq(localMessageDigest.digest(paramArrayOfByte));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzaj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */