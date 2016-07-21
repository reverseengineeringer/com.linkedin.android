package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ReachStatistics
  implements FissileDataModel<ReachStatistics>, RecordTemplate<ReachStatistics>
{
  public static final ReachStatisticsBuilder BUILDER = ReachStatisticsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasNumInNetworkViewers;
  public final boolean hasNumOutOfNetworkViewers;
  public final boolean hasSocialUpdateType;
  public final long numInNetworkViewers;
  public final long numOutOfNetworkViewers;
  public final SocialUpdateType socialUpdateType;
  
  ReachStatistics(long paramLong1, long paramLong2, SocialUpdateType paramSocialUpdateType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    numInNetworkViewers = paramLong1;
    numOutOfNetworkViewers = paramLong2;
    socialUpdateType = paramSocialUpdateType;
    hasNumInNetworkViewers = paramBoolean1;
    hasNumOutOfNetworkViewers = paramBoolean2;
    hasSocialUpdateType = paramBoolean3;
    _cachedId = null;
  }
  
  public final ReachStatistics accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumInNetworkViewers)
    {
      paramDataProcessor.startRecordField$505cff1c("numInNetworkViewers");
      paramDataProcessor.processLong(numInNetworkViewers);
    }
    if (hasNumOutOfNetworkViewers)
    {
      paramDataProcessor.startRecordField$505cff1c("numOutOfNetworkViewers");
      paramDataProcessor.processLong(numOutOfNetworkViewers);
    }
    if (hasSocialUpdateType)
    {
      paramDataProcessor.startRecordField$505cff1c("socialUpdateType");
      paramDataProcessor.processEnum(socialUpdateType);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumInNetworkViewers) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics", "numInNetworkViewers");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasNumOutOfNetworkViewers) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics", "numOutOfNetworkViewers");
      }
      if (!hasSocialUpdateType) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics", "socialUpdateType");
      }
      return new ReachStatistics(numInNetworkViewers, numOutOfNetworkViewers, socialUpdateType, hasNumInNetworkViewers, hasNumOutOfNetworkViewers, hasSocialUpdateType);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ReachStatistics)paramObject;
      if (numInNetworkViewers != numInNetworkViewers) {
        return false;
      }
      if (numOutOfNetworkViewers != numOutOfNetworkViewers) {
        return false;
      }
      if (socialUpdateType == null) {
        break;
      }
    } while (socialUpdateType.equals(socialUpdateType));
    for (;;)
    {
      return false;
      if (socialUpdateType == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasNumInNetworkViewers) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasNumOutOfNetworkViewers) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasSocialUpdateType) {
      i = j + 2;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int j = (int)(numInNetworkViewers ^ numInNetworkViewers >>> 32);
    int k = (int)(numOutOfNetworkViewers ^ numOutOfNetworkViewers >>> 32);
    if (socialUpdateType != null) {}
    for (int i = socialUpdateType.hashCode();; i = 0)
    {
      i = ((j + 527) * 31 + k) * 31 + i;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ReachStatistics");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label158:
    label230:
    label240:
    label248:
    label250:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1793547122);
        if (hasNumInNetworkViewers)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numInNetworkViewers);
          if (!hasNumOutOfNetworkViewers) {
            break label230;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numOutOfNetworkViewers);
          if (!hasSocialUpdateType) {
            break label240;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, socialUpdateType.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label248;
          }
          if (str != null) {
            break label250;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label158;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */