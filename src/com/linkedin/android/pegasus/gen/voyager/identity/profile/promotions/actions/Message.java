package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Message
  implements FissileDataModel<Message>, RecordTemplate<Message>
{
  public static final MessageBuilder BUILDER = MessageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasRecipients;
  public final boolean hasSuggestedMessage;
  public final List<Urn> recipients;
  public final String suggestedMessage;
  
  Message(List<Urn> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      recipients = paramList;
      suggestedMessage = paramString;
      hasRecipients = paramBoolean1;
      hasSuggestedMessage = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final Message accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    Iterator localIterator = null;
    boolean bool = false;
    if (hasRecipients)
    {
      paramDataProcessor.startRecordField$505cff1c("recipients");
      recipients.size();
      paramDataProcessor.startArray$13462e();
      localObject = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      localIterator = recipients.iterator();
      while (localIterator.hasNext())
      {
        Urn localUrn = (Urn)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(localUrn));
        if (localObject != null) {
          ((List)localObject).add(localUrn);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label229;
      }
    }
    label229:
    for (bool = true;; bool = false)
    {
      if (hasSuggestedMessage)
      {
        paramDataProcessor.startRecordField$505cff1c("suggestedMessage");
        paramDataProcessor.processString(suggestedMessage);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label303;
      }
      try
      {
        if (hasRecipients) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.Message", "recipients");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (recipients != null)
    {
      paramDataProcessor = recipients.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.Message", "recipients");
        }
      }
    }
    return new Message((List)localObject, suggestedMessage, bool, hasSuggestedMessage);
    label303:
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
      paramObject = (Message)paramObject;
      if (recipients != null)
      {
        if (recipients.equals(recipients)) {}
      }
      else {
        while (recipients != null) {
          return false;
        }
      }
      if (suggestedMessage == null) {
        break;
      }
    } while (suggestedMessage.equals(suggestedMessage));
    for (;;)
    {
      return false;
      if (suggestedMessage == null) {
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
    int j = i;
    if (hasRecipients)
    {
      i += 2;
      Iterator localIterator = recipients.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Urn localUrn = (Urn)localIterator.next();
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(localUrn));
      }
    }
    j += 1;
    i = j;
    if (hasSuggestedMessage) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(suggestedMessage);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (recipients != null) {}
    for (int i = recipients.hashCode();; i = 0)
    {
      if (suggestedMessage != null) {
        j = suggestedMessage.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Message");
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
    label271:
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
        localByteBuffer.putInt(-1416978342);
        if (hasRecipients)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, recipients.size());
          Iterator localIterator = recipients.iterator();
          while (localIterator.hasNext())
          {
            Urn localUrn = (Urn)localIterator.next();
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
          }
        }
        localByteBuffer.put((byte)0);
        if (hasSuggestedMessage)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, suggestedMessage);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label271;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */