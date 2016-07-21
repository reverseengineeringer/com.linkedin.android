package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EntitiesMiniProfile
  implements FissileDataModel<EntitiesMiniProfile>, RecordTemplate<EntitiesMiniProfile>
{
  public static final EntitiesMiniProfileBuilder BUILDER = EntitiesMiniProfileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final MemberDistance distance;
  public final boolean hasDistance;
  public final boolean hasHeadless;
  public final boolean hasMiniProfile;
  public final boolean headless;
  public final MiniProfile miniProfile;
  
  EntitiesMiniProfile(MiniProfile paramMiniProfile, MemberDistance paramMemberDistance, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    miniProfile = paramMiniProfile;
    distance = paramMemberDistance;
    headless = paramBoolean1;
    hasMiniProfile = paramBoolean2;
    hasDistance = paramBoolean3;
    hasHeadless = paramBoolean4;
    _cachedId = null;
  }
  
  public final EntitiesMiniProfile accept(DataProcessor paramDataProcessor)
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
      localObject1 = null;
      bool2 = false;
      if (hasDistance)
      {
        paramDataProcessor.startRecordField$505cff1c("distance");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label198;
        }
        localObject1 = distance.accept(paramDataProcessor);
        label95:
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
      if (hasHeadless)
      {
        paramDataProcessor.startRecordField$505cff1c("headless");
        paramDataProcessor.processBoolean(headless);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label243;
      }
      try
      {
        if (hasMiniProfile) {
          break label221;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile", "miniProfile");
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
      localObject1 = (MemberDistance)paramDataProcessor.processDataTemplate(distance);
      break label95;
    }
    label221:
    return new EntitiesMiniProfile((MiniProfile)localObject2, (MemberDistance)localObject1, headless, bool1, bool2, hasHeadless);
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
      paramObject = (EntitiesMiniProfile)paramObject;
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (distance != null)
      {
        if (distance.equals(distance)) {}
      }
      else {
        while (distance != null) {
          return false;
        }
      }
    } while (headless == headless);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j;
    if (hasMiniProfile)
    {
      if (miniProfile._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasDistance)
      {
        i = j + 1;
        if (distance._cachedId == null) {
          break label131;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(distance._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasHeadless) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      i = miniProfile.getSerializedSize() + 7;
      break;
      label131:
      i += distance.getSerializedSize();
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
      if (distance == null) {
        break label81;
      }
    }
    label81:
    for (int j = distance.hashCode();; j = 0)
    {
      if (headless) {
        k = 1;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EntitiesMiniProfile");
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
    label331:
    label356:
    label366:
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
        localByteBuffer.putInt(-2136325432);
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDistance) {
              break label356;
            }
            localByteBuffer.put((byte)1);
            if (distance._cachedId == null) {
              break label331;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, distance._cachedId);
            distance.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasHeadless) {
              break label372;
            }
            localByteBuffer.put((byte)1);
            if (!headless) {
              break label366;
            }
            i = 1;
            localByteBuffer.put((byte)i);
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
          localByteBuffer.put((byte)1);
          distance.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          i = 0;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */