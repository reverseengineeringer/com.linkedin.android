package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class RecommendedChannel
  implements FissileDataModel<RecommendedChannel>, RecordTemplate<RecommendedChannel>
{
  public static final RecommendedChannelBuilder BUILDER = RecommendedChannelBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Channel channel;
  public final boolean hasChannel;
  public final boolean hasObjectUrn;
  public final boolean hasReason;
  public final boolean hasTrackingId;
  public final Urn objectUrn;
  public final AnnotatedText reason;
  public final String trackingId;
  
  RecommendedChannel(String paramString, Urn paramUrn, Channel paramChannel, AnnotatedText paramAnnotatedText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    trackingId = paramString;
    objectUrn = paramUrn;
    channel = paramChannel;
    reason = paramAnnotatedText;
    hasTrackingId = paramBoolean1;
    hasObjectUrn = paramBoolean2;
    hasChannel = paramBoolean3;
    hasReason = paramBoolean4;
    _cachedId = null;
  }
  
  public final RecommendedChannel accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    Object localObject1;
    if (hasObjectUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("objectUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasChannel)
    {
      paramDataProcessor.startRecordField$505cff1c("channel");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = channel.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label114:
      localObject1 = null;
      bool2 = false;
      if (hasReason)
      {
        paramDataProcessor.startRecordField$505cff1c("reason");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label231;
        }
        localObject1 = reason.accept(paramDataProcessor);
        label153:
        if (localObject1 == null) {
          break label249;
        }
      }
    }
    label222:
    label231:
    label249:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label284;
      }
      try
      {
        if (hasChannel) {
          break label254;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedChannel", "channel");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Channel)paramDataProcessor.processDataTemplate(channel);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(reason);
      break label153;
    }
    label254:
    return new RecommendedChannel(trackingId, objectUrn, (Channel)localObject2, (AnnotatedText)localObject1, hasTrackingId, hasObjectUrn, bool1, bool2);
    label284:
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
      paramObject = (RecommendedChannel)paramObject;
      if (objectUrn != null)
      {
        if (objectUrn.equals(objectUrn)) {}
      }
      else {
        while (objectUrn != null) {
          return false;
        }
      }
      if (channel != null)
      {
        if (channel.equals(channel)) {}
      }
      else {
        while (channel != null) {
          return false;
        }
      }
      if (reason == null) {
        break;
      }
    } while (reason.equals(reason));
    for (;;)
    {
      return false;
      if (reason == null) {
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
    if (hasTrackingId) {
      i = PegasusBinaryUtils.getEncodedLength(trackingId) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasObjectUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    j = i + 1;
    i = j;
    if (hasChannel)
    {
      i = j + 1;
      if (channel._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(channel._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasReason)
      {
        i = j + 1;
        if (reason._cachedId == null) {
          break label174;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(reason._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += channel.getSerializedSize();
      break;
      label174:
      i += reason.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (objectUrn != null)
    {
      i = objectUrn.hashCode();
      if (channel == null) {
        break label87;
      }
    }
    label87:
    for (int j = channel.hashCode();; j = 0)
    {
      if (reason != null) {
        k = reason.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RecommendedChannel");
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
    label170:
    label230:
    label333:
    label343:
    label368:
    label378:
    label403:
    label411:
    label413:
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
        localByteBuffer.putInt(-2062216166);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasObjectUrn) {
            break label333;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          if (!hasChannel) {
            break label368;
          }
          localByteBuffer.put((byte)1);
          if (channel._cachedId == null) {
            break label343;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, channel._cachedId);
          channel.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasReason) {
            break label403;
          }
          localByteBuffer.put((byte)1);
          if (reason._cachedId == null) {
            break label378;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, reason._cachedId);
          reason.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label411;
          }
          if (str != null) {
            break label413;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)1);
          channel.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          reason.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedChannel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */