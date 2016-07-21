package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

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

public final class OccupationHighlight
  implements FissileDataModel<OccupationHighlight>, RecordTemplate<OccupationHighlight>
{
  public static final OccupationHighlightBuilder BUILDER = OccupationHighlightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasNumViews;
  public final boolean hasViewerTitle;
  public final long numViews;
  public final String viewerTitle;
  
  OccupationHighlight(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    numViews = paramLong;
    viewerTitle = paramString;
    hasNumViews = paramBoolean1;
    hasViewerTitle = paramBoolean2;
    _cachedId = null;
  }
  
  public final OccupationHighlight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumViews)
    {
      paramDataProcessor.startRecordField$505cff1c("numViews");
      paramDataProcessor.processLong(numViews);
    }
    if (hasViewerTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("viewerTitle");
      paramDataProcessor.processString(viewerTitle);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumViews) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight", "numViews");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasViewerTitle) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight", "viewerTitle");
      }
      return new OccupationHighlight(numViews, viewerTitle, hasNumViews, hasViewerTitle);
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
      paramObject = (OccupationHighlight)paramObject;
      if (numViews != numViews) {
        return false;
      }
      if (viewerTitle == null) {
        break;
      }
    } while (viewerTitle.equals(viewerTitle));
    for (;;)
    {
      return false;
      if (viewerTitle == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasNumViews) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasViewerTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(viewerTitle);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int j = (int)(numViews ^ numViews >>> 32);
    if (viewerTitle != null) {}
    for (int i = viewerTitle.hashCode();; i = 0)
    {
      i = (j + 527) * 31 + i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building OccupationHighlight");
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
    label203:
    label211:
    label213:
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
        localByteBuffer.putInt(-960217302);
        if (hasNumViews)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numViews);
          if (!hasViewerTitle) {
            break label203;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, viewerTitle);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label211;
          }
          if (str != null) {
            break label213;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */