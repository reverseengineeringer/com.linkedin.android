package com.linkedin.android.pegasus.gen.voyager.entities.incommon;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
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

public final class InCommonPerson
  implements FissileDataModel<InCommonPerson>, RecordTemplate<InCommonPerson>
{
  public static final InCommonPersonBuilder BUILDER = InCommonPersonBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasMember;
  public final boolean hasPeople;
  public final boolean hasTotal;
  public final MiniProfileWithDistance member;
  public final List<MiniProfile> people;
  public final int total;
  
  InCommonPerson(MiniProfileWithDistance paramMiniProfileWithDistance, List<MiniProfile> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    member = paramMiniProfileWithDistance;
    if (paramList == null) {}
    for (paramMiniProfileWithDistance = null;; paramMiniProfileWithDistance = Collections.unmodifiableList(paramList))
    {
      people = paramMiniProfileWithDistance;
      total = paramInt;
      hasMember = paramBoolean1;
      hasPeople = paramBoolean2;
      hasTotal = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final InCommonPerson accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasMember)
    {
      paramDataProcessor.startRecordField$505cff1c("member");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = member.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localMiniProfile = null;
      bool2 = false;
      if (!hasPeople) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("people");
      people.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = people.iterator();
      label131:
      if (!localIterator.hasNext()) {
        break label247;
      }
      localMiniProfile = (MiniProfile)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (MiniProfile localMiniProfile = localMiniProfile.accept(paramDataProcessor);; localMiniProfile = (MiniProfile)paramDataProcessor.processDataTemplate(localMiniProfile))
    {
      if ((localObject1 != null) && (localMiniProfile != null)) {
        ((List)localObject1).add(localMiniProfile);
      }
      i += 1;
      break label131;
      localObject1 = (MiniProfileWithDistance)paramDataProcessor.processDataTemplate(member);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label261:
      if (hasTotal)
      {
        paramDataProcessor.startRecordField$505cff1c("total");
        paramDataProcessor.processInt(total);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label421;
      }
      if (!hasPeople) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasTotal) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson", "total");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (people != null)
    {
      paramDataProcessor = people.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson", "people");
        }
      }
    }
    return new InCommonPerson((MiniProfileWithDistance)localObject2, (List)localObject1, total, bool1, bool2, hasTotal);
    label421:
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
      paramObject = (InCommonPerson)paramObject;
      if (member != null)
      {
        if (member.equals(member)) {}
      }
      else {
        while (member != null) {
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
    } while (total == total);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j;
    Iterator localIterator;
    if (hasMember)
    {
      if (member._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(member._cachedId) + 9;
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
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      MiniProfile localMiniProfile = (MiniProfile)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = member.getSerializedSize() + 7;
        break;
      }
      i += localMiniProfile.getSerializedSize();
    }
    label153:
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
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (member != null) {}
    for (int i = member.hashCode();; i = 0)
    {
      if (people != null) {
        j = people.hashCode();
      }
      i = ((i + 527) * 31 + j) * 31 + total;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InCommonPerson");
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
    label409:
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
        localByteBuffer.putInt(-667758660);
        Iterator localIterator;
        if (hasMember)
        {
          localByteBuffer.put((byte)1);
          if (member._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, member._cachedId);
            member.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPeople) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, people.size());
            localIterator = people.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          MiniProfile localMiniProfile = (MiniProfile)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            member.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          localMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
            break label409;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */