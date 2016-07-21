package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Link
  implements FissileDataModel<Link>, RecordTemplate<Link>
{
  public static final LinkBuilder BUILDER = LinkBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasHeight;
  public final boolean hasHtml;
  public final boolean hasPreviewImages;
  public final boolean hasUrl;
  public final boolean hasWidth;
  public final int height;
  public final String html;
  public final List<MediaProxyImage> previewImages;
  public final String url;
  public final int width;
  
  Link(String paramString1, String paramString2, int paramInt1, int paramInt2, List<MediaProxyImage> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    url = paramString1;
    html = paramString2;
    width = paramInt1;
    height = paramInt2;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      previewImages = paramString1;
      hasUrl = paramBoolean1;
      hasHtml = paramBoolean2;
      hasWidth = paramBoolean3;
      hasHeight = paramBoolean4;
      hasPreviewImages = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final Link accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    if (hasHtml)
    {
      paramDataProcessor.startRecordField$505cff1c("html");
      paramDataProcessor.processString(html);
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
        break label338;
      }
    }
    label338:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label436;
      }
      if (!hasPreviewImages) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (hasUrl) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Link", "url");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (previewImages != null)
    {
      paramDataProcessor = previewImages.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MediaProxyImage)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Link", "previewImages");
        }
      }
    }
    return new Link(url, html, width, height, (List)localObject, hasUrl, hasHtml, hasWidth, hasHeight, bool);
    label436:
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
      paramObject = (Link)paramObject;
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (html != null)
      {
        if (html.equals(html)) {}
      }
      else {
        while (html != null) {
          return false;
        }
      }
      if (width != width) {
        return false;
      }
      if (height != height) {
        return false;
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
    if (hasUrl) {
      i = PegasusBinaryUtils.getEncodedLength(url) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasHtml) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(html);
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
    i += 1;
    j = i;
    if (hasPreviewImages)
    {
      i += 2;
      Iterator localIterator = previewImages.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        MediaProxyImage localMediaProxyImage = (MediaProxyImage)localIterator.next();
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
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (url != null)
    {
      i = url.hashCode();
      if (html == null) {
        break label113;
      }
    }
    label113:
    for (int j = html.hashCode();; j = 0)
    {
      int m = width;
      int n = height;
      if (previewImages != null) {
        k = previewImages.hashCode();
      }
      i = (((j + (i + 527) * 31) * 31 + m) * 31 + n) * 31 + k;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Link");
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
    label162:
    label186:
    label210:
    label327:
    label337:
    label347:
    label380:
    label387:
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
        localByteBuffer.putInt(983498920);
        Iterator localIterator;
        if (hasUrl)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasHtml) {
            break label327;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, html);
          if (!hasWidth) {
            break label337;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(width);
          if (!hasHeight) {
            break label347;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(height);
          if (!hasPreviewImages) {
            break label380;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, previewImages.size());
          localIterator = previewImages.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label387;
          }
          MediaProxyImage localMediaProxyImage = (MediaProxyImage)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localMediaProxyImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label162;
            localByteBuffer.put((byte)0);
            break label186;
            localByteBuffer.put((byte)0);
            break label210;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Link
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */