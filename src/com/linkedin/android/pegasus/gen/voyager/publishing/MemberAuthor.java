package com.linkedin.android.pegasus.gen.voyager.publishing;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MemberAuthor
  implements FissileDataModel<MemberAuthor>, RecordTemplate<MemberAuthor>
{
  public static final MemberAuthorBuilder BUILDER = MemberAuthorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final FollowingInfo followingInfo;
  public final boolean hasFollowingInfo;
  public final boolean hasInfluencer;
  public final boolean hasMiniProfile;
  public final boolean influencer;
  public final MiniProfile miniProfile;
  
  MemberAuthor(MiniProfile paramMiniProfile, boolean paramBoolean1, FollowingInfo paramFollowingInfo, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    miniProfile = paramMiniProfile;
    influencer = paramBoolean1;
    followingInfo = paramFollowingInfo;
    hasMiniProfile = paramBoolean2;
    hasInfluencer = paramBoolean3;
    hasFollowingInfo = paramBoolean4;
    _cachedId = null;
  }
  
  public final MemberAuthor accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label189;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      if (hasInfluencer)
      {
        paramDataProcessor.startRecordField$505cff1c("influencer");
        paramDataProcessor.processBoolean(influencer);
      }
      localObject1 = null;
      bool2 = false;
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label198;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label216;
        }
      }
    }
    label189:
    label198:
    label216:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label243;
      }
      try
      {
        if (hasMiniProfile) {
          break label221;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.publishing.MemberAuthor", "miniProfile");
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
    }
    label221:
    return new MemberAuthor((MiniProfile)localObject2, influencer, (FollowingInfo)localObject1, bool1, hasInfluencer, bool2);
    label243:
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
      paramObject = (MemberAuthor)paramObject;
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
      if (followingInfo == null) {
        break;
      }
    } while (followingInfo.equals(followingInfo));
    for (;;)
    {
      return false;
      if (followingInfo == null) {
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
          break label131;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = miniProfile.getSerializedSize() + 7;
      break;
      label131:
      i += followingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (miniProfile != null)
    {
      i = miniProfile.hashCode();
      if (!influencer) {
        break label81;
      }
    }
    label81:
    for (int j = 1;; j = 0)
    {
      if (followingInfo != null) {
        k = followingInfo.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MemberAuthor");
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
    label331:
    label337:
    label347:
    label372:
    label380:
    label382:
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
        localByteBuffer.putInt(2076882028);
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInfluencer) {
              break label337;
            }
            localByteBuffer.put((byte)1);
            if (!influencer) {
              break label331;
            }
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasFollowingInfo) {
              break label372;
            }
            localByteBuffer.put((byte)1);
            if (followingInfo._cachedId == null) {
              break label347;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
            followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label380;
          }
          if (str != null) {
            break label382;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.publishing.MemberAuthor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */