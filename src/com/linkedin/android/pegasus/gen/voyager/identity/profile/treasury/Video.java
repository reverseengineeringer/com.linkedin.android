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

public final class Video
  implements FissileDataModel<Video>, RecordTemplate<Video>
{
  public static final VideoBuilder BUILDER = VideoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String duration;
  public final boolean hasDuration;
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
  
  Video(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, List<MediaProxyImage> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    html = paramString1;
    width = paramInt1;
    height = paramInt2;
    duration = paramString2;
    url = paramString3;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      previewImages = paramString1;
      hasHtml = paramBoolean1;
      hasWidth = paramBoolean2;
      hasHeight = paramBoolean3;
      hasDuration = paramBoolean4;
      hasUrl = paramBoolean5;
      hasPreviewImages = paramBoolean6;
      _cachedId = null;
      return;
    }
  }
  
  public final Video accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
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
    if (hasDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("duration");
      paramDataProcessor.processString(duration);
    }
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
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
        break label363;
      }
    }
    label363:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label507;
      }
      if (!hasPreviewImages) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (hasHtml) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video", "html");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasWidth) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video", "width");
    }
    if (!hasHeight) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video", "height");
    }
    if (previewImages != null)
    {
      paramDataProcessor = previewImages.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MediaProxyImage)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video", "previewImages");
        }
      }
    }
    return new Video(html, width, height, duration, url, (List)localObject, hasHtml, hasWidth, hasHeight, hasDuration, hasUrl, bool);
    label507:
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
      paramObject = (Video)paramObject;
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
      if (duration != null)
      {
        if (duration.equals(duration)) {}
      }
      else {
        while (duration != null) {
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
    if (hasHtml) {
      i = PegasusBinaryUtils.getEncodedLength(html) + 8;
    }
    int j = i + 1;
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
    if (hasDuration) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(duration);
    }
    j = i + 1;
    i = j;
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
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
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int n;
    int i1;
    int j;
    if (html != null)
    {
      i = html.hashCode();
      n = width;
      i1 = height;
      if (duration == null) {
        break label136;
      }
      j = duration.hashCode();
      label57:
      if (url == null) {
        break label141;
      }
    }
    label136:
    label141:
    for (int k = url.hashCode();; k = 0)
    {
      if (previewImages != null) {
        m = previewImages.hashCode();
      }
      i = (k + (j + (((i + 527) * 31 + n) * 31 + i1) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label57;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Video");
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
    label160:
    label184:
    label210:
    label236:
    label353:
    label363:
    label373:
    label383:
    label416:
    label423:
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
        localByteBuffer.putInt(1530302730);
        Iterator localIterator;
        if (hasHtml)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, html);
          if (!hasWidth) {
            break label353;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(width);
          if (!hasHeight) {
            break label363;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(height);
          if (!hasDuration) {
            break label373;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, duration);
          if (!hasUrl) {
            break label383;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasPreviewImages) {
            break label416;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, previewImages.size());
          localIterator = previewImages.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label423;
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
            break label160;
            localByteBuffer.put((byte)0);
            break label184;
            localByteBuffer.put((byte)0);
            break label210;
            localByteBuffer.put((byte)0);
            break label236;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */