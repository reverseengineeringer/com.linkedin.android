package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect;

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

public final class ReconnectionSuggestions
  implements FissileDataModel<ReconnectionSuggestions>, RecordTemplate<ReconnectionSuggestions>
{
  public static final ReconnectionSuggestionsBuilder BUILDER = ReconnectionSuggestionsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasLegoTrackingToken;
  public final boolean hasSuggestions;
  public final String legoTrackingToken;
  public final List<ReconnectionSuggestion> suggestions;
  
  ReconnectionSuggestions(List<ReconnectionSuggestion> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      suggestions = paramList;
      legoTrackingToken = paramString;
      hasSuggestions = paramBoolean1;
      hasLegoTrackingToken = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  private ReconnectionSuggestions accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    ReconnectionSuggestion localReconnectionSuggestion = null;
    boolean bool = false;
    if (hasSuggestions)
    {
      paramDataProcessor.startRecordField$505cff1c("suggestions");
      suggestions.size();
      paramDataProcessor.startArray$13462e();
      localObject = localReconnectionSuggestion;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = suggestions.iterator();
      if (localIterator.hasNext())
      {
        localReconnectionSuggestion = (ReconnectionSuggestion)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localReconnectionSuggestion = localReconnectionSuggestion.accept(paramDataProcessor);; localReconnectionSuggestion = (ReconnectionSuggestion)paramDataProcessor.processDataTemplate(localReconnectionSuggestion))
        {
          if ((localObject != null) && (localReconnectionSuggestion != null)) {
            ((List)localObject).add(localReconnectionSuggestion);
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
      if (hasLegoTrackingToken)
      {
        paramDataProcessor.startRecordField$505cff1c("legoTrackingToken");
        paramDataProcessor.processString(legoTrackingToken);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label344;
      }
      try
      {
        if (hasSuggestions) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestions", "suggestions");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasLegoTrackingToken) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestions", "legoTrackingToken");
    }
    if (suggestions != null)
    {
      paramDataProcessor = suggestions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ReconnectionSuggestion)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestions", "suggestions");
        }
      }
    }
    return new ReconnectionSuggestions((List)localObject, legoTrackingToken, bool, hasLegoTrackingToken);
    label344:
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
      paramObject = (ReconnectionSuggestions)paramObject;
      if (suggestions != null)
      {
        if (suggestions.equals(suggestions)) {}
      }
      else {
        while (suggestions != null) {
          return false;
        }
      }
      if (legoTrackingToken == null) {
        break;
      }
    } while (legoTrackingToken.equals(legoTrackingToken));
    for (;;)
    {
      return false;
      if (legoTrackingToken == null) {
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
    if (hasSuggestions)
    {
      i += 2;
      Iterator localIterator = suggestions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        ReconnectionSuggestion localReconnectionSuggestion = (ReconnectionSuggestion)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localReconnectionSuggestion.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasLegoTrackingToken) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(legoTrackingToken);
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
    if (suggestions != null) {}
    for (int i = suggestions.hashCode();; i = 0)
    {
      if (legoTrackingToken != null) {
        j = legoTrackingToken.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ReconnectionSuggestions");
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
    label316:
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
        localByteBuffer.putInt(-234305213);
        if (hasSuggestions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, suggestions.size());
          Iterator localIterator = suggestions.iterator();
          while (localIterator.hasNext())
          {
            ReconnectionSuggestion localReconnectionSuggestion = (ReconnectionSuggestion)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localReconnectionSuggestion.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localReconnectionSuggestion.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasLegoTrackingToken)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label316;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */