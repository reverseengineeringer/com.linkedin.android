package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class SessionProtobufHelper
{
  private static final ByteString SIGNAL_DEFAULT_BYTE_STRING = ByteString.copyFromUtf8("0");
  private static final ByteString UNITY_PLATFORM_BYTE_STRING = ByteString.copyFromUtf8("Unity");
  
  private static int getBinaryImageSize(ByteString paramByteString1, ByteString paramByteString2)
  {
    int j = CodedOutputStream.computeUInt64Size(1, 0L) + 0 + CodedOutputStream.computeUInt64Size(2, 0L) + CodedOutputStream.computeBytesSize(3, paramByteString1);
    int i = j;
    if (paramByteString2 != null) {
      i = j + CodedOutputStream.computeBytesSize(4, paramByteString2);
    }
    return i;
  }
  
  private static int getDeviceIdentifierSize(IdManager.DeviceIdentifierType paramDeviceIdentifierType, String paramString)
  {
    return CodedOutputStream.computeEnumSize(1, protobufIndex) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(paramString));
  }
  
  private static int getEventAppCustomAttributeSize(String paramString1, String paramString2)
  {
    int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(paramString1));
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    return i + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(paramString1));
  }
  
  private static int getEventAppExecutionExceptionSize(Throwable paramThrowable, int paramInt1, int paramInt2)
  {
    int j = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(paramThrowable.getClass().getName())) + 0;
    Object localObject = paramThrowable.getLocalizedMessage();
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8((String)localObject));
    }
    localObject = paramThrowable.getStackTrace();
    int k = localObject.length;
    j = 0;
    while (j < k)
    {
      int m = getFrameSize(localObject[j], true);
      i += CodedOutputStream.computeTagSize(4) + CodedOutputStream.computeRawVarint32Size(m) + m;
      j += 1;
    }
    paramThrowable = paramThrowable.getCause();
    j = i;
    if (paramThrowable != null)
    {
      if (paramInt1 < paramInt2)
      {
        paramInt1 = getEventAppExecutionExceptionSize(paramThrowable, paramInt1 + 1, paramInt2);
        j = i + (CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(paramInt1) + paramInt1);
      }
    }
    else {
      return j;
    }
    paramInt1 = 0;
    while (paramThrowable != null)
    {
      paramThrowable = paramThrowable.getCause();
      paramInt1 += 1;
    }
    return i + CodedOutputStream.computeUInt32Size(7, paramInt1);
  }
  
  private static int getEventAppExecutionSignalSize()
  {
    return CodedOutputStream.computeBytesSize(1, SIGNAL_DEFAULT_BYTE_STRING) + 0 + CodedOutputStream.computeBytesSize(2, SIGNAL_DEFAULT_BYTE_STRING) + CodedOutputStream.computeUInt64Size(3, 0L);
  }
  
  private static int getEventAppExecutionSize$322e56cf(Throwable paramThrowable, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, ByteString paramByteString1, ByteString paramByteString2)
  {
    int i = getThreadSize(paramThread, paramArrayOfStackTraceElement, 4, true);
    i = CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(i) + i + 0;
    int k = paramArrayOfThread.length;
    int j = 0;
    while (j < k)
    {
      m = getThreadSize(paramArrayOfThread[j], (StackTraceElement[])paramList.get(j), 0, false);
      i += CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(m) + m;
      j += 1;
    }
    j = getEventAppExecutionExceptionSize(paramThrowable, 1, 8);
    k = CodedOutputStream.computeTagSize(2);
    int m = CodedOutputStream.computeRawVarint32Size(j);
    int n = getEventAppExecutionSignalSize();
    int i1 = CodedOutputStream.computeTagSize(3);
    int i2 = CodedOutputStream.computeRawVarint32Size(n);
    int i3 = getBinaryImageSize(paramByteString1, paramByteString2);
    return CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(i3) + i3 + (i + (k + m + j) + (i1 + i2 + n));
  }
  
  private static int getEventAppSize$565823c3(Throwable paramThrowable, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, ByteString paramByteString1, ByteString paramByteString2, Map<String, String> paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt)
  {
    int i = getEventAppExecutionSize$322e56cf(paramThrowable, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramByteString1, paramByteString2);
    int j = CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(i) + i + 0;
    i = j;
    if (paramMap != null)
    {
      paramThrowable = paramMap.entrySet().iterator();
      for (;;)
      {
        i = j;
        if (!paramThrowable.hasNext()) {
          break;
        }
        paramThread = (Map.Entry)paramThrowable.next();
        i = getEventAppCustomAttributeSize((String)paramThread.getKey(), (String)paramThread.getValue());
        j += CodedOutputStream.computeTagSize(2) + CodedOutputStream.computeRawVarint32Size(i) + i;
      }
    }
    j = i;
    if (paramRunningAppProcessInfo != null)
    {
      j = importance;
      j = i + CodedOutputStream.computeBoolSize$2563259(3);
    }
    return CodedOutputStream.computeUInt32Size(4, paramInt) + j;
  }
  
  private static int getEventDeviceSize$45a61cda(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    return CodedOutputStream.computeFloatSize$255e745() + 0 + CodedOutputStream.computeSInt32Size$255f288(paramInt1) + CodedOutputStream.computeBoolSize$2563259(3) + CodedOutputStream.computeUInt32Size(4, paramInt2) + CodedOutputStream.computeUInt64Size(5, paramLong1) + CodedOutputStream.computeUInt64Size(6, paramLong2);
  }
  
  private static int getFrameSize(StackTraceElement paramStackTraceElement, boolean paramBoolean)
  {
    int k = 2;
    int j;
    if (paramStackTraceElement.isNativeMethod())
    {
      i = CodedOutputStream.computeUInt64Size(1, Math.max(paramStackTraceElement.getLineNumber(), 0)) + 0;
      j = i + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(paramStackTraceElement.getClassName() + "." + paramStackTraceElement.getMethodName()));
      i = j;
      if (paramStackTraceElement.getFileName() != null) {
        i = j + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(paramStackTraceElement.getFileName()));
      }
      j = i;
      if (!paramStackTraceElement.isNativeMethod())
      {
        j = i;
        if (paramStackTraceElement.getLineNumber() > 0) {
          j = i + CodedOutputStream.computeUInt64Size(4, paramStackTraceElement.getLineNumber());
        }
      }
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (int i = k;; i = 0)
    {
      return CodedOutputStream.computeUInt32Size(5, i) + j;
      i = CodedOutputStream.computeUInt64Size(1, 0L) + 0;
      break;
    }
  }
  
  private static int getThreadSize(Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
  {
    int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(paramThread.getName())) + CodedOutputStream.computeUInt32Size(2, paramInt);
    int j = paramArrayOfStackTraceElement.length;
    paramInt = 0;
    while (paramInt < j)
    {
      int k = getFrameSize(paramArrayOfStackTraceElement[paramInt], paramBoolean);
      i += CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(k) + k;
      paramInt += 1;
    }
    return i;
  }
  
  private static ByteString stringToByteString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return ByteString.copyFromUtf8(paramString);
  }
  
  public static void writeBeginSession(CodedOutputStream paramCodedOutputStream, String paramString1, String paramString2, long paramLong)
    throws Exception
  {
    paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8(paramString2));
    paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(paramString1));
    paramCodedOutputStream.writeUInt64(3, paramLong);
  }
  
  private static void writeFrame(CodedOutputStream paramCodedOutputStream, int paramInt, StackTraceElement paramStackTraceElement, boolean paramBoolean)
    throws Exception
  {
    int i = 4;
    paramCodedOutputStream.writeTag(paramInt, 2);
    paramCodedOutputStream.writeRawVarint32(getFrameSize(paramStackTraceElement, paramBoolean));
    if (paramStackTraceElement.isNativeMethod())
    {
      paramCodedOutputStream.writeUInt64(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
      paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(paramStackTraceElement.getClassName() + "." + paramStackTraceElement.getMethodName()));
      if (paramStackTraceElement.getFileName() != null) {
        paramCodedOutputStream.writeBytes(3, ByteString.copyFromUtf8(paramStackTraceElement.getFileName()));
      }
      if ((!paramStackTraceElement.isNativeMethod()) && (paramStackTraceElement.getLineNumber() > 0)) {
        paramCodedOutputStream.writeUInt64(4, paramStackTraceElement.getLineNumber());
      }
      if (!paramBoolean) {
        break label142;
      }
    }
    label142:
    for (paramInt = i;; paramInt = 0)
    {
      paramCodedOutputStream.writeUInt32(5, paramInt);
      return;
      paramCodedOutputStream.writeUInt64(1, 0L);
      break;
    }
  }
  
  public static void writeSessionApp(CodedOutputStream paramCodedOutputStream, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
    throws Exception
  {
    ByteString localByteString = ByteString.copyFromUtf8(paramString1);
    paramString2 = ByteString.copyFromUtf8(paramString2);
    paramString3 = ByteString.copyFromUtf8(paramString3);
    paramString4 = ByteString.copyFromUtf8(paramString4);
    paramString5 = ByteString.copyFromUtf8(paramString5);
    if (paramString6 != null) {}
    for (paramString1 = ByteString.copyFromUtf8(paramString6);; paramString1 = null)
    {
      paramCodedOutputStream.writeTag(7, 2);
      int i = CodedOutputStream.computeBytesSize(1, localByteString);
      int j = CodedOutputStream.computeBytesSize(2, paramString3);
      int k = CodedOutputStream.computeBytesSize(3, paramString4);
      int m = CodedOutputStream.computeBytesSize(1, paramString2) + 0;
      j = i + 0 + j + k + (m + (CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(m))) + CodedOutputStream.computeBytesSize(6, paramString5);
      i = j;
      if (paramString1 != null) {
        i = j + CodedOutputStream.computeBytesSize(8, UNITY_PLATFORM_BYTE_STRING) + CodedOutputStream.computeBytesSize(9, paramString1);
      }
      paramCodedOutputStream.writeRawVarint32(i + CodedOutputStream.computeEnumSize(10, paramInt));
      paramCodedOutputStream.writeBytes(1, localByteString);
      paramCodedOutputStream.writeBytes(2, paramString3);
      paramCodedOutputStream.writeBytes(3, paramString4);
      paramCodedOutputStream.writeTag(5, 2);
      paramCodedOutputStream.writeRawVarint32(CodedOutputStream.computeBytesSize(1, paramString2) + 0);
      paramCodedOutputStream.writeBytes(1, paramString2);
      paramCodedOutputStream.writeBytes(6, paramString5);
      if (paramString1 != null)
      {
        paramCodedOutputStream.writeBytes(8, UNITY_PLATFORM_BYTE_STRING);
        paramCodedOutputStream.writeBytes(9, paramString1);
      }
      paramCodedOutputStream.writeEnum(10, paramInt);
      return;
    }
  }
  
  public static void writeSessionDevice(CodedOutputStream paramCodedOutputStream, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map<IdManager.DeviceIdentifierType, String> paramMap, int paramInt3, String paramString3, String paramString4)
    throws Exception
  {
    paramString1 = ByteString.copyFromUtf8(paramString1);
    ByteString localByteString = stringToByteString(paramString2);
    paramString2 = stringToByteString(paramString4);
    paramString3 = stringToByteString(paramString3);
    paramCodedOutputStream.writeTag(9, 2);
    int j = CodedOutputStream.computeBytesSize(1, paramString1);
    int k = CodedOutputStream.computeEnumSize(3, paramInt1);
    if (localByteString == null) {}
    for (int i = 0;; i = CodedOutputStream.computeBytesSize(4, localByteString))
    {
      i = i + (k + (j + 0)) + CodedOutputStream.computeUInt32Size(5, paramInt2) + CodedOutputStream.computeUInt64Size(6, paramLong1) + CodedOutputStream.computeUInt64Size(7, paramLong2) + CodedOutputStream.computeBoolSize$2563259(10);
      if (paramMap == null) {
        break;
      }
      paramString4 = paramMap.entrySet().iterator();
      for (;;)
      {
        j = i;
        if (!paramString4.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)paramString4.next();
        j = getDeviceIdentifierSize((IdManager.DeviceIdentifierType)localEntry.getKey(), (String)localEntry.getValue());
        i = j + (CodedOutputStream.computeTagSize(11) + CodedOutputStream.computeRawVarint32Size(j)) + i;
      }
    }
    j = i;
    int m = CodedOutputStream.computeUInt32Size(12, paramInt3);
    if (paramString3 == null)
    {
      i = 0;
      if (paramString2 != null) {
        break label408;
      }
    }
    label408:
    for (k = 0;; k = CodedOutputStream.computeBytesSize(14, paramString2))
    {
      paramCodedOutputStream.writeRawVarint32(k + (j + m + i));
      paramCodedOutputStream.writeBytes(1, paramString1);
      paramCodedOutputStream.writeEnum(3, paramInt1);
      paramCodedOutputStream.writeBytes(4, localByteString);
      paramCodedOutputStream.writeUInt32(5, paramInt2);
      paramCodedOutputStream.writeUInt64(6, paramLong1);
      paramCodedOutputStream.writeUInt64(7, paramLong2);
      paramCodedOutputStream.writeBool(10, paramBoolean);
      paramString1 = paramMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramMap = (Map.Entry)paramString1.next();
        paramCodedOutputStream.writeTag(11, 2);
        paramCodedOutputStream.writeRawVarint32(getDeviceIdentifierSize((IdManager.DeviceIdentifierType)paramMap.getKey(), (String)paramMap.getValue()));
        paramCodedOutputStream.writeEnum(1, getKeyprotobufIndex);
        paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8((String)paramMap.getValue()));
      }
      i = CodedOutputStream.computeBytesSize(13, paramString3);
      break;
    }
    paramCodedOutputStream.writeUInt32(12, paramInt3);
    if (paramString3 != null) {
      paramCodedOutputStream.writeBytes(13, paramString3);
    }
    if (paramString2 != null) {
      paramCodedOutputStream.writeBytes(14, paramString2);
    }
  }
  
  public static void writeSessionEvent(CodedOutputStream paramCodedOutputStream, long paramLong1, String paramString1, Throwable paramThrowable, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, Map<String, String> paramMap, LogFileManager paramLogFileManager, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt1, String paramString2, String paramString3, float paramFloat, int paramInt2, boolean paramBoolean, long paramLong2, long paramLong3)
    throws Exception
  {
    ByteString localByteString = ByteString.copyFromUtf8(paramString2);
    if (paramString3 == null) {}
    int k;
    for (paramString2 = null;; paramString2 = ByteString.copyFromUtf8(paramString3.replace("-", "")))
    {
      paramString3 = paramLogFileManager.getByteStringForLog();
      if (paramString3 == null) {
        Fabric.getLogger().d("CrashlyticsCore", "No log data to include with this event.");
      }
      paramLogFileManager.clearLog();
      paramCodedOutputStream.writeTag(10, 2);
      i = CodedOutputStream.computeUInt64Size(1, paramLong1);
      j = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(paramString1));
      k = getEventAppSize$565823c3(paramThrowable, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, localByteString, paramString2, paramMap, paramRunningAppProcessInfo, paramInt1);
      int m = CodedOutputStream.computeTagSize(3);
      int n = CodedOutputStream.computeRawVarint32Size(k);
      int i1 = getEventDeviceSize$45a61cda(paramInt2, paramInt1, paramLong2, paramLong3);
      j = k + (m + n) + (i + 0 + j) + (i1 + (CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(i1)));
      i = j;
      if (paramString3 != null)
      {
        i = CodedOutputStream.computeBytesSize(1, paramString3);
        i = j + (i + (CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(i)));
      }
      paramCodedOutputStream.writeRawVarint32(i);
      paramCodedOutputStream.writeUInt64(1, paramLong1);
      paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(paramString1));
      paramCodedOutputStream.writeTag(3, 2);
      paramCodedOutputStream.writeRawVarint32(getEventAppSize$565823c3(paramThrowable, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, localByteString, paramString2, paramMap, paramRunningAppProcessInfo, paramInt1));
      paramCodedOutputStream.writeTag(1, 2);
      paramCodedOutputStream.writeRawVarint32(getEventAppExecutionSize$322e56cf(paramThrowable, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, localByteString, paramString2));
      writeThread(paramCodedOutputStream, paramThread, paramArrayOfStackTraceElement, 4, true);
      j = paramArrayOfThread.length;
      i = 0;
      while (i < j)
      {
        writeThread(paramCodedOutputStream, paramArrayOfThread[i], (StackTraceElement[])paramList.get(i), 0, false);
        i += 1;
      }
    }
    int i = 1;
    for (int j = 2;; j = 6)
    {
      paramCodedOutputStream.writeTag(j, 2);
      paramCodedOutputStream.writeRawVarint32(getEventAppExecutionExceptionSize(paramThrowable, 1, 8));
      paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8(paramThrowable.getClass().getName()));
      paramString1 = paramThrowable.getLocalizedMessage();
      if (paramString1 != null) {
        paramCodedOutputStream.writeBytes(3, ByteString.copyFromUtf8(paramString1));
      }
      paramString1 = paramThrowable.getStackTrace();
      k = paramString1.length;
      j = 0;
      while (j < k)
      {
        writeFrame(paramCodedOutputStream, 4, paramString1[j], true);
        j += 1;
      }
      paramThrowable = paramThrowable.getCause();
      if (paramThrowable == null) {
        break label508;
      }
      if (i >= 8) {
        break;
      }
      i += 1;
    }
    i = 0;
    while (paramThrowable != null)
    {
      paramThrowable = paramThrowable.getCause();
      i += 1;
    }
    paramCodedOutputStream.writeUInt32(7, i);
    label508:
    paramCodedOutputStream.writeTag(3, 2);
    paramCodedOutputStream.writeRawVarint32(getEventAppExecutionSignalSize());
    paramCodedOutputStream.writeBytes(1, SIGNAL_DEFAULT_BYTE_STRING);
    paramCodedOutputStream.writeBytes(2, SIGNAL_DEFAULT_BYTE_STRING);
    paramCodedOutputStream.writeUInt64(3, 0L);
    paramCodedOutputStream.writeTag(4, 2);
    paramCodedOutputStream.writeRawVarint32(getBinaryImageSize(localByteString, paramString2));
    paramCodedOutputStream.writeUInt64(1, 0L);
    paramCodedOutputStream.writeUInt64(2, 0L);
    paramCodedOutputStream.writeBytes(3, localByteString);
    if (paramString2 != null) {
      paramCodedOutputStream.writeBytes(4, paramString2);
    }
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramThread = paramMap.entrySet().iterator();
      while (paramThread.hasNext())
      {
        paramString1 = (Map.Entry)paramThread.next();
        paramCodedOutputStream.writeTag(2, 2);
        paramCodedOutputStream.writeRawVarint32(getEventAppCustomAttributeSize((String)paramString1.getKey(), (String)paramString1.getValue()));
        paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8((String)paramString1.getKey()));
        paramThrowable = (String)paramString1.getValue();
        paramString1 = paramThrowable;
        if (paramThrowable == null) {
          paramString1 = "";
        }
        paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(paramString1));
      }
    }
    if (paramRunningAppProcessInfo != null) {
      if (importance == 100) {
        break label847;
      }
    }
    label847:
    for (boolean bool = true;; bool = false)
    {
      paramCodedOutputStream.writeBool(3, bool);
      paramCodedOutputStream.writeUInt32(4, paramInt1);
      paramCodedOutputStream.writeTag(5, 2);
      paramCodedOutputStream.writeRawVarint32(getEventDeviceSize$45a61cda(paramInt2, paramInt1, paramLong2, paramLong3));
      paramCodedOutputStream.writeFloat$255e752(paramFloat);
      paramCodedOutputStream.writeSInt32$255f295(paramInt2);
      paramCodedOutputStream.writeBool(3, paramBoolean);
      paramCodedOutputStream.writeUInt32(4, paramInt1);
      paramCodedOutputStream.writeUInt64(5, paramLong2);
      paramCodedOutputStream.writeUInt64(6, paramLong3);
      if (paramString3 != null)
      {
        paramCodedOutputStream.writeTag(6, 2);
        paramCodedOutputStream.writeRawVarint32(CodedOutputStream.computeBytesSize(1, paramString3));
        paramCodedOutputStream.writeBytes(1, paramString3);
      }
      return;
    }
  }
  
  public static void writeSessionOS(CodedOutputStream paramCodedOutputStream, boolean paramBoolean)
    throws Exception
  {
    ByteString localByteString1 = ByteString.copyFromUtf8(Build.VERSION.RELEASE);
    ByteString localByteString2 = ByteString.copyFromUtf8(Build.VERSION.CODENAME);
    paramCodedOutputStream.writeTag(8, 2);
    paramCodedOutputStream.writeRawVarint32(CodedOutputStream.computeEnumSize(1, 3) + 0 + CodedOutputStream.computeBytesSize(2, localByteString1) + CodedOutputStream.computeBytesSize(3, localByteString2) + CodedOutputStream.computeBoolSize$2563259(4));
    paramCodedOutputStream.writeEnum(1, 3);
    paramCodedOutputStream.writeBytes(2, localByteString1);
    paramCodedOutputStream.writeBytes(3, localByteString2);
    paramCodedOutputStream.writeBool(4, paramBoolean);
  }
  
  public static void writeSessionUser(CodedOutputStream paramCodedOutputStream, String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    paramString1 = ByteString.copyFromUtf8((String)localObject);
    localObject = stringToByteString(paramString2);
    ByteString localByteString = stringToByteString(paramString3);
    int j = CodedOutputStream.computeBytesSize(1, paramString1) + 0;
    int i = j;
    if (paramString2 != null) {
      i = j + CodedOutputStream.computeBytesSize(2, (ByteString)localObject);
    }
    j = i;
    if (paramString3 != null) {
      j = i + CodedOutputStream.computeBytesSize(3, localByteString);
    }
    paramCodedOutputStream.writeTag(6, 2);
    paramCodedOutputStream.writeRawVarint32(j);
    paramCodedOutputStream.writeBytes(1, paramString1);
    if (paramString2 != null) {
      paramCodedOutputStream.writeBytes(2, (ByteString)localObject);
    }
    if (paramString3 != null) {
      paramCodedOutputStream.writeBytes(3, localByteString);
    }
  }
  
  private static void writeThread(CodedOutputStream paramCodedOutputStream, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
    throws Exception
  {
    paramCodedOutputStream.writeTag(1, 2);
    paramCodedOutputStream.writeRawVarint32(getThreadSize(paramThread, paramArrayOfStackTraceElement, paramInt, paramBoolean));
    paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8(paramThread.getName()));
    paramCodedOutputStream.writeUInt32(2, paramInt);
    int i = paramArrayOfStackTraceElement.length;
    paramInt = 0;
    while (paramInt < i)
    {
      writeFrame(paramCodedOutputStream, 3, paramArrayOfStackTraceElement[paramInt], paramBoolean);
      paramInt += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.SessionProtobufHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */