package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedRecipient
  implements FissileDataModel<SuggestedRecipient>, RecordTemplate<SuggestedRecipient>
{
  public static final SuggestedRecipientBuilder BUILDER = SuggestedRecipientBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasLastMessagedAt;
  public final boolean hasSubtext;
  public final boolean hasSuggestedRecipientProfile;
  public final boolean hasText;
  public final long lastMessagedAt;
  public final String subtext;
  public final SuggestedRecipientProfile suggestedRecipientProfile;
  public final String text;
  
  SuggestedRecipient(String paramString1, String paramString2, long paramLong, SuggestedRecipientProfile paramSuggestedRecipientProfile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    text = paramString1;
    subtext = paramString2;
    lastMessagedAt = paramLong;
    suggestedRecipientProfile = paramSuggestedRecipientProfile;
    hasText = paramBoolean1;
    hasSubtext = paramBoolean2;
    hasLastMessagedAt = paramBoolean3;
    hasSuggestedRecipientProfile = paramBoolean4;
    _cachedId = null;
  }
  
  public final SuggestedRecipient accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      paramDataProcessor.processString(text);
    }
    if (hasSubtext)
    {
      paramDataProcessor.startRecordField$505cff1c("subtext");
      paramDataProcessor.processString(subtext);
    }
    if (hasLastMessagedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("lastMessagedAt");
      paramDataProcessor.processLong(lastMessagedAt);
    }
    SuggestedRecipientProfile localSuggestedRecipientProfile = null;
    boolean bool = false;
    if (hasSuggestedRecipientProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("suggestedRecipientProfile");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label168;
      }
      localSuggestedRecipientProfile = suggestedRecipientProfile.accept(paramDataProcessor);
      if (localSuggestedRecipientProfile == null) {
        break label185;
      }
    }
    label168:
    label185:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label243;
      }
      try
      {
        if (hasText) {
          break label190;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipient", "text");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localSuggestedRecipientProfile = (SuggestedRecipientProfile)paramDataProcessor.processDataTemplate(suggestedRecipientProfile);
      break;
    }
    label190:
    if (!hasSuggestedRecipientProfile) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipient", "suggestedRecipientProfile");
    }
    return new SuggestedRecipient(text, subtext, lastMessagedAt, localSuggestedRecipientProfile, hasText, hasSubtext, hasLastMessagedAt, bool);
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
      paramObject = (SuggestedRecipient)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (subtext != null)
      {
        if (subtext.equals(subtext)) {}
      }
      else {
        while (subtext != null) {
          return false;
        }
      }
      if (lastMessagedAt != lastMessagedAt) {
        return false;
      }
      if (suggestedRecipientProfile == null) {
        break;
      }
    } while (suggestedRecipientProfile.equals(suggestedRecipientProfile));
    for (;;)
    {
      return false;
      if (suggestedRecipientProfile == null) {
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
    if (hasText) {
      i = PegasusBinaryUtils.getEncodedLength(text) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSubtext) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(subtext);
    }
    j = i + 1;
    i = j;
    if (hasLastMessagedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasSuggestedRecipientProfile)
    {
      i = j + 1;
      if (suggestedRecipientProfile._cachedId == null) {
        break label130;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(suggestedRecipientProfile._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label130:
      i += suggestedRecipientProfile.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (text != null)
    {
      i = text.hashCode();
      if (subtext == null) {
        break label108;
      }
    }
    label108:
    for (int j = subtext.hashCode();; j = 0)
    {
      int m = (int)(lastMessagedAt ^ lastMessagedAt >>> 32);
      if (suggestedRecipientProfile != null) {
        k = suggestedRecipientProfile.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedRecipient");
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
    label162:
    label186:
    label289:
    label299:
    label309:
    label334:
    label342:
    label344:
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
        localByteBuffer.putInt(-1355924287);
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, text);
          if (!hasSubtext) {
            break label289;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, subtext);
          if (!hasLastMessagedAt) {
            break label299;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(lastMessagedAt);
          if (!hasSuggestedRecipientProfile) {
            break label334;
          }
          localByteBuffer.put((byte)1);
          if (suggestedRecipientProfile._cachedId == null) {
            break label309;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, suggestedRecipientProfile._cachedId);
          suggestedRecipientProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label342;
          }
          if (str != null) {
            break label344;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label186;
          localByteBuffer.put((byte)1);
          suggestedRecipientProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */