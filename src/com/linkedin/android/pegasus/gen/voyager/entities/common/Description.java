package com.linkedin.android.pegasus.gen.voyager.entities.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Description
  implements FissileDataModel<Description>, RecordTemplate<Description>
{
  public static final DescriptionBuilder BUILDER = DescriptionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final AttributedText attributedText;
  public final boolean hasAttributedText;
  public final boolean hasText;
  public final String text;
  
  Description(String paramString, AttributedText paramAttributedText, boolean paramBoolean1, boolean paramBoolean2)
  {
    text = paramString;
    attributedText = paramAttributedText;
    hasText = paramBoolean1;
    hasAttributedText = paramBoolean2;
    _cachedId = null;
  }
  
  public final Description accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      paramDataProcessor.processString(text);
    }
    AttributedText localAttributedText = null;
    boolean bool = false;
    if (hasAttributedText)
    {
      paramDataProcessor.startRecordField$505cff1c("attributedText");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localAttributedText = attributedText.accept(paramDataProcessor);
      if (localAttributedText == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label158;
      }
      try
      {
        if (hasText) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.Description", "text");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localAttributedText = (AttributedText)paramDataProcessor.processDataTemplate(attributedText);
      break;
    }
    label140:
    return new Description(text, localAttributedText, hasText, bool);
    label158:
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
      paramObject = (Description)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (attributedText == null) {
        break;
      }
    } while (attributedText.equals(attributedText));
    for (;;)
    {
      return false;
      if (attributedText == null) {
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
    if (hasAttributedText)
    {
      i = j + 1;
      if (attributedText._cachedId == null) {
        break label87;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedText._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label87:
      i += attributedText.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (text != null) {}
    for (int i = text.hashCode();; i = 0)
    {
      if (attributedText != null) {
        j = attributedText.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Description");
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
    label239:
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
        localByteBuffer.putInt(-1627210761);
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, text);
          if (!hasAttributedText) {
            break label264;
          }
          localByteBuffer.put((byte)1);
          if (attributedText._cachedId == null) {
            break label239;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
          attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          attributedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.Description
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */