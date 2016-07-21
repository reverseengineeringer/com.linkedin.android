package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NextSchool
  implements FissileDataModel<NextSchool>, RecordTemplate<NextSchool>
{
  public static final NextSchoolBuilder BUILDER = NextSchoolBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasLocation;
  public final boolean hasMiniSchool;
  public final boolean hasObjectUrn;
  public final boolean hasStudentsAndAlumniCount;
  public final String location;
  public final MiniSchool miniSchool;
  public final Urn objectUrn;
  public final StudentsAndAlumniCount studentsAndAlumniCount;
  
  NextSchool(Urn paramUrn1, MiniSchool paramMiniSchool, String paramString, StudentsAndAlumniCount paramStudentsAndAlumniCount, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    entityUrn = paramUrn1;
    miniSchool = paramMiniSchool;
    location = paramString;
    studentsAndAlumniCount = paramStudentsAndAlumniCount;
    objectUrn = paramUrn2;
    hasEntityUrn = paramBoolean1;
    hasMiniSchool = paramBoolean2;
    hasLocation = paramBoolean3;
    hasStudentsAndAlumniCount = paramBoolean4;
    hasObjectUrn = paramBoolean5;
    paramMiniSchool = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final NextSchool accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasMiniSchool)
    {
      paramDataProcessor.startRecordField$505cff1c("miniSchool");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniSchool.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label255;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label89:
      if (hasLocation)
      {
        paramDataProcessor.startRecordField$505cff1c("location");
        paramDataProcessor.processString(location);
      }
      localObject1 = null;
      bool2 = false;
      if (hasStudentsAndAlumniCount)
      {
        paramDataProcessor.startRecordField$505cff1c("studentsAndAlumniCount");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label264;
        }
        localObject1 = studentsAndAlumniCount.accept(paramDataProcessor);
        label153:
        if (localObject1 == null) {
          break label282;
        }
      }
    }
    label255:
    label264:
    label282:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasObjectUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("objectUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label325;
      }
      try
      {
        if (hasMiniSchool) {
          break label287;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.NextSchool", "miniSchool");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniSchool)paramDataProcessor.processDataTemplate(miniSchool);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (StudentsAndAlumniCount)paramDataProcessor.processDataTemplate(studentsAndAlumniCount);
      break label153;
    }
    label287:
    return new NextSchool(entityUrn, (MiniSchool)localObject2, location, (StudentsAndAlumniCount)localObject1, objectUrn, hasEntityUrn, bool1, hasLocation, bool2, hasObjectUrn);
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
      paramObject = (NextSchool)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (miniSchool != null)
      {
        if (miniSchool.equals(miniSchool)) {}
      }
      else {
        while (miniSchool != null) {
          return false;
        }
      }
      if (location != null)
      {
        if (location.equals(location)) {}
      }
      else {
        while (location != null) {
          return false;
        }
      }
      if (studentsAndAlumniCount != null)
      {
        if (studentsAndAlumniCount.equals(studentsAndAlumniCount)) {}
      }
      else {
        while (studentsAndAlumniCount != null) {
          return false;
        }
      }
      if (objectUrn == null) {
        break;
      }
    } while (objectUrn.equals(objectUrn));
    for (;;)
    {
      return false;
      if (objectUrn == null) {
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
    UrnCoercer localUrnCoercer;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMiniSchool)
    {
      i = j + 1;
      if (miniSchool._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniSchool._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasLocation) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(location);
      }
      j = i + 1;
      i = j;
      if (hasStudentsAndAlumniCount)
      {
        i = j + 1;
        if (studentsAndAlumniCount._cachedId == null) {
          break label206;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(studentsAndAlumniCount._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasObjectUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      __sizeOfObject = i;
      return i;
      i += miniSchool.getSerializedSize();
      break;
      label206:
      i += studentsAndAlumniCount.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (miniSchool == null) {
        break label132;
      }
      j = miniSchool.hashCode();
      if (location == null) {
        break label137;
      }
      k = location.hashCode();
      label60:
      if (studentsAndAlumniCount == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = studentsAndAlumniCount.hashCode();; m = 0)
    {
      if (objectUrn != null) {
        n = objectUrn.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NextSchool");
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
    label204:
    label230:
    label290:
    label367:
    label392:
    label402:
    label412:
    label437:
    label447:
    label455:
    label457:
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
        localByteBuffer.putInt(-922643627);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasMiniSchool) {
            break label392;
          }
          localByteBuffer.put((byte)1);
          if (miniSchool._cachedId == null) {
            break label367;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniSchool._cachedId);
          miniSchool.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasLocation) {
            break label402;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, location);
          if (!hasStudentsAndAlumniCount) {
            break label437;
          }
          localByteBuffer.put((byte)1);
          if (studentsAndAlumniCount._cachedId == null) {
            break label412;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, studentsAndAlumniCount._cachedId);
          studentsAndAlumniCount.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasObjectUrn) {
            break label447;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label455;
          }
          if (str != null) {
            break label457;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniSchool.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          studentsAndAlumniCount.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.NextSchool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */