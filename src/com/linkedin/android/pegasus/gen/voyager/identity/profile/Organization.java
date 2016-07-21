package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Organization
  implements FissileDataModel<Organization>, RecordTemplate<Organization>
{
  public static final OrganizationBuilder BUILDER = OrganizationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasName;
  public final boolean hasOccupation;
  public final boolean hasPosition;
  public final boolean hasTimePeriod;
  public final String name;
  public final Urn occupation;
  public final String position;
  public final DateRange timePeriod;
  
  Organization(Urn paramUrn1, String paramString1, DateRange paramDateRange, String paramString2, Urn paramUrn2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    entityUrn = paramUrn1;
    name = paramString1;
    timePeriod = paramDateRange;
    position = paramString2;
    occupation = paramUrn2;
    description = paramString3;
    hasEntityUrn = paramBoolean1;
    hasName = paramBoolean2;
    hasTimePeriod = paramBoolean3;
    hasPosition = paramBoolean4;
    hasOccupation = paramBoolean5;
    hasDescription = paramBoolean6;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final Organization accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasTimePeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("timePeriod");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label233;
      }
      localObject = timePeriod.accept(paramDataProcessor);
      if (localObject == null) {
        break label250;
      }
    }
    label233:
    label250:
    for (bool = true;; bool = false)
    {
      if (hasPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("position");
        paramDataProcessor.processString(position);
      }
      if (hasOccupation)
      {
        paramDataProcessor.startRecordField$505cff1c("occupation");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(occupation));
      }
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label305;
      }
      try
      {
        if (hasName) {
          break label255;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Organization", "name");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
    }
    label255:
    return new Organization(entityUrn, name, (DateRange)localObject, position, occupation, description, hasEntityUrn, hasName, bool, hasPosition, hasOccupation, hasDescription);
    label305:
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
      paramObject = (Organization)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
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
      if (position != null)
      {
        if (position.equals(position)) {}
      }
      else {
        while (position != null) {
          return false;
        }
      }
      if (occupation != null)
      {
        if (occupation.equals(occupation)) {}
      }
      else {
        while (occupation != null) {
          return false;
        }
      }
      if (description == null) {
        break;
      }
    } while (description.equals(description));
    for (;;)
    {
      return false;
      if (description == null) {
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
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasTimePeriod)
    {
      i = j + 1;
      if (timePeriod._cachedId == null) {
        break label201;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasPosition) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(position);
      }
      j = i + 1;
      i = j;
      if (hasOccupation)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(occupation));
      }
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      __sizeOfObject = i;
      return i;
      label201:
      i += timePeriod.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (name == null) {
        break label154;
      }
      j = name.hashCode();
      if (timePeriod == null) {
        break label159;
      }
      k = timePeriod.hashCode();
      if (position == null) {
        break label164;
      }
      m = position.hashCode();
      label76:
      if (occupation == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = occupation.hashCode();; n = 0)
    {
      if (description != null) {
        i1 = description.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Organization");
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
    label256:
    label290:
    label359:
    label369:
    label394:
    label404:
    label414:
    label424:
    label432:
    label434:
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
        localByteBuffer.putInt(-788564116);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label359;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasTimePeriod) {
            break label394;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label369;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPosition) {
            break label404;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, position);
          if (!hasOccupation) {
            break label414;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(occupation));
          if (!hasDescription) {
            break label424;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label432;
          }
          if (str != null) {
            break label434;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)1);
          timePeriod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label256;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Organization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */