package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ConnectionsInCommonInsight
  implements FissileDataModel<ConnectionsInCommonInsight>, RecordTemplate<ConnectionsInCommonInsight>
{
  public static final ConnectionsInCommonInsightBuilder BUILDER = ConnectionsInCommonInsightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasMiniProfile;
  public final boolean hasNumConnectionsInCommon;
  public final MiniProfile miniProfile;
  public final int numConnectionsInCommon;
  
  ConnectionsInCommonInsight(MiniProfile paramMiniProfile, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    miniProfile = paramMiniProfile;
    numConnectionsInCommon = paramInt;
    hasMiniProfile = paramBoolean1;
    hasNumConnectionsInCommon = paramBoolean2;
    _cachedId = null;
  }
  
  public final ConnectionsInCommonInsight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    MiniProfile localMiniProfile = null;
    boolean bool = false;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localMiniProfile = miniProfile.accept(paramDataProcessor);
      if (localMiniProfile == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      if (hasNumConnectionsInCommon)
      {
        paramDataProcessor.startRecordField$505cff1c("numConnectionsInCommon");
        paramDataProcessor.processInt(numConnectionsInCommon);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label177;
      }
      try
      {
        if (hasMiniProfile) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ConnectionsInCommonInsight", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniProfile = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
    }
    label140:
    if (!hasNumConnectionsInCommon) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ConnectionsInCommonInsight", "numConnectionsInCommon");
    }
    return new ConnectionsInCommonInsight(localMiniProfile, numConnectionsInCommon, bool, hasNumConnectionsInCommon);
    label177:
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
      paramObject = (ConnectionsInCommonInsight)paramObject;
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
    } while (numConnectionsInCommon == numConnectionsInCommon);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasMiniProfile) {
      if (miniProfile._cachedId == null) {
        break label75;
      }
    }
    label75:
    for (i = PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId) + 9;; i = miniProfile.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasNumConnectionsInCommon) {
        i = j + 4;
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (miniProfile != null) {}
    for (int i = miniProfile.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + numConnectionsInCommon;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ConnectionsInCommonInsight");
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
    label262:
    label270:
    label272:
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
        localByteBuffer.putInt(278179830);
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasNumConnectionsInCommon) {
              break label262;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(numConnectionsInCommon);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label270;
          }
          if (str != null) {
            break label272;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ConnectionsInCommonInsight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */