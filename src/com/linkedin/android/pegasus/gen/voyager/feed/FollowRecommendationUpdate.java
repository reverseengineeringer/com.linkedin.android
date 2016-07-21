package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedEntity;
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

public final class FollowRecommendationUpdate
  implements FissileDataModel<FollowRecommendationUpdate>, RecordTemplate<FollowRecommendationUpdate>
{
  public static final FollowRecommendationUpdateBuilder BUILDER = FollowRecommendationUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final boolean hasActions;
  public final boolean hasRecommendation;
  public final boolean hasRecommendationText;
  public final RecommendedEntity recommendation;
  public final AttributedText recommendationText;
  
  FollowRecommendationUpdate(List<UpdateAction> paramList, RecommendedEntity paramRecommendedEntity, AttributedText paramAttributedText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      actions = paramList;
      recommendation = paramRecommendedEntity;
      recommendationText = paramAttributedText;
      hasActions = paramBoolean1;
      hasRecommendation = paramBoolean2;
      hasRecommendationText = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final FollowRecommendationUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject3;
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
      int i = 0;
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
      bool2 = false;
      if (hasRecommendation)
      {
        paramDataProcessor.startRecordField$505cff1c("recommendation");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label343;
        }
        localObject2 = recommendation.accept(paramDataProcessor);
        label222:
        if (localObject2 == null) {
          break label361;
        }
        bool2 = true;
        localObject3 = localObject2;
      }
      label234:
      localObject2 = null;
      bool3 = false;
      if (hasRecommendationText)
      {
        paramDataProcessor.startRecordField$505cff1c("recommendationText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label371;
        }
        localObject2 = recommendationText.accept(paramDataProcessor);
        label274:
        if (localObject2 == null) {
          break label389;
        }
      }
    }
    label343:
    label361:
    label371:
    label389:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label464;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasRecommendation) {
          break label395;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.FollowRecommendationUpdate", "recommendation");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (RecommendedEntity)paramDataProcessor.processDataTemplate(recommendation);
      break label222;
      bool2 = false;
      localObject3 = localObject2;
      break label234;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(recommendationText);
      break label274;
    }
    label395:
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.FollowRecommendationUpdate", "actions");
        }
      }
    }
    return new FollowRecommendationUpdate((List)localObject1, (RecommendedEntity)localObject3, (AttributedText)localObject2, bool1, bool2, bool3);
    label464:
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
      paramObject = (FollowRecommendationUpdate)paramObject;
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (recommendation != null)
      {
        if (recommendation.equals(recommendation)) {}
      }
      else {
        while (recommendation != null) {
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
    if (hasActions)
    {
      i += 2;
      Iterator localIterator = actions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        UpdateAction localUpdateAction = (UpdateAction)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localUpdateAction.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasRecommendation)
    {
      i = j + 1;
      if (recommendation._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(recommendation._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasRecommendationText)
      {
        i = j + 1;
        if (recommendationText._cachedId == null) {
          break label208;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(recommendationText._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += recommendation.getSerializedSize();
      break;
      label208:
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
      if (recommendation == null) {
        break label89;
      }
    }
    label89:
    for (int j = recommendation.hashCode();; j = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FollowRecommendationUpdate");
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
    label435:
    label460:
    label468:
    label470:
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
        localByteBuffer.putInt(-1680538663);
        if (hasActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          Iterator localIterator = actions.iterator();
          while (localIterator.hasNext())
          {
            UpdateAction localUpdateAction = (UpdateAction)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localUpdateAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localUpdateAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasRecommendation)
        {
          localByteBuffer.put((byte)1);
          if (recommendation._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, recommendation._cachedId);
            recommendation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasRecommendationText) {
              break label460;
            }
            localByteBuffer.put((byte)1);
            if (recommendationText._cachedId == null) {
              break label435;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, recommendationText._cachedId);
            recommendationText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label468;
          }
          if (str != null) {
            break label470;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          recommendation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.FollowRecommendationUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */