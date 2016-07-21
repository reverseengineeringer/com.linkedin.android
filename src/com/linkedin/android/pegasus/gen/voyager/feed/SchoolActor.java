package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SchoolActor
  implements FissileDataModel<SchoolActor>, RecordTemplate<SchoolActor>
{
  public static final SchoolActorBuilder BUILDER = SchoolActorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final FollowingInfo followingInfo;
  public final boolean hasFollowingInfo;
  public final boolean hasMiniSchool;
  public final boolean hasShowFollowAction;
  public final boolean hasUrn;
  public final MiniSchool miniSchool;
  public final boolean showFollowAction;
  public final Urn urn;
  
  SchoolActor(Urn paramUrn, MiniSchool paramMiniSchool, FollowingInfo paramFollowingInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    urn = paramUrn;
    miniSchool = paramMiniSchool;
    followingInfo = paramFollowingInfo;
    showFollowAction = paramBoolean1;
    hasUrn = paramBoolean2;
    hasMiniSchool = paramBoolean3;
    hasFollowingInfo = paramBoolean4;
    hasShowFollowAction = paramBoolean5;
    _cachedId = null;
  }
  
  public final SchoolActor accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("urn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasMiniSchool)
    {
      paramDataProcessor.startRecordField$505cff1c("miniSchool");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniSchool.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label89:
      localObject1 = null;
      bool2 = false;
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label231;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label128:
        if (localObject1 == null) {
          break label249;
        }
      }
    }
    label222:
    label231:
    label249:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasShowFollowAction)
      {
        paramDataProcessor.startRecordField$505cff1c("showFollowAction");
        paramDataProcessor.processBoolean(showFollowAction);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label303;
      }
      try
      {
        if (hasMiniSchool) {
          break label254;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.SchoolActor", "miniSchool");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniSchool)paramDataProcessor.processDataTemplate(miniSchool);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break label128;
    }
    label254:
    if (!hasFollowingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.SchoolActor", "followingInfo");
    }
    return new SchoolActor(urn, (MiniSchool)localObject2, (FollowingInfo)localObject1, showFollowAction, hasUrn, bool1, bool2, hasShowFollowAction);
    label303:
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
      paramObject = (SchoolActor)paramObject;
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
          return false;
        }
      }
      if (miniSchool != null)
      {
        if (miniSchool.equals(miniSchool)) {}
      }
      else {
        while (miniSchool != null) {
          return false;
        }
      }
      if (followingInfo != null)
      {
        if (followingInfo.equals(followingInfo)) {}
      }
      else {
        while (followingInfo != null) {
          return false;
        }
      }
    } while (showFollowAction == showFollowAction);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMiniSchool)
    {
      i = j + 1;
      if (miniSchool._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniSchool._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasFollowingInfo)
      {
        i = j + 1;
        if (followingInfo._cachedId == null) {
          break label166;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasShowFollowAction) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      i += miniSchool.getSerializedSize();
      break;
      label166:
      i += followingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (urn != null)
    {
      i = urn.hashCode();
      if (miniSchool == null) {
        break label104;
      }
      j = miniSchool.hashCode();
      label45:
      if (followingInfo == null) {
        break label109;
      }
    }
    label104:
    label109:
    for (int k = followingInfo.hashCode();; k = 0)
    {
      if (showFollowAction) {
        m = 1;
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SchoolActor");
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
    label264:
    label288:
    label340:
    label365:
    label375:
    label400:
    label410:
    label416:
    label424:
    label426:
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
        localByteBuffer.putInt(1727881693);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasMiniSchool) {
            break label365;
          }
          localByteBuffer.put((byte)1);
          if (miniSchool._cachedId == null) {
            break label340;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniSchool._cachedId);
          miniSchool.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFollowingInfo) {
            break label400;
          }
          localByteBuffer.put((byte)1);
          if (followingInfo._cachedId == null) {
            break label375;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
          followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasShowFollowAction) {
            break label416;
          }
          localByteBuffer.put((byte)1);
          if (!showFollowAction) {
            break label410;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label424;
          }
          if (str != null) {
            break label426;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniSchool.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)1);
          followingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label264;
          localByteBuffer.put((byte)0);
          break label264;
          i = 0;
          break label288;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.SchoolActor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */