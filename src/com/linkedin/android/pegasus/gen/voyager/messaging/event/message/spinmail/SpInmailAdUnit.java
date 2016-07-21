package com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SpInmailAdUnit
  implements FissileDataModel<SpInmailAdUnit>, RecordTemplate<SpInmailAdUnit>
{
  public static final SpInmailAdUnitBuilder BUILDER = SpInmailAdUnitBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Image adUnit;
  public final String adUnitTracking;
  public final boolean hasAdUnit;
  public final boolean hasAdUnitTracking;
  
  SpInmailAdUnit(Image paramImage, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    adUnit = paramImage;
    adUnitTracking = paramString;
    hasAdUnit = paramBoolean1;
    hasAdUnitTracking = paramBoolean2;
    _cachedId = null;
  }
  
  public final SpInmailAdUnit accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Image localImage = null;
    boolean bool = false;
    if (hasAdUnit)
    {
      paramDataProcessor.startRecordField$505cff1c("adUnit");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localImage = adUnit.accept(paramDataProcessor);
      if (localImage == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      if (hasAdUnitTracking)
      {
        paramDataProcessor.startRecordField$505cff1c("adUnitTracking");
        paramDataProcessor.processString(adUnitTracking);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label158;
      }
      try
      {
        if (hasAdUnit) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailAdUnit", "adUnit");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localImage = (Image)paramDataProcessor.processDataTemplate(adUnit);
      break;
    }
    label140:
    return new SpInmailAdUnit(localImage, adUnitTracking, bool, hasAdUnitTracking);
    label158:
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
      paramObject = (SpInmailAdUnit)paramObject;
      if (adUnit != null)
      {
        if (adUnit.equals(adUnit)) {}
      }
      else {
        while (adUnit != null) {
          return false;
        }
      }
      if (adUnitTracking == null) {
        break;
      }
    } while (adUnitTracking.equals(adUnitTracking));
    for (;;)
    {
      return false;
      if (adUnitTracking == null) {
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
    if (hasAdUnit) {
      if (adUnit._cachedId == null) {
        break label83;
      }
    }
    label83:
    for (i = PegasusBinaryUtils.getEncodedLength(adUnit._cachedId) + 9;; i = adUnit.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasAdUnitTracking) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(adUnitTracking);
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (adUnit != null) {}
    for (int i = adUnit.hashCode();; i = 0)
    {
      if (adUnitTracking != null) {
        j = adUnitTracking.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SpInmailAdUnit");
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
    label264:
    label272:
    label274:
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
        localByteBuffer.putInt(-1138539658);
        if (hasAdUnit)
        {
          localByteBuffer.put((byte)1);
          if (adUnit._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, adUnit._cachedId);
            adUnit.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAdUnitTracking) {
              break label264;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, adUnitTracking);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label272;
          }
          if (str != null) {
            break label274;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          adUnit.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailAdUnit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */