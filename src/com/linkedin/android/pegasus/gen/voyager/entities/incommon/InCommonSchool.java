package com.linkedin.android.pegasus.gen.voyager.entities.incommon;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class InCommonSchool
  implements FissileDataModel<InCommonSchool>, RecordTemplate<InCommonSchool>
{
  public static final InCommonSchoolBuilder BUILDER = InCommonSchoolBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasMiniSchool;
  public final boolean hasPeople;
  public final boolean hasPeopleWithDistance;
  public final boolean hasTotal;
  public final MiniSchool miniSchool;
  public final List<MiniProfile> people;
  public final List<MiniProfileWithDistance> peopleWithDistance;
  public final int total;
  
  InCommonSchool(MiniSchool paramMiniSchool, List<MiniProfile> paramList, List<MiniProfileWithDistance> paramList1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    miniSchool = paramMiniSchool;
    if (paramList == null)
    {
      paramMiniSchool = null;
      people = paramMiniSchool;
      if (paramList1 != null) {
        break label85;
      }
    }
    label85:
    for (paramMiniSchool = null;; paramMiniSchool = Collections.unmodifiableList(paramList1))
    {
      peopleWithDistance = paramMiniSchool;
      total = paramInt;
      hasMiniSchool = paramBoolean1;
      hasPeople = paramBoolean2;
      hasPeopleWithDistance = paramBoolean3;
      hasTotal = paramBoolean4;
      _cachedId = null;
      return;
      paramMiniSchool = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final InCommonSchool accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject3 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    boolean bool2;
    int i;
    if (hasMiniSchool)
    {
      paramDataProcessor.startRecordField$505cff1c("miniSchool");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniSchool.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasPeople) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("people");
      people.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = people.iterator();
      label131:
      if (!((Iterator)localObject4).hasNext()) {
        break label247;
      }
      localObject2 = (MiniProfile)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (Object localObject2 = ((MiniProfile)localObject2).accept(paramDataProcessor);; localObject2 = (MiniProfile)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label131;
      localObject1 = (MiniSchool)paramDataProcessor.processDataTemplate(miniSchool);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool2 = true;
      label261:
      localObject2 = null;
      localObject4 = null;
      bool3 = false;
      if (!hasPeopleWithDistance) {
        break label445;
      }
      paramDataProcessor.startRecordField$505cff1c("peopleWithDistance");
      peopleWithDistance.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = peopleWithDistance.iterator();
      label336:
      if (!localIterator.hasNext()) {
        break label431;
      }
      localObject4 = (MiniProfileWithDistance)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label415;
      }
    }
    label415:
    for (Object localObject4 = ((MiniProfileWithDistance)localObject4).accept(paramDataProcessor);; localObject4 = (MiniProfileWithDistance)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject2 != null) && (localObject4 != null)) {
        ((List)localObject2).add(localObject4);
      }
      i += 1;
      break label336;
      bool2 = false;
      break;
    }
    label431:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label445:
      if (hasTotal)
      {
        paramDataProcessor.startRecordField$505cff1c("total");
        paramDataProcessor.processInt(total);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label690;
      }
      if (!hasPeople) {
        localObject1 = Collections.emptyList();
      }
      if (!hasPeopleWithDistance) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasMiniSchool) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool", "miniSchool");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasTotal) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool", "total");
    }
    if (people != null)
    {
      paramDataProcessor = people.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool", "people");
        }
      }
    }
    if (peopleWithDistance != null)
    {
      paramDataProcessor = peopleWithDistance.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MiniProfileWithDistance)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool", "peopleWithDistance");
        }
      }
    }
    return new InCommonSchool((MiniSchool)localObject3, (List)localObject1, (List)localObject2, total, bool1, bool2, bool3, hasTotal);
    label690:
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
      paramObject = (InCommonSchool)paramObject;
      if (miniSchool != null)
      {
        if (miniSchool.equals(miniSchool)) {}
      }
      else {
        while (miniSchool != null) {
          return false;
        }
      }
      if (people != null)
      {
        if (people.equals(people)) {}
      }
      else {
        while (people != null) {
          return false;
        }
      }
      if (peopleWithDistance != null)
      {
        if (peopleWithDistance.equals(peopleWithDistance)) {}
      }
      else {
        while (peopleWithDistance != null) {
          return false;
        }
      }
    } while (total == total);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    Iterator localIterator;
    if (hasMiniSchool)
    {
      if (miniSchool._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniSchool._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasPeople) {
        break label153;
      }
      i += 2;
      localIterator = people.iterator();
    }
    Object localObject;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      localObject = (MiniProfile)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = miniSchool.getSerializedSize() + 7;
        break;
      }
      i += ((MiniProfile)localObject).getSerializedSize();
    }
    label153:
    i = j + 1;
    int j = i;
    if (hasPeopleWithDistance)
    {
      i += 2;
      localIterator = peopleWithDistance.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (MiniProfileWithDistance)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((MiniProfileWithDistance)localObject).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasTotal) {
      i = j + 4;
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
    if (miniSchool != null)
    {
      i = miniSchool.hashCode();
      if (people == null) {
        break label99;
      }
    }
    label99:
    for (int j = people.hashCode();; j = 0)
    {
      if (peopleWithDistance != null) {
        k = peopleWithDistance.hashCode();
      }
      i = ((j + (i + 527) * 31) * 31 + k) * 31 + total;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InCommonSchool");
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
    label335:
    label342:
    label546:
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
        localByteBuffer.putInt(-601848268);
        Iterator localIterator;
        if (hasMiniSchool)
        {
          localByteBuffer.put((byte)1);
          if (miniSchool._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniSchool._cachedId);
            miniSchool.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPeople) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, people.size());
            localIterator = people.iterator();
          }
        }
        Object localObject;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          localObject = (MiniProfile)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((MiniProfile)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            miniSchool.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          ((MiniProfile)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasPeopleWithDistance)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, peopleWithDistance.size());
          localIterator = peopleWithDistance.iterator();
          while (localIterator.hasNext())
          {
            localObject = (MiniProfileWithDistance)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((MiniProfileWithDistance)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((MiniProfileWithDistance)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasTotal)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(total);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label546;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */