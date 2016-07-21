package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class DiscussionWithImage
  implements FissileDataModel<DiscussionWithImage>, RecordTemplate<DiscussionWithImage>
{
  public static final DiscussionWithImageBuilder BUILDER = DiscussionWithImageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AnnotatedText body;
  public final String contentId;
  public final Image contentImage;
  public final String contentUrl;
  public final boolean hasBody;
  public final boolean hasContentId;
  public final boolean hasContentImage;
  public final boolean hasContentUrl;
  public final boolean hasTitle;
  public final String title;
  
  DiscussionWithImage(String paramString1, AnnotatedText paramAnnotatedText, String paramString2, String paramString3, Image paramImage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    title = paramString1;
    body = paramAnnotatedText;
    contentId = paramString2;
    contentUrl = paramString3;
    contentImage = paramImage;
    hasTitle = paramBoolean1;
    hasBody = paramBoolean2;
    hasContentId = paramBoolean3;
    hasContentUrl = paramBoolean4;
    hasContentImage = paramBoolean5;
    _cachedId = null;
  }
  
  public final DiscussionWithImage accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasBody)
    {
      paramDataProcessor.startRecordField$505cff1c("body");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = body.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label239;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label81:
      if (hasContentId)
      {
        paramDataProcessor.startRecordField$505cff1c("contentId");
        paramDataProcessor.processString(contentId);
      }
      if (hasContentUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("contentUrl");
        paramDataProcessor.processString(contentUrl);
      }
      localObject1 = null;
      bool2 = false;
      if (hasContentImage)
      {
        paramDataProcessor.startRecordField$505cff1c("contentImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label248;
        }
        localObject1 = contentImage.accept(paramDataProcessor);
        label170:
        if (localObject1 == null) {
          break label266;
        }
      }
    }
    label239:
    label248:
    label266:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label366;
      }
      try
      {
        if (hasTitle) {
          break label271;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(body);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(contentImage);
      break label170;
    }
    label271:
    if (!hasContentId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "contentId");
    }
    if (!hasContentUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "contentUrl");
    }
    if (!hasContentImage) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "contentImage");
    }
    return new DiscussionWithImage(title, (AnnotatedText)localObject2, contentId, contentUrl, (Image)localObject1, hasTitle, bool1, hasContentId, hasContentUrl, bool2);
    label366:
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
      paramObject = (DiscussionWithImage)paramObject;
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
      if (contentId != null)
      {
        if (contentId.equals(contentId)) {}
      }
      else {
        while (contentId != null) {
          return false;
        }
      }
      if (contentUrl != null)
      {
        if (contentUrl.equals(contentUrl)) {}
      }
      else {
        while (contentUrl != null) {
          return false;
        }
      }
      if (contentImage == null) {
        break;
      }
    } while (contentImage.equals(contentImage));
    for (;;)
    {
      return false;
      if (contentImage == null) {
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
    if (hasTitle) {
      i = PegasusBinaryUtils.getEncodedLength(title) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasBody)
    {
      i = j + 1;
      if (body._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(body._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasContentId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contentId);
      }
      j = i + 1;
      i = j;
      if (hasContentUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contentUrl);
      }
      j = i + 1;
      i = j;
      if (hasContentImage)
      {
        i = j + 1;
        if (contentImage._cachedId == null) {
          break label192;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(contentImage._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += body.getSerializedSize();
      break;
      label192:
      i += contentImage.getSerializedSize();
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
    if (title != null)
    {
      i = title.hashCode();
      if (body == null) {
        break label132;
      }
      j = body.hashCode();
      if (contentId == null) {
        break label137;
      }
      k = contentId.hashCode();
      label60:
      if (contentUrl == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = contentUrl.hashCode();; m = 0)
    {
      if (contentImage != null) {
        n = contentImage.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building DiscussionWithImage");
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
    label196:
    label222:
    label248:
    label351:
    label376:
    label386:
    label396:
    label406:
    label431:
    label439:
    label441:
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
        localByteBuffer.putInt(-1481923370);
        if (hasTitle)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasBody) {
            break label376;
          }
          localByteBuffer.put((byte)1);
          if (body._cachedId == null) {
            break label351;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, body._cachedId);
          body.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasContentId) {
            break label386;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contentId);
          if (!hasContentUrl) {
            break label396;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contentUrl);
          if (!hasContentImage) {
            break label431;
          }
          localByteBuffer.put((byte)1);
          if (contentImage._cachedId == null) {
            break label406;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, contentImage._cachedId);
          contentImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label439;
          }
          if (str != null) {
            break label441;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          body.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label196;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)0);
          break label222;
          localByteBuffer.put((byte)0);
          break label248;
          localByteBuffer.put((byte)1);
          contentImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<DiscussionWithImage>
  {
    public AnnotatedText body = null;
    public String contentId = null;
    public Image contentImage = null;
    public String contentUrl = null;
    public boolean hasBody = false;
    public boolean hasContentId = false;
    public boolean hasContentImage = false;
    public boolean hasContentUrl = false;
    public boolean hasTitle = false;
    public String title = null;
    
    public final DiscussionWithImage build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (DiscussionWithImage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new DiscussionWithImage(title, body, contentId, contentUrl, contentImage, hasTitle, hasBody, hasContentId, hasContentUrl, hasContentImage);
        if (!hasTitle) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "title");
        }
        if (!hasContentId) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "contentId");
        }
        if (!hasContentUrl) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "contentUrl");
        }
      } while (hasContentImage);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage", "contentImage");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */