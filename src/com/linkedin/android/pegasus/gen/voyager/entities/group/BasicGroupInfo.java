package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BasicGroupInfo
  implements FissileDataModel<BasicGroupInfo>, RecordTemplate<BasicGroupInfo>
{
  public static final BasicGroupInfoBuilder BUILDER = BasicGroupInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasMemberCount;
  public final boolean hasMiniGroup;
  public final int memberCount;
  public final MiniGroup miniGroup;
  
  BasicGroupInfo(MiniGroup paramMiniGroup, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    miniGroup = paramMiniGroup;
    memberCount = paramInt;
    hasMiniGroup = paramBoolean1;
    hasMemberCount = paramBoolean2;
    _cachedId = null;
  }
  
  public final BasicGroupInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    MiniGroup localMiniGroup = null;
    boolean bool = false;
    if (hasMiniGroup)
    {
      paramDataProcessor.startRecordField$505cff1c("miniGroup");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localMiniGroup = miniGroup.accept(paramDataProcessor);
      if (localMiniGroup == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      if (hasMemberCount)
      {
        paramDataProcessor.startRecordField$505cff1c("memberCount");
        paramDataProcessor.processInt(memberCount);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label158;
      }
      try
      {
        if (hasMiniGroup) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo", "miniGroup");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniGroup = (MiniGroup)paramDataProcessor.processDataTemplate(miniGroup);
      break;
    }
    label140:
    return new BasicGroupInfo(localMiniGroup, memberCount, bool, hasMemberCount);
    label158:
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
      paramObject = (BasicGroupInfo)paramObject;
      if (miniGroup != null)
      {
        if (miniGroup.equals(miniGroup)) {}
      }
      else {
        while (miniGroup != null) {
          return false;
        }
      }
    } while (memberCount == memberCount);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasMiniGroup) {
      if (miniGroup._cachedId == null) {
        break label75;
      }
    }
    label75:
    for (i = PegasusBinaryUtils.getEncodedLength(miniGroup._cachedId) + 9;; i = miniGroup.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasMemberCount) {
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
    if (miniGroup != null) {}
    for (int i = miniGroup.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + memberCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building BasicGroupInfo");
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
        localByteBuffer.putInt(-842627211);
        if (hasMiniGroup)
        {
          localByteBuffer.put((byte)1);
          if (miniGroup._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniGroup._cachedId);
            miniGroup.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMemberCount) {
              break label262;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(memberCount);
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
          miniGroup.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */