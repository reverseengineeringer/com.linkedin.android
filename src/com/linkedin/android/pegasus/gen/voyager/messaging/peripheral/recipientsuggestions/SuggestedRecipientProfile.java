package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedRecipientProfile
  implements FissileDataModel<SuggestedRecipientProfile>, UnionTemplate<SuggestedRecipientProfile>
{
  public static final SuggestedRecipientProfileBuilder BUILDER = SuggestedRecipientProfileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasSuggestedMemberValue;
  public final SuggestedMember suggestedMemberValue;
  
  SuggestedRecipientProfile(SuggestedMember paramSuggestedMember, boolean paramBoolean)
  {
    suggestedMemberValue = paramSuggestedMember;
    hasSuggestedMemberValue = paramBoolean;
    _cachedId = null;
  }
  
  public final SuggestedRecipientProfile accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    SuggestedMember localSuggestedMember = null;
    boolean bool = false;
    if (hasSuggestedMemberValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.peripheral.recipientsuggestions.SuggestedMember");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label74;
      }
      localSuggestedMember = suggestedMemberValue.accept(paramDataProcessor);
      if (localSuggestedMember == null) {
        break label91;
      }
    }
    label74:
    label91:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label96;
      }
      return new SuggestedRecipientProfile(localSuggestedMember, bool);
      localSuggestedMember = (SuggestedMember)paramDataProcessor.processDataTemplate(suggestedMemberValue);
      break;
    }
    label96:
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
      paramObject = (SuggestedRecipientProfile)paramObject;
      if (suggestedMemberValue == null) {
        break;
      }
    } while (suggestedMemberValue.equals(suggestedMemberValue));
    for (;;)
    {
      return false;
      if (suggestedMemberValue == null) {
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
    if (hasSuggestedMemberValue) {
      if (suggestedMemberValue._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(suggestedMemberValue._cachedId) + 9;; i = suggestedMemberValue.getSerializedSize() + 7)
    {
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (suggestedMemberValue != null) {}
    for (int i = suggestedMemberValue.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedRecipientProfile");
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
    label238:
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
        localByteBuffer.putInt(735823485);
        if (hasSuggestedMemberValue)
        {
          localByteBuffer.put((byte)1);
          if (suggestedMemberValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, suggestedMemberValue._cachedId);
            suggestedMemberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label238;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          suggestedMemberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */