package com.linkedin.android.pegasus.gen.voyager.messaging.event.message;

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
import java.io.IOException;
import java.nio.ByteBuffer;

public final class StickerPack
  implements FissileDataModel<StickerPack>, RecordTemplate<StickerPack>
{
  public static final StickerPackBuilder BUILDER = StickerPackBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String author;
  public final Urn entityUrn;
  public final boolean hasAuthor;
  public final boolean hasEntityUrn;
  public final boolean hasHidden;
  public final boolean hasModifiedAt;
  public final boolean hasName;
  public final boolean hasPreviewSticker;
  public final boolean hidden;
  public final long modifiedAt;
  public final String name;
  public final Sticker previewSticker;
  
  StickerPack(Urn paramUrn, String paramString1, String paramString2, boolean paramBoolean1, Sticker paramSticker, long paramLong, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    entityUrn = paramUrn;
    name = paramString1;
    author = paramString2;
    hidden = paramBoolean1;
    previewSticker = paramSticker;
    modifiedAt = paramLong;
    hasEntityUrn = paramBoolean2;
    hasName = paramBoolean3;
    hasAuthor = paramBoolean4;
    hasHidden = paramBoolean5;
    hasPreviewSticker = paramBoolean6;
    hasModifiedAt = paramBoolean7;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private StickerPack accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    if (hasAuthor)
    {
      paramDataProcessor.startRecordField$505cff1c("author");
      paramDataProcessor.processString(author);
    }
    if (hasHidden)
    {
      paramDataProcessor.startRecordField$505cff1c("hidden");
      paramDataProcessor.processBoolean(hidden);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasPreviewSticker)
    {
      paramDataProcessor.startRecordField$505cff1c("previewSticker");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label225;
      }
      localObject = previewSticker.accept(paramDataProcessor);
      if (localObject == null) {
        break label242;
      }
    }
    label225:
    label242:
    for (bool = true;; bool = false)
    {
      if (hasModifiedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("modifiedAt");
        paramDataProcessor.processLong(modifiedAt);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label373;
      }
      try
      {
        if (hasEntityUrn) {
          break label247;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.StickerPack", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (Sticker)paramDataProcessor.processDataTemplate(previewSticker);
      break;
    }
    label247:
    if (!hasName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.StickerPack", "name");
    }
    if (!hasAuthor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.StickerPack", "author");
    }
    if (!hasPreviewSticker) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.StickerPack", "previewSticker");
    }
    if (!hasModifiedAt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.StickerPack", "modifiedAt");
    }
    return new StickerPack(entityUrn, name, author, hidden, (Sticker)localObject, modifiedAt, hasEntityUrn, hasName, hasAuthor, hasHidden, bool, hasModifiedAt);
    label373:
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
      paramObject = (StickerPack)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (author != null)
      {
        if (author.equals(author)) {}
      }
      else {
        while (author != null) {
          return false;
        }
      }
      if (hidden != hidden) {
        return false;
      }
      if (previewSticker != null)
      {
        if (previewSticker.equals(previewSticker)) {}
      }
      else {
        while (previewSticker != null) {
          return false;
        }
      }
    } while (modifiedAt == modifiedAt);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasAuthor) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(author);
    }
    j = i + 1;
    i = j;
    if (hasHidden) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasPreviewSticker)
    {
      i = j + 1;
      if (previewSticker._cachedId == null) {
        break label179;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(previewSticker._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasModifiedAt) {
        i = j + 8;
      }
      __sizeOfObject = i;
      return i;
      label179:
      i += previewSticker.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (name == null) {
        break label143;
      }
      j = name.hashCode();
      if (author == null) {
        break label148;
      }
      k = author.hashCode();
      label60:
      if (!hidden) {
        break label153;
      }
    }
    label143:
    label148:
    label153:
    for (int m = 1;; m = 0)
    {
      if (previewSticker != null) {
        n = previewSticker.hashCode();
      }
      i = ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n) * 31 + (int)(modifiedAt ^ modifiedAt >>> 32);
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building StickerPack");
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
    label196:
    label220:
    label229:
    label289:
    label356:
    label366:
    label376:
    label382:
    label392:
    label417:
    label427:
    label435:
    label437:
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
        localByteBuffer.putInt(-15353939);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label356;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasAuthor) {
            break label366;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, author);
          if (!hasHidden) {
            break label382;
          }
          localByteBuffer.put((byte)1);
          if (!hidden) {
            break label376;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasPreviewSticker) {
            break label417;
          }
          localByteBuffer.put((byte)1);
          if (previewSticker._cachedId == null) {
            break label392;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, previewSticker._cachedId);
          previewSticker.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasModifiedAt) {
            break label427;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(modifiedAt);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label435;
          }
          if (str != null) {
            break label437;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label196;
          i = 0;
          break label220;
          localByteBuffer.put((byte)0);
          break label229;
          localByteBuffer.put((byte)1);
          previewSticker.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label289;
          localByteBuffer.put((byte)0);
          break label289;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.StickerPack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */