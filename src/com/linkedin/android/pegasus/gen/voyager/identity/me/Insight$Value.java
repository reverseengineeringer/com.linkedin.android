package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJymbiiInsight;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlight;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Insight$Value
  implements FissileDataModel<Value>, UnionTemplate<Value>
{
  public static final InsightBuilder.ValueBuilder BUILDER = InsightBuilder.ValueBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ConnectionsInCommonInsight connectionsInCommonInsightValue;
  public final boolean hasConnectionsInCommonInsightValue;
  public final boolean hasNetworkHighlightValue;
  public final boolean hasSocialUpdateAnalyticsInsightValue;
  public final boolean hasWvmpJymbiiInsightValue;
  public final NetworkHighlight networkHighlightValue;
  public final SocialUpdateAnalyticsInsight socialUpdateAnalyticsInsightValue;
  public final WvmpJymbiiInsight wvmpJymbiiInsightValue;
  
  Insight$Value(NetworkHighlight paramNetworkHighlight, WvmpJymbiiInsight paramWvmpJymbiiInsight, ConnectionsInCommonInsight paramConnectionsInCommonInsight, SocialUpdateAnalyticsInsight paramSocialUpdateAnalyticsInsight, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    networkHighlightValue = paramNetworkHighlight;
    wvmpJymbiiInsightValue = paramWvmpJymbiiInsight;
    connectionsInCommonInsightValue = paramConnectionsInCommonInsight;
    socialUpdateAnalyticsInsightValue = paramSocialUpdateAnalyticsInsight;
    hasNetworkHighlightValue = paramBoolean1;
    hasWvmpJymbiiInsightValue = paramBoolean2;
    hasConnectionsInCommonInsightValue = paramBoolean3;
    hasSocialUpdateAnalyticsInsightValue = paramBoolean4;
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
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    if (hasNetworkHighlightValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.networkHighlights.NetworkHighlight");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = networkHighlightValue.accept(paramDataProcessor);
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
      if (hasWvmpJymbiiInsightValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.wvmpOverview.WvmpJymbiiInsight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label270;
        }
        localObject1 = wvmpJymbiiInsightValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label288;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasConnectionsInCommonInsightValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.ConnectionsInCommonInsight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label297;
        }
        localObject1 = connectionsInCommonInsightValue.accept(paramDataProcessor);
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
      if (hasSocialUpdateAnalyticsInsightValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.SocialUpdateAnalyticsInsight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label325;
        }
        localObject1 = socialUpdateAnalyticsInsightValue.accept(paramDataProcessor);
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
      return new Value((NetworkHighlight)localObject2, (WvmpJymbiiInsight)localObject3, (ConnectionsInCommonInsight)localObject4, (SocialUpdateAnalyticsInsight)localObject1, bool1, bool2, bool3, bool4);
      localObject1 = (NetworkHighlight)paramDataProcessor.processDataTemplate(networkHighlightValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (WvmpJymbiiInsight)paramDataProcessor.processDataTemplate(wvmpJymbiiInsightValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (ConnectionsInCommonInsight)paramDataProcessor.processDataTemplate(connectionsInCommonInsightValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (SocialUpdateAnalyticsInsight)paramDataProcessor.processDataTemplate(socialUpdateAnalyticsInsightValue);
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
      paramObject = (Value)paramObject;
      if (networkHighlightValue != null)
      {
        if (networkHighlightValue.equals(networkHighlightValue)) {}
      }
      else {
        while (networkHighlightValue != null) {
          return false;
        }
      }
      if (wvmpJymbiiInsightValue != null)
      {
        if (wvmpJymbiiInsightValue.equals(wvmpJymbiiInsightValue)) {}
      }
      else {
        while (wvmpJymbiiInsightValue != null) {
          return false;
        }
      }
      if (connectionsInCommonInsightValue != null)
      {
        if (connectionsInCommonInsightValue.equals(connectionsInCommonInsightValue)) {}
      }
      else {
        while (connectionsInCommonInsightValue != null) {
          return false;
        }
      }
      if (socialUpdateAnalyticsInsightValue == null) {
        break;
      }
    } while (socialUpdateAnalyticsInsightValue.equals(socialUpdateAnalyticsInsightValue));
    for (;;)
    {
      return false;
      if (socialUpdateAnalyticsInsightValue == null) {
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
    if (hasNetworkHighlightValue)
    {
      if (networkHighlightValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(networkHighlightValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasWvmpJymbiiInsightValue)
      {
        i = j + 1;
        if (wvmpJymbiiInsightValue._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpJymbiiInsightValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasConnectionsInCommonInsightValue)
      {
        i = j + 1;
        if (connectionsInCommonInsightValue._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(connectionsInCommonInsightValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasSocialUpdateAnalyticsInsightValue)
      {
        i = j + 1;
        if (socialUpdateAnalyticsInsightValue._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialUpdateAnalyticsInsightValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = networkHighlightValue.getSerializedSize() + 7;
      break;
      label198:
      i += wvmpJymbiiInsightValue.getSerializedSize();
      break label93;
      label211:
      i += connectionsInCommonInsightValue.getSerializedSize();
      break label135;
      label224:
      i += socialUpdateAnalyticsInsightValue.getSerializedSize();
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
    if (networkHighlightValue != null)
    {
      i = networkHighlightValue.hashCode();
      if (wvmpJymbiiInsightValue == null) {
        break label110;
      }
      j = wvmpJymbiiInsightValue.hashCode();
      label45:
      if (connectionsInCommonInsightValue == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = connectionsInCommonInsightValue.hashCode();; k = 0)
    {
      if (socialUpdateAnalyticsInsightValue != null) {
        m = socialUpdateAnalyticsInsightValue.hashCode();
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
        localByteBuffer.putInt(51850799);
        if (hasNetworkHighlightValue)
        {
          localByteBuffer.put((byte)1);
          if (networkHighlightValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, networkHighlightValue._cachedId);
            networkHighlightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasWvmpJymbiiInsightValue) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (wvmpJymbiiInsightValue._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, wvmpJymbiiInsightValue._cachedId);
            wvmpJymbiiInsightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasConnectionsInCommonInsightValue) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (connectionsInCommonInsightValue._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, connectionsInCommonInsightValue._cachedId);
            connectionsInCommonInsightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSocialUpdateAnalyticsInsightValue) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (socialUpdateAnalyticsInsightValue._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, socialUpdateAnalyticsInsightValue._cachedId);
            socialUpdateAnalyticsInsightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          networkHighlightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          wvmpJymbiiInsightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          connectionsInCommonInsightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          socialUpdateAnalyticsInsightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.Insight.Value
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */