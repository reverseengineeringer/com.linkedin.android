package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

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

public final class ViewReferrerSourceHighlight
  implements FissileDataModel<ViewReferrerSourceHighlight>, RecordTemplate<ViewReferrerSourceHighlight>
{
  public static final ViewReferrerSourceHighlightBuilder BUILDER = ViewReferrerSourceHighlightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasReferrerSources;
  public final List<ViewReferrerSourceInfo> referrerSources;
  
  ViewReferrerSourceHighlight(List<ViewReferrerSourceInfo> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      referrerSources = paramList;
      hasReferrerSources = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  public final ViewReferrerSourceHighlight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    ViewReferrerSourceInfo localViewReferrerSourceInfo = null;
    boolean bool = false;
    if (hasReferrerSources)
    {
      paramDataProcessor.startRecordField$505cff1c("referrerSources");
      referrerSources.size();
      paramDataProcessor.startArray$13462e();
      localObject = localViewReferrerSourceInfo;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = referrerSources.iterator();
      if (localIterator.hasNext())
      {
        localViewReferrerSourceInfo = (ViewReferrerSourceInfo)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localViewReferrerSourceInfo = localViewReferrerSourceInfo.accept(paramDataProcessor);; localViewReferrerSourceInfo = (ViewReferrerSourceInfo)paramDataProcessor.processDataTemplate(localViewReferrerSourceInfo))
        {
          if ((localObject != null) && (localViewReferrerSourceInfo != null)) {
            ((List)localObject).add(localViewReferrerSourceInfo);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label226;
      }
    }
    label226:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label292;
      }
      try
      {
        if (hasReferrerSources) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceHighlight", "referrerSources");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (referrerSources != null)
    {
      paramDataProcessor = referrerSources.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ViewReferrerSourceInfo)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceHighlight", "referrerSources");
        }
      }
    }
    return new ViewReferrerSourceHighlight((List)localObject, bool);
    label292:
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
      paramObject = (ViewReferrerSourceHighlight)paramObject;
      if (referrerSources == null) {
        break;
      }
    } while (referrerSources.equals(referrerSources));
    for (;;)
    {
      return false;
      if (referrerSources == null) {
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
    int j = i;
    if (hasReferrerSources)
    {
      i += 2;
      Iterator localIterator = referrerSources.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        ViewReferrerSourceInfo localViewReferrerSourceInfo = (ViewReferrerSourceInfo)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localViewReferrerSourceInfo.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (referrerSources != null) {}
    for (int i = referrerSources.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ViewReferrerSourceHighlight");
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
        localByteBuffer.putInt(1043981087);
        if (hasReferrerSources)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, referrerSources.size());
          Iterator localIterator = referrerSources.iterator();
          while (localIterator.hasNext())
          {
            ViewReferrerSourceInfo localViewReferrerSourceInfo = (ViewReferrerSourceInfo)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localViewReferrerSourceInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localViewReferrerSourceInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceHighlight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */