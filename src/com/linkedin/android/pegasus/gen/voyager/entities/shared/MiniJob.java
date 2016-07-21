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

public final class MiniJob
  implements FissileDataModel<MiniJob>, RecordTemplate<MiniJob>
{
  public static final MiniJobBuilder BUILDER = MiniJobBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasListDate;
  public final boolean hasListedAt;
  public final boolean hasLocation;
  public final boolean hasLogo;
  public final boolean hasObjectUrn;
  public final boolean hasTitle;
  public final boolean hasTrackingId;
  public final long listDate;
  public final long listedAt;
  public final String location;
  public final Image logo;
  public final Urn objectUrn;
  public final String title;
  public final String trackingId;
  
  MiniJob(String paramString1, Urn paramUrn1, Urn paramUrn2, String paramString2, String paramString3, Image paramImage, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    trackingId = paramString1;
    objectUrn = paramUrn1;
    entityUrn = paramUrn2;
    title = paramString2;
    location = paramString3;
    logo = paramImage;
    listDate = paramLong1;
    listedAt = paramLong2;
    hasTrackingId = paramBoolean1;
    hasObjectUrn = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    hasTitle = paramBoolean4;
    hasLocation = paramBoolean5;
    hasLogo = paramBoolean6;
    hasListDate = paramBoolean7;
    hasListedAt = paramBoolean8;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  public final MiniJob accept(DataProcessor paramDataProcessor)
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
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasLocation)
    {
      paramDataProcessor.startRecordField$505cff1c("location");
      paramDataProcessor.processString(location);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasLogo)
    {
      paramDataProcessor.startRecordField$505cff1c("logo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label282;
      }
      localObject = logo.accept(paramDataProcessor);
      if (localObject == null) {
        break label299;
      }
    }
    label282:
    label299:
    for (bool = true;; bool = false)
    {
      if (hasListDate)
      {
        paramDataProcessor.startRecordField$505cff1c("listDate");
        paramDataProcessor.processLong(listDate);
      }
      if (hasListedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("listedAt");
        paramDataProcessor.processLong(listedAt);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label389;
      }
      try
      {
        if (hasEntityUrn) {
          break label304;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (Image)paramDataProcessor.processDataTemplate(logo);
      break;
    }
    label304:
    if (!hasTitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob", "title");
    }
    return new MiniJob(trackingId, objectUrn, entityUrn, title, location, (Image)localObject, listDate, listedAt, hasTrackingId, hasObjectUrn, hasEntityUrn, hasTitle, hasLocation, bool, hasListDate, hasListedAt);
    label389:
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
      paramObject = (MiniJob)paramObject;
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
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
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
      if (logo != null)
      {
        if (logo.equals(logo)) {}
      }
      else {
        while (logo != null) {
          return false;
        }
      }
      if (listDate != listDate) {
        return false;
      }
    } while (listedAt == listedAt);
    return false;
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
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasLocation) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(location);
    }
    j = i + 1;
    i = j;
    if (hasLogo)
    {
      i = j + 1;
      if (logo._cachedId == null) {
        break label237;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(logo._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasListDate) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasListedAt) {
        i = j + 8;
      }
      __sizeOfObject = i;
      return i;
      label237:
      i += logo.getSerializedSize();
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
    if (objectUrn != null)
    {
      i = objectUrn.hashCode();
      if (entityUrn == null) {
        break label166;
      }
      j = entityUrn.hashCode();
      if (title == null) {
        break label171;
      }
      k = title.hashCode();
      label60:
      if (location == null) {
        break label176;
      }
    }
    label166:
    label171:
    label176:
    for (int m = location.hashCode();; m = 0)
    {
      if (logo != null) {
        n = logo.hashCode();
      }
      i = (((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n) * 31 + (int)(listDate ^ listDate >>> 32)) * 31 + (int)(listedAt ^ listedAt >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MiniJob");
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
    label256:
    label316:
    label340:
    label407:
    label417:
    label427:
    label437:
    label447:
    label472:
    label482:
    label492:
    label500:
    label502:
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
        localByteBuffer.putInt(-943938465);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasObjectUrn) {
            break label407;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          if (!hasEntityUrn) {
            break label417;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTitle) {
            break label427;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasLocation) {
            break label437;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, location);
          if (!hasLogo) {
            break label472;
          }
          localByteBuffer.put((byte)1);
          if (logo._cachedId == null) {
            break label447;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, logo._cachedId);
          logo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasListDate) {
            break label482;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(listDate);
          if (!hasListedAt) {
            break label492;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(listedAt);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label500;
          }
          if (str != null) {
            break label502;
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
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)1);
          logo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label316;
          localByteBuffer.put((byte)0);
          break label316;
          localByteBuffer.put((byte)0);
          break label340;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */