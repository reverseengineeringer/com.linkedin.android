package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialUpdateAnalytics$Value
  implements FissileDataModel<Value>, UnionTemplate<Value>
{
  public static final SocialUpdateAnalyticsBuilder.ValueBuilder BUILDER = SocialUpdateAnalyticsBuilder.ValueBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasReachStatisticsValue;
  public final boolean hasSocialGestureHighlightsValue;
  public final boolean hasSuggestedArticlesValue;
  public final ReachStatistics reachStatisticsValue;
  public final SocialGestureHighlights socialGestureHighlightsValue;
  public final SuggestedArticles suggestedArticlesValue;
  
  SocialUpdateAnalytics$Value(ReachStatistics paramReachStatistics, SocialGestureHighlights paramSocialGestureHighlights, SuggestedArticles paramSuggestedArticles, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    reachStatisticsValue = paramReachStatistics;
    socialGestureHighlightsValue = paramSocialGestureHighlights;
    suggestedArticlesValue = paramSuggestedArticles;
    hasReachStatisticsValue = paramBoolean1;
    hasSocialGestureHighlightsValue = paramBoolean2;
    hasSuggestedArticlesValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final Value accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasReachStatisticsValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.socialUpdateAnalytics.ReachStatistics");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = reachStatisticsValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label205;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasSocialGestureHighlightsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlights");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label214;
        }
        localObject1 = socialGestureHighlightsValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label232;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasSuggestedArticlesValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.socialUpdateAnalytics.SuggestedArticles");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label241;
        }
        localObject1 = suggestedArticlesValue.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label259;
        }
      }
    }
    label205:
    label214:
    label232:
    label241:
    label259:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label265;
      }
      return new Value((ReachStatistics)localObject2, (SocialGestureHighlights)localObject3, (SuggestedArticles)localObject1, bool1, bool2, bool3);
      localObject1 = (ReachStatistics)paramDataProcessor.processDataTemplate(reachStatisticsValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SocialGestureHighlights)paramDataProcessor.processDataTemplate(socialGestureHighlightsValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (SuggestedArticles)paramDataProcessor.processDataTemplate(suggestedArticlesValue);
      break label146;
    }
    label265:
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
      paramObject = (Value)paramObject;
      if (reachStatisticsValue != null)
      {
        if (reachStatisticsValue.equals(reachStatisticsValue)) {}
      }
      else {
        while (reachStatisticsValue != null) {
          return false;
        }
      }
      if (socialGestureHighlightsValue != null)
      {
        if (socialGestureHighlightsValue.equals(socialGestureHighlightsValue)) {}
      }
      else {
        while (socialGestureHighlightsValue != null) {
          return false;
        }
      }
      if (suggestedArticlesValue == null) {
        break;
      }
    } while (suggestedArticlesValue.equals(suggestedArticlesValue));
    for (;;)
    {
      return false;
      if (suggestedArticlesValue == null) {
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
    if (hasReachStatisticsValue)
    {
      if (reachStatisticsValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(reachStatisticsValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasSocialGestureHighlightsValue)
      {
        i = j + 1;
        if (socialGestureHighlightsValue._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialGestureHighlightsValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasSuggestedArticlesValue)
      {
        i = j + 1;
        if (suggestedArticlesValue._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(suggestedArticlesValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = reachStatisticsValue.getSerializedSize() + 7;
      break;
      label156:
      i += socialGestureHighlightsValue.getSerializedSize();
      break label93;
      label169:
      i += suggestedArticlesValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (reachStatisticsValue != null)
    {
      i = reachStatisticsValue.hashCode();
      if (socialGestureHighlightsValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = socialGestureHighlightsValue.hashCode();; j = 0)
    {
      if (suggestedArticlesValue != null) {
        k = suggestedArticlesValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Value");
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
    label230:
    label358:
    label383:
    label393:
    label418:
    label426:
    label428:
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
        localByteBuffer.putInt(-1176001595);
        if (hasReachStatisticsValue)
        {
          localByteBuffer.put((byte)1);
          if (reachStatisticsValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, reachStatisticsValue._cachedId);
            reachStatisticsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSocialGestureHighlightsValue) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (socialGestureHighlightsValue._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, socialGestureHighlightsValue._cachedId);
            socialGestureHighlightsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSuggestedArticlesValue) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (suggestedArticlesValue._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, suggestedArticlesValue._cachedId);
            suggestedArticlesValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label426;
          }
          if (str != null) {
            break label428;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          reachStatisticsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          socialGestureHighlightsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          suggestedArticlesValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialUpdateAnalytics.Value
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */