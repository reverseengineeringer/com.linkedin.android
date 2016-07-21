package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType;
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

public final class SocialGestureHighlights
  implements FissileDataModel<SocialGestureHighlights>, RecordTemplate<SocialGestureHighlights>
{
  public static final SocialGestureHighlightsBuilder BUILDER = SocialGestureHighlightsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasHighlights;
  public final boolean hasSocialUpdateType;
  public final List<AnalyticsHighlight> highlights;
  public final SocialUpdateType socialUpdateType;
  
  SocialGestureHighlights(List<AnalyticsHighlight> paramList, SocialUpdateType paramSocialUpdateType, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      highlights = paramList;
      socialUpdateType = paramSocialUpdateType;
      hasHighlights = paramBoolean1;
      hasSocialUpdateType = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final SocialGestureHighlights accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    AnalyticsHighlight localAnalyticsHighlight = null;
    boolean bool = false;
    if (hasHighlights)
    {
      paramDataProcessor.startRecordField$505cff1c("highlights");
      highlights.size();
      paramDataProcessor.startArray$13462e();
      localObject = localAnalyticsHighlight;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = highlights.iterator();
      if (localIterator.hasNext())
      {
        localAnalyticsHighlight = (AnalyticsHighlight)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localAnalyticsHighlight = localAnalyticsHighlight.accept(paramDataProcessor);; localAnalyticsHighlight = (AnalyticsHighlight)paramDataProcessor.processDataTemplate(localAnalyticsHighlight))
        {
          if ((localObject != null) && (localAnalyticsHighlight != null)) {
            ((List)localObject).add(localAnalyticsHighlight);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label251;
      }
    }
    label251:
    for (bool = true;; bool = false)
    {
      if (hasSocialUpdateType)
      {
        paramDataProcessor.startRecordField$505cff1c("socialUpdateType");
        paramDataProcessor.processEnum(socialUpdateType);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label344;
      }
      try
      {
        if (hasHighlights) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlights", "highlights");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasSocialUpdateType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlights", "socialUpdateType");
    }
    if (highlights != null)
    {
      paramDataProcessor = highlights.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((AnalyticsHighlight)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlights", "highlights");
        }
      }
    }
    return new SocialGestureHighlights((List)localObject, socialUpdateType, bool, hasSocialUpdateType);
    label344:
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
      paramObject = (SocialGestureHighlights)paramObject;
      if (highlights != null)
      {
        if (highlights.equals(highlights)) {}
      }
      else {
        while (highlights != null) {
          return false;
        }
      }
      if (socialUpdateType == null) {
        break;
      }
    } while (socialUpdateType.equals(socialUpdateType));
    for (;;)
    {
      return false;
      if (socialUpdateType == null) {
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
    if (hasHighlights)
    {
      i += 2;
      Iterator localIterator = highlights.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        AnalyticsHighlight localAnalyticsHighlight = (AnalyticsHighlight)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localAnalyticsHighlight.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasSocialUpdateType) {
      i = j + 2;
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
    if (highlights != null) {}
    for (int i = highlights.hashCode();; i = 0)
    {
      if (socialUpdateType != null) {
        j = socialUpdateType.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialGestureHighlights");
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
    label319:
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
        localByteBuffer.putInt(1297589845);
        if (hasHighlights)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, highlights.size());
          Iterator localIterator = highlights.iterator();
          while (localIterator.hasNext())
          {
            AnalyticsHighlight localAnalyticsHighlight = (AnalyticsHighlight)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localAnalyticsHighlight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localAnalyticsHighlight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasSocialUpdateType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, socialUpdateType.ordinal());
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label319;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlights
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */