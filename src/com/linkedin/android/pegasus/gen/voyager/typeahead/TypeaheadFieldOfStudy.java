package com.linkedin.android.pegasus.gen.voyager.typeahead;

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
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TypeaheadFieldOfStudy
  implements FissileDataModel<TypeaheadFieldOfStudy>, RecordTemplate<TypeaheadFieldOfStudy>
{
  public static final TypeaheadFieldOfStudyBuilder BUILDER = TypeaheadFieldOfStudyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final Urn fieldOfStudyUrn;
  public final boolean hasBackendUrn;
  public final boolean hasFieldOfStudyUrn;
  public final boolean hasId;
  public final String id;
  
  TypeaheadFieldOfStudy(String paramString, Urn paramUrn1, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    id = paramString;
    backendUrn = paramUrn1;
    fieldOfStudyUrn = paramUrn2;
    hasId = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    hasFieldOfStudyUrn = paramBoolean3;
    _cachedId = null;
  }
  
  public final TypeaheadFieldOfStudy accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processString(id);
    }
    UrnCoercer localUrnCoercer;
    if (hasBackendUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("backendUrn");
      localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    if (hasFieldOfStudyUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("fieldOfStudyUrn");
      localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(fieldOfStudyUrn));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasId) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy", "id");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasBackendUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy", "backendUrn");
      }
      if (!hasFieldOfStudyUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy", "fieldOfStudyUrn");
      }
      return new TypeaheadFieldOfStudy(id, backendUrn, fieldOfStudyUrn, hasId, hasBackendUrn, hasFieldOfStudyUrn);
    }
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
      paramObject = (TypeaheadFieldOfStudy)paramObject;
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (backendUrn != null)
      {
        if (backendUrn.equals(backendUrn)) {}
      }
      else {
        while (backendUrn != null) {
          return false;
        }
      }
      if (fieldOfStudyUrn == null) {
        break;
      }
    } while (fieldOfStudyUrn.equals(fieldOfStudyUrn));
    for (;;)
    {
      return false;
      if (fieldOfStudyUrn == null) {
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
    if (hasId) {
      i = PegasusBinaryUtils.getEncodedLength(id) + 8;
    }
    int j = i + 1;
    i = j;
    UrnCoercer localUrnCoercer;
    if (hasBackendUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    j = i + 1;
    i = j;
    if (hasFieldOfStudyUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(fieldOfStudyUrn));
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (id != null)
    {
      i = id.hashCode();
      if (backendUrn == null) {
        break label87;
      }
    }
    label87:
    for (int j = backendUrn.hashCode();; j = 0)
    {
      if (fieldOfStudyUrn != null) {
        k = fieldOfStudyUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TypeaheadFieldOfStudy");
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
    label170:
    label247:
    label257:
    label265:
    label267:
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
        localByteBuffer.putInt(-1229314091);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasBackendUrn) {
            break label247;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasFieldOfStudyUrn) {
            break label257;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(fieldOfStudyUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label265;
          }
          if (str != null) {
            break label267;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */