package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SchoolFacets
  implements FissileDataModel<SchoolFacets>, RecordTemplate<SchoolFacets>
{
  public static final SchoolFacetsBuilder BUILDER = SchoolFacetsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<AlumniJobFunction> alumniJobFunctions;
  public final List<AlumniLocation> alumniLocations;
  public final Urn entityUrn;
  public final boolean hasAlumniJobFunctions;
  public final boolean hasAlumniLocations;
  public final boolean hasEntityUrn;
  
  SchoolFacets(Urn paramUrn, List<AlumniJobFunction> paramList, List<AlumniLocation> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    entityUrn = paramUrn;
    if (paramList == null)
    {
      paramList = null;
      alumniJobFunctions = paramList;
      if (paramList1 != null) {
        break label84;
      }
    }
    label84:
    for (paramList = (List<AlumniJobFunction>)localObject;; paramList = Collections.unmodifiableList(paramList1))
    {
      alumniLocations = paramList;
      hasEntityUrn = paramBoolean1;
      hasAlumniJobFunctions = paramBoolean2;
      hasAlumniLocations = paramBoolean3;
      paramList = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final SchoolFacets accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    if (hasAlumniJobFunctions)
    {
      paramDataProcessor.startRecordField$505cff1c("alumniJobFunctions");
      alumniJobFunctions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = alumniJobFunctions.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (AlumniJobFunction)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((AlumniJobFunction)localObject2).accept(paramDataProcessor);; localObject2 = (AlumniJobFunction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      localObject2 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasAlumniLocations) {
        break label398;
      }
      paramDataProcessor.startRecordField$505cff1c("alumniLocations");
      alumniLocations.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = alumniLocations.iterator();
      label290:
      if (!localIterator.hasNext()) {
        break label384;
      }
      localObject3 = (AlumniLocation)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label368;
      }
    }
    label368:
    for (Object localObject3 = ((AlumniLocation)localObject3).accept(paramDataProcessor);; localObject3 = (AlumniLocation)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label290;
      bool1 = false;
      break;
    }
    label384:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label398:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label576;
      }
      if (!hasAlumniJobFunctions) {
        localObject1 = Collections.emptyList();
      }
      if (!hasAlumniLocations) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (alumniJobFunctions == null) {
          break;
        }
        paramDataProcessor = alumniJobFunctions.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((AlumniJobFunction)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolFacets", "alumniJobFunctions");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (alumniLocations != null)
    {
      paramDataProcessor = alumniLocations.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((AlumniLocation)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolFacets", "alumniLocations");
        }
      }
    }
    return new SchoolFacets(entityUrn, (List)localObject1, (List)localObject2, hasEntityUrn, bool1, bool2);
    label576:
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
      paramObject = (SchoolFacets)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (alumniJobFunctions != null)
      {
        if (alumniJobFunctions.equals(alumniJobFunctions)) {}
      }
      else {
        while (alumniJobFunctions != null) {
          return false;
        }
      }
      if (alumniLocations == null) {
        break;
      }
    } while (alumniLocations.equals(alumniLocations));
    for (;;)
    {
      return false;
      if (alumniLocations == null) {
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
    Object localObject1;
    if (hasEntityUrn)
    {
      localObject1 = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    i += 1;
    int j = i;
    Object localObject2;
    if (hasAlumniJobFunctions)
    {
      i += 2;
      localObject1 = alumniJobFunctions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (AlumniJobFunction)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((AlumniJobFunction)localObject2).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasAlumniLocations)
    {
      i += 2;
      localObject1 = alumniLocations.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (AlumniLocation)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((AlumniLocation)localObject2).getSerializedSize();
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
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (alumniJobFunctions == null) {
        break label91;
      }
    }
    label91:
    for (int j = alumniJobFunctions.hashCode();; j = 0)
    {
      if (alumniLocations != null) {
        k = alumniLocations.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SchoolFacets");
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
    label291:
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
        localByteBuffer.putInt(2067235365);
        Object localObject1;
        Object localObject2;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (hasAlumniJobFunctions)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, alumniJobFunctions.size());
            localObject1 = alumniJobFunctions.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label291;
            }
            localObject2 = (AlumniJobFunction)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((AlumniJobFunction)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            ((AlumniJobFunction)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
        if (hasAlumniLocations)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, alumniLocations.size());
          localObject1 = alumniLocations.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AlumniLocation)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((AlumniLocation)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((AlumniLocation)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolFacets
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */