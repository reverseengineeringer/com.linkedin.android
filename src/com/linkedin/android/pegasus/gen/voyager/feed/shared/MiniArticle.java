package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
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

public final class MiniArticle
  implements FissileDataModel<MiniArticle>, RecordTemplate<MiniArticle>
{
  public static final MiniArticleBuilder BUILDER = MiniArticleBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String ampUrl;
  public final Urn entityUrn;
  public final boolean hasAmpUrl;
  public final boolean hasEntityUrn;
  public final boolean hasImages;
  public final boolean hasObjectUrn;
  public final boolean hasTitle;
  public final boolean hasTrackingId;
  public final boolean hasUrl;
  public final List<Image> images;
  public final Urn objectUrn;
  public final String title;
  public final String trackingId;
  public final String url;
  
  MiniArticle(String paramString1, Urn paramUrn1, Urn paramUrn2, String paramString2, String paramString3, String paramString4, List<Image> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    trackingId = paramString1;
    objectUrn = paramUrn1;
    entityUrn = paramUrn2;
    title = paramString2;
    url = paramString3;
    ampUrl = paramString4;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      images = paramString1;
      hasTrackingId = paramBoolean1;
      hasObjectUrn = paramBoolean2;
      hasEntityUrn = paramBoolean3;
      hasTitle = paramBoolean4;
      hasUrl = paramBoolean5;
      hasAmpUrl = paramBoolean6;
      hasImages = paramBoolean7;
      paramString1 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
      return;
    }
  }
  
  public final MiniArticle accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    if (hasObjectUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("objectUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    if (hasAmpUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("ampUrl");
      paramDataProcessor.processString(ampUrl);
    }
    Object localObject = null;
    Image localImage = null;
    boolean bool = false;
    if (hasImages)
    {
      paramDataProcessor.startRecordField$505cff1c("images");
      images.size();
      paramDataProcessor.startArray$13462e();
      localObject = localImage;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = images.iterator();
      if (localIterator.hasNext())
      {
        localImage = (Image)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localImage = localImage.accept(paramDataProcessor);; localImage = (Image)paramDataProcessor.processDataTemplate(localImage))
        {
          if ((localObject != null) && (localImage != null)) {
            ((List)localObject).add(localImage);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label404;
      }
    }
    label404:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label537;
      }
      if (!hasImages) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (hasEntityUrn) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.MiniArticle", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.MiniArticle", "url");
    }
    if (images != null)
    {
      paramDataProcessor = images.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Image)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.shared.MiniArticle", "images");
        }
      }
    }
    return new MiniArticle(trackingId, objectUrn, entityUrn, title, url, ampUrl, (List)localObject, hasTrackingId, hasObjectUrn, hasEntityUrn, hasTitle, hasUrl, hasAmpUrl, bool);
    label537:
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
      paramObject = (MiniArticle)paramObject;
      if (objectUrn != null)
      {
        if (objectUrn.equals(objectUrn)) {}
      }
      else {
        while (objectUrn != null) {
          return false;
        }
      }
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
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
      if (ampUrl != null)
      {
        if (ampUrl.equals(ampUrl)) {}
      }
      else {
        while (ampUrl != null) {
          return false;
        }
      }
      if (images == null) {
        break;
      }
    } while (images.equals(images));
    for (;;)
    {
      return false;
      if (images == null) {
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
    Object localObject;
    if (hasObjectUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    j = i + 1;
    i = j;
    if (hasEntityUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
    }
    j = i + 1;
    i = j;
    if (hasAmpUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(ampUrl);
    }
    i += 1;
    j = i;
    if (hasImages)
    {
      i += 2;
      localObject = images.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        Image localImage = (Image)((Iterator)localObject).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localImage.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
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
    if (objectUrn != null)
    {
      i = objectUrn.hashCode();
      if (entityUrn == null) {
        break label156;
      }
      j = entityUrn.hashCode();
      if (title == null) {
        break label161;
      }
      k = title.hashCode();
      if (url == null) {
        break label166;
      }
      m = url.hashCode();
      label76:
      if (ampUrl == null) {
        break label172;
      }
    }
    label156:
    label161:
    label166:
    label172:
    for (int n = ampUrl.hashCode();; n = 0)
    {
      if (images != null) {
        i1 = images.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MiniArticle");
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
    label171:
    label205:
    label231:
    label257:
    label283:
    label400:
    label410:
    label420:
    label430:
    label440:
    label473:
    label480:
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
        localByteBuffer.putInt(453860938);
        Object localObject;
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasObjectUrn) {
            break label400;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          if (!hasEntityUrn) {
            break label410;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTitle) {
            break label420;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasUrl) {
            break label430;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasAmpUrl) {
            break label440;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, ampUrl);
          if (!hasImages) {
            break label473;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, images.size());
          localObject = images.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label480;
          }
          Image localImage = (Image)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label171;
            localByteBuffer.put((byte)0);
            break label205;
            localByteBuffer.put((byte)0);
            break label231;
            localByteBuffer.put((byte)0);
            break label257;
            localByteBuffer.put((byte)0);
            break label283;
          }
          localByteBuffer.put((byte)1);
          localImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.MiniArticle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */