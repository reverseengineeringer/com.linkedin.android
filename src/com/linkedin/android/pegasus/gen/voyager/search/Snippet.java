package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Snippet
  implements FissileDataModel<Snippet>, RecordTemplate<Snippet>
{
  public static final SnippetBuilder BUILDER = SnippetBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AnnotatedText body;
  public final SnippetField fieldType;
  public final boolean hasBody;
  public final boolean hasFieldType;
  public final boolean hasHeading;
  public final AnnotatedText heading;
  
  Snippet(SnippetField paramSnippetField, AnnotatedText paramAnnotatedText1, AnnotatedText paramAnnotatedText2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    fieldType = paramSnippetField;
    heading = paramAnnotatedText1;
    body = paramAnnotatedText2;
    hasFieldType = paramBoolean1;
    hasHeading = paramBoolean2;
    hasBody = paramBoolean3;
    _cachedId = null;
  }
  
  public final Snippet accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFieldType)
    {
      paramDataProcessor.startRecordField$505cff1c("fieldType");
      paramDataProcessor.processEnum(fieldType);
    }
    Object localObject = null;
    boolean bool1 = false;
    AnnotatedText localAnnotatedText;
    if (hasHeading)
    {
      paramDataProcessor.startRecordField$505cff1c("heading");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localAnnotatedText = heading.accept(paramDataProcessor);
        if (localAnnotatedText == null) {
          break label189;
        }
        bool1 = true;
        localObject = localAnnotatedText;
      }
    }
    else
    {
      label81:
      localAnnotatedText = null;
      bool2 = false;
      if (hasBody)
      {
        paramDataProcessor.startRecordField$505cff1c("body");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label198;
        }
        localAnnotatedText = body.accept(paramDataProcessor);
        label120:
        if (localAnnotatedText == null) {
          break label216;
        }
      }
    }
    label189:
    label198:
    label216:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label262;
      }
      try
      {
        if (hasFieldType) {
          break label221;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.Snippet", "fieldType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localAnnotatedText = (AnnotatedText)paramDataProcessor.processDataTemplate(heading);
      break;
      bool1 = false;
      localObject = localAnnotatedText;
      break label81;
      localAnnotatedText = (AnnotatedText)paramDataProcessor.processDataTemplate(body);
      break label120;
    }
    label221:
    if (!hasBody) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.Snippet", "body");
    }
    return new Snippet(fieldType, (AnnotatedText)localObject, localAnnotatedText, hasFieldType, bool1, bool2);
    label262:
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
      paramObject = (Snippet)paramObject;
      if (fieldType != null)
      {
        if (fieldType.equals(fieldType)) {}
      }
      else {
        while (fieldType != null) {
          return false;
        }
      }
      if (heading != null)
      {
        if (heading.equals(heading)) {}
      }
      else {
        while (heading != null) {
          return false;
        }
      }
      if (body == null) {
        break;
      }
    } while (body.equals(body));
    for (;;)
    {
      return false;
      if (body == null) {
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
    if (hasFieldType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasHeading)
    {
      i = j + 1;
      if (heading._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(heading._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasBody)
      {
        i = j + 1;
        if (body._cachedId == null) {
          break label137;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(body._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += heading.getSerializedSize();
      break;
      label137:
      i += body.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (fieldType != null)
    {
      i = fieldType.hashCode();
      if (heading == null) {
        break label87;
      }
    }
    label87:
    for (int j = heading.hashCode();; j = 0)
    {
      if (body != null) {
        k = body.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Snippet");
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
    label199:
    label302:
    label327:
    label337:
    label362:
    label370:
    label372:
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
        localByteBuffer.putInt(627946130);
        if (hasFieldType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, fieldType.ordinal());
          if (!hasHeading) {
            break label327;
          }
          localByteBuffer.put((byte)1);
          if (heading._cachedId == null) {
            break label302;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, heading._cachedId);
          heading.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasBody) {
            break label362;
          }
          localByteBuffer.put((byte)1);
          if (body._cachedId == null) {
            break label337;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, body._cachedId);
          body.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label370;
          }
          if (str != null) {
            break label372;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          heading.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label199;
          localByteBuffer.put((byte)0);
          break label199;
          localByteBuffer.put((byte)1);
          body.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.Snippet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */