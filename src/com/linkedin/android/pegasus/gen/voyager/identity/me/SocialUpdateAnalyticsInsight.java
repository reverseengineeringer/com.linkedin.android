package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialUpdateAnalyticsInsight
  implements FissileDataModel<SocialUpdateAnalyticsInsight>, RecordTemplate<SocialUpdateAnalyticsInsight>
{
  public static final SocialUpdateAnalyticsInsightBuilder BUILDER = SocialUpdateAnalyticsInsightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn entity;
  public final boolean hasEntity;
  public final boolean hasText;
  public final AttributedText text;
  
  SocialUpdateAnalyticsInsight(AttributedText paramAttributedText, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2)
  {
    text = paramAttributedText;
    entity = paramUrn;
    hasText = paramBoolean1;
    hasEntity = paramBoolean2;
    _cachedId = null;
  }
  
  public final SocialUpdateAnalyticsInsight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    AttributedText localAttributedText = null;
    boolean bool = false;
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label126;
      }
      localAttributedText = text.accept(paramDataProcessor);
      if (localAttributedText == null) {
        break label143;
      }
    }
    label126:
    label143:
    for (bool = true;; bool = false)
    {
      if (hasEntity)
      {
        paramDataProcessor.startRecordField$505cff1c("entity");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entity));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label185;
      }
      try
      {
        if (hasText) {
          break label148;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsInsight", "text");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localAttributedText = (AttributedText)paramDataProcessor.processDataTemplate(text);
      break;
    }
    label148:
    if (!hasEntity) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsInsight", "entity");
    }
    return new SocialUpdateAnalyticsInsight(localAttributedText, entity, bool, hasEntity);
    label185:
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
      paramObject = (SocialUpdateAnalyticsInsight)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (entity == null) {
        break;
      }
    } while (entity.equals(entity));
    for (;;)
    {
      return false;
      if (entity == null) {
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
    if (hasText) {
      if (text._cachedId == null) {
        break label90;
      }
    }
    label90:
    for (i = PegasusBinaryUtils.getEncodedLength(text._cachedId) + 9;; i = text.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasEntity)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entity));
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (text != null) {}
    for (int i = text.hashCode();; i = 0)
    {
      if (entity != null) {
        j = entity.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialUpdateAnalyticsInsight");
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
    label272:
    label280:
    label282:
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
        localByteBuffer.putInt(-488478446);
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          if (text._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
            text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEntity) {
              break label272;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entity));
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label280;
          }
          if (str != null) {
            break label282;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsInsight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */