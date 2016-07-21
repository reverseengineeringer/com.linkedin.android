package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class RichText
  implements FissileDataModel<RichText>, RecordTemplate<RichText>
{
  public static final RichTextBuilder BUILDER = RichTextBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String embedHtml;
  public final Urn externalId;
  public final String externalUrl;
  public final boolean hasEmbedHtml;
  public final boolean hasExternalId;
  public final boolean hasExternalUrl;
  public final boolean hasHeight;
  public final boolean hasPreviewImages;
  public final boolean hasUrl;
  public final boolean hasWidth;
  public final int height;
  public final List<MediaProxyImage> previewImages;
  public final String url;
  public final int width;
  
  RichText(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, Urn paramUrn, List<MediaProxyImage> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    embedHtml = paramString1;
    url = paramString2;
    width = paramInt1;
    height = paramInt2;
    externalUrl = paramString3;
    externalId = paramUrn;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      previewImages = paramString1;
      hasEmbedHtml = paramBoolean1;
      hasUrl = paramBoolean2;
      hasWidth = paramBoolean3;
      hasHeight = paramBoolean4;
      hasExternalUrl = paramBoolean5;
      hasExternalId = paramBoolean6;
      hasPreviewImages = paramBoolean7;
      _cachedId = null;
      return;
    }
  }
  
  public final RichText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEmbedHtml)
    {
      paramDataProcessor.startRecordField$505cff1c("embedHtml");
      paramDataProcessor.processString(embedHtml);
    }
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    if (hasWidth)
    {
      paramDataProcessor.startRecordField$505cff1c("width");
      paramDataProcessor.processInt(width);
    }
    if (hasHeight)
    {
      paramDataProcessor.startRecordField$505cff1c("height");
      paramDataProcessor.processInt(height);
    }
    if (hasExternalUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("externalUrl");
      paramDataProcessor.processString(externalUrl);
    }
    if (hasExternalId)
    {
      paramDataProcessor.startRecordField$505cff1c("externalId");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(externalId));
    }
    Object localObject = null;
    MediaProxyImage localMediaProxyImage = null;
    boolean bool = false;
    if (hasPreviewImages)
    {
      paramDataProcessor.startRecordField$505cff1c("previewImages");
      previewImages.size();
      paramDataProcessor.startArray$13462e();
      localObject = localMediaProxyImage;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = previewImages.iterator();
      if (localIterator.hasNext())
      {
        localMediaProxyImage = (MediaProxyImage)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localMediaProxyImage = localMediaProxyImage.accept(paramDataProcessor);; localMediaProxyImage = (MediaProxyImage)paramDataProcessor.processDataTemplate(localMediaProxyImage))
        {
          if ((localObject != null) && (localMediaProxyImage != null)) {
            ((List)localObject).add(localMediaProxyImage);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label427;
      }
    }
    label427:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label491;
      }
      if (!hasPreviewImages) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (previewImages == null) {
          break;
        }
        paramDataProcessor = previewImages.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((MediaProxyImage)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.RichText", "previewImages");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    return new RichText(embedHtml, url, width, height, externalUrl, externalId, (List)localObject, hasEmbedHtml, hasUrl, hasWidth, hasHeight, hasExternalUrl, hasExternalId, bool);
    label491:
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
      paramObject = (RichText)paramObject;
      if (embedHtml != null)
      {
        if (embedHtml.equals(embedHtml)) {}
      }
      else {
        while (embedHtml != null) {
          return false;
        }
      }
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (width != width) {
        return false;
      }
      if (height != height) {
        return false;
      }
      if (externalUrl != null)
      {
        if (externalUrl.equals(externalUrl)) {}
      }
      else {
        while (externalUrl != null) {
          return false;
        }
      }
      if (externalId != null)
      {
        if (externalId.equals(externalId)) {}
      }
      else {
        while (externalId != null) {
          return false;
        }
      }
      if (previewImages == null) {
        break;
      }
    } while (previewImages.equals(previewImages));
    for (;;)
    {
      return false;
      if (previewImages == null) {
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
    if (hasEmbedHtml) {
      i = PegasusBinaryUtils.getEncodedLength(embedHtml) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
    }
    j = i + 1;
    i = j;
    if (hasWidth) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasHeight) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasExternalUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(externalUrl);
    }
    j = i + 1;
    i = j;
    Object localObject;
    if (hasExternalId)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(externalId));
    }
    i += 1;
    j = i;
    if (hasPreviewImages)
    {
      i += 2;
      localObject = previewImages.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        MediaProxyImage localMediaProxyImage = (MediaProxyImage)((Iterator)localObject).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localMediaProxyImage.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
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
    int i1;
    int i2;
    int k;
    if (embedHtml != null)
    {
      i = embedHtml.hashCode();
      if (url == null) {
        break label158;
      }
      j = url.hashCode();
      i1 = width;
      i2 = height;
      if (externalUrl == null) {
        break label163;
      }
      k = externalUrl.hashCode();
      label72:
      if (externalId == null) {
        break label168;
      }
    }
    label158:
    label163:
    label168:
    for (int m = externalId.hashCode();; m = 0)
    {
      if (previewImages != null) {
        n = previewImages.hashCode();
      }
      i = (m + (k + (((j + (i + 527) * 31) * 31 + i1) * 31 + i2) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label72;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RichText");
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
    label163:
    label187:
    label211:
    label237:
    label271:
    label388:
    label398:
    label408:
    label418:
    label428:
    label461:
    label468:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1477196542);
        Object localObject;
        if (hasEmbedHtml)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, embedHtml);
          if (!hasUrl) {
            break label388;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasWidth) {
            break label398;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(width);
          if (!hasHeight) {
            break label408;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(height);
          if (!hasExternalUrl) {
            break label418;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, externalUrl);
          if (!hasExternalId) {
            break label428;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(externalId));
          if (!hasPreviewImages) {
            break label461;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, previewImages.size());
          localObject = previewImages.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label468;
          }
          MediaProxyImage localMediaProxyImage = (MediaProxyImage)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localMediaProxyImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label163;
            localByteBuffer.put((byte)0);
            break label187;
            localByteBuffer.put((byte)0);
            break label211;
            localByteBuffer.put((byte)0);
            break label237;
            localByteBuffer.put((byte)0);
            break label271;
          }
          localByteBuffer.put((byte)1);
          localMediaProxyImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.RichText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */