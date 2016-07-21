package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialUpdateAnalytics
  implements FissileDataModel<SocialUpdateAnalytics>, RecordTemplate<SocialUpdateAnalytics>
{
  public static final SocialUpdateAnalyticsBuilder BUILDER = SocialUpdateAnalyticsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasObjectUrn;
  public final boolean hasTrackingId;
  public final boolean hasValue;
  public final Urn objectUrn;
  public final String trackingId;
  public final Value value;
  
  SocialUpdateAnalytics(Value paramValue, String paramString, Urn paramUrn1, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    value = paramValue;
    trackingId = paramString;
    entityUrn = paramUrn1;
    objectUrn = paramUrn2;
    hasValue = paramBoolean1;
    hasTrackingId = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    hasObjectUrn = paramBoolean4;
    paramValue = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  private SocialUpdateAnalytics accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Value localValue = null;
    boolean bool = false;
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label184;
      }
      localValue = value.accept(paramDataProcessor);
      if (localValue == null) {
        break label201;
      }
    }
    label184:
    label201:
    for (bool = true;; bool = false)
    {
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      UrnCoercer localUrnCoercer;
      if (hasEntityUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("entityUrn");
        localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
      }
      if (hasObjectUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("objectUrn");
        localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label297;
      }
      try
      {
        if (hasValue) {
          break label206;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialUpdateAnalytics", "value");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localValue = (Value)paramDataProcessor.processDataTemplate(value);
      break;
    }
    label206:
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialUpdateAnalytics", "trackingId");
    }
    if (!hasEntityUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialUpdateAnalytics", "entityUrn");
    }
    if (!hasObjectUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialUpdateAnalytics", "objectUrn");
    }
    return new SocialUpdateAnalytics(localValue, trackingId, entityUrn, objectUrn, bool, hasTrackingId, hasEntityUrn, hasObjectUrn);
    label297:
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
      paramObject = (SocialUpdateAnalytics)paramObject;
      if (value != null)
      {
        if (value.equals(value)) {}
      }
      else {
        while (value != null) {
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
      if (objectUrn == null) {
        break;
      }
    } while (objectUrn.equals(objectUrn));
    for (;;)
    {
      return false;
      if (objectUrn == null) {
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
    if (hasValue) {
      if (value._cachedId == null) {
        break label147;
      }
    }
    label147:
    for (i = PegasusBinaryUtils.getEncodedLength(value._cachedId) + 9;; i = value.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasTrackingId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
      }
      j = i + 1;
      i = j;
      UrnCoercer localUrnCoercer;
      if (hasEntityUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
      }
      j = i + 1;
      i = j;
      if (hasObjectUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (value != null)
    {
      i = value.hashCode();
      if (entityUrn == null) {
        break label87;
      }
    }
    label87:
    for (int j = entityUrn.hashCode();; j = 0)
    {
      if (objectUrn != null) {
        k = objectUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialUpdateAnalytics");
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
    label196:
    label230:
    label332:
    label342:
    label352:
    label360:
    label362:
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
        localByteBuffer.putInt(-629411327);
        if (hasValue)
        {
          localByteBuffer.put((byte)1);
          if (value._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, value._cachedId);
            value.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTrackingId) {
              break label332;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, trackingId);
            if (!hasEntityUrn) {
              break label342;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
            if (!hasObjectUrn) {
              break label352;
            }
            localByteBuffer.put((byte)1);
            localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label360;
          }
          if (str != null) {
            break label362;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          value.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)0);
          break label230;
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
  
  public static final class Value
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
    
    Value(ReachStatistics paramReachStatistics, SocialGestureHighlights paramSocialGestureHighlights, SuggestedArticles paramSuggestedArticles, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialUpdateAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */