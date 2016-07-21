package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Insight
  implements FissileDataModel<Insight>, RecordTemplate<Insight>
{
  public static final InsightBuilder BUILDER = InsightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final AttributedText body;
  public final boolean hasBody;
  public final boolean hasPreFilledText;
  public final boolean hasTitle;
  public final boolean hasTrackingId;
  public final boolean hasType;
  public final AttributedText preFilledText;
  public final AttributedText title;
  public final String trackingId;
  public final InsightType type;
  
  Insight(AttributedText paramAttributedText1, AttributedText paramAttributedText2, AttributedText paramAttributedText3, InsightType paramInsightType, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    title = paramAttributedText1;
    body = paramAttributedText2;
    preFilledText = paramAttributedText3;
    type = paramInsightType;
    trackingId = paramString;
    hasTitle = paramBoolean1;
    hasBody = paramBoolean2;
    hasPreFilledText = paramBoolean3;
    hasType = paramBoolean4;
    hasTrackingId = paramBoolean5;
    _cachedId = null;
  }
  
  private Insight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    boolean bool1 = false;
    AttributedText localAttributedText1;
    label56:
    AttributedText localAttributedText2;
    boolean bool2;
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localAttributedText1 = title.accept(paramDataProcessor);
        if (localAttributedText1 == null) {
          break label266;
        }
        bool1 = true;
        localObject = localAttributedText1;
      }
    }
    else
    {
      localAttributedText2 = null;
      bool2 = false;
      if (hasBody)
      {
        paramDataProcessor.startRecordField$505cff1c("body");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label275;
        }
        localAttributedText1 = body.accept(paramDataProcessor);
        label95:
        if (localAttributedText1 == null) {
          break label293;
        }
        bool2 = true;
        localAttributedText2 = localAttributedText1;
      }
      label106:
      localAttributedText1 = null;
      bool3 = false;
      if (hasPreFilledText)
      {
        paramDataProcessor.startRecordField$505cff1c("preFilledText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label302;
        }
        localAttributedText1 = preFilledText.accept(paramDataProcessor);
        label146:
        if (localAttributedText1 == null) {
          break label320;
        }
      }
    }
    label266:
    label275:
    label293:
    label302:
    label320:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasType)
      {
        paramDataProcessor.startRecordField$505cff1c("type");
        paramDataProcessor.processEnum(type);
      }
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label417;
      }
      try
      {
        if (hasTitle) {
          break label326;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localAttributedText1 = (AttributedText)paramDataProcessor.processDataTemplate(title);
      break;
      bool1 = false;
      localObject = localAttributedText1;
      break label56;
      localAttributedText1 = (AttributedText)paramDataProcessor.processDataTemplate(body);
      break label95;
      bool2 = false;
      localAttributedText2 = localAttributedText1;
      break label106;
      localAttributedText1 = (AttributedText)paramDataProcessor.processDataTemplate(preFilledText);
      break label146;
    }
    label326:
    if (!hasBody) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "body");
    }
    if (!hasType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "type");
    }
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "trackingId");
    }
    return new Insight((AttributedText)localObject, localAttributedText2, localAttributedText1, type, trackingId, bool1, bool2, bool3, hasType, hasTrackingId);
    label417:
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
      paramObject = (Insight)paramObject;
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (body != null)
      {
        if (body.equals(body)) {}
      }
      else {
        while (body != null) {
          return false;
        }
      }
      if (preFilledText != null)
      {
        if (preFilledText.equals(preFilledText)) {}
      }
      else {
        while (preFilledText != null) {
          return false;
        }
      }
      if (type == null) {
        break;
      }
    } while (type.equals(type));
    for (;;)
    {
      return false;
      if (type == null) {
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
    int j;
    if (hasTitle)
    {
      if (title._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(title._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasBody)
      {
        i = j + 1;
        if (body._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(body._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasPreFilledText)
      {
        i = j + 1;
        if (preFilledText._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(preFilledText._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasType) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasTrackingId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
      }
      __sizeOfObject = i;
      return i;
      i = title.getSerializedSize() + 7;
      break;
      label198:
      i += body.getSerializedSize();
      break label93;
      label211:
      i += preFilledText.getSerializedSize();
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
    if (title != null)
    {
      i = title.hashCode();
      if (body == null) {
        break label110;
      }
      j = body.hashCode();
      label45:
      if (preFilledText == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = preFilledText.hashCode();; k = 0)
    {
      if (type != null) {
        m = type.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Insight");
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
    label319:
    label413:
    label438:
    label448:
    label473:
    label483:
    label493:
    label501:
    label503:
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
        localByteBuffer.putInt(1261083046);
        if (hasTitle)
        {
          localByteBuffer.put((byte)1);
          if (title._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, title._cachedId);
            title.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasBody) {
              break label438;
            }
            localByteBuffer.put((byte)1);
            if (body._cachedId == null) {
              break label413;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, body._cachedId);
            body.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPreFilledText) {
              break label473;
            }
            localByteBuffer.put((byte)1);
            if (preFilledText._cachedId == null) {
              break label448;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, preFilledText._cachedId);
            preFilledText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasType) {
              break label483;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
            if (!hasTrackingId) {
              break label493;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, trackingId);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label501;
          }
          if (str != null) {
            break label503;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          title.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          body.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          preFilledText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)0);
          break label319;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<Insight>
  {
    public AttributedText body = null;
    public boolean hasBody = false;
    public boolean hasPreFilledText = false;
    public boolean hasTitle = false;
    public boolean hasTrackingId = false;
    public boolean hasType = false;
    public AttributedText preFilledText = null;
    public AttributedText title = null;
    public String trackingId = null;
    public InsightType type = null;
    
    public final Insight build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Insight.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Insight(title, body, preFilledText, type, trackingId, hasTitle, hasBody, hasPreFilledText, hasType, hasTrackingId);
        if (!hasTitle) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "title");
        }
        if (!hasBody) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "body");
        }
        if (!hasType) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "type");
        }
      } while (hasTrackingId);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight", "trackingId");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.Insight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */