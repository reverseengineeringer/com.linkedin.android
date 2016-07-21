package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MiniSchool
  implements FissileDataModel<MiniSchool>, RecordTemplate<MiniSchool>
{
  public static final MiniSchoolBuilder BUILDER = MiniSchoolBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasLogo;
  public final boolean hasObjectUrn;
  public final boolean hasSchoolName;
  public final boolean hasTrackingId;
  public final Image logo;
  public final Urn objectUrn;
  public final String schoolName;
  public final String trackingId;
  
  MiniSchool(String paramString1, Urn paramUrn1, Urn paramUrn2, String paramString2, Image paramImage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    trackingId = paramString1;
    objectUrn = paramUrn1;
    entityUrn = paramUrn2;
    schoolName = paramString2;
    logo = paramImage;
    hasTrackingId = paramBoolean1;
    hasObjectUrn = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    hasSchoolName = paramBoolean4;
    hasLogo = paramBoolean5;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  public final MiniSchool accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    if (hasObjectUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("objectUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasSchoolName)
    {
      paramDataProcessor.startRecordField$505cff1c("schoolName");
      paramDataProcessor.processString(schoolName);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasLogo)
    {
      paramDataProcessor.startRecordField$505cff1c("logo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label207;
      }
      localObject = logo.accept(paramDataProcessor);
      if (localObject == null) {
        break label224;
      }
    }
    label207:
    label224:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label290;
      }
      try
      {
        if (hasEntityUrn) {
          break label229;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (Image)paramDataProcessor.processDataTemplate(logo);
      break;
    }
    label229:
    if (!hasSchoolName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool", "schoolName");
    }
    return new MiniSchool(trackingId, objectUrn, entityUrn, schoolName, (Image)localObject, hasTrackingId, hasObjectUrn, hasEntityUrn, hasSchoolName, bool);
    label290:
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
      paramObject = (MiniSchool)paramObject;
      if (objectUrn != null)
      {
        if (objectUrn.equals(objectUrn)) {}
      }
      else {
        while (objectUrn != null) {
          return false;
        }
      }
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (schoolName != null)
      {
        if (schoolName.equals(schoolName)) {}
      }
      else {
        while (schoolName != null) {
          return false;
        }
      }
      if (logo == null) {
        break;
      }
    } while (logo.equals(logo));
    for (;;)
    {
      return false;
      if (logo == null) {
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
    if (hasTrackingId) {
      i = PegasusBinaryUtils.getEncodedLength(trackingId) + 8;
    }
    int j = i + 1;
    i = j;
    UrnCoercer localUrnCoercer;
    if (hasObjectUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    j = i + 1;
    i = j;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    j = i + 1;
    i = j;
    if (hasSchoolName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(schoolName);
    }
    j = i + 1;
    i = j;
    if (hasLogo)
    {
      i = j + 1;
      if (logo._cachedId == null) {
        break label176;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(logo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label176:
      i += logo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (objectUrn != null)
    {
      i = objectUrn.hashCode();
      if (entityUrn == null) {
        break label110;
      }
      j = entityUrn.hashCode();
      label45:
      if (schoolName == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = schoolName.hashCode();; k = 0)
    {
      if (logo != null) {
        m = logo.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MiniSchool");
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
    label204:
    label230:
    label333:
    label343:
    label353:
    label363:
    label388:
    label396:
    label398:
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
        localByteBuffer.putInt(1849250407);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasObjectUrn) {
            break label333;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          if (!hasEntityUrn) {
            break label343;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasSchoolName) {
            break label353;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, schoolName);
          if (!hasLogo) {
            break label388;
          }
          localByteBuffer.put((byte)1);
          if (logo._cachedId == null) {
            break label363;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, logo._cachedId);
          logo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label396;
          }
          if (str != null) {
            break label398;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          logo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */