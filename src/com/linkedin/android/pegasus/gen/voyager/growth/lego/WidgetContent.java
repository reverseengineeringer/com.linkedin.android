package com.linkedin.android.pegasus.gen.voyager.growth.lego;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class WidgetContent
  implements FissileDataModel<WidgetContent>, RecordTemplate<WidgetContent>
{
  public static final WidgetContentBuilder BUILDER = WidgetContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasPrefetchable;
  public final boolean hasTrackingToken;
  public final boolean hasWidgetId;
  public final boolean prefetchable;
  public final String trackingToken;
  public final String widgetId;
  
  WidgetContent(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    widgetId = paramString1;
    trackingToken = paramString2;
    prefetchable = paramBoolean1;
    hasWidgetId = paramBoolean2;
    hasTrackingToken = paramBoolean3;
    hasPrefetchable = paramBoolean4;
    _cachedId = null;
  }
  
  public final WidgetContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasWidgetId)
    {
      paramDataProcessor.startRecordField$505cff1c("widgetId");
      paramDataProcessor.processString(widgetId);
    }
    if (hasTrackingToken)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingToken");
      paramDataProcessor.processString(trackingToken);
    }
    if (hasPrefetchable)
    {
      paramDataProcessor.startRecordField$505cff1c("prefetchable");
      paramDataProcessor.processBoolean(prefetchable);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasWidgetId) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent", "widgetId");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasTrackingToken) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent", "trackingToken");
      }
      if (!hasPrefetchable) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent", "prefetchable");
      }
      return new WidgetContent(widgetId, trackingToken, prefetchable, hasWidgetId, hasTrackingToken, hasPrefetchable);
    }
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
      paramObject = (WidgetContent)paramObject;
      if (widgetId != null)
      {
        if (widgetId.equals(widgetId)) {}
      }
      else {
        while (widgetId != null) {
          return false;
        }
      }
      if (trackingToken != null)
      {
        if (trackingToken.equals(trackingToken)) {}
      }
      else {
        while (trackingToken != null) {
          return false;
        }
      }
    } while (prefetchable == prefetchable);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasWidgetId) {
      i = PegasusBinaryUtils.getEncodedLength(widgetId) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTrackingToken) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingToken);
    }
    j = i + 1;
    i = j;
    if (hasPrefetchable) {
      i = j + 1;
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
    if (widgetId != null)
    {
      i = widgetId.hashCode();
      if (trackingToken == null) {
        break label81;
      }
    }
    label81:
    for (int j = trackingToken.hashCode();; j = 0)
    {
      if (prefetchable) {
        k = 1;
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
    int i = 1;
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WidgetContent");
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
    label165:
    label186:
    label238:
    label248:
    label254:
    label262:
    label264:
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
        localByteBuffer.putInt(336873126);
        if (hasWidgetId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, widgetId);
          if (!hasTrackingToken) {
            break label238;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingToken);
          if (!hasPrefetchable) {
            break label254;
          }
          localByteBuffer.put((byte)1);
          if (!prefetchable) {
            break label248;
          }
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label262;
          }
          if (str != null) {
            break label264;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label165;
          i = 0;
          break label186;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */