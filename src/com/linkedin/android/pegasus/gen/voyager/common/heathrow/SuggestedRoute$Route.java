package com.linkedin.android.pegasus.gen.voyager.common.heathrow;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedRoute$Route
  implements FissileDataModel<Route>, UnionTemplate<Route>
{
  public static final SuggestedRouteBuilder.RouteBuilder BUILDER = SuggestedRouteBuilder.RouteBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AbiRoute abiRouteValue;
  public final FallbackRoute fallbackRouteValue;
  public final FeedRoute feedRouteValue;
  public final boolean hasAbiRouteValue;
  public final boolean hasFallbackRouteValue;
  public final boolean hasFeedRouteValue;
  public final boolean hasPymkRouteValue;
  public final PymkRoute pymkRouteValue;
  
  SuggestedRoute$Route(AbiRoute paramAbiRoute, PymkRoute paramPymkRoute, FeedRoute paramFeedRoute, FallbackRoute paramFallbackRoute, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    abiRouteValue = paramAbiRoute;
    pymkRouteValue = paramPymkRoute;
    feedRouteValue = paramFeedRoute;
    fallbackRouteValue = paramFallbackRoute;
    hasAbiRouteValue = paramBoolean1;
    hasPymkRouteValue = paramBoolean2;
    hasFeedRouteValue = paramBoolean3;
    hasFallbackRouteValue = paramBoolean4;
    _cachedId = null;
  }
  
  public final Route accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    if (hasAbiRouteValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.heathrow.AbiRoute");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = abiRouteValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label261;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasPymkRouteValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.heathrow.PymkRoute");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label270;
        }
        localObject1 = pymkRouteValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label288;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasFeedRouteValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.heathrow.FeedRoute");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label297;
        }
        localObject1 = feedRouteValue.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label315;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasFallbackRouteValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.heathrow.FallbackRoute");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label325;
        }
        localObject1 = fallbackRouteValue.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label343;
        }
      }
    }
    label261:
    label270:
    label288:
    label297:
    label315:
    label325:
    label343:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label349;
      }
      return new Route((AbiRoute)localObject2, (PymkRoute)localObject3, (FeedRoute)localObject4, (FallbackRoute)localObject1, bool1, bool2, bool3, bool4);
      localObject1 = (AbiRoute)paramDataProcessor.processDataTemplate(abiRouteValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (PymkRoute)paramDataProcessor.processDataTemplate(pymkRouteValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (FeedRoute)paramDataProcessor.processDataTemplate(feedRouteValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (FallbackRoute)paramDataProcessor.processDataTemplate(fallbackRouteValue);
      break label198;
    }
    label349:
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
      paramObject = (Route)paramObject;
      if (abiRouteValue != null)
      {
        if (abiRouteValue.equals(abiRouteValue)) {}
      }
      else {
        while (abiRouteValue != null) {
          return false;
        }
      }
      if (pymkRouteValue != null)
      {
        if (pymkRouteValue.equals(pymkRouteValue)) {}
      }
      else {
        while (pymkRouteValue != null) {
          return false;
        }
      }
      if (feedRouteValue != null)
      {
        if (feedRouteValue.equals(feedRouteValue)) {}
      }
      else {
        while (feedRouteValue != null) {
          return false;
        }
      }
      if (fallbackRouteValue == null) {
        break;
      }
    } while (fallbackRouteValue.equals(fallbackRouteValue));
    for (;;)
    {
      return false;
      if (fallbackRouteValue == null) {
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
    if (hasAbiRouteValue)
    {
      if (abiRouteValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(abiRouteValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasPymkRouteValue)
      {
        i = j + 1;
        if (pymkRouteValue._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(pymkRouteValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasFeedRouteValue)
      {
        i = j + 1;
        if (feedRouteValue._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(feedRouteValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasFallbackRouteValue)
      {
        i = j + 1;
        if (fallbackRouteValue._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(fallbackRouteValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = abiRouteValue.getSerializedSize() + 7;
      break;
      label198:
      i += pymkRouteValue.getSerializedSize();
      break label93;
      label211:
      i += feedRouteValue.getSerializedSize();
      break label135;
      label224:
      i += fallbackRouteValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (abiRouteValue != null)
    {
      i = abiRouteValue.hashCode();
      if (pymkRouteValue == null) {
        break label110;
      }
      j = pymkRouteValue.hashCode();
      label45:
      if (feedRouteValue == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = feedRouteValue.hashCode();; k = 0)
    {
      if (fallbackRouteValue != null) {
        m = fallbackRouteValue.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Route");
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
    label290:
    label418:
    label443:
    label453:
    label478:
    label488:
    label513:
    label521:
    label523:
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
        localByteBuffer.putInt(36859586);
        if (hasAbiRouteValue)
        {
          localByteBuffer.put((byte)1);
          if (abiRouteValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, abiRouteValue._cachedId);
            abiRouteValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPymkRouteValue) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (pymkRouteValue._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pymkRouteValue._cachedId);
            pymkRouteValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFeedRouteValue) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (feedRouteValue._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, feedRouteValue._cachedId);
            feedRouteValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFallbackRouteValue) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (fallbackRouteValue._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, fallbackRouteValue._cachedId);
            fallbackRouteValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label521;
          }
          if (str != null) {
            break label523;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          abiRouteValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          pymkRouteValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          feedRouteValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          fallbackRouteValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.heathrow.SuggestedRoute.Route
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */