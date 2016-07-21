package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MemberTopCard
  implements FissileDataModel<MemberTopCard>, RecordTemplate<MemberTopCard>
{
  public static final MemberTopCardBuilder BUILDER = MemberTopCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ContactInfo contactInfo;
  public final MemberDistance distance;
  public final boolean hasContactInfo;
  public final boolean hasDistance;
  public final boolean hasMessagingMember;
  public final MessagingMember messagingMember;
  
  MemberTopCard(MessagingMember paramMessagingMember, MemberDistance paramMemberDistance, ContactInfo paramContactInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    messagingMember = paramMessagingMember;
    distance = paramMemberDistance;
    contactInfo = paramContactInfo;
    hasMessagingMember = paramBoolean1;
    hasDistance = paramBoolean2;
    hasContactInfo = paramBoolean3;
    _cachedId = null;
  }
  
  public final MemberTopCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasMessagingMember)
    {
      paramDataProcessor.startRecordField$505cff1c("messagingMember");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = messagingMember.accept(paramDataProcessor);
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
      if (hasDistance)
      {
        paramDataProcessor.startRecordField$505cff1c("distance");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label225;
        }
        localObject1 = distance.accept(paramDataProcessor);
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
      if (hasContactInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("contactInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label252;
        }
        localObject1 = contactInfo.accept(paramDataProcessor);
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
        break label332;
      }
      try
      {
        if (hasMessagingMember) {
          break label276;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard", "messagingMember");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MessagingMember)paramDataProcessor.processDataTemplate(messagingMember);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (MemberDistance)paramDataProcessor.processDataTemplate(distance);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (ContactInfo)paramDataProcessor.processDataTemplate(contactInfo);
      break label146;
    }
    label276:
    if (!hasDistance) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard", "distance");
    }
    if (!hasContactInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard", "contactInfo");
    }
    return new MemberTopCard((MessagingMember)localObject2, (MemberDistance)localObject3, (ContactInfo)localObject1, bool1, bool2, bool3);
    label332:
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
      paramObject = (MemberTopCard)paramObject;
      if (messagingMember != null)
      {
        if (messagingMember.equals(messagingMember)) {}
      }
      else {
        while (messagingMember != null) {
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
      if (contactInfo == null) {
        break;
      }
    } while (contactInfo.equals(contactInfo));
    for (;;)
    {
      return false;
      if (contactInfo == null) {
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
    if (hasMessagingMember)
    {
      if (messagingMember._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(messagingMember._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasDistance)
      {
        i = j + 1;
        if (distance._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(distance._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasContactInfo)
      {
        i = j + 1;
        if (contactInfo._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(contactInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = messagingMember.getSerializedSize() + 7;
      break;
      label156:
      i += distance.getSerializedSize();
      break label93;
      label169:
      i += contactInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (messagingMember != null)
    {
      i = messagingMember.hashCode();
      if (distance == null) {
        break label87;
      }
    }
    label87:
    for (int j = distance.hashCode();; j = 0)
    {
      if (contactInfo != null) {
        k = contactInfo.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MemberTopCard");
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
        localByteBuffer.putInt(-1863635895);
        if (hasMessagingMember)
        {
          localByteBuffer.put((byte)1);
          if (messagingMember._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, messagingMember._cachedId);
            messagingMember.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDistance) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (distance._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, distance._cachedId);
            distance.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasContactInfo) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (contactInfo._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, contactInfo._cachedId);
            contactInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          messagingMember.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          distance.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          contactInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.MemberTopCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */