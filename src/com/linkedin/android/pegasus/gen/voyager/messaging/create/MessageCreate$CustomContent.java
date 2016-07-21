package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.ShareCreate;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MessageCreate$CustomContent
  implements FissileDataModel<CustomContent>, UnionTemplate<CustomContent>
{
  public static final MessageCreateBuilder.CustomContentBuilder BUILDER = MessageCreateBuilder.CustomContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasInmailContentCreateValue;
  public final boolean hasMiniGroupUrnValue;
  public final boolean hasShareCreateValue;
  public final InmailContentCreate inmailContentCreateValue;
  public final Urn miniGroupUrnValue;
  public final ShareCreate shareCreateValue;
  
  MessageCreate$CustomContent(InmailContentCreate paramInmailContentCreate, ShareCreate paramShareCreate, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    inmailContentCreateValue = paramInmailContentCreate;
    shareCreateValue = paramShareCreate;
    miniGroupUrnValue = paramUrn;
    hasInmailContentCreateValue = paramBoolean1;
    hasShareCreateValue = paramBoolean2;
    hasMiniGroupUrnValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final CustomContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasInmailContentCreateValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.create.message.InmailContentCreate");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = inmailContentCreateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label190;
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
      if (hasShareCreateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.create.message.ShareCreate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label199;
        }
        localObject1 = shareCreateValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label217;
        }
      }
    }
    label190:
    label199:
    label217:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasMiniGroupUrnValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("string");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(miniGroupUrnValue));
      }
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label222;
      }
      return new CustomContent((InmailContentCreate)localObject2, (ShareCreate)localObject1, miniGroupUrnValue, bool1, bool2, hasMiniGroupUrnValue);
      localObject1 = (InmailContentCreate)paramDataProcessor.processDataTemplate(inmailContentCreateValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (ShareCreate)paramDataProcessor.processDataTemplate(shareCreateValue);
      break label95;
    }
    label222:
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
      paramObject = (CustomContent)paramObject;
      if (inmailContentCreateValue != null)
      {
        if (inmailContentCreateValue.equals(inmailContentCreateValue)) {}
      }
      else {
        while (inmailContentCreateValue != null) {
          return false;
        }
      }
      if (shareCreateValue != null)
      {
        if (shareCreateValue.equals(shareCreateValue)) {}
      }
      else {
        while (shareCreateValue != null) {
          return false;
        }
      }
      if (miniGroupUrnValue == null) {
        break;
      }
    } while (miniGroupUrnValue.equals(miniGroupUrnValue));
    for (;;)
    {
      return false;
      if (miniGroupUrnValue == null) {
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
    if (hasInmailContentCreateValue)
    {
      if (inmailContentCreateValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(inmailContentCreateValue._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasShareCreateValue)
      {
        i = j + 1;
        if (shareCreateValue._cachedId == null) {
          break label146;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareCreateValue._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasMiniGroupUrnValue)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(miniGroupUrnValue));
      }
      __sizeOfObject = i;
      return i;
      i = inmailContentCreateValue.getSerializedSize() + 7;
      break;
      label146:
      i += shareCreateValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (inmailContentCreateValue != null)
    {
      i = inmailContentCreateValue.hashCode();
      if (shareCreateValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = shareCreateValue.hashCode();; j = 0)
    {
      if (miniGroupUrnValue != null) {
        k = miniGroupUrnValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CustomContent");
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
    label332:
    label357:
    label367:
    label375:
    label377:
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
        localByteBuffer.putInt(-535643681);
        if (hasInmailContentCreateValue)
        {
          localByteBuffer.put((byte)1);
          if (inmailContentCreateValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, inmailContentCreateValue._cachedId);
            inmailContentCreateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareCreateValue) {
              break label357;
            }
            localByteBuffer.put((byte)1);
            if (shareCreateValue._cachedId == null) {
              break label332;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareCreateValue._cachedId);
            shareCreateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMiniGroupUrnValue) {
              break label367;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(miniGroupUrnValue));
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label375;
          }
          if (str != null) {
            break label377;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          inmailContentCreateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          shareCreateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
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
  
  public static final class Builder
  {
    public boolean hasInmailContentCreateValue = false;
    public boolean hasMiniGroupUrnValue = false;
    public boolean hasShareCreateValue = false;
    public InmailContentCreate inmailContentCreateValue = null;
    public Urn miniGroupUrnValue = null;
    public ShareCreate shareCreateValue = null;
    
    public final MessageCreate.CustomContent build()
      throws BuilderException
    {
      int j = 0;
      if (hasInmailContentCreateValue) {
        j = 0 + 1;
      }
      int i = j;
      if (hasShareCreateValue) {
        i = j + 1;
      }
      j = i;
      if (hasMiniGroupUrnValue) {
        j = i + 1;
      }
      if (j > 1) {
        throw new UnionMemberCountException("CustomContent", j);
      }
      return new MessageCreate.CustomContent(inmailContentCreateValue, shareCreateValue, miniGroupUrnValue, hasInmailContentCreateValue, hasShareCreateValue, hasMiniGroupUrnValue);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate.CustomContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */