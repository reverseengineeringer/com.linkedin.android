package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
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

public final class AggregatedFollowRecommendationUpdate
  implements FissileDataModel<AggregatedFollowRecommendationUpdate>, RecordTemplate<AggregatedFollowRecommendationUpdate>
{
  public static final AggregatedFollowRecommendationUpdateBuilder BUILDER = AggregatedFollowRecommendationUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final List<Update> followRecommendationUpdates;
  public final boolean hasActions;
  public final boolean hasFollowRecommendationUpdates;
  public final boolean hasRecommendationText;
  public final AttributedText recommendationText;
  
  AggregatedFollowRecommendationUpdate(List<UpdateAction> paramList, List<Update> paramList1, AttributedText paramAttributedText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null)
    {
      paramList = null;
      actions = paramList;
      if (paramList1 != null) {
        break label73;
      }
    }
    label73:
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList1))
    {
      followRecommendationUpdates = paramList;
      recommendationText = paramAttributedText;
      hasActions = paramBoolean1;
      hasFollowRecommendationUpdates = paramBoolean2;
      hasRecommendationText = paramBoolean3;
      _cachedId = null;
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final AggregatedFollowRecommendationUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    boolean bool2;
    if (hasActions)
    {
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = actions.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (UpdateAction)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((UpdateAction)localObject2).accept(paramDataProcessor);; localObject2 = (UpdateAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      localObject3 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasFollowRecommendationUpdates) {
        break label365;
      }
      paramDataProcessor.startRecordField$505cff1c("followRecommendationUpdates");
      followRecommendationUpdates.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = followRecommendationUpdates.iterator();
      label253:
      if (!localIterator.hasNext()) {
        break label347;
      }
      localObject3 = (Update)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label331;
      }
    }
    label331:
    for (Object localObject3 = ((Update)localObject3).accept(paramDataProcessor);; localObject3 = (Update)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label253;
      bool1 = false;
      break;
    }
    label347:
    paramDataProcessor.endArray();
    if (localObject2 != null)
    {
      bool2 = true;
      localObject3 = localObject2;
      label365:
      localObject2 = null;
      bool3 = false;
      if (hasRecommendationText)
      {
        paramDataProcessor.startRecordField$505cff1c("recommendationText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label479;
        }
        localObject2 = recommendationText.accept(paramDataProcessor);
        label405:
        if (localObject2 == null) {
          break label497;
        }
      }
    }
    label479:
    label497:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label622;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasFollowRecommendationUpdates) {
          break label503;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedFollowRecommendationUpdate", "followRecommendationUpdates");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool2 = false;
      localObject3 = localObject2;
      break;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(recommendationText);
      break label405;
    }
    label503:
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedFollowRecommendationUpdate", "actions");
        }
      }
    }
    if (followRecommendationUpdates != null)
    {
      paramDataProcessor = followRecommendationUpdates.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Update)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedFollowRecommendationUpdate", "followRecommendationUpdates");
        }
      }
    }
    return new AggregatedFollowRecommendationUpdate((List)localObject1, (List)localObject3, (AttributedText)localObject2, bool1, bool2, bool3);
    label622:
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
      paramObject = (AggregatedFollowRecommendationUpdate)paramObject;
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (followRecommendationUpdates != null)
      {
        if (followRecommendationUpdates.equals(followRecommendationUpdates)) {}
      }
      else {
        while (followRecommendationUpdates != null) {
          return false;
        }
      }
      if (recommendationText == null) {
        break;
      }
    } while (recommendationText.equals(recommendationText));
    for (;;)
    {
      return false;
      if (recommendationText == null) {
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
    Iterator localIterator;
    Object localObject;
    if (hasActions)
    {
      i += 2;
      localIterator = actions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (UpdateAction)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((UpdateAction)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasFollowRecommendationUpdates)
    {
      i += 2;
      localIterator = followRecommendationUpdates.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Update)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Update)localObject).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasRecommendationText)
    {
      i = j + 1;
      if (recommendationText._cachedId == null) {
        break label241;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(recommendationText._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label241:
      i += recommendationText.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (actions != null)
    {
      i = actions.hashCode();
      if (followRecommendationUpdates == null) {
        break label91;
      }
    }
    label91:
    for (int j = followRecommendationUpdates.hashCode();; j = 0)
    {
      if (recommendationText != null) {
        k = recommendationText.hashCode();
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
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AggregatedFollowRecommendationUpdate");
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
    label512:
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
        localByteBuffer.putInt(-909066812);
        Iterator localIterator;
        Object localObject;
        if (hasActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          localIterator = actions.iterator();
          while (localIterator.hasNext())
          {
            localObject = (UpdateAction)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((UpdateAction)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((UpdateAction)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasFollowRecommendationUpdates)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, followRecommendationUpdates.size());
          localIterator = followRecommendationUpdates.iterator();
          while (localIterator.hasNext())
          {
            localObject = (Update)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((Update)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((Update)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasRecommendationText)
        {
          localByteBuffer.put((byte)1);
          if (recommendationText._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, recommendationText._cachedId);
            recommendationText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label512;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          recommendationText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.AggregatedFollowRecommendationUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */