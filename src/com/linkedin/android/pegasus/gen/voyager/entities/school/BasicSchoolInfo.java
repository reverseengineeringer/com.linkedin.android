package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BasicSchoolInfo
  implements FissileDataModel<BasicSchoolInfo>, RecordTemplate<BasicSchoolInfo>
{
  public static final BasicSchoolInfoBuilder BUILDER = BasicSchoolInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final int followerCount;
  public final FollowingInfo followingInfo;
  public final boolean hasFollowerCount;
  public final boolean hasFollowingInfo;
  public final boolean hasLocation;
  public final boolean hasMiniSchool;
  public final String location;
  public final MiniSchool miniSchool;
  
  BasicSchoolInfo(MiniSchool paramMiniSchool, FollowingInfo paramFollowingInfo, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    miniSchool = paramMiniSchool;
    followingInfo = paramFollowingInfo;
    followerCount = paramInt;
    location = paramString;
    hasMiniSchool = paramBoolean1;
    hasFollowingInfo = paramBoolean2;
    hasFollowerCount = paramBoolean3;
    hasLocation = paramBoolean4;
    _cachedId = null;
  }
  
  public final BasicSchoolInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasMiniSchool)
    {
      paramDataProcessor.startRecordField$505cff1c("miniSchool");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniSchool.accept(paramDataProcessor);
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
      localObject1 = null;
      bool2 = false;
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label223;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label95:
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
      if (hasLocation)
      {
        paramDataProcessor.startRecordField$505cff1c("location");
        paramDataProcessor.processString(location);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label295;
      }
      try
      {
        if (hasMiniSchool) {
          break label246;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo", "miniSchool");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniSchool)paramDataProcessor.processDataTemplate(miniSchool);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break label95;
    }
    label246:
    if (!hasFollowingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo", "followingInfo");
    }
    return new BasicSchoolInfo((MiniSchool)localObject2, (FollowingInfo)localObject1, followerCount, location, bool1, bool2, hasFollowerCount, hasLocation);
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
      paramObject = (BasicSchoolInfo)paramObject;
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
      if (followerCount != followerCount) {
        return false;
      }
      if (location == null) {
        break;
      }
    } while (location.equals(location));
    for (;;)
    {
      return false;
      if (location == null) {
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
    int j;
    if (hasMiniSchool)
    {
      if (miniSchool._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniSchool._cachedId) + 9;
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
      j = i + 1;
      i = j;
      if (hasLocation) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(location);
      }
      __sizeOfObject = i;
      return i;
      i = miniSchool.getSerializedSize() + 7;
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
    if (miniSchool != null)
    {
      i = miniSchool.hashCode();
      if (followingInfo == null) {
        break label99;
      }
    }
    label99:
    for (int j = followingInfo.hashCode();; j = 0)
    {
      int m = followerCount;
      if (location != null) {
        k = location.hashCode();
      }
      i = ((j + (i + 527) * 31) * 31 + m) * 31 + k;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building BasicSchoolInfo");
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
    label254:
    label348:
    label373:
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
        localByteBuffer.putInt(-1802369130);
        if (hasMiniSchool)
        {
          localByteBuffer.put((byte)1);
          if (miniSchool._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniSchool._cachedId);
            miniSchool.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFollowingInfo) {
              break label373;
            }
            localByteBuffer.put((byte)1);
            if (followingInfo._cachedId == null) {
              break label348;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
            followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFollowerCount) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(followerCount);
            if (!hasLocation) {
              break label393;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, location);
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
          miniSchool.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          followingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label254;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */