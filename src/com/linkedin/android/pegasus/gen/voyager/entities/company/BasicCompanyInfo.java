package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BasicCompanyInfo
  implements FissileDataModel<BasicCompanyInfo>, RecordTemplate<BasicCompanyInfo>
{
  public static final BasicCompanyInfoBuilder BUILDER = BasicCompanyInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final int followerCount;
  public final FollowingInfo followingInfo;
  public final boolean hasFollowerCount;
  public final boolean hasFollowingInfo;
  public final boolean hasHeadquarters;
  public final boolean hasMiniCompany;
  public final String headquarters;
  public final MiniCompany miniCompany;
  
  BasicCompanyInfo(MiniCompany paramMiniCompany, String paramString, FollowingInfo paramFollowingInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    miniCompany = paramMiniCompany;
    headquarters = paramString;
    followingInfo = paramFollowingInfo;
    followerCount = paramInt;
    hasMiniCompany = paramBoolean1;
    hasHeadquarters = paramBoolean2;
    hasFollowingInfo = paramBoolean3;
    hasFollowerCount = paramBoolean4;
    _cachedId = null;
  }
  
  public final BasicCompanyInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasMiniCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("miniCompany");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniCompany.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label214;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      if (hasHeadquarters)
      {
        paramDataProcessor.startRecordField$505cff1c("headquarters");
        paramDataProcessor.processString(headquarters);
      }
      localObject1 = null;
      bool2 = false;
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label223;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label241;
        }
      }
    }
    label214:
    label223:
    label241:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasFollowerCount)
      {
        paramDataProcessor.startRecordField$505cff1c("followerCount");
        paramDataProcessor.processInt(followerCount);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label295;
      }
      try
      {
        if (hasMiniCompany) {
          break label246;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo", "miniCompany");
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
      break label120;
    }
    label246:
    if (!hasFollowingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo", "followingInfo");
    }
    return new BasicCompanyInfo((MiniCompany)localObject2, headquarters, (FollowingInfo)localObject1, followerCount, bool1, hasHeadquarters, bool2, hasFollowerCount);
    label295:
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
      paramObject = (BasicCompanyInfo)paramObject;
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
          return false;
        }
      }
      if (headquarters != null)
      {
        if (headquarters.equals(headquarters)) {}
      }
      else {
        while (headquarters != null) {
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
    } while (followerCount == followerCount);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j;
    if (hasMiniCompany)
    {
      if (miniCompany._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasHeadquarters) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(headquarters);
      }
      j = i + 1;
      i = j;
      if (hasFollowingInfo)
      {
        i = j + 1;
        if (followingInfo._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasFollowerCount) {
        i = j + 4;
      }
      __sizeOfObject = i;
      return i;
      i = miniCompany.getSerializedSize() + 7;
      break;
      label156:
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
    if (miniCompany != null)
    {
      i = miniCompany.hashCode();
      if (headquarters == null) {
        break label95;
      }
    }
    label95:
    for (int j = headquarters.hashCode();; j = 0)
    {
      if (followingInfo != null) {
        k = followingInfo.hashCode();
      }
      i = ((j + (i + 527) * 31) * 31 + k) * 31 + followerCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building BasicCompanyInfo");
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
    label196:
    label256:
    label348:
    label358:
    label383:
    label393:
    label401:
    label403:
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
        localByteBuffer.putInt(1439973268);
        if (hasMiniCompany)
        {
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
            miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasHeadquarters) {
              break label348;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, headquarters);
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
            if (!hasFollowerCount) {
              break label393;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(followerCount);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label401;
          }
          if (str != null) {
            break label403;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)1);
          followingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label256;
          localByteBuffer.put((byte)0);
          break label256;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */