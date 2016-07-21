package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedEditCard
  implements FissileDataModel<SuggestedEditCard>, RecordTemplate<SuggestedEditCard>
{
  public static final SuggestedEditCardBuilder BUILDER = SuggestedEditCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final boolean hasSuggestion;
  public final long publishedAt;
  public final boolean read;
  public final Suggestion suggestion;
  
  SuggestedEditCard(long paramLong, boolean paramBoolean1, Suggestion paramSuggestion, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    publishedAt = paramLong;
    read = paramBoolean1;
    suggestion = paramSuggestion;
    hasPublishedAt = paramBoolean2;
    hasRead = paramBoolean3;
    hasSuggestion = paramBoolean4;
    _cachedId = null;
  }
  
  public final SuggestedEditCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    if (hasRead)
    {
      paramDataProcessor.startRecordField$505cff1c("read");
      paramDataProcessor.processBoolean(read);
    }
    Suggestion localSuggestion = null;
    boolean bool = false;
    if (hasSuggestion)
    {
      paramDataProcessor.startRecordField$505cff1c("suggestion");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localSuggestion = suggestion.accept(paramDataProcessor);
      if (localSuggestion == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label229;
      }
      try
      {
        if (hasPublishedAt) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localSuggestion = (Suggestion)paramDataProcessor.processDataTemplate(suggestion);
      break;
    }
    label165:
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard", "read");
    }
    if (!hasSuggestion) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard", "suggestion");
    }
    return new SuggestedEditCard(publishedAt, read, localSuggestion, hasPublishedAt, hasRead, bool);
    label229:
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
      paramObject = (SuggestedEditCard)paramObject;
      if (publishedAt != publishedAt) {
        return false;
      }
      if (read != read) {
        return false;
      }
      if (suggestion == null) {
        break;
      }
    } while (suggestion.equals(suggestion));
    for (;;)
    {
      return false;
      if (suggestion == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasPublishedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasRead) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasSuggestion)
    {
      i = j + 1;
      if (suggestion._cachedId == null) {
        break label100;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(suggestion._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label100:
      i += suggestion.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int k = (int)(publishedAt ^ publishedAt >>> 32);
    if (read) {}
    for (int i = 1;; i = 0)
    {
      if (suggestion != null) {
        j = suggestion.hashCode();
      }
      i = (i + (k + 527) * 31) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedEditCard");
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
    label158:
    label167:
    label270:
    label276:
    label286:
    label311:
    label319:
    label321:
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
        localByteBuffer.putInt(-1638878889);
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasRead) {
            break label276;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label270;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasSuggestion) {
            break label311;
          }
          localByteBuffer.put((byte)1);
          if (suggestion._cachedId == null) {
            break label286;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, suggestion._cachedId);
          suggestion.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label319;
          }
          if (str != null) {
            break label321;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label158;
          localByteBuffer.put((byte)0);
          break label167;
          localByteBuffer.put((byte)1);
          suggestion.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<SuggestedEditCard>
  {
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private boolean hasSuggestion = false;
    private long publishedAt = 0L;
    public boolean read = false;
    private Suggestion suggestion = null;
    
    public Builder() {}
    
    public Builder(SuggestedEditCard paramSuggestedEditCard)
    {
      publishedAt = publishedAt;
      read = read;
      suggestion = suggestion;
      hasPublishedAt = hasPublishedAt;
      hasRead = hasRead;
      hasSuggestion = hasSuggestion;
    }
    
    public final SuggestedEditCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SuggestedEditCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SuggestedEditCard(publishedAt, read, suggestion, hasPublishedAt, hasRead, hasSuggestion);
        if (!hasPublishedAt) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard", "publishedAt");
        }
        if (!hasRead) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard", "read");
        }
      } while (hasSuggestion);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard", "suggestion");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */