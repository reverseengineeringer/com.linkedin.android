package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Alumnus
  implements FissileDataModel<Alumnus>, RecordTemplate<Alumnus>
{
  public static final AlumnusBuilder BUILDER = AlumnusBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String degreeLevel;
  public final Date endDate;
  public final String fieldOfStudy;
  public final boolean hasDegreeLevel;
  public final boolean hasEndDate;
  public final boolean hasFieldOfStudy;
  public final boolean hasMiniProfile;
  public final boolean hasObjectUrn;
  public final boolean hasStartDate;
  public final boolean hasTimePeriod;
  public final MiniProfile miniProfile;
  public final Urn objectUrn;
  public final Date startDate;
  public final DateRange timePeriod;
  
  Alumnus(MiniProfile paramMiniProfile, String paramString1, String paramString2, Date paramDate1, Date paramDate2, DateRange paramDateRange, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    miniProfile = paramMiniProfile;
    degreeLevel = paramString1;
    fieldOfStudy = paramString2;
    startDate = paramDate1;
    endDate = paramDate2;
    timePeriod = paramDateRange;
    objectUrn = paramUrn;
    hasMiniProfile = paramBoolean1;
    hasDegreeLevel = paramBoolean2;
    hasFieldOfStudy = paramBoolean3;
    hasStartDate = paramBoolean4;
    hasEndDate = paramBoolean5;
    hasTimePeriod = paramBoolean6;
    hasObjectUrn = paramBoolean7;
    _cachedId = null;
  }
  
  public final Alumnus accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label145:
    label156:
    Object localObject4;
    boolean bool3;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label351;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasDegreeLevel)
      {
        paramDataProcessor.startRecordField$505cff1c("degreeLevel");
        paramDataProcessor.processString(degreeLevel);
      }
      if (hasFieldOfStudy)
      {
        paramDataProcessor.startRecordField$505cff1c("fieldOfStudy");
        paramDataProcessor.processString(fieldOfStudy);
      }
      localObject3 = null;
      bool2 = false;
      if (hasStartDate)
      {
        paramDataProcessor.startRecordField$505cff1c("startDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label360;
        }
        localObject1 = startDate.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label378;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasEndDate)
      {
        paramDataProcessor.startRecordField$505cff1c("endDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label387;
        }
        localObject1 = endDate.accept(paramDataProcessor);
        label196:
        if (localObject1 == null) {
          break label405;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label208:
      localObject1 = null;
      bool4 = false;
      if (hasTimePeriod)
      {
        paramDataProcessor.startRecordField$505cff1c("timePeriod");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label415;
        }
        localObject1 = timePeriod.accept(paramDataProcessor);
        label248:
        if (localObject1 == null) {
          break label433;
        }
      }
    }
    label351:
    label360:
    label378:
    label387:
    label405:
    label415:
    label433:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasObjectUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("objectUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label485;
      }
      try
      {
        if (hasMiniProfile) {
          break label439;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.Alumnus", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (Date)paramDataProcessor.processDataTemplate(startDate);
      break label145;
      bool2 = false;
      localObject3 = localObject1;
      break label156;
      localObject1 = (Date)paramDataProcessor.processDataTemplate(endDate);
      break label196;
      bool3 = false;
      localObject4 = localObject1;
      break label208;
      localObject1 = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break label248;
    }
    label439:
    return new Alumnus((MiniProfile)localObject2, degreeLevel, fieldOfStudy, (Date)localObject3, (Date)localObject4, (DateRange)localObject1, objectUrn, bool1, hasDegreeLevel, hasFieldOfStudy, bool2, bool3, bool4, hasObjectUrn);
    label485:
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
      paramObject = (Alumnus)paramObject;
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (degreeLevel != null)
      {
        if (degreeLevel.equals(degreeLevel)) {}
      }
      else {
        while (degreeLevel != null) {
          return false;
        }
      }
      if (fieldOfStudy != null)
      {
        if (fieldOfStudy.equals(fieldOfStudy)) {}
      }
      else {
        while (fieldOfStudy != null) {
          return false;
        }
      }
      if (startDate != null)
      {
        if (startDate.equals(startDate)) {}
      }
      else {
        while (startDate != null) {
          return false;
        }
      }
      if (endDate != null)
      {
        if (endDate.equals(endDate)) {}
      }
      else {
        while (endDate != null) {
          return false;
        }
      }
      if (timePeriod != null)
      {
        if (timePeriod.equals(timePeriod)) {}
      }
      else {
        while (timePeriod != null) {
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
    int j;
    if (hasMiniProfile)
    {
      if (miniProfile._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasDegreeLevel) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(degreeLevel);
      }
      j = i + 1;
      i = j;
      if (hasFieldOfStudy) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(fieldOfStudy);
      }
      j = i + 1;
      i = j;
      if (hasStartDate)
      {
        i = j + 1;
        if (startDate._cachedId == null) {
          break label280;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(startDate._cachedId);
      }
      label143:
      j = i + 1;
      i = j;
      if (hasEndDate)
      {
        i = j + 1;
        if (endDate._cachedId == null) {
          break label293;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(endDate._cachedId);
      }
      label185:
      j = i + 1;
      i = j;
      if (hasTimePeriod)
      {
        i = j + 1;
        if (timePeriod._cachedId == null) {
          break label306;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasObjectUrn)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      __sizeOfObject = i;
      return i;
      i = miniProfile.getSerializedSize() + 7;
      break;
      label280:
      i += startDate.getSerializedSize();
      break label143;
      label293:
      i += endDate.getSerializedSize();
      break label185;
      label306:
      i += timePeriod.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    if (miniProfile != null)
    {
      i = miniProfile.hashCode();
      if (degreeLevel == null) {
        break label176;
      }
      j = degreeLevel.hashCode();
      if (fieldOfStudy == null) {
        break label181;
      }
      k = fieldOfStudy.hashCode();
      if (startDate == null) {
        break label186;
      }
      m = startDate.hashCode();
      if (endDate == null) {
        break label192;
      }
      n = endDate.hashCode();
      label92:
      if (timePeriod == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = timePeriod.hashCode();; i1 = 0)
    {
      if (objectUrn != null) {
        i2 = objectUrn.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Alumnus");
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
    label196:
    label222:
    label282:
    label342:
    label402:
    label504:
    label514:
    label524:
    label549:
    label559:
    label584:
    label594:
    label619:
    label629:
    label637:
    label639:
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
        localByteBuffer.putInt(-1727495902);
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDegreeLevel) {
              break label504;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, degreeLevel);
            if (!hasFieldOfStudy) {
              break label514;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, fieldOfStudy);
            if (!hasStartDate) {
              break label549;
            }
            localByteBuffer.put((byte)1);
            if (startDate._cachedId == null) {
              break label524;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, startDate._cachedId);
            startDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEndDate) {
              break label584;
            }
            localByteBuffer.put((byte)1);
            if (endDate._cachedId == null) {
              break label559;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, endDate._cachedId);
            endDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTimePeriod) {
              break label619;
            }
            localByteBuffer.put((byte)1);
            if (timePeriod._cachedId == null) {
              break label594;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
            timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasObjectUrn) {
              break label629;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label637;
          }
          if (str != null) {
            break label639;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)0);
          break label222;
          localByteBuffer.put((byte)1);
          startDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label282;
          localByteBuffer.put((byte)0);
          break label282;
          localByteBuffer.put((byte)1);
          endDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label342;
          localByteBuffer.put((byte)0);
          break label342;
          localByteBuffer.put((byte)1);
          timePeriod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label402;
          localByteBuffer.put((byte)0);
          break label402;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.Alumnus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */