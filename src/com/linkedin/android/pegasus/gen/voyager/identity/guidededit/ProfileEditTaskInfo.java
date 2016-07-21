package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

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

public final class ProfileEditTaskInfo
  implements FissileDataModel<ProfileEditTaskInfo>, RecordTemplate<ProfileEditTaskInfo>
{
  public static final ProfileEditTaskInfoBuilder BUILDER = ProfileEditTaskInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<FormField> formFields;
  public final boolean hasFormFields;
  public final boolean hasUpdateEntity;
  public final boolean hasUpdateEntityUrn;
  public final Urn updateEntity;
  public final Urn updateEntityUrn;
  
  ProfileEditTaskInfo(Urn paramUrn1, Urn paramUrn2, List<FormField> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    updateEntity = paramUrn1;
    updateEntityUrn = paramUrn2;
    if (paramList == null) {}
    for (paramUrn1 = null;; paramUrn1 = Collections.unmodifiableList(paramList))
    {
      formFields = paramUrn1;
      hasUpdateEntity = paramBoolean1;
      hasUpdateEntityUrn = paramBoolean2;
      hasFormFields = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final ProfileEditTaskInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasUpdateEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("updateEntity");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(updateEntity));
    }
    if (hasUpdateEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("updateEntityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(updateEntityUrn));
    }
    Object localObject = null;
    FormField localFormField = null;
    boolean bool = false;
    if (hasFormFields)
    {
      paramDataProcessor.startRecordField$505cff1c("formFields");
      formFields.size();
      paramDataProcessor.startArray$13462e();
      localObject = localFormField;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = formFields.iterator();
      if (localIterator.hasNext())
      {
        localFormField = (FormField)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localFormField = localFormField.accept(paramDataProcessor);; localFormField = (FormField)paramDataProcessor.processDataTemplate(localFormField))
        {
          if ((localObject != null) && (localFormField != null)) {
            ((List)localObject).add(localFormField);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label292;
      }
    }
    label292:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label374;
      }
      try
      {
        if (hasFormFields) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileEditTaskInfo", "formFields");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (formFields != null)
    {
      paramDataProcessor = formFields.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((FormField)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileEditTaskInfo", "formFields");
        }
      }
    }
    return new ProfileEditTaskInfo(updateEntity, updateEntityUrn, (List)localObject, hasUpdateEntity, hasUpdateEntityUrn, bool);
    label374:
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
      paramObject = (ProfileEditTaskInfo)paramObject;
      if (updateEntity != null)
      {
        if (updateEntity.equals(updateEntity)) {}
      }
      else {
        while (updateEntity != null) {
          return false;
        }
      }
      if (updateEntityUrn != null)
      {
        if (updateEntityUrn.equals(updateEntityUrn)) {}
      }
      else {
        while (updateEntityUrn != null) {
          return false;
        }
      }
      if (formFields == null) {
        break;
      }
    } while (formFields.equals(formFields));
    for (;;)
    {
      return false;
      if (formFields == null) {
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
    Object localObject;
    if (hasUpdateEntity)
    {
      localObject = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(updateEntity)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasUpdateEntityUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(updateEntityUrn));
    }
    i += 1;
    j = i;
    if (hasFormFields)
    {
      i += 2;
      localObject = formFields.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        FormField localFormField = (FormField)((Iterator)localObject).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localFormField.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (updateEntity != null)
    {
      i = updateEntity.hashCode();
      if (updateEntityUrn == null) {
        break label89;
      }
    }
    label89:
    for (int j = updateEntityUrn.hashCode();; j = 0)
    {
      if (formFields != null) {
        k = formFields.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileEditTaskInfo");
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
    label178:
    label295:
    label328:
    label335:
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
        localByteBuffer.putInt(427964704);
        Object localObject;
        if (hasUpdateEntity)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(updateEntity));
          if (!hasUpdateEntityUrn) {
            break label295;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(updateEntityUrn));
          if (!hasFormFields) {
            break label328;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, formFields.size());
          localObject = formFields.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label335;
          }
          FormField localFormField = (FormField)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localFormField.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label178;
          }
          localByteBuffer.put((byte)1);
          localFormField.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileEditTaskInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */