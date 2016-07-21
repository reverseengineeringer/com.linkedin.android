package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public class TypeaheadSchool
  implements FissileDataModel<TypeaheadSchool>, RecordTemplate<TypeaheadSchool>
{
  public static final TypeaheadSchoolBuilder BUILDER = TypeaheadSchoolBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final FollowingInfo following;
  public final boolean hasBackendUrn;
  public final boolean hasFollowing;
  public final boolean hasId;
  public final boolean hasSchool;
  public final String id;
  public final MiniSchool school;
  
  TypeaheadSchool(String paramString, Urn paramUrn, MiniSchool paramMiniSchool, FollowingInfo paramFollowingInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    id = paramString;
    backendUrn = paramUrn;
    school = paramMiniSchool;
    following = paramFollowingInfo;
    hasId = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    hasSchool = paramBoolean3;
    hasFollowing = paramBoolean4;
    _cachedId = null;
  }
  
  public final TypeaheadSchool accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processString(id);
    }
    Object localObject1;
    if (hasBackendUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("backendUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasSchool)
    {
      paramDataProcessor.startRecordField$505cff1c("school");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = school.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label114:
      localObject1 = null;
      bool2 = false;
      if (hasFollowing)
      {
        paramDataProcessor.startRecordField$505cff1c("following");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label231;
        }
        localObject1 = following.accept(paramDataProcessor);
        label153:
        if (localObject1 == null) {
          break label249;
        }
      }
    }
    label222:
    label231:
    label249:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label322;
      }
      try
      {
        if (hasId) {
          break label254;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSchool", "id");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniSchool)paramDataProcessor.processDataTemplate(school);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(following);
      break label153;
    }
    label254:
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSchool", "backendUrn");
    }
    if (!hasSchool) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSchool", "school");
    }
    return new TypeaheadSchool(id, backendUrn, (MiniSchool)localObject2, (FollowingInfo)localObject1, hasId, hasBackendUrn, bool1, bool2);
    label322:
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TypeaheadSchool)paramObject;
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
      if (school != null)
      {
        if (school.equals(school)) {}
      }
      else {
        while (school != null) {
          return false;
        }
      }
      if (following == null) {
        break;
      }
    } while (following.equals(following));
    for (;;)
    {
      return false;
      if (following == null) {
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
    if (hasBackendUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    j = i + 1;
    i = j;
    if (hasSchool)
    {
      i = j + 1;
      if (school._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(school._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasFollowing)
      {
        i = j + 1;
        if (following._cachedId == null) {
          break label174;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(following._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += school.getSerializedSize();
      break;
      label174:
      i += following.getSerializedSize();
    }
  }
  
  public int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (id != null)
    {
      i = id.hashCode();
      if (backendUrn == null) {
        break label110;
      }
      j = backendUrn.hashCode();
      label45:
      if (school == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = school.hashCode();; k = 0)
    {
      if (following != null) {
        m = following.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TypeaheadSchool");
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
    label230:
    label333:
    label343:
    label368:
    label378:
    label403:
    label411:
    label413:
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
        localByteBuffer.putInt(-961548818);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasBackendUrn) {
            break label333;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasSchool) {
            break label368;
          }
          localByteBuffer.put((byte)1);
          if (school._cachedId == null) {
            break label343;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, school._cachedId);
          school.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFollowing) {
            break label403;
          }
          localByteBuffer.put((byte)1);
          if (following._cachedId == null) {
            break label378;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, following._cachedId);
          following.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label411;
          }
          if (str != null) {
            break label413;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)1);
          school.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          following.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSchool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */