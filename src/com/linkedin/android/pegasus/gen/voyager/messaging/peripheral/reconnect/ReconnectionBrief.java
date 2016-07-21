package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ReconnectionBrief
  implements FissileDataModel<ReconnectionBrief>, RecordTemplate<ReconnectionBrief>
{
  public static final ReconnectionBriefBuilder BUILDER = ReconnectionBriefBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn briefUrn;
  public final boolean hasBriefUrn;
  public final boolean hasImage;
  public final boolean hasLink;
  public final boolean hasSource;
  public final boolean hasText;
  public final boolean hasType;
  public final Image image;
  public final String link;
  public final ReconnectionBriefSource source;
  public final AttributedText text;
  public final ReconnectionBriefType type;
  
  ReconnectionBrief(ReconnectionBriefType paramReconnectionBriefType, Urn paramUrn, AttributedText paramAttributedText, Image paramImage, String paramString, ReconnectionBriefSource paramReconnectionBriefSource, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    type = paramReconnectionBriefType;
    briefUrn = paramUrn;
    text = paramAttributedText;
    image = paramImage;
    link = paramString;
    source = paramReconnectionBriefSource;
    hasType = paramBoolean1;
    hasBriefUrn = paramBoolean2;
    hasText = paramBoolean3;
    hasImage = paramBoolean4;
    hasLink = paramBoolean5;
    hasSource = paramBoolean6;
    _cachedId = null;
  }
  
  public final ReconnectionBrief accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    Object localObject1;
    if (hasBriefUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("briefUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(briefUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label114:
    Object localObject3;
    boolean bool2;
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label299;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasImage)
      {
        paramDataProcessor.startRecordField$505cff1c("image");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label308;
        }
        localObject1 = image.accept(paramDataProcessor);
        label153:
        if (localObject1 == null) {
          break label326;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label164:
      if (hasLink)
      {
        paramDataProcessor.startRecordField$505cff1c("link");
        paramDataProcessor.processString(link);
      }
      localObject1 = null;
      bool3 = false;
      if (hasSource)
      {
        paramDataProcessor.startRecordField$505cff1c("source");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label335;
        }
        localObject1 = source.accept(paramDataProcessor);
        label229:
        if (localObject1 == null) {
          break label353;
        }
      }
    }
    label299:
    label308:
    label326:
    label335:
    label353:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label420;
      }
      try
      {
        if (hasType) {
          break label359;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionBrief", "type");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(text);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break label153;
      bool2 = false;
      localObject3 = localObject1;
      break label164;
      localObject1 = (ReconnectionBriefSource)paramDataProcessor.processDataTemplate(source);
      break label229;
    }
    label359:
    if (!hasText) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionBrief", "text");
    }
    return new ReconnectionBrief(type, briefUrn, (AttributedText)localObject2, (Image)localObject3, link, (ReconnectionBriefSource)localObject1, hasType, hasBriefUrn, bool1, bool2, hasLink, bool3);
    label420:
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
      paramObject = (ReconnectionBrief)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (briefUrn != null)
      {
        if (briefUrn.equals(briefUrn)) {}
      }
      else {
        while (briefUrn != null) {
          return false;
        }
      }
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (image != null)
      {
        if (image.equals(image)) {}
      }
      else {
        while (image != null) {
          return false;
        }
      }
      if (link != null)
      {
        if (link.equals(link)) {}
      }
      else {
        while (link != null) {
          return false;
        }
      }
      if (source == null) {
        break;
      }
    } while (source.equals(source));
    for (;;)
    {
      return false;
      if (source == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasBriefUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(briefUrn));
    }
    j = i + 1;
    i = j;
    if (hasText)
    {
      i = j + 1;
      if (text._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(text._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasImage)
      {
        i = j + 1;
        if (image._cachedId == null) {
          break label236;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
      label149:
      j = i + 1;
      i = j;
      if (hasLink) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(link);
      }
      j = i + 1;
      i = j;
      if (hasSource)
      {
        i = j + 1;
        if (source._cachedId == null) {
          break label249;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(source._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += text.getSerializedSize();
      break;
      label236:
      i += image.getSerializedSize();
      break label149;
      label249:
      i += source.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (type != null)
    {
      i = type.hashCode();
      if (briefUrn == null) {
        break label154;
      }
      j = briefUrn.hashCode();
      if (text == null) {
        break label159;
      }
      k = text.hashCode();
      if (image == null) {
        break label164;
      }
      m = image.hashCode();
      label76:
      if (link == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = link.hashCode();; n = 0)
    {
      if (source != null) {
        i1 = source.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ReconnectionBrief");
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
    label173:
    label233:
    label293:
    label319:
    label422:
    label432:
    label457:
    label467:
    label492:
    label502:
    label512:
    label537:
    label545:
    label547:
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
        localByteBuffer.putInt(354289777);
        if (hasType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasBriefUrn) {
            break label422;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(briefUrn));
          if (!hasText) {
            break label457;
          }
          localByteBuffer.put((byte)1);
          if (text._cachedId == null) {
            break label432;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
          text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasImage) {
            break label492;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label467;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasLink) {
            break label502;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, link);
          if (!hasSource) {
            break label537;
          }
          localByteBuffer.put((byte)1);
          if (source._cachedId == null) {
            break label512;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, source._cachedId);
          source.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label545;
          }
          if (str != null) {
            break label547;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label173;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label233;
          localByteBuffer.put((byte)0);
          break label233;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label293;
          localByteBuffer.put((byte)0);
          break label293;
          localByteBuffer.put((byte)0);
          break label319;
          localByteBuffer.put((byte)1);
          source.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionBrief
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */