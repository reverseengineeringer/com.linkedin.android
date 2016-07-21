package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InfluencerActor
  implements FissileDataModel<InfluencerActor>, RecordTemplate<InfluencerActor>
{
  public static final InfluencerActorBuilder BUILDER = InfluencerActorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final MemberDistance distance;
  public final FollowingInfo followingInfo;
  public final boolean hasDistance;
  public final boolean hasFollowingInfo;
  public final boolean hasMiniProfile;
  public final boolean hasShowFollowAction;
  public final boolean hasUrn;
  public final MiniProfile miniProfile;
  public final boolean showFollowAction;
  public final Urn urn;
  
  InfluencerActor(Urn paramUrn, MiniProfile paramMiniProfile, FollowingInfo paramFollowingInfo, boolean paramBoolean1, MemberDistance paramMemberDistance, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    urn = paramUrn;
    miniProfile = paramMiniProfile;
    followingInfo = paramFollowingInfo;
    showFollowAction = paramBoolean1;
    distance = paramMemberDistance;
    hasUrn = paramBoolean2;
    hasMiniProfile = paramBoolean3;
    hasFollowingInfo = paramBoolean4;
    hasShowFollowAction = paramBoolean5;
    hasDistance = paramBoolean6;
    _cachedId = null;
  }
  
  public final InfluencerActor accept(DataProcessor paramDataProcessor)
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
    label89:
    Object localObject3;
    boolean bool2;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label274;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label283;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label128:
        if (localObject1 == null) {
          break label301;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label139:
      if (hasShowFollowAction)
      {
        paramDataProcessor.startRecordField$505cff1c("showFollowAction");
        paramDataProcessor.processBoolean(showFollowAction);
      }
      localObject1 = null;
      bool3 = false;
      if (hasDistance)
      {
        paramDataProcessor.startRecordField$505cff1c("distance");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label310;
        }
        localObject1 = distance.accept(paramDataProcessor);
        label204:
        if (localObject1 == null) {
          break label328;
        }
      }
    }
    label274:
    label283:
    label301:
    label310:
    label328:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label387;
      }
      try
      {
        if (hasMiniProfile) {
          break label334;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.InfluencerActor", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break label128;
      bool2 = false;
      localObject3 = localObject1;
      break label139;
      localObject1 = (MemberDistance)paramDataProcessor.processDataTemplate(distance);
      break label204;
    }
    label334:
    if (!hasFollowingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.InfluencerActor", "followingInfo");
    }
    return new InfluencerActor(urn, (MiniProfile)localObject2, (FollowingInfo)localObject3, showFollowAction, (MemberDistance)localObject1, hasUrn, bool1, bool2, hasShowFollowAction, bool3);
    label387:
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
      paramObject = (InfluencerActor)paramObject;
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
          return false;
        }
      }
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
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
      if (showFollowAction != showFollowAction) {
        return false;
      }
      if (distance == null) {
        break;
      }
    } while (distance.equals(distance));
    for (;;)
    {
      return false;
      if (distance == null) {
        break;
      }
    }
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
    if (hasMiniProfile)
    {
      i = j + 1;
      if (miniProfile._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId);
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
          break label208;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
      label129:
      j = i + 1;
      i = j;
      if (hasShowFollowAction) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasDistance)
      {
        i = j + 1;
        if (distance._cachedId == null) {
          break label221;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(distance._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += miniProfile.getSerializedSize();
      break;
      label208:
      i += followingInfo.getSerializedSize();
      break label129;
      label221:
      i += distance.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (urn != null)
    {
      i = urn.hashCode();
      if (miniProfile == null) {
        break label126;
      }
      j = miniProfile.hashCode();
      if (followingInfo == null) {
        break label131;
      }
      k = followingInfo.hashCode();
      label60:
      if (!showFollowAction) {
        break label136;
      }
    }
    label126:
    label131:
    label136:
    for (int m = 1;; m = 0)
    {
      if (distance != null) {
        n = distance.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InfluencerActor");
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
    label297:
    label400:
    label425:
    label435:
    label460:
    label470:
    label476:
    label486:
    label511:
    label519:
    label521:
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
        localByteBuffer.putInt(340681564);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasMiniProfile) {
            break label425;
          }
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId == null) {
            break label400;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
          miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFollowingInfo) {
            break label460;
          }
          localByteBuffer.put((byte)1);
          if (followingInfo._cachedId == null) {
            break label435;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
          followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasShowFollowAction) {
            break label476;
          }
          localByteBuffer.put((byte)1);
          if (!showFollowAction) {
            break label470;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasDistance) {
            break label511;
          }
          localByteBuffer.put((byte)1);
          if (distance._cachedId == null) {
            break label486;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, distance._cachedId);
          distance.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label519;
          }
          if (str != null) {
            break label521;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
          break label297;
          localByteBuffer.put((byte)1);
          distance.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.InfluencerActor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */