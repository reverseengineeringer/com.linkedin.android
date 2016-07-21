package com.crashlytics.android.core;

import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

final class CLSUUID
{
  private static String _clsId;
  private static final AtomicLong _sequenceNumber = new AtomicLong(0L);
  
  public CLSUUID(IdManager paramIdManager)
  {
    long l1 = new Date().getTime();
    long l2 = l1 / 1000L;
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)l2);
    ((ByteBuffer)localObject).order(ByteOrder.BIG_ENDIAN);
    ((ByteBuffer)localObject).position(0);
    localObject = ((ByteBuffer)localObject).array();
    int i = localObject[0];
    int j = localObject[1];
    int k = localObject[2];
    int m = localObject[3];
    localObject = convertLongToTwoByteBuffer(l1 % 1000L);
    int n = localObject[0];
    int i1 = localObject[1];
    localObject = convertLongToTwoByteBuffer(_sequenceNumber.incrementAndGet());
    int i2 = localObject[0];
    int i3 = localObject[1];
    localObject = convertLongToTwoByteBuffer(Integer.valueOf(Process.myPid()).shortValue());
    int i4 = localObject[0];
    int i5 = localObject[1];
    paramIdManager = CommonUtils.sha1(paramIdManager.getAppInstallIdentifier());
    localObject = CommonUtils.hexify(new byte[] { i, j, k, m, n, i1, i2, i3, i4, i5 });
    _clsId = String.format(Locale.US, "%s-%s-%s-%s", new Object[] { ((String)localObject).substring(0, 12), ((String)localObject).substring(12, 16), ((String)localObject).subSequence(16, 20), paramIdManager.substring(0, 12) }).toUpperCase(Locale.US);
  }
  
  private static byte[] convertLongToTwoByteBuffer(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.putShort((short)(int)paramLong);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.position(0);
    return localByteBuffer.array();
  }
  
  public final String toString()
  {
    return _clsId;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CLSUUID
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */