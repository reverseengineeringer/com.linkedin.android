package com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PeopleYouMayKnow$Entity
  implements FissileDataModel<Entity>, UnionTemplate<Entity>
{
  public static final PeopleYouMayKnowBuilder.EntityBuilder BUILDER = PeopleYouMayKnowBuilder.EntityBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final GuestContact guestContactValue;
  public final boolean hasGuestContactValue;
  public final boolean hasMiniProfileValue;
  public final MiniProfile miniProfileValue;
  
  PeopleYouMayKnow$Entity(MiniProfile paramMiniProfile, GuestContact paramGuestContact, boolean paramBoolean1, boolean paramBoolean2)
  {
    miniProfileValue = paramMiniProfile;
    guestContactValue = paramGuestContact;
    hasMiniProfileValue = paramBoolean1;
    hasGuestContactValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final Entity accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasMiniProfileValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.MiniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfileValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label149;
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
      if (hasGuestContactValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.growth.abi.GuestContact");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = guestContactValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label176;
        }
      }
    }
    label149:
    label158:
    label176:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label181;
      }
      return new Entity((MiniProfile)localObject2, (GuestContact)localObject1, bool1, bool2);
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfileValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (GuestContact)paramDataProcessor.processDataTemplate(guestContactValue);
      break label95;
    }
    label181:
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
      paramObject = (Entity)paramObject;
      if (miniProfileValue != null)
      {
        if (miniProfileValue.equals(miniProfileValue)) {}
      }
      else {
        while (miniProfileValue != null) {
          return false;
        }
      }
      if (guestContactValue == null) {
        break;
      }
    } while (guestContactValue.equals(guestContactValue));
    for (;;)
    {
      return false;
      if (guestContactValue == null) {
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
    if (hasMiniProfileValue)
    {
      if (miniProfileValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniProfileValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasGuestContactValue)
      {
        i = j + 1;
        if (guestContactValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(guestContactValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = miniProfileValue.getSerializedSize() + 7;
      break;
      label114:
      i += guestContactValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (miniProfileValue != null) {}
    for (int i = miniProfileValue.hashCode();; i = 0)
    {
      if (guestContactValue != null) {
        j = guestContactValue.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Entity");
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
    label298:
    label323:
    label331:
    label333:
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
        localByteBuffer.putInt(161958986);
        if (hasMiniProfileValue)
        {
          localByteBuffer.put((byte)1);
          if (miniProfileValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfileValue._cachedId);
            miniProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasGuestContactValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (guestContactValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, guestContactValue._cachedId);
            guestContactValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label331;
          }
          if (str != null) {
            break label333;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniProfileValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          guestContactValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow.Entity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */