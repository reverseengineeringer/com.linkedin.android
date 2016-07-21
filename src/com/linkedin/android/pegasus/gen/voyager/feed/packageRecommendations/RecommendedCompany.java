package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class RecommendedCompany
  implements FissileDataModel<RecommendedCompany>, RecordTemplate<RecommendedCompany>
{
  public static final RecommendedCompanyBuilder BUILDER = RecommendedCompanyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final FollowingInfo followingInfo;
  public final boolean hasFollowingInfo;
  public final boolean hasMiniCompany;
  public final boolean hasReason;
  public final MiniCompany miniCompany;
  public final AnnotatedText reason;
  
  RecommendedCompany(MiniCompany paramMiniCompany, FollowingInfo paramFollowingInfo, AnnotatedText paramAnnotatedText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    miniCompany = paramMiniCompany;
    followingInfo = paramFollowingInfo;
    reason = paramAnnotatedText;
    hasMiniCompany = paramBoolean1;
    hasFollowingInfo = paramBoolean2;
    hasReason = paramBoolean3;
    _cachedId = null;
  }
  
  public final RecommendedCompany accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasMiniCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("miniCompany");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniCompany.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label216;
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
          break label225;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label243;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasReason)
      {
        paramDataProcessor.startRecordField$505cff1c("reason");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label252;
        }
        localObject1 = reason.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label270;
        }
      }
    }
    label216:
    label225:
    label243:
    label252:
    label270:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label313;
      }
      try
      {
        if (hasMiniCompany) {
          break label276;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedCompany", "miniCompany");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(reason);
      break label146;
    }
    label276:
    if (!hasFollowingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedCompany", "followingInfo");
    }
    return new RecommendedCompany((MiniCompany)localObject2, (FollowingInfo)localObject3, (AnnotatedText)localObject1, bool1, bool2, bool3);
    label313:
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
      paramObject = (RecommendedCompany)paramObject;
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
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
    if (hasMiniCompany)
    {
      if (miniCompany._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasFollowingInfo)
      {
        i = j + 1;
        if (followingInfo._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasReason)
      {
        i = j + 1;
        if (reason._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(reason._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = miniCompany.getSerializedSize() + 7;
      break;
      label156:
      i += followingInfo.getSerializedSize();
      break label93;
      label169:
      i += reason.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (miniCompany != null)
    {
      i = miniCompany.hashCode();
      if (followingInfo == null) {
        break label87;
      }
    }
    label87:
    for (int j = followingInfo.hashCode();; j = 0)
    {
      if (reason != null) {
        k = reason.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RecommendedCompany");
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
    label230:
    label358:
    label383:
    label393:
    label418:
    label426:
    label428:
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
        localByteBuffer.putInt(-1564503386);
        if (hasMiniCompany)
        {
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
            miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFollowingInfo) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (followingInfo._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
            followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasReason) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (reason._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, reason._cachedId);
            reason.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label426;
          }
          if (str != null) {
            break label428;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          followingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedCompany
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */