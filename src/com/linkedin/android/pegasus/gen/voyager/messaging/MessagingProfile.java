package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MessagingProfile
  implements FissileDataModel<MessagingProfile>, UnionTemplate<MessagingProfile>
{
  public static final MessagingProfileBuilder BUILDER = MessagingProfileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasMessagingCompanyValue;
  public final boolean hasMessagingMemberValue;
  public final MessagingCompany messagingCompanyValue;
  public final MessagingMember messagingMemberValue;
  
  MessagingProfile(MessagingMember paramMessagingMember, MessagingCompany paramMessagingCompany, boolean paramBoolean1, boolean paramBoolean2)
  {
    messagingMemberValue = paramMessagingMember;
    messagingCompanyValue = paramMessagingCompany;
    hasMessagingMemberValue = paramBoolean1;
    hasMessagingCompanyValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final MessagingProfile accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasMessagingMemberValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.MessagingMember");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = messagingMemberValue.accept(paramDataProcessor);
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
      if (hasMessagingCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.MessagingCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = messagingCompanyValue.accept(paramDataProcessor);
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
      return new MessagingProfile((MessagingMember)localObject2, (MessagingCompany)localObject1, bool1, bool2);
      localObject1 = (MessagingMember)paramDataProcessor.processDataTemplate(messagingMemberValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (MessagingCompany)paramDataProcessor.processDataTemplate(messagingCompanyValue);
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
      paramObject = (MessagingProfile)paramObject;
      if (messagingMemberValue != null)
      {
        if (messagingMemberValue.equals(messagingMemberValue)) {}
      }
      else {
        while (messagingMemberValue != null) {
          return false;
        }
      }
      if (messagingCompanyValue == null) {
        break;
      }
    } while (messagingCompanyValue.equals(messagingCompanyValue));
    for (;;)
    {
      return false;
      if (messagingCompanyValue == null) {
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
    if (hasMessagingMemberValue)
    {
      if (messagingMemberValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(messagingMemberValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasMessagingCompanyValue)
      {
        i = j + 1;
        if (messagingCompanyValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(messagingCompanyValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = messagingMemberValue.getSerializedSize() + 7;
      break;
      label114:
      i += messagingCompanyValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (messagingMemberValue != null) {}
    for (int i = messagingMemberValue.hashCode();; i = 0)
    {
      if (messagingCompanyValue != null) {
        j = messagingCompanyValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MessagingProfile");
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
        localByteBuffer.putInt(-2038104322);
        if (hasMessagingMemberValue)
        {
          localByteBuffer.put((byte)1);
          if (messagingMemberValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, messagingMemberValue._cachedId);
            messagingMemberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMessagingCompanyValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (messagingCompanyValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, messagingCompanyValue._cachedId);
            messagingCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          messagingMemberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          messagingCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.MessagingProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */