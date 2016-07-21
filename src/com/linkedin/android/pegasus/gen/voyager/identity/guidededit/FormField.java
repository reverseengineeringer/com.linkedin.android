package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class FormField
  implements FissileDataModel<FormField>, RecordTemplate<FormField>
{
  public static final FormFieldBuilder BUILDER = FormFieldBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final FieldNames fieldName;
  public final boolean hasFieldName;
  public final boolean hasPrefillValues;
  public final List<PrefillValues> prefillValues;
  
  FormField(FieldNames paramFieldNames, List<PrefillValues> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    fieldName = paramFieldNames;
    if (paramList == null) {}
    for (paramFieldNames = null;; paramFieldNames = Collections.unmodifiableList(paramList))
    {
      prefillValues = paramFieldNames;
      hasFieldName = paramBoolean1;
      hasPrefillValues = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final FormField accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFieldName)
    {
      paramDataProcessor.startRecordField$505cff1c("fieldName");
      paramDataProcessor.processEnum(fieldName);
    }
    Object localObject = null;
    PrefillValues localPrefillValues = null;
    boolean bool = false;
    if (hasPrefillValues)
    {
      paramDataProcessor.startRecordField$505cff1c("prefillValues");
      prefillValues.size();
      paramDataProcessor.startArray$13462e();
      localObject = localPrefillValues;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = prefillValues.iterator();
      if (localIterator.hasNext())
      {
        localPrefillValues = (PrefillValues)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localPrefillValues = localPrefillValues.accept(paramDataProcessor);; localPrefillValues = (PrefillValues)paramDataProcessor.processDataTemplate(localPrefillValues))
        {
          if ((localObject != null) && (localPrefillValues != null)) {
            ((List)localObject).add(localPrefillValues);
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
        if (hasFieldName) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.FormField", "fieldName");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (prefillValues != null)
    {
      paramDataProcessor = prefillValues.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PrefillValues)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.FormField", "prefillValues");
        }
      }
    }
    return new FormField(fieldName, (List)localObject, hasFieldName, bool);
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
      paramObject = (FormField)paramObject;
      if (fieldName != null)
      {
        if (fieldName.equals(fieldName)) {}
      }
      else {
        while (fieldName != null) {
          return false;
        }
      }
      if (prefillValues == null) {
        break;
      }
    } while (prefillValues.equals(prefillValues));
    for (;;)
    {
      return false;
      if (prefillValues == null) {
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
    if (hasFieldName) {
      i = j + 2;
    }
    i += 1;
    j = i;
    if (hasPrefillValues)
    {
      i += 2;
      Iterator localIterator = prefillValues.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        PrefillValues localPrefillValues = (PrefillValues)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localPrefillValues.getSerializedSize();
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
    if (fieldName != null) {}
    for (int i = fieldName.hashCode();; i = 0)
    {
      if (prefillValues != null) {
        j = prefillValues.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FormField");
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
    label286:
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
        localByteBuffer.putInt(1590366252);
        Iterator localIterator;
        if (hasFieldName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, fieldName.ordinal());
          if (hasPrefillValues)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, prefillValues.size());
            localIterator = prefillValues.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label286;
            }
            PrefillValues localPrefillValues = (PrefillValues)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localPrefillValues.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localPrefillValues.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class PrefillValues
    implements FissileDataModel<PrefillValues>, UnionTemplate<PrefillValues>
  {
    public static final FormFieldBuilder.PrefillValuesBuilder BUILDER = FormFieldBuilder.PrefillValuesBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasIndustryValue;
    public final Industry industryValue;
    
    PrefillValues(Industry paramIndustry, boolean paramBoolean)
    {
      industryValue = paramIndustry;
      hasIndustryValue = paramBoolean;
      _cachedId = null;
    }
    
    public final PrefillValues accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Industry localIndustry = null;
      boolean bool = false;
      if (hasIndustryValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.Industry");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label74;
        }
        localIndustry = industryValue.accept(paramDataProcessor);
        if (localIndustry == null) {
          break label91;
        }
      }
      label74:
      label91:
      for (bool = true;; bool = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label96;
        }
        return new PrefillValues(localIndustry, bool);
        localIndustry = (Industry)paramDataProcessor.processDataTemplate(industryValue);
        break;
      }
      label96:
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
        paramObject = (PrefillValues)paramObject;
        if (industryValue == null) {
          break;
        }
      } while (industryValue.equals(industryValue));
      for (;;)
      {
        return false;
        if (industryValue == null) {
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
      if (hasIndustryValue) {
        if (industryValue._cachedId == null) {
          break label58;
        }
      }
      label58:
      for (i = PegasusBinaryUtils.getEncodedLength(industryValue._cachedId) + 9;; i = industryValue.getSerializedSize() + 7)
      {
        __sizeOfObject = i;
        return i;
      }
    }
    
    public final int hashCode()
    {
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (industryValue != null) {}
      for (int i = industryValue.hashCode();; i = 0)
      {
        i += 527;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PrefillValues");
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
      label238:
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
          localByteBuffer.putInt(244442555);
          if (hasIndustryValue)
          {
            localByteBuffer.put((byte)1);
            if (industryValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, industryValue._cachedId);
              industryValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          while (paramByteBuffer == null)
          {
            if (str != null) {
              break label238;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            industryValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.FormField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */