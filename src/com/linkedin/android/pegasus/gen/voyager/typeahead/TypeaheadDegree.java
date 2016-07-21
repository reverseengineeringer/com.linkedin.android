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

public final class TypeaheadDegree
  implements FissileDataModel<TypeaheadDegree>, RecordTemplate<TypeaheadDegree>
{
  public static final TypeaheadDegreeBuilder BUILDER = TypeaheadDegreeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final Urn degreeUrn;
  public final boolean hasBackendUrn;
  public final boolean hasDegreeUrn;
  public final boolean hasId;
  public final String id;
  
  TypeaheadDegree(String paramString, Urn paramUrn1, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    id = paramString;
    backendUrn = paramUrn1;
    degreeUrn = paramUrn2;
    hasId = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    hasDegreeUrn = paramBoolean3;
    _cachedId = null;
  }
  
  public final TypeaheadDegree accept(DataProcessor paramDataProcessor)
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
    if (hasDegreeUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("degreeUrn");
      localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(degreeUrn));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasId) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadDegree", "id");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasBackendUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadDegree", "backendUrn");
      }
      if (!hasDegreeUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadDegree", "degreeUrn");
      }
      return new TypeaheadDegree(id, backendUrn, degreeUrn, hasId, hasBackendUrn, hasDegreeUrn);
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
      paramObject = (TypeaheadDegree)paramObject;
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
      if (degreeUrn == null) {
        break;
      }
    } while (degreeUrn.equals(degreeUrn));
    for (;;)
    {
      return false;
      if (degreeUrn == null) {
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
    if (hasDegreeUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(degreeUrn));
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
      if (degreeUrn != null) {
        k = degreeUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TypeaheadDegree");
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
        localByteBuffer.putInt(1458975120);
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
          if (!hasDegreeUrn) {
            break label257;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(degreeUrn));
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadDegree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */