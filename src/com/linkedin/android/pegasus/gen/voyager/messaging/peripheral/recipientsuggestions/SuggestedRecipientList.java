package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
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

public final class SuggestedRecipientList
  implements FissileDataModel<SuggestedRecipientList>, RecordTemplate<SuggestedRecipientList>
{
  public static final SuggestedRecipientListBuilder BUILDER = SuggestedRecipientListBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasSuggestedRecipients;
  public final boolean hasTitle;
  public final List<SuggestedRecipient> suggestedRecipients;
  public final String title;
  
  SuggestedRecipientList(String paramString, List<SuggestedRecipient> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    title = paramString;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      suggestedRecipients = paramString;
      hasTitle = paramBoolean1;
      hasSuggestedRecipients = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  private SuggestedRecipientList accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    Object localObject = null;
    SuggestedRecipient localSuggestedRecipient = null;
    boolean bool = false;
    if (hasSuggestedRecipients)
    {
      paramDataProcessor.startRecordField$505cff1c("suggestedRecipients");
      suggestedRecipients.size();
      paramDataProcessor.startArray$13462e();
      localObject = localSuggestedRecipient;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = suggestedRecipients.iterator();
      if (localIterator.hasNext())
      {
        localSuggestedRecipient = (SuggestedRecipient)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localSuggestedRecipient = localSuggestedRecipient.accept(paramDataProcessor);; localSuggestedRecipient = (SuggestedRecipient)paramDataProcessor.processDataTemplate(localSuggestedRecipient))
        {
          if ((localObject != null) && (localSuggestedRecipient != null)) {
            ((List)localObject).add(localSuggestedRecipient);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label251;
      }
    }
    label251:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label325;
      }
      try
      {
        if (hasSuggestedRecipients) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientList", "suggestedRecipients");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (suggestedRecipients != null)
    {
      paramDataProcessor = suggestedRecipients.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SuggestedRecipient)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientList", "suggestedRecipients");
        }
      }
    }
    return new SuggestedRecipientList(title, (List)localObject, hasTitle, bool);
    label325:
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
      paramObject = (SuggestedRecipientList)paramObject;
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (suggestedRecipients == null) {
        break;
      }
    } while (suggestedRecipients.equals(suggestedRecipients));
    for (;;)
    {
      return false;
      if (suggestedRecipients == null) {
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
    if (hasTitle) {
      i = PegasusBinaryUtils.getEncodedLength(title) + 8;
    }
    i += 1;
    int j = i;
    if (hasSuggestedRecipients)
    {
      i += 2;
      Iterator localIterator = suggestedRecipients.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        SuggestedRecipient localSuggestedRecipient = (SuggestedRecipient)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localSuggestedRecipient.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (title != null) {}
    for (int i = title.hashCode();; i = 0)
    {
      if (suggestedRecipients != null) {
        j = suggestedRecipients.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedRecipientList");
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
    label283:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(883181430);
        Iterator localIterator;
        if (hasTitle)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (hasSuggestedRecipients)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, suggestedRecipients.size());
            localIterator = suggestedRecipients.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label283;
            }
            SuggestedRecipient localSuggestedRecipient = (SuggestedRecipient)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localSuggestedRecipient.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localSuggestedRecipient.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */