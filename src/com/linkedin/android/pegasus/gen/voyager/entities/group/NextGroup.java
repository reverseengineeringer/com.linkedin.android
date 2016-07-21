package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NextGroup
  implements FissileDataModel<NextGroup>, RecordTemplate<NextGroup>
{
  public static final NextGroupBuilder BUILDER = NextGroupBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasMemberCount;
  public final boolean hasMiniGroup;
  public final boolean hasRecentPostAt;
  public final int memberCount;
  public final MiniGroup miniGroup;
  public final long recentPostAt;
  
  NextGroup(Urn paramUrn, MiniGroup paramMiniGroup, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entityUrn = paramUrn;
    miniGroup = paramMiniGroup;
    recentPostAt = paramLong;
    memberCount = paramInt;
    hasEntityUrn = paramBoolean1;
    hasMiniGroup = paramBoolean2;
    hasRecentPostAt = paramBoolean3;
    hasMemberCount = paramBoolean4;
    paramMiniGroup = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final NextGroup accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasMiniGroup)
    {
      paramDataProcessor.startRecordField$505cff1c("miniGroup");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label175;
      }
      localObject = miniGroup.accept(paramDataProcessor);
      if (localObject == null) {
        break label192;
      }
    }
    label175:
    label192:
    for (bool = true;; bool = false)
    {
      if (hasRecentPostAt)
      {
        paramDataProcessor.startRecordField$505cff1c("recentPostAt");
        paramDataProcessor.processLong(recentPostAt);
      }
      if (hasMemberCount)
      {
        paramDataProcessor.startRecordField$505cff1c("memberCount");
        paramDataProcessor.processInt(memberCount);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label250;
      }
      try
      {
        if (hasEntityUrn) {
          break label197;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (MiniGroup)paramDataProcessor.processDataTemplate(miniGroup);
      break;
    }
    label197:
    if (!hasMiniGroup) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup", "miniGroup");
    }
    return new NextGroup(entityUrn, (MiniGroup)localObject, recentPostAt, memberCount, hasEntityUrn, bool, hasRecentPostAt, hasMemberCount);
    label250:
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
      paramObject = (NextGroup)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (miniGroup != null)
      {
        if (miniGroup.equals(miniGroup)) {}
      }
      else {
        while (miniGroup != null) {
          return false;
        }
      }
      if (recentPostAt != recentPostAt) {
        return false;
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
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMiniGroup)
    {
      i = j + 1;
      if (miniGroup._cachedId == null) {
        break label129;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniGroup._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasRecentPostAt) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasMemberCount) {
        i = j + 4;
      }
      __sizeOfObject = i;
      return i;
      label129:
      i += miniGroup.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (entityUrn != null) {}
    for (int i = entityUrn.hashCode();; i = 0)
    {
      if (miniGroup != null) {
        j = miniGroup.hashCode();
      }
      i = (((i + 527) * 31 + j) * 31 + (int)(recentPostAt ^ recentPostAt >>> 32)) * 31 + memberCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NextGroup");
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
    label204:
    label228:
    label295:
    label320:
    label330:
    label340:
    label348:
    label350:
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
        localByteBuffer.putInt(-2120030935);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasMiniGroup) {
            break label320;
          }
          localByteBuffer.put((byte)1);
          if (miniGroup._cachedId == null) {
            break label295;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniGroup._cachedId);
          miniGroup.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRecentPostAt) {
            break label330;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(recentPostAt);
          if (!hasMemberCount) {
            break label340;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(memberCount);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label348;
          }
          if (str != null) {
            break label350;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniGroup.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label228;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */