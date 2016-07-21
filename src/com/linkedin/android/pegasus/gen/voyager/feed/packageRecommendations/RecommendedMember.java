package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class RecommendedMember
  implements FissileDataModel<RecommendedMember>, RecordTemplate<RecommendedMember>
{
  public static final RecommendedMemberBuilder BUILDER = RecommendedMemberBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final FollowingInfo followingInfo;
  public final boolean hasFollowingInfo;
  public final boolean hasInfluencer;
  public final boolean hasMiniProfile;
  public final boolean hasReason;
  public final boolean influencer;
  public final MiniProfile miniProfile;
  public final AnnotatedText reason;
  
  RecommendedMember(MiniProfile paramMiniProfile, boolean paramBoolean1, FollowingInfo paramFollowingInfo, AnnotatedText paramAnnotatedText, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    miniProfile = paramMiniProfile;
    influencer = paramBoolean1;
    followingInfo = paramFollowingInfo;
    reason = paramAnnotatedText;
    hasMiniProfile = paramBoolean2;
    hasInfluencer = paramBoolean3;
    hasFollowingInfo = paramBoolean4;
    hasReason = paramBoolean5;
    _cachedId = null;
  }
  
  public final RecommendedMember accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label241;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasInfluencer)
      {
        paramDataProcessor.startRecordField$505cff1c("influencer");
        paramDataProcessor.processBoolean(influencer);
      }
      localObject3 = null;
      bool2 = false;
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label250;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label268;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label131:
      localObject1 = null;
      bool3 = false;
      if (hasReason)
      {
        paramDataProcessor.startRecordField$505cff1c("reason");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label277;
        }
        localObject1 = reason.accept(paramDataProcessor);
        label171:
        if (localObject1 == null) {
          break label295;
        }
      }
    }
    label241:
    label250:
    label268:
    label277:
    label295:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label365;
      }
      try
      {
        if (hasMiniProfile) {
          break label301;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break label120;
      bool2 = false;
      localObject3 = localObject1;
      break label131;
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(reason);
      break label171;
    }
    label301:
    if (!hasInfluencer) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember", "influencer");
    }
    if (!hasFollowingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember", "followingInfo");
    }
    return new RecommendedMember((MiniProfile)localObject2, influencer, (FollowingInfo)localObject3, (AnnotatedText)localObject1, bool1, hasInfluencer, bool2, bool3);
    label365:
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
      paramObject = (RecommendedMember)paramObject;
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (influencer != influencer) {
        return false;
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
      if (reason == null) {
        break;
      }
    } while (reason.equals(reason));
    for (;;)
    {
      return false;
      if (reason == null) {
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
    if (hasMiniProfile)
    {
      if (miniProfile._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasInfluencer) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasFollowingInfo)
      {
        i = j + 1;
        if (followingInfo._cachedId == null) {
          break label173;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
      label110:
      j = i + 1;
      i = j;
      if (hasReason)
      {
        i = j + 1;
        if (reason._cachedId == null) {
          break label186;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(reason._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = miniProfile.getSerializedSize() + 7;
      break;
      label173:
      i += followingInfo.getSerializedSize();
      break label110;
      label186:
      i += reason.getSerializedSize();
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
    if (miniProfile != null)
    {
      i = miniProfile.hashCode();
      if (!influencer) {
        break label104;
      }
      j = 1;
      label39:
      if (followingInfo == null) {
        break label109;
      }
    }
    label104:
    label109:
    for (int k = followingInfo.hashCode();; k = 0)
    {
      if (reason != null) {
        m = reason.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label39;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RecommendedMember");
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
    label194:
    label203:
    label263:
    label391:
    label397:
    label407:
    label432:
    label442:
    label467:
    label475:
    label477:
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
        localByteBuffer.putInt(-763935343);
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInfluencer) {
              break label397;
            }
            localByteBuffer.put((byte)1);
            if (!influencer) {
              break label391;
            }
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasFollowingInfo) {
              break label432;
            }
            localByteBuffer.put((byte)1);
            if (followingInfo._cachedId == null) {
              break label407;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
            followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasReason) {
              break label467;
            }
            localByteBuffer.put((byte)1);
            if (reason._cachedId == null) {
              break label442;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, reason._cachedId);
            reason.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label475;
          }
          if (str != null) {
            break label477;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label194;
          localByteBuffer.put((byte)0);
          break label203;
          localByteBuffer.put((byte)1);
          followingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label263;
          localByteBuffer.put((byte)0);
          break label263;
          localByteBuffer.put((byte)1);
          reason.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */