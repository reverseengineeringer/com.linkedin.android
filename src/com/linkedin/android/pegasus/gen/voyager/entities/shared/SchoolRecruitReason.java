package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
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

public final class SchoolRecruitReason
  implements FissileDataModel<SchoolRecruitReason>, RecordTemplate<SchoolRecruitReason>
{
  public static final SchoolRecruitReasonBuilder BUILDER = SchoolRecruitReasonBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<EntitiesMiniProfile> alumniOfMostRecentSchool;
  public final boolean hasAlumniOfMostRecentSchool;
  public final boolean hasMostRecentSchool;
  public final boolean hasTotalNumberOfAlumni;
  public final MiniSchool mostRecentSchool;
  public final int totalNumberOfAlumni;
  
  SchoolRecruitReason(MiniSchool paramMiniSchool, int paramInt, List<EntitiesMiniProfile> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    mostRecentSchool = paramMiniSchool;
    totalNumberOfAlumni = paramInt;
    if (paramList == null) {}
    for (paramMiniSchool = null;; paramMiniSchool = Collections.unmodifiableList(paramList))
    {
      alumniOfMostRecentSchool = paramMiniSchool;
      hasMostRecentSchool = paramBoolean1;
      hasTotalNumberOfAlumni = paramBoolean2;
      hasAlumniOfMostRecentSchool = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final SchoolRecruitReason accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasMostRecentSchool)
    {
      paramDataProcessor.startRecordField$505cff1c("mostRecentSchool");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = mostRecentSchool.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label247;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasTotalNumberOfAlumni)
      {
        paramDataProcessor.startRecordField$505cff1c("totalNumberOfAlumni");
        paramDataProcessor.processInt(totalNumberOfAlumni);
      }
      localObject1 = null;
      localEntitiesMiniProfile = null;
      bool2 = false;
      if (!hasAlumniOfMostRecentSchool) {
        break label286;
      }
      paramDataProcessor.startRecordField$505cff1c("alumniOfMostRecentSchool");
      alumniOfMostRecentSchool.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localEntitiesMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = alumniOfMostRecentSchool.iterator();
      label156:
      if (!localIterator.hasNext()) {
        break label272;
      }
      localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label256;
      }
    }
    label247:
    label256:
    for (EntitiesMiniProfile localEntitiesMiniProfile = localEntitiesMiniProfile.accept(paramDataProcessor);; localEntitiesMiniProfile = (EntitiesMiniProfile)paramDataProcessor.processDataTemplate(localEntitiesMiniProfile))
    {
      if ((localObject1 != null) && (localEntitiesMiniProfile != null)) {
        ((List)localObject1).add(localEntitiesMiniProfile);
      }
      i += 1;
      break label156;
      localObject1 = (MiniSchool)paramDataProcessor.processDataTemplate(mostRecentSchool);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
    }
    label272:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label286:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label447;
      }
      try
      {
        if (hasMostRecentSchool) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.SchoolRecruitReason", "mostRecentSchool");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasTotalNumberOfAlumni) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.SchoolRecruitReason", "totalNumberOfAlumni");
    }
    if (!hasAlumniOfMostRecentSchool) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.SchoolRecruitReason", "alumniOfMostRecentSchool");
    }
    if (alumniOfMostRecentSchool != null)
    {
      paramDataProcessor = alumniOfMostRecentSchool.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.shared.SchoolRecruitReason", "alumniOfMostRecentSchool");
        }
      }
    }
    return new SchoolRecruitReason((MiniSchool)localObject2, totalNumberOfAlumni, (List)localObject1, bool1, hasTotalNumberOfAlumni, bool2);
    label447:
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
      paramObject = (SchoolRecruitReason)paramObject;
      if (mostRecentSchool != null)
      {
        if (mostRecentSchool.equals(mostRecentSchool)) {}
      }
      else {
        while (mostRecentSchool != null) {
          return false;
        }
      }
      if (totalNumberOfAlumni != totalNumberOfAlumni) {
        return false;
      }
      if (alumniOfMostRecentSchool == null) {
        break;
      }
    } while (alumniOfMostRecentSchool.equals(alumniOfMostRecentSchool));
    for (;;)
    {
      return false;
      if (alumniOfMostRecentSchool == null) {
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
    Iterator localIterator;
    if (hasMostRecentSchool)
    {
      if (mostRecentSchool._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(mostRecentSchool._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasTotalNumberOfAlumni) {
        i = j + 4;
      }
      i += 1;
      j = i;
      if (!hasAlumniOfMostRecentSchool) {
        break label170;
      }
      i += 2;
      localIterator = alumniOfMostRecentSchool.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label170;
      }
      EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = mostRecentSchool.getSerializedSize() + 7;
        break;
      }
      i += localEntitiesMiniProfile.getSerializedSize();
    }
    label170:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (mostRecentSchool != null) {}
    for (int i = mostRecentSchool.hashCode();; i = 0)
    {
      int k = totalNumberOfAlumni;
      if (alumniOfMostRecentSchool != null) {
        j = alumniOfMostRecentSchool.hashCode();
      }
      i = ((i + 527) * 31 + k) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SchoolRecruitReason");
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
    label194:
    label336:
    label369:
    label376:
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
        localByteBuffer.putInt(1088706379);
        Iterator localIterator;
        if (hasMostRecentSchool)
        {
          localByteBuffer.put((byte)1);
          if (mostRecentSchool._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mostRecentSchool._cachedId);
            mostRecentSchool.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTotalNumberOfAlumni) {
              break label336;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(totalNumberOfAlumni);
            if (!hasAlumniOfMostRecentSchool) {
              break label369;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, alumniOfMostRecentSchool.size());
            localIterator = alumniOfMostRecentSchool.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label376;
          }
          EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEntitiesMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            mostRecentSchool.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label194;
          }
          localByteBuffer.put((byte)1);
          localEntitiesMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.SchoolRecruitReason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */