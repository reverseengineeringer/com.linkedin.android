package com.linkedin.android.pegasus.gen.voyager.messaging.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.messaging.Conversation;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ThreadTypeaheadResult
  implements FissileDataModel<ThreadTypeaheadResult>, RecordTemplate<ThreadTypeaheadResult>
{
  public static final ThreadTypeaheadResultBuilder BUILDER = ThreadTypeaheadResultBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Conversation conversation;
  public final boolean hasConversation;
  public final boolean hasSubtext;
  public final String subtext;
  
  ThreadTypeaheadResult(Conversation paramConversation, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    conversation = paramConversation;
    subtext = paramString;
    hasConversation = paramBoolean1;
    hasSubtext = paramBoolean2;
    _cachedId = null;
  }
  
  public final ThreadTypeaheadResult accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Conversation localConversation = null;
    boolean bool = false;
    if (hasConversation)
    {
      paramDataProcessor.startRecordField$505cff1c("conversation");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localConversation = conversation.accept(paramDataProcessor);
      if (localConversation == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      if (hasSubtext)
      {
        paramDataProcessor.startRecordField$505cff1c("subtext");
        paramDataProcessor.processString(subtext);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label177;
      }
      try
      {
        if (hasConversation) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.typeahead.ThreadTypeaheadResult", "conversation");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localConversation = (Conversation)paramDataProcessor.processDataTemplate(conversation);
      break;
    }
    label140:
    if (!hasSubtext) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.typeahead.ThreadTypeaheadResult", "subtext");
    }
    return new ThreadTypeaheadResult(localConversation, subtext, bool, hasSubtext);
    label177:
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
      paramObject = (ThreadTypeaheadResult)paramObject;
      if (conversation != null)
      {
        if (conversation.equals(conversation)) {}
      }
      else {
        while (conversation != null) {
          return false;
        }
      }
      if (subtext == null) {
        break;
      }
    } while (subtext.equals(subtext));
    for (;;)
    {
      return false;
      if (subtext == null) {
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
    if (hasConversation) {
      if (conversation._cachedId == null) {
        break label83;
      }
    }
    label83:
    for (i = PegasusBinaryUtils.getEncodedLength(conversation._cachedId) + 9;; i = conversation.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasSubtext) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(subtext);
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (conversation != null) {}
    for (int i = conversation.hashCode();; i = 0)
    {
      if (subtext != null) {
        j = subtext.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ThreadTypeaheadResult");
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
    label264:
    label272:
    label274:
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
        localByteBuffer.putInt(-732665802);
        if (hasConversation)
        {
          localByteBuffer.put((byte)1);
          if (conversation._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, conversation._cachedId);
            conversation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSubtext) {
              break label264;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, subtext);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label272;
          }
          if (str != null) {
            break label274;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          conversation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.typeahead.ThreadTypeaheadResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */